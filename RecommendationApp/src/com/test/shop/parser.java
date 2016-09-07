package com.test.shop;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import android.util.Log;



//import android.sax.Element;

public class parser
{
private Document dom;
public ArrayList<Dress> dressList = new ArrayList<Dress>();

public void parseXmlFile(){
		//get the factory
	
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		try {

			//Using factory get an instance of document builder
			DocumentBuilder db = dbf.newDocumentBuilder();

			//parse using builder to get DOM representation of the XML file
			 dom = db.parse("file:///sdcard/dresses.xml");
		}catch(ParserConfigurationException pce) {
			pce.printStackTrace();
		}catch(SAXException se) {
			se.printStackTrace();
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}

public void parseDocument(){
	
	//get the root element
	Element docEle = (Element) dom.getDocumentElement();

	//get a nodelist of elements
	NodeList nl = (docEle).getElementsByTagName("dress");
	
	
	Log.v("dress", "dree value size :count:" + nl.getLength());
	if(nl != null && nl.getLength() > 0) {
		for(int i = 0 ; i < nl.getLength();i++) {

			//get the employee element
			Element el = (Element)nl.item(i);

			//get the object 			
			Dress d = getDress(el);
			
			dressList.add(d);
			
		}
	}
}

private Dress getItem(Element el) {
	
	return null;
}

public Dress getDress(Element dressEl) {

	//for each <employee> element get text or int values of
	//name ,id, age and name
	String name = getTextValue(dressEl,"name");
	int price  = getIntValue(dressEl,"price");
	String colour = getTextValue(dressEl,"colour");
	String size = getTextValue(dressEl,"size");
	String description = getTextValue(dressEl,"description");
	String brand = getTextValue(dressEl,"brand");
	String ltw = getTextValue(dressEl,"ltw");
	String TAGS = getTextValue(dressEl,"tag");
	String imagePath = getTextValue(dressEl,"filename");

	//String type = ((org.w3c.dom.Element) empEl).getAttribute("type");

	//Create a new Employee with the value read from the xml nodes
	Dress d = new Dress(name,price,colour,size,description,brand,ltw,TAGS, imagePath);

	return d;
}

private String getTextValue(Element ele, String tagName) {
	String textVal = null;
	
	NodeList nl = (ele).getElementsByTagName(tagName);
	if(nl != null && nl.getLength() > 0) {
		Element el = (Element)nl.item(0);
		textVal = ((Node) el).getFirstChild().getNodeValue();
	}

	return textVal;
}
private int getIntValue(Element ele, String tagName) {
	//in production application you would catch the exception
	return Integer.parseInt(getTextValue(ele,tagName));
}

///private void printData(){
	
	////System.out.println("hello");


	//System.out.println(" " + myEmpls.size() + "'.");

	//Iterator it = myDress.iterator();
	//while(it.hasNext()) {
		//System.out.println(it.next().toString());
	//}
}

