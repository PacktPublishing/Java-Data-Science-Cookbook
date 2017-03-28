package chap3.java.science.data;

import org.apache.commons.math3.stat.descriptive.AggregateSummaryStatistics;
import org.apache.commons.math3.stat.descriptive.SummaryStatistics;

public class AggregateStats {
	public static void main(String[] args){
		double[] values1 = {32, 39, 14, 98, 45, 44, 45};
		double[] values2 = {34, 89, 67, 0, 15, 0, 56, 88};
		AggregateStats aggStatTest = new AggregateStats();
		aggStatTest.getAggregateStats(values1, values2);
	}
	public void getAggregateStats(double[] values1, double[] values2){
		AggregateSummaryStatistics aggregate = new AggregateSummaryStatistics();
		SummaryStatistics firstSet = aggregate.createContributingStatistics();
		SummaryStatistics secondSet = aggregate.createContributingStatistics();
		
		for(int i = 0; i < values1.length; i++) {
			firstSet.addValue(values1[i]);
		}
		for(int i = 0; i < values2.length; i++) {
			secondSet.addValue(values2[i]);
		}
		
		double sampleSum = aggregate.getSum();
		double sampleMean = aggregate.getMean();
		double sampleStd= aggregate.getStandardDeviation();
		System.out.println(sampleSum + "\t" + sampleMean + "\t" + sampleStd);
	}
}
