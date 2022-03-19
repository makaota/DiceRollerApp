package com.makaota.dicerollerapp.Model;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Parcel;
import android.os.Parcelable;

import com.makaota.dicerollerapp.R;

import java.util.ArrayList;

public class Dice implements Parcelable {

    private int dice1Value;
    private int dice2Value;
    private int dice3Value;
    private int dice4Value;
    private int dice5Value;
    private int dice6Value;
    private int dice7Value;
    private int dice8Value;
    private int dice9Value;


    public Dice( int dice5Value){

       this.dice5Value = dice5Value;

    }

    public Dice(int dice4Value, int dice6Value){

       this.dice4Value = dice4Value;
       this.dice6Value = dice6Value;

    }

    public Dice(int dice2Value, int dice5Value, int dice8Value){

        this.dice2Value = dice2Value;
        this.dice5Value = dice5Value;
        this.dice8Value = dice8Value;

    }

    public Dice(int dice1Value, int dice3Value, int dice7Value,
                int dice9Value){

        this.dice1Value = dice1Value;
        this.dice3Value = dice3Value;
        this.dice7Value = dice7Value;
        this.dice9Value = dice9Value;
    }

    public Dice(int dice1Value, int dice3Value, int dice5Value,
                int dice7Value, int dice9Value){

        this.dice1Value = dice1Value;
        this.dice3Value = dice3Value;
        this.dice5Value = dice5Value;
        this.dice7Value = dice7Value;
        this.dice9Value = dice9Value;


    }

    public Dice(int dice1Value, int dice3Value, int dice4Value,
                int dice6Value, int dice7Value, int dice9Value){

        this.dice1Value = dice1Value;
        this.dice3Value = dice3Value;
        this.dice4Value = dice4Value;
        this.dice6Value = dice6Value;
        this.dice7Value = dice7Value;
        this.dice9Value = dice9Value;
    }

    protected Dice(Parcel in) {
        dice1Value = in.readInt();
        dice2Value = in.readInt();
        dice3Value = in.readInt();
        dice4Value = in.readInt();
        dice5Value = in.readInt();
        dice6Value = in.readInt();
        dice7Value = in.readInt();
        dice8Value = in.readInt();
        dice9Value = in.readInt();
    }

    public static final Creator<Dice> CREATOR = new Creator<Dice>() {
        @Override
        public Dice createFromParcel(Parcel in) {
            return new Dice(in);
        }

        @Override
        public Dice[] newArray(int size) {
            return new Dice[size];
        }
    };

    public int getDice1Value() {
        return dice1Value;
    }

    public int getDice2Value() {
        return dice2Value;
    }

    public int getDice3Value() {
        return dice3Value;
    }

    public int getDice4Value() {
        return dice4Value;
    }

    public int getDice5Value() {
        return dice5Value;
    }

    public int getDice6Value() {
        return dice6Value;
    }

    public int getDice7Value() {
        return dice7Value;
    }

    public int getDice8Value() {
        return dice8Value;
    }

    public int getDice9Value() {
        return dice9Value;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(dice1Value);
        dest.writeInt(dice2Value);
        dest.writeInt(dice3Value);
        dest.writeInt(dice4Value);
        dest.writeInt(dice5Value);
        dest.writeInt(dice6Value);
        dest.writeInt(dice7Value);
        dest.writeInt(dice8Value);
        dest.writeInt(dice9Value);
    }
}
