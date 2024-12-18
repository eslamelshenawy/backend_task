package com.stc.backend.controllers;

import com.stc.backend.models.ItemEntity;
import com.stc.backend.services.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Controller class for managing items such as spaces, folders, and files.
 */
@RestController
@RequestMapping("/api/items")
public class ItemController {

    private static final Logger logger = LoggerFactory.getLogger(ItemController.class); // Logger instance

    @Autowired
    private ItemService itemService;

    /**
     * API endpoint to create a new space.
     *
     * @param name the name of the space to create
     * @return the created space entity
     */
    @PostMapping("/spaces")
    public ItemEntity createSpace(@RequestParam String name) {
        logger.info("Received request to create a space with name: {}", name); // Log the request

        ItemEntity space = itemService.createSpace(name);
        logger.info("Space created successfully with ID: {}", space.getId()); // Log success

        return space;
    }

    /**
     * API endpoint to create a new folder under a specific parent item.
     *
     * @param name the name of the folder to create
     * @param parentId the ID of the parent item
     * @return the created folder entity
     */
    @PostMapping("/folders")
    public ItemEntity createFolder(@RequestParam String name, @RequestParam UUID parentId) {
        logger.info("Received request to create a folder with name: {} under parent ID: {}", name, parentId); // Log the request

        ItemEntity folder = itemService.createFolder(name, parentId);
        logger.info("Folder created successfully with ID: {}", folder.getId()); // Log success

        return folder;
    }

    /**
     * API endpoint to create a new file under a specific parent item.
     *
     * @param name the name of the file to create
     * @param parentId the ID of the parent item
     * @return the created file entity
     */
    @PostMapping("/files")
    public ItemEntity createFile(@RequestParam String name, @RequestParam UUID parentId) {
        logger.info("Received request to create a file with name: {} under parent ID: {}", name, parentId); // Log the request

        ItemEntity file = itemService.createFile(name, parentId);
        logger.info("File created successfully with ID: {}", file.getId()); // Log success

        return file;
    }
}
