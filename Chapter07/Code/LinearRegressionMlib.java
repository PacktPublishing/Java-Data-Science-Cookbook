package com.data.big.mlib;

import scala.Tuple2;

import org.apache.spark.api.java.*;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.mllib.linalg.Vectors;
import org.apache.spark.mllib.regression.LabeledPoint;
import org.apache.spark.mllib.regression.LinearRegressionModel;
import org.apache.spark.mllib.regression.LinearRegressionWithSGD;
import org.apache.spark.SparkConf;

public class LinearRegressionMlib {

	public static void main(String[] args) {
		SparkConf configuration = new SparkConf().setMaster("local[4]").setAppName("Linear Regression Example");
		JavaSparkContext sparkContext = new JavaSparkContext(configuration);

		// Load and parse the data
		String inputData = "data/lr-data.txt";
		JavaRDD<String> data = sparkContext.textFile(inputData);
		JavaRDD<LabeledPoint> parsedData = data.map(
				new Function<String, LabeledPoint>() {
					public LabeledPoint call(String line) {
						String[] parts = line.split(",");
						String[] features = parts[1].split(" ");
						double[] featureVector = new double[features.length];
						for (int i = 0; i < features.length - 1; i++){
							featureVector[i] = Double.parseDouble(features[i]);
						}
						return new LabeledPoint(Double.parseDouble(parts[0]), Vectors.dense(featureVector));
					}
				}
		);
		parsedData.cache();

		// Building the model
		int numIterations = 100;
		final LinearRegressionModel model = 
				LinearRegressionWithSGD.train(JavaRDD.toRDD(parsedData), numIterations);

		// Evaluate model on training examples and compute training error
		JavaRDD<Tuple2<Double, Double>> valuesAndPreds = parsedData.map(
				new Function<LabeledPoint, Tuple2<Double, Double>>() {
					public Tuple2<Double, Double> call(LabeledPoint point) {
						double prediction = model.predict(point.features());
						return new Tuple2<Double, Double>(prediction, point.label());
					}
				}
		);
		double MSE = new JavaDoubleRDD(valuesAndPreds.map(
				new Function<Tuple2<Double, Double>, Object>() {
					public Object call(Tuple2<Double, Double> pair) {
						return Math.pow(pair._1() - pair._2(), 2.0);
					}
				}
		).rdd()).mean();
		System.out.println("training Mean Squared Error = " + MSE);
	}
}