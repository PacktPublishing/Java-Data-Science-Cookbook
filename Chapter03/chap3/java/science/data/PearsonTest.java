package chap3.java.science.data;

import org.apache.commons.math3.stat.correlation.PearsonsCorrelation;

public class PearsonTest {
	public static void main(String[] args){
		double[] x = {43, 21, 25, 42, 57, 59};
		double[] y = {99, 65, 79, 75, 87, 81};
		PearsonTest test = new PearsonTest();
		test.calculatePearson(x, y);
	}
	public void calculatePearson(double[] x, double[] y){
		PearsonsCorrelation pCorrelation = new PearsonsCorrelation();
		double cor = pCorrelation.correlation(x, y);//take out false too
		System.out.println(cor);
	}
}
