package chap3.java.science.data;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordFrequencyStatsJava {
	public static void main(String[] args){
		String str = "Horatio says 'tis but our fantasy, "
				+ "And will not let belief take hold of him "
				+ "Touching this dreaded sight, twice seen of us. "
				+ "Therefore I have entreated him along, 35"
				+ "With us to watch the minutes of this night, "
				+ "That, if again this apparition come, "
				+ "He may approve our eyes and speak to it.";
		
		WordFrequencyStatsJava freqTest = new WordFrequencyStatsJava();
		freqTest.getFreqStats(str);
	}
	public void getFreqStats(String str){
		Stream<String> stream = Stream.of(str.toLowerCase().split("\\W+")).parallel();
		Map<String, Long> wordFreq = stream
				.collect(Collectors.groupingBy(String::toString,Collectors.counting()));
		wordFreq.forEach((k,v)->System.out.println(k + "=" + v));
	}
}
