package cz.alisma.alej.text.wrapping;
import java.util.Scanner;

public class WrapAndAlign {
    protected static int MAX_WIDTH = 30; //default width

    public static void main(String[] args) {
    	Scanner input = new Scanner(System.in);
        ParagraphDetector pd = new ParagraphDetector(input);
        Aligner aligner = new LeftAligner();
        String typeOfAlignment = ""; //default alignment is to left - not compulsory
        String widthChanger = "-w";
        String widthChangerChecker[] = new String[2];
        String widthValue = "";
        
        try {
        	typeOfAlignment = args[0];
        	widthChangerChecker[0] = args[0];
        	widthChangerChecker[1] = args[1];
        } catch (ArrayIndexOutOfBoundsException e) {
        
        }
        
        if (typeOfAlignment.equals("--justify")) {
        	aligner = new JustifyAligner();
        } if (typeOfAlignment.equals("--center")) {
        	aligner = new CenterAligner();
        } if (typeOfAlignment.equals("--right")) {
        	aligner = new RightAligner();
        } 
	    try {
	    	if (widthChangerChecker[0].equals(widthChanger)) {
	        	widthValue = args[1];
	        	int i = Integer.parseInt(widthValue);
	        	WrapAndAlign.MAX_WIDTH = i;
	        } if (widthChangerChecker[1].equals(widthChanger)) {
	        	try {
		        	widthValue = args[2];
		        	widthValue = args[2];
		        	int i = Integer.parseInt(widthValue);
		        	WrapAndAlign.MAX_WIDTH = i;
	        	} catch (ArrayIndexOutOfBoundsException e) {
	        		System.out.println("Write your requested width!\n\n");
	        		throw e;
	        	}
	    	}
	    } catch (NullPointerException e) {
	    	
	    }

        while (pd.hasNextParagraph()) {
            Paragraph para = pd.nextParagraph();
            LinePrinter line = new LinePrinter(System.out, MAX_WIDTH, aligner);
            while (para.hasNextWord()) {
                String word = para.nextWord();
                line.addWord(word);
            }
            line.flush();
            System.out.println();
        }  
    }
}
