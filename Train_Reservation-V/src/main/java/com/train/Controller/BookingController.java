package com.train.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.train.Repository.PassengerRepository;
import com.train.Service.BookingService;
import com.train.model.Booking;
import com.train.model.Passenger;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/bookings")
@RequiredArgsConstructor
public class BookingController {

	@Autowired
	private BookingService bookingService;

	@PostMapping("/{trainId}/{userId}")
	public ResponseEntity<Booking> createBooking(@PathVariable Long trainId, @PathVariable Long userId,
			@RequestBody List<Passenger> passengers) throws NotFoundException {
		// Create the booking
		Booking booking = bookingService.createBooking(trainId, userId, passengers);

		// Return the created booking
		return ResponseEntity.ok(booking);
	}

	@GetMapping
	public List<Booking> getAllBookings() {
		return bookingService.getAllBookings();
	}

	@GetMapping("/{bookingId}")
	public ResponseEntity<Booking> retrieveBookingById(@PathVariable Long bookingId) {
		// Retrieve the booking by ID
		Booking booking = bookingService.retrieveBookingById(bookingId);

		// Return the booking
		return ResponseEntity.ok(booking);
	}

	@GetMapping("/getByUserId/{userId}")
	public ResponseEntity<List<Booking>> retrieveBookingByUserId(@PathVariable Long userId) {
		// Retrieve the booking by ID
		List<Booking> booking = bookingService.retrieveBookingUserById(userId);

		// Return the booking
		return ResponseEntity.ok(booking);
	}

	@GetMapping("/{bookingId}/passengers")
	public ResponseEntity<List<Passenger>> findPassengersByBookingId(@PathVariable Long bookingId)
			throws NotFoundException {
		// Find the passengers by booking ID
		List<Passenger> passengers = bookingService.findPassengersByBookingId(bookingId);

		// Return the passengers
		return ResponseEntity.ok(passengers);
	}

	@DeleteMapping("/{bookingId}")
	public void deleteBookingById(@PathVariable Long bookingId) {

		bookingService.deleteBookingById(bookingId);
	}

	@DeleteMapping("/all")
	public void deleteAllBookings() {
		bookingService.deleteAllBookings();
	}
}