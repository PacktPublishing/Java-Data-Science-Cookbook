package chap4.java.science.data;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instances;

public class WekaArffTest {
	public static void main(String[] args) throws Exception {
		ArrayList<Attribute>      attributes;
		ArrayList<String>      classVals;
		Instances       data;
		double[]        values;

		// Set up attributes
		attributes = new ArrayList<Attribute>();
		// Numeric attribute
		attributes.add(new Attribute("age"));
		// String attribute
		ArrayList<String> empty = null;
		attributes.add(new Attribute("name", empty));
		// Date attribute
		attributes.add(new Attribute("dob", "yyyy-MM-dd"));
		classVals = new ArrayList<String>();
		for (int i = 0; i < 5; i++){
			classVals.add("class" + (i + 1));
		}
		Attribute classVal = new Attribute("class", classVals);
		attributes.add(classVal);

		// Create Instances object
		data = new Instances("MyRelation", attributes, 0);

		// Data fill up
		// First instance
		values = new double[data.numAttributes()];
		values[0] = 35;
		values[1] = data.attribute(1).addStringValue("John Doe");
		values[2] = data.attribute(2).parseDate("1981-01-20");
		values[3] = classVals.indexOf("class3");

		// add
		data.add(new DenseInstance(1.0, values));

		// Second instance
		values = new double[data.numAttributes()];  // important: needs NEW array!
		values[0] = 30;
		values[1] = data.attribute(1).addStringValue("Harry Potter");
		values[2] = data.attribute(2).parseDate("1986-07-05");
		values[3] = classVals.indexOf("class1");

		// add
		data.add(new DenseInstance(1.0, values));

		//writing arff file to disk
		BufferedWriter writer = new BufferedWriter(new FileWriter("c:/training.arff"));
		writer.write(data.toString());
		writer.close();

		// Output data
		System.out.println(data);
	}
}
