package com.pipeecho.starpirates;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MenuActivity extends AppCompatActivity {

    //DataModel Data = new DataModel();
    int NumberOfClasses = 1;// = Data.NUMBER_OF_CLASSES;

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
        MenuItems[0] = "Play as Cutter";// + Data.PlayerClassArray[0].Name;
        MenuItems[1] = "Inspect Pistol";// + Data.PlayerClassArray[0].Button1.Name;
        MenuItems[2] = "Inspect Blowtorch";// + Data.PlayerClassArray[0].Button2.Name;

        System.out.println("Menu list strings named");

        // Then have an instructions tab at the end
        MenuItems[(3 * NumberOfClasses)] = "Instructions";
        // TODO Have each list item have the correct segue to another activity

        // Get list view id
        ListView listView = (ListView) findViewById(R.id.MenuList);
        System.out.println("List view found");

        // Build adapter for the list view
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, MenuItems);
        System.out.println("Menu list adapter made");

        // Set adapter to listview
        listView.setAdapter(adapter);
        System.out.println("Menu list adapter allocated");
    }
}
