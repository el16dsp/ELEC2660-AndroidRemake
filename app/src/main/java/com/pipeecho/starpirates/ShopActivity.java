package com.pipeecho.starpirates;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ShopActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        // TODO Build shop

        Intent intent = getIntent();
        int ClassSelected = intent.getIntExtra(MenuActivity.CHAR_SELECTED, 0);
        int Coins = intent.getIntExtra(MenuActivity.COINS_SAVED, 0);

        TextView HealthLabel = findViewById(R.id.HealthBar);
        HealthLabel.setBackgroundColor(GameActivity.LABEL_RED);

        TextView CoinsLabel = findViewById(R.id.CoinsLabel);
        CoinsLabel.setText(String.format("Coins: %04d", Coins));

    }
}
