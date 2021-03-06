package com.pipeecho.starpirates;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MenuActivity extends AppCompatActivity {

    public static final String CHAR_SELECTED = "com.pipeecho.StarPirates.CHAR_SELECTED";
    public static final String WEAPON_SELECTED = "com.pipeecho.StarPirates.WEAPON_SELECTED";
    public static final String COINS_SAVED = "com.pipeecho.StarPirates.COINS_SAVED";

    DataModel Data = new DataModel();
    int NumberOfClasses = Data.NUMBER_OF_CLASSES;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("Building menu");
        setContentView(R.layout.activity_menu);
        System.out.println("Menu view allocated");

        // Make array of strings
        String[] MenuItems = new String[(3 * NumberOfClasses)
                + 1 /* Instructions tab*/ + 1 /* Reset data */];
        System.out.println("Menu list string space allocated");

        // For each class in the DataModel, have a "Play as...", "Inspect 'name of button1'" and
        // "Inspect 'name of button2'"
        for (int class_number = 0; class_number < NumberOfClasses; class_number++) {
            MenuItems[(3 * class_number) + 0] = "Play as " + Data.GetClassName(class_number);
            MenuItems[(3 * class_number) + 1] = "Inspect " + Data.GetWeaponTitle(class_number, 0);
            MenuItems[(3 * class_number) + 2] = "Inspect " + Data.GetWeaponTitle(class_number, 1);
        }

        System.out.println("Menu list strings named");

        // Then have an instructions tab at the end
        MenuItems[(3 * NumberOfClasses)] = "Instructions";
        MenuItems[(3 * NumberOfClasses) + 1] = "Reset data";

        // Get list view id
        ListView listView = findViewById(R.id.MenuList);
        System.out.println("List view found");

        // Build adapter for the list view
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, MenuItems);
        System.out.println("Menu list adapter made");

        // Set adapter to listview
        listView.setAdapter(adapter);
        System.out.println("Menu list adapter allocated");

        // Set the listview to be clickable and have each item go to the right activity
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                System.out.println("Pressed item " + i);
                // If (item index 'i' % 3) = 0, player selected class or instructions view
                // Else, load info view for inspection
                if ((i % 3) == 0) {
                    System.out.println("Play game selected or instruction view selected");
                    // If (i / 3) is less than the number of classes, play game
                    // Else load instruction view
                    if ((i / 3) < NumberOfClasses) {
                        System.out.println("Playing game as " + Data.GetClassName(i/3));
                        Intent GameIntent = new Intent(MenuActivity.this, GameActivity.class);

                        GameIntent.putExtra(CHAR_SELECTED, i/3);

                        startActivity(GameIntent);
                    } else {
                        System.out.println("Loading instruction view");
                        Intent InstructionIntent = new Intent(MenuActivity.this, InstructionActivity.class);

                        startActivity(InstructionIntent);
                    }
                    // End if of deciding if to play game or load instructions
                } else {
                    // If (i / 3) is less than the number of classes, load the inspection view
                    // Else, ask to reset data
                    if ((i / 3) < NumberOfClasses) {
                        System.out.println("Inspection view selected");
                        Intent InspectionIntent = new Intent(MenuActivity.this, InspectionActivity.class);

                        InspectionIntent.putExtra(CHAR_SELECTED, i / 3);
                        InspectionIntent.putExtra(WEAPON_SELECTED, (i % 3) - 1);

                        MenuActivity.this.startActivity(InspectionIntent);
                    } else {
                        System.out.println("Reset data pressed");
                        AlertDialog.Builder builder = new AlertDialog.Builder(getWindow().getContext());
                        builder.setMessage("This will set all weapon levels to one. Are you sure you want to do this?")
                                .setTitle("Reset data");
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                System.out.println("User wants to reset data");
                                // Reset data
                                for (int Class = 0; Class < NumberOfClasses; Class++) {
                                    for (int Weapon = 0; Weapon <= 1; Weapon++) {
                                        Data.SaveData(Class, Weapon, 1, getWindow().getDecorView().getRootView());
                                    }
                                }
                            }
                        });
                        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                System.out.println("User does not want to reset data");
                            }
                        });
                        AlertDialog alert = builder.create();
                        alert.show();
                    }
                }
                // End if of selecting inspection view or game
            }
        }); // End of setting the listener
    }
}
