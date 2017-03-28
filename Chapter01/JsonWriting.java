package chap1.java.science.data;

import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JsonWriting {

	public static void main(String[] args) {
		JsonWriting jsonWriting = new JsonWriting();
		jsonWriting.writeJson("C:/testJSON.json");
	}

	public void writeJson(String outFileName){
		JSONObject obj = new JSONObject();
		obj.put("book", "Harry Potter and the Philosopher's Stone");
		obj.put("author", "J. K. Rowling");

		JSONArray list = new JSONArray();
		list.add("There are characters in this book that will remind us of all the people we have met. Everybody knows or knew a spoilt, overweight boy like Dudley or a bossy and interfering (yet kind-hearted) girl like Hermione");
		list.add("Hogwarts is a truly magical place, not only in the most obvious way but also in all the detail that the author has gone to describe it so vibrantly.");
		list.add("Parents need to know that this thrill-a-minute story, the first in the Harry Potter series, respects kids' intelligence and motivates them to tackle its greater length and complexity, play imaginative games, and try to solve its logic puzzles. ");

		obj.put("messages", list);

		try {

			FileWriter file = new FileWriter(outFileName);
			file.write(obj.toJSONString());
			file.flush();
			file.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.print(obj);
	}
}
