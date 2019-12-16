package com.example.appoftheyear.classLibrary;

import android.widget.ArrayAdapter;

import com.example.appoftheyear.DrinksFragment;

import java.util.ArrayList;

public class MenuKaart {
    private static ArrayList<MenuItem> _menuItems;
    private  static ArrayList<Voorgerecht> _voorgerechten;
    private  static ArrayList<Hoofdgerecht> _hoofdgerechten;
    private static ArrayList<Drink> _drinks;
    private static ArrayList<Dessert> _desserts;





    public MenuKaart() {
        _menuItems = new ArrayList<>();

      //  _menuItems.add(new Voorgerecht("Kaaskroket", 5.50f));
     //   _menuItems.add(new Voorgerecht("Garnaalkroket", 5.50f));
        _menuItems.add(new Hoofdgerecht("Vol-au-vent", 10.50f));
        _menuItems.add(new Hoofdgerecht("Steak", 28));
        _menuItems.add(new Dessert("Ne Frisco", 4));
        _menuItems.add(new Dessert("Cremeke me discobolle", 4));
        _menuItems.add(new Drink("Das bier", 3.50f));
        _menuItems.add(new Drink("Ne Scheven Tore", 5.50f));
    }

    public MenuKaart(ArrayList<Voorgerecht> voorgerechten) {
        _voorgerechten = voorgerechten;

        for (Voorgerecht voorgerecht: _voorgerechten) {

            _menuItems.add(voorgerecht);
            
        }

       // _hoofdgerechten = hoofdgerechten;
       // _drinks = drinks;
       // _desserts = desserts;
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
        ArrayList<Dessert> deserten = new ArrayList<Dessert>();
        for (MenuItem item : _menuItems) {
            if (item instanceof Dessert){
                deserten.add((Dessert) item);
            }
        }
        return deserten;
    }

}
