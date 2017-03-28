package chap3.java.science.data;

import org.apache.commons.math3.stat.regression.SimpleRegression;

public class RegressionTest {
	
	public static void main(String[] args){
		double[][] data = { { 1, 3 }, {2, 5 }, {3, 7 }, {4, 14 }, {5, 11 }};
		RegressionTest test = new RegressionTest();
		test.calculateRegression(data);
	}
	public void calculateRegression(double[][] data){
		SimpleRegression regression = new SimpleRegression();
		regression.addData(data);
		System.out.println(regression.getIntercept());
		System.out.println(regression.getSlope());
		System.out.println(regression.getSlopeStdErr());
	}
}
