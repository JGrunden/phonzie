package com.jagk.phonzie;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseOpenHelper extends SQLiteOpenHelper {

	static final String dbName="phonzieDB";
	static final String PersonTable="Persons";
	static final String colID="PersonID";
	static final String colFname="FirstName";
	static final String colLname="LastName";
	static final String colPnumber="Pnumber";
	s
	public DatabaseOpenHelper(Context context) {
		  super(context, dbName, null,1); 
	}
	
	public DatabaseOpenHelper(Context context, String name,
			CursorFactory factory, int version) {
		super(context, name, factory, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
    	String createQuery = "CREATE TABLE "+PersonTable+" ("+colID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+colFname+", "+colLname+", "+colPnumber+");";
    	db.execSQL(createQuery);
    }

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + PersonTable);
		onCreate(db);
	}
	
	public void InsertPerson(String fname, String lname, Integer pnumber){
		SQLiteDatabase db=this.getWritableDatabase();
		 ContentValues cv=new ContentValues();
		   cv.put(colID, 1); //kanske ska vara id ist�llet f�r 1
		   cv.put(colFname, fname);
		   cv.put(colLname, lname);
		   cv.put(colPnumber, pnumber);
		   String nullColumnHack = "test";
		   db.insert(PersonTable, nullColumnHack, cv);
           db.close();
	}


}
