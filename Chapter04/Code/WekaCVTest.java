package chap4.java.science.data;

import java.util.Random;

import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class WekaCVTest {
	Instances iris = null;
	NaiveBayes nb;

	public void loadArff(String arffInput){
		DataSource source = null;
		try {
			source = new DataSource(arffInput);
			iris = source.getDataSet();
			if (iris.classIndex() == -1)
				iris.setClassIndex(iris.numAttributes() - 1);
		} catch (Exception e1) {
		}
	}

	public void generateModel(){
		nb = new NaiveBayes();
		try {
			nb.buildClassifier(iris);
		} catch (Exception e) {

		}
	}

	public void saveModel(String modelPath){
		try {
			weka.core.SerializationHelper.write(modelPath, nb);
		} catch (Exception e) {
		}
	}

	public void crossValidate(){
		Evaluation eval = null;
		try {
			eval = new Evaluation(iris);
			eval.crossValidateModel(nb, iris, 10, new Random(1));
			System.out.println(eval.toSummaryString());
		} catch (Exception e1) {
		}	
	}
	
	public static void main(String[] args){
		WekaCVTest test = new WekaCVTest();
		test.loadArff("C:/Program Files/Weka-3-6/data/iris.arff");
		test.generateModel();
		test.saveModel("c:/nb.model");
		test.crossValidate();
	}
}
