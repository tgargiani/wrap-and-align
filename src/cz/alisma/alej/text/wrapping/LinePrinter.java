package cz.alisma.alej.text.wrapping;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/** Wraps printed lines. */
public class LinePrinter {
    private int width;
    private PrintStream output;
    private Aligner aligner;
    private List<String> words;

    /** Constructor.
     * 
     * @param out Where to send the output to.
     * @param w Maximum output width.
     * @param align Aligner to use.
     */
    public LinePrinter(PrintStream out, int w, Aligner align) {
        output = out;
        width = w;
        aligner = align;
        words = new ArrayList<>();
    }

    /** Add a word to be printed. */
    public void addWord(String word) {
        words.add(word);
    }

    /** Flush the content to the output.
     * 
     * Prints all remaining words, aligning the lines properly.
     */
    public void flush() {
        int lengthSoFar = 0;
        List<String> line = new ArrayList<>();
        
        for (String word : words) {
            if (lengthSoFar + word.length() > width) {
                output.println(aligner.format(line));
                line.clear();
                lengthSoFar = 0;
            }
            line.add(word);
            lengthSoFar += word.length() + 1;
        }
        
        if (!line.isEmpty()) {
            output.println(aligner.format(line));
        }
    }

}
