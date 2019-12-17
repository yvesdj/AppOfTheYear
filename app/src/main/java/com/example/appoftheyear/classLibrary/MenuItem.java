package com.example.appoftheyear.classLibrary;

import android.os.Parcel;
import android.os.Parcelable;

public class MenuItem implements Parcelable {
    public String naam;

    public float prijs;

    public MenuItem(){

    }

    public MenuItem(String naam, float prijs){
        this.naam = naam;
        this.prijs = prijs;
    }

    @Override
    public String toString(){
        return this.naam + " [$" + this.prijs + "]";
    }




    protected MenuItem(Parcel in) {
        naam = in.readString();
        prijs = in.readFloat();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(naam);
        dest.writeFloat(prijs);
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