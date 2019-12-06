package com.example.appoftheyear.classLibrary;

public class MenuItem {
    private String _naam;

    public String Get_naam() {
        return _naam;
    }

    public void Set_naam(String _naam) {
        this._naam = _naam;
    }

    private int _prijs;

    public int Get_prijs() {
        return _prijs;
    }

    public void Set_prijs(int _prijs) {
        this._prijs = _prijs;
    }

    public MenuItem(String naam, int prijs){
        Set_naam(naam);
        Set_prijs(prijs);
    }

    @Override
    public String toString(){
        return _naam;
    }
}
