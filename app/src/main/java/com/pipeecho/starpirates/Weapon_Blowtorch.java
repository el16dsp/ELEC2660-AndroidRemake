package com.pipeecho.starpirates;

/**
 * Created by dspip on 2017-12-20.
 */

public class Weapon_Blowtorch extends WeaponClass {
    @Override
    public void UpdateStats(int DesiredLevel) {
        Level = DesiredLevel;

        // Display old stats
        System.out.println("Old weapon stats:");
        DisplayStats();

        LevelsPerUpgrade = 2.0;

        DamagePerClick = 2 + Level;
        ClicksPerClip = 10;
        StunDuration = 4 + Level;
        AutoClickLoadRate = 0;

        ClickAmount = ClicksPerClip;

        // Display new stats
        System.out.println("New weapon stats:");
        DisplayStats();
    }

    public Weapon_Blowtorch() {
        System.out.println("Making blowtorch weapon class");
        Type = "A";
        Name = "Blowtorch";
        Image = "blowtorch";
        Description = "A versatile tool for a versatile pirate";
    }
}
