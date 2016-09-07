package com.test.shop;


import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

public class Recommendation extends Activity{

	parser parse  = new parser();
	Evaluator evaluate = new Evaluator();
	
	public static int total;
	public static int countBA1;
	public static int countBA2;
	public static int countBoA1;
	public static int countBoA2;
	public static int countCA1;
	public static int countCA2;
	public static int countDA1;
	public static int countDA2;
	

	public static ArrayList<Dress> bangaloreDressesA1;
	public static ArrayList<Dress> bombayDressesA1;
	public static ArrayList<Dress> delhiDressesA1;
	public static ArrayList<Dress> chennaiDressesA1;
	
	public static ArrayList<Dress> bangaloreDressesA2;
	public static ArrayList<Dress> bombayDressesA2;
	public static ArrayList<Dress> delhiDressesA2;
	public static ArrayList<Dress> chennaiDressesA2;
	
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);
        
        bangaloreDressesA1 = new ArrayList<Dress>();
        bombayDressesA1 = new ArrayList<Dress>();
        delhiDressesA1 = new ArrayList<Dress>();
        chennaiDressesA1 = new ArrayList<Dress>();
        
        
        bangaloreDressesA2 = new ArrayList<Dress>();
        bombayDressesA2 = new ArrayList<Dress>();
        delhiDressesA2 = new ArrayList<Dress>();
        chennaiDressesA2 = new ArrayList<Dress>();
        
        
        File f1 = new File("/sdcard/TAGS/BangaloreA1");
        countBA1 = 0;
        for (File file : f1.listFiles()) {
                if (file.isFile()) {
                        countBA1++;
                }
                System.out.println("Filename" + file.getAbsolutePath());
        }
        
        
        File f2 = new File("/sdcard/TAGS/BangaloreA2");
        countBA2 = 0;
        for (File file : f2.listFiles()) {
                if (file.isFile()) {
                        countBA2++;
                }
                System.out.println("Filename" + file.getAbsolutePath());
        }
        
        File f3 = new File("/sdcard/TAGS/BombayA1");
        countBoA1 = 0;
        for (File file : f3.listFiles()) {
                if (file.isFile()) {
                        countBoA1++;
                }
                System.out.println("Filename" + file.getAbsolutePath());
        }
        
        File f4 = new File("/sdcard/TAGS/BombayA2");
        countBoA2 = 0;
        for (File file : f4.listFiles()) {
                if (file.isFile()) {
                        countBoA2++;
                }
                System.out.println("Filename" + file.getAbsolutePath());
        }
        
        File f5 = new File("/sdcard/TAGS/DelhiA1");
        countDA1 = 0;
        for (File file : f5.listFiles()) {
                if (file.isFile()) {
                        countDA1++;
                }
                System.out.println("Filename" + file.getAbsolutePath());
        }
        
        File f6 = new File("/sdcard/TAGS/DelhiA2");
        countDA2 = 0;
        for (File file : f6.listFiles()) {
                if (file.isFile()) {
                        countDA2++;
                }
                System.out.println("Filename" + file.getAbsolutePath());
        }
        
        File f7 = new File("/sdcard/TAGS/ChennaiA1");
        countCA1 = 0;
        for (File file : f7.listFiles()) {
                if (file.isFile()) {
                        countCA1++;
                }
                System.out.println("Filename" + file.getAbsolutePath());
        }
        
        File f8 = new File("/sdcard/TAGS/ChennaiA2");
        countCA2 = 0;
        for (File file : f8.listFiles()) {
                if (file.isFile()) {
                        countCA2++;
                }
                System.out.println("Filename" + file.getAbsolutePath());
        }
        
        total = countBA1 + countBoA1 + countCA1 + countDA1 + countBA2 + countBoA2 + countCA2 + countDA2;
       System.out.println("Number of files: " + total);
        
        evaluate.parseXmlFile();
        evaluate.parseDocument(); 
        
        parse.parseXmlFile();
        parse.parseDocument();
        

        Iterator<Dress> dressesIterator = parse.dressList.iterator();
        while(dressesIterator.hasNext()) {
        	Dress d = dressesIterator.next();
        	if(d.TAGS.equals("BangaloreA1")){
        		bangaloreDressesA1.add(d);
        		
        	}
        	else if(d.TAGS.equals("BangaloreA2")){
        		bangaloreDressesA2.add(d);
        		
        	}
        	else if(d.TAGS.equals("DelhiA1")){
        		delhiDressesA1.add(d);
            }
        	else if(d.TAGS.equals("DelhiA2")){
        		delhiDressesA2.add(d);
            }
        	else if(d.TAGS.equals("ChennaiA1")){
        		chennaiDressesA1.add(d);
        	}
        	else if(d.TAGS.equals("ChennaiA2")){
        		chennaiDressesA2.add(d);
        	}
        	else if(d.TAGS.equals("BombayA1")){
        		bombayDressesA1.add(d);
        	}
        	else if(d.TAGS.equals("BombayA2")){
        		bombayDressesA2.add(d);
        	}
        }


       //setContentView(R.layout.recommendation);
        
        Log.v("dresses" , "Size of dress collectio:" + parse.dressList.size());
        //setListAdapter(new ArrayAdapter<String>(this, R.layout.recommendation,List<String>dressList));
        //setListAdapter(new ArrayAdapter<Dress>(this,R.layout.recommendation, DRESSLIST));
        
        //setListAdapter(new ArrayAdapter<String>(this, R.layout.dresses));
       // ListView lv = getListView();
        //lv.setTextFilterEnabled(true);
        
        ListView list = (ListView) findViewById(R.id.dress_list);
        
        list.setAdapter(new DressListBaseAdapter(this,parse.dressList, evaluate.personList ));
        
        Log.v("dresses" , "Bangalore:" + bangaloreDressesA1.size());
        Log.v("dresses" , "Delhi:" + delhiDressesA1.size());
        Log.v("dresses" , "BBay:" + bombayDressesA1.size());
        Log.v("dresses" , "Chennai:" + chennaiDressesA1.size());
        
        
        
        
        
        
        
        
        

        //lv.setOnItemClickListener(new OnItemClickListener() {
          //public void onItemClick(AdapterView<?> parent, View view,
            //  int position, long id) {
            // When clicked, show a toast with the TextView text
            //Toast.makeText(getApplicationContext(), ((TextView) view).getText(),
             //   Toast.LENGTH_SHORT).show();
         
         // }
       // });

	}
}

