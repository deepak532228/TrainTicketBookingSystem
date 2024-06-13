package com.train.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.train.Service.TicketService;
import com.train.model.Booking;
import com.train.model.Ticket;

@RestController
@RequestMapping("/ticket")
public class TicketController {

	@Autowired
	private TicketService ticketService;

	@PostMapping("/{bookingId}")
	public Ticket createTicket(@PathVariable Long bookingId) {

		Ticket ticket = ticketService.createTicket(bookingId);
		return ticket;

	}

	@GetMapping("/all")
	public List<Ticket> getAllTickets() {
		return ticketService.getAllTickets();
	}

	@GetMapping("/getByUserAndBookingId/{userId}/{bookingId}")
	public ResponseEntity<List<Booking>> retrieveBookingByUserId(@PathVariable Long userId,
			@PathVariable Long bookingId) {
		// Retrieve the booking by ID
		List<Booking> booking = ticketService.findByUserIdAndBookingId(userId, bookingId);

		// Return the booking
		return ResponseEntity.ok(booking);
	}

	@DeleteMapping("/{bookingId}/delete")
	public ResponseEntity<Void> deleteTicketByBookingId(@PathVariable Long bookingId) {
		ticketService.deleteTicketByBookingId(bookingId);
		return ResponseEntity.ok().build();
	}

}