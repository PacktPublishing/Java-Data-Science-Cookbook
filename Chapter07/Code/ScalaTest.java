package com.data.big.mlib;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;


public class ScalaTest {
	public static void main( String[] args ){
		String inputFile = "data/dummy.txt";
		SparkConf configuration = new SparkConf().setMaster("local[4]").setAppName("My App");
		JavaSparkContext sparkContext = new JavaSparkContext(configuration);
		JavaRDD<String> logData = sparkContext.textFile(inputFile).cache();

		long numberA = logData.filter(new Function<String,Boolean>(){
			private static final long serialVersionUID = 1L;
			public Boolean call(String s){
				return s.length() == 0;
			}
		}).count();
		sparkContext.close();
		System.out.println("Empty Lines: " + numberA);
	}
}
