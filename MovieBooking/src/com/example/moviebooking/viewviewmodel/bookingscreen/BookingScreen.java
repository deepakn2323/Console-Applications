package com.example.moviebooking.viewviewmodel.bookingscreen;

import com.example.moviebooking.datalayer.TheatreRepository;
import com.example.moviebooking.datalayer.UserRepository;
import com.example.moviebooking.dto.*;
import com.example.moviebooking.viewviewmodel.BaseScreen;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookingScreen extends BaseScreen {
	private BookingScreenViewModel bookingScreenViewModel;
	private Scanner scanner;

	public BookingScreen() {
		bookingScreenViewModel = new BookingScreenViewModel(this);
		this.scanner = new Scanner(System.in);
	}


	public void proceedToBooking(Show selectedShow, Screen selectedScreen) {
        List<List<Integer>> seat2D = selectedShow.getSeat2D();

		System.out.println("Available Seats 0: Available, 1: Booked:");
		displaySeatLayout(seat2D);

		System.out.println("Enter the number of seats to book:");
		int seatsToBook = scanner.nextInt();
		scanner.nextLine();

		List<int[]> selectedSeats = getSeatSelectionFromUser(seatsToBook, seat2D);

		bookingScreenViewModel.confirmBooking(selectedShow, selectedScreen, selectedSeats);
	}

	private List<int[]> getSeatSelectionFromUser(int seatsToBook, List<List<Integer>> seat2D) {
		List<int[]> selectedSeats = new ArrayList<>();
		for (int i = 0; i < seatsToBook; i++) {
			System.out.println("\nEnter seat row and column (e.g., 2 3 for row 2, column 3):");
			int row = scanner.nextInt();
			int col = scanner.nextInt();
			while(!bookingScreenViewModel.validateSeatRowAndCol(row, col, seat2D)){
				System.out.println("\nEnter valid row and col");
				 row = scanner.nextInt();
				 col = scanner.nextInt();
			}

			if (seat2D.get(row - 1).get(col - 1) == 0) {
				seat2D.get(row - 1).set(col - 1, 1);
				selectedSeats.add(new int[]{row - 1, col - 1});
			} else {
				System.out.println("Seat already booked, select another seat.");
				i--;
			}
		}
		return selectedSeats;
	}


	private void displaySeatLayout(List<List<Integer>> seat2D) {
		System.out.println("-------------------------------seats---------------------------------");
		for (int i = 0; i < seat2D.size(); i++) {
			for (int j = 0; j < seat2D.get(i).size(); j++) {
				System.out.print(seat2D.get(i).get(j) + " ");
			}
			System.out.println();
		}
		System.out.println("-------------------------------seats---------------------------------");
	}


	public void bookedSuccessfully(String showTime, int seatsBooked, String bookingId, List<int[]> selectedSeats) {
		System.out.println("\n------------------------Booked Successfully--------------------------");
		System.out.println("Booking confirmed for show: "+showTime);
		System.out.println("Number of seats booked: " + seatsBooked);

		System.out.println("Booking ID: " + bookingId);
		System.out.println("Seats Booked: ");
		for (int[] seat : selectedSeats) {
			System.out.println("Row: " + (seat[0] + 1) + ", Column: " + (seat[1] + 1));
		}
		System.out.println("\n---------------------------------------------------------------------\n");
	}
}
