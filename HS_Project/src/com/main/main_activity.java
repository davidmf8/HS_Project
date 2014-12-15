package com.main;

import com.example.hs_project.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import android.content.Intent;

public class main_activity extends Activity{
	
	private Button collection;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);
		
		collection = (Button)findViewById(R.id.Button1);
	}
	
	public void onClick(View v){
		switch(v.getId()){
		  case R.id.colection:
			  Intent colectionActivity = new Intent(main_activity.this, collection_activity.class);
			  startActivity(colectionActivity);
		      break;
		  case R.id.mydecks:
			  Intent decksActivity = new Intent(main_activity.this, mydecks_activity.class);
			  startActivity(decksActivity);
			  break;
		  case R.id.netdecks:
			  Intent netActivity = new Intent(main_activity.this, netdecks_activity.class);
			  startActivity(netActivity);
			  break;
		}
	}
	
}
