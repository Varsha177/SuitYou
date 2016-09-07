package com.test.shop;

import android.content.Intent;
import android.text.Selection;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class MyOnItemSelectedListener implements OnItemSelectedListener {
	
	
	private String[] apparels;
	private EditText select;
	
	public MyOnItemSelectedListener(String [] apparels,EditText select) {
		// TODO Auto-generated constructor stub
		this.apparels = apparels;
		this.select = select;
	}
	

    public void onItemSelected(AdapterView<?> parent,
        View view, int pos, long id) {
    	
     // Toast.makeText(parent.getContext(), "You've chosen : " +
         // parent.getItemAtPosition(pos).toString(), Toast.LENGTH_LONG).show();
    	
       select.setText(apparels[pos]);
      

    }
    

    private void startActivity(Intent intentTwo) {
		// TODO Auto-generated method stub
		
	}

	public void onNothingSelected(AdapterView parent) {
		//Do Nothing.
    }
};




