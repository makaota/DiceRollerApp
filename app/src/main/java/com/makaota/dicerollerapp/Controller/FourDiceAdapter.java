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

public class FourDiceAdapter extends RecyclerView.Adapter<FourDiceAdapter.ViewHolder> {


    private ArrayList<Dice> diceValues;

    int myRandomNum1, myRandomNum3, myRandomNum7, myRandomNum9;

    // Create a diceImage array
    private int [] diceImage = {R.drawable.dice1,R.drawable.dice2,R.drawable.dice3,R.drawable.dice4,
            R.drawable.dice5,R.drawable.dice6};

    public FourDiceAdapter(ArrayList<Dice> diceValuesList){

        diceValues = diceValuesList;

    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView ivResult;

        ImageView ivDice1;
        ImageView ivDice2;
        ImageView ivDice3;
        ImageView ivDice4;

        // Create a diceImage array

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivDice1 = itemView.findViewById(R.id.ivDiceImage1OfFourDice);
            ivDice2 = itemView.findViewById(R.id.ivDiceImage2OfFourDice);
            ivDice3 = itemView.findViewById(R.id.ivDiceValue3ListOfFourDice);
            ivDice4 = itemView.findViewById(R.id.ivDiceValue4ListOfFourDice);

            ivResult = itemView.findViewById(R.id.ivResultOfFourDice);

        }
    }
    @NonNull
    @Override
    public FourDiceAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_of_four_dice,parent,
                false);
        return new FourDiceAdapter.ViewHolder(v);

    }

    private void getFourDiceValue(int dice1Value, int dice3Value, int dice7Value, int dice9Value) {

        if (dice1Value == 1) {
            myRandomNum1 = 0;
        }
        if (dice1Value == 2) {
            myRandomNum1 = 1;
        }
        if (dice1Value == 3) {
            myRandomNum1 = 2;
        }
        if (dice1Value == 4) {
            myRandomNum1 = 3;
        }
        if (dice1Value == 5) {
            myRandomNum1 = 4;
        }
        if (dice1Value == 6) {
            myRandomNum1 = 5;
        }


        if (dice3Value == 1) {
            myRandomNum3 = 0;
        }
        if (dice3Value == 2) {
            myRandomNum3 = 1;
        }
        if (dice3Value == 3) {
            myRandomNum3 = 2;
        }
        if (dice3Value == 4) {
            myRandomNum3 = 3;
        }
        if (dice3Value == 5) {
            myRandomNum3 = 4;
        }
        if (dice3Value == 6) {
            myRandomNum3 = 5;
        }


        if (dice7Value == 1) {
            myRandomNum7 = 0;
        }
        if (dice7Value == 2) {
            myRandomNum7 = 1;
        }
        if (dice7Value == 3) {
            myRandomNum7 = 2;
        }
        if (dice7Value == 4) {
            myRandomNum7 = 3;
        }
        if (dice7Value == 5) {
            myRandomNum7 = 4;
        }
        if (dice7Value == 6) {
            myRandomNum7 = 5;
        }


        if (dice9Value == 1) {
            myRandomNum9 = 0;
        }
        if (dice9Value == 2) {
            myRandomNum9 = 1;
        }
        if (dice9Value == 3) {
            myRandomNum9 = 2;
        }
        if (dice9Value == 4) {
            myRandomNum9 = 3;
        }
        if (dice9Value == 5) {
            myRandomNum9 = 4;
        }
        if (dice9Value == 6) {
            myRandomNum9 = 5;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull FourDiceAdapter.ViewHolder holder, int position) {

        int dice1Value = diceValues.get(position).getDice1Value();
        int dice2Value = diceValues.get(position).getDice3Value();
        int dice3Value = diceValues.get(position).getDice7Value();
        int dice4Value = diceValues.get(position).getDice9Value();

        holder.itemView.setTag(diceValues.get(position));
        getFourDiceValue(dice1Value,dice2Value,dice3Value,dice4Value);
        holder.ivDice1.setImageResource(diceImage[myRandomNum1]);
        holder.ivDice2.setImageResource(diceImage[myRandomNum3]);
        holder.ivDice3.setImageResource(diceImage[myRandomNum7]);
        holder.ivDice4.setImageResource(diceImage[myRandomNum9]);

        int result = dice1Value + dice2Value + dice3Value + dice4Value;

        switch (result) {

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
            case 13:
                holder.ivResult.setImageResource(R.drawable.img_value_thirteen);
                break;
            case 14:
                holder.ivResult.setImageResource(R.drawable.img_value_fourteen);
                break;
            case 15:
                holder.ivResult.setImageResource(R.drawable.img_value_fifteen);
                break;
            case 16:
                holder.ivResult.setImageResource(R.drawable.img_value_sixteen);
                break;

            case 17:
                holder.ivResult.setImageResource(R.drawable.img_value_seventeen);
                break;

            case 18:
                holder.ivResult.setImageResource(R.drawable.img_value_eighteen);
                break;

            case 19:
                holder.ivResult.setImageResource(R.drawable.img_value_nineteen);
                break;

            case 20:
                holder.ivResult.setImageResource(R.drawable.img_value_twenty);
                break;

            case 21:
                holder.ivResult.setImageResource(R.drawable.img_value_twenty_one);
                break;

            case 22:
                holder.ivResult.setImageResource(R.drawable.img_value_twenty_two);
                break;

            case 23:
                holder.ivResult.setImageResource(R.drawable.img_value_twenty_three);
                break;

            case 24:
                holder.ivResult.setImageResource(R.drawable.img_value_twenty_four);
                break;
        }

    }

    @Override
    public int getItemCount() {
        return diceValues.size();

    }

}