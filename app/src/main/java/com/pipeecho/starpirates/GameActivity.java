package com.pipeecho.starpirates;

import android.content.Intent;
import android.graphics.Point;
import android.support.annotation.Dimension;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.TextView;

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

        // TODO Change button text
    }

    public void onButton1Click(View view) {
        // When button one pressed
        System.out.println("GameActivity Button1 pressed");
        // TODO Connect view to game
    }

    public void onButton2Click(View view) {
        // When button two pressed
        System.out.println("GameActivity Button2 pressed");
        // TODO Connect view to game
    }

    public void onOnstacleButton(View view) {
        // When obstacle button pressed
        System.out.println("GameActivity obstacle button pressed");
    }

    public void UpdateTextLabels(GameClassDataPacket data) {
        // TODO Update health label text
        TextView HealthLabel = findViewById(R.id.HealthLabel);
        HealthLabel.setText(data.HealthRatio);

        // TODO Update health background label
        // Get Screen width
        // Taken from https://stackoverflow.com/questions/1016896/get-screen-dimensions-in-pixels
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        int ScreenWidth = size.x;
        // Get TextView
        TextView HealthBackground = findViewById(R.id.HealthBackground);
        // Get ratio denominator
        int Denominator = Game.GetRatioDenominator(data.HealthRatio);
        // Get ratio numerator
        int Numerator = Game.GetRatioNumerator(data.HealthRatio);
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

        // TODO Update coin label text

        // TODO Update turn label text

        // TODO Update weapon status labels

        // TODO Update weapon status backgrounds

    }

    public void UpdateImages() {
        // TODO Update obstacle image

        // TODO Update player image

    }
}
