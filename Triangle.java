package start;

public class Triangle {
	/**
	 * When given text and a position to start a search, it will search for segments in the XML file that store TriangleData. <br>
	 * Returns a table consisting of x1, y1, z1, x2, y2, z2, x3, y3, z3 and a final entry of the last position it found a vector <br>
	 * Utilizing the last position, it can be "chained" (called multiple times) with very little difficulty.
	 */
	public static double[] getAll(String triSeg, int StartFind) {
		StartFind = Math.abs(StartFind);
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
		
		StringManipulation str = new StringManipulation();
		int FirstPos = str.find(triSeg, "<v1>", StartFind);
		int firstCommaPos = str.find(triSeg, ", ", FirstPos+4);
		
		String X1 = triSeg.substring(FirstPos+4, firstCommaPos);
		
		int secondCommaPos = str.find(triSeg, ", ", firstCommaPos+1);
		
		String Y1 = triSeg.substring(firstCommaPos+2, secondCommaPos);
		
		int lastSetPos = str.find(triSeg, "</v1>", secondCommaPos-2);
		
		String Z1 = triSeg.substring(secondCommaPos+2, lastSetPos);
		
		x1 = Float.parseFloat(X1);//X Z Y -- DO NOT EDIT (It's not X Y Z!)
		y1 = Float.parseFloat(Z1);
		z1 = Float.parseFloat(Y1);
		
		//V1 Complete. Starting V2
		FirstPos = str.find(triSeg, "<v2>", lastSetPos);
		firstCommaPos = str.find(triSeg, ", ", FirstPos+("<v2>").length());
		
		
		String X2 = triSeg.substring(FirstPos+4, firstCommaPos);
		
		//System.out.println(X2);
		
		secondCommaPos = str.find(triSeg, ", ", firstCommaPos+1);
		
		String Y2 = triSeg.substring(firstCommaPos+2, secondCommaPos);
		
		//System.out.println(Y2);
		
		lastSetPos = str.find(triSeg, "</v2>", secondCommaPos-2);
		
		String Z2 = triSeg.substring(secondCommaPos+2, lastSetPos);
		
		//System.out.println(Z2);
		
		x2 = Float.parseFloat(X2);//X Z Y -- DO NOT EDIT (It's not X Y Z!)
		y2 = Float.parseFloat(Z2);
		z2 = Float.parseFloat(Y2);
		//Got V2. Starting V3
		FirstPos = str.find(triSeg, "<v3>", lastSetPos);
		firstCommaPos = str.find(triSeg, ", ", FirstPos+("<v3>").length());
		
		String X3 = triSeg.substring(FirstPos+4, firstCommaPos);
		
		secondCommaPos = str.find(triSeg, ", ", firstCommaPos+1);
		
		String Y3 = triSeg.substring(firstCommaPos+2, secondCommaPos);
		
		lastSetPos = str.find(triSeg, "</v3>", secondCommaPos-2);
		
		String Z3 = triSeg.substring(secondCommaPos+2, lastSetPos);
		
		x3 = Float.parseFloat(X3);//X Z Y -- DO NOT EDIT (It's not X Y Z!)
		y3 = Float.parseFloat(Z3);
		z3 = Float.parseFloat(Y3);
		
		//end = lastSetPos;
		end = str.find(triSeg, "</triangle>", lastSetPos)+10;
		
		double[] V3Table = {x1, y1, z1, x2, y2, z2, x3, y3, z3, end};
		return V3Table;
	}
}
