package start;

public class Index {

	private static int[] returnTableOfIndex(String seg) {
		seg = seg.substring(9);
		String[] StrStuff = seg.split(", ");
		int[] stuff = new int[StrStuff.length];
		int f = 0;
		for (int i = 0; i < StrStuff.length; i++) {
			int MyNum = Integer.parseInt(StrStuff[i]);
			stuff[f] = MyNum+1;
			f += 1;
		}
		return stuff;
	}
	
	public static int[] getIndices(String xml) {
		int[] a = returnTableOfIndex(xml);
		return a;
	}
	
	public static int getHighestIndex(String xml) {
		int[] a = returnTableOfIndex(xml);
		int highest = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] > highest) {
				highest = a[i];
			}
		}
		return highest;
	}
}
