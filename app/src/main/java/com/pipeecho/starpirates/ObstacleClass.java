package com.pipeecho.starpirates;

import java.util.Random;
import static java.lang.Math.ceil;
import static java.lang.Math.floor;

/**
 * Created by dspiper on 2017-12-18.
 */

public class ObstacleClass {
    String Name;
    String Image;

    int Level;
    int MaxHealth;
    int CurrentHealth;
    int Armour;
    int Reward;
    int StunDuration;

    WeaponClass Ability = new WeaponClass();

    public ObstacleClass(int DesiredLevel, String TypeName) {

        // The constructor for the obstacles
        // Valid obstacle names are "chest_idle", "chest_dead", "door_idle", "door_dead", "enemy"

        Level = DesiredLevel;
        Random RandomNumber = new Random();
        if (TypeName == "chest_idle") {
            System.out.println("Constructing chest idle");

            Name = "Chest";
            Image = "chest_idle";

            MaxHealth = (6 + (RandomNumber.nextInt() % 5) ) * Level; // (6 to 10) times level

            Armour = 0;
            Reward = 0;

            Ability.AutoClickLoadRate = 0;
            Ability.DamagePerClick = 0;
            Ability.Type = "A";

            System.out.println("Generated chest (idle) of level " + Level);
        } else if (TypeName == "chest_dead") {
            System.out.println("Constructing chest dead");

            Name = "Chest";
            Image = "chest_dead";

            MaxHealth = 1;

            Armour = 0;
            Reward = (10 + (RandomNumber.nextInt() % 5) ) * Level; // (10 to 14) * level

            Ability.AutoClickLoadRate = 0;
            Ability.DamagePerClick = 0;
            Ability.Type = "A";

            System.out.println("Generated chest (dead) of level " + Level);
        } else if (TypeName == "door_idle") {
            System.out.println("Constructing door idle");

            Name = "Door";
            Image = "door_idle";

            MaxHealth = (6 + (RandomNumber.nextInt() % 5) ) * Level; // (6 to 10) * level

            Armour = 0;
            Reward = 0;

            Ability.Type = "A";
            Ability.DamagePerClick = 0;
            Ability.AutoClickLoadRate = 0;

            System.out.println("Generated door (idle) of level " + Level);
        } else if (TypeName == "door_dead") {
            System.out.println("Constructing door dead");

            Name = "Door";
            Image = "door_dead";

            MaxHealth = 1;

            Armour = 0;
            Reward = (1 + (RandomNumber.nextInt() % 5) ) * Level; // (1 to 6) * level

            Ability.Type = "A";
            Ability.DamagePerClick = 0;
            Ability.AutoClickLoadRate = 0;

            System.out.println("Generated door (dead) of level " + Level);
        } else {
            System.out.println("Constructing enemy");

            Name = "Enemy";
            Image = "enemy_idle";

            MaxHealth = (6 + (RandomNumber.nextInt() % 5)) * Level; // (6 to 10) * level

            Armour = RandomNumber.nextInt() % Level; // (0 to level)
            Reward = (1 + (RandomNumber.nextInt() % 5)) * Level; // (1 to 5) * level

            Ability.Level = DesiredLevel;
            Ability.Type = "A";
            Ability.ClicksPerClip = (int)ceil(1.0 + ((float)Level / (1 + (RandomNumber.nextInt() % Level))));
            Ability.DamagePerClick = (int)floor((float)(Level / (1 + (RandomNumber.nextInt() % Level))));
            Ability.ClickAmount = RandomNumber.nextInt() % Ability.ClicksPerClip; // Random amount of readiness
            Ability.StunDuration = 0;
            Ability.AutoClickLoadRate = 1;

            System.out.println("Generated enemy of level " + DesiredLevel);
        }
        CurrentHealth = MaxHealth;
    }

    public int GetCurrentHealth() {
        System.out.println("ObstacleClass GetCurrentHealth called");
        if (CurrentHealth < 0) {
            CurrentHealth = 0;
        }
        System.out.println("ObstacleClass GetCurrentHealth returning value " + CurrentHealth);
        return CurrentHealth;
    }

    public int GetClickAmount() {
        //System.out.println("ObstacleClass GetClickAmount called");
        //System.out.println("ObstacleClass GetClickAmount returning value " + Ability.ClickAmount);
        return Ability.ClickAmount;
    }

    public int GetMaxClicks() {
        //System.out.println("ObstacleClass GetMaxClicks called");
        //System.out.println("ObstacleClass GetMaxClicks returning value " + Ability.ClicksPerClip);
        return Ability.ClicksPerClip;
    }

    public int GetAutoClicks() {
        //System.out.println("ObstacleClass GetAutoClicks called");
        //System.out.println("ObstacleClass GetAutoClicks returning value " + Ability.AutoClickLoadRate);
        return Ability.AutoClickLoadRate;
    }

    public String GetName() {
        //System.out.println("ObstacleClass GetName called");
        //System.out.println("ObstacleClass GetName returning value " + Name);
        return Name;
    }

    public String GetImage() {
        //System.out.println("ObstacleClass GetImage called");
        //System.out.println("ObstacleClass GetImage returning value " + Image);
        return Image;
    }

    public String GetRatio() {
        //System.out.println("ObstacleClass GetRatio called");
        String Ratio = CurrentHealth + "/" + MaxHealth;
        //System.out.println("ObstacleClass GetRatio returning value " + Ratio);
        return Ratio;
    }

    public boolean IsStunned() {
        //System.out.println("ObstacleClass IsStunned called");
        if (StunDuration > 0) {
            System.out.println("ObstacleClass IsStunned returning value true");
            return true;
        } else {
            System.out.println("ObstacleClass IsStunned returning value false");
            return false;
        }
    }

    public String TakeDamage(WeaponClassDataPacket Data) {
        // Takes integers of the damage (subtracted from current health) and the stun (sets the
        // stun duration if the new value is higher)
        // Returns a string of the health ratio

        // Deal with stun logic
        System.out.println("Obstacle stunned for " + Data.Stun);
        if (StunDuration < Data.Stun) {
            StunDuration = Data.Stun;
        }
        System.out.println("Obstacle stunned for " + Data.Stun + " to " + StunDuration);

        // Deal with damage logic
        System.out.println("Obstacle taking damage of " + Data.Damage + " from " + CurrentHealth + " to " + (CurrentHealth - Data.Damage));
        CurrentHealth -= Data.Damage;
        if (CurrentHealth < 0) {
            CurrentHealth = 0;
        }
        String Ratio = GetRatio();
        System.out.println("Obstacle health is " + Ratio);

        return Ratio;
    }
}
