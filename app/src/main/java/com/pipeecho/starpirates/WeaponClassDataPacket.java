package com.pipeecho.starpirates;

/**
 * Created by dspip on 2017-12-18.
 */

public class WeaponClassDataPacket {
    int Damage;
    int Stun;
    String Ratio;

    WeaponClassDataPacket() {
        // Each attribute must be overridden in the game

        // Sets each attribute to a placeholder one
        Damage = 0;
        Stun = 0;
        Ratio = "0/0";
    }
}
