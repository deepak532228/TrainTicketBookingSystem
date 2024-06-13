package com.train.Repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.train.model.Train;

@Repository
public interface TrainRepository extends JpaRepository<Train, Long> {

	List<Train> findBySourceAndDestination(String source, String destination);

	List<Train> findBySourceAndDestinationAndJourneyDateTime(String source, String destination,
			LocalDateTime journeyDateTime);

	void save(List<Train> train);

}
