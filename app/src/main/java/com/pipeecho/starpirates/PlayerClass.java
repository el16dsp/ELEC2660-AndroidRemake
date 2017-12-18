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

    public String TakeDamage(int Damage) {
        // Takes the damage in and reduces it by the armour
        // If the end value is a float, the value will be floored to the nearest integer
        // The value is then sutracted from CurrentHealth and the health ratio returned

        String Ratio = ReturnHealthRatio();
        // TODO Do damage
        return Ratio;
    }

    public String ReturnHealthRatio() {
        String Ratio = "0/0";
        // TODO Make ratio calculator
        return Ratio;
    }
}
