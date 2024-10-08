package com.example.moviebooking.viewviewmodel.bookedtickets;

import com.example.moviebooking.datalayer.UserRepository;
import com.example.moviebooking.dto.Booking;
import com.example.moviebooking.dto.User;
import com.example.moviebooking.viewviewmodel.BaseScreen;

import java.util.List;

public class BookedTicketScreen extends BaseScreen {

	private BookedTicketViewModel bookedTicketViewModel;
	public BookedTicketScreen() {
		this.bookedTicketViewModel = new BookedTicketViewModel(this);
	}

	public void onCreate(){
		if(hasCheckNetworkConnection()){
			displayBookedTickets();
		}else{
			System.out.println("Check your Internet Connection...........");
		}
	}

	private void displayBookedTickets() {
		User user = UserRepository.getInstance().getCurrentUser();
		if(user!=null){
			List<Booking> bookedListOfUser = bookedTicketViewModel.getBookedListOfUser();
			for(Booking bookedTicket : bookedListOfUser){
				System.out.println("Booking ID: " + bookedTicket.getId());
				System.out.println("Movie: " + bookedTicket.getMovie().getMovieName());
				System.out.println("Show Time: " + bookedTicket.getShowTiming());
				System.out.println("Screen Name: " + bookedTicket.getScreenName());
				System.out.println("Theatre Name: " + bookedTicket.getTheatreName());
				System.out.println("Number of Tickets: " + bookedTicket.getNumberOfTickets());
				System.out.println("Booked by: " + bookedTicket.getUser().getName());
				System.out.println("Booking Date: " + bookedTicket.getBookingDate());

			}
			System.out.println("-----------------------------------------------------------------------------------------------------------");
		}
		else{
			System.out.println("use is null");
		}
	}
}
