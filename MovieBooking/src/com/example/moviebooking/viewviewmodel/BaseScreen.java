package com.example.moviebooking.viewviewmodel;

public class BaseScreen {
    public boolean hasCheckNetworkConnection() {
        return checkNetworkConnection();
    }

    public boolean checkNetworkConnection() {
        return true;
    }
}
