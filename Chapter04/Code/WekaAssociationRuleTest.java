package chap4.java.science.data;

import weka.associations.Apriori;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class WekaAssociationRuleTest {
	Instances superMarket = null;
	Apriori apriori;
	public void loadArff(String arffInput){
		DataSource source = null;
		try {
			source = new DataSource(arffInput);
			superMarket = source.getDataSet();
		} catch (Exception e1) {
		}
	}
	public void generateRule(){
		apriori = new Apriori();
		try {
//			apriori.setNumRules(20);
			apriori.buildAssociations(superMarket);
			System.out.println(apriori);
		} catch (Exception e) {
		}
	}
	public static void main(String args[]){
		WekaAssociationRuleTest test = new WekaAssociationRuleTest();
		test.loadArff("C:\\Program Files\\Weka-3-6\\data\\supermarket.arff");
		test.generateRule();
	}
}