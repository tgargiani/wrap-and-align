package cz.alisma.alej.text.wrapping;
import java.util.List;

public class RightAligner implements Aligner {
	
	@Override
	public String format(List<String> words) {
		StringBuilder result = new StringBuilder();
        
		int realWidth = 0;
		for (String w : words) {
			realWidth += w.length();	
		}
		realWidth += words.size() - 1;
		
		for (int i = realWidth; i < WrapAndAlign.MAX_WIDTH; i++) {
			System.out.print(" ");
		}
		
		boolean first = true;
        for (String w : words) {
            if (!first) {
                result.append(" ");
            } else {
                first = false;
            }
            result.append(w);
        }
        
        return result.toString();
	}
	
}
