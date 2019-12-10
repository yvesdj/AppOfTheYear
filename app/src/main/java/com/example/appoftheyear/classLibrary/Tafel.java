package com.example.appoftheyear.classLibrary;

import java.util.ArrayList;

public class Tafel {
    private int _tafelId;

    public void set_tafelId(int _tafelId) {
        this._tafelId = _tafelId;
    }

    private ArrayList<MenuItem> _tafelItems;

    public ArrayList<MenuItem> get_tafelItems() {
        return _tafelItems;
    }

    public void set_tafelItems(ArrayList<MenuItem> _tafelItems) {
        this._tafelItems = _tafelItems;
    }

    public float berekenPrijs(){
        float totaalPrijs = 0;
        for (MenuItem item : _tafelItems) {
            totaalPrijs += item.Get_prijs();
        }
        return totaalPrijs;
    }
}
