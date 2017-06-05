package cz.alisma.alej.text.wrapping;
import java.util.List;
import java.util.Scanner;

/** Paragraph of text. */
public class Paragraph {
    private Scanner words;

    /** Constructs the paragraph from list of lines.
     * 
     * @param lines Lines composing the paragraph.
     */
    public Paragraph(List<String> lines) {
        StringBuilder builder = new StringBuilder();
        for (String line : lines) {
            builder.append(line);
            builder.append(" ");
        }
        words = new Scanner(builder.toString());
    }

    /** Tells whether there is another word not yet read in the paragraph. */
    public boolean hasNextWord() {
        return words.hasNext();
    }

    /** Get the next word from the paragraph.
     * 
     * @return Next word.
     */
    public String nextWord() {
        return words.next();
    }
}
