package com.pipeecho.starpirates;

import android.content.Intent;
import android.graphics.Point;
import android.support.annotation.Dimension;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
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

        // TODO Build game view

        Intent intent = getIntent();
        ClassSelected = intent.getIntExtra(MenuActivity.CHAR_SELECTED, 0);

        Game = new GameController(ClassSelected);

        Button Button1 = findViewById(R.id.Button1);
        Button Button2 = findViewById(R.id.Button2);
        Button1.setText(Game.GetButtonText(0));
        Button2.setText(Game.GetButtonText(1));
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

    public void onOnstacleButton(View view) {
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
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        int ScreenWidth = size.x;
        // Get TextView
        TextView HealthBackground = findViewById(R.id.HealthBackground);
        // Get ratio denominator
        int Denominator = Game.GetRatioDenominator(Data.HealthRatio);
        if (Denominator == 0) {
            Denominator = 1;
        }
        // Get ratio numerator
        int Numerator = Game.GetRatioNumerator(Data.HealthRatio);
        if (Numerator == 0) {
            Numerator = 1;
        }
        // Turn ratio into floating point multiplier
        float Ratio = (float) Numerator / (float) Denominator;
        // Multiply screen width by multiplier
        int NewWidth = (int) (ScreenWidth * Ratio);
        // Set TextView width as new value
        HealthBackground.setWidth(NewWidth);
        // If ratio is less than a constant, colour is red
        if (Ratio < HEALTH_COLOUR_CHANGE_LIMIT) {
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
        TurnLabel.setText(String.format("Turns: %04d", Data.Turns));

        // Update weapon 1 status label
        TextView Ratio1Label = findViewById(R.id.Weapon1Label);
        Ratio1Label.setText(Data.Button1Ratio);

        // TODO Update weapon 1 status background

        // Update weapon 2 status label
        TextView Ratio2Label = findViewById(R.id.Weapon2Label);
        Ratio2Label.setText(Data.Button2Ratio);

        // TODO Update weapon 2 status background

    }

    public void UpdateImages() {
        // TODO Update obstacle image

        // TODO Update player image

    }
}
