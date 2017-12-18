package com.pipeecho.starpirates;

import java.lang.reflect.Array;

/**
 * Created by dspiper on 2017-12-18.
 */

public class DataModel {
    Array PlayerClassArray;
    String StoredData;

    public DataModel() {
        // Constructs the playerclass array and fills it with data
    }

    public String LoadData() {
        // Will load data and return values into the string StoredData
        StoredData = "";

        // Load file and modify stuff

        return StoredData;
    }

    void SaveData(int Class, int WeaponOffset, int NewLevel) {
        // Will take the integer inputs of class and weaponoffset to pick the right spot to save
        // the new level in
    }

    String GetClassName(int Class) {
        // Takes the desired class integer and returns the name of the class
        String Name = "placeholder";

        // Do stuff here

        return Name;
    }

    String GetWeapon1Title(int Class) {
        // Takes the desired class integer and returns the name of the class' first weapon
        String Name = "placeholder";

        // Do stuff here

        return Name;
    }

    String GetWeapon2Title(int Class) {
        // Takes the desired class integer and returns the name of the class' second weapon
        String Name = "placeholder";

        // Do stuff here

        return Name;
    }

    int GetWeapon1Cost(int Class) {
        // Takes the desired class integer and returns the cost of the first weapon's next upgrade

        return 0;
    }

    int GetWeapon2Cost(int Class) {
        // Takes the desired class integer and returns the cost of the second weapon's next upgrade

        return 0;
    }

    int GetWeapon1Level(int Class) {
        // Takes the desired class integer and returns the current level of the first weapon

        return 0;
    }

    int GetWeapon2Level(int Class) {
        // Takes the desired class integer and returns the current level of the second weapon

        return 0;
    }
}
