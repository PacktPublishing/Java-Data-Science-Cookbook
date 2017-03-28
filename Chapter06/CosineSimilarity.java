package chap6.java.science.data;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CosineSimilarity {
	public double calculateCosine(String s1, String s2){
		//tokenization in parallel with Java 8
		Stream<String> stream1 = Stream.of(s1.toLowerCase().split("\\W+")).parallel();
		Stream<String> stream2 = Stream.of(s2.toLowerCase().split("\\W+")).parallel();
		
		//word frequency maps for two strings
		Map<String, Long> wordFreq1 = stream1
		     .collect(Collectors.groupingBy(String::toString,Collectors.counting()));
		Map<String, Long> wordFreq2 = stream2
			     .collect(Collectors.groupingBy(String::toString,Collectors.counting()));
		
		//unique words for each string
		Set<String> wordSet1 = wordFreq1.keySet();
		Set<String> wordSet2 = wordFreq2.keySet();
		
		//common words of two strings
		Set<String> intersection = new HashSet<String>(wordSet1);
		intersection.retainAll(wordSet2);
		
		//numerator of cosine formula. s1.s2
		double numerator = 0;
		for (String common: intersection){
			numerator += wordFreq1.get(common) * wordFreq2.get(common);
		}
		
		//denominator of cosine formula has two parameters
		double param1 = 0, param2 = 0;
		
		//sqrt (sum of squared of s1 word frequencies)
		for(String w1: wordSet1){
			param1 += Math.pow(wordFreq1.get(w1), 2);
		}
		param1 = Math.sqrt(param1);
		
		//sqrt (sum of squared of s2 word frequencies)
		for(String w2: wordSet2){
			param2 += Math.pow(wordFreq2.get(w2), 2);
		}
		param2 = Math.sqrt(param2);
		
		//denominator of cosine formula. sqrt(sum(s1^2)) X sqrt(sum(s2^2))
		double denominator = param1 * param2;
		
		//cosine measure
		double cosineSimilarity = numerator/denominator;
		return cosineSimilarity;
	}//end method to calculate cosine similarity of two strings
	
	public static void main(String[] args){
		CosineSimilarity cos = new CosineSimilarity();
		System.out.println(cos.calculateCosine("To be, or not to be: that is the question.", "Frailty, thy name is woman!"));
		System.out.println(cos.calculateCosine("The lady doth protest too much, methinks.", "Frailty, thy name is woman!"));
	}
}
