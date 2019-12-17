package com.example.appoftheyear.classLibrary;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Tafel implements Parcelable {
    public int tafelId;


    public ArrayList<MenuItem> tafelItems;

    public float berekenPrijs(){
        float totaalPrijs = 0;
        for (MenuItem item : tafelItems) {
            totaalPrijs += item.prijs;
        }
        return totaalPrijs;
    }

    public Tafel(){
        tafelItems = new ArrayList<>();
    }

    public Tafel(int tafelId){
        this.tafelId = tafelId;
        tafelItems = new ArrayList<>();
    }

    protected Tafel(Parcel in) {
        tafelId = in.readInt();
        if (in.readByte() == 0x01) {
            tafelItems = new ArrayList<MenuItem>();
            in.readList(tafelItems, MenuItem.class.getClassLoader());
        } else {
            tafelItems = null;
        }
    }

    public void AddMenuItem(MenuItem item){
        tafelItems.add(item);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(tafelId);
        if (tafelItems == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(tafelItems);
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