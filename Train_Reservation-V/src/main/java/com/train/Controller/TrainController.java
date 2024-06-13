package com.train.Controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.train.Exception.TrainException;
import com.train.Service.TrainService;
import com.train.model.Train;

@RestController
@RequestMapping("/train")
public class TrainController {

	@Autowired
	private TrainService trainService;

	@PostMapping("/add")
	public Train saveTrain(@RequestBody Train train) {
		return trainService.saveTrain(train);
	}

	@PutMapping("/update")
	public Train updateTrain(@RequestBody Train train) {
		return trainService.updateTrain(train);
	}

	@GetMapping("/all")
	public List<Train> getAllTrains() throws TrainException {
		return trainService.getAllTrains();
	}

	@GetMapping("/{id}")
	public Optional<Train> getTrainById(@PathVariable Long id) throws TrainException {
		return trainService.getTrainById(id);
	}

	@GetMapping("/{source}/{destination}")
	public List<Train> getTrainsBySourceAndDestination(@PathVariable String source, @PathVariable String destination)
			throws TrainException {
		return trainService.getTrainsBySourceAndDestination(source, destination);
	}

	@GetMapping("/{source}/{destination}/{journeyDateTime}")
	public List<Train> getTrainsBySourceAndDestinationAndJourneyDateTime(@PathVariable String source,
			@PathVariable String destination, @PathVariable LocalDateTime journeyDateTime) throws TrainException {
		return trainService.getTrainsBySourceAndDestinationAndJourneyDateTime(source, destination, journeyDateTime);
	}

	@DeleteMapping("/{id}")
	public void deleteTrain(@PathVariable Long id) throws TrainException {
		trainService.deleteTrain(id);
	}
}
