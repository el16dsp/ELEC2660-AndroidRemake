package com.pipeecho.starpirates;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class InspectionActivity extends AppCompatActivity {

    DataModel Data = new DataModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inspection);

        // Get the intent that started the activity
        Intent intent = getIntent();
        // Extract char selected
        int ClassSelected = intent.getIntExtra(MenuActivity.CHAR_SELECTED, 0);
        int WeaponSelected = intent.getIntExtra(MenuActivity.WEAPON_SELECTED, 0);

        System.out.println("Class selected was " + Data.GetClassName(ClassSelected));
        if (WeaponSelected == 0) {
            System.out.println("Weapon selected was " + Data.GetWeapon1Title(ClassSelected));
        } else if (WeaponSelected == 1) {
            System.out.println("Weapon selected was " + Data.GetWeapon2Title(ClassSelected));
        } else {
            System.out.println("Unable to select weapon");
        }
        // TODO Build inspection view
    }
}
