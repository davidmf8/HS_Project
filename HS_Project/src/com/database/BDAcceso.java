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
	private static String SQLCarta = "SELECT * FROM CARTA";

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
		Cursor cursor = database.rawQuery(SQLCarta, null);
		if(cursor.moveToFirst()){
		  do {
		    cartas.add(cursor.getString(0));
		    System.out.println(cursor.getString(0) + cursor.getString(1) + cursor.getString(2)+cursor.getString(3)+cursor.getString(4)+cursor.getString(5)+cursor.getInt(6));
		  } while(cursor.moveToNext());
		}
		return cartas;	
	}
	
	public ArrayList<String> getCartasPorClase(String clase){
		ArrayList<String> cartas = new ArrayList<String>();
		String sql = "SELECT * FROM CARTA WHERE clase='"+clase+"";
		Cursor cursor = database.rawQuery(sql, null);
		if(cursor.moveToFirst()){
		  do {
		    cartas.add(cursor.getString(0));
		  } while(cursor.moveToNext());
		}
		return cartas;	
	}
	
	public ArrayList<String> getCartasPorSet(String set){
		ArrayList<String> cartas = new ArrayList<String>();
		String sql = "SELECT * FROM CARTA WHERE set='"+set+"";
		Cursor cursor = database.rawQuery(sql, null);
		if(cursor.moveToFirst()){
		  do {
		    cartas.add(cursor.getString(0));
		  } while(cursor.moveToNext());
		}
		return cartas;	
	}
	
	public ArrayList<String> getCartasPorTipo(String tipo){
		ArrayList<String> cartas = new ArrayList<String>();
		String sql = "SELECT * FROM CARTA WHERE tipo='"+tipo+"";
		Cursor cursor = database.rawQuery(sql, null);
		if(cursor.moveToFirst()){
		  do {
		    cartas.add(cursor.getString(0));
		  } while(cursor.moveToNext());
		}
		return cartas;	
	}
	
	public ArrayList<String> getCartasPorRareza(String rareza){
		ArrayList<String> cartas = new ArrayList<String>();
		String sql = "SELECT * FROM CARTA WHERE rareza='"+rareza+"";
		Cursor cursor = database.rawQuery(sql, null);
		if(cursor.moveToFirst()){
		  do {
		    cartas.add(cursor.getString(0));
		  } while(cursor.moveToNext());
		}
		return cartas;	
	}
	
	public ArrayList<String> getCartasPorCoste(int coste){
		ArrayList<String> cartas = new ArrayList<String>();
		String sql = "SELECT * FROM CARTA WHERE coste='"+coste+"";
		Cursor cursor = database.rawQuery(sql, null);
		if(cursor.moveToFirst()){
		  do {
		    cartas.add(cursor.getString(0));
		  } while(cursor.moveToNext());
		}
		return cartas;	
	}
	
	public ArrayList<String> getCartasPorAtaque(int ataque){
		ArrayList<String> cartas = new ArrayList<String>();
		String sql = "SELECT * FROM CARTA WHERE ataque='"+ataque+"";
		Cursor cursor = database.rawQuery(sql, null);
		if(cursor.moveToFirst()){
		  do {
		    cartas.add(cursor.getString(0));
		  } while(cursor.moveToNext());
		}
		return cartas;	
	}
	
	public ArrayList<String> getCartasPorDefensa(int defensa){
		ArrayList<String> cartas = new ArrayList<String>();
		String sql = "SELECT * FROM CARTA WHERE defensa='"+defensa+"";
		Cursor cursor = database.rawQuery(sql, null);
		if(cursor.moveToFirst()){
		  do {
		    cartas.add(cursor.getString(0));
		  } while(cursor.moveToNext());
		}
		return cartas;	
	}
	
	public ArrayList<String> getCartasPorBuscador(String nombre){
		ArrayList<String> cartas = new ArrayList<String>();
		String carta, descripcion;
		Cursor cursor = database.rawQuery(SQLCarta, null);
		if(cursor.moveToFirst()){
		  do {
			carta = cursor.getString(0);
			descripcion = cursor.getString(9);
		    if(carta.contains(nombre) || descripcion.contains(nombre)){
		    	cartas.add(carta);
		    }
		  } while(cursor.moveToNext());
		}
		return cartas;	
	}
	
	public void BDcloseCards(){ //Cierra la base de datos
		cartasBD.close();
	}
}
