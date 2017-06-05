package cz.alisma.alej.text.wrapping;
import java.util.ArrayList;
import java.util.List;

public class JustifyAligner implements Aligner {
	
	@Override
	public String format(List<String> words) {
		StringBuilder result = new StringBuilder();
	
		int realWidth = 0;
		double spaceWidth = 0;
		double remainder = 0;
		int counter = 0;			
		double multiplication = 0; 	// <-- how many spaces wasted...
		int moreSpaceIndex = 0;		//...(I can't write 1.5 spaces, therefore I have wasted 0.5 spaces)
		for (String w : words) {
			realWidth += w.length();	
		}
		if (words.size() == 1) {
			spaceWidth = (double) (WrapAndAlign.MAX_WIDTH - realWidth) / words.size();
		} else {
			spaceWidth = (double) (WrapAndAlign.MAX_WIDTH - realWidth) / (words.size() - 1);
		}
		remainder = (double) (spaceWidth % 1);
		multiplication = (double) remainder * (words.size() - 1);	//how many spaces I have to add?
		moreSpaceIndex = (int) Math.round(multiplication);	//same value as multiplication

		List<String> space = new ArrayList<String>();
		for (int i = 0; i < (int) spaceWidth; i++) {		//how many spaces between words
			space.add(" ");	
		}

		boolean first = true;
		
        for (String w : words) {
        	if (!first) {
        		for (String s : space) {
        			result.append(s);
        		}
            } else {
                first = false;
            }
            result.append(w);
            counter += 1;
            if (counter >= words.size() - moreSpaceIndex) {
            	result.append(" ");
            }
        }
        
        return result.toString();
	}
}
