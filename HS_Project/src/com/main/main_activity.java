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
		if(v.getId() == R.id.Button1){
			Intent intent = new Intent(main_activity.this, collection_activity.class);
			startActivity(intent);
		}
	}
	
}
