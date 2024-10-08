package com.example.moviebooking.viewviewmodel.movielist;

import com.example.moviebooking.dto.Movie;
import com.example.moviebooking.viewviewmodel.BaseScreen;
import com.example.moviebooking.viewviewmodel.theatrelistscreen.TheatreListView;

import java.util.List;
import java.util.Scanner;

public class MovieListView extends BaseScreen {
    private MovieListViewModel movieListViewModel;
    private Scanner scanner;

    public MovieListView() {
        movieListViewModel = new MovieListViewModel(this);
        this.scanner = new Scanner(System.in);
    }

    public void onCreate() {
        if (hasCheckNetworkConnection()) {
            displayMovies();
        } else {
            System.out.println("Check your Internet Connection...........");
        }
    }

    private void displayMovies() {
        List<Movie> movieList = movieListViewModel.getAllMovies();
        for (int i = 0; i < movieList.size(); i++) {
            System.out.println((i + 1) + ". " + movieList.get(i));
        }
        System.out.println("Select movie to watch ");
        String selectedMovie = scanner.nextLine();
        while (Integer.parseInt(selectedMovie) < 1 || Integer.parseInt(selectedMovie) > movieList.size()) {
            System.out.println("Invalid choice! (choose a number from 1 to " + movieList.size() + ")");
            System.out.print("Please select the correct movie : ");
            selectedMovie = scanner.nextLine();
        }
        TheatreListView theatreListView = new TheatreListView();
        theatreListView.onCreate(Integer.parseInt(selectedMovie) - 1);
    }
}
