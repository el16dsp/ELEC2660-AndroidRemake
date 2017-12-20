package com.pipeecho.starpirates;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        // Make array of strings
        DataModel Data = new DataModel();
        String[] MenuItems = {"Play as Cutter", "Inspect Pistol", "Inspect Blowtorch"};
        // TODO Make this list based on the classes in the data model
        // TODO Have each list item have the correct segue to another activity

        // Get list view id
        ListView listView = (ListView) findViewById(R.id.MenuList);

        // Build adapter for the list view
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, MenuItems);

        // Set adapter to listview
        listView.setAdapter(adapter);
    }
}
