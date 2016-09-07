package com.test.shop;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ClothesOne extends Activity{
	
	  
 
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.one);
	        
	        Button EnterButton;
	        
	        final EditText ApparelContent;
	        
	        
	        
	        
	      
	        EditText select = (EditText) findViewById(R.id.editText1);
	        Spinner spinner = (Spinner) findViewById(R.id.spinner);
	        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
	                this, R.array.typeofapparel_array, android.R.layout.simple_spinner_item);
	        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	        spinner.setAdapter(adapter);
	        
	        Resources res = getResources();
	        String[] typeofapparel = res.getStringArray(R.array.typeofapparel_array);
	        
	        
	        spinner.setOnItemSelectedListener(new MyOnItemSelectedListener(typeofapparel,select));
	        
	        ApparelContent = (EditText) findViewById(R.id.editText1);
	        
	        
	        EnterButton = (Button)findViewById(R.id.button1);
	        
	        EnterButton.setOnClickListener(new OnClickListener() {
	   		
	   		public void onClick(View v) {
	   			// TODO Auto-generated method stub
    			String text;
      			text = ApparelContent.getText().toString();
//	   			sendSms();
//	   			Toast.makeText(getApplicationContext(), "Boom!",5 ).show();
//	   			finish();
	   			if(text.contentEquals("Dresses"))
	   			{
	   				Intent intentTwo = new Intent();
	   				intentTwo.setAction("android.intent.action.DRESSES");
	   				intentTwo.addCategory(Intent.CATEGORY_DEFAULT);
	   				startActivity(intentTwo);
	   				
	   			}
	   			else if(text.contentEquals("Tops"))
	   			{
	   				Intent intentThree = new Intent();
	   				intentThree.setAction("android.intent.action.TOPS");
	   				intentThree.addCategory(Intent.CATEGORY_DEFAULT);
	   				startActivity(intentThree);
	   				
	   			}
	   			else if(text.contentEquals("Bottoms"))
	   			{
	   				Intent intentFour = new Intent();
	   				intentFour.setAction("android.intent.action.BOTTOMS");
	   				intentFour.addCategory(Intent.CATEGORY_DEFAULT);
	   				startActivity(intentFour);
	   				
	   			}
	   			

	   			
	   			
	   			
	   		}
	   	} );
}
	 

};


