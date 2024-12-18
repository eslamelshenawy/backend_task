package com.stc.backend.controllers;

import com.stc.backend.models.Permission;
import com.stc.backend.services.PermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for managing permissions.
 */
@RestController
@RequestMapping("/api/permissions")
public class PermissionController {

    private static final Logger logger = LoggerFactory.getLogger(PermissionController.class); // Logger instance

    @Autowired
    private PermissionService permissionService;

    /**
     * API endpoint to retrieve all permissions.
     *
     * @return a list of all permissions
     */
    @GetMapping
    public ResponseEntity<List<Permission>> getAllPermissions() {
        logger.info("Received request to fetch all permissions."); // Log the request

        List<Permission> permissions = permissionService.getAllPermissions();
        logger.info("Fetched {} permissions successfully.", permissions.size()); // Log the response count

        return ResponseEntity.ok(permissions);
    }

    /**
     * API endpoint to create a new permission.
     *
     * @param permission the permission object to create
     * @return the created permission
     */
    @PostMapping
    public ResponseEntity<Permission> createPermission(@RequestBody Permission permission) {
        logger.info("Received request to create a new permission: {}", permission); // Log the request

        Permission createdPermission = permissionService.createPermission(permission);
        logger.info("Created permission successfully with ID: {}", createdPermission.getId()); // Log success

        return ResponseEntity.ok(createdPermission);
    }

    /**
     * API endpoint to retrieve a permission by its ID.
     *
     * @param id the ID of the permission to retrieve
     * @return the permission object if found
     */
    @GetMapping("/{id}")
    public ResponseEntity<Permission> getPermissionById(@PathVariable Long id) {
        logger.info("Received request to fetch permission with ID: {}", id); // Log the request

        Permission permission = permissionService.getPermissionById(id);
        logger.info("Fetched permission successfully: {}", permission); // Log success

        return ResponseEntity.ok(permission);
    }

    /**
     * API endpoint to delete a permission by its ID.
     *
     * @param id the ID of the permission to delete
     * @return a response indicating the deletion was successful
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePermission(@PathVariable Long id) {
        logger.info("Received request to delete permission with ID: {}", id); // Log the request

        permissionService.deletePermission(id);
        logger.info("Deleted permission with ID: {}", id); // Log success

        return ResponseEntity.noContent().build();
    }
}
