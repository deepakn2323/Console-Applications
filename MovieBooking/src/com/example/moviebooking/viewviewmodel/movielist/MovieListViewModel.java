package com.example.moviebooking.viewviewmodel.movielist;

import com.example.moviebooking.datalayer.TheatreRepository;
import com.example.moviebooking.dto.Movie;

import java.util.List;

class MovieListViewModel{
    private MovieListView movieListView;
    MovieListViewModel(MovieListView movieListView){
        this.movieListView = movieListView;
    }

    List<Movie> getAllMovies() {
        return TheatreRepository.getInstance().getMovies();
    }
}