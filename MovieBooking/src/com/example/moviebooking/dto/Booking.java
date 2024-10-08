package com.example.moviebooking.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Booking {
    private String id;
    private User user;
    private Movie movie;
    private String showTiming;
    private int screenId;
    private String screenName;
    private String theatreName;
    private LocalDateTime bookingDate;
    private int numberOfTickets;
    private List<int[]> seatNumbers;
    private int showId;
    private Show show;

    public Booking(User user, Movie movie, Show show, Screen screen,String theatreName, LocalDateTime bookingDate, int numberOfTickets, List<int[]> seatNumbers) {
        this.id = UUID.randomUUID().toString();
        this.user = user;
        this.movie = movie;
        this.showId = show.getShowId();
        this.showTiming = show.getShowTiming();
        this.screenId = screen.getId();
        this.screenName=screen.getName();
        this.theatreName = theatreName;
        this.bookingDate = bookingDate;
        this.numberOfTickets = numberOfTickets;
        this.seatNumbers = seatNumbers;
        this.show = show;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getShowTiming() {
        return showTiming;
    }

    public void setShowTiming(String showTiming) {
        this.showTiming = showTiming;
    }

    public String getTheatreName() {
        return theatreName;
    }

    public void setTheatreName(String theatreName) {
        this.theatreName = theatreName;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public List<int[]> getSeatNumbers() {
        return seatNumbers;
    }

    public void setSeatNumbers(List<int[]> seatNumbers) {
        this.seatNumbers = seatNumbers;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id='" + id + '\'' +
                ", user=" + user +
                ", movie=" + movie +
                ", showTiming='" + showTiming + '\'' +
                ", screenName='" + screenName + '\'' +
                ", theatreName='" + theatreName + '\'' +
                ", bookingDate=" + bookingDate +
                ", numberOfTickets=" + numberOfTickets +
                ", seatNumbers=" + seatNumbers +
                '}';
    }

    public int getScreenId() {
        return screenId;
    }

    public void setScreenId(int screenId) {
        this.screenId = screenId;
    }

    public int getShowId() {
        return showId;
    }

    public void setShowId(int showId) {
        this.showId = showId;
    }

    public Show getShow() {
        return show;
    }
}
