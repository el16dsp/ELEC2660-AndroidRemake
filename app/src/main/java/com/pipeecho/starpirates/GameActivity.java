package com.pipeecho.starpirates;

import android.content.Intent;
import android.graphics.Point;
import android.support.annotation.Dimension;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

public class GameActivity extends AppCompatActivity {
    int ClassSelected;
    GameController Game;
    double HEALTH_COLOUR_CHANGE_LIMIT = 0.4;
    int LABEL_GREEN = 0xff88aa00;
    int LABEL_RED = 0xffcc0000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Intent intent = getIntent();
        ClassSelected = intent.getIntExtra(MenuActivity.CHAR_SELECTED, 0);

        Game = new GameController(ClassSelected);

        // Set button text to be that of the weapons.
        Button Button1 = findViewById(R.id.Button1);
        Button Button2 = findViewById(R.id.Button2);
        Button1.setText(Game.GetButtonText(0));
        Button2.setText(Game.GetButtonText(1));

        // TODO Weapon ratio colour blocks do not appear. Fix.
        // Have frame 0 data prepared
        GameClassDataPacket Data = new GameClassDataPacket();
        Data.Button1Ratio = Game.Player.Weapons[0].GetRatio();
        Data.Button2Ratio = Game.Player.Weapons[1].GetRatio();
        Data.Coins = Game.Coins;
        Data.Turns = Game.Turns;
        Data.HealthRatio = Game.Player.ReturnHealthRatio();
        Data.PlayerImageTitle = Game.Player.ImageBasis + "_idle";
        Data.ObstacleImageTitle = Game.GetCurrentObstacle().Image;
        UpdateTextLabels(Data);
    }

    public void onButton1Click(View view) {
        // When button one pressed
        System.out.println("GameActivity Button1 pressed");
        GameClassDataPacket Data = Game.OnButtonTick(0);
        UpdateTextLabels(Data);
    }

    public void onButton2Click(View view) {
        // When button two pressed
        System.out.println("GameActivity Button2 pressed");
        GameClassDataPacket Data = Game.OnButtonTick(1);
        UpdateTextLabels(Data);
    }

    public void onObstacleButton(View view) {
        // When obstacle button pressed
        System.out.println("GameActivity obstacle button pressed");
        GameClassDataPacket Data = Game.OnObstacleTick();
        UpdateTextLabels(Data);
    }

    public void UpdateTextLabels(GameClassDataPacket Data) {
        // Update health label text
        TextView HealthLabel = findViewById(R.id.HealthLabel);
        HealthLabel.setText(Data.HealthRatio);

        // Update health background label
        // Get Screen width
        // Taken from https://stackoverflow.com/questions/1016896/get-screen-dimensions-in-pixels
        Point size = new Point();
        int ScreenWidth = size.x;
        // Get TextView
        TextView HealthBackground = findViewById(R.id.HealthBackground);
        // Get ratio denominator
        int DenominatorHealth = Game.GetRatioDenominator(Data.HealthRatio);
        if (DenominatorHealth == 0) {
            DenominatorHealth = 1;
        }
        // Get ratio numerator
        int NumeratorHealth = Game.GetRatioNumerator(Data.HealthRatio);
        if (NumeratorHealth == 0) {
            NumeratorHealth = 1;
        }
        // Turn ratio into floating point multiplier
        float RatioHealth = (float) NumeratorHealth / (float) DenominatorHealth;
        // Multiply screen width by multiplier
        int NewWidthHealth = (int) (ScreenWidth * RatioHealth);
        // Set TextView width as new value
        HealthBackground.setWidth(NewWidthHealth);
        // If ratio is less than a constant, colour is red
        if (RatioHealth < HEALTH_COLOUR_CHANGE_LIMIT) {
            // Set colour to red
            HealthBackground.setBackgroundColor(LABEL_RED);
        } else {
            // Set colour to green
            HealthBackground.setBackgroundColor(LABEL_GREEN);
        }

        // Update coin label text
        TextView CoinLabel = findViewById(R.id.CoinLabel);
        CoinLabel.setText(String.format("Coins: %04d",Data.Coins));

        // Update turn label text
        TextView TurnLabel = findViewById(R.id.TurnLabel);
        TurnLabel.setText(String.format("Turn: %04d", Data.Turns));

        // Update weapon 1 status label
        TextView Ratio1Label = findViewById(R.id.Weapon1Label);
        Ratio1Label.setText(Data.Button1Ratio);

        // Update weapon 1 status background
        TextView Weapon1Background = findViewById(R.id.Weapon1Background);
        // Get ratio denominator
        int DenominatorButton1 = Game.GetRatioDenominator(Data.Button1Ratio);
        if (DenominatorButton1 == 0) {
            DenominatorButton1 = 1;
        }
        // Get ratio numerator
        int NumeratorButton1 = Game.GetRatioNumerator(Data.HealthRatio);
        if (NumeratorButton1 == 0) {
            NumeratorButton1 = 1;
        }
        // Turn ratio into floating point multiplier
        float RatioButton1 = (float) NumeratorButton1 / (float) DenominatorButton1;
        // Multiply screen width by multiplier
        int NewWidthButton1 = (int) (ScreenWidth * RatioButton1 / 2);
        // Set TextView width as new value
        Weapon1Background.setWidth(NewWidthButton1);
        // If weapon is type 'A' and fully charged, colour is green
        if (Game.Player.Weapons[0].Type.equals("A") && (NumeratorButton1 == DenominatorButton1)) {
            Weapon1Background.setBackgroundColor(LABEL_GREEN);
        } else {
            Weapon1Background.setBackgroundColor(LABEL_RED);
        }
        // If weapon is type 'W' and has at least one in the numerator, colour is green
        if (Game.Player.Weapons[0].Type.equals("W") && (NumeratorButton1 > 0)) {
            Weapon1Background.setBackgroundColor(LABEL_GREEN);
        } else {
            Weapon1Background.setBackgroundColor(LABEL_RED);
        }

        // Update weapon 2 status label
        TextView Ratio2Label = findViewById(R.id.Weapon2Label);
        Ratio2Label.setText(Data.Button2Ratio);

        // Update weapon 2 status background
        TextView Weapon2Background = findViewById(R.id.Weapon2Background);
        // Get ratio denominator
        int DenominatorButton2 = Game.GetRatioDenominator(Data.Button1Ratio);
        if (DenominatorButton2 == 0) {
            DenominatorButton2 = 1;
        }
        // Get ratio numerator
        int NumeratorButton2 = Game.GetRatioNumerator(Data.HealthRatio);
        if (NumeratorButton2 == 0) {
            NumeratorButton2 = 1;
        }
        // Turn ratio into floating point multiplier
        float RatioButton2 = (float) NumeratorButton2 / (float) DenominatorButton2;
        // Multiply screen width by multiplier
        int NewWidthButton2 = (int) (ScreenWidth * RatioButton2 / 2);
        // Set TextView width as new value
        Weapon2Background.setWidth(NewWidthButton2);
        // If weapon is type 'A' and fully charged, colour is green
        if (Game.Player.Weapons[1].Type.equals("A") && (NumeratorButton2 == DenominatorButton2)) {
            Weapon2Background.setBackgroundColor(LABEL_GREEN);
        } else {
            Weapon2Background.setBackgroundColor(LABEL_RED);
        }
        // If weapon is type 'W' and has at least one in the numerator, colour is green
        if (Game.Player.Weapons[1].Type.equals("W") && (NumeratorButton2 > 0)) {
            Weapon2Background.setBackgroundColor(LABEL_GREEN);
        } else {
            Weapon2Background.setBackgroundColor(LABEL_RED);
        }

        UpdateImages(Data);
    }

    public void UpdateImages(GameClassDataPacket Data) {
        System.out.println("UpdateImages called with images '" + Data.ObstacleImageTitle +
                "' and '" + Data.PlayerImageTitle + "'");
        // Update obstacle image
        ImageButton ObstacleImage = findViewById(R.id.ObstacleImage);
        ObstacleImage.setImageResource(getResources().getIdentifier(Data.ObstacleImageTitle,
                "drawable", getPackageName()));

        // Update player image
        ImageView PlayerImage = findViewById(R.id.PlayerImage);
        PlayerImage.setImageResource(getResources().getIdentifier(Data.PlayerImageTitle,
                "drawable", getPackageName()));

    }
}
