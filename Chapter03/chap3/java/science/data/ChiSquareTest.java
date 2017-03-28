package chap3.java.science.data;

import org.apache.commons.math3.stat.inference.TestUtils;

public class ChiSquareTest {
	public static void main(String[] args){
		long[] observed = {43, 21, 25, 42, 57, 59};
		double[] expected = {99, 65, 79, 75, 87, 81};
		ChiSquareTest test = new ChiSquareTest();
		test.getChiSquare(observed, expected);
	}
	public void getChiSquare(long[] observed, double[] expected){
		System.out.println(TestUtils.chiSquare(expected, observed));//t statistics
		System.out.println(TestUtils.chiSquareTest(expected, observed));//p value
		System.out.println(TestUtils.chiSquareTest(expected, observed, 0.05));
	}
}
