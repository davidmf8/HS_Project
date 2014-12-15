package com.main;

import com.example.hs_project.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.support.v4.widget.DrawerLayout;

public class collection_activity extends Activity {
    
	private String[] searchMenuOptions;
	private DrawerLayout drawerLayout;
	private ListView drawerList;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.collection_activity);
        
        searchMenuOptions = new String[] {"Option 1", "Option 2", "Option 3"};
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        drawerList = (ListView) findViewById(R.id.left_drawer);
        
       }
}
