import mulan.classifier.lazy.MLkNN;
import mulan.classifier.meta.RAkEL;
import mulan.classifier.transformation.LabelPowerset;
import mulan.data.InvalidDataFormatException;
import mulan.data.MultiLabelInstances;
import mulan.evaluation.Evaluator;
import mulan.evaluation.MultipleEvaluation;
import weka.classifiers.trees.J48;

public class Mulan {
	public static void main(String[] args){
		MultiLabelInstances dataset = null;
		try {
			dataset = new MultiLabelInstances("F:\\mulan-1.5.0\\mulan\\data\\emotions.arff", "F:\\mulan-1.5.0\\mulan\\data\\emotions.xml");
		} catch (InvalidDataFormatException e) {
		}
		RAkEL learner1 = new RAkEL(new LabelPowerset(new J48()));
		MLkNN learner2 = new MLkNN(); 
		Evaluator eval = new Evaluator();
		MultipleEvaluation results;
		int numFolds = 10;
		results = eval.crossValidate(learner1, dataset, numFolds);
		System.out.println(results);
		results = eval.crossValidate(learner2, dataset, numFolds);
		System.out.println(results);
	}
}
