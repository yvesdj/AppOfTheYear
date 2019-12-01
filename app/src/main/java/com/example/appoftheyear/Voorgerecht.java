package com.example.appoftheyear;

public class Voorgerecht {
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

    public Voorgerecht(String Naam, int Prijs) {
        _naam = Naam;
        _prijs = Prijs;
    }

    @Override
    public String toString(){
        return _naam;
    }
}
