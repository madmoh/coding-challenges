/*
 * Level: medium
 * Time to read problem and solve: 0:27
 *   - Reading problem and figuring a solution: 10 minutes
 *   - Writing initial solution: 20 minutes
 *   - Solving bugs: 0 minutes
 * Concepts:
 *   1. 2D arrays
 *   2. Updating variables every period
 * To remember:
 *   1. Working with 2D arrays, it's is usually better to use it as [y][x] rather than [x][y]
 */

import java.io.*;
import java.util.*;

public class flu {
	public static void main(String args[]) throws FileNotFoundException {
		Scanner s = new Scanner(new FileReader("flu.in"));
		
		while (s.hasNextInt()) {
			int W = s.nextInt();
			int H = s.nextInt();
			if (W == 0 && H == 0) break;
			
			int T = s.nextInt(); // Time of being ill
			int I = s.nextInt(); // Time to spread to others
			int R = s.nextInt(); // Range of disease
			int D = s.nextInt(); // t_final
			
			// Get initial status
			char pop[][] = new char[H][W];
			int inf[][] = new int [H][W];
			for (int y = 0; y < H; y++) {
				String line = s.next();
				for (int x = 0; x < W; x++) {
					pop[y][x] = line.charAt(x); // P: healthy, I: infected, X: empty
					inf[y][x] = 0;
				}
			}
			
			// Update state until t = D
			for (int t = 0; t < D; t += I) {
				ArrayList<Person> psn = new ArrayList<>(); // regular person (not infected)
				ArrayList<Person> ill = new ArrayList<>(); // infected person
				
				for (int y = 0; y < H; y++) {
					for (int x = 0; x < W; x++) {
						if (pop[y][x] == 'P') psn.add(new Person(x, y));
						if (pop[y][x] == 'I') ill.add(new Person(x, y));
					}
				}
				
				for (Person i : ill) {
					inf[i.y][i.x] += I; 
				}
				
				for (Person i : ill) {
					if (inf[i.y][i.x] >= T)
						continue;
					for (Person p : psn) {
						if (distance(i.x, i.y, p.x, p.y) < R)
							pop[p.y][p.x] = 'I'; 
					}
				}
			}
			
			// Get final result
			int sumI = 0;
			for (int y = 0; y < H; y++) {
				for (int x = 0; x < W; x++) {
					if (pop[y][x] == 'I' && inf[y][x] <= T)
						sumI++;
				}
			}
			System.out.println(sumI);
		}
		
		s.close();
	}
	
	public static double distance(double x1, double y1, double x2, double y2) {
		return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
	}
}

class Person {
	int x;
	int y;
//	int t;
	
	public Person(int x_, int y_) { //, int t_) {
		x = x_;
		y = y_;
//		t = t_;
	}
}
