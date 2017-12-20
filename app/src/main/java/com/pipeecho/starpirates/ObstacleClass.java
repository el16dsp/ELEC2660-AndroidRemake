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

    WeaponClass Ability;

    public ObstacleClass(int DesiredLevel, String TypeName) {

        // The constructor for the obstacles
        // Valid obstacle names are "chest", "chest_dead", "door", "door_dead", "enemy"

        Level = DesiredLevel;
        Random RandomNumber = new Random();
        if (TypeName == "chest") {

            Name = "Chest";
            Image = "chest_idle.png";

            MaxHealth = (6 + (RandomNumber.nextInt() % 5) ) * Level; // (6 to 10) times level

            Armour = 0;
            Reward = 0;

            Ability.AutoClickLoadRate = 0;
            Ability.DamagePerClick = 0;
            Ability.Type = "A";

            System.out.println("Generated chest (idle) of level " + Level);
        } else if (TypeName == "chest_dead") {

            Name = "Chest";
            Image = "chest_dead.png";

            MaxHealth = 1;

            Armour = 0;
            Reward = (10 + (RandomNumber.nextInt() % 5) ) * Level; // (10 to 14) * level

            Ability.AutoClickLoadRate = 0;
            Ability.DamagePerClick = 0;
            Ability.Type = "A";

            System.out.println("Generated chest (dead) of level " + Level);
        } else if (TypeName == "door") {

            Name = "Door";
            Image = "door_idle.png";

            MaxHealth = (6 + (RandomNumber.nextInt() % 5) ) * Level; // (6 to 10) * level

            Armour = 0;
            Reward = 0;

            Ability.Type = "A";
            Ability.DamagePerClick = 0;
            Ability.AutoClickLoadRate = 0;

            System.out.println("Generated door (idle) of level " + Level);
        } else if (TypeName == "door_dead") {

            Name = "Door";
            Image = "door_dead.png";

            MaxHealth = 1;

            Armour = 0;
            Reward = (1 + (RandomNumber.nextInt() % 5) ) * Level; // (1 to 6) * level

            Ability.Type = "A";
            Ability.DamagePerClick = 0;
            Ability.AutoClickLoadRate = 0;

            System.out.println("Generated door (dead) of level " + Level);
        } else {
            Name = "Enemy";
            Image = "enemy_idle.png";

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

    public int getCurrentHealth() {
        System.out.println("ObstacleClass getCurrentHealth called");
        if (CurrentHealth < 0) {
            CurrentHealth = 0;
        }
        System.out.println("ObstacleClass getCurrentHealth returning value " + CurrentHealth);
        return CurrentHealth;
    }

    public int getClickAmount() {
        System.out.println("ObstacleClass getClickAmount called");
        System.out.println("ObstacleClass getClickAmount returning value " + Ability.ClickAmount);
        return Ability.ClickAmount;
    }

    public int getMaxClicks() {
        System.out.println("ObstacleClass getMaxClicks called");
        System.out.println("ObstacleClass getMaxClicks returning value " + Ability.ClicksPerClip);
        return Ability.ClicksPerClip;
    }

    public int getAutoClicks() {
        System.out.println("ObstacleClass getAutoClicks called");
        System.out.println("ObstacleClass getAutoClicks returning value " + Ability.AutoClickLoadRate);
        return Ability.AutoClickLoadRate;
    }

    public String getName() {
        System.out.println("ObstacleClass getName called");
        System.out.println("ObstacleClass getName returning value " + Name);
        return Name;
    }

    public String getImage() {
        System.out.println("ObstacleClass getImage called");
        System.out.println("ObstacleClass getImage returning value " + Image);
        return Image;
    }

    public String getRatio() {
        System.out.println("ObstacleClass getRatio called");
        String Ratio = CurrentHealth + "/" + MaxHealth;
        System.out.println("ObstacleClass getRatio returning value " + Ratio);
        return Ratio;
    }

    public boolean IsStunned() {
        System.out.println("ObstacleClass IsStunned called");
        if (StunDuration > 0) {
            System.out.println("ObstacleClass IsStunned returning value true");
            return true;
        } else {
            System.out.println("ObstacleClass IsStunned returning value false");
            return false;
        }
    }

    public String TakeDamage(int Damage, int Stun) {
        // Takes integers of the damage (subtracted from current health) and the stun (sets the
        // stun duration if the new value is higher)
        // Returns a string of the health ratio

        // Deal with stun logic
        System.out.println("Obstacle stunned for " + StunDuration);
        if (StunDuration < Stun) {
            StunDuration = Stun;
        }
        System.out.println("Obstacle stunned for " + Stun + " to " + StunDuration);

        // Deal with damage logic
        System.out.println("Obstacle taking damage of " + Damage + " from " + CurrentHealth + " to " + (CurrentHealth - Damage));
        CurrentHealth -= Damage;
        if (CurrentHealth < 0) {
            CurrentHealth = 0;
        }
        String Ratio = getRatio();
        System.out.println("Obstacle health is " + Ratio);

        return Ratio;
    }
}
