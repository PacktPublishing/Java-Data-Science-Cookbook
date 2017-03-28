package chap3.java.science.data;

import org.apache.commons.math3.stat.descriptive.SummaryStatistics;

public class SummaryStats {
	public static void main(String[] args){
		double[] values = {32, 39, 14, 98, 45, 44, 45, 34, 89, 67, 0, 15, 0, 56, 88};
		SummaryStats summaryStatTest = new SummaryStats();
		summaryStatTest.getSummaryStats(values);
	}
	public void getSummaryStats(double[] values){
		SummaryStatistics stats = new SummaryStatistics();
		for( int i = 0; i < values.length; i++) {
		        stats.addValue(values[i]);
		}
		double mean = stats.getMean();
		double std = stats.getStandardDeviation();
		System.out.println(mean + "\t" + std);
	}
}
