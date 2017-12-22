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
    double LevelsPerUpgrade;
    int DamagePerClick;
    int ClicksPerClip;
    int ClickAmount;
    int StunDuration;
    int AutoClickLoadRate;

    public WeaponClass() {
        Name = "placeholder";
        Image = "placeholder";
        Description = "placeholder";
        UpdateStats(0);
    }

    public void UpdateStats(int DesiredLevel) {
        // Must be overridden in each sub-class
        // TODO Make sub-classes for each weapon

        // Archetype of method is below
        Level = DesiredLevel;

        // Display old stats
        DisplayStats();

        LevelsPerUpgrade = 1.0;

        DamagePerClick = Level;
        ClicksPerClip = Level;
        StunDuration = Level;
        AutoClickLoadRate = Level;

        ClickAmount = ClicksPerClip;

        // Display new stats
        DisplayStats();
    }

    public String AutoIncrement() {
        // Increments the ClickAmount by AutoClickLoadRate and returns a string of
        // ("%d/%d", ClickAmount, ClicksPerClip)
        System.out.println("WeaponClass AutoIncrement called");
        String Ratio;

        // Add one to the ClickAmount is it isn't at the maximum
        if (ClickAmount < ClicksPerClip) {
            System.out.println("Old ClickAmount is " + ClickAmount);
            ClickAmount += AutoClickLoadRate;

            // If statement to stop click amount going beyond the maximum
            if (ClickAmount > ClicksPerClip) {
                ClickAmount = ClicksPerClip;
            }

            System.out.println("New ClickAmount is " + ClickAmount);
        } else {
            System.out.println("ClickAmount maximum reached");
        }

        Ratio = GetRatio();
        System.out.println("WeaponClass AutoIncrement returning value " + Ratio);
        return Ratio;
    }

    public String ManualIncrement() {
        // Increments the ClickAmount by 1 and returns a string of
        // ("%d/%d", ClickAmount, ClicksPerClip)
        System.out.println("WeaponClass ManualIncrement called");
        String Ratio;

        // Add one to the ClickAmount is it isn't at the maximum
        if (ClickAmount < ClicksPerClip) {
            System.out.println("Old ClickAmount is " + ClickAmount);
            ClickAmount += 1;
            System.out.println("New ClickAmount is " + ClickAmount);
        } else {
            System.out.println("ClickAmount maximum reached");
        }

        Ratio = GetRatio();
        System.out.println("WeaponClass ManualIncrement returning value " + Ratio);
        return Ratio;
    }

    String GetRatio() {
        // Returns a string of ("%d/%d", ClickAmount, ClicksPerClip)
        System.out.println("WeaponClass getRatio called");
        String Ratio = ClickAmount + "/" + ClicksPerClip;
        System.out.println("WeaponClass getRatio returning value " + Ratio);
        return Ratio;
    }

    public WeaponClassDataPacket DamageDealtOnClick() {
        // Needs to return an integer of damage dealt, another integer of the stun duration and
        // then the string of the ratio

        System.out.println("WeaponClass DamageDealtOnClick called");

        WeaponClassDataPacket Packet = new WeaponClassDataPacket();

        if ((Type.equals("W")) && (ClickAmount > 0)) {
            System.out.println("Firing weapon for damage " + DamagePerClick + " and stun " + StunDuration);

            // Remove one round from the weapon
            ClickAmount -= 1;
            // Populate packet for damage, stun and ratio
            Packet.Damage = DamagePerClick;
            Packet.Stun = StunDuration;
            Packet.Ratio = GetRatio();
        } else if (Type.equals("W")) {
            System.out.println("Cannot fire weapon");
            // Populate packet for ratio (don't need to add damage and stun as they default to zero)
            Packet.Ratio = GetRatio();
        }

        if ((Type.equals("A")) && (ClickAmount == ClicksPerClip)) {
            System.out.println("Firing ability for damage " + DamagePerClick + " and stun " + StunDuration);
            // Remove all rounds from the weapon
            ClickAmount = 0;
            // Populate packet for damage, stun and ratio
            Packet.Damage = DamagePerClick;
            Packet.Stun = StunDuration;
            Packet.Ratio = GetRatio();
        } else if (Type.equals("A")) {
            System.out.println("Cannot fire ability");
            // Populate packet for ratio (don't need to add damage and stun as they default to zero)
            Packet.Ratio = GetRatio();
        }

        System.out.println("WeaponClass DamageDealtOnClick returning values:");
        return Packet;
    }

    void DisplayStats() {
        System.out.println("Damage is " + DamagePerClick);
        System.out.println("Click capacity is " + ClicksPerClip);
        System.out.println("Stun duration is " + StunDuration);
        System.out.println("Auto click rate is " + AutoClickLoadRate);
    }

    String GetName() {
        System.out.println("WeaponClass GetName called");
        System.out.println("WeaponClass GetName returning value " + Name);
        return Name;
    }
}
