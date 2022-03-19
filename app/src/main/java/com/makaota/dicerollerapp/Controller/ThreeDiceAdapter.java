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

public class ThreeDiceAdapter extends RecyclerView.Adapter<ThreeDiceAdapter.ViewHolder> {


    private ArrayList<Dice> diceValues;

    int myRandomNum2, myRandomNum5, myRandomNum8;


    // Create a diceImage array
    private int [] diceImage = {R.drawable.dice1,R.drawable.dice2,R.drawable.dice3,R.drawable.dice4,
            R.drawable.dice5,R.drawable.dice6};

    public ThreeDiceAdapter(ArrayList<Dice> diceValuesList){

        diceValues = diceValuesList;

    }

    public class ViewHolder extends RecyclerView.ViewHolder{


        ImageView ivResult;

        ImageView ivDice1;
        ImageView ivDice2;
        ImageView ivDice3;

        // Create a diceImage array

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivDice1 = itemView.findViewById(R.id.ivDiceImage1OfThreeDice);
            ivDice2 = itemView.findViewById(R.id.ivDiceImage2OfThreeDice);
            ivDice3 = itemView.findViewById(R.id.ivDiceValue3OfListOfThreeDice);

            ivResult = itemView.findViewById(R.id.ivResultOfThreeDice);

        }
    }
    @NonNull
    @Override
    public ThreeDiceAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_of_three_dice,parent,
                false);
        return new ThreeDiceAdapter.ViewHolder(v);

    }

    private void getThreeDiceValues(int dice2Value, int dice5Value, int dice8Value) {

        if (dice2Value == 1) {
            myRandomNum2 = 0;
        }
        if (dice2Value == 2) {
            myRandomNum2 = 1;
        }
        if (dice2Value == 3) {
            myRandomNum2 = 2;
        }
        if (dice2Value == 4) {
            myRandomNum2 = 3;
        }
        if (dice2Value == 5) {
            myRandomNum2 = 4;
        }
        if (dice2Value == 6) {
            myRandomNum2 = 5;
        }


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


        if (dice8Value == 1) {
            myRandomNum8 = 0;
        }
        if (dice8Value == 2) {
            myRandomNum8 = 1;
        }
        if (dice8Value == 3) {
            myRandomNum8 = 2;
        }
        if (dice8Value == 4) {
            myRandomNum8 = 3;
        }
        if (dice8Value == 5) {
            myRandomNum8 = 4;
        }
        if (dice8Value == 6) {
            myRandomNum8 = 5;
        }
    }

        @Override
    public void onBindViewHolder(@NonNull ThreeDiceAdapter.ViewHolder holder, int position) {


        int dice1Value = diceValues.get(position).getDice2Value();
        int dice2Value = diceValues.get(position).getDice5Value();
        int dice3Value = diceValues.get(position).getDice8Value();

        holder.itemView.setTag(diceValues.get(position));


        getThreeDiceValues(dice1Value,dice2Value,dice3Value);
        holder.ivDice1.setImageResource(diceImage[myRandomNum2]);
        holder.ivDice2.setImageResource(diceImage[myRandomNum5]);
        holder.ivDice3.setImageResource(diceImage[myRandomNum8]);

        int result = dice1Value + dice2Value + dice3Value;

            switch (result) {

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
            }
    }

    @Override
    public int getItemCount() {
        return diceValues.size();

    }
}
