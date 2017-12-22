package com.pipeecho.starpirates;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MenuActivity extends AppCompatActivity {

    DataModel Data = new DataModel();
    int NumberOfClasses = Data.NUMBER_OF_CLASSES;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("Building menu");
        setContentView(R.layout.activity_menu);
        System.out.println("Menu view allocated");

        // Make array of strings
        String[] MenuItems = new String[(3 * NumberOfClasses) + 1];
        System.out.println("Menu list string space allocated");
        // TODO Make this list based on the classes in the data model
        // Need to figure out a way to load data in the background and not have heavy processing
        // in this method

        // For each class in the DataModel, have a "Play as...", "Inspect 'name of button1'" and
        // "Inspect 'name of button2'"
        for (int class_number = 0; class_number < NumberOfClasses; class_number++) {
            MenuItems[(3 * class_number) + 0] = "Play as " + Data.GetClassName(class_number);
            MenuItems[(3 * class_number) + 1] = "Inspect " + Data.GetWeapon1Title(class_number);
            MenuItems[(3 * class_number) + 2] = "Inspect " + Data.GetWeapon2Title(class_number);
        }

        System.out.println("Menu list strings named");

        // Then have an instructions tab at the end
        MenuItems[(3 * NumberOfClasses)] = "Instructions";
        // TODO Have each list item have the correct segue to another activity

        // Get list view id
        ListView listView = findViewById(R.id.MenuList);
        System.out.println("List view found");

        // Build adapter for the list view
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, MenuItems);
        System.out.println("Menu list adapter made");

        // Set adapter to listview
        listView.setAdapter(adapter);
        System.out.println("Menu list adapter allocated");
    }
}
