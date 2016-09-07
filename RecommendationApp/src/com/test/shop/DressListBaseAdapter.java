package com.test.shop;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class DressListBaseAdapter extends BaseAdapter {
	private static ArrayList<Dress> itemDetailsrrayList;
	private static ArrayList<Person> PersonList;

	private LayoutInflater l_Inflater;

	private int bangIndex;
	private int bomIndex;
	private int delIndex;
	private int chenIndex;
	private int exhaustB;
	private int exhaustBo;
	private int exhaustD;
	private int exhaustC;
	private int entered;
	boolean isExhausted = false;
	private ArrayList<View> viewHolderList = new ArrayList<View>();

	public DressListBaseAdapter(Context context, ArrayList<Dress> results,
			ArrayList<Person> personList) {
		itemDetailsrrayList = results;
		PersonList = personList;
		l_Inflater = LayoutInflater.from(context);

	}

	public int getCount() {
		Log.v("dress", "ADAPTER" + itemDetailsrrayList.size());
		return itemDetailsrrayList.size();
	}

	public Object getItem(int position) {
		return itemDetailsrrayList.get(position);

	}

	public long getItemId(int position) {

		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		View listItem = l_Inflater.inflate(R.layout.recommendation, null);

		// First do math on how many dresses in each city
		// Find which is thr greatest.... calc ratios
		View v;
		try{
		    v = viewHolderList.get(position);
		}
		    
		catch(IndexOutOfBoundsException e) {
			v = null;
		}
		if(v != null){
			return v;
		}

		int mod = position
				% (Person.total[0] + Person.total[1] + Person.total[2] + Person.total[3]);
		

		String whichCity = checkInBounds(mod);
		Log.v("aks", " ModValue :" + mod);
		Dress d = null;

		Log.v("aks", "POSITION : " + position + " whichCity :" + whichCity);

		if (Person.Group == Person.Age1) {
			Log.v("dress", " ENTERED");

			if (whichCity.equals("TB")) {
				Log.v("dress", " IN TB, dress :" + d.name);
			
				if (bomIndex < Recommendation.bombayDressesA1.size()) {
					d = Recommendation.bombayDressesA1.get(bomIndex);
					Log.v("dress", " IN BBAY, dress :" + d.name);
					exhaustBo = 0;
					++bomIndex;
					entered = 1;
					isExhausted = false;

				} else {
					entered = 0;
					isExhausted = true;
					exhaustBo = 1;
					
				}

			}

			else if (whichCity.equals("TD")) {
				Log.v("dress", " GOINGONCE, dress :" +delIndex + "hi" + Recommendation.delhiDressesA1.size());
				if (delIndex < Recommendation.delhiDressesA1.size()) {
					d = Recommendation.delhiDressesA1.get(delIndex);
					Log.v("dress", " IN DELHI, dress :" + d.name);
					exhaustD = 0;
					++delIndex;
					entered = 1;
					isExhausted = false;
				} else {
					entered = 0;
					isExhausted = true;
					exhaustD = 1;
				}

			} else if (whichCity.equals("TC")) {
			
				if (chenIndex < Recommendation.chennaiDressesA1.size()) {
					d = Recommendation.chennaiDressesA1.get(chenIndex);
					Log.v("dress", " IN CH, dress :" + d.name);
					exhaustC = 0;
					++chenIndex;
					entered = 1;
					isExhausted = false;
				} else {
					entered = 0;
					isExhausted = true;
					exhaustC = 1;
				}

			} else if (whichCity.equals("TBa")) {
				
				Log.v("dress", " GOING, dress :" +bangIndex + "hi" + Recommendation.bangaloreDressesA1.size());
				if (bangIndex < Recommendation.bangaloreDressesA1.size()) {
					d = Recommendation.bangaloreDressesA1.get(bangIndex);
					Log.v("dress", " IN BA, dress :" + d.name);
					exhaustB = 0;
					++bangIndex;
					entered = 1;
					isExhausted = false;
				} else {
					entered = 0;
					isExhausted = true;
					exhaustB = 1;
				}

			}

		}

		else if (Person.Group == Person.Age2) {
			Log.v("dress", " ENTERED AGAIN");

			if (whichCity.equals("TB")) {
				

				if (bomIndex < Recommendation.bombayDressesA2.size()) {
					d = Recommendation.bombayDressesA2.get(bomIndex);
					Log.v("dress", " IN B2, dress :" + d.name);
					exhaustBo = 0;
					++bomIndex;
					entered = 1;
				} else {
					exhaustBo = 1;
				}

			}

			else if (whichCity.equals("TD")) {
				
				if (delIndex < Recommendation.delhiDressesA2.size()) {
					d = Recommendation.delhiDressesA2.get(delIndex);
					Log.v("dress", " IN DELHI2, dress :" + d.name);
					exhaustD = 0;
					++delIndex;
					entered = 1;
				} else {
					exhaustD = 1;
				}

			} else if (whichCity.equals("TC")) {
				

				if (chenIndex < Recommendation.chennaiDressesA2.size()) {
					d = Recommendation.chennaiDressesA2.get(chenIndex);
					exhaustC = 0;
					++chenIndex;
					entered = 1;
				} else {
					exhaustC = 1;
				}
			} else if (whichCity.equals("TBa")) {
				

				if (bangIndex < Recommendation.bangaloreDressesA2.size()) {
					d = Recommendation.bangaloreDressesA2.get(bangIndex);
					exhaustB = 0;
					++bangIndex;
					entered = 1;
				} else {
					exhaustB = 1;
				}

			}
		}
		
		if(isExhausted) {
			if (bangIndex < Recommendation.bangaloreDressesA1.size()) {
				d = Recommendation.bangaloreDressesA1.get(bangIndex);
				++bangIndex;
				isExhausted = false;
				
			} 
			else if (delIndex < Recommendation.delhiDressesA1.size()) {
				d = Recommendation.delhiDressesA1.get(delIndex);
				exhaustD = 0;
				++delIndex;
				isExhausted = false;
			} 
			else if (chenIndex < Recommendation.chennaiDressesA1.size()) {
				d = Recommendation.chennaiDressesA1.get(chenIndex);
				++chenIndex;
				isExhausted = false;
			} 
			else if (bomIndex < Recommendation.bombayDressesA1.size()) {
				d = Recommendation.bombayDressesA1.get(bomIndex);
				++bomIndex;
				isExhausted = false;
			} 
			
			
			
		}
//		if (exhaustB == 0 && exhaustD == 1 && exhaustBo == 1 && exhaustC == 1 && entered != 1) {
//
//			if (bangIndex < Recommendation.bangaloreDressesA1.size()) {
//				d = Recommendation.bangaloreDressesA1.get(bangIndex);
//				++bangIndex;
//			} else {
//				exhaustB = 1;
//			}
//		}
//
//		else if (exhaustD == 0 && exhaustB == 1 && exhaustBo == 1 && exhaustC == 1 && entered != 1) {
//
//			if (delIndex < Recommendation.delhiDressesA1.size()) {
//				d = Recommendation.delhiDressesA1.get(delIndex);
//				exhaustD = 0;
//				++delIndex;
//			} else {
//				exhaustD = 1;
//			}
//		}
//
//		else if (exhaustC == 0 && exhaustB == 1 && exhaustBo == 1 && exhaustD == 1 && entered != 1) {
//
//			if (chenIndex < Recommendation.chennaiDressesA1.size()) {
//				d = Recommendation.chennaiDressesA1.get(chenIndex);
//				++chenIndex;
//			} else {
//				exhaustC = 1;
//			}
//		}
//
//		else if (exhaustBo == 0 && exhaustB == 1 && exhaustD == 1 && exhaustC == 1 && entered != 1) {
//
//			if (bomIndex < Recommendation.bombayDressesA1.size()) {
//				d = Recommendation.bombayDressesA1.get(bomIndex);
//				++bomIndex;
//			} else {
//				exhaustBo = 1;
//			}
//		}

		TextView dressName = (TextView) listItem.findViewById(R.id.dress_name);
		// Set the text based on the above city object as calac.
		Log.v("dress", " dress name :" + d);
		Log.v("dress", " USELESS");
		dressName.setText(d.name);

		TextView brandName = (TextView) listItem.findViewById(R.id.brand_name);
		brandName.setText(d.brand);

		// if(PersonList.get(0).Bangalore > 0) {

		// }

		TextView priceAmount = (TextView) listItem
				.findViewById(R.id.price_amount);
		priceAmount.setText(String.valueOf(d.price));

		ImageView image = (ImageView) listItem.findViewById(R.id.imageView1);

		String imagePath = null;

		if (d.TAGS.equals("BangaloreA1"))
			imagePath = "/sdcard/TAGS/BangaloreA1/";
		else if (d.TAGS.equals("BombayA1"))
			imagePath = "/sdcard/TAGS/BombayA1/";
		else if (d.TAGS.equals("ChennaiA1"))
			imagePath = "/sdcard/TAGS/ChennaiA1/";
		else
			imagePath = "/sdcard/TAGS/DelhiA1/";

		Bitmap p = BitmapFactory.decodeFile(imagePath + d.imagePath);

		image.setImageBitmap(p);
		viewHolderList.add(position, listItem);

		return listItem;
	}

	private String checkInBounds(int value) {
		Person p = PersonList.get(0);
		int arr[] = p.total;
		for(int i = 0 ; i < arr.length; i++) {
			Log.v("akshay", " Total at :" + i + " = " + arr[i]);
			Log.v("akshay", " Order at :" + i + " = " + p.order[i]);
			
		}
		
		if (value < arr[0]) {
			return p.order[0];

		} else if (value < (arr[0] + arr[1])) {
			
			
			return p.order[1];
		} else if (value < (arr[0] + arr[1] + arr[2])) {
			return p.order[2];
		} else
			return p.order[3];

	}

}
