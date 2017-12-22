package com.pipeecho.starpirates;

/**
 * Created by dspip on 2017-12-22.
 */

public class Weapon_StunRig extends WeaponClass {
    @Override
    public void UpdateStats(int DesiredLevel) {
        Level = DesiredLevel;

        // Display old stats
        System.out.println("Old weapon stats:");
        DisplayStats();

        LevelsPerUpgrade = 1.1;

        DamagePerClick = 0;
        ClicksPerClip = 5;
        StunDuration = 1 + Level;
        AutoClickLoadRate = 0 + (Level / 10);

        ClickAmount = ClicksPerClip;

        // Display new stats
        System.out.println("New weapon stats:");
        DisplayStats();
    }

    public Weapon_StunRig() {
        System.out.println("Making stun rig weapon class");
        Type = "A";
        Name = "Stun Rig";
        Image = "stun_rig";
        Description = "Lights up the big things";
    }
}
