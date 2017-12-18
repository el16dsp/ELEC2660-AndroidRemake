package com.pipeecho.starpirates;

/**
 * Created by dspiper on 2017-12-18.
 */

public class PlayerClass {
    String Name;
    String ImageBasis;

    int MaxHealth;
    int CurrentHealth;
    int Armour;

    WeaponClass Button1;
    WeaponClass Button2;

    String TakeDamage(int Damage) {
        // Takes the damage in and reduces it by the armour
        // If the end value is a float, the value will be floored to the nearest integer
        // The value is then sutracted from CurrentHealth and the health ratio returned

        String Ratio = ReturnHealthRatio();

        return Ratio;
    }

    String ReturnHealthRatio() {
        String Ratio = "0/0";

        return Ratio;
    }
}
