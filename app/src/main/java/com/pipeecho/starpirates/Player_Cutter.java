package com.pipeecho.starpirates;

/**
 * Created by dspip on 2017-12-20.
 */

public class Player_Cutter extends PlayerClass {


    @Override
    public void MakeClass(int Weapon1Level, int Weapon2Level) {
        // Class stuff
        System.out.println("Making cutter class");
        Name = "Cutter";
        ImageBasis = "cutter";
        MaxHealth = 40;
        CurrentHealth = MaxHealth;
        Armour = 0;

        // Weapon 1 - Pistol
        Weapons[0] = new Weapon_Pistol();
        Weapons[0].UpdateStats(Weapon1Level);

        // Weapon 2 - Blowtorch
        Weapons[1] = new Weapon_Blowtorch();
        Weapons[1].UpdateStats(Weapon2Level);
    }
}
