package chap4.java.science.data;

import weka.classifiers.functions.Logistic;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class WekaLogisticRegressionTest {
	Instances iris = null;
	Logistic logReg ;

	public void loadArff(String arffInput){
		DataSource source = null;
		try {
			source = new DataSource(arffInput);
			iris = source.getDataSet();
			iris.setClassIndex(iris.numAttributes() - 1);
		} catch (Exception e1) {
		}
	}

	public void buildRegression(){	
		logReg = new Logistic();

		try {
			logReg.buildClassifier(iris);
		} catch (Exception e) {
		} 
		System.out.println(logReg);
	}

	public static void main(String[] args) throws Exception{
		WekaLogisticRegressionTest test = new WekaLogisticRegressionTest();
		test.loadArff("C:\\Program Files\\Weka-3-6\\data\\iris.arff");
		test.buildRegression();
	}
}
