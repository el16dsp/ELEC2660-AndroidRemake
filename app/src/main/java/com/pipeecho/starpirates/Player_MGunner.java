package com.pipeecho.starpirates;

/**
 * Created by dspip on 2017-12-22.
 */

public class Player_MGunner extends PlayerClass {
    @Override
    public void MakeClass(int Weapon1Level, int Weapon2Level) {
        // Class stuff
        System.out.println("Making master gunner class");
        Name = "Master Gunner";
        ImageBasis = "master_gunner";
        MaxHealth = 60;
        CurrentHealth = MaxHealth;
        Armour = 50;

        // Weapon 1 - Stun rig
        Weapons[0] = new Weapon_StunRig();
        Weapons[0].UpdateStats(Weapon1Level);

        // Weapon 2 - Heavy Rifle
        Weapons[1] = new Weapon_HeavyRifle();
        Weapons[1].UpdateStats(Weapon2Level);
    }
}
