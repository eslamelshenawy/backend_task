package com.stc.backend.controllers;

import com.stc.backend.utils.ReverseParentheses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Controller class for handling API requests to reverse substrings within parentheses.
 */
@RestController
@RequestMapping("/api/v1/reverse")
public class ReverseController {

    private static final Logger logger = LoggerFactory.getLogger(ReverseController.class); // Logger instance

    /**
     * API endpoint to reverse substrings in a file content between parentheses.
     *
     * @param filePath the path to the file containing the input string
     * @return the processed string with reversed substrings
     * @throws IOException if there is an error reading the file
     */
    @PostMapping
    public String reverseParenthesesFromFile(@RequestParam String filePath) throws IOException {
        logger.info("Received request to process file at path: {}", filePath); // Log the request

        // Read the content of the file
        String input = new String(Files.readAllBytes(Paths.get(filePath)));
        logger.debug("File content read successfully: {}", input); // Log the file content (debug level)

        // Process the input using ReverseParentheses utility
        String result = ReverseParentheses.process(input);
        logger.info("Processed file content successfully."); // Log success message

        return result;
    }
}
