package com.pipeecho.starpirates;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

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
    }
}
