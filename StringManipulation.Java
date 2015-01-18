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
		int lenTxt = txt.length();
		int lenFnd = toFind.length();
		int j = -1;
		for (int i = Start; i < lenTxt-lenFnd; i++) {
			String sub = txt.substring(i, i+lenFnd);
			j = i;
			if (sub.matches(toFind)) {
				break;
			}
		}
		return j;
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
		nTxt = txt.substring(0, Start-1)+replace+txt.substring(Finish+1);
		return nTxt;
	}
	
	/**
	 * Returns an integer that represents how many times [toFind] was found in [txt] 
	 */
	public int match(String txt, String toFind) {
		int Finds = 0;
		for (int i = 0; i < txt.length()-toFind.length(); i++) {
			String sub = txt.substring(i, i+toFind.length());
			if (sub.matches(toFind)) {
				Finds += 1;
			}
		}
		return Finds;
	}
}
