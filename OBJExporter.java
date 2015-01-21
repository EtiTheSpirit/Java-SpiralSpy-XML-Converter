package start;

public class OBJExporter {
	
	static double x1;
	static double x2;
	static double x3;
	
	static double y1;
	static double y2;
	static double y3;
	
	static double z1;
	static double z2;
	static double z3;
	
	public static String getInput(double[][] tris, int[] indices, int triLen) {
		String obj = "#Brought to you by XanthicDragon\n\ng Model\n\n";
		/*
		 * TRIS:
		 * {input} {x1, y1, z1, x2, y2, z2, x3, y3, z3, end}
		 * Ignore end
		 */
		
		int indLen = indices.length;
		
		int TC = (triLen+indLen)*3;
		
		/*
		 * IDEA:
		 * Using values of indices, I can index certain triangles.
		 * EXAMPLE:
		 * Indices: 1, 2, 5, 6, 4, 3
		 * if (tris[Indices[i]] != null) { }
		 * If there is a triangle capable of being indexed, run it in that order. OTHERWISE, go the normal order.
		 */
		
		int f = 0;
		int g = 0;
		for (int i = 0; i < triLen; i++) {
			try {
				if (i < indLen) {
					f++;
					double[] set = tris[indices[i]];
					x1 = set[0];
					y1 = set[1];
					z1 = set[2];
					
					x2 = set[3];
					y2 = set[4];
					z2 = set[5];
					
					x3 = set[6];
					y3 = set[7];
					z3 = set[8];
					
					obj = obj + "v "+x1+" "+y1+" "+z1+"\n";
					obj = obj + "v "+x2+" "+y2+" "+z2+"\n";
					obj = obj + "v "+x3+" "+y3+" "+z3+"\n";
				}
			} finally {
				double[] set = tris[i];
				x1 = set[0];
				y1 = set[1];
				z1 = set[2];
				
				x2 = set[3];
				y2 = set[4];
				z2 = set[5];
				
				x3 = set[6];
				y3 = set[7];
				z3 = set[8];
				
				obj = obj + "v "+x1+" "+y1+" "+z1+"\n";
				obj = obj + "v "+x2+" "+y2+" "+z2+"\n";
				obj = obj + "v "+x3+" "+y3+" "+z3+"\n";
				g++;
			}
		}
		

		obj = obj + "\nusemtl null\n\n";
		System.out.println(f+" indexed triangles");
		System.out.println(g-f+" non-indexed triangles");
		for (int i = 0; i <= TC; i++) {
			if (i % 3 == 0 && i > 0) {
				obj = obj + "f "+(i-2)+" "+(i-1)+" "+(i-0)+"\n";
			}
		}
		return obj;
	}
}
