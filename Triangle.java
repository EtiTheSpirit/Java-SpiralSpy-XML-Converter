package start;

public class Triangle {
	/**
	 * When given text and a position to start a search, it will search for segments in the XML file that store TriangleData. <br>
	 * Returns a table consisting of x1, y1, z1, x2, y2, z2, x3, y3, z3 and a final entry of the last position it found a vector <br>
	 * Utilizing the last position, it can be "chained" (called multiple times) with very little difficulty.
	 */
	public static double[] getAll(String triSeg, int StartFind) {
		if (StartFind > 15) {
			StartFind -= 15;
		}
		double x1 = 0.0;
		double y1 = 0.0;
		double z1 = 0.0;
		double x2 = 0.0;
		double y2 = 0.0;
		double z2 = 0.0;
		double x3 = 0.0;
		double y3 = 0.0;
		double z3 = 0.0;
		double end = 0.0;
		//Variables defined.
		StringManipulation string = new StringManipulation();
		
		int V1Start = string.find(triSeg, "<v1>", StartFind);
		int V1End = string.find(triSeg, "</v1>", StartFind);
		
		String V1 = triSeg.substring(V1Start, V1End);
		V1 = V1.replace("<v1>", "");
		String[] xyz1 = V1.split(", ");
		
		for (int i = 0; i < xyz1.length; i++) {
			if (i == 0) {
				x1 = Double.parseDouble(xyz1[i]);
			} else if (i == 1) {
				z1 = Double.parseDouble(xyz1[i]);
			} else if (i == 2) {
				y1 = Double.parseDouble(xyz1[i]);
			}
		}
		
		int V2Start = string.find(triSeg, "<v2>", V1End);
		int V2End = string.find(triSeg, "</v2>", V1End);
		
		String V2 = triSeg.substring(V2Start, V2End);
		V2 = V2.replace("<v2>", "");
		String[] xyz2 = V2.split(", ");
		
		for (int i = 0; i < xyz2.length; i++) {
			if (i == 0) {
				x2 = Double.parseDouble(xyz2[i]);
			} else if (i == 1) {
				z2 = Double.parseDouble(xyz2[i]);
			} else if (i == 2) {
				y2 = Double.parseDouble(xyz2[i]);
			}
		}
		
		int V3Start = string.find(triSeg, "<v3>", V2End);
		int V3End = string.find(triSeg, "</v3>", V2End);
		
		String V3 = triSeg.substring(V3Start, V3End);
		V3 = V3.replace("<v3>", "");
		String[] xyz3 = V3.split(", ");
		
		for (int i = 0; i < xyz3.length; i++) {
			if (i == 0) {
				x3 = Double.parseDouble(xyz3[i]);
			} else if (i == 1) {
				z3 = Double.parseDouble(xyz3[i]);
			} else if (i == 2) {
				y3 = Double.parseDouble(xyz3[i]);
			}
		}
		
		end = V3End;
		
		double[] V3Table = {x1, y1, z1, x2, y2, z2, x3, y3, z3, end};
		return V3Table;
	}
}
