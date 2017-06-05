package cz.alisma.alej.text.wrapping;
import java.util.List;

/** Aligns text in a line. */
public interface Aligner {
    
    /** Format one line.
     * 
     * @param words List of words on the line.
     * @return Formatted line.
     */
    public String format(List<String> words);
}
