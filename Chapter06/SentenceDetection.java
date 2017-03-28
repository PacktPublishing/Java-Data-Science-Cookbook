package chap6.java.science.data;

import java.text.BreakIterator;
import java.util.Locale;

public class SentenceDetection {
	public void useSentenceIterator(String source){
		BreakIterator iterator = BreakIterator.getSentenceInstance(Locale.US);
		iterator.setText(source);
		int start = iterator.first();
		for (int end = iterator.next();
		    end != BreakIterator.DONE;
		    start = end, end = iterator.next()) {
		  System.out.println(source.substring(start,end));
		}
	}
	public static void main(String[] args){
		SentenceDetection detection = new SentenceDetection();
		String test = "My name is Rushdi Shams. You can use Dr. before my name as I have a Ph.D. but I am a bit shy to use it.";
		detection.useSentenceIterator(test);
	}
}

