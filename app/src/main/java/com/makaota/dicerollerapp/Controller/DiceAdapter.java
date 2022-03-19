package com.makaota.dicerollerapp.Controller;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.makaota.dicerollerapp.Model.Dice;
import com.makaota.dicerollerapp.Model.MyDiceKeysAndValues;
import com.makaota.dicerollerapp.R;

import java.util.ArrayList;
import java.util.HashMap;

public class DiceAdapter extends RecyclerView.Adapter<DiceAdapter.ViewHolder> {


    private ArrayList<Dice> diceValues;

    int myRandomNum5;

    // Create a diceImage array
    private int[] diceImage = {R.drawable.dice1, R.drawable.dice2, R.drawable.dice3, R.drawable.dice4,
            R.drawable.dice5, R.drawable.dice6};

    public DiceAdapter(ArrayList<Dice> diceValuesList) {

        diceValues = diceValuesList;

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivResult;
        ImageView ivDice1;

        // Create a diceImage array
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivDice1 = itemView.findViewById(R.id.ivDice1);
            ivResult = itemView.findViewById(R.id.ivResultOfOneDie);

        }

    }

    @NonNull
    @Override
    public DiceAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items, parent,
                false);
        return new ViewHolder(v);

    }

    private void getOneDiceValue(int dice5Value) {


        if (dice5Value == 1) {
            myRandomNum5 = 0;
        }
        if (dice5Value == 2) {
            myRandomNum5 = 1;
        }
        if (dice5Value == 3) {
            myRandomNum5 = 2;
        }
        if (dice5Value == 4) {
            myRandomNum5 = 3;
        }
        if (dice5Value == 5) {
            myRandomNum5 = 4;
        }
        if (dice5Value == 6) {
            myRandomNum5 = 5;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull DiceAdapter.ViewHolder holder, int position) {


        int dice1Value = diceValues.get(position).getDice5Value();

        holder.itemView.setTag(diceValues.get(position));

        getOneDiceValue(dice1Value);

        int result = dice1Value;


        switch (result) {
            case 1:
                holder.ivResult.setImageResource(R.drawable.img_value_one);
                break;
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
        }


        holder.ivDice1.setImageResource(diceImage[myRandomNum5]);

    }


    @Override
    public int getItemCount() {
        return diceValues.size();

    }

}
