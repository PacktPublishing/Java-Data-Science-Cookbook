package chap1.java.science.data;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class TextFileReadApache {
	public static void main(String[] args){
		TextFileReadApache test = new TextFileReadApache();
		test.readFile("C:/dummy.txt");

	}
	public void readFile(String fileName){
		File file = new File(fileName);
		String text = "";
		try {
			text = FileUtils.readFileToString(file, "UTF-8");
		} catch (IOException e) {
			System.out.println("Error reading " + file.getAbsolutePath());
		}
		//process text
	}
}
