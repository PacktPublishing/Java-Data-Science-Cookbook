package chap3.java.science.data;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

public class DescriptiveStats {
	public static void main(String[] args){
		double[] values = {32, 39, 14, 98, 45, 44, 45, 34, 89, 67, 0, 15, 0, 56, 88};
		DescriptiveStats descStatTest = new DescriptiveStats();
		descStatTest.getDescStats(values);
		
	}
	public void getDescStats(double[] values){
		DescriptiveStatistics stats = new DescriptiveStatistics();
		for( int i = 0; i < values.length; i++) {
		        stats.addValue(values[i]);
		}
		double mean = stats.getMean();
		double std = stats.getStandardDeviation();
		double median = stats.getPercentile(50);
		System.out.println(mean + "\t" + std + "\t" + median);
	}
}
