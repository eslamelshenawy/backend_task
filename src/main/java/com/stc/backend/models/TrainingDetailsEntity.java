package com.stc.backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TrainingDetails")
public class TrainingDetailsEntity {

    @Id
    private Integer userTrainingId;

    private Integer userId;

    private Integer trainingId;

    private Date trainingDate;
}
