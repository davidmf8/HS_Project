package com.main;

import com.database.BDAcceso;
import com.example.hs_project.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class main_activity extends Activity{
	private Button boton;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);
		boton = (Button)findViewById(R.id.button1);
	}
	
	public void onClick(View v) {
		if(v.getId() == R.id.button1){
			BDAcceso BD = new BDAcceso(this);
			BD = BD.BDopenCards();
			BD.getCartas();
			BD.BDcloseCards();
		}
	}
	
}
