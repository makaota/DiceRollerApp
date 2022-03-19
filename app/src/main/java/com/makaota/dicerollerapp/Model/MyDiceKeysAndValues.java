package com.makaota.dicerollerapp.Model;

import android.app.Application;

import java.util.SplittableRandom;

public class MyDiceKeysAndValues {

    private String DICE_KEY;
    private String DICE_IMAGE_KEY;
    private String BACKGROUND_COLOR_KEY;
    private String FULL_SCREEN_TOGGLE_KEY;

    private String PLAY1VALUE;
    private String PLAY2VALUE;
    private String PLAY3VALUE;
    private String PLAY4VALUE;
    private String PLAY5VALUE;
    private String PLAY6VALUE;


    private String DICE_IMAGE_ALEA;
    private String DICE_IMAGE_ALEA_A;
    private String DICE_IMAGE_DADO;
    private String DICE_IMAGE_DICE;
    private String DICE_IMAGE_DICE_A_5SQB;
    private String DICE_IMAGE_DICE_5SQA;
    private String DICE_IMAGE_DICEY;
    private String DICE_IMAGE_TERNING;
    private String DICE_IMAGE_KISMET;
    private String DICE_IMAGE_U_PLUS;

    private String CORN_FLOWER_BLUE;
    private String WHITE;
    private String MEDIUM_SEA_GREEN;
    private String LIGHT_BLUE;
    private String DARK_MAGENTA;
    private String MAGENTA;
    private String TOMATO;
    private String DARK_SHADE_OF_YELLOW;
    private String DARK_PINK;
    private String CYAN;

    private String SHAKE_TO_ROLL_KEY;
    private String ROLLING_SOUND_KEY;
    private String SPEAK_TOTAL_KEY;
    private String VIBRATE_KEY;

    private Boolean FULL_SCREEN_TOGGLE;

    public MyDiceKeysAndValues() {


        // Dice Keys
        DICE_KEY = "diceKey";
        DICE_IMAGE_KEY = "diceImageKey";
        BACKGROUND_COLOR_KEY = "backgroundColorKey";
        FULL_SCREEN_TOGGLE_KEY = "fullScreenToggleKey";
        SHAKE_TO_ROLL_KEY = "shakeToRollKey";
        ROLLING_SOUND_KEY = "rollingSoundKey";
        SPEAK_TOTAL_KEY = "speakTotal";
        VIBRATE_KEY = "vibrateKey;";


        // Dice Play Values
        PLAY1VALUE = "1";
        PLAY2VALUE = "2";
        PLAY3VALUE = "3";
        PLAY4VALUE = "4";
        PLAY5VALUE = "5";
        PLAY6VALUE = "6";


        // Dice Image Values
        DICE_IMAGE_ALEA = "alea";
        DICE_IMAGE_ALEA_A = "alea_a";
        DICE_IMAGE_DADO = "dado";
        DICE_IMAGE_DICE = "dice";
        DICE_IMAGE_DICE_A_5SQB = "dice_a_5sqb";
        DICE_IMAGE_DICE_5SQA = "dice_b_5sqa";
        DICE_IMAGE_DICEY = "dicey";
        DICE_IMAGE_TERNING = "terning";
        DICE_IMAGE_KISMET = "kismet";
        DICE_IMAGE_U_PLUS = "u_plus";



        // Background Color Values
        CORN_FLOWER_BLUE = "CornflowerBlue";
        WHITE = "White";
        MEDIUM_SEA_GREEN ="mediumSeaGreen";
        LIGHT_BLUE = "lightBlue";
        DARK_MAGENTA = "darkMagenta";
        MAGENTA = "magenta";
        TOMATO = "tomato";
        DARK_SHADE_OF_YELLOW = "darkShadeOfYellow";
        DARK_PINK = "darkPink";
        CYAN = "cyan";





    }

    public String getDICE_KEY() {
        return DICE_KEY;
    }

    public String getDICE_IMAGE_KEY() {
        return DICE_IMAGE_KEY;
    }

    public String getBACKGROUND_COLOR_KEY() {
        return BACKGROUND_COLOR_KEY;
    }

    public String getPLAY1VALUE() {
        return PLAY1VALUE;
    }

    public String getPLAY2VALUE() {
        return PLAY2VALUE;
    }

    public String getPLAY3VALUE() {
        return PLAY3VALUE;
    }

    public String getPLAY4VALUE() {
        return PLAY4VALUE;
    }

    public String getPLAY5VALUE() {
        return PLAY5VALUE;
    }

    public String getPLAY6VALUE() {
        return PLAY6VALUE;
    }

    public String getDICE_IMAGE_ALEA() {
        return DICE_IMAGE_ALEA;
    }

    public String getDICE_IMAGE_ALEA_A() {
        return DICE_IMAGE_ALEA_A;
    }

    public String getDICE_IMAGE_DADO() {
        return DICE_IMAGE_DADO;
    }

    public String getDICE_IMAGE_DICE() {
        return DICE_IMAGE_DICE;
    }

    public String getDICE_IMAGE_DICE_A_5SQB() {
        return DICE_IMAGE_DICE_A_5SQB;
    }

    public String getDICE_IMAGE_DICE_5SQA() {
        return DICE_IMAGE_DICE_5SQA;
    }

    public String getDICE_IMAGE_DICEY() {
        return DICE_IMAGE_DICEY;
    }

    public String getDICE_IMAGE_TERNING() {
        return DICE_IMAGE_TERNING;
    }

    public String getDICE_IMAGE_KISMET() {
        return DICE_IMAGE_KISMET;
    }

    public String getDICE_IMAGE_U_PLUS() {
        return DICE_IMAGE_U_PLUS;
    }




    public String getCORN_FLOWER_BLUE() {
        return CORN_FLOWER_BLUE;
    }

    public String getWHITE() {
        return WHITE;
    }

    public String getMEDIUM_SEA_GREEN() {
        return MEDIUM_SEA_GREEN;
    }

    public String getLIGHT_BLUE() {
        return LIGHT_BLUE;
    }

    public String getDARK_MAGENTA() {
        return DARK_MAGENTA;
    }

    public String getMAGENTA() {
        return MAGENTA;
    }

    public String getTOMATO() {
        return TOMATO;
    }

    public String getDARK_SHADE_OF_YELLOW() {
        return DARK_SHADE_OF_YELLOW;
    }

    public String getDARK_PINK() {
        return DARK_PINK;
    }

    public String getCYAN() {
        return CYAN;
    }


    public String getFULL_SCREEN_TOGGLE_KEY() {
        return FULL_SCREEN_TOGGLE_KEY;
    }

    public String getSHAKE_TO_ROLL_KEY() {
        return SHAKE_TO_ROLL_KEY;
    }

    public String getROLLING_SOUND_KEY() {
        return ROLLING_SOUND_KEY;
    }

    public String getSPEAK_TOTAL_KEY() {
        return SPEAK_TOTAL_KEY;
    }

    public String getVIBRATE_KEY() {
        return VIBRATE_KEY;
    }
}
