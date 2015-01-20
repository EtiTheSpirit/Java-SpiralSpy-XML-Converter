package start;
public class StringManipulation {
	/**
	 * Returns the starting position (for usage in substring) <BR>
	 * Example: FindString("Hello", "lo", 0); <br>
	 * Returns: 3 <br>
	 * To find the finish, take the variable used in [toFind]'s length and add that to the return.
	 * Changing Start will edit the location to start the search. <br>
	 * Example: FindString("HelloFlow", "lo", 5) returns 6, whereas FindString("HelloFlow", "lo", 0) returns 3. <br>
	 * Returns -1 if no string was found.
	 */
	public int find(String txt, String toFind, int Start) {
		return txt.indexOf(toFind, Start);
	}
	
	public int findEnd(String txt, String toFind, int Start) {
		return txt.lastIndexOf(toFind, Start);
	}
	
	/**
     *  Returns a string of [txt] where [replace] is changed to [toFind]<BR>
     *  Example: <br>
     *  gsub("Hello, world!", "world", "mars");<br>
     *  Returns: <br>
     *  Hello, mars!
     **/
	public String gsub(String txt, String toFind, String replace) {
		String nTxt = "";
		int Start = find(txt, toFind, 0);
		int Finish = Start+toFind.length();
		nTxt = txt.substring(0, Start)+replace+txt.substring(Finish+1);
		return nTxt;
	}
	
	public int match(String str, String findStr) {
		int lastIndex = 0;
		int count = 0;
		while (lastIndex != -1) {
			lastIndex = str.indexOf(findStr,lastIndex);
			if (lastIndex != -1) {
				count++;
				lastIndex += findStr.length();
			}
		}
		return count;
	}
}
