package com.example.appoftheyear.classLibrary;

import java.util.ArrayList;

public class MenuKaart {
    private static ArrayList<MenuItem> _menuItems;

    public MenuKaart() {
        _menuItems = new ArrayList<>();
    }

    public MenuKaart(ArrayList<MenuItem> menuItems) {
        _menuItems = menuItems;
    }

    public void AddMenuItem(MenuItem item){
        _menuItems.add(item);
    }


    public ArrayList<Voorgerecht> GetVoorgerechten(){
        ArrayList<Voorgerecht> voorgerechten = new ArrayList<>();
        for (MenuItem item : _menuItems) {
            if (item instanceof Voorgerecht){
                voorgerechten.add((Voorgerecht) item);
            }
        }
        return voorgerechten;
    }

    public ArrayList<Hoofdgerecht> GetHoofdgerechten(){
        ArrayList<Hoofdgerecht> hoofdgerechten = new ArrayList<>();
        for (MenuItem item : _menuItems) {
            if (item instanceof Hoofdgerecht){
                hoofdgerechten.add((Hoofdgerecht) item);
            }
        }
        return hoofdgerechten;
    }

    public ArrayList<Drink> GetDrinks(){
        ArrayList<Drink> drinks = new ArrayList<>();
        for (MenuItem item : _menuItems) {
            if (item instanceof Drink){
                drinks.add((Drink) item);
            }
        }
        return drinks;
    }

    public ArrayList<Dessert> GetDesserten(){
        ArrayList<Dessert> deserten = new ArrayList<>();
        for (MenuItem item : _menuItems) {
            if (item instanceof Dessert){
                deserten.add((Dessert) item);
            }
        }
        return deserten;
    }

}
