package com.pipeecho.starpirates;

import java.lang.reflect.Array;

/**
 * Created by dspiper on 2017-12-18.
 */

public class DataModel {
    PlayerClass[] PlayerClassArray;
    String StoredData;
    int NUMBER_OF_CLASSES = 1;

    public DataModel() {
        // Constructs the playerclass array and fills it with data
        // TODO Make the constructor
        PlayerClassArray = new PlayerClass[NUMBER_OF_CLASSES];

        PlayerClassArray[0] = new Player_Cutter();
        PlayerClassArray[0].MakeClass(1, 1);

        PlayerClassArray[0].Button1.DisplayStats();
    }

    public String LoadData() {
        // Will load data and return values into the string StoredData
        StoredData = "";

        // TODO Load file and modify stuff

        return StoredData;
    }

    public void SaveData(int Class, int WeaponOffset, int NewLevel) {
        // Will take the integer inputs of class and weaponoffset to pick the right spot to save
        // the new level in

        // TODO Save data
    }

    public String GetClassName(int Class) {
        // Takes the desired class integer and returns the name of the class
        String Name = "placeholder";

        // TODO Do stuff here

        return Name;
    }

    public String GetWeapon1Title(int Class) {
        // Takes the desired class integer and returns the name of the class' first weapon
        String Name = "placeholder";

        // TODO Do stuff here

        return Name;
    }

    public String GetWeapon2Title(int Class) {
        // Takes the desired class integer and returns the name of the class' second weapon
        String Name = "placeholder";

        // TODO Do stuff here

        return Name;
    }

    public int GetWeapon1Cost(int Class) {
        // Takes the desired class integer and returns the cost of the first weapon's next upgrade
        // TODO Find and return cost
        return 0;
    }

    public int GetWeapon2Cost(int Class) {
        // Takes the desired class integer and returns the cost of the second weapon's next upgrade
        // TODO Find and return cost
        return 0;
    }

    public int GetWeapon1Level(int Class) {
        // Takes the desired class integer and returns the current level of the first weapon
        // TODO Find and return level
        return 0;
    }

    public int GetWeapon2Level(int Class) {
        // Takes the desired class integer and returns the current level of the second weapon
        // TODO Find and return level
        return 0;
    }
}
