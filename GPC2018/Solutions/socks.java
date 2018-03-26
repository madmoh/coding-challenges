/*
 * Level: easy
 * Time to read problem and solve: 0:10
 *   - Reading problem and figuring a solution: 5 minutes
 *   - Writing initial solution: 5 minutes
 *   - Solving bugs: 0 minutes
 * Concepts:
 *   1. Mathematics and logical thinking
 * To remember:
 *   1. Always check given constraints
 *   2. If updated program to "long" instead of "int", reread the entire program to ensure everything uses "long"
 */

import java.io.*;
import java.util.*;

public class socks {
	public static void main(String args[]) throws FileNotFoundException {
//		System.out.println(Long.MAX_VALUE);
		
		Scanner s = new Scanner(new FileReader("socks.in"));
		
		int T = s.nextInt();
		
		for (int t = 0; t < T; t++) {
			System.out.print((t + 1) + ". ");
			
			long C = s.nextInt();
			long sum = 0;
			for (int c = 0; c < C; c++) {
				sum += s.nextInt();
			}
			if (C + 1 <= sum) System.out.println(C + 1);
			else System.out.println("Impossible");
		}
		
		s.close();
	}
}
