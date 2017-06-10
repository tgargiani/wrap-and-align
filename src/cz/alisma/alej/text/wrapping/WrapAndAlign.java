/*
 * MIT License
 * Copyright (c) 2017 Gymnazium Nad Aleji
 * Copyright (c) 2017 Vojtech Horky
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package cz.alisma.alej.text.wrapping;

import java.util.Scanner;

public class WrapAndAlign {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ParagraphDetector pd = new ParagraphDetector(input);
        int width = 30;
        Aligner aligner = new LeftAligner(width);
        
        if (args.length == 1) {
        	if (args[0].equals("--right")) {
        		aligner = new RightAligner(width);
        	} if (args[0].equals("--center")) {
        		aligner = new CenterAligner(width);
        	} if (args[0].equals("--justify")) {
        		aligner = new JustifyAligner(width);
        	}
        }
        if (args.length == 2) {
        	if (args[0].equals("-w")) {
        		try {
        			width = Integer.parseInt(args[1]);
        		} catch (NumberFormatException e) {
        			System.out.println("Invalid input!\n");
        			throw e;
        		}
        	}
        } if (args.length == 3) {
        	if (args[1].equals("-w")) {
        		try {
        			width = Integer.parseInt(args[2]);
        		} catch (NumberFormatException e) {
        			System.out.println("Invalid input!\n");
        			throw e;
        		}
        	}
        	
        	if (args[0].equals("--right")) {
        		aligner = new RightAligner(width);
        	} if (args[0].equals("--center")) {
        		aligner = new CenterAligner(width);
        	} if (args[0].equals("--justify")) {
        		aligner = new JustifyAligner(width);
        	}
        }

        while (pd.hasNextParagraph()) {
            Paragraph para = pd.nextParagraph();
            LinePrinter line = new LinePrinter(System.out, width, aligner);
            while (para.hasNextWord()) {
                String word = para.nextWord();
                line.addWord(word);
            }
            line.flush();
            System.out.println();
        }
    }
}