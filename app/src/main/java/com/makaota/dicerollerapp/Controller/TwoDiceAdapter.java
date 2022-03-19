package com.makaota.dicerollerapp.Controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.makaota.dicerollerapp.Model.Dice;
import com.makaota.dicerollerapp.R;

import java.util.ArrayList;

public class TwoDiceAdapter extends RecyclerView.Adapter<TwoDiceAdapter.ViewHolder> {


    private ArrayList<Dice> diceValues;

    int myRandomNum4, myRandomNum6;


    // Create a diceImage array
    private int[] diceImage = {R.drawable.dice1, R.drawable.dice2, R.drawable.dice3, R.drawable.dice4,
            R.drawable.dice5, R.drawable.dice6};


    public TwoDiceAdapter(ArrayList<Dice> diceValuesList) {
        diceValues = diceValuesList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivResult;
        ImageView ivDice1;
        ImageView ivDice2;

        // Create a diceImage array

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivDice1 = itemView.findViewById(R.id.ivDiceImage1OfTwoDice);
            ivDice2 = itemView.findViewById(R.id.ivDiceImage2OfTwodice);
            ivResult = itemView.findViewById(R.id.ivResultOfTwoDice);

        }
    }

    @NonNull
    @Override
    public TwoDiceAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_of_two_dice, parent,
                false);
        return new TwoDiceAdapter.ViewHolder(v);

    }

    private void getTwoDiceValues(int dice4Value, int dice6Value) {


        if (dice4Value == 1) {
            myRandomNum4 = 0;
        }
        if (dice4Value == 2) {
            myRandomNum4 = 1;
        }
        if (dice4Value == 3) {
            myRandomNum4 = 2;
        }
        if (dice4Value == 4) {
            myRandomNum4 = 3;
        }
        if (dice4Value == 5) {
            myRandomNum4 = 4;
        }
        if (dice4Value == 6) {
            myRandomNum4 = 5;
        }


        if (dice6Value == 1) {
            myRandomNum6 = 0;
        }
        if (dice6Value == 2) {
            myRandomNum6 = 1;
        }
        if (dice6Value == 3) {
            myRandomNum6 = 2;
        }
        if (dice6Value == 4) {
            myRandomNum6 = 3;
        }
        if (dice6Value == 5) {
            myRandomNum6 = 4;
        }
        if (dice6Value == 6) {
            myRandomNum6 = 5;
        }
    }


    @Override
    public void onBindViewHolder(@NonNull TwoDiceAdapter.ViewHolder holder, int position) {

        int dice1Value = diceValues.get(position).getDice4Value();
        int dice2Value = diceValues.get(position).getDice6Value();

        holder.itemView.setTag(diceValues.get(position));

        getTwoDiceValues(dice1Value, dice2Value);

        holder.ivDice1.setImageResource(diceImage[myRandomNum6]);

        holder.ivDice2.setImageResource(diceImage[myRandomNum4]);

        int result = dice1Value + dice2Value;

        switch (result) {
            case 2:
                holder.ivResult.setImageResource(R.drawable.img_value_two);
                break;
            case 3:
                holder.ivResult.setImageResource(R.drawable.img_value_three);
                break;
            case 4:
                holder.ivResult.setImageResource(R.drawable.img_value_four);
                break;
            case 5:
                holder.ivResult.setImageResource(R.drawable.img_value_five);
                break;
            case 6:
                holder.ivResult.setImageResource(R.drawable.img_value_six);
                break;
            case 7:
                holder.ivResult.setImageResource(R.drawable.img_value_seven);
                break;
            case 8:
                holder.ivResult.setImageResource(R.drawable.img_value_eight);
                break;
            case 9:
                holder.ivResult.setImageResource(R.drawable.img_value_nine);
                break;
            case 10:
                holder.ivResult.setImageResource(R.drawable.img_value_ten);
                break;
            case 11:
                holder.ivResult.setImageResource(R.drawable.img_value_eleven);
                break;
            case 12:
                holder.ivResult.setImageResource(R.drawable.img_value_twelve);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return diceValues.size();

    }

}
