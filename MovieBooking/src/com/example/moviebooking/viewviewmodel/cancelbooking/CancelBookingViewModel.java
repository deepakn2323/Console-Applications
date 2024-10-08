package com.example.moviebooking.viewviewmodel.cancelbooking;

import com.example.moviebooking.datalayer.TheatreRepository;
import com.example.moviebooking.datalayer.UserRepository;
import com.example.moviebooking.dto.Booking;
import com.example.moviebooking.dto.Screen;
import com.example.moviebooking.dto.Show;

import java.util.List;

public class CancelBookingViewModel {
    private CancelBookingView cancelBookingView;

    CancelBookingViewModel(CancelBookingView cancelBookingView) {
        this.cancelBookingView = cancelBookingView;
    }

    void cancelBookingById(String bookingId) {
        List<Booking> bookingsDoneByUser = UserRepository.getInstance().getCurrentUser().getBookedTickets();
        Booking matchedBooking = null;
        for (Booking booking : bookingsDoneByUser) {
            if (booking.getId().equals(bookingId)) {
                matchedBooking = booking;
                break;
            }
        }
        if (matchedBooking != null) {
            cancelBookingTicket(matchedBooking);
        } else {
            cancelBookingView.onFailure(bookingId);
        }
    }

    private void cancelBookingTicket(Booking matchedBooking) {
        UserRepository.getInstance().getCurrentUser().getBookedTickets().remove(matchedBooking);
        unbookSeats(matchedBooking, matchedBooking.getSeatNumbers());
        cancelBookingView.cancelledSuccessfully(matchedBooking.getId());

    }

    private void unbookSeats(Booking matchedBooking, List<int[]> seatNumbers) {
        Show show = matchedBooking.getShow();
        show.getBookedTickets().remove(matchedBooking);
        List<List<Integer>> seats = show.getSeat2D();

        for (int[] seat : seatNumbers) {
            int row = seat[0];
            int col = seat[1];
            seats.get(row).set(col, 0);
        }
    }

}
