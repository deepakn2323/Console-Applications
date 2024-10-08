package com.example.moviebooking.viewviewmodel.theatrelistscreen;

import com.example.moviebooking.dto.Screen;
import com.example.moviebooking.dto.Show;
import com.example.moviebooking.dto.Theatre;
import com.example.moviebooking.viewviewmodel.BaseScreen;
import com.example.moviebooking.viewviewmodel.bookingscreen.BookingScreen;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TheatreListView extends BaseScreen {
	private TheatreListViewModel theatreListViewModel;
	private Scanner scanner;

	public TheatreListView() {
		theatreListViewModel = new TheatreListViewModel(this);
		this.scanner = new Scanner(System.in);
	}

	public void onCreate(int selectedMovieId){
		if(hasCheckNetworkConnection()){
			if(selectedMovieId==-1){
				displayAllTheatres();
			}
			else displayTheatres(selectedMovieId);
		}else{
			System.out.println("Check your Internet Connection...........");
		}
	}
	private void displayAllTheatres(){
		Map<String, Theatre> theatres = theatreListViewModel.getAllTheatres();
		if (theatres.isEmpty()) {
			System.out.println("No theatres available.");
		} else {
			System.out.println("Available Theatres:");
			for (Map.Entry<String, Theatre> entry : theatres.entrySet()) {
				String city = entry.getKey();
				Theatre theatre = entry.getValue();

				System.out.println("City: " + city + ", Theatre Name: " + theatre.getName());
			}
		}
	}
	private void displayTheatres(int selectedMovieId) {
		String selectedMovie = theatreListViewModel.getMovieName(selectedMovieId);
		List<Theatre> theatres = theatreListViewModel.getTheatresRunningShow(selectedMovieId);
		if (theatres.isEmpty()) {
			System.out.println("No theatres are running the selected movie.");
			return;
		} else {
			int theatreIndex = 1;
			for (Theatre theatre : theatres) {
				System.out.println(theatreIndex+". Theatre: " + theatre.getName() + " in " + theatre.getCity());
				theatreIndex++;
			}
		}
		System.out.println("Enter theatre to view availables screens to watch your movie: "+selectedMovie);
		String selectedTheatreId = scanner.nextLine();
		while(!theatreListViewModel.validateSelectedTheatreId(selectedTheatreId,theatres)){
			System.out.println("Enter valid theatre ");
			selectedTheatreId = scanner.nextLine();
		}
		Theatre selectedTheatre = theatres.get(Integer.parseInt(selectedTheatreId)-1);
		displayTheatreScreensRunningTheSelectedMovie(selectedTheatre, selectedMovieId);
	}

	private void displayTheatreScreensRunningTheSelectedMovie(Theatre selectedTheatre, int selectedMovieId) {
		List<Screen> screensRunningSelectedMovie = theatreListViewModel.getScreensRunningSelectedMovie(selectedTheatre, selectedMovieId);

		if (screensRunningSelectedMovie != null && !screensRunningSelectedMovie.isEmpty()) {
			System.out.println("Available shows in your selected Theatre: " + selectedTheatre.getName());

			int showIndex = 1;
			for (Screen screen : screensRunningSelectedMovie) {
				System.out.println("-------------------------------Screen---------------------------------");
				System.out.println("Screen: " + screen.getName() + " with capacity: " + screen.getCapacity());
				List<Show> shows = screen.getShows();
				System.out.println("-------------------------------shows---------------------------------");
				for (Show show : shows) {
					if (show.getMovieId() == selectedMovieId) {
						System.out.println(showIndex + ". Show Timing: " + show.getShowTiming() + ", Ticket Fare: " + show.getTicketFare());
						showIndex++;
						System.out.println("---------------------------------------------------------------------");
					}
				}
			}
			System.out.println("Enter the show number to book tickets:");
			String selectedShowIndex = scanner.nextLine();
			int showNumber = Integer.parseInt(selectedShowIndex) - 1;
			if(showNumber<0 || showNumber>showIndex){
				System.out.println("Invalid show\n");
				return;
			}
			Show selectedShow = theatreListViewModel.getSelectedShow(screensRunningSelectedMovie, showNumber, selectedMovieId);
			Screen selectedScreen = theatreListViewModel.getSelectedScreen(screensRunningSelectedMovie, showNumber, selectedMovieId);
			System.out.println("Screen - "+selectedScreen+" selectedshow "+selectedShow);
			BookingScreen bookingScreen = new BookingScreen();
			bookingScreen.proceedToBooking(selectedShow, selectedScreen);
		} else {
			System.out.println("No screens are showing the selected movie in this theatre.");
		}
	}


}
