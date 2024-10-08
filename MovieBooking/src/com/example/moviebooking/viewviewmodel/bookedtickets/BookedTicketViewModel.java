package com.example.moviebooking.viewviewmodel.bookedtickets;

import com.example.moviebooking.datalayer.UserRepository;
import com.example.moviebooking.dto.Booking;

import java.util.List;

class BookedTicketViewModel {
	private BookedTicketScreen bookedTicketScreen;

	public BookedTicketViewModel(BookedTicketScreen bookedTicketScreen) {
		this.bookedTicketScreen = bookedTicketScreen;
	}

	List<Booking> getBookedListOfUser() {
		List<Booking> bookings = UserRepository.getInstance().getCurrentUser().getBookedTickets();
		return bookings;
	}
}
