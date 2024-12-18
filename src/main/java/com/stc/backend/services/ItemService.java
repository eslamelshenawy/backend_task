package com.stc.backend.services;

import com.stc.backend.models.ItemEntity;
import com.stc.backend.repositories.ItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Service class for managing items such as spaces, folders, and files.
 */
@Service
public class ItemService {

    private static final Logger logger = LoggerFactory.getLogger(ItemService.class); // Logger instance

    @Autowired
    private ItemRepository itemRepository;

    /**
     * Creates a new space item.
     *
     * @param name the name of the space to create
     * @return the created space entity
     */
    public ItemEntity createSpace(String name) {
        logger.info("Creating a new space with name: {}", name); // Log the request

        ItemEntity space = new ItemEntity();
        space.setType("Space");
        space.setName(name);

        ItemEntity createdSpace = itemRepository.save(space);
        logger.info("Space created successfully with ID: {}", createdSpace.getId()); // Log success

        return createdSpace;
    }

    /**
     * Creates a new folder item under a specific parent.
     *
     * @param name     the name of the folder to create
     * @param parentId the ID of the parent item
     * @return the created folder entity
     */
    public ItemEntity createFolder(String name, UUID parentId) {
        logger.info("Creating a new folder with name: {} under parent ID: {}", name, parentId); // Log the request

        ItemEntity folder = new ItemEntity();
        folder.setType("Folder");
        folder.setName(name);
        folder.setParentId(parentId);

        ItemEntity createdFolder = itemRepository.save(folder);
        logger.info("Folder created successfully with ID: {}", createdFolder.getId()); // Log success

        return createdFolder;
    }

    /**
     * Creates a new file item under a specific parent.
     *
     * @param name     the name of the file to create
     * @param parentId the ID of the parent item
     * @return the created file entity
     */
    public ItemEntity createFile(String name, UUID parentId) {
        logger.info("Creating a new file with name: {} under parent ID: {}", name, parentId); // Log the request

        ItemEntity file = new ItemEntity();
        file.setType("File");
        file.setName(name);
        file.setParentId(parentId);

        ItemEntity createdFile = itemRepository.save(file);
        logger.info("File created successfully with ID: {}", createdFile.getId()); // Log success

        return createdFile;
    }
}
