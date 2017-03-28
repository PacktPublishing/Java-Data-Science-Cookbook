package chap4.java.science.data;

import weka.classifiers.functions.LinearRegression;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class WekaLinearRegressionTest {
	Instances cpu = null;
	LinearRegression lReg ;

	public void loadArff(String arffInput){
		DataSource source = null;
		try {
			source = new DataSource(arffInput);
			cpu = source.getDataSet();
			cpu.setClassIndex(cpu.numAttributes() - 1);
		} catch (Exception e1) {
		}
	}

	public void buildRegression(){	
		lReg = new LinearRegression();
		try {
			lReg.buildClassifier(cpu);
		} catch (Exception e) {
		} 
		System.out.println(lReg);
	}

	public static void main(String[] args) throws Exception{
		WekaLinearRegressionTest test = new WekaLinearRegressionTest();
		test.loadArff("C:\\Program Files\\Weka-3-6\\data\\cpu.arff");
		test.buildRegression();
	}
}
