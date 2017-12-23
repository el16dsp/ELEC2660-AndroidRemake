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

    String TakeDamage(int Damage) {
        // Takes the damage in and reduces it by the armour
        // If the end value is a float, the value will be floored to the nearest integer
        // The value is then subtracted from CurrentHealth and the health ratio returned

        // Process armour effect
        int DamageTaken = (int) (100.0 * Damage / (100.0 + Armour));

        // Take damage from health
        CurrentHealth -= DamageTaken;
        if (CurrentHealth < 0) {
            CurrentHealth = 0;
        }
        // Get ratio
        String Ratio = ReturnHealthRatio();

        return Ratio;
    }

    String ReturnHealthRatio() {
        //System.out.println("PlayerClass ReturnHealthRatio called");
        String Ratio = CurrentHealth + "/" + MaxHealth;
        //System.out.println("PlayerClass ReturnHealthRatio returning value " + Ratio);
        return Ratio;
    }

    String GetWeaponName(int Index) {
        //System.out.println("PlayerClass GetWeaponName called");
        String Name = Weapons[Index].GetName();
        //System.out.println("PlayerClass GetWeaponName returning value " + Name);
        return Name;
    }

    String GetName() {
        //System.out.println("PlayerClass GetName called");
        //System.out.println("PlayerClass GetName returning value " + Name);
        return Name;
    }

    String GetWeaponDescription(int Index) {
        //System.out.println("PlayerClass GetWeaponDescription called for value " + Index);
        String Description = Weapons[Index].Description;
        //System.out.println("PlayerClass GetWeaponDescription returning value " + Description);
        return Description;
    }

    int GetWeaponDamage(int Index) {
        //System.out.println("PlayerClass GetWeaponDamage called for value " + Index);
        int Damage = Weapons[Index].DamagePerClick;
        //System.out.println("PlayerClass GetWeaponDamage returning value " + Damage);
        return Damage;
    }

    int GetClicksPerClip(int Index){
        //System.out.println("PlayerClass GetClicksPerClip called for value " + Index);
        int ClicksPerClip = Weapons[Index].ClicksPerClip;
        //System.out.println("PlayerClass GetClicksPerClip returning value " + ClicksPerClip);
        return ClicksPerClip;
    }

    int GetStunDuration(int Index) {
        //System.out.println("PlayerClass GetStunDuration called for value " + Index);
        int StunDuration = Weapons[Index].StunDuration;
        //System.out.println("PlayerClass GetStunDuration returning value " + StunDuration);
        return StunDuration;
    }

    int GetAutoClickRate(int Index) {
        //System.out.println("PlayerClass GetAutoClickRate called for value " + Index);
        int AutoClickLoadRate = Weapons[Index].AutoClickLoadRate;
        //System.out.println("PlayerClass GetAutoClickRate returning value " + AutoClickLoadRate);
        return AutoClickLoadRate;
    }

    int GetWeaponLevel(int Index) {
        //System.out.println("PlayerClass GetWeaponLevel called for value " + Index);
        int Level = Weapons[Index].Level;
        //System.out.println("PlayerClass GetWeaponLevel returning value " + Level);
        return Level;
    }

    double GetWeaponUpgradesPerLevel(int Index) {
        //System.out.println("PlayerClass GetWeaponUpgradesPerLevel called for value " + Index);
        double LevelsPerUpgrade = Weapons[Index].LevelsPerUpgrade;
        //System.out.println("PlayerClass GetWeaponUpgradesPerLevel returning value " + LevelsPerUpgrade);
        return LevelsPerUpgrade;
    }

    String GetImageBasis(int Index) {
        //System.out.println("PlayerClass GetImageBasis called for value " + Index);
        String ImageName = Weapons[Index].Image;
        //System.out.println("PlayerClass GetImageBasis returning value " + ImageName);
        return ImageName;
    }
}