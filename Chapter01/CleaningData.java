package chap1.java.science.data;

public class CleaningData {
	public static void main(String[] args) throws Exception {
		CleaningData clean = new CleaningData();
		String text = "Your text here you have got from some file";
		String cleanedText = clean.cleanText(text);
		//Process cleanedText
	}

	public String cleanText(String text){
		text = text.replaceAll("[^\\p{ASCII}]","");
		text = text.replaceAll("\\s+", " "); 
		text = text.replaceAll("\\p{Cntrl}", ""); 
		text = text.replaceAll("[^\\p{Print}]", "");
		text = text.replaceAll("\\p{C}", "");
		return text;
	}
}
