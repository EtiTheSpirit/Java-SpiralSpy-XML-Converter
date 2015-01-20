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
	
	@SuppressWarnings("static-access")
	public String Init(String xml) throws IOException {
		if (string.find(xml, "com.threerings.export.XMLImporter", 0) > -1) {
			int TriCount = string.match(xml, "<triangle>");
			System.out.println(TriCount+" faces in XML.");
			System.out.println((TriCount*3)+" vertecies in XML");
			System.out.println("Getting triangle data...");
			
			double[][] triangles = new double[TriCount][9];
			
			OBJExporter export = new OBJExporter();
			
			obj = obj + "#Brought to you by XanthicDragon\n\ng Model\n\n";
			
			Index index = new Index();
			int start = string.find(xml, "<indices>", 0);
			int finish = string.find(xml, "</indices>", 0);
			String stxt = xml.substring(start, finish);
			int[] indices = index.getIndices(stxt);
			/*for (int i = 0; i < TriCount; i++) {
				double[] items = tri.getAll(xml, end);
				triangles[i] = items;
				end = (int) items[9];
			}*/
			
			int i = 0;
			
			String xml2 = xml.substring(string.find(xml, "<mode>TRIANGLES</mode>", 0));
			while (string.find(xml2, "<triangle>", end) > -1) {
				System.out.println(end);
				double[] items = tri.getAll(xml2, end);
				triangles[i] = items;
				end = (int) items[9];
				i++;
			}
			
			obj = export.getInput(triangles, indices, TriCount);
			
			System.out.println("Complete!");
			return obj;
		} else {
			return "Not a valid SpiralSpy XML.";
		}
	}
}
