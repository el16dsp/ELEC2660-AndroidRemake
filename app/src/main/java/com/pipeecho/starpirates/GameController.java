package com.pipeecho.starpirates;

import java.util.Random;

/**
 * Created by dspiper on 2017-12-18.
 */

public class GameController {
    // TODO Make game
    // Variables
    PlayerClass Player;
    DataModel Data = new DataModel();
    int Coins = 0;
    int Turns = 0;
    int ObstacleIndex = 0;
    int RoomNumber = 0;
    ObstacleClass[] ObstacleList;

    // Constants
    int ENCOUNTER_OFFSET = 100;
    int ENCOUNTER_RANGE = 300;
    int ENCOUNTER_ENEMY_CHANCE = 5;
    int ENCOUNTER_CHEST_CHANCE = 2;
    int ENCOUNTER_DOOR_CHANCE = 3;
    int ENCOUNTER_TOTAL_CHANCE = ENCOUNTER_ENEMY_CHANCE + ENCOUNTER_CHEST_CHANCE + ENCOUNTER_DOOR_CHANCE;
    int ENCOUNTER_LEVEL_RANGE = 3;

    public GameController(int Class) {
        Player = Data.PlayerClassArray[Class];

        GenerateObstacaleList();
    }

    public ObstacleClass GetCurrentObstacle() {
        System.out.println("GameController GetCurrentObstacle called");
        ObstacleClass CurrentObstacle = ObstacleList[ObstacleIndex];
        System.out.println("GameController GetCurrentObstacle returning obstacle " + CurrentObstacle);
        return CurrentObstacle;
    }

    public int GenerateObstacaleList() {
        System.out.println("GameController GenerateObstacleList called");

        // Get random number generator
        Random RandomNumber = new Random();
        System.out.println("Random number generator initialised");

        // Get number of encounters and their levels
        int Encounters = 1 + ((Turns + 1) % (ENCOUNTER_OFFSET + (RandomNumber.nextInt() % ENCOUNTER_RANGE)));
        int DesiredLevel = 1 + (Coins / (1 + (RandomNumber.nextInt() % ENCOUNTER_LEVEL_RANGE)));
        System.out.println("Generating " + Encounters + " obstacles of level " + DesiredLevel);

        // Set array's size to that of encounters
        ObstacleList = new ObstacleClass[Encounters];

        // Add obstacles to the array
        int Index = 0;
        while (Index < Encounters) {
            // Pick random number between 0 and ENCOUNTER_TOTAL_CHANCE
            int RandomRoll = Math.abs(RandomNumber.nextInt() % ENCOUNTER_TOTAL_CHANCE);

            // Decide whether obstacle is a chest, door or enemy
            if (RandomRoll <= ENCOUNTER_CHEST_CHANCE && Index != (Encounters - 1)) {
                System.out.println("Picked idle chest of level " + DesiredLevel + " in index " + Index);
                System.out.println("Picked dead chest of level " + DesiredLevel + " in index " + (Index + 1));

                // Generate chests
                ObstacleClass chest_idle = new ObstacleClass(DesiredLevel, "chest_idle");
                ObstacleClass chest_dead = new ObstacleClass(DesiredLevel, "chest_dead");

                // Add obstacles to the list
                ObstacleList[Index] = chest_idle;
                Index++;
                ObstacleList[Index] = chest_dead;
                Index++;
            } else if (RandomRoll <= (ENCOUNTER_CHEST_CHANCE + ENCOUNTER_DOOR_CHANCE) || Index == (Encounters - 1)) {
                System.out.println("Picked idle door of level " + DesiredLevel + " in index " + Index);
                System.out.println("Picked dead door of level " + DesiredLevel + " in index " + (Index + 1));

                // Generate doors
                ObstacleClass door_idle = new ObstacleClass(DesiredLevel, "door_idle");
                ObstacleClass door_dead = new ObstacleClass(DesiredLevel, "door_dead");

                // Add obstacles to the list
                ObstacleList[Index] = door_idle;
                Index++;
                ObstacleList[Index] = door_dead;
                Index++;
            } else {
                System.out.println("Picked enemy of level " + DesiredLevel + " in index " + Index);

                // Generate enemy
                ObstacleClass enemy = new ObstacleClass(DesiredLevel, "enemy");

                // Add obstacles to the list
                ObstacleList[Index] = enemy;
                Index++;
            }
        }

        System.out.println("GameController GenerateObstacleList returning number of encounters: " + Encounters);
        return Encounters;
    }
}
