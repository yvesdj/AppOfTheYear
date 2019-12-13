package com.example.appoftheyear.classLibrary;

import java.util.ArrayList;

public class Tafel {
    private int _tafelId;

    public void Set_tafelId(int _tafelId) {
        this._tafelId = _tafelId;
    }

    private ArrayList<MenuItem> _tafelItems;

    public ArrayList<MenuItem> Get_tafelItems() {
        return _tafelItems;
    }

    public void Set_tafelItems(ArrayList<MenuItem> _tafelItems) {
        this._tafelItems = _tafelItems;
    }

    public float berekenPrijs(){
        float totaalPrijs = 0;
        for (MenuItem item : _tafelItems) {
            totaalPrijs += item.Get_prijs();
        }
        return totaalPrijs;
    }

    public void AddMenuItem(MenuItem item){
        _tafelItems.add(item);
    }

    public ArrayList<String> GetBestellingenNamen(){
        ArrayList<String> bestellingNamen = new ArrayList<>();
        bestellingNamen.add("Bestellingen");
        if (_tafelItems != null){

            for (MenuItem item: _tafelItems) {
                bestellingNamen.add(item.Get_naam());
            }
        }
        return bestellingNamen;
    }
}
