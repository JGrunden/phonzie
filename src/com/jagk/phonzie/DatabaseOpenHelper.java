package com.jagk.phonzie;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Parcel;
import android.os.Parcelable;

public class DatabaseOpenHelper extends SQLiteOpenHelper implements Parcelable {

	static final int databaseVersion = 1;
	static final String dbName="phonzieDB";
	static final String PersonTable="Persons";
	static final String colID="ID";
	static final String colFname="FirstName";
	static final String colLname="LastName";
	static final String colPnumber="PersonNumber";

	public DatabaseOpenHelper(Context context) {
		super(context, dbName, null, databaseVersion); 
	}

	/*public DatabaseOpenHelper(Context context, String name,
			CursorFactory factory, int version) {
		super(context, name, factory, version);
	}
	 */

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

	public void addPerson(Person p){
		SQLiteDatabase db=this.getWritableDatabase();
		ContentValues cv=new ContentValues();
		cv.put(colID, 1); //kanske ska vara id istället för 1
		cv.put(colFname, p.getFname());
		cv.put(colLname, p.getLname());
		cv.put(colPnumber, p.getPnumber());
		db.insert(PersonTable, null, cv);
		db.close();
	}
	/* TBD
	public int updatePerson(String fname, String lname, Integer pnumber)
	  {
	   SQLiteDatabase db=this.getWritableDatabase();
	   ContentValues cv=new ContentValues();
	   cv.put(colPFname, emp.getName());
	   cv.put(colLname, emp.getAge());
	   cv.put(colDept, emp.getDept());
	   return db.update(employeeTable, cv, colID+"=?", 
	    new String []{String.valueOf(emp.getID())});   
	  }

	public void deletePerson(Integer pnumber)
	  {
	   SQLiteDatabase db=this.getWritableDatabase();
	   db.delete(PersonTable,colID+"=?", new String [] {String.valueOf(emp.getID())});
	   db.close();
	  }
	 */

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

}
