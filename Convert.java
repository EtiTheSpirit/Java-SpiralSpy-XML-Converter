package start;

import java.io.IOException;

public class Convert {
	
	String obj = "";
	String objF = "";
	
	StringManipulation string = new StringManipulation();
	Triangle tri = new Triangle();
	int prev = 0;
	
	static double x1;
	static double y1;
	static double z1;
	
	static double x2;
	static double y2;
	static double z2;
	
	static double x3;
	static double y3;
	static double z3;
	
	static int end = 0;
	
	private static void IterateTriangleDataTable(double[] stuph) {
		int len = stuph.length;
		for (int i = 0; i < len; i++) {
			if (i == 0) {
				x1 = stuph[i];
			} else if (i == 1) {
				y1 = stuph[i];
			} else if (i == 2) {
				z1 = stuph[i];
			} else if (i == 3) {
				x2 = stuph[i];
			} else if (i == 4) {
				y2 = stuph[i];
			} else if (i == 5) {
				z2 = stuph[i];
			} else if (i == 6) {
				x3 = stuph[i];
			} else if (i == 7) {
				y3 = stuph[i];
			} else if (i == 8) {
				z3 = stuph[i];
			} else if (i == 9) {
				end = (int) stuph[i];
			} else if (i > 9) {
				break;
			}
		}
	}
	
	@SuppressWarnings("static-access")
	public String Init(String xml) throws IOException {
		int TriCount = string.match(xml, "<triangle>");
		System.out.println(TriCount+" faces in XML.");
		System.out.println((TriCount*3)+" vertecies in XML");
		System.out.println("Getting triangle data...");
		
		obj = obj + "#Brought to you by XanthicDragon\n\ng Model\n\n";
		
		Index index = new Index();
		int start = string.find(xml, "<indices>", 0);
		int finish = string.find(xml, "</indices>", 0);
		String stxt = xml.substring(start, finish);
		int[] indices = index.getIndices(stxt);
		int highest = index.getHighestIndex(stxt);
		int leng = indices.length;
		int finds = 0;
		for (int i = 0; i < leng*2; i++) {
			if (finds >= leng || i >= leng) {
				if (i > 0 && i % 3 == 0) {
					int g = indices[i-leng+2]+highest;
					int h = indices[i-leng+1]+highest;
					int j = indices[i-leng+0]+highest;
					String t3 = g+" "+h+" "+j;
					objF = objF + "f "+t3+"\n";
				}
			} else {
				if (i > 0 && i % 3 == 0) {
					int g = indices[i-2];
					int h = indices[i-1];
					int j = indices[i-0];
					String t3 = g+" "+h+" "+j;
					objF = objF + "f "+t3+"\n";
					
				}
			}
			finds += 1;
		}
		int gets = 0;
		for (int i = 0; i < leng; i++) {
			if (gets >= TriCount) {
				end = 0;
				gets = 0;
			}
			double[] items = tri.getAll(xml, end);
			IterateTriangleDataTable(items);
			obj = obj + "v "+x1+" "+y1+" "+z1+"\n";
			obj = obj + "v "+x2+" "+y2+" "+z2+"\n";
			obj = obj + "v "+x3+" "+y3+" "+z3+"\n";
			gets += 1;
		}
		
		obj = obj + "\nusemtl none\n\n";
		System.out.println("Vertecies acquired and mapped. Getting vertex offsets...");
		obj = obj + objF;
		
		System.out.println("Complete!");
		return obj;
	}
}
