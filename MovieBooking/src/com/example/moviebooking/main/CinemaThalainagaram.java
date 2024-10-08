package com.example.moviebooking.main;

import com.example.moviebooking.datalayer.TheatreRepository;
import com.example.moviebooking.dto.Movie;
import com.example.moviebooking.viewviewmodel.login.LoginView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CinemaThalainagaram {
    private static CinemaThalainagaram cinemaThalainagaram;
    private String appName = "Cinema Thalainagaram";
    private String appVersion = "0.1.0";

    private CinemaThalainagaram() {

    }
    public static CinemaThalainagaram getInstance() {
        if (cinemaThalainagaram == null) {
            cinemaThalainagaram = new CinemaThalainagaram();
        }
        return cinemaThalainagaram;
    }
    private void onCreate() {
        createdMovies();
        LoginView loginView = new LoginView();
        loginView.onCreate();
    }

    public static void main(String[] args) {
        CinemaThalainagaram.getInstance().onCreate();
    }


    void createdMovies(){
        String descriptionGOAT ="Consequences of an unknown past haunt the present of a special anti-terrorist squad. How will they confront it?\n";
        List<String> actorsGOAT = new ArrayList<>(Arrays.asList("Vijay", "Mohan", "Prasanth", "Prabhu Deva", "Jayaram"));
        Movie movieGOAT = new Movie("GOAT",3.10, "5-Sept-2024", descriptionGOAT, "Venkat Prabhu", "UA", actorsGOAT);

        String descriptionMeiyazhagan = "Meiyazhagan is a Tamil movie starring Karthi and Arvind Swamy in prominent roles. It is written and directed by C. Prem Kumar.\n";
        List<String> actorsMeiyazhagan = new ArrayList<>(Arrays.asList("Arvind Samy", "Karthi"));
        Movie movieMeiyazhagan = new Movie("Meiyazhagan", 2.55, "27-Sept-2024", descriptionMeiyazhagan, "C.Prem Kumar", "U", actorsMeiyazhagan);
        List<Movie> movieList = new ArrayList<>();
        movieList.add(movieGOAT);
        movieList.add(movieMeiyazhagan);
        TheatreRepository.getInstance().setMovieList(movieList);
    }

}


