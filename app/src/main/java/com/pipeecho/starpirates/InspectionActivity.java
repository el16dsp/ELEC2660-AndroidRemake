package com.pipeecho.starpirates;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class InspectionActivity extends AppCompatActivity {

    DataModel Data = new DataModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inspection);

        // Prepare variables for use in the view
        String ClassName;
        String WeaponName;
        String WeaponDescription;
        int Level;
        int Cost;
        String Damage;
        String ClicksPerClip;
        String StunDuration;
        String AutoClickRate;

        // Get the intent that started the activity
        Intent intent = getIntent();
        // Extract char selected
        int ClassSelected = intent.getIntExtra(MenuActivity.CHAR_SELECTED, 0);
        int WeaponSelected = intent.getIntExtra(MenuActivity.WEAPON_SELECTED, 0);

        ClassName = Data.GetClassName(ClassSelected);
        TextView ClassNameText = findViewById(R.id.ClassText);
        ClassNameText.setText(ClassName);
        System.out.println("Class selected was " + ClassName);

        TextView WeaponNameText = findViewById(R.id.NameText);
        if (WeaponSelected == 0 || WeaponSelected == 1) {
            WeaponName = Data.GetWeaponTitle(ClassSelected, WeaponSelected);
            System.out.println("Weapon selected was " + WeaponName);
        } else {
            WeaponName = "placeholder";
            System.out.println("Unable to select weapon");
        }
        WeaponNameText.setText(WeaponName);

        WeaponDescription = Data.GetWeaponDescription(ClassSelected, WeaponSelected);
        TextView DescText = findViewById(R.id.DescriptionText);
        DescText.setText(WeaponDescription);
        System.out.println("Description found was " + WeaponDescription);

        Cost = Data.GetWeaponCost(ClassSelected, WeaponSelected);
        TextView CostText = findViewById(R.id.CostText);
        CostText.setText(String.format("Cost: %d coins", Cost));

        Level = Data.GetWeaponLevel(ClassSelected, WeaponSelected);
        TextView LevelText = findViewById(R.id.LevelText);
        LevelText.setText(String.format("Level: %d ", Level));

        // TODO Build inspection view
    }
}
