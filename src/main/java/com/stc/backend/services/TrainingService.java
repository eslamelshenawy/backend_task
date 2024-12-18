package com.stc.backend.services;

import com.stc.backend.dto.TrainingSummaryDTO;
import com.stc.backend.repositories.TrainingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for managing training-related operations.
 */
@Service
public class TrainingService {

    private static final Logger logger = LoggerFactory.getLogger(TrainingService.class); // Logger instance

    private final TrainingRepository trainingRepository;

    /**
     * Constructor for TrainingService.
     *
     * @param trainingRepository the repository for training data operations
     */
    public TrainingService(TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }

    /**
     * Retrieves a summary of users who have attended the same training multiple times.
     *
     * @return a list of TrainingSummaryDTO containing user training details
     */
    public List<TrainingSummaryDTO> getUsersWithMultipleTrainings() {
        logger.info("Fetching users with multiple training sessions."); // Log the request

        List<TrainingSummaryDTO> trainingSummaries = trainingRepository.findUsersWithMultipleTrainings();

        logger.info("Fetched {} user training summaries successfully.", trainingSummaries.size()); // Log the response count
        return trainingSummaries;
    }
}
