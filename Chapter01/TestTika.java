package chap1.java.science.data;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.sax.BodyContentHandler;

public class TestTika {
     public static void main(String args[]) throws Exception {
          TestTika tika = new TestTika();
          tika.convertPdf("C:/testPDF.pdf");
     }
     public void convertPdf(String fileName){
          InputStream stream = null;
          try {
              stream = new FileInputStream(fileName);
              AutoDetectParser parser = new AutoDetectParser();
              BodyContentHandler handler = new BodyContentHandler(-1);
              Metadata metadata = new Metadata();
              parser.parse(stream, handler, metadata, new ParseContext());
              System.out.println(handler.toString());
          }catch (Exception e) {
              e.printStackTrace();
          }finally {
              if (stream != null)
                   try {
                        stream.close();
                   } catch (IOException e) {
                        System.out.println("Error closing stream");
                   }
          }
     }
}
