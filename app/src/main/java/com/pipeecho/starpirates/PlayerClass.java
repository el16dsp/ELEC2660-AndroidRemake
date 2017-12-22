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

    public void MakeClass(int Weapon1Level, int Weapon2Level) {
        // Blank constructor
        // Needs to be overwritten for each class
        Name = "placeholder";
        ImageBasis = "placeholder";

        MaxHealth = 1;
        CurrentHealth = MaxHealth;
        Armour = 0;

        // Make placeholder weapon
        // This can be overridden by one of the weapons
        Button1.Type = "W";

        Button1.Name = "placeholder";
        Button1.Image = "placeholder";
        Button1.Description = "placeholder";

        Button1.Level = 0;
        Button1.LevelsPerUpgrade = 1.0;
        Button1.DamagePerClick = 0;
        Button1.ClicksPerClip = 1;
        Button1.ClickAmount = Button1.ClicksPerClip;
        Button1.StunDuration = 0;
        Button1.AutoClickLoadRate = 0;

        // Make placeholder weapon
        // This can be overridden by one of the weapons
        Button2.Type = "W";

        Button2.Name = "placeholder";
        Button2.Image = "placeholder";
        Button2.Description = "placeholder";

        Button2.Level = 0;
        Button2.LevelsPerUpgrade = 1.0;
        Button2.DamagePerClick = 0;
        Button2.ClicksPerClip = 1;
        Button2.ClickAmount = Button1.ClicksPerClip;
        Button2.StunDuration = 0;
        Button2.AutoClickLoadRate = 0;
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
        String Name = Button1.GetName();
        System.out.println("PlayerClass GetWeapon1Name returning value " + Name);
        return Name;
    }

    String GetWeapon2Name() {
        System.out.println("PlayerClass GetWeapon2Name called");
        String Name = Button2.GetName();
        System.out.println("PlayerClass GetWeapon2Name returning value " + Name);
        return Name;
    }

    String GetName() {
        System.out.println("PlayerClass GetName called");
        System.out.println("PlayerClass GetName returning value " + Name);
        return Name;
    }
}