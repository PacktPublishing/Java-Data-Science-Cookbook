package chap4.java.science.data;

import weka.classifiers.meta.FilteredClassifier;
import weka.classifiers.trees.RandomForest;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.unsupervised.attribute.Remove;


public class WekaFilteredClassifierTest {
	Instances weather = null;
	RandomForest rf;

	public void loadArff(String arffInput){
		DataSource source = null;
		try {
			source = new DataSource(arffInput);
			weather = source.getDataSet();
			weather.setClassIndex(weather.numAttributes() - 1);
		} catch (Exception e1) {
		}
	}

	public void buildFilteredClassifier(){
		rf = new RandomForest();
		Remove rm = new Remove();
		rm.setAttributeIndices("1");
		FilteredClassifier fc = new FilteredClassifier();
		fc.setFilter(rm);
		fc.setClassifier(rf);
		try{
			fc.buildClassifier(weather);
			for (int i = 0; i < weather.numInstances(); i++){
				double pred = fc.classifyInstance(weather.instance(i));
				System.out.print("given value: " + weather.classAttribute().value((int) weather.instance(i).classValue()));
				System.out.println("---predicted value: " + weather.classAttribute().value((int) pred));
			}
		} catch (Exception e) {
		}
	}
	
	public static void main(String[] args){
		WekaFilteredClassifierTest test = new WekaFilteredClassifierTest();
		test.loadArff("C:/Program Files/Weka-3-6/data/weather.nominal.arff");
		test.buildFilteredClassifier();
	}
}
