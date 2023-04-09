package com.shivam.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shivam.bindings.PassangerInfo;
import com.shivam.bindings.TicketInfo;

@RestController
public class TicketRestController {

	@PostMapping(value = "/ticket", produces = { "application/json" }, consumes = { "application/json" })
	public ResponseEntity<TicketInfo> bookTicket(@RequestBody PassangerInfo request) {
		System.out.println(request);

		// logic to book ticket
		TicketInfo tinfo = new TicketInfo();
		tinfo.setTicketId(1234);
		tinfo.setPnr("JLJL6868");
		tinfo.setTicketStatus("CONFIRMED");

		return new ResponseEntity<TicketInfo>(tinfo, HttpStatus.CREATED);
	}

	@PutMapping("/ticket")
	public ResponseEntity<String> updateTicket(@RequestBody PassangerInfo request) {
		System.out.println(request); // logic to update ticket
		return new ResponseEntity<>("Ticket Updated", HttpStatus.OK);
	}

	@DeleteMapping("/ticket/{ticketId}")
	public ResponseEntity<String> deleteTicket(@PathVariable("ticketId") Integer ticketId) { // logic to delete the
																								// ticket
		return new ResponseEntity<>("Ticket Deleted", HttpStatus.OK);

	}

}
