package com.database;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;

public class BDLoad extends SQLiteOpenHelper{
	private String SQLiteCartas = "CREATE TABLE CARTA (nombre TEXT PRIMARY KEY, tipo TEXT, clase TEXT, setteam TEXT, rareza TEXT, tag TEXT, coste INTEGER, ataque INTEGER, salud INTEGER, descripcion TEXT, numcopias INTEGER)";
	private String SQLiteMazos = "CREATE TABLE MAZO (nombre TEXT PRIMARY KEY, numcartas INTEGER, clase TEXT)";
	private String SQLiteMazosDescargados = "CREATE TABLE MAZODESCARGADO (nombre TEXT PRIMARY KEY, numcartas INTEGER, clase TEXT, fechaactualizacion TEXT)";
	private Context context;

	public BDLoad(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
		this.context = context;
	}

	@Override
	public void onCreate(SQLiteDatabase BD) {
		BD.execSQL(SQLiteCartas);
		BD.execSQL(SQLiteMazos);
		BD.execSQL(SQLiteMazosDescargados);

		InputStream is = null;
	    try {
	         is = context.getAssets().open("BD.sql");
	         if (is != null) {
	             BD.beginTransaction();
	             BufferedReader reader = new BufferedReader(new InputStreamReader(is));
	             String line = reader.readLine();
	             while (!TextUtils.isEmpty(line)) {
	                 BD.execSQL(line);
	                 line = reader.readLine();
	             }
	             BD.setTransactionSuccessful();
	         }
	    } catch (Exception ex) {} finally {
	        BD.endTransaction();
	        if (is != null) {
	            try {
	                is.close();
	            } catch (IOException e) {}               
	        }
	    }
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
	}

}
