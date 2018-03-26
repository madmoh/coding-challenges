/*
 * Level: medium
 * Time to read problem and solve: 0:55
 *   - Reading problem and figuring a solution: 20 minutes
 *   - Writing initial solution: 20 minutes
 *   - Solving bugs: 15 minutes
 * Concepts:
 *   1. Mathematics (figuring out algorithms)
 * To remember:
 *   1. Solve a sample by hand first, then codify the algorithm
 *   2. If not sure how to directly get best solution, get all solutions then sort them out
 */

import java.io.*;
import java.util.*;

public class tri {
	public static void main(String args[]) throws FileNotFoundException {
//		System.out.println((long)checkTriangular(3));
//		System.out.println(getTriangular((long)checkTriangular(3)));
		
		Scanner s = new Scanner(new FileReader("tri.in"));
		
		int T = s.nextInt();
		
		for (int t = 0; t < T; t++) {
			System.out.print((t + 1) + ". ");
			
			long N = s.nextLong();
			
			long n = (long)checkTriangular(N);
//			System.out.print(n + " \t ");
			
			ArrayList<TriNum> solutions = new ArrayList<>();
			for (int k = 0; k < n; k++) {
				long n0, n1, n2;
				n0 = getTriangular(n - k);
				n1 = getTriangular((long)checkTriangular(N - n0));
				n2 = getTriangular((long)checkTriangular(N - n0 - n1));
				if (n0 + n1 + n2 == N) solutions.add(new TriNum(n0, n1, n2));
			}
			
//			System.out.print(solutions.size() + " \t ");
			System.out.println(Collections.min(solutions));
		}
		
		s.close();
	}
	
	public static long getTriangular(long index) {
		return index * (index + 1) / 2;
	}
	
	public static double checkTriangular(long number) {
		return (Math.sqrt(1 + 8 * number) - 1) / 2.0;
	}
	
	public static boolean isInteger(double number) {
		return (number == Math.floor(number));
	}
}

class TriNum implements Comparable<TriNum> {
	long n0;
	long n1;
	long n2;
	int numberOfTri;
	
	public TriNum(long n0, long n1, long n2) {
		Long array[] = {n0, n1, n2};
		Collections.sort(Arrays.asList(array));
		
		this.n0 = array[0];
		this.n1 = array[1];
		this.n2 = array[2];
		
		if (n0 != 0) numberOfTri++;
		if (n1 != 0) numberOfTri++;
		if (n2 != 0) numberOfTri++;
	}
	
	public String toString() {
		String temp = "";
		if (n0 != 0) temp += n0;
		if (n1 != 0) temp += " " + n1;
		if (n2 != 0) temp += " " + n2;
		if (temp.charAt(0) == ' ') temp = temp.substring(1);
		return temp;
	}
	
	public int compareTo(TriNum tn) {
		if (numberOfTri < tn.numberOfTri) return -1;
		if (numberOfTri > tn.numberOfTri) return +1;
		
		if (n0 < tn.n0) return -1;
		if (n0 > tn.n0) return +1;
		
		if (n1 < tn.n1) return -1;
		if (n1 > tn.n1) return +1;
		
		else return 0;
	}
}