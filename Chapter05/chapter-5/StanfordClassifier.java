package chap5.java.science.data;

import edu.stanford.nlp.classify.Classifier;
import edu.stanford.nlp.classify.ColumnDataClassifier;
import edu.stanford.nlp.ling.Datum;
import edu.stanford.nlp.objectbank.ObjectBank;

public class StanfordClassifier {
  public static void main(String[] args) throws Exception {
    ColumnDataClassifier columnDataClassifier = new ColumnDataClassifier("examples/cheese2007.prop");
    Classifier<String,String> classifier =
        columnDataClassifier.makeClassifier(columnDataClassifier.readTrainingExamples("examples/cheeseDisease.train"));
    for (String line : ObjectBank.getLineIterator("examples/cheeseDisease.test", "utf-8")) {
      Datum<String,String> d = columnDataClassifier.makeDatumFromLine(line);
      System.out.println(line + "  ==>  " + classifier.classOf(d));
    }
  }
}

