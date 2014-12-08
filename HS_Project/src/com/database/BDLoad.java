package com.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class BDLoad extends SQLiteOpenHelper{
	private String SQLiteCartas = "CREATE TABLE CARTA (nombre TEXT PRIMARY KEY, tipo TEXT, clase TEXT, set TEXT, rareza TEXT, coste INTEGER, ataque INTEGER, defensa INTEGER, descripcion TEXT, numcopias INTEGER)";
	private String SQLiteMazos = "CREATE TABLE MAZO (nombre TEXT PRIMARY KEY, numcartas INTEGER, clase TEXT)";
	private String SQLiteMazosDescargados = "CREATE TABLE MAZODESCARGADO (nombre TEXT PRIMARY KEY, numcartas INTEGER, clase TEXT, fechaactualizacion TEXT)";

	public BDLoad(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
	}

	@Override
	public void onCreate(SQLiteDatabase BD) {
		BD.execSQL(SQLiteCartas);
		BD.execSQL(SQLiteMazos);
		BD.execSQL(SQLiteMazosDescargados);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
	}

}
