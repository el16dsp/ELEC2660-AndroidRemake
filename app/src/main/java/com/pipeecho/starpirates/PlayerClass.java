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

    WeaponClass[] Weapons = new WeaponClass[2];

    public void MakeClass(int Weapon1Level, int Weapon2Level) {
        // Blank constructor
        // Needs to be overwritten for each class
        Name = "placeholder";
        ImageBasis = "placeholder";

        MaxHealth = 1;
        CurrentHealth = MaxHealth;
        Armour = 0;

        Weapons[0] = new WeaponClass();
        Weapons[1] = new WeaponClass();
    }

    public String TakeDamage(int Damage) {
        // Takes the damage in and reduces it by the armour
        // If the end value is a float, the value will be floored to the nearest integer
        // The value is then subtracted from CurrentHealth and the health ratio returned

        String Ratio = ReturnHealthRatio();
        // TODO Do damage
        return Ratio;
    }

    String ReturnHealthRatio() {
        System.out.println("PlayerClass ReturnHealthRatio called");
        String Ratio = CurrentHealth + "/" + MaxHealth;
        System.out.println("PlayerClass ReturnHealthRatio returning value " + Ratio);
        return Ratio;
    }

    String GetWeapon1Name() {
        System.out.println("PlayerClass GetWeapon1Name called");
        String Name = Weapons[0].GetName();
        System.out.println("PlayerClass GetWeapon1Name returning value " + Name);
        return Name;
    }

    String GetWeapon2Name() {
        System.out.println("PlayerClass GetWeapon2Name called");
        String Name = Weapons[1].GetName();
        System.out.println("PlayerClass GetWeapon2Name returning value " + Name);
        return Name;
    }

    String GetName() {
        System.out.println("PlayerClass GetName called");
        System.out.println("PlayerClass GetName returning value " + Name);
        return Name;
    }
}