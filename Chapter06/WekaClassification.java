package chap6.java.science.data;

import weka.core.*;
import weka.core.converters.*;
import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.filters.*;
import weka.filters.unsupervised.attribute.*;

import java.io.*;
import java.util.Random;

public class WekaClassification {
	public static void main(String[] args) throws Exception {
		TextDirectoryLoader loader = new TextDirectoryLoader();
		loader.setDirectory(new File("C:/text_example"));
		Instances data = loader.getDataSet();

		StringToWordVector filter = new StringToWordVector();
		filter.setInputFormat(data);
		Instances dataFiltered = Filter.useFilter(data, filter);

		NaiveBayes nb = new NaiveBayes();
		nb.buildClassifier(dataFiltered);
		System.out.println("\n\nClassifier model:\n\n" + nb);

		Evaluation eval = null;
		eval = new Evaluation(dataFiltered);
		eval.crossValidateModel(nb, dataFiltered, 5, new Random(1));
		System.out.println(eval.toSummaryString());
	}
}