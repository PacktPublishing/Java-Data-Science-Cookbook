package chap4.java.science.data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import weka.classifiers.bayes.NaiveBayes;
import weka.core.Instances;

public class WekaTrainTest {
	NaiveBayes nb;
	Instances train, test, labeled;
	
	public void loadModel(String modelPath){
		try {
			nb = (NaiveBayes) weka.core.SerializationHelper.read(modelPath);
		} catch (Exception e) {
		}
	}
	
	public void loadDatasets(String training, String testing){
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(training));
			train = new Instances (reader);
			train.setClassIndex(train.numAttributes() -1);
		} catch (IOException e) {
		}


		try {
			reader = new BufferedReader(new FileReader(testing));
			test = new Instances (reader);
			test.setClassIndex(train.numAttributes() -1);
		} catch (IOException e) {
		}

		try {
			reader.close();
		} catch (IOException e) {
		}
	}

	public void classify(){
		try {
			nb.buildClassifier(train);
		} catch (Exception e) {
		}

		labeled = new Instances(test);

		for (int i = 0; i < test.numInstances(); i++) {
			double clsLabel;
			try {
				clsLabel = nb.classifyInstance(test.instance(i));
				labeled.instance(i).setClassValue(clsLabel);
				double[] predictionOutput = nb.distributionForInstance(test.instance(i));
				double predictionProbability = predictionOutput[1];
				System.out.println(predictionProbability);
			} catch (Exception e) {
			}
		}
	}

	public void writeArff(String outArff){
		BufferedWriter writer;
		try {
			writer = new BufferedWriter(new FileWriter(outArff));
			writer.write(labeled.toString());
			writer.close();
		} catch (IOException e) {
		}
	}
	
	public static void main(String[] args) throws Exception{
		WekaTrainTest test = new WekaTrainTest();
		test.loadModel("c:/nb.model");
		test.loadDatasets("C:\\Program Files\\Weka-3-8\\data\\iris.arff", "c:\\iris-test.arff");
		test.classify();
		test.writeArff("c:/out.arff");
	}
}
