package com.makaota.dicerollerapp.View;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.makaota.dicerollerapp.Model.MyDiceKeysAndValues;
import com.makaota.dicerollerapp.R;
import com.shashank.sony.fancytoastlib.FancyToast;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    private Button btnPlay1Die, btnPlay2Dice, btnPlay3Dice, btnPlay4Dice, btnPlay5Dice, btnPlay6Dice;
    private ImageView ivAlea, ivAlea_a, ivDado, ivDice, ivDice_a_5sqb, ivDice_perspective, ivDicey;
    private ImageView ivTerning, ivKismet, ivU_plus;

    private TextView tvCornFlowerBlue, tvWhite, tvMediumSeaGreen, tvLightBlue, tvDarkMagenta,tvMagenta;
    private TextView tvTomato,tvDarkShadeOfYellow, tvDarkPink, tvCyan;

    private TextView enableToggle;

    private SwitchCompat fullScreenSwitch, rollingSound, vibrate;
    private CheckBox shakeToRoll, speakTotal;

    private Button btn_dice_options, btn_theme_options, btn_experience;



    private LinearLayout mySettingsLayout;


    private MyDiceKeysAndValues myDiceKeysAndValues;


    SharedPreferences.Editor editor;
    SharedPreferences sharedPreferences;

    ActionBar actionBar;

    private Vibrator vibrator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_settings_layout);

        editor = getSharedPreferences("prefs", MODE_PRIVATE).edit();
        sharedPreferences = getSharedPreferences("prefs", MODE_PRIVATE);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Settings");

        myDiceKeysAndValues = new MyDiceKeysAndValues();

        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);

        btnPlay1Die = findViewById(R.id.btn_play_1_die);
        btnPlay2Dice = findViewById(R.id.btn_play_2_dice);
        btnPlay3Dice = findViewById(R.id.btn_play_3_dice);
        btnPlay4Dice = findViewById(R.id.btn_play_4_dice);
        btnPlay5Dice = findViewById(R.id.btn_play_5_dice);
        btnPlay6Dice = findViewById(R.id.btn_play_6_dice);

        ivAlea = findViewById(R.id.iv_alea);
        ivAlea_a = findViewById(R.id.iv_alea_a);
        ivDado = findViewById(R.id.iv_dado);
        ivDice = findViewById(R.id.iv_dice);
        ivDice_a_5sqb = findViewById(R.id.iv_dice_a_5sqb);
        ivDice_perspective = findViewById(R.id.iv_dice_perspective);
        ivDicey = findViewById(R.id.iv_dicey);
        ivTerning = findViewById(R.id.iv_terning);
        ivKismet = findViewById(R.id.iv_kismet);
        ivU_plus = findViewById(R.id.iv_u_plus);


        tvCornFlowerBlue = findViewById(R.id.tvCornFlowerBlue);
        tvWhite = findViewById(R.id.tvWhite);
        tvMediumSeaGreen = findViewById(R.id.tvMediumSeaGreen);
        tvLightBlue = findViewById(R.id.tvLightBlue);
        tvDarkMagenta = findViewById(R.id.tvDarkMagenta);
        tvMagenta = findViewById(R.id.tvMagenta);
        tvTomato = findViewById(R.id.tvTomato);
        tvDarkShadeOfYellow = findViewById(R.id.tvDarkShadeOfYellow);
        tvDarkPink = findViewById(R.id.tvDarkPink);
        tvCyan = findViewById(R.id.tvCyan);

        mySettingsLayout = findViewById(R.id.settingsLayout);

        fullScreenSwitch = findViewById(R.id.fullScreenSwitch);

        shakeToRoll = findViewById(R.id.shakeToRoll);
        rollingSound = findViewById(R.id.rollingSound);
        speakTotal = findViewById(R.id.speakTotal);
        vibrate = findViewById(R.id.vibrate);


        btn_dice_options = findViewById(R.id.btn_reset_dice_options);
        btn_theme_options = findViewById(R.id.btn_theme_options);
        btn_experience = findViewById(R.id.btn_experience);

        enableToggle = findViewById(R.id.tvEnableToggle);


        btnPlay1Die.setOnClickListener(this);
        btnPlay2Dice.setOnClickListener(this);
        btnPlay3Dice.setOnClickListener(this);
        btnPlay4Dice.setOnClickListener(this);
        btnPlay5Dice.setOnClickListener(this);
        btnPlay6Dice.setOnClickListener(this);

        ivAlea.setOnClickListener(this);
        ivAlea_a.setOnClickListener(this);
        ivDado.setOnClickListener(this);
        ivDice.setOnClickListener(this);
        ivDice_a_5sqb.setOnClickListener(this);
        ivDice_perspective.setOnClickListener(this);
        ivDicey.setOnClickListener(this);
        ivTerning.setOnClickListener(this);
        ivKismet.setOnClickListener(this);
        ivU_plus.setOnClickListener(this);

        tvCornFlowerBlue.setOnClickListener(this);
        tvWhite.setOnClickListener(this);
        tvMediumSeaGreen.setOnClickListener(this);
        tvLightBlue.setOnClickListener(this);
        tvDarkMagenta.setOnClickListener(this);
        tvMagenta.setOnClickListener(this);
        tvTomato.setOnClickListener(this);
        tvDarkShadeOfYellow.setOnClickListener(this);
        tvDarkPink.setOnClickListener(this);
        tvCyan.setOnClickListener(this);

        fullScreenSwitch.setOnClickListener(this);
        fullScreenSwitch.setOnCheckedChangeListener(this);

        shakeToRoll.setOnClickListener(this);
        rollingSound.setOnCheckedChangeListener(this);
        speakTotal.setOnClickListener(this);
        vibrate.setOnCheckedChangeListener(this);


        btn_dice_options.setOnClickListener(this);
        btn_theme_options.setOnClickListener(this);
        btn_experience.setOnClickListener(this);

        enableFullScreenToggle();




        if (savedInstanceState != null) {

            String cornFlowerBlue = savedInstanceState.getString(myDiceKeysAndValues.getBACKGROUND_COLOR_KEY());
            String white = savedInstanceState.getString(myDiceKeysAndValues.getBACKGROUND_COLOR_KEY());
            String mediumSeaGreen = savedInstanceState.getString(myDiceKeysAndValues.getBACKGROUND_COLOR_KEY());
            String lightBlue = savedInstanceState.getString(myDiceKeysAndValues.getBACKGROUND_COLOR_KEY());
            String darkMagenta = savedInstanceState.getString(myDiceKeysAndValues.getBACKGROUND_COLOR_KEY());
            String magenta = savedInstanceState.getString(myDiceKeysAndValues.getBACKGROUND_COLOR_KEY());
            String tomato = savedInstanceState.getString(myDiceKeysAndValues.getBACKGROUND_COLOR_KEY());
            String darkShaeOfYellow = savedInstanceState.getString(myDiceKeysAndValues.getBACKGROUND_COLOR_KEY());
            String darkPink = savedInstanceState.getString(myDiceKeysAndValues.getBACKGROUND_COLOR_KEY());
            String cyan = savedInstanceState.getString(myDiceKeysAndValues.getBACKGROUND_COLOR_KEY());

            if (cornFlowerBlue.equals(myDiceKeysAndValues.getCORN_FLOWER_BLUE())){
                mySettingsLayout.setBackgroundColor(Color.parseColor("#6495ED"));

            }else if (white.equals(myDiceKeysAndValues.getWHITE())){
                mySettingsLayout.setBackgroundColor(Color.parseColor("#FFFFFF"));

            }else if (mediumSeaGreen.equals(myDiceKeysAndValues.getMEDIUM_SEA_GREEN())){
                mySettingsLayout.setBackgroundColor(Color.parseColor("#3CB371"));

            }else if (lightBlue.equals(myDiceKeysAndValues.getLIGHT_BLUE())){
                mySettingsLayout.setBackgroundColor(Color.parseColor("#ADD8E6"));

            }else if (darkMagenta.equals(myDiceKeysAndValues.getDARK_MAGENTA())){
                mySettingsLayout.setBackgroundColor(Color.parseColor("#8B008B"));

            }else if (magenta.equals(myDiceKeysAndValues.getMAGENTA())){
                mySettingsLayout.setBackgroundColor(Color.parseColor("#FF00FF"));

            }else if (tomato.equals(myDiceKeysAndValues.getTOMATO())){
                mySettingsLayout.setBackgroundColor(Color.parseColor("#FF6347"));

            }else if (darkShaeOfYellow.equals(myDiceKeysAndValues.getDARK_SHADE_OF_YELLOW())){
                mySettingsLayout.setBackgroundColor(Color.parseColor("#666600"));

            }else if (darkPink.equals(myDiceKeysAndValues.getDARK_PINK())){
                mySettingsLayout.setBackgroundColor(Color.parseColor("#FF1493"));

            }else if (cyan.equals(myDiceKeysAndValues.getCYAN())){
                mySettingsLayout.setBackgroundColor(Color.parseColor("#00FFFF"));
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString(myDiceKeysAndValues.getBACKGROUND_COLOR_KEY(), myDiceKeysAndValues.getCORN_FLOWER_BLUE());
        outState.putString(myDiceKeysAndValues.getBACKGROUND_COLOR_KEY(), myDiceKeysAndValues.getWHITE());
        outState.putString(myDiceKeysAndValues.getBACKGROUND_COLOR_KEY(), myDiceKeysAndValues.getMEDIUM_SEA_GREEN());
        outState.putString(myDiceKeysAndValues.getBACKGROUND_COLOR_KEY(), myDiceKeysAndValues.getLIGHT_BLUE());
        outState.putString(myDiceKeysAndValues.getBACKGROUND_COLOR_KEY(), myDiceKeysAndValues.getDARK_MAGENTA());
        outState.putString(myDiceKeysAndValues.getBACKGROUND_COLOR_KEY(), myDiceKeysAndValues.getMAGENTA());
        outState.putString(myDiceKeysAndValues.getBACKGROUND_COLOR_KEY(), myDiceKeysAndValues.getTOMATO());
        outState.putString(myDiceKeysAndValues.getBACKGROUND_COLOR_KEY(), myDiceKeysAndValues.getDARK_SHADE_OF_YELLOW());
        outState.putString(myDiceKeysAndValues.getBACKGROUND_COLOR_KEY(), myDiceKeysAndValues.getDARK_PINK());
        outState.putString(myDiceKeysAndValues.getBACKGROUND_COLOR_KEY(), myDiceKeysAndValues.getCYAN());

    }

    @Override
    protected void onResume() {
        super.onResume();

       chooseColorThemeFunction();
       enableFullScreenToggle();
       setShakeToRoll();
       setRollingSound();
       setSpeakTotal();
       setVibrate();
       setTextViewOnText();

    }

    private void setTextViewOnText(){

        String textViewOnText = sharedPreferences.getString("textOnKey", "tvWhite");

        if (textViewOnText.equals("tvCornFlowerBlue")){

            tvCornFlowerBlue.setText("on");
            tvWhite.setText("");
            tvMediumSeaGreen.setText("");
            tvLightBlue.setText("");
            tvDarkMagenta.setText("");
            tvMagenta.setText("");
            tvTomato.setText("");
            tvDarkShadeOfYellow.setText("");
            tvDarkPink.setText("");
            tvCyan.setText("");

        }else if (textViewOnText.equals("tvWhite")){

            tvCornFlowerBlue.setText("");
            tvWhite.setText("on");
            tvMediumSeaGreen.setText("");
            tvLightBlue.setText("");
            tvDarkMagenta.setText("");
            tvMagenta.setText("");
            tvTomato.setText("");
            tvDarkShadeOfYellow.setText("");
            tvDarkPink.setText("");
            tvCyan.setText("");

        }else if (textViewOnText.equals("tvMediumSeaGreen")){

            tvCornFlowerBlue.setText("");
            tvWhite.setText("");
            tvMediumSeaGreen.setText("on");
            tvLightBlue.setText("");
            tvDarkMagenta.setText("");
            tvMagenta.setText("");
            tvTomato.setText("");
            tvDarkShadeOfYellow.setText("");
            tvDarkPink.setText("");
            tvCyan.setText("");

        }else if (textViewOnText.equals("tvLightBlue")){

            tvCornFlowerBlue.setText("");
            tvWhite.setText("");
            tvMediumSeaGreen.setText("");
            tvLightBlue.setText("on");
            tvDarkMagenta.setText("");
            tvMagenta.setText("");
            tvTomato.setText("");
            tvDarkShadeOfYellow.setText("");
            tvDarkPink.setText("");
            tvCyan.setText("");

        }else if (textViewOnText.equals("tvDarkMagenta")){

            tvCornFlowerBlue.setText("");
            tvWhite.setText("");
            tvMediumSeaGreen.setText("");
            tvLightBlue.setText("");
            tvDarkMagenta.setText("on");
            tvMagenta.setText("");
            tvTomato.setText("");
            tvDarkShadeOfYellow.setText("");
            tvDarkPink.setText("");
            tvCyan.setText("");

        }else if (textViewOnText.equals("tvMagenta")){

            tvCornFlowerBlue.setText("");
            tvWhite.setText("");
            tvMediumSeaGreen.setText("");
            tvLightBlue.setText("");
            tvDarkMagenta.setText("");
            tvMagenta.setText("on");
            tvTomato.setText("");
            tvDarkShadeOfYellow.setText("");
            tvDarkPink.setText("");
            tvCyan.setText("");

        }else if (textViewOnText.equals("tvTomato")){

            tvCornFlowerBlue.setText("");
            tvWhite.setText("");
            tvMediumSeaGreen.setText("");
            tvLightBlue.setText("");
            tvDarkMagenta.setText("");
            tvMagenta.setText("");
            tvTomato.setText("on");
            tvDarkShadeOfYellow.setText("");
            tvDarkPink.setText("");
            tvCyan.setText("");

        }else if (textViewOnText.equals("tvDarkShadeOfYellow")){
            tvCornFlowerBlue.setText("");
            tvWhite.setText("");
            tvMediumSeaGreen.setText("");
            tvLightBlue.setText("");
            tvDarkMagenta.setText("");
            tvMagenta.setText("");
            tvTomato.setText("");
            tvDarkShadeOfYellow.setText("on");
            tvDarkPink.setText("");
            tvCyan.setText("");

        }else if (textViewOnText.equals("tvDarkPink")){

            tvCornFlowerBlue.setText("");
            tvWhite.setText("");
            tvMediumSeaGreen.setText("");
            tvLightBlue.setText("");
            tvDarkMagenta.setText("");
            tvMagenta.setText("");
            tvTomato.setText("");
            tvDarkShadeOfYellow.setText("");
            tvDarkPink.setText("on");
            tvCyan.setText("");

        }else if (textViewOnText.equals("tvCyan")){

            tvCornFlowerBlue.setText("");
            tvWhite.setText("");
            tvMediumSeaGreen.setText("");
            tvLightBlue.setText("");
            tvDarkMagenta.setText("");
            tvMagenta.setText("");
            tvTomato.setText("");
            tvDarkShadeOfYellow.setText("");
            tvDarkPink.setText("");
            tvCyan.setText("on");

        }
    }

    private void setVibrate() {

        Boolean myVibrate = sharedPreferences.getBoolean(myDiceKeysAndValues.getVIBRATE_KEY(),
                true);

        if (myVibrate.equals(true)) {
            vibrate.setChecked(true);
        } else {
            vibrate.setChecked(false);
        }
    }

    private void setSpeakTotal() {

        Boolean mySpeakTotal = sharedPreferences.getBoolean(myDiceKeysAndValues.getSPEAK_TOTAL_KEY(),
                false);

        if (mySpeakTotal.equals(true)) {
            speakTotal.setChecked(true);
        } else {
            speakTotal.setChecked(false);
        }
    }

    private void setRollingSound() {

        Boolean myRollingSound = sharedPreferences.getBoolean(myDiceKeysAndValues.getROLLING_SOUND_KEY(),
                true);

        if (myRollingSound.equals(true)) {
            rollingSound.setChecked(true);
        } else {
            rollingSound.setChecked(false);
        }
    }

    private void setShakeToRoll(){

        Boolean myShakeToRoll = sharedPreferences.getBoolean(myDiceKeysAndValues.getSHAKE_TO_ROLL_KEY(),
                false);

        if (myShakeToRoll.equals(true)){
            shakeToRoll.setChecked(true);
        }else {
            shakeToRoll.setChecked(false);
        }

    }

    private void enableFullScreenToggle(){

        Boolean fullScreenToggle = sharedPreferences.getBoolean(myDiceKeysAndValues.getFULL_SCREEN_TOGGLE_KEY(),
                false);

        if (fullScreenToggle.equals(true)){
            fullScreenSwitch.setChecked(true);
            enableToggle.setText("Disable full screen toggle");
        }else {
            fullScreenSwitch.setChecked(false);
        }

    }




    private void chooseColorThemeFunction(){
        String chooseColorTheme = sharedPreferences.getString(myDiceKeysAndValues.getBACKGROUND_COLOR_KEY(),
                myDiceKeysAndValues.getWHITE());

        if (chooseColorTheme.equals(myDiceKeysAndValues.getCORN_FLOWER_BLUE())){
            mySettingsLayout.setBackgroundColor(Color.parseColor("#6495ED"));

        }else if (chooseColorTheme.equals(myDiceKeysAndValues.getWHITE())){
            mySettingsLayout.setBackgroundColor(Color.parseColor("#FFFFFF"));

        }else if (chooseColorTheme.equals(myDiceKeysAndValues.getMEDIUM_SEA_GREEN())){
            mySettingsLayout.setBackgroundColor(Color.parseColor("#3CB371"));

        }else if (chooseColorTheme.equals(myDiceKeysAndValues.getLIGHT_BLUE())){
            mySettingsLayout.setBackgroundColor(Color.parseColor("#ADD8E6"));

        }else if (chooseColorTheme.equals(myDiceKeysAndValues.getDARK_MAGENTA())){
            mySettingsLayout.setBackgroundColor(Color.parseColor("#8B008B"));

        }else if (chooseColorTheme.equals(myDiceKeysAndValues.getMAGENTA())){
            mySettingsLayout.setBackgroundColor(Color.parseColor("#FF00FF"));

        }else if (chooseColorTheme.equals(myDiceKeysAndValues.getTOMATO())){
            mySettingsLayout.setBackgroundColor(Color.parseColor("#FF6347"));

        }else if (chooseColorTheme.equals(myDiceKeysAndValues.getDARK_SHADE_OF_YELLOW())){
            mySettingsLayout.setBackgroundColor(Color.parseColor("#666600"));

        }else if (chooseColorTheme.equals(myDiceKeysAndValues.getDARK_PINK())){
            mySettingsLayout.setBackgroundColor(Color.parseColor("#FF1493"));

        }else if (chooseColorTheme.equals(myDiceKeysAndValues.getCYAN())){
            mySettingsLayout.setBackgroundColor(Color.parseColor("#00FFFF"));
        }

    }

    @Override
    public void onClick(View v) {


        String diceKey = "diceKey";
        String diceImageKey = "diceImageKey";





        switch (v.getId()) {

            // choose dice play numbers

            case R.id.btn_play_1_die:

                editor.putString(myDiceKeysAndValues.getDICE_KEY(), myDiceKeysAndValues.getPLAY1VALUE());
                editor.apply();
                FancyToast.makeText(this,
                        "Play using 1 die",
                        FancyToast.LENGTH_SHORT,
                        FancyToast.SUCCESS,
                        true).show();
                vibrator.vibrate(100);

                break;
            case R.id.btn_play_2_dice:
                editor.putString(myDiceKeysAndValues.getDICE_KEY(), myDiceKeysAndValues.getPLAY2VALUE());
                editor.apply();

                FancyToast.makeText(this,
                        "Play using 2 Dices",
                        FancyToast.LENGTH_SHORT,
                        FancyToast.SUCCESS,
                        true).show();
                vibrator.vibrate(100);

                break;
            case R.id.btn_play_3_dice:

                editor.putString(myDiceKeysAndValues.getDICE_KEY(),myDiceKeysAndValues.getPLAY3VALUE());
                editor.apply();

                FancyToast.makeText(this,
                        "Play using 3 Dices",
                        FancyToast.LENGTH_SHORT,
                        FancyToast.SUCCESS,
                        true).show();
                vibrator.vibrate(100);

                break;
            case R.id.btn_play_4_dice:
                editor.putString(myDiceKeysAndValues.getDICE_KEY(),myDiceKeysAndValues.getPLAY4VALUE());
                editor.apply();

                FancyToast.makeText(this,
                        "Play using 4 Dices",
                        FancyToast.LENGTH_SHORT,
                        FancyToast.SUCCESS,
                        true).show();
                vibrator.vibrate(100);

                break;
            case R.id.btn_play_5_dice:
                editor.putString(myDiceKeysAndValues.getDICE_KEY(),myDiceKeysAndValues.getPLAY5VALUE());
                editor.apply();

                FancyToast.makeText(this,
                        "Play using 5 Dices",
                        FancyToast.LENGTH_SHORT,
                        FancyToast.SUCCESS,
                        true).show();
                vibrator.vibrate(100);

                break;
            case R.id.btn_play_6_dice:
                editor.putString(myDiceKeysAndValues.getDICE_KEY(),myDiceKeysAndValues.getPLAY6VALUE());
                editor.apply();

                FancyToast.makeText(this,
                        "Play using 6 Dices",
                        FancyToast.LENGTH_SHORT,
                        FancyToast.SUCCESS,
                        true).show();
                vibrator.vibrate(100);

                break;


                // Choose Play Dice Images

            case R.id.iv_alea:
                editor.putString(myDiceKeysAndValues.getDICE_IMAGE_KEY(),myDiceKeysAndValues.getDICE_IMAGE_ALEA());
                editor.apply();

                FancyToast.makeText(this,
                        "Play using Alea dice images",
                        FancyToast.LENGTH_LONG,
                        FancyToast.CONFUSING,
                        R.drawable.alea_4,
                        false).show();
                vibrator.vibrate(100);

                break;

            case R.id.iv_alea_a:
                editor.putString(myDiceKeysAndValues.getDICE_IMAGE_KEY(),myDiceKeysAndValues.getDICE_IMAGE_ALEA_A());
                editor.apply();

                FancyToast.makeText(this,
                        "Play using Alea A dice images",
                        FancyToast.LENGTH_LONG,
                        FancyToast.CONFUSING,
                        R.drawable.alea_a4,
                        false).show();
                vibrator.vibrate(100);

                break;

            case R.id.iv_dado:
                editor.putString(myDiceKeysAndValues.getDICE_IMAGE_KEY(),myDiceKeysAndValues.getDICE_IMAGE_DADO());
                editor.apply();

                FancyToast.makeText(this,
                        "Play using Dado dice images",
                        FancyToast.LENGTH_LONG,
                        FancyToast.CONFUSING,
                        R.drawable.dado_4,
                        false).show();
                vibrator.vibrate(100);

                break;

            case R.id.iv_dice:
                editor.putString(myDiceKeysAndValues.getDICE_IMAGE_KEY(),myDiceKeysAndValues.getDICE_IMAGE_DICE());
                editor.apply();

                FancyToast.makeText(this,
                        "Play using Black dice images",
                        FancyToast.LENGTH_LONG,
                        FancyToast.CONFUSING,
                        R.drawable.dice_four_black,
                        false).show();
                vibrator.vibrate(100);

                break;

            case R.id.iv_dice_a_5sqb:
                editor.putString(myDiceKeysAndValues.getDICE_IMAGE_KEY(),myDiceKeysAndValues.getDICE_IMAGE_DICE_A_5SQB());
                editor.apply();

                FancyToast.makeText(this,
                        "Play using Dice A 5sqb dice images",
                        FancyToast.LENGTH_LONG,
                        FancyToast.CONFUSING,
                        R.drawable.dice4a,
                        false).show();
                vibrator.vibrate(100);

                break;

            case R.id.iv_dice_perspective:
                editor.putString(myDiceKeysAndValues.getDICE_IMAGE_KEY(),myDiceKeysAndValues.getDICE_IMAGE_DICE_5SQA());
                editor.apply();

                FancyToast.makeText(this,
                        "Play using Perspective dice images",
                        FancyToast.LENGTH_LONG,
                        FancyToast.CONFUSING,
                        R.drawable.perspective_dice_four,
                        false).show();
                vibrator.vibrate(100);

                break;

            case R.id.iv_dicey:
                editor.putString(myDiceKeysAndValues.getDICE_IMAGE_KEY(),myDiceKeysAndValues.getDICE_IMAGE_DICEY());
                editor.apply();

                FancyToast.makeText(this,
                        "Play using Dicey dice images",
                        FancyToast.LENGTH_LONG,
                        FancyToast.CONFUSING,
                        R.drawable.dicey_6,
                        false).show();
                vibrator.vibrate(100);

                break;

            case R.id.iv_terning:
                editor.putString(myDiceKeysAndValues.getDICE_IMAGE_KEY(),myDiceKeysAndValues.getDICE_IMAGE_TERNING());
                editor.apply();

                FancyToast.makeText(this,
                        "Play using Terning dice images",
                        FancyToast.LENGTH_LONG,
                        FancyToast.CONFUSING,
                        R.drawable.terning6,
                        false).show();
                vibrator.vibrate(100);

                break;

            case R.id.iv_kismet:
                editor.putString(myDiceKeysAndValues.getDICE_IMAGE_KEY(),myDiceKeysAndValues.getDICE_IMAGE_KISMET());
                editor.apply();

                FancyToast.makeText(this,
                        "Play using Kismet dice images",
                        FancyToast.LENGTH_LONG,
                        FancyToast.CONFUSING,
                        R.drawable.kismet_six,
                        false).show();
                vibrator.vibrate(100);

                break;

            case R.id.iv_u_plus:
                editor.putString(myDiceKeysAndValues.getDICE_IMAGE_KEY(),myDiceKeysAndValues.getDICE_IMAGE_U_PLUS());
                editor.apply();

                FancyToast.makeText(this,
                        "Play using U-PLUS dice images",
                        FancyToast.LENGTH_LONG,
                        FancyToast.CONFUSING,
                        R.drawable.u_plus4,
                        false).show();
                vibrator.vibrate(100);

                break;


                // CHOOSE BACKGROUND COLOR THEME

            case R.id.tvCornFlowerBlue:
                editor.putString(myDiceKeysAndValues.getBACKGROUND_COLOR_KEY(), myDiceKeysAndValues.getCORN_FLOWER_BLUE());


                mySettingsLayout.setBackgroundColor(Color.parseColor("#6495ED"));
                tvCornFlowerBlue.setText("on");
                editor.putString("textOnKey","tvCornFlowerBlue");
                editor.apply();

                tvWhite.setText("");
                tvMediumSeaGreen.setText("");
                tvLightBlue.setText("");
                tvDarkMagenta.setText("");
                tvMagenta.setText("");
                tvTomato.setText("");
                tvDarkShadeOfYellow.setText("");
                tvDarkPink.setText("");
                tvCyan.setText("");


                break;
            case R.id.tvWhite:
                editor.putString(myDiceKeysAndValues.getBACKGROUND_COLOR_KEY(), myDiceKeysAndValues.getWHITE());


                mySettingsLayout.setBackgroundColor(Color.parseColor("#FFFFFF"));

                tvCornFlowerBlue.setText("");
                tvWhite.setText("on");

                editor.putString("textOnKey","tvWhite");
                editor.apply();

                tvMediumSeaGreen.setText("");
                tvLightBlue.setText("");
                tvDarkMagenta.setText("");
                tvMagenta.setText("");
                tvTomato.setText("");
                tvDarkShadeOfYellow.setText("");
                tvDarkPink.setText("");
                tvCyan.setText("");

                break;
            case R.id.tvMediumSeaGreen:
                editor.putString(myDiceKeysAndValues.getBACKGROUND_COLOR_KEY(), myDiceKeysAndValues.getMEDIUM_SEA_GREEN());


                mySettingsLayout.setBackgroundColor(Color.parseColor("#3CB371"));


                tvCornFlowerBlue.setText("");
                tvWhite.setText("");
                tvMediumSeaGreen.setText("on");

                editor.putString("textOnKey","tvMediumSeaGreen");
                editor.apply();
                tvLightBlue.setText("");
                tvDarkMagenta.setText("");
                tvMagenta.setText("");
                tvTomato.setText("");
                tvDarkShadeOfYellow.setText("");
                tvDarkPink.setText("");
                tvCyan.setText("");

                break;
            case R.id.tvLightBlue:
                editor.putString(myDiceKeysAndValues.getBACKGROUND_COLOR_KEY(), myDiceKeysAndValues.getLIGHT_BLUE());


                mySettingsLayout.setBackgroundColor(Color.parseColor("#ADD8E6"));


                tvCornFlowerBlue.setText("");
                tvWhite.setText("");
                tvMediumSeaGreen.setText("");
                tvLightBlue.setText("on");

                editor.putString("textOnKey","tvLightBlue");
                editor.apply();
                tvDarkMagenta.setText("");
                tvMagenta.setText("");
                tvTomato.setText("");
                tvDarkShadeOfYellow.setText("");
                tvDarkPink.setText("");
                tvCyan.setText("");

                break;
            case R.id.tvDarkMagenta:
                editor.putString(myDiceKeysAndValues.getBACKGROUND_COLOR_KEY(), myDiceKeysAndValues.getDARK_MAGENTA());


                mySettingsLayout.setBackgroundColor(Color.parseColor("#8B008B"));


                tvCornFlowerBlue.setText("");
                tvWhite.setText("");
                tvMediumSeaGreen.setText("");
                tvLightBlue.setText("");
                tvDarkMagenta.setText("on");

                editor.putString("textOnKey","tvDarkMagenta");
                editor.apply();
                tvMagenta.setText("");
                tvTomato.setText("");
                tvDarkShadeOfYellow.setText("");
                tvDarkPink.setText("");
                tvCyan.setText("");

                break;
            case R.id.tvMagenta:
                editor.putString(myDiceKeysAndValues.getBACKGROUND_COLOR_KEY(), myDiceKeysAndValues.getMAGENTA());


                mySettingsLayout.setBackgroundColor(Color.parseColor("#FF00FF"));


                tvCornFlowerBlue.setText("");
                tvWhite.setText("");
                tvMediumSeaGreen.setText("");
                tvLightBlue.setText("");
                tvDarkMagenta.setText("");
                tvMagenta.setText("on");

                editor.putString("textOnKey","tvMagenta");
                editor.apply();
                tvTomato.setText("");
                tvDarkShadeOfYellow.setText("");
                tvDarkPink.setText("");
                tvCyan.setText("");

                break;
            case R.id.tvTomato:
                editor.putString(myDiceKeysAndValues.getBACKGROUND_COLOR_KEY(), myDiceKeysAndValues.getTOMATO());


                mySettingsLayout.setBackgroundColor(Color.parseColor("#FF6347"));

                tvCornFlowerBlue.setText("");
                tvWhite.setText("");
                tvMediumSeaGreen.setText("");
                tvLightBlue.setText("");
                tvDarkMagenta.setText("");
                tvMagenta.setText("");
                tvTomato.setText("on");

                editor.putString("textOnKey","tvTomato");
                editor.apply();
                tvDarkShadeOfYellow.setText("");
                tvDarkPink.setText("");
                tvCyan.setText("");

                break;
            case R.id.tvDarkShadeOfYellow:
                editor.putString(myDiceKeysAndValues.getBACKGROUND_COLOR_KEY(), myDiceKeysAndValues.getDARK_SHADE_OF_YELLOW());


                mySettingsLayout.setBackgroundColor(Color.parseColor("#666600"));

                tvCornFlowerBlue.setText("");
                tvWhite.setText("");
                tvMediumSeaGreen.setText("");
                tvLightBlue.setText("");
                tvDarkMagenta.setText("");
                tvMagenta.setText("");
                tvTomato.setText("");
                tvDarkShadeOfYellow.setText("on");

                editor.putString("textOnKey","tvDarkShadeOfYellow");
                editor.apply();
                tvDarkPink.setText("");
                tvCyan.setText("");

                break;
            case R.id.tvDarkPink:
                editor.putString(myDiceKeysAndValues.getBACKGROUND_COLOR_KEY(), myDiceKeysAndValues.getDARK_PINK());


                mySettingsLayout.setBackgroundColor(Color.parseColor("#FF1493"));

                tvCornFlowerBlue.setText("");
                tvWhite.setText("");
                tvMediumSeaGreen.setText("");
                tvLightBlue.setText("");
                tvDarkMagenta.setText("");
                tvMagenta.setText("");
                tvTomato.setText("");
                tvDarkShadeOfYellow.setText("");
                tvDarkPink.setText("on");

                editor.putString("textOnKey","tvDarkPink");
                editor.apply();
                tvCyan.setText("");

                break;
            case R.id.tvCyan:
                editor.putString(myDiceKeysAndValues.getBACKGROUND_COLOR_KEY(), myDiceKeysAndValues.getCYAN());

                mySettingsLayout.setBackgroundColor(Color.parseColor("#00FFFF"));

                tvCornFlowerBlue.setText("");
                tvWhite.setText("");
                tvMediumSeaGreen.setText("");
                tvLightBlue.setText("");
                tvDarkMagenta.setText("");
                tvMagenta.setText("");
                tvTomato.setText("");
                tvDarkShadeOfYellow.setText("");
                tvDarkPink.setText("");
                tvCyan.setText("on");

                editor.putString("textOnKey","tvCyan");
                editor.apply();

                break;


            // Experience


                case R.id.fullScreenSwitch:
                if (fullScreenSwitch.isChecked()) {
                    editor.putBoolean(myDiceKeysAndValues.getFULL_SCREEN_TOGGLE_KEY(), true);
                    enableToggle.setText("Disable full screen toggle");
                }else {
                    editor.putBoolean(myDiceKeysAndValues.getFULL_SCREEN_TOGGLE_KEY(), false);
                    enableToggle.setText("Enable full screen toggle");
                }
                editor.apply();
                break;


            case R.id.shakeToRoll:
                if (shakeToRoll.isChecked()) {
                    editor.putBoolean(myDiceKeysAndValues.getSHAKE_TO_ROLL_KEY(), true);
                }else {
                    editor.putBoolean(myDiceKeysAndValues.getSHAKE_TO_ROLL_KEY(), false);
                }
                editor.apply();
                break;

            case R.id.rollingSound:
                if (rollingSound.isChecked()) {
                    editor.putBoolean(myDiceKeysAndValues.getROLLING_SOUND_KEY(), true);
                }else {
                    editor.putBoolean(myDiceKeysAndValues.getROLLING_SOUND_KEY(), false);
                }
                editor.apply();
                break;

            case R.id.speakTotal:
                if (speakTotal.isChecked()) {
                    editor.putBoolean(myDiceKeysAndValues.getSPEAK_TOTAL_KEY(), true);
                }else {
                    editor.putBoolean(myDiceKeysAndValues.getSPEAK_TOTAL_KEY(), false);
                }
                editor.apply();
                break;

            case R.id.vibrate:
                if (vibrate.isChecked()) {
                    editor.putBoolean(myDiceKeysAndValues.getVIBRATE_KEY(), true);
                }else {
                    editor.putBoolean(myDiceKeysAndValues.getVIBRATE_KEY(), false);
                }
                editor.apply();
                break;


                // Reset Buttons

            case R.id.btn_reset_dice_options:
                editor.putString(myDiceKeysAndValues.getDICE_KEY(), myDiceKeysAndValues.getPLAY2VALUE());
                editor.putString(myDiceKeysAndValues.getDICE_IMAGE_KEY(),myDiceKeysAndValues.getDICE_IMAGE_KISMET());
                editor.apply();

                FancyToast.makeText(this,
                        "Dice Options reset to default",
                        FancyToast.LENGTH_LONG,
                        FancyToast.INFO,
                        true).show();
                break;

            case R.id.btn_theme_options:

                editor.putString(myDiceKeysAndValues.getBACKGROUND_COLOR_KEY(), myDiceKeysAndValues.getWHITE());
                mySettingsLayout.setBackgroundColor(Color.parseColor("#FFFFFF"));

                if (fullScreenSwitch.isChecked()){
                    editor.putBoolean(myDiceKeysAndValues.getFULL_SCREEN_TOGGLE_KEY(), false);
                    enableToggle.setText("Enable full screen toggle");
                }
                fullScreenSwitch.setChecked(false);
                editor.apply();

                tvCornFlowerBlue.setText("");
                tvWhite.setText("on");

                editor.putString("textOnKey","tvWhite");
                editor.apply();

                tvMediumSeaGreen.setText("");
                tvLightBlue.setText("");
                tvDarkMagenta.setText("");
                tvMagenta.setText("");
                tvTomato.setText("");
                tvDarkShadeOfYellow.setText("");
                tvDarkPink.setText("");
                tvCyan.setText("");

                FancyToast.makeText(this,
                        "Theme Options reset to default",
                        FancyToast.LENGTH_LONG,
                        FancyToast.INFO,
                        true).show();

                break;

            case R.id.btn_experience:

                if (shakeToRoll.isChecked()){
                    editor.putBoolean(myDiceKeysAndValues.getSHAKE_TO_ROLL_KEY(), false);
                    editor.apply();
                }
                shakeToRoll.setChecked(false);

                if (rollingSound.isChecked()) {
                    editor.putBoolean(myDiceKeysAndValues.getROLLING_SOUND_KEY(), true);
                    editor.apply();
                }
                rollingSound.setChecked(true);

                if (speakTotal.isChecked()){
                    editor.putBoolean(myDiceKeysAndValues.getSPEAK_TOTAL_KEY(), false);
                    editor.apply();
                }
                speakTotal.setChecked(false);


                if (vibrate.isChecked()) {
                    editor.putBoolean(myDiceKeysAndValues.getVIBRATE_KEY(), true);
                    editor.apply();
                }
                vibrate.setChecked(true);


                FancyToast.makeText(this,
                        "Experience reset to default",
                        FancyToast.LENGTH_LONG,
                        FancyToast.INFO,
                        true).show();

                break;

        }

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

         switch (buttonView.getId()){

             case R.id.rollingSound:

                 if (isChecked) {
                     editor.putBoolean(myDiceKeysAndValues.getROLLING_SOUND_KEY(), true);
                 }else {
                     editor.putBoolean(myDiceKeysAndValues.getROLLING_SOUND_KEY(), false);
                 }
                 editor.apply();

                 break;
             case R.id.vibrate:

                 if (isChecked) {
                     editor.putBoolean(myDiceKeysAndValues.getVIBRATE_KEY(), true);
                 }else {
                     editor.putBoolean(myDiceKeysAndValues.getVIBRATE_KEY(), false);
                 }
                 editor.apply();

                 break;
             case R.id.fullScreenSwitch:

                 if (isChecked) {
                     editor.putBoolean(myDiceKeysAndValues.getFULL_SCREEN_TOGGLE_KEY(), true);
                     enableToggle.setText("Disable full screen toggle");
                 }else {
                     editor.putBoolean(myDiceKeysAndValues.getFULL_SCREEN_TOGGLE_KEY(), false);
                     enableToggle.setText("Enable full screen toggle");
                 }
                 editor.apply();
                 break;

        }



    }
}