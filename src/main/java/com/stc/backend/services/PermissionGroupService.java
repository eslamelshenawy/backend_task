package com.stc.backend.services;

import com.stc.backend.models.PermissionGroup;
import com.stc.backend.repositories.PermissionGroupRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for managing permission groups.
 */
@Service
public class PermissionGroupService {

    private static final Logger logger = LoggerFactory.getLogger(PermissionGroupService.class); // Logger instance

    @Autowired
    private PermissionGroupRepository permissionGroupRepository;

    /**
     * Retrieves all permission groups.
     *
     * @return a list of all permission groups
     */
    public List<PermissionGroup> getAllPermissionGroups() {
        logger.info("Fetching all permission groups."); // Log the request

        List<PermissionGroup> groups = permissionGroupRepository.findAll();
        logger.info("Fetched {} permission groups successfully.", groups.size()); // Log the response count

        return groups;
    }

    /**
     * Creates a new permission group.
     *
     * @param group the permission group object to create
     * @return the created permission group
     */
    public PermissionGroup createPermissionGroup(PermissionGroup group) {
        logger.info("Creating a new permission group: {}", group); // Log the request

        PermissionGroup createdGroup = permissionGroupRepository.save(group);
        logger.info("Permission group created successfully with ID: {}", createdGroup.getId()); // Log success

        return createdGroup;
    }

    /**
     * Retrieves a permission group by its ID.
     *
     * @param id the ID of the permission group to retrieve
     * @return the permission group if found, or null otherwise
     */
    public PermissionGroup getPermissionGroupById(Long id) {
        logger.info("Fetching permission group with ID: {}", id); // Log the request

        PermissionGroup group = permissionGroupRepository.findById(id).orElse(null);

        if (group != null) {
            logger.info("Permission group fetched successfully: {}", group); // Log success
        } else {
            logger.warn("Permission group not found with ID: {}", id); // Log warning if not found
        }

        return group;
    }

    /**
     * Deletes a permission group by its ID.
     *
     * @param id the ID of the permission group to delete
     */
    public void deletePermissionGroup(Long id) {
        logger.info("Deleting permission group with ID: {}", id); // Log the request

        permissionGroupRepository.deleteById(id);
        logger.info("Permission group with ID: {} deleted successfully.", id); // Log success
    }
}
