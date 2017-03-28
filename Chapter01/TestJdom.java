package chap1.java.science.data;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class TestJdom {

	public static void main(String[] args){
		TestJdom test = new TestJdom();
		test.parseXml("C:/dummyxml.com");

	}
	public void parseXml(String fileName){
		SAXBuilder builder = new SAXBuilder();
		File file = new File(fileName);
		try {
			Document document = (Document) builder.build(file);
			Element rootNode = document.getRootElement();
			List list = rootNode.getChildren("author");
			for (int i = 0; i < list.size(); i++) {
				Element node = (Element) list.get(i);
				System.out.println("First Name : " + node.getChildText("firstname"));
				System.out.println("Last Name : " + node.getChildText("lastname"));
			}
		} catch (IOException io) {
			System.out.println(io.getMessage());
		} catch (JDOMException jdomex) {
			System.out.println(jdomex.getMessage());
		}



	}

}
