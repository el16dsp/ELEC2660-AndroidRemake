package com.pipeecho.starpirates;

/**
 * Created by dspip on 2017-12-22.
 */

public class Weapon_HeavyRifle extends WeaponClass {
    @Override
    public void UpdateStats(int DesiredLevel) {
        Level = DesiredLevel;

        // Display old stats
        System.out.println("Old weapon stats:");
        DisplayStats();

        LevelsPerUpgrade = 3.2;

        DamagePerClick = 3 * (1 + Level);
        ClicksPerClip = 9;
        StunDuration = 0;
        AutoClickLoadRate = 0 + (Level / 5);

        ClickAmount = ClicksPerClip;

        // Display new stats
        System.out.println("New weapon stats:");
        DisplayStats();
    }

    public Weapon_HeavyRifle() {
        System.out.println("Making heavy rifle weapon class");
        Type = "A";
        Name = "Heavy Rifle";
        Image = "heavy_rifle";
        Description = "Clears up the big things";
    }
}
