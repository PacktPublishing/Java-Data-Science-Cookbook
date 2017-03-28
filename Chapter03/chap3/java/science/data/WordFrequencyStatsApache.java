package chap3.java.science.data;

import org.apache.commons.math3.stat.Frequency;

public class WordFrequencyStatsApache {
	public static void main(String[] args){
		String str = "Horatio says 'tis but our fantasy, "
				+ "And will not let belief take hold of him "
				+ "Touching this dreaded sight, twice seen of us. "
				+ "Therefore I have entreated him along, 35"
				+ "With us to watch the minutes of this night, "
				+ "That, if again this apparition come, "
				+ "He may approve our eyes and speak to it.";
		String[] words = str.toLowerCase().split("\\W+");
		WordFrequencyStatsApache freqTest = new WordFrequencyStatsApache();
		freqTest.getFreqStats(words);

	}
	public void getFreqStats(String[] words){
		Frequency freq = new Frequency();
		for( int i = 0; i < words.length; i++) {
			freq.addValue(words[i].trim());
		}

		for( int i = 0; i < words.length; i++) {
			System.out.println(words[i] + "=" + freq.getCount(words[i]));
		}
	}
}
