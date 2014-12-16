package com.main;

import com.example.hs_project.R;

import com.main.CustomDrawerLayout;

import ListViewAdapter.collectionAdapter;
import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;


public class collection_activity extends Activity {
	private String[] searchMenuOptions, searchMenuOptions2;
	private CustomDrawerLayout customDrawerLayout;
	private ListView drawerLeftList, drawerRightList;
	private GridView gridview;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.collection_activity);
        
        searchMenuOptions = new String[] {"Close", "Option 2", "Option 3"};
        searchMenuOptions2 = new String[] {"Close", "Option 4", "Option 5"};
        customDrawerLayout = (CustomDrawerLayout)findViewById(R.id.drawer_layout);
        customDrawerLayout.setDrawerLockMode(CustomDrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        
        drawerLeftList = (ListView) findViewById(R.id.left_drawer);
        drawerLeftList.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, searchMenuOptions));
        
        drawerLeftList.setOnItemClickListener(new OnItemClickListener(){
        	@Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                    	customDrawerLayout.closeDrawer(Gravity.START);
                    	customDrawerLayout.setDrawerLockMode(CustomDrawerLayout.LOCK_MODE_LOCKED_CLOSED, Gravity.START);
                        break;
                }
            }
        });
        
        drawerRightList = (ListView) findViewById(R.id.right_drawer);
        drawerRightList.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, searchMenuOptions2));
        
        drawerRightList.setOnItemClickListener(new OnItemClickListener(){
        	@Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                    	customDrawerLayout.closeDrawer(Gravity.END);
                    	customDrawerLayout.setDrawerLockMode(CustomDrawerLayout.LOCK_MODE_LOCKED_CLOSED, Gravity.END);
                        break;
                }
            }
        });
        
        gridview = (GridView) findViewById(R.id.gridCollection);// crear el
        gridview.setAdapter(new collectionAdapter(this));
        
    }
	
	public void onClick(View v){
		switch(v.getId()){
		  case R.id.searchButton:
			  customDrawerLayout.openDrawer(Gravity.START);
			  customDrawerLayout.setDrawerLockMode(CustomDrawerLayout.LOCK_MODE_LOCKED_OPEN, Gravity.START);
			  break;
		  case R.id.deckButton:
			  customDrawerLayout.openDrawer(Gravity.END);
			  customDrawerLayout.setDrawerLockMode(CustomDrawerLayout.LOCK_MODE_LOCKED_OPEN, Gravity.END);
			  break;
		}
	}
	
}
