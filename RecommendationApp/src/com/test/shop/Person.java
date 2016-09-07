package com.test.shop;

import android.util.Log;
import android.util.StringBuilderPrinter;
import com.test.shop.Recommendation;

public class Person {

	//name ,id, age and name
		String hometown ;
		String currentCity ;
		String Movie1;
		String Movie2;
		String Movie3;
		String Music1;
		String Music2;
		String Music3;
		String Event1;
		String Event2;
		String CheckIn1;
		String CheckIn2;
		String WorkPlace;
		static int Age1;
		static int Age2;
		public static int Group;
		int age;
		
		
		
		
		float Delhi;
		float Bangalore;
		float Bombay;
		float Chennai;
		float MH;
		float EH;
		float ME;
		float EE;
		float LB;
		float PUBS;
		float ICS;
		float WCS;
		float MM;
		float PARTY;
		float CP;
		
		
		int TD;
		int TBa;
		int TB;
		int TC;
		
		
		static int total[] = new int[4];
		int i;
		int j;
		int n = 4;
		int temp;
		int result;
		
		
		String order[] = {"TD","TB","TBa","TC"};
		
		public Person(String hometown,String currentCity,String Movie1,String Movie2,String Movie3, String Music1,String Music2,String Music3,String Event1,String Event2,String CheckIn1, String CheckIn2, String WorkPlace,int age) {
			
			this.hometown = hometown;
			this.currentCity = currentCity;
			this.Movie1 = Movie1;
			this.Movie2 = Movie2;
			this.Movie3 = Movie3;
			this.Music1 = Music1;
			this.Music2 = Music2;
			this.Music3 = Music3;
			this.Event1 = Event1;
			this.Event2 = Event2;
			this.CheckIn1 = CheckIn1;
			this.CheckIn2 = CheckIn2;
			this.WorkPlace = WorkPlace;
			this.age = age;
			
			// TODO Auto-generated constructor stub
			
			if(this.hometown.equals("Delhi"))
				Delhi = 20;
			if(this.hometown.equals("Bangalore"))
				Bangalore = 20;
			if(this.hometown.equals("Bombay"))
				Bombay = 20;
			if(this.hometown.equals("Chennai"))
				Chennai = 20;
			
			
			
			if(this.currentCity.equals("Delhi"))
				Delhi = 20;
			if(this.currentCity.equals("Bangalore"))
			    Bangalore = 20;
			if(this.currentCity.equals("Bombay"))
				Bombay = 20;
			if(this.currentCity.equals("Chennai"))
				Chennai = 20;
			
			
			if((this.age > 16) && (this.age < 29))
			{
				Age1 = this.age;
				Group = Age1;
			}
			
			
			if((this.age > 28) && (this.age < 41))
			{
				Age2 = this.age;
				Group = Age2;
			}
			
			
			
			Log.v("dress" , " Delhi :" + Delhi + " Bangalore :" + Bangalore + " Bombay :" + Bombay + " Chennai :" + Chennai);
			
			likescore();
			eventscore();
			totalscore();

		}
		
		
		void likescore()
		{
			String[] Movies= {this.Movie1,this.Movie2,this.Movie3};
			String[] Music = {this.Music1,this.Music2,this.Music3};
			int i;
			for(i = 0;i < 3; ++i)
			{
				if(Movies[i].equals("MH"))
				{
					++MH;
			
				}
				else if(Movies[i].equals("EH"))
				{
					++EH;
				}
				else if(Movies[i].equals("ME"))
				{
					++ME;
				}
				else if(Movies[i].equals("EE"))
				{
					++EE;
				}
				
				
				
				
				
			    if(Music[i].equals("MH"))
				{
					++MH;
			
				}
				else if(Music[i].equals("EH"))
				{
					++EH;
				}
				else if(Music[i].equals("ME"))
				{
					++ME;
				}
				else if(Music[i].equals("EE"))
				{
					++EE;
				}
				
			}
			Log.v("dress" , " MH :" + MH + " ME :" + ME + " EH :" + EH + " EE :" + EE);
			
			MH = (MH / 6) * 20;
			EH = (EH / 6) * 20;
			ME = (ME / 6) * 20;
			EE = (EE / 6) * 20;
			Log.v("dress" , " MH :" + MH + " ME :" + ME + " EH :" + EH + " EE :" + EE);
			
			Delhi = Delhi + MH;
			Delhi = Delhi + ME;
			Bombay = Bombay + EH;
			Bombay = Bombay + EE;
			
			
			Log.v("dress" , " Delhi :" + Delhi + " Bangalore :" + Bangalore + " Bombay :" + Bombay + " Chennai :" + Chennai);
				
		}
		
		void eventscore()
		{
			String[] Events = {this.Event1,this.Event2};
			String[] CheckIns = {this.CheckIn1,this.CheckIn2};
			int i;
			for(i = 0;i < 2; ++i)
			{
				if(Events[i].equals("LB"))
				{
					++LB;
			
				}
				else if(Events[i].equals("PUBS"))
				{
					++PUBS;
				}
				else if(Events[i].equals("ICS"))
				{
					++ICS;
				}
			
				else if(Events[i].equals("WCS"))
				{
					++WCS;
				}
				else if(Events[i].equals("MM"))
				{
					++MM;
				}
				
			
				if(CheckIns[i].equals("ICS"))
				{
					++ICS;
			
				}
				else if(CheckIns[i].equals("WCS"))
				{
					++WCS;
			
				}
				else if(CheckIns[i].equals("PARTY"))
				{
					++PARTY;
				}
				else if(CheckIns[i].equals("CP"))
				{
					++CP;
				}
				
				
			}
			
			LB = (LB / 4) * 20;
			PUBS = (PUBS / 4) * 20;
			ICS = (ICS / 4) * 20;
			WCS = (WCS / 4) * 20;
			MM = (MM / 4) * 20;
			PARTY = (PARTY / 4) * 20;
			CP = (CP / 4) * 20;
			
			if(WorkPlace.equals("IT"))
				Bangalore += 20;
			else if(WorkPlace.equals("PS"))
				Chennai += 20;
			else if(WorkPlace.equals("DS"))
				Bombay += 20;
			
				
			
			Delhi += LB + PARTY;
			Bangalore += CP + PUBS + MM;
			Bombay += WCS;
			Chennai += ICS;
			
		
			
			Log.v("dress" , " Delhi :" + Delhi + " Bangalore :" + Bangalore + " Bombay :" + Bombay + " Chennai :" + Chennai);
		}

		
		void totalscore()
		{
			TD = (int) ((Delhi * Recommendation.total) / 100);
			TBa = (int) ((Bangalore * Recommendation.total) / 100);
			TB = (int) ((Bombay * Recommendation.total) / 100);
			TC = (int) ((Chennai * Recommendation.total) / 100);

			Log.v("dress" , " TD :" + TD + " TBa :" + TBa + " TB :" + TB + " TC :" + TC);
			
			total[0] = TD;
			total[1] = TBa; 
			total[2] = TB;
			total[3] = TC;

			
			  for(i = 0; i < n; i++){
				  for(j = 1; j < (n-i); j++){
					  if(total[j-1] < total[j]){
						  temp = total[j-1];
						  total[j-1]=total[j];
						  total[j]=temp; 
					  }
				  }
			  }
			  
			  
			  for(i = 0; i < n; i++){

					  //System.out.println("Order : " + total[i]);
					  Log.v("dress" , "Order : " + total[i]);
				  
			  }
			  
			  long result = total[0];
			  for(int i = 0;i < total.length ; i++)
			  {

				  result = hcf(result,total[i]);
				  Log.v("dress" , " result :" + result + " total :" + total[i]);
				  
			  }
			  
			  boolean enteredDelhi = false;
			  boolean enteredBang = false;
			  boolean enteredMum = false;
			  boolean enteredChen = false;
			  for(int i = 0;i<total.length;++i)
			  {
				  if(total[i] == TD && enteredDelhi == false) {
					  order[i] = "TD";
					  enteredDelhi = true;
				  }
				  else if(total[i] == TBa && enteredBang == false) {
					  order[i] = "TBa";
					  enteredBang = true;
				  }
				  else if(total[i] == TB && enteredMum == false) {
					  order[i] = "TB";
					  enteredMum = true;
				  }
				  else if(total[i] == TC && enteredChen == false) {
					  order[i] = "TC";
					  enteredChen = true;
				  }
			  }
			  for(int i = 0; i < total.length ; i++)
			  {
				  total[i] /= result;
				  Log.v("dress" , " result :" + result + " total :" + total[i]);
				  Log.v("dress" , " order :" + order[i]);
				  
			  }
			  
			  
		}

		public static long hcf(long result2, long k) {
			Log.v("result2" + result2, "k: " + k);
			while( k > 0)
			{
				long temp = k;
				k = result2 % k;
				result2 = temp;
			}
			 return result2;
			// TODO Auto-generated method stub
			
		}
	
}

			
