package chap1.java.science.data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class TextFileReadJava {
	public static void main(String[] args){
		TextFileReadJava test = new TextFileReadJava();
		test.readTextFile("C:/dummy.txt");
	}
	public void readTextFile(String file){
		try (Stream<String> stream = Files.lines(Paths.get(file))) {
			stream.forEach(System.out::println);
		} catch (IOException e) {
			//Your exception handling here
		}

	}
}
