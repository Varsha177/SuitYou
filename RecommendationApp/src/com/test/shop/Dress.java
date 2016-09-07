package com.test.shop;

public class Dress {

	//name ,id, age and name
		String name ;
		int price ;
		String colour ;
		String size ;
		String description;
		String brand;
		String ltw ;
		String TAGS;
		String imagePath;
		
		public Dress(String name, int price, String colour, String size,
				String description, String brand, String ltw,String TAGS, String imagePath) {
			
			this.name = name;
			this.price = price;
			this.colour = colour;
			this.size = size;
			this.description =description;
			this.brand = brand;
			this.ltw =ltw;
			this.TAGS = TAGS;
			this.imagePath = imagePath;
		}

}
