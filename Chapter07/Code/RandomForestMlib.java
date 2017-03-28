package com.data.big.mlib;

import scala.Tuple2;
import java.util.HashMap;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.mllib.regression.LabeledPoint;
import org.apache.spark.mllib.tree.RandomForest;
import org.apache.spark.mllib.tree.model.RandomForestModel;
import org.apache.spark.mllib.util.MLUtils;

public class RandomForestMlib {
	public static void main(String args[]){

		SparkConf configuration = new SparkConf().setMaster("local[4]").setAppName("Any");
		JavaSparkContext sc = new JavaSparkContext(configuration);

		// Load and parse the data file.
		String input = "data/rf-data.txt";
		JavaRDD<LabeledPoint> data = MLUtils.loadLibSVMFile(sc.sc(), input).toJavaRDD();
		// Split the data into training and test sets (30% held out for testing)
		JavaRDD<LabeledPoint>[] dataSplits = data.randomSplit(new double[]{0.7, 0.3});
		JavaRDD<LabeledPoint> trainingData = dataSplits[0];
		JavaRDD<LabeledPoint> testData = dataSplits[1];

		// Train a RandomForest model.
		Integer numClasses = 2;
		HashMap<Integer, Integer> categoricalFeaturesInfo = new HashMap<Integer, Integer>();//  Empty categoricalFeaturesInfo indicates all features are continuous.
		Integer numTrees = 3; // Use more in practice.
		String featureSubsetStrategy = "auto"; // Let the algorithm choose.
		String impurity = "gini";
		Integer maxDepth = 5;
		Integer maxBins = 32;
		Integer seed = 12345;

		final RandomForestModel rfModel = RandomForest.trainClassifier(trainingData, numClasses,
				categoricalFeaturesInfo, numTrees, featureSubsetStrategy, impurity, maxDepth, maxBins,
				seed);

		// Evaluate model on test instances and compute test error
		JavaPairRDD<Double, Double> label =
				testData.mapToPair(new PairFunction<LabeledPoint, Double, Double>() {
					public Tuple2<Double, Double> call(LabeledPoint p) {
						return new Tuple2<Double, Double>(rfModel.predict(p.features()), p.label());
					}
				});

		Double testError =
				1.0 * label.filter(new Function<Tuple2<Double, Double>, Boolean>() {
					public Boolean call(Tuple2<Double, Double> pl) {
						return !pl._1().equals(pl._2());
					}
				}).count() / testData.count();

		System.out.println("Test Error: " + testError);
		System.out.println("Learned classification forest model:\n" + rfModel.toDebugString());
	}
}