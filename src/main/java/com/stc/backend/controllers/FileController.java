package com.stc.backend.controllers;

import com.stc.backend.models.FileEntity;
import com.stc.backend.services.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

/**
 * Controller class for managing file operations such as retrieving metadata and downloading files.
 */
@RestController
@RequestMapping("/api/v1/files")
public class FileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class); // Logger instance

    @Autowired
    private FileService fileService;

    /**
     * API endpoint to retrieve metadata for a specific file.
     *
     * @param id the unique identifier of the file
     * @return an Optional containing the file metadata if found
     */
    @GetMapping("/{id}/metadata")
    public Optional<FileEntity> getFileMetadata(@PathVariable UUID id) {
        logger.info("Received request to fetch metadata for file with ID: {}", id); // Log the request

        Optional<FileEntity> fileMetadata = fileService.getFile(id);

        if (fileMetadata.isPresent()) {
            logger.info("Metadata retrieved successfully for file ID: {}", id); // Log success
        } else {
            logger.warn("No metadata found for file ID: {}", id); // Log warning if not found
        }

        return fileMetadata;
    }

    /**
     * API endpoint to download the binary content of a specific file.
     *
     * @param id the unique identifier of the file
     * @return the binary content of the file or null if the file is not found
     */
    @GetMapping("/{id}/download")
    public byte[] downloadFile(@PathVariable UUID id) {
        logger.info("Received request to download file with ID: {}", id); // Log the request

        byte[] fileBinary = fileService.getFile(id).map(FileEntity::getBinary).orElse(null);

        if (fileBinary != null) {
            logger.info("File with ID: {} downloaded successfully. Size: {} bytes", id, fileBinary.length); // Log success
        } else {
            logger.warn("File with ID: {} not found for download.", id); // Log warning if not found
        }

        return fileBinary;
    }
}
