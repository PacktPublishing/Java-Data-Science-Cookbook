package chap6.java.science.data;

import edu.stanford.nlp.ling.CoreAnnotations.LemmaAnnotation; 
import edu.stanford.nlp.ling.CoreAnnotations.SentencesAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TextAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TokensAnnotation; 
import edu.stanford.nlp.ling.CoreLabel; 
import edu.stanford.nlp.pipeline.Annotation; 
import edu.stanford.nlp.pipeline.StanfordCoreNLP; 
import edu.stanford.nlp.util.CoreMap; 
import java.util.ArrayList; 
import java.util.List; 
import java.util.Properties; 
/**
 * Class to perform lemmatization using Stanford Core NLP 
 * @author Themistoklis Mavridis 
 */ 
public class Lemmatizer { 
     
     
    public static void main(String[] args)
    {
    	StanfordCoreNLP pipeline; 
        Properties props = new Properties(); 
        props.put("annotators", "tokenize, ssplit, pos, lemma"); 
        pipeline = new StanfordCoreNLP(props, false);
        String text = "This is a test string"; 
        Annotation document = pipeline.process(text);  

        for(CoreMap sentence: document.get(SentencesAnnotation.class))
        {    
            for(CoreLabel token: sentence.get(TokensAnnotation.class))
            {       
                String word = token.get(TextAnnotation.class);      
                String lemma = token.get(LemmaAnnotation.class); 
                System.out.println("lemmatized version :" + lemma);
            }
        }
    }
}