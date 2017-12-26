package com.pipeecho.starpirates;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ShopActivity extends AppCompatActivity {

    DataModel Data;

    int ClassSelected;
    int Coins;

    TextView CoinsLabel;

    Button Button1;
    Button Button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        // TODO Build shop

        Intent intent = getIntent();

        Data = new DataModel();

        ClassSelected = intent.getIntExtra(MenuActivity.CHAR_SELECTED, 0);
        Coins = intent.getIntExtra(MenuActivity.COINS_SAVED, 0);

        CoinsLabel = findViewById(R.id.CoinsLabel);
        Button1 = findViewById(R.id.ShopButton1);
        Button2 = findViewById(R.id.ShopButton2);

        TextView HealthLabel = findViewById(R.id.HealthBar);
        HealthLabel.setBackgroundColor(GameActivity.LABEL_RED);

        CoinsLabel.setText(String.format("Coins: %04d", Coins));

        UpdateButtonText(0);
        UpdateButtonText(1);

    }

    public void OnButton1Press(View view) {
        System.out.println("Button 1 pressed");
    }

    public void OnButton2Press(View view) {
        System.out.println("Button 2 pressed");
    }

    void UpdateButtonText(int ButtonIndex) {
        // Button 1 is ButtonIndex 0
        // Button 2 is ButtonIndex 1

        String WeaponName = Data.GetWeaponTitle(ClassSelected, ButtonIndex);
        int CurrentWeaponLevel = Data.GetWeaponLevel(ClassSelected, ButtonIndex);
        int NextWeaponLevel = CurrentWeaponLevel + 1;
        int NextCost = Data.GetWeaponCost(ClassSelected, ButtonIndex);

        System.out.println(String.format("Upgrade %s to level %d for %d coins",
                WeaponName, NextWeaponLevel, NextCost));

        if (ButtonIndex == 0) {
            Button1.setText(String.format("Upgrade %s to level %d for %d coins",
                    WeaponName, NextWeaponLevel, NextCost));
        } else if (ButtonIndex == 1) {
            Button2.setText(String.format("Upgrade %s to level %d for %d coins",
                    WeaponName, NextWeaponLevel, NextCost));
        }
    }
}
