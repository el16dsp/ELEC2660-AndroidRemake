package com.pipeecho.starpirates;

import java.util.Random;

/**
 * Created by dspiper on 2017-12-18.
 */

public class GameController {
    // TODO Make game
    // Variables
    PlayerClass Player;
    DataModel Data;
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
        Data = new DataModel();
        Player = Data.PlayerClassArray[Class];
        System.out.println("Loaded player class " + Player.GetName());

        GenerateObstacleList();
    }

    ObstacleClass GetCurrentObstacle() {
        //System.out.println("GameController GetCurrentObstacle called");
        ObstacleClass CurrentObstacle = ObstacleList[ObstacleIndex];
        //System.out.println("GameController GetCurrentObstacle returning obstacle " + CurrentObstacle);
        return CurrentObstacle;
    }

    int GenerateObstacleList() {
        System.out.println("GameController GenerateObstacleList called");

        // Get random number generator
        Random RandomNumber = new Random();
        System.out.println("Random number generator initialised");

        // Get number of encounters and their levels
        int Encounters = 2 + ((Turns + 1) % (ENCOUNTER_OFFSET + (Math.abs(RandomNumber.nextInt()) % ENCOUNTER_RANGE)));
        int DesiredLevel = 1 + (Coins / (1 + (Math.abs(RandomNumber.nextInt()) % ENCOUNTER_LEVEL_RANGE)));
        System.out.println("Generating " + Encounters + " obstacles of level " + DesiredLevel);

        // Set array's size to that of encounters
        ObstacleList = new ObstacleClass[Encounters];

        // Add obstacles to the array
        int Index = 0;
        while (Index < Encounters) {
            // TODO This still causes the app to crash. Fix.
            // Pick random number between 0 and ENCOUNTER_TOTAL_CHANCE
            int RandomRoll = Math.abs(RandomNumber.nextInt() % ENCOUNTER_TOTAL_CHANCE);
            System.out.println("Index: " + Index + " Encounters: " + Encounters + " Roll: " + RandomRoll);

            // Decide whether obstacle is a chest, door or enemy
            int LastEncounter = Encounters - 2;
            if (RandomRoll <= ENCOUNTER_CHEST_CHANCE && Index <= (LastEncounter - 2)) {
                // If rolled for and not the last encounter...
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
            } else if (RandomRoll <= (ENCOUNTER_CHEST_CHANCE + ENCOUNTER_DOOR_CHANCE) && (Index <= LastEncounter)) {
                // If rolled for or is the last encounter...
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

    int GetRatioNumerator(String Ratio) {
        // Turns a ratio such as "1/1" or "10/40" and gets the numerator as an integer
        // System.out.println("GameController GetRatioNumerator called with ratio " + Ratio);

        // Find "/"
        int SlashIndex = Ratio.indexOf("/");
        // Get string of all chars before "/"
        String Numerator = Ratio.substring(0, SlashIndex);
        // Convert value to integer
        // Taken from https://stackoverflow.com/questions/5585779/how-to-convert-a-string-to-an-int-in-java
        int IntNumerator = Integer.parseInt(Numerator);

        // System.out.println("GameController GetRatioNumerator returning value " + IntNumerator);
        return IntNumerator;
    }

    int GetRatioDenominator(String Ratio) {
        // Turns a ratio such as "1/1" or "10/40" and gets the denominator as an integer
        // System.out.println("GameController GetRatioDenominator called with ratio " + Ratio);

        // Find "/"
        int SlashIndex = Ratio.indexOf("/");
        // Get string of all chars before "/"
        String Denominator = Ratio.substring(SlashIndex + 1);
        // Convert value to integer
        // Taken from https://stackoverflow.com/questions/5585779/how-to-convert-a-string-to-an-int-in-java
        int IntDenominator = Integer.parseInt(Denominator);

        // System.out.println("GameController GetRatioDenominator returning value " + IntDenominator);
        return IntDenominator;
    }

    String GetButtonText(int Weapon) {
        // If weapon type is 'A', have "Charge..."
        // If weapon type is 'W', have "Load..."
        String Type = Player.Weapons[Weapon].Type;
        String ButtonText = "placeholder";

        // Get weapon name
        String Name = Player.GetWeaponName(Weapon);

        if (Type.equals("A")) {
            ButtonText = "Charge " + Name;
        } else if (Type.equals("W")) {
            ButtonText = "Load " + Name;
        }
        return ButtonText;
    }

    GameClassDataPacket OnAnyTick() {
        // Generic turn protocol
        GameClassDataPacket Data = new GameClassDataPacket();

        ObstacleClass Obstacle = GetCurrentObstacle();
        System.out.println(String.format("/// TURN %04d BEGIN \\\\\\", Turns + 1));

        Data.ObstacleImageTitle = Obstacle.Image;

        // Call obstacle weapon increment
        Obstacle.Ability.AutoIncrement();

        // Call auto-increment for player weapons
        Player.Weapons[0].AutoIncrement();
        Player.Weapons[1].AutoIncrement();

        // Obstacle attack logic
        // If obstacle is stunned or not an enemy, it can't attack
        // TODO Obstacle doesn't attack player. Fix.
        if (!Obstacle.IsStunned() && Obstacle.GetName().equals("enemy")) {
            System.out.println("Enemy is not stunned");

            // Fetch obstacle weapon ratio
            String ObstacleWeaponRatio = Obstacle.Ability.GetRatio();
            int Denominator = GetRatioDenominator(ObstacleWeaponRatio);
            int Numerator = GetRatioNumerator(ObstacleWeaponRatio);
            if (Denominator == 0) {
                Denominator = 1;
            }
            if (Numerator == 0) {
                Numerator = 1;
            }

            if (Numerator == Denominator) {
                // If obstacle amount is full, fire

                WeaponClassDataPacket Damage = Obstacle.Ability.DamageDealtOnClick();
                // Since there are no mechanics for the player to be stunned, only the damage
                // is cared about
                System.out.println("Obstacle attacks for " + Damage.Damage + " damage");

                // Apply damage to the player
                Data.HealthRatio = Player.TakeDamage(Damage.Damage);
            }
        }

        // If obstacle is an enemy, select it's image
        if (Obstacle.GetName().equals("enemy")) {
            // If obstacle will be stunned during next turn, set image to stunned
            // If obstacle is 1 auto-click away ie. will fire next turn, set image to attack
            // If obstacle is 2 auto-clicks away, set image to pre-attack
            // Else, be idle
            if (Obstacle.StunDuration > 1) {
                Data.ObstacleImageTitle = "enemy_stunned";
            } else if (Obstacle.GetClickAmount() == (Obstacle.GetMaxClicks() - (2 * Obstacle.GetAutoClicks()))) {
                Data.ObstacleImageTitle = "enemy_pre_attack";
            } else if (Obstacle.GetClickAmount() == (Obstacle.GetMaxClicks() - Obstacle.GetAutoClicks())) {
                Data.ObstacleImageTitle = "enemy_attack";
            } else {
                Data.ObstacleImageTitle = "enemy_idle";
            }
        }

        // Change data values
        Data.Coins = Coins;
        Data.Turns = Turns;

        return Data;
    }

    GameClassDataPacket OnObstacleTick() {
        GameClassDataPacket Data;
        WeaponClassDataPacket Attack = new WeaponClassDataPacket();

        Data = OnAnyTick();

        // Call weapon 1 damage
        WeaponClassDataPacket Button1Attack = Player.Weapons[0].DamageDealtOnClick();
        Data.Button1Ratio = Button1Attack.Ratio;

        // Call weapon 2 damage
        WeaponClassDataPacket Button2Attack = Player.Weapons[1].DamageDealtOnClick();
        Data.Button2Ratio = Button2Attack.Ratio;

        // Process individual attacks and combine to one
        Attack.Damage = Button1Attack.Damage + Button2Attack.Damage;
        if (Button1Attack.Stun > Button2Attack.Stun) {
            Attack.Stun = Button1Attack.Stun;
        } else {
            Attack.Stun = Button2Attack.Stun;
        }

        // Apply attack to Obstacle
        ObstacleClass CurrentObstacle = GetCurrentObstacle();
        String ObstacleHealthRatio = CurrentObstacle.TakeDamage(Attack);
        int ObstacleHealthNumerator = GetRatioNumerator(ObstacleHealthRatio);
        if (ObstacleHealthNumerator == 0) {
            // Obstacle is dead
            ObstacleIndex += 1;
            if (ObstacleIndex >= ObstacleList.length) {
                // If no more obstacles in the room, generate a new room
                GenerateObstacleList();
                ObstacleIndex = 0;
            }
            // Add reward
            Coins += CurrentObstacle.Reward;
            Data.Coins = Coins;

            // Get image of next obstacle
            Data.ObstacleImageTitle = ObstacleList[ObstacleIndex].GetImage();
        }

        // Pick player image
        boolean IfWeapon1Fired = (Button1Attack.Damage > 0 || Button1Attack.Stun > 0);
        boolean IfWeapon2Fired = (Button2Attack.Damage > 0 || Button2Attack.Stun > 0);
        if (IfWeapon1Fired && IfWeapon2Fired) {
            Data.PlayerImageTitle = Player.ImageBasis + "_fire_12";
        } else if (IfWeapon1Fired) {
            Data.PlayerImageTitle = Player.ImageBasis + "_fire_1";
        } else if (IfWeapon2Fired) {
            Data.PlayerImageTitle = Player.ImageBasis + "_fire_2";
        } else {
            Data.PlayerImageTitle = Player.ImageBasis + "_idle";
        } // Loading an individual weapon is done in the corresponding methods

        Data = OnEndTick(Data);

        return Data;
    }

    GameClassDataPacket OnButtonTick(int Weapon) {
        GameClassDataPacket Data;

        Data = OnAnyTick();

        // Increment the player's weapon and save the new ratio
        if (Weapon == 0) {
            Data.Button1Ratio = Player.Weapons[0].ManualIncrement();
            Data.Button2Ratio = Player.Weapons[1].GetRatio();
        } else if (Weapon == 1) {
            Data.Button1Ratio = Player.Weapons[0].GetRatio();
            Data.Button2Ratio = Player.Weapons[1].ManualIncrement();
        }

        // Fetch the player's image
        Data.PlayerImageTitle = Player.ImageBasis + "_load_" + (Weapon + 1);

        Data = OnEndTick(Data);

        return Data;
    }

    GameClassDataPacket OnEndTick(GameClassDataPacket Data) {
        Turns += 1;
        Data.Turns = Turns;
        System.out.println(String.format("/// TURN %04d END \\\\\\", Data.Turns));

        // Resolve player damage here
        if (Player.CurrentHealth <= 0) {
            System.out.println("Player is dead");
            // Open up the shop
            // TODO Make shop and intent to it
        } else {
            Data.HealthRatio = Player.ReturnHealthRatio();
        }

        return Data;
    }

}
