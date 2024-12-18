package com.stc.backend.services;

import com.stc.backend.models.FileEntity;
import com.stc.backend.repositories.FileRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

/**
 * Service class for managing file operations such as saving and retrieving files.
 */
@Service
public class FileService {

    private static final Logger logger = LoggerFactory.getLogger(FileService.class); // Logger instance

    @Autowired
    private FileRepository fileRepository;

    /**
     * Saves a file entity with its binary content.
     *
     * @param itemId the ID of the related item (e.g., folder or parent space)
     * @param binary the binary content of the file
     * @return the saved file entity
     */
    public FileEntity saveFile(UUID itemId, byte[] binary) {
        logger.info("Saving file for item ID: {}", itemId); // Log the request

        FileEntity file = new FileEntity();
        file.setItemId(itemId);
        file.setBinary(binary);

        FileEntity savedFile = fileRepository.save(file);
        logger.info("File saved successfully with ID: {}", savedFile.getId()); // Log success

        return savedFile;
    }

    /**
     * Retrieves a file entity by its ID.
     *
     * @param fileId the ID of the file to retrieve
     * @return an Optional containing the file entity if found
     */
    public Optional<FileEntity> getFile(UUID fileId) {
        logger.info("Fetching file with ID: {}", fileId); // Log the request

        Optional<FileEntity> file = fileRepository.findById(fileId);

        if (file.isPresent()) {
            logger.info("File found with ID: {}", fileId); // Log success
        } else {
            logger.warn("File not found with ID: {}", fileId); // Log warning if not found
        }

        return file;
    }
}
