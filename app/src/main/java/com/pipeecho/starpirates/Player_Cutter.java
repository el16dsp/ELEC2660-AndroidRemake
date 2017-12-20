package com.pipeecho.starpirates;

/**
 * Created by dspip on 2017-12-20.
 */

public class Player_Cutter extends PlayerClass {
    @Override
    public void MakeClass(int Weapon1Level, int Weapon2Level) {
        // TODO Make class and add weapons
        // Class stuff
        Name = "Cutter";
        ImageBasis = "cutter";
        MaxHealth = 40;
        CurrentHealth = MaxHealth;
        Armour = 0;

        // Weapon 1 - Pistol
        Weapon_Pistol Button1 = new Weapon_Pistol();

        Button1.MakeClass();
        Button1.UpdateStats(Weapon1Level);

        // Weapon 2 - Blowtorch
    }
}
