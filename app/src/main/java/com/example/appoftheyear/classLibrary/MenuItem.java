package com.example.appoftheyear.classLibrary;

public abstract class MenuItem {
    private String _naam;

    public String Get_naam() {
        return _naam;
    }

    public void Set_naam(String _naam) {
        this._naam = _naam;
    }

    private float _prijs;

    public float Get_prijs() {
        return _prijs;
    }

    public void Set_prijs(float _prijs) {
        this._prijs = _prijs;
    }

    public MenuItem(String naam, float prijs){
        Set_naam(naam);
        Set_prijs(prijs);
    }

    @Override
    public String toString(){
        return _naam;


    }



}
