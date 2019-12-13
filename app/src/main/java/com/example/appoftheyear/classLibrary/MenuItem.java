package com.example.appoftheyear.classLibrary;

import android.os.Parcel;
import android.os.Parcelable;

public class MenuItem implements Parcelable {
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
        return this._naam + " [$" + this._prijs + "]";
    }




    protected MenuItem(Parcel in) {
        _naam = in.readString();
        _prijs = in.readFloat();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(_naam);
        dest.writeFloat(_prijs);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<MenuItem> CREATOR = new Parcelable.Creator<MenuItem>() {
        @Override
        public MenuItem createFromParcel(Parcel in) {
            return new MenuItem(in);
        }

        @Override
        public MenuItem[] newArray(int size) {
            return new MenuItem[size];
        }
    };
}