package com.pipeecho.starpirates;

/**
 * Created by dspip on 2017-12-23.
 */

public class GameClassDataPacket {
    String HealthRatio;
    String Button1Ratio;
    String Button2Ratio;
    int Coins;
    int Turns;
    String ObstacleImageTitle;
    String PlayerImageTitle;

    public GameClassDataPacket() {
        // Each attribute must be overridden in the game

        // Sets each attribute to a placeholder one
        HealthRatio = "1/1";
        Button1Ratio = "0/1";
        Button2Ratio = "0/1";
        Coins = 0;
        Turns = 0;
        ObstacleImageTitle = "placeholder";

    }
}
