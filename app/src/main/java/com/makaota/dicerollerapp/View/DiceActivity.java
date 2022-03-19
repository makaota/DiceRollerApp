package com.makaota.dicerollerapp.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.makaota.dicerollerapp.Controller.DiceAdapter;
import com.makaota.dicerollerapp.Controller.FiveDiceAdapter;
import com.makaota.dicerollerapp.Controller.FourDiceAdapter;
import com.makaota.dicerollerapp.Controller.SixDiceAdapter;
import com.makaota.dicerollerapp.Controller.ThreeDiceAdapter;
import com.makaota.dicerollerapp.Controller.TwoDiceAdapter;
import com.makaota.dicerollerapp.Model.Dice;
import com.makaota.dicerollerapp.Model.MyDiceKeysAndValues;
import com.makaota.dicerollerapp.Model.ShakeDetector;
import com.makaota.dicerollerapp.R;
import com.shashank.sony.fancytoastlib.FancyToast;

import java.util.ArrayList;
import java.util.Random;

public class DiceActivity extends AppCompatActivity implements View.OnClickListener{


    /**
     * Date Developed           : 04/11/2021
     * Date Modified            : 21/12/2021
     * Developer FullName       : Seotsa Abram Makaota
     * Project Name             : Dice Roller App
     * Project Purpose          : To learn core android development fundamentals for Phones and Tablet
     *                            To Learn how to use the Model View Controller (MVC) Pattern
     *                            To Learn how to transition between phones and tablet using the saveInstances function
     *                            To learn about how to setup a recycler view, fragments and activities in the newest
     *                            version of android studio
     *                            and also to learn about a smooth user experience/design (UX) when developing mobile apps
     *
     *
     * About the app            : It's a dice roller/rolling dice app for board games
     *                            say you have a physical board game that requires maybe 1 to 6 dices to play the game
     *                            e.g(Monopoly, ludo, snake & ladder etc.)and it happens that you don't
     *                            have a physical die or dices to play one of this wonderful games we all love
     *                            that's where dice roller app comes in, to assist the user to play the game
     *                            without having to use a physical die or dices
     *                            this app is optimized for phones and tablets
     *
     * Features                 : This app represent StartActivity, DiceActivity and
     *                            SettingsActivity that has three features namely
     *                            1. Dice Options,
     *                            2. Theme Options,
     *                            3  User Experience
     *
     *                            START ACTIVITY
     *                            The Start Activity Screen is shown every time the app is opened
     *
     *                            DICE ACTIVITY
     *                            This Activity lets the user to roll the dice by tapping the dice image at the bottom or
     *                            by tapping game area of the screen, depending on the user settings of the game or app
     *                            based on the setting the user can choose to toggle between screens whether to view the
     *                            dice current results or not
     *
     *                            SETTINGS ACTIVITY
     *                            This activity presents the user with preferences settings,
     *                            DICE OPTIONS, THEME OPTIONS AND USER EXPERIENCE
     *
     *                            1. DICE OPTIONS
     *                            this feature let the users to choose how many dices they want to use from 1 die up to 6 dices
     *                            this feature also let the users choose dice images they want to play with.
     *                            the user can choose up to 10 different dice images
     *
     *                            2. THEME OPTIONS
     *                            this feature allows the users to choose background color themes between 10 different colors
     *                            this feature also allows the users to toggle from full screen mode on the main screen
     *                            3. EXPERIENCE
     *
     *                            This feature allows users to turn the shake detector on/off when rolling the dice
     *                            this feature also allows users to switch play sound on/off when tapping or shaking the device to roll the die/dice
     *                            this feature speaks the added total of the dices after each roll and users can turn that on/off
     *                            and lastly this feature can vibrate the device when tapping/shaking to roll and users can switch on/off if they want to
     *
     * Libraries used           : Shake Animation       implementation 'com.daimajia.androidanimations:library:2.4@aar'
     *                            Fancy Toast Messages  implementation 'io.github.shashank02051997:FancyToast:2.0.1'
     *
     *
     */


    /**
     * Image View variables here
     */
    private ImageView diceImage1;
    private ImageView diceImage2;
    private ImageView diceImage3;
    private ImageView diceImage4;
    private ImageView diceImage5;
    private ImageView diceImage6;
    private ImageView diceImage7;
    private ImageView diceImage8;
    private ImageView diceImage9;
    private ImageView iv_settings;
    /////////////////////////////////////////

    // Play button variable
    private ImageButton btnPlay;


    /**
     * Media Player Variables here
     */
    private MediaPlayer mp;
    private MediaPlayer one, two, three, four, five, six, seven, eight, nine, ten, elven, twelve, thirteen, fourteen, fifteen;
    private MediaPlayer sixteen, seventeen, eighteen, nineteen, twenty, twentyOne, twentyTwo, twentyThree, twentyFour;
    private MediaPlayer twentyFive, twentySix, twentySeven, twentyEight, twentyNine, thirty, thirtyOne, thirtyTwo;
    private MediaPlayer thirtyThree, thirtyFour, thirtyFive, thirtySix;

    // Random Object Variable
    private Random randObj;

    /**
     * My Random Variables here
     */
    private int myRandomNum1, myRandomNum2, myRandomNum3, myRandomNum4, myRandomNum5, myRandomNum6;
    private int myRandomNum7, myRandomNum8, myRandomNum9;

    /**
     * My dice values Variables here
     */
    private int dice1Value, dice2Value, dice3Value, dice4Value, dice5Value, dice6Value, dice7Value;
    private int dice8Value, dice9Value;


    /**
     * My Layout Variables here
     */
    private LinearLayout diceActivityLayout, layoutOfRecyclerView;
    private LinearLayout diceActivityLayout1, diceActivityLayout2, diceActivityLayout3;
    private ConstraintLayout layoutOfButtonAndSettings;


    /**
     * Dice Images Arrays here
     */
    private int[] aleaDiceImages = {R.drawable.alea_1, R.drawable.alea_2, R.drawable.alea_3, R.drawable.alea_4,
            R.drawable.alea_5, R.drawable.alea_6};

    private int[] alea_a_diceImage = {R.drawable.alea_a1, R.drawable.alea_a2, R.drawable.alea_a3, R.drawable.alea_a4,
            R.drawable.alea_a5, R.drawable.alea_a6};

    private int[] dadoDiceImage = {R.drawable.dado_1, R.drawable.dado_2, R.drawable.dado_3, R.drawable.dado_4,
            R.drawable.dado_5, R.drawable.dado_6};

    // Create a diceImage array
    private int[] diceImage = {R.drawable.dice_one_black, R.drawable.dice_two_black, R.drawable.dice_three_black, R.drawable.dice_four_black,
            R.drawable.dice_five_black, R.drawable.dice_six_black};

    private int[] dice_a_5sqb_diceImage = {R.drawable.dice1a, R.drawable.dice2a, R.drawable.dice3a, R.drawable.dice4a,
            R.drawable.dice5sqb, R.drawable.dice6a};

    private int[] perspective_diceImage = {R.drawable.perspective_dice_one, R.drawable.perspective_dice_two, R.drawable.perspective_dice_three, R.drawable.perspective_dice_four,
            R.drawable.perspective_dice_five, R.drawable.perspective_dice_six};

    private int[] diceyDiceImage = {R.drawable.dicey_1, R.drawable.dicey_2, R.drawable.dicey_3, R.drawable.dicey_4,
            R.drawable.dicey_5, R.drawable.dicey_6};

    private int[] kismetDiceImage = {R.drawable.kismet_ace, R.drawable.kismet_deuce, R.drawable.kismet_trey, R.drawable.kismet_four,
            R.drawable.kismet_five, R.drawable.kismet_six};

    private int[] terningDiceImage = {R.drawable.terning1, R.drawable.terning2, R.drawable.terning3, R.drawable.terning4,
            R.drawable.terning5, R.drawable.terning6};

    private int[] u_plusDiceImage = {R.drawable.u_plus1, R.drawable.u_plus2, R.drawable.u_plus3, R.drawable.u_plus4,
            R.drawable.u_plus5, R.drawable.u_plus6};

    /**---------------------------------------------------------------------------------------------------------------------------------**/

    /**
     * dice play keys here
     */
    private int dicePlayKeyValue;
    //private int playSixKey, playFiveKey, playFourKey, playThreeKey, playTwoKey, playOneKey;


    /**
     * My RecyclerView Variables here
     */
    private RecyclerView recyclerView, recyclerViewOfTwoDice, recyclerViewOfThreeDice, recyclerViewOfFourDice;
    private RecyclerView recyclerViewOfFiveDice, recyclerViewOfSixDice;

    /**
     * My RecyclerView Adapter Variables here
     */
    private RecyclerView.Adapter myAdapter, myAdapterOfTwoDice, myAdapterOfThreeDice, myAdapterOfFourDice;
    private RecyclerView.Adapter myAdapterOfFiveDice, myAdapterOfSixDice;


    /**
     * My RecyclerView LayoutManager Variables here
     */
    private RecyclerView.LayoutManager layoutManager, layoutManagerOfTwoDice, layoutManagerOfThreeDice;
    private RecyclerView.LayoutManager layoutManagerOfFourDice, layoutManagerOfFiveDice, layoutManagerOfSixDice;


    /**
     * My Arraylist of dice object Variables here
     */
    ArrayList<Dice> diceValues;
    ArrayList<Dice> diceValuesOfTwoDice;
    ArrayList<Dice> diceValuesOfThreeDice;
    ArrayList<Dice> diceValuesOfFourDice;
    ArrayList<Dice> diceValuesOfFiveDice;
    ArrayList<Dice> diceValuesOfSixDice;


    /**
     * My Sensor Variables here
     */
    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private ShakeDetector mShakeDetector;

    // My Dice Keys and Values variable
    private MyDiceKeysAndValues myDiceKeysAndValues;
    // My Vibrator variable
    private Vibrator vibrator;


    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice);

        getSupportActionBar().hide();


        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);

        myDiceKeysAndValues = new MyDiceKeysAndValues();

        initializeMediaPlayerVariables();

        initializeDiceImages();

        // RecyclerView of one die
        initializeRecyclerView_LayoutManager_And_ArrayList_Of_OneDie();

        // RecyclerView of Two Dice
        initializeRecyclerView_LayoutManager_And_ArrayList_Of_TwoDice();

        // RecyclerView of Three Dice

        initializeRecyclerView_LayoutManager_And_ArrayList_Of_ThreeDice();

        // RecyclerView of Four Dice
        initializeRecyclerView_LayoutManager_And_ArrayList_Of_FourDice();

        // RecyclerView of Five Dice
        initializeRecyclerView_LayoutManager_And_ArrayList_Of_FiveDice();

        // RecyclerView of Six Dice
        initializeRecyclerView_LayoutManager_And_ArrayList_Of_SixDice();


        // ShakeDetector initialization
        initializeDiceShakeDetectionSensor();

        initializeDicePlaySoundAndRandomObject();


        initializeSettingButton_And_LinearLayout_As_A_Button_And_SetOnclickListeners_For_Both();


        /**
         * check instance and get the values to be displayed once the device is rotated*/
        if (savedInstanceState != null) {
            myRandomNum1 = savedInstanceState.getInt("MY_RANDOM_NUM1_KEY");
            myRandomNum2 = savedInstanceState.getInt("MY_RANDOM_NUM2_KEY");
            myRandomNum3 = savedInstanceState.getInt("MY_RANDOM_NUM3_KEY");
            myRandomNum4 = savedInstanceState.getInt("MY_RANDOM_NUM4_KEY");
            myRandomNum5 = savedInstanceState.getInt("MY_RANDOM_NUM5_KEY");
            myRandomNum6 = savedInstanceState.getInt("MY_RANDOM_NUM6_KEY");
            myRandomNum7 = savedInstanceState.getInt("MY_RANDOM_NUM7_KEY");
            myRandomNum8 = savedInstanceState.getInt("MY_RANDOM_NUM8_KEY");
            myRandomNum9 = savedInstanceState.getInt("MY_RANDOM_NUM9_KEY");


            diceValues = savedInstanceState.getParcelableArrayList("KEY1");
            diceValuesOfTwoDice = savedInstanceState.getParcelableArrayList("KEY2");
            diceValuesOfThreeDice = savedInstanceState.getParcelableArrayList("KEY3");
            diceValuesOfFourDice = savedInstanceState.getParcelableArrayList("KEY4");
            diceValuesOfFiveDice = savedInstanceState.getParcelableArrayList("KEY5");
            diceValuesOfSixDice = savedInstanceState.getParcelableArrayList("KEY6");

            aleaDiceImages = savedInstanceState.getIntArray("alea");
            alea_a_diceImage = savedInstanceState.getIntArray("alea_a");
            dadoDiceImage = savedInstanceState.getIntArray("dado");
            diceImage = savedInstanceState.getIntArray("dice");
            dice_a_5sqb_diceImage = savedInstanceState.getIntArray("dice_5sqb");
            perspective_diceImage = savedInstanceState.getIntArray("perspective");
            diceyDiceImage = savedInstanceState.getIntArray("dicey");
            kismetDiceImage = savedInstanceState.getIntArray("kismet");
            u_plusDiceImage = savedInstanceState.getIntArray("u_plus");
            terningDiceImage = savedInstanceState.getIntArray("terning");


            myAdapter = new DiceAdapter( diceValues);
            layoutManager = new GridLayoutManager(this, 2, GridLayoutManager.HORIZONTAL, false);
            //layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(myAdapter);


            myAdapterOfTwoDice = new TwoDiceAdapter(diceValuesOfTwoDice);
            layoutManagerOfTwoDice = new GridLayoutManager(this, 2, GridLayoutManager.HORIZONTAL, false);
            //layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
            recyclerViewOfTwoDice.setLayoutManager(layoutManagerOfTwoDice);
            recyclerViewOfTwoDice.setAdapter(myAdapterOfTwoDice);


            myAdapterOfThreeDice = new ThreeDiceAdapter(diceValuesOfThreeDice);
            layoutManagerOfThreeDice = new LinearLayoutManager(this);
            //layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
            recyclerViewOfThreeDice.setLayoutManager(layoutManagerOfThreeDice);
            recyclerViewOfThreeDice.setAdapter(myAdapterOfThreeDice);


            myAdapterOfFourDice = new FourDiceAdapter(diceValuesOfFourDice);
            layoutManagerOfFourDice = new LinearLayoutManager(this);
            //layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
            recyclerViewOfFourDice.setLayoutManager(layoutManagerOfFourDice);
            recyclerViewOfFourDice.setAdapter(myAdapterOfFourDice);


            myAdapterOfFiveDice = new FiveDiceAdapter(diceValuesOfFiveDice);
            layoutManagerOfFiveDice = new LinearLayoutManager(this);
            //layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
            recyclerViewOfFiveDice.setLayoutManager(layoutManagerOfFiveDice);
            recyclerViewOfFiveDice.setAdapter(myAdapterOfFiveDice);


            myAdapterOfSixDice = new SixDiceAdapter(diceValuesOfSixDice);
            layoutManagerOfSixDice = new LinearLayoutManager(this);
            //layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
            recyclerViewOfSixDice.setLayoutManager(layoutManagerOfSixDice);
            recyclerViewOfSixDice.setAdapter(myAdapterOfSixDice);


            sharedPreferences = getSharedPreferences("prefs", MODE_PRIVATE);

            String diceImageKey = sharedPreferences.getString(myDiceKeysAndValues.getDICE_IMAGE_KEY()
                    , myDiceKeysAndValues.getDICE_IMAGE_KISMET());

            if (diceImageKey.equals(myDiceKeysAndValues.getDICE_IMAGE_KISMET())) {

                diceImage1.setImageResource(kismetDiceImage[myRandomNum1]);
                diceImage2.setImageResource(kismetDiceImage[myRandomNum2]);
                diceImage3.setImageResource(kismetDiceImage[myRandomNum3]);
                diceImage4.setImageResource(kismetDiceImage[myRandomNum4]);
                diceImage5.setImageResource(kismetDiceImage[myRandomNum5]);
                diceImage6.setImageResource(kismetDiceImage[myRandomNum6]);
                diceImage7.setImageResource(kismetDiceImage[myRandomNum7]);
                diceImage8.setImageResource(kismetDiceImage[myRandomNum8]);
                diceImage9.setImageResource(kismetDiceImage[myRandomNum9]);

            } else if (diceImageKey.equals(myDiceKeysAndValues.getDICE_IMAGE_ALEA())) {

                diceImage1.setImageResource(aleaDiceImages[myRandomNum1]);
                diceImage2.setImageResource(aleaDiceImages[myRandomNum2]);
                diceImage3.setImageResource(aleaDiceImages[myRandomNum3]);
                diceImage4.setImageResource(aleaDiceImages[myRandomNum4]);
                diceImage5.setImageResource(aleaDiceImages[myRandomNum5]);
                diceImage6.setImageResource(aleaDiceImages[myRandomNum6]);
                diceImage7.setImageResource(aleaDiceImages[myRandomNum7]);
                diceImage8.setImageResource(aleaDiceImages[myRandomNum8]);
                diceImage9.setImageResource(aleaDiceImages[myRandomNum9]);

            } else if (diceImageKey.equals(myDiceKeysAndValues.getDICE_IMAGE_ALEA_A())) {

                diceImage1.setImageResource(alea_a_diceImage[myRandomNum1]);
                diceImage2.setImageResource(alea_a_diceImage[myRandomNum2]);
                diceImage3.setImageResource(alea_a_diceImage[myRandomNum3]);
                diceImage4.setImageResource(alea_a_diceImage[myRandomNum4]);
                diceImage5.setImageResource(alea_a_diceImage[myRandomNum5]);
                diceImage6.setImageResource(alea_a_diceImage[myRandomNum6]);
                diceImage7.setImageResource(alea_a_diceImage[myRandomNum7]);
                diceImage8.setImageResource(alea_a_diceImage[myRandomNum8]);
                diceImage9.setImageResource(alea_a_diceImage[myRandomNum9]);


            } else if (diceImageKey.equals(myDiceKeysAndValues.getDICE_IMAGE_DADO())) {

                diceImage1.setImageResource(dadoDiceImage[myRandomNum1]);
                diceImage2.setImageResource(dadoDiceImage[myRandomNum2]);
                diceImage3.setImageResource(dadoDiceImage[myRandomNum3]);
                diceImage4.setImageResource(dadoDiceImage[myRandomNum4]);
                diceImage5.setImageResource(dadoDiceImage[myRandomNum5]);
                diceImage6.setImageResource(dadoDiceImage[myRandomNum6]);
                diceImage7.setImageResource(dadoDiceImage[myRandomNum7]);
                diceImage8.setImageResource(dadoDiceImage[myRandomNum8]);
                diceImage9.setImageResource(dadoDiceImage[myRandomNum9]);

            } else if (diceImageKey.equals(myDiceKeysAndValues.getDICE_IMAGE_DICE())) {

                // black dice
                diceImage1.setImageResource(diceImage[myRandomNum1]);
                diceImage2.setImageResource(diceImage[myRandomNum2]);
                diceImage3.setImageResource(diceImage[myRandomNum3]);
                diceImage4.setImageResource(diceImage[myRandomNum4]);
                diceImage5.setImageResource(diceImage[myRandomNum5]);
                diceImage6.setImageResource(diceImage[myRandomNum6]);
                diceImage7.setImageResource(diceImage[myRandomNum7]);
                diceImage8.setImageResource(diceImage[myRandomNum8]);
                diceImage9.setImageResource(diceImage[myRandomNum9]);

            } else if (diceImageKey.equals(myDiceKeysAndValues.getDICE_IMAGE_DICE_A_5SQB())) {

                diceImage1.setImageResource(dice_a_5sqb_diceImage[myRandomNum1]);
                diceImage2.setImageResource(dice_a_5sqb_diceImage[myRandomNum2]);
                diceImage3.setImageResource(dice_a_5sqb_diceImage[myRandomNum3]);
                diceImage4.setImageResource(dice_a_5sqb_diceImage[myRandomNum4]);
                diceImage5.setImageResource(dice_a_5sqb_diceImage[myRandomNum5]);
                diceImage6.setImageResource(dice_a_5sqb_diceImage[myRandomNum6]);
                diceImage7.setImageResource(dice_a_5sqb_diceImage[myRandomNum7]);
                diceImage8.setImageResource(dice_a_5sqb_diceImage[myRandomNum8]);
                diceImage9.setImageResource(dice_a_5sqb_diceImage[myRandomNum9]);


            } else if (diceImageKey.equals(myDiceKeysAndValues.getDICE_IMAGE_DICE_5SQA())) {

                diceImage1.setImageResource(perspective_diceImage[myRandomNum1]);
                diceImage2.setImageResource(perspective_diceImage[myRandomNum2]);
                diceImage3.setImageResource(perspective_diceImage[myRandomNum3]);
                diceImage4.setImageResource(perspective_diceImage[myRandomNum4]);
                diceImage5.setImageResource(perspective_diceImage[myRandomNum5]);
                diceImage6.setImageResource(perspective_diceImage[myRandomNum6]);
                diceImage7.setImageResource(perspective_diceImage[myRandomNum7]);
                diceImage8.setImageResource(perspective_diceImage[myRandomNum8]);
                diceImage9.setImageResource(perspective_diceImage[myRandomNum9]);

            } else if (diceImageKey.equals(myDiceKeysAndValues.getDICE_IMAGE_DICEY())) {

                diceImage1.setImageResource(diceyDiceImage[myRandomNum1]);
                diceImage2.setImageResource(diceyDiceImage[myRandomNum2]);
                diceImage3.setImageResource(diceyDiceImage[myRandomNum3]);
                diceImage4.setImageResource(diceyDiceImage[myRandomNum4]);
                diceImage5.setImageResource(diceyDiceImage[myRandomNum5]);
                diceImage6.setImageResource(diceyDiceImage[myRandomNum6]);
                diceImage7.setImageResource(diceyDiceImage[myRandomNum7]);
                diceImage8.setImageResource(diceyDiceImage[myRandomNum8]);
                diceImage9.setImageResource(diceyDiceImage[myRandomNum9]);

            } else if (diceImageKey.equals(myDiceKeysAndValues.getDICE_IMAGE_TERNING())) {

                diceImage1.setImageResource(terningDiceImage[myRandomNum1]);
                diceImage2.setImageResource(terningDiceImage[myRandomNum2]);
                diceImage3.setImageResource(terningDiceImage[myRandomNum3]);
                diceImage4.setImageResource(terningDiceImage[myRandomNum4]);
                diceImage5.setImageResource(terningDiceImage[myRandomNum5]);
                diceImage6.setImageResource(terningDiceImage[myRandomNum6]);
                diceImage7.setImageResource(terningDiceImage[myRandomNum7]);
                diceImage8.setImageResource(terningDiceImage[myRandomNum8]);
                diceImage9.setImageResource(terningDiceImage[myRandomNum9]);


            } else if (diceImageKey.equals(myDiceKeysAndValues.getDICE_IMAGE_U_PLUS())) {

                diceImage1.setImageResource(u_plusDiceImage[myRandomNum1]);
                diceImage2.setImageResource(u_plusDiceImage[myRandomNum2]);
                diceImage3.setImageResource(u_plusDiceImage[myRandomNum3]);
                diceImage4.setImageResource(u_plusDiceImage[myRandomNum4]);
                diceImage5.setImageResource(u_plusDiceImage[myRandomNum5]);
                diceImage6.setImageResource(u_plusDiceImage[myRandomNum6]);
                diceImage7.setImageResource(u_plusDiceImage[myRandomNum7]);
                diceImage8.setImageResource(u_plusDiceImage[myRandomNum8]);
                diceImage9.setImageResource(u_plusDiceImage[myRandomNum9]);

            }

        }

    }

    private void initializeSettingButton_And_LinearLayout_As_A_Button_And_SetOnclickListeners_For_Both() {
        iv_settings = findViewById(R.id.iv_settings);
        iv_settings.setOnClickListener(this);
        btnPlay = findViewById(R.id.btn_play);
        btnPlay.setOnClickListener(this);

        layoutOfRecyclerView = findViewById(R.id.layoutOfRecyclerView);

        layoutOfButtonAndSettings = findViewById(R.id.layoutOfButtonAndSettings);

        diceActivityLayout = findViewById(R.id.diceActivityLayout);
        diceActivityLayout1 = findViewById(R.id.diceActivityLayout1);
        diceActivityLayout2 = findViewById(R.id.diceActivityLayout2);
        diceActivityLayout3 = findViewById(R.id.diceActivityLayout3);
        diceActivityLayout.setOnClickListener(this);
        diceActivityLayout1.setOnClickListener(this);
        diceActivityLayout2.setOnClickListener(this);
        diceActivityLayout3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {


        switch (v.getId()) {
            case R.id.btn_play:
            case R.id.diceActivityLayout1:
            case R.id.diceActivityLayout2:
            case R.id.diceActivityLayout3:

                if (dicePlayKeyValue == 6) {
                    initializeDicePlayUsingKeysAndValuesFromSharedPreference();
                } else if (dicePlayKeyValue == 5) {
                    initializeDicePlayUsingKeysAndValuesFromSharedPreference();
                } else if (dicePlayKeyValue == 4) {
                    initializeDicePlayUsingKeysAndValuesFromSharedPreference();
                } else if (dicePlayKeyValue == 3) {
                    initializeDicePlayUsingKeysAndValuesFromSharedPreference();
                } else if (dicePlayKeyValue == 2) {
                    initializeDicePlayUsingKeysAndValuesFromSharedPreference();
                } else if (dicePlayKeyValue == 1) {
                    initializeDicePlayUsingKeysAndValuesFromSharedPreference();
                }
                break;
            case R.id.iv_settings:

                Intent settingsPageIntent = new Intent(DiceActivity.this, SettingsActivity.class);
                startActivity(settingsPageIntent);
                break;
        }
    }

    private void initializeDicePlaySoundAndRandomObject() {

        mp = MediaPlayer.create(this, R.raw.dice_sound);
        randObj = new Random();
    }


    private void initializeDiceShakeDetectionSensor() {
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mAccelerometer = mSensorManager
                .getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mShakeDetector = new ShakeDetector();
        mShakeDetector.setOnShakeListener(new ShakeDetector.OnShakeListener() {

            @Override
            public void onShake(int count) {
                /*
                 * The following method, "handleShakeEvent(count):" is a stub //
                 * method you would use to setup whatever you want done once the
                 * device has been shook.
                 */
                handleShakeEvent();
            }
        });
    }

    /**
     * void initializeDicePlayUsingKeysAndValuesFromSharedPreference()
     * this function gets sharedPreferences from the application MODE PRIVATE
     * and then it declares a variable of type string called playDiceKey
     * then playDiceKey uses sharedPreferences to get the dice key from the object called
     * myDiceKeysAndValues variable
     * <p>
     * this function then checks which playValue is being used either 1,2,3,4,5 or 6
     * and then it will initialize the play according to the number of dices being used
     * <p>
     * after initializing which to play the app needs to play
     * for that to happen this function needs to call another function after each check condition
     * which is either playOneDie(diceImage5); playTwoDice(diceImage4,diceImage6); playThreeDice(diceImage2,diceImage5,diceImage8);
     * etc
     * <p>
     * Basically this function is the one that plays the entire dice game or app
     * <p>
     * Function calls
     * at the time of this comment its about 12 usages
     * 1.  public void onClick(View v)
     * 2. private void handleShakeEvent()
     */


    public void setPlay1DiceVisibility() {


        diceImage1.setVisibility(View.GONE);
        diceImage2.setVisibility(View.GONE);
        diceImage3.setVisibility(View.GONE);
        diceImage4.setVisibility(View.GONE);
        diceImage6.setVisibility(View.GONE);
        diceImage7.setVisibility(View.GONE);
        diceImage8.setVisibility(View.GONE);
        diceImage9.setVisibility(View.GONE);
        diceImage5.setVisibility(View.VISIBLE);


    }

    public void setPlay2DiceVisibility() {


        diceImage1.setVisibility(View.GONE);
        diceImage2.setVisibility(View.GONE);
        diceImage3.setVisibility(View.GONE);
        diceImage5.setVisibility(View.GONE);
        diceImage7.setVisibility(View.GONE);
        diceImage8.setVisibility(View.GONE);
        diceImage9.setVisibility(View.GONE);
        diceImage4.setVisibility(View.VISIBLE);
        diceImage6.setVisibility(View.VISIBLE);


    }

    public void setPlay3DiceVisibility() {


        diceImage1.setVisibility(View.GONE);
        diceImage3.setVisibility(View.GONE);
        diceImage4.setVisibility(View.GONE);
        diceImage6.setVisibility(View.GONE);
        diceImage7.setVisibility(View.GONE);
        diceImage9.setVisibility(View.GONE);
        diceImage2.setVisibility(View.VISIBLE);
        diceImage5.setVisibility(View.VISIBLE);
        diceImage8.setVisibility(View.VISIBLE);
    }

    public void setPlay4DiceVisibility() {


        diceImage2.setVisibility(View.GONE);
        diceImage4.setVisibility(View.GONE);
        diceImage5.setVisibility(View.GONE);
        diceImage6.setVisibility(View.GONE);
        diceImage8.setVisibility(View.GONE);
        diceImage1.setVisibility(View.VISIBLE);
        diceImage3.setVisibility(View.VISIBLE);
        diceImage7.setVisibility(View.VISIBLE);
        diceImage9.setVisibility(View.VISIBLE);
    }

    public void setPlay5DiceVisibility() {


        diceImage2.setVisibility(View.GONE);
        diceImage4.setVisibility(View.GONE);
        diceImage6.setVisibility(View.GONE);
        diceImage8.setVisibility(View.GONE);

        diceImage1.setVisibility(View.VISIBLE);
        diceImage3.setVisibility(View.VISIBLE);
        diceImage5.setVisibility(View.VISIBLE);
        diceImage7.setVisibility(View.VISIBLE);
        diceImage9.setVisibility(View.VISIBLE);

    }

    public void setPlay6DiceVisibility() {


        diceImage2.setVisibility(View.GONE);
        diceImage5.setVisibility(View.GONE);
        diceImage8.setVisibility(View.GONE);

        diceImage1.setVisibility(View.VISIBLE);
        diceImage3.setVisibility(View.VISIBLE);
        diceImage4.setVisibility(View.VISIBLE);
        diceImage6.setVisibility(View.VISIBLE);
        diceImage7.setVisibility(View.VISIBLE);
        diceImage9.setVisibility(View.VISIBLE);

    }

    private void initializeDicePlayUsingKeysAndValuesFromSharedPreference() {


        sharedPreferences = getSharedPreferences("prefs", MODE_PRIVATE);
        String playDiceKey;
        playDiceKey = sharedPreferences.getString(myDiceKeysAndValues.getDICE_KEY(),
                myDiceKeysAndValues.getPLAY2VALUE());

        if (playDiceKey.equals(myDiceKeysAndValues.getPLAY1VALUE())) {
            dicePlayKeyValue = 1;
            setPlay1DiceVisibility();
            playOneDie(diceImage5);
            myAdapter.notifyDataSetChanged();


        } else if (playDiceKey.equals(myDiceKeysAndValues.getPLAY2VALUE())) {

            dicePlayKeyValue = 2;
            setPlay2DiceVisibility();
            playTwoDice(diceImage4, diceImage6);
            myAdapterOfTwoDice.notifyDataSetChanged();

        } else if (playDiceKey.equals(myDiceKeysAndValues.getPLAY3VALUE())) {

            dicePlayKeyValue = 3;
            setPlay3DiceVisibility();
            playThreeDice(diceImage2, diceImage5, diceImage8);
            myAdapterOfThreeDice.notifyDataSetChanged();
        } else if (playDiceKey.equals(myDiceKeysAndValues.getPLAY4VALUE())) {

            dicePlayKeyValue = 4;
            setPlay4DiceVisibility();
            playFourDice(diceImage1, diceImage3, diceImage7, diceImage9);
            myAdapterOfFourDice.notifyDataSetChanged();

        } else if (playDiceKey.equals(myDiceKeysAndValues.getPLAY5VALUE())) {

            dicePlayKeyValue = 5;
            setPlay5DiceVisibility();

            playFiveDice(diceImage1, diceImage3, diceImage5, diceImage7, diceImage9);
            myAdapterOfFiveDice.notifyDataSetChanged();
        } else if (playDiceKey.equals(myDiceKeysAndValues.getPLAY6VALUE())) {

            dicePlayKeyValue = 6;
            setPlay6DiceVisibility();
            playSixDice(diceImage1, diceImage3, diceImage4, diceImage6, diceImage7, diceImage9);
            myAdapterOfSixDice.notifyDataSetChanged();


        }
    }

    private void initializeRecyclerView_LayoutManager_And_ArrayList_Of_SixDice() {

        recyclerViewOfSixDice = findViewById(R.id.list);
        recyclerViewOfSixDice.setHasFixedSize(true);
        diceValuesOfSixDice = new ArrayList<Dice>();
    }

    private void initializeRecyclerView_LayoutManager_And_ArrayList_Of_FiveDice() {

        recyclerViewOfFiveDice = findViewById(R.id.list);
        recyclerViewOfFiveDice.setHasFixedSize(true);
        diceValuesOfFiveDice = new ArrayList<Dice>();
    }

    private void initializeRecyclerView_LayoutManager_And_ArrayList_Of_FourDice() {

        recyclerViewOfFourDice = findViewById(R.id.list);
        recyclerViewOfFourDice.setHasFixedSize(true);
        diceValuesOfFourDice = new ArrayList<Dice>();
    }

    private void initializeRecyclerView_LayoutManager_And_ArrayList_Of_ThreeDice() {

        recyclerViewOfThreeDice = findViewById(R.id.list);
        recyclerViewOfThreeDice.setHasFixedSize(true);
        diceValuesOfThreeDice = new ArrayList<Dice>();

    }

    private void initializeRecyclerView_LayoutManager_And_ArrayList_Of_TwoDice() {

        recyclerViewOfTwoDice = findViewById(R.id.list);
        recyclerViewOfTwoDice.setHasFixedSize(true);
        diceValuesOfTwoDice = new ArrayList<Dice>();

    }

    private void initializeRecyclerView_LayoutManager_And_ArrayList_Of_OneDie() {
        recyclerView = findViewById(R.id.list);
        recyclerView.setHasFixedSize(true);
        diceValues = new ArrayList<Dice>();
    }

    private void initializeDiceImages() {

        diceImage1 = findViewById(R.id.imgDice1);
        diceImage2 = findViewById(R.id.imgDice2);
        diceImage3 = findViewById(R.id.imgDice3);
        diceImage4 = findViewById(R.id.imgDice4);
        diceImage5 = findViewById(R.id.imgDice5);
        diceImage6 = findViewById(R.id.imgDice6);

        diceImage7 = findViewById(R.id.imgDice7);
        diceImage8 = findViewById(R.id.imgDice8);
        diceImage9 = findViewById(R.id.imgDice9);


    }

    private void initializeMediaPlayerVariables() {

        one = MediaPlayer.create(this, R.raw.one);
        two = MediaPlayer.create(this, R.raw.two);
        three = MediaPlayer.create(this, R.raw.three);
        four = MediaPlayer.create(this, R.raw.four);
        five = MediaPlayer.create(this, R.raw.five);
        six = MediaPlayer.create(this, R.raw.six);
        seven = MediaPlayer.create(this, R.raw.seven);
        eight = MediaPlayer.create(this, R.raw.eight);
        nine = MediaPlayer.create(this, R.raw.nine);
        ten = MediaPlayer.create(this, R.raw.ten);
        elven = MediaPlayer.create(this, R.raw.eleven);
        twelve = MediaPlayer.create(this, R.raw.twelve);
        thirteen = MediaPlayer.create(this, R.raw.thirteen);
        fourteen = MediaPlayer.create(this, R.raw.fourteen);
        fifteen = MediaPlayer.create(this, R.raw.fiveteen);
        sixteen = MediaPlayer.create(this, R.raw.sixteen);
        seventeen = MediaPlayer.create(this, R.raw.seventeen);
        eighteen = MediaPlayer.create(this, R.raw.eighteen);
        nineteen = MediaPlayer.create(this, R.raw.nineteen);
        twenty = MediaPlayer.create(this, R.raw.twenty);
        twentyOne = MediaPlayer.create(this, R.raw.twentyone);
        twentyTwo = MediaPlayer.create(this, R.raw.twentytwo);
        twentyThree = MediaPlayer.create(this, R.raw.twentythree);
        twentyFour = MediaPlayer.create(this, R.raw.twentyfour);
        twentyFive = MediaPlayer.create(this, R.raw.twentyfive);
        twentySix = MediaPlayer.create(this, R.raw.twentysix);
        twentySeven = MediaPlayer.create(this, R.raw.twentyseven);
        twentyEight = MediaPlayer.create(this, R.raw.twentyeight);
        twentyNine = MediaPlayer.create(this, R.raw.twentynine);
        thirty = MediaPlayer.create(this, R.raw.thirty);
        thirtyOne = MediaPlayer.create(this, R.raw.thirtyone);
        thirtyTwo = MediaPlayer.create(this, R.raw.thirtytwo);
        thirtyThree = MediaPlayer.create(this, R.raw.thirtythree);
        thirtyFour = MediaPlayer.create(this, R.raw.thirtyfour);
        thirtyFive = MediaPlayer.create(this, R.raw.thirtyfive);
        thirtySix = MediaPlayer.create(this, R.raw.thirtysix);

    }

    private void handleShakeEvent() {

        sharedPreferences = getSharedPreferences("prefs", MODE_PRIVATE);
        Boolean shakeToRollKey = sharedPreferences.getBoolean(myDiceKeysAndValues.getSHAKE_TO_ROLL_KEY(), false);

        if (!shakeToRollKey) {
            FancyToast.makeText(this,
                    "Hello!\nShake to roll is turned off",
                    FancyToast.LENGTH_LONG,
                    FancyToast.ERROR,
                    true).show();
        }

        // Shake is on

        if (shakeToRollKey) {

            if (dicePlayKeyValue == 6) {

                initializeDicePlayUsingKeysAndValuesFromSharedPreference();
            } else if (dicePlayKeyValue == 5) {

                initializeDicePlayUsingKeysAndValuesFromSharedPreference();

            } else if (dicePlayKeyValue == 4) {

                initializeDicePlayUsingKeysAndValuesFromSharedPreference();

            } else if (dicePlayKeyValue == 3) {

                initializeDicePlayUsingKeysAndValuesFromSharedPreference();

            } else if (dicePlayKeyValue == 2) {

                initializeDicePlayUsingKeysAndValuesFromSharedPreference();

            } else if (dicePlayKeyValue == 1) {

                initializeDicePlayUsingKeysAndValuesFromSharedPreference();

            }
        } else {

            // Shake is off
        }
    }


    private void enableFullScreenToggle() {

        Boolean fullScreenToggle = sharedPreferences.getBoolean(myDiceKeysAndValues.getFULL_SCREEN_TOGGLE_KEY(),
                false);

        if (fullScreenToggle.equals(true)) {
            layoutOfRecyclerView.setVisibility(View.GONE);
            layoutOfButtonAndSettings.setVisibility(View.GONE);
            iv_settings.setVisibility(View.VISIBLE);
        } else {
            layoutOfRecyclerView.setVisibility(View.VISIBLE);
            layoutOfButtonAndSettings.setVisibility(View.VISIBLE);
        }

    }


    private void chooseColorThemeFunction() {

        String chooseColorTheme = sharedPreferences.getString(myDiceKeysAndValues.getBACKGROUND_COLOR_KEY(),
                myDiceKeysAndValues.getWHITE());

        if (chooseColorTheme.equals(myDiceKeysAndValues.getCORN_FLOWER_BLUE())) {
            diceActivityLayout.setBackgroundColor(Color.parseColor("#6495ED"));

        } else if (chooseColorTheme.equals(myDiceKeysAndValues.getWHITE())) {
            diceActivityLayout.setBackgroundColor(Color.parseColor("#FFFFFF"));

        } else if (chooseColorTheme.equals(myDiceKeysAndValues.getMEDIUM_SEA_GREEN())) {
            diceActivityLayout.setBackgroundColor(Color.parseColor("#3CB371"));

        } else if (chooseColorTheme.equals(myDiceKeysAndValues.getLIGHT_BLUE())) {
            diceActivityLayout.setBackgroundColor(Color.parseColor("#ADD8E6"));

        } else if (chooseColorTheme.equals(myDiceKeysAndValues.getDARK_MAGENTA())) {
            diceActivityLayout.setBackgroundColor(Color.parseColor("#8B008B"));

        } else if (chooseColorTheme.equals(myDiceKeysAndValues.getMAGENTA())) {
            diceActivityLayout.setBackgroundColor(Color.parseColor("#FF00FF"));

        } else if (chooseColorTheme.equals(myDiceKeysAndValues.getTOMATO())) {
            diceActivityLayout.setBackgroundColor(Color.parseColor("#FF6347"));

        } else if (chooseColorTheme.equals(myDiceKeysAndValues.getDARK_SHADE_OF_YELLOW())) {
            diceActivityLayout.setBackgroundColor(Color.parseColor("#666600"));

        } else if (chooseColorTheme.equals(myDiceKeysAndValues.getDARK_PINK())) {
            diceActivityLayout.setBackgroundColor(Color.parseColor("#FF1493"));

        } else if (chooseColorTheme.equals(myDiceKeysAndValues.getCYAN())) {
            diceActivityLayout.setBackgroundColor(Color.parseColor("#00FFFF"));
        }

    }

    @Override
    public void onBackPressed() {

        Dialog customExitDialog = new Dialog(this);
        customExitDialog.getWindow().setLayout(WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT);

        customExitDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        customExitDialog.getWindow().getAttributes().windowAnimations = android.R.style.Animation_Dialog;
        customExitDialog.setContentView(R.layout.exit_dialog_layout);

        TextView yesBtn = customExitDialog.findViewById(R.id.btnYes);
        TextView noBtn = customExitDialog.findViewById(R.id.btnNo);


        yesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

        noBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customExitDialog.cancel();
            }
        });

        customExitDialog.show();
    }

    private void setDiceImageOfOneDie() {

        sharedPreferences = getSharedPreferences("prefs", MODE_PRIVATE);
        String playDiceImageKey = sharedPreferences.getString(myDiceKeysAndValues.getDICE_IMAGE_KEY(),
                myDiceKeysAndValues.getDICE_IMAGE_KISMET());

        dicePlayKeyValue = 1;

        if (playDiceImageKey.equals(myDiceKeysAndValues.getDICE_IMAGE_ALEA())) {
            diceImage5.setImageResource(aleaDiceImages[myRandomNum5]);
        } else if (playDiceImageKey.equals(myDiceKeysAndValues.getDICE_IMAGE_ALEA_A())) {
            diceImage5.setImageResource(alea_a_diceImage[myRandomNum5]);
        } else if (playDiceImageKey.equals(myDiceKeysAndValues.getDICE_IMAGE_DADO())) {
            diceImage5.setImageResource(dadoDiceImage[myRandomNum5]);
        } else if (playDiceImageKey.equals(myDiceKeysAndValues.getDICE_IMAGE_KISMET())) {
            diceImage5.setImageResource(kismetDiceImage[myRandomNum5]);
        } else if (playDiceImageKey.equals(myDiceKeysAndValues.getDICE_IMAGE_DICE_A_5SQB())) {
            diceImage5.setImageResource(dice_a_5sqb_diceImage[myRandomNum5]);
        } else if (playDiceImageKey.equals(myDiceKeysAndValues.getDICE_IMAGE_DICE_5SQA())) {
            diceImage5.setImageResource(perspective_diceImage[myRandomNum5]);
        } else if (playDiceImageKey.equals(myDiceKeysAndValues.getDICE_IMAGE_DICEY())) {
            diceImage5.setImageResource(diceyDiceImage[myRandomNum5]);
        } else if (playDiceImageKey.equals(myDiceKeysAndValues.getDICE_IMAGE_DICE())) {
            diceImage5.setImageResource(diceImage[myRandomNum5]);
        } else if (playDiceImageKey.equals(myDiceKeysAndValues.getDICE_IMAGE_TERNING())) {
            diceImage5.setImageResource(terningDiceImage[myRandomNum5]);
        } else if (playDiceImageKey.equals(myDiceKeysAndValues.getDICE_IMAGE_U_PLUS())) {
            diceImage5.setImageResource(u_plusDiceImage[myRandomNum5]);
        }
    }

    private void setDiceImageOfTwoDice() {

        sharedPreferences = getSharedPreferences("prefs", MODE_PRIVATE);
        String playDiceImageKey = sharedPreferences.getString(myDiceKeysAndValues.getDICE_IMAGE_KEY(),
                myDiceKeysAndValues.getDICE_IMAGE_KISMET());

        dicePlayKeyValue = 2;

        if (playDiceImageKey.equals(myDiceKeysAndValues.getDICE_IMAGE_ALEA())) {
            diceImage4.setImageResource(aleaDiceImages[myRandomNum4]);
            diceImage6.setImageResource(aleaDiceImages[myRandomNum6]);
        } else if (playDiceImageKey.equals(myDiceKeysAndValues.getDICE_IMAGE_ALEA_A())) {
            diceImage4.setImageResource(alea_a_diceImage[myRandomNum4]);
            diceImage6.setImageResource(alea_a_diceImage[myRandomNum6]);
        } else if (playDiceImageKey.equals(myDiceKeysAndValues.getDICE_IMAGE_DADO())) {
            diceImage4.setImageResource(dadoDiceImage[myRandomNum4]);
            diceImage6.setImageResource(dadoDiceImage[myRandomNum6]);

        } else if (playDiceImageKey.equals(myDiceKeysAndValues.getDICE_IMAGE_KISMET())) {
            diceImage4.setImageResource(kismetDiceImage[myRandomNum4]);
            diceImage6.setImageResource(kismetDiceImage[myRandomNum6]);
        } else if (playDiceImageKey.equals(myDiceKeysAndValues.getDICE_IMAGE_DICE_A_5SQB())) {
            diceImage4.setImageResource(dice_a_5sqb_diceImage[myRandomNum4]);
            diceImage6.setImageResource(dice_a_5sqb_diceImage[myRandomNum6]);
        } else if (playDiceImageKey.equals(myDiceKeysAndValues.getDICE_IMAGE_DICE_5SQA())) {
            diceImage4.setImageResource(perspective_diceImage[myRandomNum4]);
            diceImage6.setImageResource(perspective_diceImage[myRandomNum6]);
        } else if (playDiceImageKey.equals(myDiceKeysAndValues.getDICE_IMAGE_DICEY())) {
            diceImage4.setImageResource(diceyDiceImage[myRandomNum4]);
            diceImage6.setImageResource(diceyDiceImage[myRandomNum6]);
        } else if (playDiceImageKey.equals(myDiceKeysAndValues.getDICE_IMAGE_DICE())) {
            diceImage4.setImageResource(diceImage[myRandomNum4]);
            diceImage6.setImageResource(diceImage[myRandomNum6]);
        } else if (playDiceImageKey.equals(myDiceKeysAndValues.getDICE_IMAGE_TERNING())) {
            diceImage4.setImageResource(terningDiceImage[myRandomNum4]);
            diceImage6.setImageResource(terningDiceImage[myRandomNum6]);
        } else if (playDiceImageKey.equals(myDiceKeysAndValues.getDICE_IMAGE_U_PLUS())) {
            diceImage4.setImageResource(u_plusDiceImage[myRandomNum4]);
            diceImage6.setImageResource(u_plusDiceImage[myRandomNum6]);
        }

    }

    private void setDiceImageOfThreeDice() {

        sharedPreferences = getSharedPreferences("prefs", MODE_PRIVATE);
        String playDiceImageKey = sharedPreferences.getString(myDiceKeysAndValues.getDICE_IMAGE_KEY(),
                myDiceKeysAndValues.getDICE_IMAGE_KISMET());

        dicePlayKeyValue = 3;

        if (playDiceImageKey.equals(myDiceKeysAndValues.getDICE_IMAGE_ALEA())) {
            diceImage2.setImageResource(aleaDiceImages[myRandomNum2]);
            diceImage5.setImageResource(aleaDiceImages[myRandomNum5]);
            diceImage8.setImageResource(aleaDiceImages[myRandomNum8]);
        } else if (playDiceImageKey.equals(myDiceKeysAndValues.getDICE_IMAGE_ALEA_A())) {
            diceImage2.setImageResource(alea_a_diceImage[myRandomNum2]);
            diceImage5.setImageResource(alea_a_diceImage[myRandomNum5]);
            diceImage8.setImageResource(alea_a_diceImage[myRandomNum8]);
        } else if (playDiceImageKey.equals(myDiceKeysAndValues.getDICE_IMAGE_DADO())) {
            diceImage2.setImageResource(dadoDiceImage[myRandomNum2]);
            diceImage5.setImageResource(dadoDiceImage[myRandomNum5]);
            diceImage8.setImageResource(dadoDiceImage[myRandomNum8]);
        } else if (playDiceImageKey.equals(myDiceKeysAndValues.getDICE_IMAGE_KISMET())) {
            diceImage2.setImageResource(kismetDiceImage[myRandomNum2]);
            diceImage5.setImageResource(kismetDiceImage[myRandomNum5]);
            diceImage8.setImageResource(kismetDiceImage[myRandomNum8]);
        } else if (playDiceImageKey.equals(myDiceKeysAndValues.getDICE_IMAGE_DICE_A_5SQB())) {
            diceImage2.setImageResource(dice_a_5sqb_diceImage[myRandomNum2]);
            diceImage5.setImageResource(dice_a_5sqb_diceImage[myRandomNum5]);
            diceImage8.setImageResource(dice_a_5sqb_diceImage[myRandomNum8]);
        } else if (playDiceImageKey.equals(myDiceKeysAndValues.getDICE_IMAGE_DICE_5SQA())) {
            diceImage2.setImageResource(perspective_diceImage[myRandomNum2]);
            diceImage5.setImageResource(perspective_diceImage[myRandomNum5]);
            diceImage8.setImageResource(perspective_diceImage[myRandomNum8]);
        } else if (playDiceImageKey.equals(myDiceKeysAndValues.getDICE_IMAGE_DICEY())) {
            diceImage2.setImageResource(diceyDiceImage[myRandomNum2]);
            diceImage5.setImageResource(diceyDiceImage[myRandomNum5]);
            diceImage8.setImageResource(diceyDiceImage[myRandomNum8]);
        } else if (playDiceImageKey.equals(myDiceKeysAndValues.getDICE_IMAGE_DICE())) {
            diceImage2.setImageResource(diceImage[myRandomNum2]);
            diceImage5.setImageResource(diceImage[myRandomNum5]);
            diceImage8.setImageResource(diceImage[myRandomNum8]);
        } else if (playDiceImageKey.equals(myDiceKeysAndValues.getDICE_IMAGE_TERNING())) {
            diceImage2.setImageResource(terningDiceImage[myRandomNum2]);
            diceImage5.setImageResource(terningDiceImage[myRandomNum5]);
            diceImage8.setImageResource(terningDiceImage[myRandomNum8]);
        } else if (playDiceImageKey.equals(myDiceKeysAndValues.getDICE_IMAGE_U_PLUS())) {
            diceImage2.setImageResource(u_plusDiceImage[myRandomNum2]);
            diceImage5.setImageResource(u_plusDiceImage[myRandomNum5]);
            diceImage8.setImageResource(u_plusDiceImage[myRandomNum8]);
        }


    }

    private void setDiceImageOfFourDice() {

        sharedPreferences = getSharedPreferences("prefs", MODE_PRIVATE);
        String playDiceImageKey = sharedPreferences.getString(myDiceKeysAndValues.getDICE_IMAGE_KEY(),
                myDiceKeysAndValues.getDICE_IMAGE_KISMET());

        dicePlayKeyValue = 4;

        if (playDiceImageKey.equals(myDiceKeysAndValues.getDICE_IMAGE_ALEA())) {
            diceImage1.setImageResource(aleaDiceImages[myRandomNum1]);
            diceImage3.setImageResource(aleaDiceImages[myRandomNum3]);
            diceImage7.setImageResource(aleaDiceImages[myRandomNum7]);
            diceImage9.setImageResource(aleaDiceImages[myRandomNum9]);
        } else if (playDiceImageKey.equals(myDiceKeysAndValues.getDICE_IMAGE_ALEA_A())) {
            diceImage1.setImageResource(alea_a_diceImage[myRandomNum1]);
            diceImage3.setImageResource(alea_a_diceImage[myRandomNum3]);
            diceImage7.setImageResource(alea_a_diceImage[myRandomNum7]);
            diceImage9.setImageResource(alea_a_diceImage[myRandomNum9]);
        } else if (playDiceImageKey.equals(myDiceKeysAndValues.getDICE_IMAGE_DADO())) {
            diceImage1.setImageResource(dadoDiceImage[myRandomNum1]);
            diceImage3.setImageResource(dadoDiceImage[myRandomNum3]);
            diceImage7.setImageResource(dadoDiceImage[myRandomNum7]);
            diceImage9.setImageResource(dadoDiceImage[myRandomNum9]);
        } else if (playDiceImageKey.equals(myDiceKeysAndValues.getDICE_IMAGE_KISMET())) {
            diceImage1.setImageResource(kismetDiceImage[myRandomNum1]);
            diceImage3.setImageResource(kismetDiceImage[myRandomNum3]);
            diceImage7.setImageResource(kismetDiceImage[myRandomNum7]);
            diceImage9.setImageResource(kismetDiceImage[myRandomNum9]);
        } else if (playDiceImageKey.equals(myDiceKeysAndValues.getDICE_IMAGE_DICE_A_5SQB())) {
            diceImage1.setImageResource(dice_a_5sqb_diceImage[myRandomNum1]);
            diceImage3.setImageResource(dice_a_5sqb_diceImage[myRandomNum3]);
            diceImage7.setImageResource(dice_a_5sqb_diceImage[myRandomNum7]);
            diceImage9.setImageResource(dice_a_5sqb_diceImage[myRandomNum9]);
        } else if (playDiceImageKey.equals(myDiceKeysAndValues.getDICE_IMAGE_DICE_5SQA())) {
            diceImage1.setImageResource(perspective_diceImage[myRandomNum1]);
            diceImage3.setImageResource(perspective_diceImage[myRandomNum3]);
            diceImage7.setImageResource(perspective_diceImage[myRandomNum7]);
            diceImage9.setImageResource(perspective_diceImage[myRandomNum9]);
        } else if (playDiceImageKey.equals(myDiceKeysAndValues.getDICE_IMAGE_DICEY())) {
            diceImage1.setImageResource(diceyDiceImage[myRandomNum1]);
            diceImage3.setImageResource(diceyDiceImage[myRandomNum3]);
            diceImage7.setImageResource(diceyDiceImage[myRandomNum7]);
            diceImage9.setImageResource(diceyDiceImage[myRandomNum9]);
        } else if (playDiceImageKey.equals(myDiceKeysAndValues.getDICE_IMAGE_DICE())) {
            diceImage1.setImageResource(diceImage[myRandomNum1]);
            diceImage3.setImageResource(diceImage[myRandomNum3]);
            diceImage7.setImageResource(diceImage[myRandomNum7]);
            diceImage9.setImageResource(diceImage[myRandomNum9]);
        } else if (playDiceImageKey.equals(myDiceKeysAndValues.getDICE_IMAGE_TERNING())) {
            diceImage1.setImageResource(terningDiceImage[myRandomNum1]);
            diceImage3.setImageResource(terningDiceImage[myRandomNum3]);
            diceImage7.setImageResource(terningDiceImage[myRandomNum7]);
            diceImage9.setImageResource(terningDiceImage[myRandomNum9]);
        } else if (playDiceImageKey.equals(myDiceKeysAndValues.getDICE_IMAGE_U_PLUS())) {
            diceImage1.setImageResource(u_plusDiceImage[myRandomNum1]);
            diceImage3.setImageResource(u_plusDiceImage[myRandomNum3]);
            diceImage7.setImageResource(u_plusDiceImage[myRandomNum7]);
            diceImage9.setImageResource(u_plusDiceImage[myRandomNum9]);
        }

    }

    private void setDiceImageOfFiveDice() {

        sharedPreferences = getSharedPreferences("prefs", MODE_PRIVATE);
        String playDiceImageKey = sharedPreferences.getString(myDiceKeysAndValues.getDICE_IMAGE_KEY(),
                myDiceKeysAndValues.getDICE_IMAGE_KISMET());

        dicePlayKeyValue = 5;

        if (playDiceImageKey.equals(myDiceKeysAndValues.getDICE_IMAGE_ALEA())) {
            diceImage1.setImageResource(aleaDiceImages[myRandomNum1]);
            diceImage3.setImageResource(aleaDiceImages[myRandomNum3]);
            diceImage5.setImageResource(aleaDiceImages[myRandomNum5]);
            diceImage7.setImageResource(aleaDiceImages[myRandomNum7]);
            diceImage9.setImageResource(aleaDiceImages[myRandomNum9]);
        } else if (playDiceImageKey.equals(myDiceKeysAndValues.getDICE_IMAGE_ALEA_A())) {
            diceImage1.setImageResource(alea_a_diceImage[myRandomNum1]);
            diceImage3.setImageResource(alea_a_diceImage[myRandomNum3]);
            diceImage5.setImageResource(alea_a_diceImage[myRandomNum5]);
            diceImage7.setImageResource(alea_a_diceImage[myRandomNum7]);
            diceImage9.setImageResource(alea_a_diceImage[myRandomNum9]);
        } else if (playDiceImageKey.equals(myDiceKeysAndValues.getDICE_IMAGE_DADO())) {
            diceImage1.setImageResource(dadoDiceImage[myRandomNum1]);
            diceImage3.setImageResource(dadoDiceImage[myRandomNum3]);
            diceImage5.setImageResource(dadoDiceImage[myRandomNum5]);
            diceImage7.setImageResource(dadoDiceImage[myRandomNum7]);
            diceImage9.setImageResource(dadoDiceImage[myRandomNum9]);
        } else if (playDiceImageKey.equals(myDiceKeysAndValues.getDICE_IMAGE_KISMET())) {
            diceImage1.setImageResource(kismetDiceImage[myRandomNum1]);
            diceImage3.setImageResource(kismetDiceImage[myRandomNum3]);
            diceImage5.setImageResource(kismetDiceImage[myRandomNum5]);
            diceImage7.setImageResource(kismetDiceImage[myRandomNum7]);
            diceImage9.setImageResource(kismetDiceImage[myRandomNum9]);
        } else if (playDiceImageKey.equals(myDiceKeysAndValues.getDICE_IMAGE_DICE_A_5SQB())) {
            diceImage1.setImageResource(dice_a_5sqb_diceImage[myRandomNum1]);
            diceImage3.setImageResource(dice_a_5sqb_diceImage[myRandomNum3]);
            diceImage5.setImageResource(dice_a_5sqb_diceImage[myRandomNum5]);
            diceImage7.setImageResource(dice_a_5sqb_diceImage[myRandomNum7]);
            diceImage9.setImageResource(dice_a_5sqb_diceImage[myRandomNum9]);
        } else if (playDiceImageKey.equals(myDiceKeysAndValues.getDICE_IMAGE_DICE_5SQA())) {
            diceImage1.setImageResource(perspective_diceImage[myRandomNum1]);
            diceImage3.setImageResource(perspective_diceImage[myRandomNum3]);
            diceImage5.setImageResource(perspective_diceImage[myRandomNum5]);
            diceImage7.setImageResource(perspective_diceImage[myRandomNum7]);
            diceImage9.setImageResource(perspective_diceImage[myRandomNum9]);
        } else if (playDiceImageKey.equals(myDiceKeysAndValues.getDICE_IMAGE_DICEY())) {
            diceImage1.setImageResource(diceyDiceImage[myRandomNum1]);
            diceImage3.setImageResource(diceyDiceImage[myRandomNum3]);
            diceImage5.setImageResource(diceyDiceImage[myRandomNum5]);
            diceImage7.setImageResource(diceyDiceImage[myRandomNum7]);
            diceImage9.setImageResource(diceyDiceImage[myRandomNum9]);
        } else if (playDiceImageKey.equals(myDiceKeysAndValues.getDICE_IMAGE_DICE())) {
            diceImage1.setImageResource(diceImage[myRandomNum1]);
            diceImage3.setImageResource(diceImage[myRandomNum3]);
            diceImage5.setImageResource(diceImage[myRandomNum5]);
            diceImage7.setImageResource(diceImage[myRandomNum7]);
            diceImage9.setImageResource(diceImage[myRandomNum9]);
        } else if (playDiceImageKey.equals(myDiceKeysAndValues.getDICE_IMAGE_TERNING())) {
            diceImage1.setImageResource(terningDiceImage[myRandomNum1]);
            diceImage3.setImageResource(terningDiceImage[myRandomNum3]);
            diceImage5.setImageResource(terningDiceImage[myRandomNum5]);
            diceImage7.setImageResource(terningDiceImage[myRandomNum7]);
            diceImage9.setImageResource(terningDiceImage[myRandomNum9]);
        } else if (playDiceImageKey.equals(myDiceKeysAndValues.getDICE_IMAGE_U_PLUS())) {
            diceImage1.setImageResource(u_plusDiceImage[myRandomNum1]);
            diceImage3.setImageResource(u_plusDiceImage[myRandomNum3]);
            diceImage5.setImageResource(u_plusDiceImage[myRandomNum5]);
            diceImage7.setImageResource(u_plusDiceImage[myRandomNum7]);
            diceImage9.setImageResource(u_plusDiceImage[myRandomNum9]);
        }

    }

    private void setDiceImageOfSixDice() {

        sharedPreferences = getSharedPreferences("prefs", MODE_PRIVATE);
        String playDiceImageKey = sharedPreferences.getString(myDiceKeysAndValues.getDICE_IMAGE_KEY(),
                myDiceKeysAndValues.getDICE_IMAGE_KISMET());

        dicePlayKeyValue = 6;

        if (playDiceImageKey.equals(myDiceKeysAndValues.getDICE_IMAGE_ALEA())) {
            diceImage1.setImageResource(aleaDiceImages[myRandomNum1]);
            diceImage3.setImageResource(aleaDiceImages[myRandomNum3]);
            diceImage4.setImageResource(aleaDiceImages[myRandomNum4]);
            diceImage6.setImageResource(aleaDiceImages[myRandomNum6]);
            diceImage7.setImageResource(aleaDiceImages[myRandomNum7]);
            diceImage9.setImageResource(aleaDiceImages[myRandomNum9]);
        } else if (playDiceImageKey.equals(myDiceKeysAndValues.getDICE_IMAGE_ALEA_A())) {
            diceImage1.setImageResource(alea_a_diceImage[myRandomNum1]);
            diceImage3.setImageResource(alea_a_diceImage[myRandomNum3]);
            diceImage4.setImageResource(alea_a_diceImage[myRandomNum4]);
            diceImage6.setImageResource(alea_a_diceImage[myRandomNum6]);
            diceImage7.setImageResource(alea_a_diceImage[myRandomNum7]);
            diceImage9.setImageResource(alea_a_diceImage[myRandomNum9]);
        } else if (playDiceImageKey.equals(myDiceKeysAndValues.getDICE_IMAGE_DADO())) {
            diceImage1.setImageResource(dadoDiceImage[myRandomNum1]);
            diceImage3.setImageResource(dadoDiceImage[myRandomNum3]);
            diceImage4.setImageResource(dadoDiceImage[myRandomNum4]);
            diceImage6.setImageResource(dadoDiceImage[myRandomNum6]);
            diceImage7.setImageResource(dadoDiceImage[myRandomNum7]);
            diceImage9.setImageResource(dadoDiceImage[myRandomNum9]);
        } else if (playDiceImageKey.equals(myDiceKeysAndValues.getDICE_IMAGE_DICE())) {
            diceImage1.setImageResource(diceImage[myRandomNum1]);
            diceImage3.setImageResource(diceImage[myRandomNum3]);
            diceImage4.setImageResource(diceImage[myRandomNum4]);
            diceImage6.setImageResource(diceImage[myRandomNum6]);
            diceImage7.setImageResource(diceImage[myRandomNum7]);
            diceImage9.setImageResource(diceImage[myRandomNum9]);
        } else if (playDiceImageKey.equals(myDiceKeysAndValues.getDICE_IMAGE_DICE_A_5SQB())) {
            diceImage1.setImageResource(dice_a_5sqb_diceImage[myRandomNum1]);
            diceImage3.setImageResource(dice_a_5sqb_diceImage[myRandomNum3]);
            diceImage4.setImageResource(dice_a_5sqb_diceImage[myRandomNum4]);
            diceImage6.setImageResource(dice_a_5sqb_diceImage[myRandomNum6]);
            diceImage7.setImageResource(dice_a_5sqb_diceImage[myRandomNum7]);
            diceImage9.setImageResource(dice_a_5sqb_diceImage[myRandomNum9]);
        } else if (playDiceImageKey.equals(myDiceKeysAndValues.getDICE_IMAGE_DICE_5SQA())) {
            diceImage1.setImageResource(perspective_diceImage[myRandomNum1]);
            diceImage3.setImageResource(perspective_diceImage[myRandomNum3]);
            diceImage4.setImageResource(perspective_diceImage[myRandomNum4]);
            diceImage6.setImageResource(perspective_diceImage[myRandomNum6]);
            diceImage7.setImageResource(perspective_diceImage[myRandomNum7]);
            diceImage9.setImageResource(perspective_diceImage[myRandomNum9]);
        } else if (playDiceImageKey.equals(myDiceKeysAndValues.getDICE_IMAGE_DICEY())) {
            diceImage1.setImageResource(diceyDiceImage[myRandomNum1]);
            diceImage3.setImageResource(diceyDiceImage[myRandomNum3]);
            diceImage4.setImageResource(diceyDiceImage[myRandomNum4]);
            diceImage6.setImageResource(diceyDiceImage[myRandomNum6]);
            diceImage7.setImageResource(diceyDiceImage[myRandomNum7]);
            diceImage9.setImageResource(diceyDiceImage[myRandomNum9]);
        } else if (playDiceImageKey.equals(myDiceKeysAndValues.getDICE_IMAGE_KISMET())) {
            diceImage1.setImageResource(kismetDiceImage[myRandomNum1]);
            diceImage3.setImageResource(kismetDiceImage[myRandomNum3]);
            diceImage4.setImageResource(kismetDiceImage[myRandomNum4]);
            diceImage6.setImageResource(kismetDiceImage[myRandomNum6]);
            diceImage7.setImageResource(kismetDiceImage[myRandomNum7]);
            diceImage9.setImageResource(kismetDiceImage[myRandomNum9]);
        } else if (playDiceImageKey.equals(myDiceKeysAndValues.getDICE_IMAGE_TERNING())) {
            diceImage1.setImageResource(terningDiceImage[myRandomNum1]);
            diceImage3.setImageResource(terningDiceImage[myRandomNum3]);
            diceImage4.setImageResource(terningDiceImage[myRandomNum4]);
            diceImage6.setImageResource(terningDiceImage[myRandomNum6]);
            diceImage7.setImageResource(terningDiceImage[myRandomNum7]);
            diceImage9.setImageResource(terningDiceImage[myRandomNum9]);
        } else if (playDiceImageKey.equals(myDiceKeysAndValues.getDICE_IMAGE_U_PLUS())) {
            diceImage1.setImageResource(u_plusDiceImage[myRandomNum1]);
            diceImage3.setImageResource(u_plusDiceImage[myRandomNum3]);
            diceImage4.setImageResource(u_plusDiceImage[myRandomNum4]);
            diceImage6.setImageResource(u_plusDiceImage[myRandomNum6]);
            diceImage7.setImageResource(u_plusDiceImage[myRandomNum7]);
            diceImage9.setImageResource(u_plusDiceImage[myRandomNum9]);
        }

    }

    @Override
    protected void onResume() {
        super.onResume();

        sharedPreferences = getSharedPreferences("prefs", MODE_PRIVATE);
        String playDiceKey;
        playDiceKey = sharedPreferences.getString(myDiceKeysAndValues.getDICE_KEY(),
                myDiceKeysAndValues.getPLAY2VALUE());

        chooseColorThemeFunction();
        enableFullScreenToggle();

        if (playDiceKey.equals(myDiceKeysAndValues.getPLAY1VALUE())) {

            setDiceImageOfOneDie();
            setPlay1DiceVisibility();

            myAdapter = new DiceAdapter( diceValues);
            layoutManager = new GridLayoutManager(this, 2, GridLayoutManager.HORIZONTAL, false);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(myAdapter);

        } else if (playDiceKey.equals(myDiceKeysAndValues.getPLAY2VALUE())) {

            setDiceImageOfTwoDice();
            setPlay2DiceVisibility();

            myAdapterOfTwoDice = new TwoDiceAdapter(diceValuesOfTwoDice);
            layoutManagerOfTwoDice = new GridLayoutManager(this, 2, GridLayoutManager.HORIZONTAL, false);
            recyclerViewOfTwoDice.setLayoutManager(layoutManagerOfTwoDice);
            recyclerViewOfTwoDice.setAdapter(myAdapterOfTwoDice);

        } else if (playDiceKey.equals(myDiceKeysAndValues.getPLAY3VALUE())) {

            setDiceImageOfThreeDice();
            setPlay3DiceVisibility();

            myAdapterOfThreeDice = new ThreeDiceAdapter(diceValuesOfThreeDice);
            layoutManagerOfThreeDice = new LinearLayoutManager(this);
            recyclerViewOfThreeDice.setLayoutManager(layoutManagerOfThreeDice);
            recyclerViewOfThreeDice.setAdapter(myAdapterOfThreeDice);


        } else if (playDiceKey.equals(myDiceKeysAndValues.getPLAY4VALUE())) {

            setDiceImageOfFourDice();
            setPlay4DiceVisibility();

            myAdapterOfFourDice = new FourDiceAdapter(diceValuesOfFourDice);
            layoutManagerOfFourDice = new LinearLayoutManager(this);
            recyclerViewOfFourDice.setLayoutManager(layoutManagerOfFourDice);
            recyclerViewOfFourDice.setAdapter(myAdapterOfFourDice);

        } else if (playDiceKey.equals(myDiceKeysAndValues.getPLAY5VALUE())) {

            setDiceImageOfFiveDice();
            setPlay5DiceVisibility();

            myAdapterOfFiveDice = new FiveDiceAdapter(diceValuesOfFiveDice);
            layoutManagerOfFiveDice = new LinearLayoutManager(this);
            recyclerViewOfFiveDice.setLayoutManager(layoutManagerOfFiveDice);
            recyclerViewOfFiveDice.setAdapter(myAdapterOfFiveDice);
        } else if (playDiceKey.equals(myDiceKeysAndValues.getPLAY6VALUE())) {

            setDiceImageOfSixDice();
            setPlay6DiceVisibility();

            myAdapterOfSixDice = new SixDiceAdapter(diceValuesOfSixDice);
            layoutManagerOfSixDice = new LinearLayoutManager(this);
            recyclerViewOfSixDice.setLayoutManager(layoutManagerOfSixDice);
            recyclerViewOfSixDice.setAdapter(myAdapterOfSixDice);
        }
        mSensorManager.registerListener(mShakeDetector, mAccelerometer, SensorManager.SENSOR_DELAY_UI);

    }

    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(mShakeDetector);

    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);


        outState.putInt("MY_RANDOM_NUM1_KEY", myRandomNum1);
        outState.putInt("MY_RANDOM_NUM2_KEY", myRandomNum2);
        outState.putInt("MY_RANDOM_NUM3_KEY", myRandomNum3);
        outState.putInt("MY_RANDOM_NUM4_KEY", myRandomNum4);
        outState.putInt("MY_RANDOM_NUM5_KEY", myRandomNum5);
        outState.putInt("MY_RANDOM_NUM6_KEY", myRandomNum6);
        outState.putInt("MY_RANDOM_NUM7_KEY", myRandomNum7);
        outState.putInt("MY_RANDOM_NUM8_KEY", myRandomNum8);
        outState.putInt("MY_RANDOM_NUM9_KEY", myRandomNum9);


        outState.putParcelableArrayList("KEY1", diceValues);
        outState.putParcelableArrayList("KEY2", diceValuesOfTwoDice);
        outState.putParcelableArrayList("KEY3", diceValuesOfThreeDice);
        outState.putParcelableArrayList("KEY4", diceValuesOfFourDice);

        outState.putParcelableArrayList("KEY5", diceValuesOfFiveDice);

        outState.putParcelableArrayList("KEY6", diceValuesOfSixDice);

        outState.putIntArray("alea", aleaDiceImages);
        outState.putIntArray("alea_a", alea_a_diceImage);
        outState.putIntArray("dado", dadoDiceImage);
        outState.putIntArray("dice", diceImage);
        outState.putIntArray("dice_5sqb", dice_a_5sqb_diceImage);
        outState.putIntArray("perspective", perspective_diceImage);
        outState.putIntArray("dicey", diceyDiceImage);
        outState.putIntArray("kismet", kismetDiceImage);
        outState.putIntArray("terning", terningDiceImage);
        outState.putIntArray("u_plus", u_plusDiceImage);


    }

    private void setRollingSoundAndVibrate() {

        sharedPreferences = getSharedPreferences("prefs", MODE_PRIVATE);
        boolean rollingSoundKey = sharedPreferences.getBoolean(myDiceKeysAndValues.getROLLING_SOUND_KEY(), true);
        Boolean vibrateKey = sharedPreferences.getBoolean(myDiceKeysAndValues.getVIBRATE_KEY(), true);

        if (vibrateKey) {
            vibrator.vibrate(500);
        } else {

        }

        if (rollingSoundKey) {
            mp.start();
        } else {
        }

    }

    public void playOneDie(ImageView diceImage5) {


        myRandomNum5 = randObj.nextInt(6); // 0...5
        setDiceImageOfOneDie();

        //daimajia android animations
        YoYo.with(Techniques.RollIn)
                .duration(1200)
                .repeat(0)
                .playOn(diceImage5);

        setRollingSoundAndVibrate();
        getOneDiceValue();

    }

    public void playTwoDice(ImageView diceImage4, ImageView diceImage6) {

        myRandomNum4 = randObj.nextInt(6); // 0...5
        myRandomNum6 = randObj.nextInt(6); // 0...5

        setDiceImageOfTwoDice();

        //daimajia android animations
        YoYo.with(Techniques.RollIn)
                .duration(1200)
                .repeat(0)
                .playOn(diceImage4);

        //daimajia android animations
        YoYo.with(Techniques.RollIn)
                .duration(1200)
                .repeat(0)
                .playOn(diceImage6);

        setRollingSoundAndVibrate();
        getTwoDiceValues();


    }

    public void playThreeDice(ImageView diceImage2, ImageView diceImage5,
                              ImageView diceImage8) {

        myRandomNum2 = randObj.nextInt(6); // 0...5
        myRandomNum5 = randObj.nextInt(6); // 0...5
        myRandomNum8 = randObj.nextInt(6); //0...5

        setDiceImageOfThreeDice();

        //daimajia android animations
        YoYo.with(Techniques.RollIn)
                .duration(1200)
                .repeat(0)
                .playOn(diceImage2);

        //daimajia android animations
        YoYo.with(Techniques.RotateIn)
                .duration(1200)
                .repeat(0)
                .playOn(diceImage5);

        //daimajia android animations
        YoYo.with(Techniques.RollIn)
                .duration(1200)
                .repeat(0)
                .playOn(diceImage8);

        setRollingSoundAndVibrate();
        getThreeDiceValues();


    }

    public void playFourDice(ImageView diceImage1, ImageView diceImage3,
                             ImageView diceImage7, ImageView diceImage9) {

        myRandomNum1 = randObj.nextInt(6); // 0...5
        myRandomNum3 = randObj.nextInt(6); // 0...5
        myRandomNum7 = randObj.nextInt(6); //0...5
        myRandomNum9 = randObj.nextInt(6); //0...5


        setDiceImageOfFourDice();

        //daimajia android animations
        YoYo.with(Techniques.RollIn)
                .duration(1200)
                .repeat(0)
                .playOn(diceImage1);

        //daimajia android animations
        YoYo.with(Techniques.RollIn)
                .duration(1200)
                .repeat(0)
                .playOn(diceImage3);

        //daimajia android animations
        YoYo.with(Techniques.RollIn)
                .duration(1200)
                .repeat(0)
                .playOn(diceImage7);

        //daimajia android animations
        YoYo.with(Techniques.RollIn)
                .duration(1200)
                .repeat(0)
                .playOn(diceImage9);


        setRollingSoundAndVibrate();
        getFourDiceValue();


    }

    public void playFiveDice(ImageView diceImage1, ImageView diceImage3,
                             ImageView diceImage5, ImageView diceImage7,
                             ImageView diceImage9) {

        myRandomNum1 = randObj.nextInt(6); // 0...5
        myRandomNum3 = randObj.nextInt(6); // 0...5
        myRandomNum5 = randObj.nextInt(6); //0...5
        myRandomNum7 = randObj.nextInt(6); //0...5
        myRandomNum9 = randObj.nextInt(6); //0...5

        setDiceImageOfFiveDice();

        //daimajia android animations
        YoYo.with(Techniques.RollIn)
                .duration(1200)
                .repeat(0)
                .playOn(diceImage1);

        //daimajia android animations
        YoYo.with(Techniques.RollIn)
                .duration(1200)
                .repeat(0)
                .playOn(diceImage3);

        //daimajia android animations
        YoYo.with(Techniques.RotateIn)
                .duration(1200)
                .repeat(0)
                .playOn(diceImage5);

        //daimajia android animations
        YoYo.with(Techniques.RollIn)
                .duration(1200)
                .repeat(0)
                .playOn(diceImage7);

        //daimajia android animations
        YoYo.with(Techniques.RollIn)
                .duration(1200)
                .repeat(0)
                .playOn(diceImage9);

        setRollingSoundAndVibrate();

        getFiveDiceValues();

    }

    public void playSixDice(ImageView diceImage1, ImageView diceImage3,
                            ImageView diceImage4, ImageView diceImage6,
                            ImageView diceImage7, ImageView diceImage9) {


        myRandomNum1 = randObj.nextInt(6); // 0...5
        myRandomNum3 = randObj.nextInt(6); // 0...5
        myRandomNum4 = randObj.nextInt(6); //0...5
        myRandomNum6 = randObj.nextInt(6); //0...5
        myRandomNum7 = randObj.nextInt(6); //0...5
        myRandomNum9 = randObj.nextInt(6); //0...5

        setDiceImageOfSixDice();

        //daimajia android animations
        YoYo.with(Techniques.RollIn)
                .duration(1200)
                .repeat(0)
                .playOn(diceImage1);

        //daimajia android animations
        YoYo.with(Techniques.RollIn)
                .duration(1200)
                .repeat(0)
                .playOn(diceImage3);

        //daimajia android animations
        YoYo.with(Techniques.RollIn)
                .duration(1200)
                .repeat(0)
                .playOn(diceImage4);

        //daimajia android animations
        YoYo.with(Techniques.RollIn)
                .duration(1200)
                .repeat(0)
                .playOn(diceImage6);

        //daimajia android animations
        YoYo.with(Techniques.RollIn)
                .duration(1200)
                .repeat(0)
                .playOn(diceImage7);

        //daimajia android animations
        YoYo.with(Techniques.RollIn)
                .duration(1200)
                .repeat(0)
                .playOn(diceImage9);

        setRollingSoundAndVibrate();
        getSixDiceValues();


    }

    private void getOneDiceValue() {

        if (myRandomNum5 == 0) {
            dice5Value = 1;
        }
        if (myRandomNum5 == 1) {
            dice5Value = 2;
        }
        if (myRandomNum5 == 2) {
            dice5Value = 3;
        }
        if (myRandomNum5 == 3) {
            dice5Value = 4;
        }
        if (myRandomNum5 == 4) {
            dice5Value = 5;
        }
        if (myRandomNum5 == 5) {
            dice5Value = 6;
        }

        diceValues.add(0, new Dice(dice5Value));
        myAdapter = new DiceAdapter(diceValues);
        layoutManager = new GridLayoutManager(this, 2, GridLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(myAdapter);


        int result = dice5Value;


        sharedPreferences = getSharedPreferences("prefs", MODE_PRIVATE);
        Boolean speakTotalKey = sharedPreferences.getBoolean(myDiceKeysAndValues.getSPEAK_TOTAL_KEY(), false);


        if (speakTotalKey) {
            switch (result) {
                case 1:
                    one.start();
                    break;
                case 2:
                    two.start();
                    break;
                case 3:
                    three.start();
                    break;
                case 4:
                    four.start();
                    break;
                case 5:
                    five.start();
                    break;
                case 6:
                    six.start();
                    break;
            }
        } else {

            // else speak total is off
        }

    }

    private void getTwoDiceValues() {

        if (myRandomNum4 == 0) {
            dice4Value = 1;
        }
        if (myRandomNum4 == 1) {
            dice4Value = 2;
        }
        if (myRandomNum4 == 2) {
            dice4Value = 3;
        }
        if (myRandomNum4 == 3) {
            dice4Value = 4;
        }
        if (myRandomNum4 == 4) {
            dice4Value = 5;
        }
        if (myRandomNum4 == 5) {
            dice4Value = 6;
        }


        if (myRandomNum6 == 0) {
            dice6Value = 1;
        }
        if (myRandomNum6 == 1) {
            dice6Value = 2;
        }
        if (myRandomNum6 == 2) {
            dice6Value = 3;
        }
        if (myRandomNum6 == 3) {
            dice6Value = 4;
        }
        if (myRandomNum6 == 4) {
            dice6Value = 5;
        }
        if (myRandomNum6 == 5) {
            dice6Value = 6;
        }


        diceValuesOfTwoDice.add(0, new Dice(dice4Value, dice6Value));
        myAdapterOfTwoDice = new TwoDiceAdapter(diceValuesOfTwoDice);
        layoutManagerOfTwoDice = new GridLayoutManager(this, 2, GridLayoutManager.HORIZONTAL, false);
        //layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewOfTwoDice.setLayoutManager(layoutManagerOfTwoDice);
        recyclerViewOfTwoDice.setAdapter(myAdapterOfTwoDice);

        int result = dice4Value + dice6Value;


        sharedPreferences = getSharedPreferences("prefs", MODE_PRIVATE);
        Boolean speakTotalKey = sharedPreferences.getBoolean(myDiceKeysAndValues.getSPEAK_TOTAL_KEY(), false);

        if (speakTotalKey) {

            switch (result) {
                case 2:
                    two.start();
                    break;
                case 3:
                    three.start();
                    break;
                case 4:
                    four.start();
                    break;
                case 5:
                    five.start();
                    break;
                case 6:
                    six.start();
                    break;
                case 7:
                    seven.start();
                    break;
                case 8:
                    eight.start();
                    break;
                case 9:
                    nine.start();
                    break;
                case 10:
                    ten.start();
                    break;
                case 11:
                    elven.start();
                    break;
                case 12:
                    twelve.start();
                    break;
            }
        } else {

            // else speak total is off
        }
    }


    private void getThreeDiceValues() {


        if (myRandomNum2 == 0) {
            dice2Value = 1;
        }
        if (myRandomNum2 == 1) {
            dice2Value = 2;
        }
        if (myRandomNum2 == 2) {
            dice2Value = 3;
        }
        if (myRandomNum2 == 3) {
            dice2Value = 4;
        }
        if (myRandomNum2 == 4) {
            dice2Value = 5;
        }
        if (myRandomNum2 == 5) {
            dice2Value = 6;
        }


        if (myRandomNum5 == 0) {
            dice5Value = 1;
        }
        if (myRandomNum5 == 1) {
            dice5Value = 2;
        }
        if (myRandomNum5 == 2) {
            dice5Value = 3;
        }
        if (myRandomNum5 == 3) {
            dice5Value = 4;
        }
        if (myRandomNum5 == 4) {
            dice5Value = 5;
        }
        if (myRandomNum5 == 5) {
            dice5Value = 6;
        }


        if (myRandomNum8 == 0) {
            dice8Value = 1;
        }
        if (myRandomNum8 == 1) {
            dice8Value = 2;
        }
        if (myRandomNum8 == 2) {
            dice8Value = 3;
        }
        if (myRandomNum8 == 3) {
            dice8Value = 4;
        }
        if (myRandomNum8 == 4) {
            dice8Value = 5;
        }
        if (myRandomNum8 == 5) {
            dice8Value = 6;
        }


        diceValuesOfThreeDice.add(0, new Dice(dice2Value, dice5Value, dice8Value));
        myAdapterOfThreeDice = new ThreeDiceAdapter(diceValuesOfThreeDice);
        //layoutManagerOfThreeDice = new LinearLayoutManager(this);
        layoutManagerOfThreeDice = new GridLayoutManager(this, 2, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewOfThreeDice.setLayoutManager(layoutManagerOfThreeDice);
        recyclerViewOfThreeDice.setAdapter(myAdapterOfThreeDice);

        int result = dice2Value + dice5Value + dice8Value;


        sharedPreferences = getSharedPreferences("prefs", MODE_PRIVATE);
        Boolean speakTotalKey = sharedPreferences.getBoolean(myDiceKeysAndValues.getSPEAK_TOTAL_KEY(), false);

        if (speakTotalKey) {
            switch (result) {

                case 3:
                    three.start();
                    break;

                case 4:
                    four.start();
                    break;

                case 5:
                    five.start();
                    break;

                case 6:
                    six.start();
                    break;
                case 7:
                    seven.start();
                    break;
                case 8:
                    eight.start();
                    break;
                case 9:
                    nine.start();
                    break;
                case 10:
                    ten.start();
                    break;
                case 11:
                    elven.start();
                    break;
                case 12:
                    twelve.start();
                    break;
                case 13:
                    thirteen.start();
                    break;
                case 14:
                    fourteen.start();
                    break;
                case 15:
                    fifteen.start();
                    break;
                case 16:
                    sixteen.start();
                    break;

                case 17:
                    seventeen.start();
                    break;

                case 18:
                    eighteen.start();
                    break;


            }
        } else {
            // else speak total is off
        }


    }


    private void getFourDiceValue() {

        if (myRandomNum1 == 0) {
            dice1Value = 1;
        }
        if (myRandomNum1 == 1) {
            dice1Value = 2;
        }
        if (myRandomNum1 == 2) {
            dice1Value = 3;
        }
        if (myRandomNum1 == 3) {
            dice1Value = 4;
        }
        if (myRandomNum1 == 4) {
            dice1Value = 5;
        }
        if (myRandomNum1 == 5) {
            dice1Value = 6;
        }


        if (myRandomNum3 == 0) {
            dice3Value = 1;
        }
        if (myRandomNum3 == 1) {
            dice3Value = 2;
        }
        if (myRandomNum3 == 2) {
            dice3Value = 3;
        }
        if (myRandomNum3 == 3) {
            dice3Value = 4;
        }
        if (myRandomNum3 == 4) {
            dice3Value = 5;
        }
        if (myRandomNum3 == 5) {
            dice3Value = 6;
        }


        if (myRandomNum7 == 0) {
            dice7Value = 1;
        }
        if (myRandomNum7 == 1) {
            dice7Value = 2;
        }
        if (myRandomNum7 == 2) {
            dice7Value = 3;
        }
        if (myRandomNum7 == 3) {
            dice7Value = 4;
        }
        if (myRandomNum7 == 4) {
            dice7Value = 5;
        }
        if (myRandomNum7 == 5) {
            dice7Value = 6;
        }


        if (myRandomNum9 == 0) {
            dice9Value = 1;
        }
        if (myRandomNum9 == 1) {
            dice9Value = 2;
        }
        if (myRandomNum9 == 2) {
            dice9Value = 3;
        }
        if (myRandomNum9 == 3) {
            dice9Value = 4;
        }
        if (myRandomNum9 == 4) {
            dice9Value = 5;
        }
        if (myRandomNum9 == 5) {
            dice9Value = 6;
        }

        diceValuesOfFourDice.add(0, new Dice(dice1Value, dice3Value, dice7Value, dice9Value));
        myAdapterOfFourDice = new FourDiceAdapter(diceValuesOfFourDice);

        layoutManagerOfFourDice = new LinearLayoutManager(this);
        //layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewOfFourDice.setLayoutManager(layoutManagerOfFourDice);

        recyclerViewOfFourDice.setAdapter(myAdapterOfFourDice);

        int result = dice1Value + dice3Value + dice7Value + dice9Value;


        sharedPreferences = getSharedPreferences("prefs", MODE_PRIVATE);
        Boolean speakTotalKey = sharedPreferences.getBoolean(myDiceKeysAndValues.getSPEAK_TOTAL_KEY(), false);

        if (speakTotalKey) {

            switch (result) {

                case 4:
                    four.start();
                    break;

                case 5:
                    five.start();
                    break;

                case 6:
                    six.start();
                    break;
                case 7:
                    seven.start();
                    break;
                case 8:
                    eight.start();
                    break;
                case 9:
                    nine.start();
                    break;
                case 10:
                    ten.start();
                    break;
                case 11:
                    elven.start();
                    break;
                case 12:
                    twelve.start();
                    break;
                case 13:
                    thirteen.start();
                    break;
                case 14:
                    fourteen.start();
                    break;
                case 15:
                    fifteen.start();
                    break;
                case 16:
                    sixteen.start();
                    break;

                case 17:
                    seventeen.start();
                    break;

                case 18:
                    eighteen.start();
                    break;

                case 19:
                    nineteen.start();
                    break;

                case 20:
                    twenty.start();
                    break;

                case 21:
                    twentyOne.start();
                    break;

                case 22:
                    twentyTwo.start();
                    break;

                case 23:
                    twentyThree.start();
                    break;

                case 24:
                    twentyFour.start();
                    break;


            }
        } else {
            // else speak total is off
        }


    }

    private void getFiveDiceValues() {

        if (myRandomNum1 == 0) {
            dice1Value = 1;
        }
        if (myRandomNum1 == 1) {
            dice1Value = 2;
        }
        if (myRandomNum1 == 2) {
            dice1Value = 3;
        }
        if (myRandomNum1 == 3) {
            dice1Value = 4;
        }
        if (myRandomNum1 == 4) {
            dice1Value = 5;
        }
        if (myRandomNum1 == 5) {
            dice1Value = 6;
        }


        if (myRandomNum3 == 0) {
            dice3Value = 1;
        }
        if (myRandomNum3 == 1) {
            dice3Value = 2;
        }
        if (myRandomNum3 == 2) {
            dice3Value = 3;
        }
        if (myRandomNum3 == 3) {
            dice3Value = 4;
        }
        if (myRandomNum3 == 4) {
            dice3Value = 5;
        }
        if (myRandomNum3 == 5) {
            dice3Value = 6;
        }


        if (myRandomNum5 == 0) {
            dice5Value = 1;
        }
        if (myRandomNum5 == 1) {
            dice5Value = 2;
        }
        if (myRandomNum5 == 2) {
            dice5Value = 3;
        }
        if (myRandomNum5 == 3) {
            dice5Value = 4;
        }
        if (myRandomNum5 == 4) {
            dice5Value = 5;
        }
        if (myRandomNum5 == 5) {
            dice5Value = 6;
        }


        if (myRandomNum7 == 0) {
            dice7Value = 1;
        }
        if (myRandomNum7 == 1) {
            dice7Value = 2;
        }
        if (myRandomNum7 == 2) {
            dice7Value = 3;
        }
        if (myRandomNum7 == 3) {
            dice7Value = 4;
        }
        if (myRandomNum7 == 4) {
            dice7Value = 5;
        }
        if (myRandomNum7 == 5) {
            dice7Value = 6;
        }


        if (myRandomNum9 == 0) {
            dice9Value = 1;
        }
        if (myRandomNum9 == 1) {
            dice9Value = 2;
        }
        if (myRandomNum9 == 2) {
            dice9Value = 3;
        }
        if (myRandomNum9 == 3) {
            dice9Value = 4;
        }
        if (myRandomNum9 == 4) {
            dice9Value = 5;
        }
        if (myRandomNum9 == 5) {
            dice9Value = 6;
        }

        diceValuesOfFiveDice.add(0, new Dice(dice1Value, dice3Value, dice5Value,
                dice7Value, dice9Value));

        myAdapterOfFiveDice = new FiveDiceAdapter(diceValuesOfFiveDice);

        layoutManagerOfFiveDice = new LinearLayoutManager(this);
        //layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewOfFiveDice.setLayoutManager(layoutManagerOfFiveDice);

        recyclerViewOfFiveDice.setAdapter(myAdapterOfFiveDice);

        int result = dice1Value + dice3Value + dice5Value + dice7Value + dice9Value;


        sharedPreferences = getSharedPreferences("prefs", MODE_PRIVATE);
        Boolean speakTotalKey = sharedPreferences.getBoolean(myDiceKeysAndValues.getSPEAK_TOTAL_KEY(), false);

        if (speakTotalKey) {

            switch (result) {

                case 5:
                    five.start();
                    break;

                case 6:
                    six.start();
                    break;
                case 7:
                    seven.start();
                    break;
                case 8:
                    eight.start();
                    break;
                case 9:
                    nine.start();
                    break;
                case 10:
                    ten.start();
                    break;
                case 11:
                    elven.start();
                    break;
                case 12:
                    twelve.start();
                    break;
                case 13:
                    thirteen.start();
                    break;
                case 14:
                    fourteen.start();
                    break;
                case 15:
                    fifteen.start();
                    break;
                case 16:
                    sixteen.start();
                    break;

                case 17:
                    seventeen.start();
                    break;

                case 18:
                    eighteen.start();
                    break;

                case 19:
                    nineteen.start();
                    break;

                case 20:
                    twenty.start();
                    break;

                case 21:
                    twentyOne.start();
                    break;

                case 22:
                    twentyTwo.start();
                    break;

                case 23:
                    twentyThree.start();
                    break;

                case 24:
                    twentyFour.start();
                    break;

                case 25:
                    twentyFive.start();
                    break;

                case 26:
                    twentySix.start();
                    break;

                case 27:
                    twentySeven.start();
                    break;

                case 28:
                    twentyEight.start();
                    break;

                case 29:
                    twentyNine.start();
                    break;

                case 30:
                    thirty.start();
                    break;


            }
        } else {
            // else speak total is off
        }
    }


    private void getSixDiceValues() {

        if (myRandomNum1 == 0) {
            dice1Value = 1;
        }
        if (myRandomNum1 == 1) {
            dice1Value = 2;
        }
        if (myRandomNum1 == 2) {
            dice1Value = 3;
        }
        if (myRandomNum1 == 3) {
            dice1Value = 4;
        }
        if (myRandomNum1 == 4) {
            dice1Value = 5;
        }
        if (myRandomNum1 == 5) {
            dice1Value = 6;
        }


        if (myRandomNum3 == 0) {
            dice3Value = 1;
        }
        if (myRandomNum3 == 1) {
            dice3Value = 2;
        }
        if (myRandomNum3 == 2) {
            dice3Value = 3;
        }
        if (myRandomNum3 == 3) {
            dice3Value = 4;
        }
        if (myRandomNum3 == 4) {
            dice3Value = 5;
        }
        if (myRandomNum3 == 5) {
            dice3Value = 6;
        }


        if (myRandomNum4 == 0) {
            dice4Value = 1;
        }
        if (myRandomNum4 == 1) {
            dice4Value = 2;
        }
        if (myRandomNum4 == 2) {
            dice4Value = 3;
        }
        if (myRandomNum4 == 3) {
            dice4Value = 4;
        }
        if (myRandomNum4 == 4) {
            dice4Value = 5;
        }
        if (myRandomNum4 == 5) {
            dice4Value = 6;
        }

        if (myRandomNum6 == 0) {
            dice6Value = 1;
        }
        if (myRandomNum6 == 1) {
            dice6Value = 2;
        }
        if (myRandomNum6 == 2) {
            dice6Value = 3;
        }
        if (myRandomNum6 == 3) {
            dice6Value = 4;
        }
        if (myRandomNum6 == 4) {
            dice6Value = 5;
        }
        if (myRandomNum6 == 5) {
            dice6Value = 6;
        }


        if (myRandomNum7 == 0) {
            dice7Value = 1;
        }
        if (myRandomNum7 == 1) {
            dice7Value = 2;
        }
        if (myRandomNum7 == 2) {
            dice7Value = 3;
        }
        if (myRandomNum7 == 3) {
            dice7Value = 4;
        }
        if (myRandomNum7 == 4) {
            dice7Value = 5;
        }
        if (myRandomNum7 == 5) {
            dice7Value = 6;
        }

        if (myRandomNum9 == 0) {
            dice9Value = 1;
        }
        if (myRandomNum9 == 1) {
            dice9Value = 2;
        }
        if (myRandomNum9 == 2) {
            dice9Value = 3;
        }
        if (myRandomNum9 == 3) {
            dice9Value = 4;
        }
        if (myRandomNum9 == 4) {
            dice9Value = 5;
        }
        if (myRandomNum9 == 5) {
            dice9Value = 6;
        }

        diceValuesOfSixDice.add(0, new Dice(dice1Value, dice3Value, dice4Value,
                dice6Value, dice7Value, dice9Value));

        myAdapterOfSixDice = new SixDiceAdapter(diceValuesOfSixDice);

        layoutManagerOfSixDice = new LinearLayoutManager(this);
        //layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewOfSixDice.setLayoutManager(layoutManagerOfSixDice);

        recyclerViewOfSixDice.setAdapter(myAdapterOfSixDice);

        int result = dice1Value + dice3Value + dice4Value + dice6Value + dice7Value + dice9Value;


        sharedPreferences = getSharedPreferences("prefs", MODE_PRIVATE);
        Boolean speakTotalKey = sharedPreferences.getBoolean(myDiceKeysAndValues.getSPEAK_TOTAL_KEY(), false);

        if (speakTotalKey) {

            switch (result) {
                case 6:
                    six.start();
                    break;
                case 7:
                    seven.start();
                    break;
                case 8:
                    eight.start();
                    break;
                case 9:
                    nine.start();
                    break;
                case 10:
                    ten.start();
                    break;
                case 11:
                    elven.start();
                    break;
                case 12:
                    twelve.start();
                    break;
                case 13:
                    thirteen.start();
                    break;
                case 14:
                    fourteen.start();
                    break;
                case 15:
                    fifteen.start();
                    break;
                case 16:
                    sixteen.start();
                    break;

                case 17:
                    seventeen.start();
                    break;

                case 18:
                    eighteen.start();
                    break;

                case 19:
                    nineteen.start();
                    break;

                case 20:
                    twenty.start();
                    break;

                case 21:
                    twentyOne.start();
                    break;

                case 22:
                    twentyTwo.start();
                    break;

                case 23:
                    twentyThree.start();
                    break;

                case 24:
                    twentyFour.start();
                    break;

                case 25:
                    twentyFive.start();
                    break;

                case 26:
                    twentySix.start();
                    break;

                case 27:
                    twentySeven.start();
                    break;

                case 28:
                    twentyEight.start();
                    break;

                case 29:
                    twentyNine.start();
                    break;

                case 30:
                    thirty.start();
                    break;

                case 31:
                    thirtyOne.start();
                    break;

                case 32:
                    thirtyTwo.start();
                    break;

                case 33:
                    thirtyThree.start();
                    break;

                case 34:
                    thirtyFour.start();
                    break;

                case 35:
                    thirtyFive.start();
                    break;

                case 36:
                    thirtySix.start();
                    break;
            }

        } else {
            // else speak total is off
        }


    }

    private void getNineDiceValues() {

        if (myRandomNum1 == 0) {
            dice1Value = 1;
        }
        if (myRandomNum1 == 1) {
            dice1Value = 2;
        }
        if (myRandomNum1 == 2) {
            dice1Value = 3;
        }
        if (myRandomNum1 == 3) {
            dice1Value = 4;
        }
        if (myRandomNum1 == 4) {
            dice1Value = 5;
        }
        if (myRandomNum1 == 5) {
            dice1Value = 6;
        }


        if (myRandomNum2 == 0) {
            dice2Value = 1;
        }
        if (myRandomNum2 == 1) {
            dice2Value = 2;
        }
        if (myRandomNum2 == 2) {
            dice2Value = 3;
        }
        if (myRandomNum2 == 3) {
            dice2Value = 4;
        }
        if (myRandomNum2 == 4) {
            dice2Value = 5;
        }
        if (myRandomNum2 == 5) {
            dice2Value = 6;
        }


        if (myRandomNum3 == 0) {
            dice3Value = 1;
        }
        if (myRandomNum3 == 1) {
            dice3Value = 2;
        }
        if (myRandomNum3 == 2) {
            dice3Value = 3;
        }
        if (myRandomNum3 == 3) {
            dice3Value = 4;
        }
        if (myRandomNum3 == 4) {
            dice3Value = 5;
        }
        if (myRandomNum3 == 5) {
            dice3Value = 6;
        }


        if (myRandomNum4 == 0) {
            dice4Value = 1;
        }
        if (myRandomNum4 == 1) {
            dice4Value = 2;
        }
        if (myRandomNum4 == 2) {
            dice4Value = 3;
        }
        if (myRandomNum4 == 3) {
            dice4Value = 4;
        }
        if (myRandomNum4 == 4) {
            dice4Value = 5;
        }
        if (myRandomNum4 == 5) {
            dice4Value = 6;
        }


        if (myRandomNum5 == 0) {
            dice5Value = 1;
        }
        if (myRandomNum5 == 1) {
            dice5Value = 2;
        }
        if (myRandomNum5 == 2) {
            dice5Value = 3;
        }
        if (myRandomNum5 == 3) {
            dice5Value = 4;
        }
        if (myRandomNum5 == 4) {
            dice5Value = 5;
        }
        if (myRandomNum5 == 5) {
            dice5Value = 6;
        }


        if (myRandomNum6 == 0) {
            dice6Value = 1;
        }
        if (myRandomNum6 == 1) {
            dice6Value = 2;
        }
        if (myRandomNum6 == 2) {
            dice6Value = 3;
        }
        if (myRandomNum6 == 3) {
            dice6Value = 4;
        }
        if (myRandomNum6 == 4) {
            dice6Value = 5;
        }
        if (myRandomNum6 == 5) {
            dice6Value = 6;
        }


        if (myRandomNum7 == 0) {
            dice7Value = 1;
        }
        if (myRandomNum7 == 1) {
            dice7Value = 2;
        }
        if (myRandomNum7 == 2) {
            dice7Value = 3;
        }
        if (myRandomNum7 == 3) {
            dice7Value = 4;
        }
        if (myRandomNum7 == 4) {
            dice7Value = 5;
        }
        if (myRandomNum7 == 5) {
            dice7Value = 6;
        }


        if (myRandomNum8 == 0) {
            dice8Value = 1;
        }
        if (myRandomNum8 == 1) {
            dice8Value = 2;
        }
        if (myRandomNum8 == 2) {
            dice8Value = 3;
        }
        if (myRandomNum8 == 3) {
            dice8Value = 4;
        }
        if (myRandomNum8 == 4) {
            dice8Value = 5;
        }
        if (myRandomNum8 == 5) {
            dice8Value = 6;
        }


        if (myRandomNum9 == 0) {
            dice9Value = 1;
        }
        if (myRandomNum9 == 1) {
            dice9Value = 2;
        }
        if (myRandomNum9 == 2) {
            dice9Value = 3;
        }
        if (myRandomNum9 == 3) {
            dice9Value = 4;
        }
        if (myRandomNum9 == 4) {
            dice9Value = 5;
        }
        if (myRandomNum9 == 5) {
            dice9Value = 6;
        }

        int result = dice1Value + dice2Value + dice3Value + dice4Value + dice5Value + dice6Value + dice7Value + dice8Value + dice9Value;

    }
}

