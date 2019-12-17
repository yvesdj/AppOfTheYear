package com.example.appoftheyear.classLibrary;

import android.widget.ArrayAdapter;

import com.example.appoftheyear.DrinksFragment;

import java.util.ArrayList;

public class MenuKaart {
    private static ArrayList<MenuItem> _menuItems = new ArrayList<>();
    private  static ArrayList<Voorgerecht> _voorgerechten = new ArrayList<>();
    private  static ArrayList<Hoofdgerecht> _hoofdgerechten = new ArrayList<>();
    private static ArrayList<Drink> _drinks = new ArrayList<>();
    private static ArrayList<Dessert> _desserts = new ArrayList<>();




    public MenuKaart() {
       _menuItems = new ArrayList<>();


    }

    /*
    public MenuKaart(ArrayList<Voorgerecht> voorgerechten) {
        _voorgerechten = voorgerechten;

        for (Voorgerecht voorgerecht: _voorgerechten) {

            _menuItems.add(new Voorgerecht(voorgerecht.Get_naam(), voorgerecht.Get_prijs()));
            
        }

       // _hoofdgerechten = hoofdgerechten;
       // _drinks = drinks;
       // _desserts = desserts;
    }
*/
    public void setVoorgerechten(ArrayList<Voorgerecht> value){
        _voorgerechten = value;
    }

    public ArrayList<Voorgerecht> getVoorgerechten(){
        return _voorgerechten;
    }


    public void setHoofdgerechten(ArrayList<Hoofdgerecht> value){
        _hoofdgerechten = value;
    }

    public ArrayList<Hoofdgerecht> getHoofdgerechten(){
        return _hoofdgerechten;
    }

    public void setDesserts(ArrayList<Dessert> value){
        _desserts = value;
    }

    public ArrayList<Dessert>getDesserts(){
        return _desserts;
    }


    public void  setDrinks(ArrayList<Drink>value){
        _drinks = value;
    }

    public  ArrayList<Drink>getDrinks(){
        return _drinks;
    }

    /*
    public ArrayList<Voorgerecht> GetVoorgerechten(){
        ArrayList<Voorgerecht> voorgerechten = new ArrayList<>();
        for (MenuItem item : _menuItems) {
            if (item instanceof Voorgerecht){
                voorgerechten.add((Voorgerecht) item);
            }
        }
        return voorgerechten;
    }
*/
    /*
    public ArrayList<Hoofdgerecht> GetHoofdgerechten(){
        ArrayList<Hoofdgerecht> hoofdgerechten = new ArrayList<>();
        for (MenuItem item : _menuItems) {
            if (item instanceof Hoofdgerecht){
                hoofdgerechten.add((Hoofdgerecht) item);
            }
        }
        return hoofdgerechten;
    }
*/
    /*
    public ArrayList<Drink> GetDrinks(){
        ArrayList<Drink> drinks = new ArrayList<>();
        for (MenuItem item : _menuItems) {
            if (item instanceof Drink){
                drinks.add((Drink) item);
            }
        }
        return drinks;
    }
*/

    /*
    public ArrayList<Dessert> GetDesserten(){
        ArrayList<Dessert> deserten = new ArrayList<Dessert>();
        for (MenuItem item : _menuItems) {
            if (item instanceof Dessert){
                deserten.add((Dessert) item);
            }
        }
        return deserten;
    }
*/
}
