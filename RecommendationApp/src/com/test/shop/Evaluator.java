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

public class Evaluator
{
private Document dom;
public ArrayList<Person> personList = new ArrayList<Person>();

public void parseXmlFile(){
		//get the factory
	
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		try {

			//Using factory get an instance of document builder
			DocumentBuilder db = dbf.newDocumentBuilder();

			//parse using builder to get DOM representation of the XML file
			 dom = db.parse("file:///sdcard/evaluator.xml");
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
	NodeList nl = (docEle).getElementsByTagName("Person");
	if(nl != null && nl.getLength() > 0) {
		for(int i = 0 ; i < nl.getLength();i++) {

			//get the employee element
			Element el = (Element)nl.item(i);

			//get the object 			
			Person p = getPerson(el);
			
			personList.add(p);
			Log.v("dress", "Count, Delhi  :" + p.Delhi +  "Bangalore :" + p.Bangalore);
		}
	}
}

private Person getItem(Element el) {
	
	return null;
}

public Person getPerson(Element personEl) {

	//for each <employee> element get text or int values of
	//name ,id, age and name
	String hometown = getTextValue(personEl,"Hometown");
	String currentCity = getTextValue(personEl,"CurrentCity");
	String Movie1 = getTextValue(personEl,"Movie1");
	String Movie2 = getTextValue(personEl,"Movie2");
	String Movie3 = getTextValue(personEl,"Movie3");
	String Music1 = getTextValue(personEl,"Music1");
	String Music2 = getTextValue(personEl,"Music2");
	String Music3 = getTextValue(personEl,"Music3");
	String Event1 = getTextValue(personEl,"Event1");
	String Event2 = getTextValue(personEl,"Event2");
	String CheckIn1 = getTextValue(personEl,"CheckIn1");
	String CheckIn2 = getTextValue(personEl,"CheckIn2");
	String WorkPlace = getTextValue(personEl,"WorkPlace");
	int age = getIntValue(personEl,"Age");
	
	


	//String type = ((org.w3c.dom.Element) empEl).getAttribute("type");

	//Create a new Employee with the value read from the xml nodes
	Person p = new Person(hometown,currentCity,Movie1,Movie2,Movie3,Music1,Music2,Music3,Event1,Event2,CheckIn1,CheckIn2,WorkPlace,age);

	return p;
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


