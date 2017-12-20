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
        DisplayStats();

        LevelsPerUpgrade = 1.2;

        DamagePerClick = 1 * Level;
        ClicksPerClip = 10;
        StunDuration = 0;
        AutoClickLoadRate = 0 + (Level / 5);

        ClickAmount = ClicksPerClip;

        // Display new stats
        DisplayStats();
    }

    public void MakeClass() {
        Type = "W";
        Name = "Pistol";
        Image = "pistol";
        Description = "A basic weapon for a basic pirate";
    }
}
