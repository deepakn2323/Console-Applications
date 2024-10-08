package com.example.moviebooking.viewviewmodel.users;

import com.example.moviebooking.dto.Screen;
import com.example.moviebooking.viewviewmodel.bookedtickets.BookedTicketScreen;
import com.example.moviebooking.viewviewmodel.cancelbooking.CancelBookingView;
import com.example.moviebooking.viewviewmodel.movielist.MovieListView;
import com.example.moviebooking.viewviewmodel.theatrelistscreen.TheatreListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserView{
    private UserViewModel userViewModel;
    private Scanner scanner;
    public UserView(){
        this.userViewModel = new UserViewModel(this);
        this.scanner = new Scanner(System.in);
    }

    public void displayUserMenu() {
        System.out.println("Login successful!\n");
        String userChoice = "";
        while (!userChoice.equals("0")) {
            System.out.println("1. View Movies");
            System.out.println("2. View Booked Tickets");
            System.out.println("3. Cancel Ticket");
            System.out.println("0. Logout");
            userChoice = scanner.nextLine();
            switch (userChoice) {
                case "1":
                    MovieListView movieListView = new MovieListView();
                    movieListView.onCreate();
                    break;
                case "2":
                    BookedTicketScreen bookedTicketScreen = new BookedTicketScreen();
                    bookedTicketScreen.onCreate();
                    break;
                case "3":
                    CancelBookingView cancelBookingView = new CancelBookingView();
                    cancelBookingView.onCreate();
                    break;
                case "0":
                    break;
                default:
                    System.out.println("Invalid choice!\n");
            }
        }
    }
}