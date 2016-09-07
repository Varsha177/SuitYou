package com.test.shop;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Dresses extends Activity{
	
	private Button RecommendationButton;
	
	
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dresses);
        
        RecommendationButton = (Button)findViewById(R.id.button1);
        RecommendationButton.setOnClickListener(new OnClickListener() {
 		
 		public void onClick(View v) {
 			// TODO Auto-generated method stub
 			Intent intentFive= new Intent();
 			intentFive.setAction("android.intent.action.RECOMMENDATION");
 			intentFive.addCategory(Intent.CATEGORY_DEFAULT);
 			startActivity(intentFive);
 			
 			
 		}
 	});
        
	}

};

