/*
 * Level: easy
 * Time to read problem and solve: 0:15
 *   - Reading problem and figuring a solution: 3 minutes
 *   - Writing initial solution: 7 minutes
 *   - Solving bugs: 5 minutes
 * Concepts:
 *   1. Iteratively reach solution (alternative solution)
 *   2. Figuring out algorithm to directly calculate result
 * To remember:
 *   1. Always check given constraints
 *   2. If updated program to "long" instead of "int", reread the entire program to ensure everything uses "long"
 */

import java.io.*;
import java.util.*;

public class rocket {
	public static void main(String args[]) throws FileNotFoundException {
		Scanner s = new Scanner(new FileReader("rocket.in"));
		
		while (s.hasNextLong()) {
			long n = s.nextLong();
			if (n == 0) break;
			
//			System.out.println(4/2.0 * (n-1)/3.0 * (2.0 * (n-1)/3.0 + 1));
			
			long sum = 0;
			long toAdd = 1;
			while (toAdd < n) {
				sum += toAdd;
				toAdd += 3;
			}
			sum *= 2;
			sum += n;
			
			System.out.println(sum);
		}
		
		s.close();
	}
}
