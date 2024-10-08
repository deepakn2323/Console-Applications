package com.example.moviebooking.viewviewmodel.theatrelistscreen;


import com.example.moviebooking.datalayer.TheatreRepository;
import com.example.moviebooking.dto.Screen;
import com.example.moviebooking.dto.Show;
import com.example.moviebooking.dto.Theatre;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class TheatreListViewModel {

    private TheatreListView theatreListScreen;

    public TheatreListViewModel(TheatreListView theatreListScreen) {
        this.theatreListScreen = theatreListScreen;
    }

    List<Theatre> getTheatresRunningShow(int selectedMovieId) {
        return TheatreRepository.getInstance().getTheatresRunningShow(selectedMovieId);
    }

    String getMovieName(int selectedMovieId) {
        return TheatreRepository.getInstance().getMovies().get(selectedMovieId).getMovieName();
    }

    List<Screen> getScreensRunningSelectedMovie(Theatre selectedTheatre, int selectedMovieId) {
        List<Screen> screenList = selectedTheatre.getScreenList();
        List<Screen> validScreens = new ArrayList<>();
        for (Screen screen : screenList) {
            if (screen.getMovieIds().contains(selectedMovieId)) {
                validScreens.add(screen);
            }
        }
        return validScreens;
    }

    Show getSelectedShow(List<Screen> screensRunningSelectedMovie, int showNumber, int selectedMovieId) {
        int currentShowIndex = 0;

        for (Screen screen : screensRunningSelectedMovie) {
            List<Show> shows = screen.getShows();
            for (Show show : shows) {
                if (show.getMovieId() == selectedMovieId) {
                    if (currentShowIndex == showNumber) {
                        return show;
                    }
                    currentShowIndex++;
                }
            }
        }
        return null;
    }

    Map<String, Theatre> getAllTheatres() {
        return TheatreRepository.getInstance().getAllTheatresWithCity();
    }

    Screen getSelectedScreen(List<Screen> screensRunningSelectedMovie, int showNumber, int selectedMovieId) {
        int currentShowIndex = 0;

        for (Screen screen : screensRunningSelectedMovie) {
            List<Show> shows = screen.getShows();
            for (Show show : shows) {
                if (show.getMovieId() == selectedMovieId) {
                    if (currentShowIndex == showNumber) {
                        return screen;
                    }
                    currentShowIndex++;
                }
            }
        }
        return null;
    }

    boolean validateSelectedTheatreId(String selectedTheatreId, List<Theatre> theatres) {
        int id = Integer.parseInt(selectedTheatreId);
        return id >= 1 && id <= theatres.size();
    }
}
