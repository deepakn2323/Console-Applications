package com.example.moviebooking.datalayer;

import com.example.moviebooking.dto.Movie;
import com.example.moviebooking.dto.Theatre;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheatreRepository {
    private static TheatreRepository repository;
    private List<String> cities = new ArrayList<>();
    private Map<String, Theatre> cityTheatreMap = new HashMap<>();
    private Map<Integer, List<Theatre>> movieIdTheatreMap = new HashMap<>();
    private Map<Integer, Theatre> theatreIdTheatreMap = new HashMap<>();

    private List<Movie> movieList = new ArrayList<>();
    private TheatreRepository() {

    }

    public static TheatreRepository getInstance() {

        if (repository == null) {
            repository = new TheatreRepository();
        }

        return repository;
    }

    public List<String> getCities() {
        return cities;
    }
    public boolean addCity(String city) {
        if (!cities.contains(city.toLowerCase())) {
            cities.add(city.toLowerCase());
            return true;
        } else {
            return false;
        }
    }
    public void addMoveIdToTheatre(int movieId, Theatre theatre) {
        if(movieIdTheatreMap.containsKey(movieId)){
            movieIdTheatreMap.get(movieId).add(theatre);
        }
        else{
            List<Theatre> theatreList = new ArrayList<>();
            theatreList.add(theatre);
            movieIdTheatreMap.put(movieId, theatreList);
        }
    }

    public boolean createTheatre(String city, Theatre theatre) {
        cityTheatreMap.put(city, theatre);
        addTheatreIdTheatreMap(theatre);
        return cityTheatreMap.containsKey(city);
    }

    public Theatre getTheatreOfACity(String city) {
        return cityTheatreMap.getOrDefault(city, null);
    }
    public List<Theatre> getTheatresRunningShow(int selectedMovieId) {
        if (movieIdTheatreMap.containsKey(selectedMovieId)) {
            return movieIdTheatreMap.get(selectedMovieId);
        } else {
            return new ArrayList<>();
        }
    }


    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }

    public List<Movie> getMovies() {
        return movieList;
    }
    private List<Theatre> getAllTheatres(){
        return new ArrayList<>(cityTheatreMap.values());
    }
    public Map<String, Theatre> getAllTheatresWithCity(){
        return cityTheatreMap;
    }

    public Theatre getTheatreIdTheatreMap(int theatreId) {
        return theatreIdTheatreMap.getOrDefault(theatreId, null);
    }

    public void addTheatreIdTheatreMap(Theatre theatre) {
        this.theatreIdTheatreMap.put(theatre.getId(), theatre);
    }
}
