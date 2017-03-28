package chap1.java.science.data;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonReading {
	public static void main(String[] args){
		JsonReading jsonReading = new JsonReading();
		jsonReading.readJson("C:/testJSON.json");
	}
	public void readJson(String inFileName) {
		JSONParser parser = new JSONParser();
		try {
			Object obj = parser.parse(new FileReader(inFileName));
			JSONObject jsonObject = (JSONObject) obj;

			String name = (String) jsonObject.get("book");
			System.out.println(name);

			String author = (String) jsonObject.get("author");
			System.out.println(author);

			JSONArray reviews = (JSONArray) jsonObject.get("messages");
			Iterator<String> iterator = reviews.iterator();
			while (iterator.hasNext()) {
				System.out.println(iterator.next());
			}
		} catch (FileNotFoundException e) {
			//Your exception handling here
		} catch (IOException e) {
			//Your exception handling here
		} catch (ParseException e) {
			//Your exception handling here
		}
	}
}

