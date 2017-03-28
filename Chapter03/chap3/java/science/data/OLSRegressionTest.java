package chap3.java.science.data;

import org.apache.commons.math3.stat.regression.OLSMultipleLinearRegression;

public class OLSRegressionTest {
	public static void main(String[] args){
		double[] y = new double[]{11.0, 12.0, 13.0, 14.0, 15.0, 16.0};
		double[][] x = new double[6][];
		x[0] = new double[]{0, 0, 0, 0, 0};
		x[1] = new double[]{2.0, 0, 0, 0, 0};
		x[2] = new double[]{0, 3.0, 0, 0, 0};
		x[3] = new double[]{0, 0, 4.0, 0, 0};
		x[4] = new double[]{0, 0, 0, 5.0, 0};
		x[5] = new double[]{0, 0, 0, 0, 6.0};   
		OLSRegressionTest test = new OLSRegressionTest();
		test.calculateOlsRegression(x, y);
	}
	public void calculateOlsRegression(double[][] x, double[] y){
		OLSMultipleLinearRegression regression = new OLSMultipleLinearRegression();
		regression.newSampleData(y, x);
		
		double[] beta = regression.estimateRegressionParameters();       
		double[] residuals = regression.estimateResiduals();
		double[][] parametersVariance = regression.estimateRegressionParametersVariance();
		double regressandVariance = regression.estimateRegressandVariance();
		double rSquared = regression.calculateRSquared();
		double sigma = regression.estimateRegressionStandardError();
	}
}
