package chap5.java.science.data;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import net.sf.javaml.classification.Classifier;
import net.sf.javaml.classification.KNearestNeighbors;
import net.sf.javaml.classification.evaluation.CrossValidation;
import net.sf.javaml.classification.evaluation.EvaluateDataset;
import net.sf.javaml.classification.evaluation.PerformanceMeasure;
import net.sf.javaml.clustering.Clusterer;
import net.sf.javaml.clustering.KMeans;
import net.sf.javaml.clustering.evaluation.ClusterEvaluation;
import net.sf.javaml.clustering.evaluation.SumOfSquaredErrors;
import net.sf.javaml.core.Dataset;
import net.sf.javaml.distance.PearsonCorrelationCoefficient;
import net.sf.javaml.featureselection.ranking.RecursiveFeatureEliminationSVM;
import net.sf.javaml.featureselection.scoring.GainRatio;
import net.sf.javaml.featureselection.subset.GreedyForwardSelection;
import net.sf.javaml.tools.data.FileHandler;

public class JavaMachineLearning {
	public static void main(String[] args) throws IOException{
		Dataset data = FileHandler.loadDataset(new File("datasets/UCI-small/iris/iris.data"), 4, ",");
		System.out.println(data);
		FileHandler.exportDataset(data, new File("c:/javaml-output.txt"));
		data = FileHandler.loadDataset(new File("c:/javaml-output.txt"), 0,"\t");
		System.out.println(data);
		
		//Clustering
		Clusterer km = new KMeans();
		Dataset[] clusters = km.cluster(data);
		for(Dataset cluster:clusters){
			System.out.println("Cluster: " + cluster);
		}
		ClusterEvaluation sse= new SumOfSquaredErrors();
		double score = sse.score(clusters);
		System.out.println(score);
		
		//Classification
		Classifier knn = new KNearestNeighbors(5);
		knn.buildClassifier(data);
		//Cross validation
		CrossValidation cv = new CrossValidation(knn);
		Map<Object, PerformanceMeasure> cvEvaluation = cv.crossValidation(data);
		System.out.println(cvEvaluation + "---------");
		//Held-out testing
		Dataset testData = FileHandler.loadDataset(new File("datasets/UCI-small/iris/iris.data"), 4, ",");
		Map<Object, PerformanceMeasure> testEvaluation =
				EvaluateDataset.testDataset(knn, testData);
		for(Object classVariable:testEvaluation.keySet()){
			System.out.println(classVariable + " class has "+testEvaluation.get(classVariable).getAccuracy());
		}
		
		//Feature scoring
		GainRatio gainRatio = new GainRatio();
		gainRatio.build(data);
		for (int i = 0; i < gainRatio.noAttributes(); i++){
			System.out.println(gainRatio.score(i));
		}
		
		//Feature ranking
		RecursiveFeatureEliminationSVM featureRank = new RecursiveFeatureEliminationSVM(0.2);
		featureRank.build(data);
		for (int i = 0; i < featureRank.noAttributes(); i++){
			System.out.println(featureRank.rank(i));
		}
		
		//Feature subset selection
		GreedyForwardSelection featureSelection = new GreedyForwardSelection(5, new PearsonCorrelationCoefficient());
		featureSelection.build(data);
		System.out.println(featureSelection.selectedAttributes());
	}
}
