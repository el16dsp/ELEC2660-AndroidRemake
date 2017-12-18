package com.pipeecho.starpirates;

/**
 * Created by dspiper on 2017-12-18.
 */

public class WeaponClass {
    String Type;
    // Will be either @"A" or @"W"
    // 'W' or weapon types will consume one 'click' per use and will do one set of damage. They
    // need to be topped up by pressing on it's button
    // 'A' or ability types will need to be charged up by pressing the button a few times then do
    // an effect on the obstacle

    // Fluff related stuff
    String Name;
    String Image;
    String Description;

    int Level;
    float LevelsPerUpgrade;
    int DamagePerClick;
    int ClicksPerClip;
    int ClickAmount;
    int StunDuration;
    int AutoClickLoadRate;

    void UpdateStats() {
        // Must be overridden in each sub-class
        // TODO Make sub-classes for each weapon
    }

    String AutoIncrement() {
        // Increments the ClickAmount by AutoClickLoadRate and returns a string of
        // ("%d/%d", ClickAmount, ClicksPerClip)
        String Ratio = "0/0";

        // TODO Do stuff here

        Ratio = GetRatio();

        return Ratio;
    }

    String ManualIncrement() {
        // Increments the ClickAmount by 1 and returns a string of
        // ("%d/%d", ClickAmount, ClicksPerClip)
        String Ratio = "0/0";

        // TODO Do stuff here

        Ratio = GetRatio();

        return Ratio;
    }

    String GetRatio() {
        // Returns a string of ("%d/%d", ClickAmount, ClicksPerClip)
        String Ratio = "0/0";

        // TODO Do stuff here

        return Ratio;
    }

    WeaponClassDataPacket DamageDealtOnClick() {
        // Needs to return an integer of damage dealt, another integer of the stun duration and
        // then the string of the ratio

        WeaponClassDataPacket Packet = new WeaponClassDataPacket();

        // TODO Calculate damage and populate packet

        return Packet;
    }
}
