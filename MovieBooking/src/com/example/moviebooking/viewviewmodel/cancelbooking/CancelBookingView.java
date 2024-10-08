package com.example.moviebooking.viewviewmodel.cancelbooking;

import com.example.moviebooking.viewviewmodel.BaseScreen;

import java.util.Scanner;

public class CancelBookingView extends BaseScreen {
    private Scanner scanner;
    private CancelBookingViewModel cancelBookingViewModel;

    public CancelBookingView() {
        this.scanner = new Scanner(System.in);
        this.cancelBookingViewModel = new CancelBookingViewModel(this);
    }

    public void onCreate() {
        if (hasCheckNetworkConnection()) {
            cancelTicket();
        } else {
            System.out.println("Check your Internet Connection...........");
        }
    }

    private void cancelTicket() {
        System.out.println("Enter ticket id to cancel the booking :");
        String bookingId = scanner.nextLine();
        cancelBookingViewModel.cancelBookingById(bookingId);
    }

    void cancelledSuccessfully(String bookingId) {
        System.out.println("Your booking" + bookingId + "is cancellded successfully");
    }

    void onFailure(String bookingId) {
        System.out.println("Your booking" + bookingId + "is cancellded successfully");
    }
}
