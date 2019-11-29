package com.example.appoftheyear;

import java.util.List;

public class Tafel {
    private int id;
    private List<String> _voorgerechten;
    private List<String> _hoofdgerechten;
    private List<String> _desserten;


    public Tafel(List<String> voorgerechten) {
        _voorgerechten = voorgerechten;
    }
}
