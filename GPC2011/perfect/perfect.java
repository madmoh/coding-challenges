package perfect;

import java.io.*;
import java.util.*;

public class perfect {
	public static void main(String args[]) throws IOException {		
		Scanner s = new Scanner(new FileReader("perfect.in"));
		
		int numTests = s.nextInt();
		for (int test = 0; test < numTests; test++) {
			int numRoads = s.nextInt();			
			
			ArrayList<line> roads = new ArrayList<>();
			for (int road = 0; road < numRoads; road++) {
				roads.add(new line(road, s.nextFloat(), s.nextFloat(), s.nextFloat(), s.nextFloat()));
			}
			
			for (int road1 = 0; road1 < numRoads; road1++) {
				for (int road2 = 0; road2 < numRoads; road2++) {
					if (road1 == road2) continue;
					if (intersect(roads.get(road1).x1, roads.get(road1).y1, roads.get(road1).x2, roads.get(road1).y2,
								  roads.get(road2).x1, roads.get(road2).y1, roads.get(road2).x2, roads.get(road2).y2))
						roads.get(road1).intersections++;
				}
			}
			
			boolean perfect = true;
			float prevLength = 0;
			Collections.sort(roads);
			
			for (int i = 0; i < roads.size(); i++) {
				if (roads.get(i).intersections > 0 && (roads.get(i).length <= prevLength || i == 0)) {
					System.out.println(roads.get(i));
					prevLength = roads.get(i).length;
					perfect = false;
				}
			}
			
			if (perfect) {
				System.out.println("This is a perfect network!");
			}
			
			System.out.println();
		}
		
		s.close();
	}
	
	public static double twice_area(double x1, double y1, double x2, double y2, double x3, double y3) {
		return  x1 * (y2 - y3) +
				x2 * (y3 - y1) +
				x3 * (y1 - y2);
	}
	
	public enum POS {
		LEFT, RIGHT, COLLINEAR
	}

	public static POS dir(double x1, double y1, double x2, double y2, double x3, double y3) {
		double area2 = twice_area(x1, y1, x2, y2, x3, y3);
		if (area2 < 0) return POS.LEFT;
		else if (area2 > 0) return POS.RIGHT;
		else return POS.COLLINEAR;
	}
	
	public static boolean XOR(boolean a, boolean b) {
		return !a ^ !b;
	}
	
	public static boolean intersect(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4) {
		if (dir(x1, y1, x2, y2, x3, y3) == POS.COLLINEAR ||
			dir(x1, y1, x2, y2, x4, y4) == POS.COLLINEAR ||
			dir(x3, y3, x4, y4, x1, y1) == POS.COLLINEAR ||
			dir(x3, y3, x4, y4, x2, y2) == POS.COLLINEAR) return false;
		
		return XOR(dir(x1, y1, x2, y2, x3, y3) == POS.LEFT,
				   dir(x1, y1, x2, y2, x4, y4) == POS.LEFT) &&
			   XOR(dir(x3, y3, x4, y4, x1, y1) == POS.LEFT,
				   dir(x3, y3, x4, y4, x2, y2) == POS.LEFT);
	}
}

class line implements Comparable<line> {
	int id;
	float x1;
	float y1;
	float x2;
	float y2;
	float length;
	int intersections;
	
	line(int id, float x1, float y1, float x2, float y2) {
		this.id = id;
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.length = (float)Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
		intersections = 0;
	}
	
	public int compareTo(line compareline) {
        float fieldInter = this.intersections - compareline.intersections;
        if (fieldInter > 0) return -1;
        else if (fieldInter < 0) return +1;
        
        float fieldLength = this.length - compareline.length;
        if (fieldLength > 0) return -1;
        else if (fieldLength < 0) return +1;
        
        float fieldID = this.id - compareline.id;
        if (fieldID > 0) return +1;
        else if (fieldID < 0) return -1;
        
        return 0;
    }
	
	public String toString() {
		return id + " " + String.format("%.2f", length) + " " + intersections;
	}
}