package chap1.java.science.data;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import com.univocity.parsers.tsv.TsvParser;
import com.univocity.parsers.tsv.TsvParserSettings;

public class TestTsv {
	public void parseTsv(String fileName){
		TsvParserSettings settings = new TsvParserSettings();
	    settings.getFormat().setLineSeparator("\n");
		    TsvParser parser = new TsvParser(settings);
	    List<String[]> allRows = parser.parseAll(new File(fileName));
	    for (int i = 0; i < allRows.size(); i++){
	    	System.out.println(Arrays.asList(allRows.get(i)));
	    }
	}
}
