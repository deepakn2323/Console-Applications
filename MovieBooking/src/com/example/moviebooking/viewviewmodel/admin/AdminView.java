package com.example.moviebooking.viewviewmodel.admin;

import com.example.moviebooking.dto.Movie;
import com.example.moviebooking.dto.Screen;
import com.example.moviebooking.dto.Show;
import com.example.moviebooking.dto.Theatre;
import com.example.moviebooking.viewviewmodel.movielist.MovieListView;
import com.example.moviebooking.viewviewmodel.theatrelistscreen.TheatreListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminView{
    private Scanner scanner;
    private AdminViewModel adminViewModel;
    public AdminView() {
        this.scanner = new Scanner(System.in);
        adminViewModel = new AdminViewModel(this);
    }

    public void displayAdminMenu() {
        System.out.println("Login successful!\n");
        String adminChoice = "";
        while (!adminChoice.equals("0")) {
            System.out.println("1. Add Theatre ");
            System.out.println("2. Add show ");
            System.out.println("3. View Theatres ");
            System.out.println("4. View Movies ");
            System.out.println("0. Logout");
            adminChoice = scanner.nextLine();
            switch (adminChoice) {
                case "1":
                    addTheatre();
                    break;
                case "2":
                    addShows();
                    break;
                case "3":
                    TheatreListView theatreListView = new TheatreListView();
                    theatreListView.onCreate(-1);
                    break;
                case "4":
                    MovieListView movieListView = new MovieListView();
                    movieListView.onCreate();
                    break;
                case "0":
                    break;
                default:
                    System.out.println("Invalid choice!\n");
            }
        }
    }

    private void addTheatre() {
        System.out.print("Enter city name : ");
        String city = scanner.nextLine();
        while (!adminViewModel.validateCity(city)) {
            System.out.println("Invalid city! (city should be at least 2 characters long and alphabets only)");
            System.out.print("Enter city name : ");
            city = scanner.nextLine();
        }
        System.out.println("Enter Theatre Name ");
        String theatreName = scanner.nextLine();
        System.out.println("Enter Total Screens");
        String totalScreens = scanner.next();
        List<Screen> screenList = new ArrayList<>();
        for(int i=1; i<=Integer.parseInt(totalScreens); i++){
            System.out.println("Enter screen "+i+" details: ");
            System.out.println("Specify Number of seat rows ");
            int numberOfSeatRows = scanner.nextInt();
            System.out.println("Specify Number of seat cols ");
            int numberOfSeatCols = scanner.nextInt();
            Screen screen = new Screen(i, numberOfSeatRows, numberOfSeatCols, theatreName);
            screenList.add(screen);
        }
        if (adminViewModel.addTheatre(city, theatreName, totalScreens, screenList)) {

            System.out.println("Theatre added successfully!");
        } else {
            System.out.println("Theatre could not be added! City might already be present!");
        }
        System.out.println();
    }

    private void addShows() {
        boolean flag = true;
        while (flag) {
            System.out.println("Enter which city Theatre to add Show");
            List<String> cities = adminViewModel.getAllCities();
            System.out.println("Cities available : ");
            for (int i = 0; i < cities.size(); i++) {
                System.out.println((i + 1) + ". " + cities.get(i));
            }
            String cityChoice = scanner.nextLine();
            while (Integer.parseInt(cityChoice) < 1 || Integer.parseInt(cityChoice) > cities.size()) {
                System.out.println("Invalid choice! (choose a number from 1 to " + cities.size() + ")");
                System.out.print("Please select the correct city : ");
                cityChoice = scanner.nextLine();
            }
            String city = cities.get(Integer.parseInt(cityChoice) - 1);
            Theatre theatre = adminViewModel.getTheatreOfACity(city);
            System.out.println("Theatre Name : " + theatre.getName());
            System.out.println("Total Screens: " + theatre.getTotalScreens());
            System.out.println("Enter screen number to add show (1 to " + theatre.getTotalScreens() + "): ");
            String selectedScreen = scanner.nextLine();

            while (Integer.parseInt(selectedScreen) < 1 || Integer.parseInt(selectedScreen) > theatre.getTotalScreens()) {
                System.out.println("Invalid screen number! (choose a number from 1 to " + theatre.getTotalScreens() + ")");
                System.out.print("Please select the correct screen number: ");
                selectedScreen = scanner.nextLine();
            }

            System.out.println("Enter Movie to add");
            List<Movie> movieList = adminViewModel.getAllMovies();
            for (int i = 0; i < movieList.size(); i++) {
                System.out.println((i + 1) + ". " + movieList.get(i));
            }
            String selectedMovie = scanner.nextLine();
            while (Integer.parseInt(selectedMovie) < 1 || Integer.parseInt(selectedMovie) > movieList.size()) {
                System.out.println("Invalid choice! (choose a number from 1 to " + movieList.size() + ")");
                System.out.print("Please select the correct movie: ");
                selectedMovie = scanner.nextLine();
            }
            System.out.println("Enter show timing: ");
            String showTime = scanner.nextLine();
            System.out.println("Enter Ticket Fare: ");
            String ticketFare = scanner.nextLine();
            adminViewModel.createShow(theatre, Integer.parseInt(selectedScreen)-1, Integer.parseInt(selectedMovie) - 1, showTime, Double.parseDouble(ticketFare));
            System.out.println("Show added Successfully in " + theatre.getName() + " in screen number " + selectedScreen);
            System.out.println();
            System.out.println("Want to add more shows y/n");
            if (scanner.nextLine().equalsIgnoreCase("n")) flag = false; // Change the logic to continue or break
        }
    }

    public void onShowCreationFailure() {
        System.out.println("Already show running in the same time on the selected screen");
        System.out.println("...................Failed!...................................");
    }
    public void onShowCreationSuccessfull() {
        System.out.println("___________________________Show created successfully_______________");
    }
}