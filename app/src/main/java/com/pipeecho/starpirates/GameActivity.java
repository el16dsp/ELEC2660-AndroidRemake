package com.pipeecho.starpirates;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class GameActivity extends AppCompatActivity {
    int ClassSelected;
    GameController Game;

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
        // TODO Connect view to game
    }

    public void onButton2Click(View view) {
        // When button two pressed
        // TODO Connect view to game
    }
}
