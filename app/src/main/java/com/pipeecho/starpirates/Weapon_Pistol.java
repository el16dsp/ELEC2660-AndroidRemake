package com.pipeecho.starpirates;

import android.text.style.ClickableSpan;

/**
 * Created by dspip on 2017-12-20.
 */

public class Weapon_Pistol extends WeaponClass {
    @Override
    public void UpdateStats(int DesiredLevel) {
        Level = DesiredLevel;

        // Display old stats
        System.out.println("Old weapon stats:");
        DisplayStats();

        LevelsPerUpgrade = 1.2;

        DamagePerClick = 1 * Level;
        ClicksPerClip = 10;
        StunDuration = 0;
        AutoClickLoadRate = 0 + (Level / 5);

        ClickAmount = ClicksPerClip;

        // Display new stats
        System.out.println("New weapon stats:");
        DisplayStats();
    }

    public Weapon_Pistol() {
        System.out.println("Making pistol weapon class");
        Type = "W";
        Name = "Pistol";
        Image = "pistol";
        Description = "A basic weapon for a basic pirate";
    }
}
