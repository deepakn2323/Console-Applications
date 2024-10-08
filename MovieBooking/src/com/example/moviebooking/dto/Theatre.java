package com.example.moviebooking.dto;

import java.util.ArrayList;
import java.util.List;

public class Theatre {
    private int idIncrement;
    private int id;
    private String name;
    private String city;
    private int totalScreens;
    private List<Screen> screenList;
    public Theatre(String name, String city, int screens, List<Screen> screenList) {
        this.id = ++idIncrement;
        this.name = name;
        this.city = city;
        this.totalScreens=screens;
        this.screenList = screenList;
    }

    public int getIdIncrement() {
        return idIncrement;
    }

    public void setIdIncrement(int idIncrement) {
        this.idIncrement = idIncrement;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getTotalScreens() {
        return totalScreens;
    }

    public void setTotalScreens(int totalScreens) {
        this.totalScreens = totalScreens;
    }

    public List<Screen> getScreenList() {
        return screenList;
    }

    public void setScreenList(List<Screen> screenList) {
        this.screenList = screenList;
    }

    public Screen getScreen(int selectedScreen) {
        return screenList.get(selectedScreen);
    }
}
