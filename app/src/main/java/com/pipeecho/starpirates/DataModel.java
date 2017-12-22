package com.pipeecho.starpirates;

/**
 * Created by dspiper on 2017-12-18.
 */

public class DataModel {
    PlayerClass[] PlayerClassArray;
    String StoredData;
    int NUMBER_OF_CLASSES = 2;

    public DataModel() {
        // Constructs the playerclass array and fills it with data
        // TODO Make the constructor
        PlayerClassArray = new PlayerClass[NUMBER_OF_CLASSES];
        System.out.println("Made space for playerclasses");

        System.out.println("Making class 0");
        PlayerClassArray[0] = new Player_Cutter();
        PlayerClassArray[0].MakeClass(1, 1);

        System.out.println("Making class 1");
        PlayerClassArray[1] = new Player_MGunner();
        PlayerClassArray[1] .MakeClass(1, 1);

        System.out.println("Classes made in DataModel");

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
        // Takes the desired class integer and returns the name of the
        System.out.println("DataModel GetClassName called");
        String Name = "placeholder";

        // TODO Do stuff here
        Name = PlayerClassArray[Class].GetName();

        System.out.println("DataModel GetClassName returning value " + Name);
        return Name;
    }

    public String GetWeapon1Title(int Class) {
        // Takes the desired class integer and returns the name of the class' first weapon
        System.out.println("DataModel GetWeapon1Name called");
        String Name = "placeholder";

        // TODO Do stuff here
        Name = PlayerClassArray[Class].GetWeapon1Name();

        System.out.println("DataModel GetWeapon1Name returning value " + Name);
        return Name;
    }

    public String GetWeapon2Title(int Class) {
        // Takes the desired class integer and returns the name of the class' second weapon
        System.out.println("DataModel GetWeapon2Name called");
        String Name = "placeholder";

        // TODO Do stuff here
        Name = PlayerClassArray[Class].GetWeapon2Name();

        System.out.println("DataModel GetWeapon2Name returning value " + Name);
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
