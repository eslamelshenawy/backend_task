package com.stc.backend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;

@Entity
@Table(name = "items")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemEntity {
    @Id
    @GeneratedValue
    private UUID id;

    private String type;

    private String name;

    @Column(name = "parent_id")
    private UUID parentId;

    @Column(name = "permission_group_id")
    private UUID permissionGroupId;

}
