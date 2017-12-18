package com.pipeecho.starpirates;

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

    public ObstacleClass(int DesiredLevel, String Name) {
        // The constructor for the obstacles
        // Valid obstacle names are "chest", "chest_dead", "door", "door_dead", "enemy"
        if (Name == "chest") {
            // TODO Make idle chest here
        } else if (Name == "chest_dead") {
            // TODO Make dead chest here
        } else if (Name == "door") {
            // TODO Make idle door here
        } else if (Name == "door_dead") {
            // TODO Make dead door here
        } else {
            // TODO Make enemy here
        }
    }

    public int getCurrentHealth() {
        return CurrentHealth;
    }

    public int getClickAmount() {
        return Ability.ClickAmount;
    }

    public int getMaxClicks() {
        return Ability.ClicksPerClip;
    }

    public int getAutoClicks() {
        return Ability.AutoClickLoadRate;
    }

    public String getName() {
        return Name;
    }

    public String getImage() {
        return Image;
    }

    public String getRatio() {
        String Ratio = "0/0";
        // TODO Calculate ratio
        return Ratio;
    }

    public boolean IsStunned() {
        if (StunDuration > 0) {
            return true;
        } else {
            return false;
        }
    }

    public String TakeDamage(int Damage, int Stun) {
        // Takes integers of the damage (subtracted from current health) and the stun (sets the
        // stun duration if the new value is higher)
        // Returns a string of the health ratio
        String Ratio = "0/0";
        // TODO Deal with damage here
        return Ratio;
    }
}
