package cz.alisma.alej.text.wrapping;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** Detects paragraph breaks in the input. */
public class ParagraphDetector {
    private Scanner input;
    private Paragraph nextPara;

    /** Constructs the detector above a scanner.
     * 
     * @param inp Initialized scanner to be used for reading the input.
     */
    public ParagraphDetector(Scanner inp) {
        input = inp;
    }

    /** Tells whether there is another paragraph not yet read in the input. */
    public boolean hasNextParagraph() {
        String line = "";
        while (input.hasNextLine()) {
            line = input.nextLine();
            if (!line.isEmpty()) {
                break;
            }
        }
        if (line.isEmpty()) {
            return false;
        }

        List<String> lines = new ArrayList<>();
        lines.add(line);

        while (input.hasNextLine()) {
            line = input.nextLine();
            if (line.isEmpty()) {
                break;
            }
            lines.add(line);
        }

        nextPara = new Paragraph(lines);
        return true;
    }
    
    /** Get the next paragraph from the input. */
    public Paragraph nextParagraph() {
        return nextPara;
    }
}
