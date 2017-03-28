package chap6.java.science.data;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;

public class OpenNlpSenToken {
	public static void main(String[] args){
		OpenNlpSenToken openNlp = new OpenNlpSenToken();
		try {
			openNlp.useOpenNlp("My name is Rushdi Shams. "
					+ "You can use Dr. before my name as I have a Ph.D. "
					+ "but I am a bit shy to use it.", "opennlp-models/en-sent.bin", "sentence");
			openNlp.useOpenNlp("\"Let's get this vis-a-vis\", he said, \"these boys' marks are really that well?\"", "opennlp-models/en-token.bin", "word");
		} catch (IOException e) {
		}
	}
	public void useOpenNlp(String sourceText, String modelPath, String choice) throws IOException{
		InputStream modelIn = null;
		modelIn = new FileInputStream(modelPath);

		if(choice.equalsIgnoreCase("sentence")){
			SentenceModel model = new SentenceModel(modelIn);
			modelIn.close();
			SentenceDetectorME sentenceDetector = new SentenceDetectorME(model);
			String sentences[] = sentenceDetector.sentDetect(sourceText);
			System.out.println("Sentences: ");
			for(String sentence:sentences){
				System.out.println(sentence);
			}
		}
		else if(choice.equalsIgnoreCase("word")){
			TokenizerModel model = new TokenizerModel(modelIn);
			modelIn.close();
			Tokenizer tokenizer = new TokenizerME(model);
			String tokens[] = tokenizer.tokenize(sourceText);
			System.out.println("Words: ");
			for(String token:tokens){
				System.out.println(token);
			}
		}
		else{
			System.out.println("Error in choice");
			modelIn.close();
			return;
		}
	}
}
