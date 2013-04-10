package com.jagk.phonzie;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class AddPersonActivity extends Activity {
	
	DatabaseOpenHelper helper;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_person);
		// Show the Up button in the action bar.
		setupActionBar();
		
		Bundle b = this.getIntent().getExtras();
		if(b!=null)
		    helper = b.getParcelable(MainActivity.DATABASE);
	}

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_person, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
    /** Called when the user clicks the Add Person button */
    public void addPerson(View view) {
    	EditText first = (EditText) findViewById(R.id.add_first_name);
    	String firstName = first.getText().toString();
    	EditText last = (EditText) findViewById(R.id.add_last_name);
    	String lastName = last.getText().toString();
    	EditText pn = (EditText) findViewById(R.id.add_p_number);
    	int pnumber = Integer.getInteger(pn.getText().toString());
    	Person p = new Person(firstName, lastName, pnumber);
    	helper.addPerson(p);
    	
    	// 1. Instantiate an AlertDialog.Builder with its constructor
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);

    	// 2. Chain together various setter methods to set the dialog characteristics
    	builder.setMessage(R.string.person_added_message)
    	       .setTitle(R.string.success_title);
    	
    	builder.setNeutralButton(R.string.ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicked OK button
            }
        });

    	// 3. Get the AlertDialog from create()
    	AlertDialog dialog = builder.create();
    	
    	first.setText("");
    	last.setText("");
    	pn.setText("");
    }
    
    /** Called when the user clicks the Back button */
    public void back(View v){
		Intent intent = new Intent(this, MainActivity.class);
		setResult(RESULT_OK, intent);
		finish();
	}

}
