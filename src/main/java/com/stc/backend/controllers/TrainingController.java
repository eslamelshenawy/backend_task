package com.stc.backend.controllers;

import com.stc.backend.dto.TrainingSummaryDTO;
import com.stc.backend.services.TrainingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller class for handling API requests related to training summaries.
 */
@RestController
@RequestMapping("/api/v1/trainings")
public class TrainingController {

    private static final Logger logger = LoggerFactory.getLogger(TrainingController.class); // Logger instance

    private final TrainingService trainingService;

    /**
     * Constructor for TrainingController.
     *
     * @param trainingService the service layer handling training-related operations
     */
    public TrainingController(TrainingService trainingService) {
        this.trainingService = trainingService;
    }

    /**
     * API endpoint to retrieve a summary of users who have attended the same training multiple times.
     *
     * @return a list of TrainingSummaryDTO containing the training details
     */
    @GetMapping("/summary")
    public List<TrainingSummaryDTO> getTrainingSummary() {
        logger.info("Received request to fetch training summaries."); // Log the request

        List<TrainingSummaryDTO> trainingSummary = trainingService.getUsersWithMultipleTrainings();

        logger.info("Fetched {} training summaries successfully.", trainingSummary.size()); // Log the response count
        return trainingSummary;
    }
}
