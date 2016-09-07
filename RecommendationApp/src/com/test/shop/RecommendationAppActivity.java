package com.test.shop;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class RecommendationAppActivity extends Activity {
    /** Called when the activity is first created. */
	
	private Button ClothesButton;
	private Button BooksButton;
	private Spinner TypeSpinner;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
       ClothesButton = (Button)findViewById(R.id.button1);
       ClothesButton.setOnClickListener(new OnClickListener() {
		
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intentOne = new Intent();
			intentOne.setAction("android.intent.action.CLOTHESONE");
			intentOne.addCategory(Intent.CATEGORY_DEFAULT);
			startActivity(intentOne);
			
			
		}
	});
       //BooksButton = (Button)findViewById(R.id.button2);
       

       
       
    }
}