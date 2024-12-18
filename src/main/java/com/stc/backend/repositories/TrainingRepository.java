package com.stc.backend.repositories;

import com.stc.backend.dto.TrainingSummaryDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainingRepository extends CrudRepository<TrainingDetailsEntity, Integer> {

    @Query(value = """
            SELECT 
                u.user_id AS userId, 
                u.username AS username, 
                t.training_id AS trainingId, 
                t.training_date AS trainingDate, 
                COUNT(*) AS count
            FROM 
                UserTable u
            JOIN 
                TrainingDetails t
            ON 
                u.user_id = t.user_id
            GROUP BY 
                u.user_id, u.username, t.training_id, t.training_date
            HAVING 
                COUNT(*) > 1
            ORDER BY 
                t.training_date DESC
            """, nativeQuery = true)
    List<TrainingSummaryDTO> findUsersWithMultipleTrainings();
}
