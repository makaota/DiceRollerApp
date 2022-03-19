package com.makaota.dicerollerapp.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.makaota.dicerollerapp.Model.MyDiceKeysAndValues;
import com.makaota.dicerollerapp.R;

public class StartActivity extends AppCompatActivity {

    // Widgets
    Button btn;
    TextView t1, t2;

    Animation animate_btn, animate_txt;

    Intent intent;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        getSupportActionBar().setTitle("Start");

        btn = findViewById(R.id.button);
        t1 = findViewById(R.id.textView);
        t2 = findViewById(R.id.textView2);

        // Now let's add the animation
        animate_btn = AnimationUtils.loadAnimation(this,
                R.anim.animate_btn);

        animate_txt = AnimationUtils.loadAnimation(this,
                R.anim.animate_texts);

        btn.setAnimation(animate_btn);

        // Let's Create animation for the text
        t1.setAnimation(animate_txt);
        t2.setAnimation(animate_txt);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent = new Intent(StartActivity.this, DiceActivity.class);
                startActivity(intent);

            }
        });


    }
}
