package com.stc.backend.controllers;

import com.stc.backend.models.PermissionGroup;
import com.stc.backend.services.PermissionGroupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for managing permission groups.
 */
@RestController
@RequestMapping("/api/permission-groups")
public class PermissionGroupController {

    private static final Logger logger = LoggerFactory.getLogger(PermissionGroupController.class); // Logger instance

    @Autowired
    private PermissionGroupService permissionGroupService;

    /**
     * API endpoint to retrieve all permission groups.
     *
     * @return a list of all permission groups
     */
    @GetMapping
    public ResponseEntity<List<PermissionGroup>> getAllPermissionGroups() {
        logger.info("Received request to fetch all permission groups."); // Log the request

        List<PermissionGroup> groups = permissionGroupService.getAllPermissionGroups();
        logger.info("Fetched {} permission groups successfully.", groups.size()); // Log the response count

        return ResponseEntity.ok(groups);
    }

    /**
     * API endpoint to create a new permission group.
     *
     * @param group the permission group object to create
     * @return the created permission group
     */
    @PostMapping
    public ResponseEntity<PermissionGroup> createPermissionGroup(@RequestBody PermissionGroup group) {
        logger.info("Received request to create a new permission group: {}", group); // Log the request

        PermissionGroup createdGroup = permissionGroupService.createPermissionGroup(group);
        logger.info("Created permission group successfully with ID: {}", createdGroup.getId()); // Log success

        return ResponseEntity.ok(createdGroup);
    }

    /**
     * API endpoint to retrieve a permission group by its ID.
     *
     * @param id the ID of the permission group to retrieve
     * @return the permission group object if found
     */
    @GetMapping("/{id}")
    public ResponseEntity<PermissionGroup> getPermissionGroupById(@PathVariable Long id) {
        logger.info("Received request to fetch permission group with ID: {}", id); // Log the request

        PermissionGroup group = permissionGroupService.getPermissionGroupById(id);
        logger.info("Fetched permission group successfully: {}", group); // Log success

        return ResponseEntity.ok(group);
    }

    /**
     * API endpoint to delete a permission group by its ID.
     *
     * @param id the ID of the permission group to delete
     * @return a response indicating the deletion was successful
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePermissionGroup(@PathVariable Long id) {
        logger.info("Received request to delete permission group with ID: {}", id); // Log the request

        permissionGroupService.deletePermissionGroup(id);
        logger.info("Deleted permission group with ID: {}", id); // Log success

        return ResponseEntity.noContent().build();
    }
}
