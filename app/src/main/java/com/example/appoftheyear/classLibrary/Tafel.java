package com.example.appoftheyear.classLibrary;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Tafel implements Parcelable {
    private int _tafelId;

    public int Get_tafelId() { return _tafelId;}
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

    public Tafel(){
        _tafelItems = new ArrayList<>();
    }

    public Tafel(int tafelId){
        _tafelId = tafelId;
        _tafelItems = new ArrayList<>();
    }

    protected Tafel(Parcel in) {
        _tafelId = in.readInt();
        if (in.readByte() == 0x01) {
            _tafelItems = new ArrayList<MenuItem>();
            in.readList(_tafelItems, MenuItem.class.getClassLoader());
        } else {
            _tafelItems = null;
        }
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(_tafelId);
        if (_tafelItems == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(_tafelItems);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Tafel> CREATOR = new Parcelable.Creator<Tafel>() {
        @Override
        public Tafel createFromParcel(Parcel in) {
            return new Tafel(in);
        }

        @Override
        public Tafel[] newArray(int size) {
            return new Tafel[size];
        }
    };
}