package com.stc.backend.services;

import com.stc.backend.models.Permission;
import com.stc.backend.repositories.PermissionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for managing permissions.
 */
@Service
public class PermissionService {

    private static final Logger logger = LoggerFactory.getLogger(PermissionService.class); // Logger instance

    @Autowired
    private PermissionRepository permissionRepository;

    /**
     * Retrieves all permissions.
     *
     * @return a list of all permissions
     */
    public List<Permission> getAllPermissions() {
        logger.info("Fetching all permissions."); // Log the request

        List<Permission> permissions = permissionRepository.findAll();
        logger.info("Fetched {} permissions successfully.", permissions.size()); // Log the response count

        return permissions;
    }

    /**
     * Creates a new permission.
     *
     * @param permission the permission object to create
     * @return the created permission
     */
    public Permission createPermission(Permission permission) {
        logger.info("Creating a new permission: {}", permission); // Log the request

        Permission createdPermission = permissionRepository.save(permission);
        logger.info("Permission created successfully with ID: {}", createdPermission.getId()); // Log success

        return createdPermission;
    }

    /**
     * Retrieves a permission by its ID.
     *
     * @param id the ID of the permission to retrieve
     * @return the permission if found, or null otherwise
     */
    public Permission getPermissionById(Long id) {
        logger.info("Fetching permission with ID: {}", id); // Log the request

        Permission permission = permissionRepository.findById(id).orElse(null);

        if (permission != null) {
            logger.info("Permission fetched successfully: {}", permission); // Log success
        } else {
            logger.warn("Permission not found with ID: {}", id); // Log warning if not found
        }

        return permission;
    }

    /**
     * Deletes a permission by its ID.
     *
     * @param id the ID of the permission to delete
     */
    public void deletePermission(Long id) {
        logger.info("Deleting permission with ID: {}", id); // Log the request

        permissionRepository.deleteById(id);
        logger.info("Permission with ID: {} deleted successfully.", id); // Log success
    }
}
