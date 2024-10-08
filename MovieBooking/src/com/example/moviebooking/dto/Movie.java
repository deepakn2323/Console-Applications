package com.example.moviebooking.dto;

import java.util.List;

public class Movie {
    private static int idIncrement;
    private final int movieId;
    private String movieName;
    private double duration;
    private final String movieReleasedDate;
    private String movieDescription;
    private final String movieDirector;
    private final String sensorCertifiedAs;
    private final List<String> movieActors;

    public Movie(String movieName, double duration, String movieReleasedDate, String movieDescription, String movieDirector, String sensorCertifiedAs, List<String> movieActors) {
        this.movieId = ++idIncrement;
        this.movieName = movieName;
        this.duration = duration;
        this.movieReleasedDate = movieReleasedDate;
        this.movieDescription = movieDescription;
        this.movieDirector = movieDirector;
        this.sensorCertifiedAs = sensorCertifiedAs;
        this.movieActors = movieActors;
    }

    public int getMovieId() {
        return movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public String getMovieReleasedDate() {
        return movieReleasedDate;
    }

    public String getMovieDescription() {
        return movieDescription;
    }

    public void setMovieDescription(String movieDescription) {
        this.movieDescription = movieDescription;
    }

    public String getMovieDirector() {
        return movieDirector;
    }

    public String getSensorCertifiedAs() {
        return sensorCertifiedAs;
    }

    public List<String> getMovieActors() {
        return movieActors;
    }

    @Override
    public String toString() {
        return "Movie Details:\n" +
                "--------------------------------------------------\n" +
                "Movie ID          : " + movieId + "\n" +
                "Movie Name        : " + movieName + "\n" +
                "Duration          : " + duration + " hrs\n" +
                "Released Date     : " + movieReleasedDate + "\n" +
                "Description       : " + movieDescription + "\n" +
                "Director          : " + movieDirector + "\n" +
                "Sensor Certified  : " + sensorCertifiedAs + "\n" +
                "Actors            : " + String.join(", ", movieActors) + "\n" +
                "--------------------------------------------------";
    }

}
