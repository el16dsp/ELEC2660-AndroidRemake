package com.pipeecho.starpirates;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;

/**
 * Created by dspiper on 2017-12-18.
 */

public class DataModel {
    PlayerClass[] PlayerClassArray;
    int NUMBER_OF_CLASSES = 2;
    public static final String SAVE_NAME = "level_stats";

    DataModel() {
        // Constructs the playerclass array and fills it with data
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

    public void LoadData(View view) {
        // Will load data and return values into the string StoredData

        SharedPreferences file = view.getContext().getSharedPreferences(SAVE_NAME, 0);
        for (int Class = 0; Class < NUMBER_OF_CLASSES; Class++) {
            for (int WeaponIndex = 0; WeaponIndex <= 1; WeaponIndex++) {
                String key = String.format("%d_%d", Class, WeaponIndex);
                int Level = file.getInt(key, 1);
                PlayerClassArray[Class].Weapons[WeaponIndex].Level = Level;
                PlayerClassArray[Class].Weapons[WeaponIndex].UpdateStats(Level);
            }
        }
    }

    public void SaveData(int Class, int WeaponOffset, int NewLevel, View view) {
        // Will take the integer inputs of class and weapon offset to pick the right spot to save
        // the new level in

        SharedPreferences file = view.getContext().getSharedPreferences(SAVE_NAME, 0);
        SharedPreferences.Editor file_editor = file.edit();

        String key = String.format("%d_%d", Class, WeaponOffset);

        file_editor.putInt(key, NewLevel);

        file_editor.commit();

        PlayerClassArray[Class].Weapons[WeaponOffset].Level = NewLevel;
    }

    String GetClassName(int Class) {
        // Takes the desired class integer and returns the name of the
        System.out.println("DataModel GetClassName called");
        String Name = "placeholder";

        Name = PlayerClassArray[Class].GetName();

        System.out.println("DataModel GetClassName returning value " + Name);
        return Name;
    }

    String GetWeaponTitle(int Class, int Index) {
        // Takes the desired class integer and returns the name of the class' first weapon
        System.out.println("DataModel GetWeaponName called with values " + Class + " and " + Index);
        String Name = "placeholder";

        Name = PlayerClassArray[Class].GetWeaponName(Index);

        System.out.println("DataModel GetWeaponName returning value " + Name);
        return Name;
    }

    String GetWeaponDescription(int Class, int Index) {
        System.out.println("DataModel GetWeaponDescription called with values " + Class + " and " + Index);
        String Description = "placeholder";

        Description = PlayerClassArray[Class].GetWeaponDescription(Index);

        System.out.println("DataModel GetWeaponDescription returning value " + Description);
        return Description;
    }

    int GetClicksPerClip(int Class, int Index) {
        System.out.println("DataModel GetClicksPerClip called with values " + Class + " and " + Index);

        int ClicksPerClip = PlayerClassArray[Class].GetClicksPerClip(Index);

        System.out.println("DataModel GetClicksPerClip returning value " + ClicksPerClip);
        return ClicksPerClip;
    }

    int GetStunDuration(int Class, int Index) {
        System.out.println("DataModel GetStunDuration called with values " + Class + " and " + Index);

        int StunDuration = PlayerClassArray[Class].GetStunDuration(Index);

        System.out.println("DataModel GetStunDuration returning value " + StunDuration);
        return StunDuration;
    }

    int GetAutoClickRate(int Class, int Index) {
        System.out.println("DataModel GetAutoClickRate called with values " + Class + " and " + Index);

        int AutoClickRate = PlayerClassArray[Class].GetAutoClickRate(Index);

        System.out.println("DataModel GetAutoClickRate returning value " + AutoClickRate);
        return AutoClickRate;
    }

    int GetWeaponDamage(int Class, int Index) {
        System.out.println("DataModel GetWeaponDamage called with values " + Class + " and " + Index);
        int Damage = PlayerClassArray[Class].GetWeaponDamage(Index);
        System.out.println("DataModel GetWeaponDamage returning value " + Damage);
        return Damage;
    }

    int GetWeaponCost(int Class, int Index) {
        // Takes the desired class integer and returns the cost of the weapon's next upgrade
        System.out.println("DataModel GetWeaponCost called with values " + Class + " and " + Index);

        // Taken from Objective-C: CostPrecise = (1.0 + 0.1 * NumberOfStatsAffectedByLevelling) *
        // powf(10.0, 1 + ((1 + 0.1 * NumberOfStatsAffectedByLevelling) * CurrentLevel)/12);
        int Level = GetWeaponLevel(Class, Index);
        double UpgradesPerLevel = PlayerClassArray[Class].GetWeaponUpgradesPerLevel(Index);
        double CostPrecise = (1.0 + 0.1 * UpgradesPerLevel) * Math.pow(10.0, 1.0 + ((1.0 + 0.1 * UpgradesPerLevel) * (Level + 1))/12);
        int Cost = (int) CostPrecise;

        System.out.println("DataModel GetWeaponCost returning value " + Cost);
        return Cost;
    }

    int GetWeaponLevel(int Class, int Index) {
        // Takes the desired class integer and returns the current level of the first weapon
        System.out.println("DataModel GetWeaponCost called with values " + Class + " and " + Index);
        int Level = PlayerClassArray[Class].GetWeaponLevel(Index);
        System.out.println("DataModel GetWeaponCost returning value " + Level);
        return Level;
    }

    String GetImageBasis(int Class, int Index) {
        System.out.println("DataModel GetImageBasis called with values " + Class + " and " + Index);
        String ImageBasis = PlayerClassArray[Class].GetImageBasis(Index);
        System.out.println("DataModel GetImageBasis returning value " + ImageBasis);
        return ImageBasis;
    }
}
