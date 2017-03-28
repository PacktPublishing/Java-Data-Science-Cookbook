package chap3.java.science.data;

import org.apache.commons.math3.stat.inference.TestUtils;

public class KSTest {
	public static void main(String[] args){
		double[] x = {43, 21, 25, 42, 57, 59};
		double[] y = {99, 65, 79, 75, 87, 81};
		KSTest test = new KSTest();
		test.calculateKs(x, y);
	}
	public void calculateKs(double[] x, double[] y){
		double d = TestUtils.kolmogorovSmirnovStatistic(x, y);
		System.out.println(TestUtils.kolmogorovSmirnovTest(x, y, false));
		System.out.println(TestUtils.exactP(d, x.length, y.length, false));
	}
}
