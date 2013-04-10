package com.jagk.phonzie;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    /** Called when the user clicks the Search Person button */
    public void searchPerson(View view) {
    	Intent intent = new Intent(this, SearchPersonActivity.class);
    	startActivity(intent);
    }
    
    /** Called when the user clicks the Add Person button */
    public void addPerson(View view) {
    	Intent intent = new Intent(this, AddPersonActivity.class);
    	startActivity(intent);
    }
}
