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
import java.util.ArrayList;
import java.util.List;

public class JustifyAligner implements Aligner {
	
	private int width;
	public JustifyAligner(int width) {
		this.width = width;
	}

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
			spaceWidth = (double) (width - realWidth) / words.size();
		} else {
			spaceWidth = (double) (width - realWidth) / (words.size() - 1);
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
