package com.example.moviebooking.dto;

import java.util.ArrayList;
import java.util.List;

public class Show {
    private int idIncrement;
    private int showId;
    private int screenId;
    private String showTiming;
    private int movieId;
    private double ticketFare;
    private List<Booking> bookedTickets;
    private List<List<Integer>> seat2D;
    private int seatRow, seatCol;

    public Show(int movieId, int screenId, String showTiming, double ticketFare, int seatRow, int seatCol) {
        this.showId = ++idIncrement;
        this.movieId = movieId;
        this.screenId = screenId;
        this.showTiming = showTiming;
        this.ticketFare = ticketFare;
        this.bookedTickets = new ArrayList<>();
        this.seatRow = seatRow;
        this.seatCol = seatCol;
        this.seat2D = new ArrayList<>();
        initseat2D();
    }

    private void initseat2D() {
        for(int i=0;i<seatRow;i++){
            List<Integer> seat = new ArrayList<>();
            for(int j=0;j<seatCol;j++){
                seat.add(0);
            }
            this.seat2D.add(seat);
        }
    }

    public List<List<Integer>> getSeat2D() {
        return seat2D;
    }

    public void setSeat2D(List<List<Integer>> seat2D) {
        this.seat2D = seat2D;
    }

    public int getScreenId() {
        return screenId;
    }

    public void setScreenId(int screenId) {
        this.screenId = screenId;
    }

    public String getShowTiming() {
        return showTiming;
    }

    public void setShowTiming(String showTiming) {
        this.showTiming = showTiming;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public double getTicketFare() {
        return ticketFare;
    }

    public void setTicketFare(int ticketFare) {
        this.ticketFare = ticketFare;
    }

    public List<Booking> getBookedTickets() {
        return bookedTickets;
    }

    public void setBookedTickets(List<Booking> bookedTickets) {
        this.bookedTickets = bookedTickets;
    }

    @Override
    public String toString() {
        return "Show{" +
                "screenId=" + screenId +
                ", showTiming='" + showTiming + '\'' +
                ", movieId=" + movieId +
                ", ticketFare=" + ticketFare +
                ", bookedTickets=" + bookedTickets +
                '}';
    }

    public int getShowId() {
        return showId;
    }
}
