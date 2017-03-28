package chap3.java.science.data;

import org.apache.commons.math3.stat.correlation.Covariance;

public class CovarianceTest {
	public static void main(String[] args){
		double[] x = {43, 21, 25, 42, 57, 59};
		double[] y = {99, 65, 79, 75, 87, 81};
		CovarianceTest test = new CovarianceTest();
		test.calculateCov(x, y);
	}
	public void calculateCov(double[] x, double[] y){
		double covariance = new Covariance().covariance(x, y, false);//take out false too
		System.out.println(covariance);
	}
}
