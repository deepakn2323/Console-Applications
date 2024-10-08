package com.example.moviebooking.dto;

import java.util.ArrayList;
import java.util.List;

public class Screen {
    private int id;
    private int capacity;
    private String name;
    private int seatRow;
    private int seatCol;
    private int noOfShows;
    private List<Integer> movieIds;
    private List<List<Integer>> seat2D;
    private List<Show> shows;
    private String theatreName;
    public Screen(){

    }
    public Screen(int id, int seatRow, int seatCol, String theatreName) {
        this.id = id;
        this.name = "Screen"+id;
        this.seatRow = seatRow;
        this.seatCol = seatCol;
        this.capacity = seatRow * seatCol;
        this.seat2D = new ArrayList<>();
        this.shows = new ArrayList<>();
        this.movieIds = new ArrayList<>();
        this.theatreName = theatreName;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeatRow() {
        return seatRow;
    }

    public void setSeatRow(int seatRow) {
        this.seatRow = seatRow;
    }

    public int getSeatCol() {
        return seatCol;
    }

    public void setSeatCol(int seatCol) {
        this.seatCol = seatCol;
    }

    public int getNoOfShows() {
        return noOfShows;
    }

    public void setNoOfShows(int noOfShows) {
        this.noOfShows = noOfShows;
    }

    public List<List<Integer>> getSeat2D() {
        return seat2D;
    }

    public void setSeat2D(List<List<Integer>> seat2D) {
        this.seat2D = seat2D;
    }

    public List<Show> getShows() {
        return shows;
    }

    public void addShows(Show show) {
        this.shows.add(show);
    }
    public List<Integer> getMovieIds(){
        return movieIds;
    }
    public void addMovieIds(int movieId) {
        this.movieIds.add(movieId);
    }

    public void setMovieIds(List<Integer> movieIds) {
        this.movieIds = movieIds;
    }

    public void setShows(List<Show> shows) {
        this.shows = shows;
    }

    public String getTheatreName() {
        return theatreName;
    }

    public void setTheatreName(String theatreName) {
        this.theatreName = theatreName;
    }

    @Override
    public String toString() {
        return "Screen{" +
                "id=" + id +
                ", capacity=" + capacity +
                ", name='" + name + '\'' +
                ", seatRow=" + seatRow +
                ", seatCol=" + seatCol +
                ", noOfShows=" + noOfShows +
                ", seat2D=" + seat2D +
                ", shows=" + shows +
                '}';
    }
}
