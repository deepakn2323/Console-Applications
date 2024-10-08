package com.example.moviebooking.viewviewmodel.bookingscreen;

import com.example.moviebooking.datalayer.TheatreRepository;
import com.example.moviebooking.datalayer.UserRepository;
import com.example.moviebooking.dto.*;

import java.time.LocalDateTime;
import java.util.List;

class BookingScreenViewModel {
	private BookingScreen bookingScreen;

	public BookingScreenViewModel(BookingScreen screen) {
		bookingScreen = screen;
	}


	void confirmBooking(Show selectedShow, Screen screen, List<int[]> selectedSeats) {
		User currentUser = UserRepository.getInstance().getCurrentUser();
		Movie selectedMovie = TheatreRepository.getInstance().getMovies().get(selectedShow.getMovieId());
		LocalDateTime bookingDate = LocalDateTime.now();
		Booking booking = new Booking(currentUser, selectedMovie,selectedShow, screen, screen.getTheatreName(), bookingDate, selectedSeats.size(), selectedSeats);

		currentUser.getBookedTickets().add(booking);
		selectedShow.getBookedTickets().add(booking);
		bookingScreen.bookedSuccessfully(selectedShow.getShowTiming(),selectedSeats.size(),booking.getId(), selectedSeats );
	}

	Movie getMovieById(int movieId) {
		return TheatreRepository.getInstance().getMovies().get(movieId);
	}

	boolean validateSeatRowAndCol(int row, int col, List<List<Integer>> seat2D) {
		return row>=1&&col>=0&&row<=seat2D.size()&&col<=seat2D.get(0).size();
	}
}
