package chap3.java.science.data;

import org.apache.commons.math3.stat.inference.TestUtils;

public class TTest {
	public static void main(String[] args){
		double[] sample1 = {43, 21, 25, 42, 57, 59};
		double[] sample2 = {99, 65, 79, 75, 87, 81};
		TTest test = new TTest();
		test.getTtest(sample1, sample2);
	}
	public void getTtest(double[] sample1, double[] sample2){
		System.out.println(TestUtils.pairedT(sample1, sample2));//t statistics
		System.out.println(TestUtils.pairedTTest(sample1, sample2));//p value
		System.out.println(TestUtils.pairedTTest(sample1, sample2, 0.05));
	}
}
