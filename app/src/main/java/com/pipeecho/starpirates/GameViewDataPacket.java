package com.pipeecho.starpirates;

/**
 * Created by dspip on 2017-12-18.
 */

public class GameViewDataPacket {
    int Damage;
    int Stun;
    String Ratio;

    GameViewDataPacket() {
        // Each attribute must be overridden in the game

        // Sets each attribute to a placeholder one
        Damage = 0;
        Stun = 0;
        Ratio = "0/0";
    }
}
