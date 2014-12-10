package com.database;

import java.util.ArrayList;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

public class BDAcceso {
	BDLoad cartasBD;
	private static int version = 1;
	private SQLiteDatabase database;
	private Context context;

	public BDAcceso(Context context){
	    this.context = context;
	}
    
	public BDAcceso BDopenCards() throws SQLiteException{ //Devuelve un objeto para trabajar con la BD.
		cartasBD = new BDLoad(context, "CARTA", null, version);
		database = cartasBD.getWritableDatabase();
		return this;
	}
	
	public ArrayList<String> getCartas(){
		ArrayList<String> cartas = new ArrayList<String>();
		String sql = "SELECT * FROM CARTA";
		Cursor cursor = database.rawQuery(sql, null);
		if(cursor.moveToFirst()){
		do {
		  cartas.add(cursor.getString(0));
		  System.out.println(cursor.getString(0) + cursor.getString(1) + cursor.getString(2)+cursor.getString(3)+cursor.getString(4)+cursor.getString(5)+cursor.getInt(6));
		} while(cursor.moveToNext());
		}
		return cartas;
		
	}
	
	public void BDcloseCards(){ //Cierra la base de datos
		cartasBD.close();
	}
}
