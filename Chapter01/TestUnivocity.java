package chap1.java.science.data;


import java.io.File;
import java.util.Arrays;
import java.util.List;

import com.univocity.parsers.common.processor.RowListProcessor;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;

public class TestUnivocity {
		public void parseCSV(String fileName){
		    CsvParserSettings parserSettings = new CsvParserSettings();
		    parserSettings.setLineSeparatorDetectionEnabled(true);
		    RowListProcessor rowProcessor = new RowListProcessor();
		   parserSettings.setRowProcessor(rowProcessor);
		    parserSettings.setHeaderExtractionEnabled(true);
		    CsvParser parser = new CsvParser(parserSettings);
		    parser.parse(new File(fileName));

		    String[] headers = rowProcessor.getHeaders();
		    List<String[]> rows = rowProcessor.getRows();
		    for (int i = 0; i < rows.size(); i++){
		    	System.out.println(Arrays.asList(rows.get(i)));
		    }
		}
		
		public static void main(String[] args){
			TestUnivocity test = new TestUnivocity();
			test.parseCSV("C:/testCSV.csv");
		}
}
