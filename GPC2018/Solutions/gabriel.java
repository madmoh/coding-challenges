/*
 * Level: easy
 * Time to read problem and solve: 0:15
 *   - Reading problem and figuring a solution: 5 minutes
 *   - Writing initial solution: 10 minutes
 *   - Solving bugs: 0 minutes
 * Concepts:
 *   1. Calculations of 2D points (distance, midpoint)
 * To remember:
 *   1. Even if points are given as integers, store them as doubles (unless explicitly stated)
 */

import java.io.*;
import java.util.*;

public class gabriel {
	public static void main(String args[]) throws FileNotFoundException {
		Scanner s = new Scanner(new FileReader("gabriel.in"));
		
		int T = s.nextInt();
		
		for (int t = 0; t < T; t++) {
			System.out.println(s.nextInt());
			
			int Z = s.nextInt();
			Point points[] = new Point[Z];
			for (int z = 0; z < Z; z++) {
				points[z] = new Point(s.nextInt(), s.nextInt(), s.nextInt());
			}
			
			for (Point a : points) {
				System.out.print(a.index + " ");
				for (Point b : points) {
					if (a == b) continue;
					
					Point midPoint = new Point(-1, (a.x + b.x) / 2.0, (a.y + b.y) / 2.0); 
					double d_amp = distance(a, midPoint);
					
					boolean isAdjacent = true;
					
					for (Point c : points) {
						if (c == a || c == b) continue;
						if (distance(midPoint, c) < d_amp) {
							isAdjacent = false;
							break;
						}
					}
					
					if (isAdjacent) System.out.print(b.index + " ");
				}
				System.out.println();
			}
		}
		
		s.close();
	}
	
	public static double distance(Point p1, Point p2) {
		return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
	}
}

class Point {
	int index;
	double x;
	double y;
	
	public Point(int index, double x, double y) {
		this.index = index;
		this.x = x;
		this.y = y;
	}
}