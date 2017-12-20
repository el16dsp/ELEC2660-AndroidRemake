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

    public PlayerClass() {
        // Blank constructor
        // Needs to be overwritten for each class
        Name = "placeholder";
        ImageBasis = "placeholder.png";

        MaxHealth = 1;
        CurrentHealth = MaxHealth;
        Armour = 0;

        Button1.Type = "W";

        Button1.Name = "placeholder";
        Button1.Image = "placeholder.png";
        Button1.Description = "placeholder";

        Button1.Level = 0;
        Button1.LevelsPerUpgrade = 1.0;
        Button1.DamagePerClick = 0;
        Button1.ClicksPerClip = 1;
        Button1.ClickAmount = Button1.ClicksPerClip;
        Button1.StunDuration = 0;
        Button1.AutoClickLoadRate = 0;

        Button2.Type = "W";

        Button2.Name = "placeholder";
        Button2.Image = "placeholder.png";
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
