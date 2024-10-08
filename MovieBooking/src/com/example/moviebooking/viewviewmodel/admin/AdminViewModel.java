package com.example.moviebooking.viewviewmodel.admin;

import com.example.moviebooking.datalayer.TheatreRepository;
import com.example.moviebooking.dto.Movie;
import com.example.moviebooking.dto.Screen;
import com.example.moviebooking.dto.Show;
import com.example.moviebooking.dto.Theatre;
import com.example.moviebooking.validate.Authenticator;
import com.example.moviebooking.validate.Validator;

import java.util.List;

class AdminViewModel{
    private Validator validator;
    private Authenticator authenticator;
    private AdminView adminView;

    public AdminViewModel(AdminView adminView) {
        this.adminView = adminView;
        this.validator = new Validator();
    }


    boolean validateCity(String city) {
        return validator.validateCity(city);
    }

    boolean addTheatre(String city, String theatreName, String totalScreens, List<Screen> screenList) {
        city = city.toLowerCase();
        boolean added = true;
        added = added && TheatreRepository.getInstance().addCity(city.toLowerCase());
        added = added && TheatreRepository.getInstance().createTheatre(city, new Theatre(theatreName, city, Integer.parseInt(totalScreens), screenList));
        return added;
    }


    List<String> getAllCities() {
        return TheatreRepository.getInstance().getCities();
    }

    Theatre getTheatreOfACity(String city) {
        return TheatreRepository.getInstance().getTheatreOfACity(city);
    }

    List<Movie> getAllMovies() {
        return TheatreRepository.getInstance().getMovies();
    }

    void addShow(Theatre theatre, int selectedScreen, Show show, int movieId) {
        Screen screen = theatre.getScreen(selectedScreen);
        screen.addMovieIds(movieId);
        TheatreRepository.getInstance().addMoveIdToTheatre(movieId, theatre);
         screen.addShows(show);
    }

    public void createShow(Theatre theatre, int selectedScreenId, int selectedMovieId, String showTime, double ticketFare) {
        Screen screen = theatre.getScreen(selectedScreenId);
        List<Show> shows  = screen.getShows();
        if(!isShowExist(shows, showTime)){
            Show newShow = new Show(selectedMovieId, screen.getId(), showTime, ticketFare, screen.getSeatRow(), screen.getSeatCol());
            screen.addMovieIds(selectedMovieId);
            TheatreRepository.getInstance().addMoveIdToTheatre(selectedMovieId, theatre);
            screen.addShows(newShow);
            adminView.onShowCreationSuccessfull();
        }
        else{
            adminView.onShowCreationFailure();
        }
    }

    private boolean isShowExist(List<Show> shows, String showTime) {
        for(Show show : shows){
            if(show.getShowTiming().equals(showTime)){
                return true;
            }
        }
        return false;
    }
}