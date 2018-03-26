/*
 * Level: medium (surprisingly not easy)
 * Time to read problem and solve: 1:00
 *   - Reading problem and figuring a solution: 5 minutes
 *   - Writing initial solution (commented): 5 minutes
 *   - Writing second solution: 50 minutes (trial and error)
 *   - Solving bugs: 0 minutes
 * Concepts:
 *   1. Optimizing special array multiplications
 *   	- Instead of multiplying every x in X by every y in Y, get the base sum of x (assume y = 1),
 *   	  then the sum will be SUM(base sum * every y in Y, y * (X.size() - 1))
 * To remember:
 *   1. Check given constraints, question could be harder than expected
 */

import java.io.*;
import java.util.*;

public class land {
	public static void main(String args[]) throws FileNotFoundException {
		// Testing old solution on large N values
//		int N = 30000;
//		
//		int X[] = new int[N];
//		for (int i = 0; i < N; i++) {
//			X[i] = (int)(9 * Math.random() + 1);
//			System.out.print(X[i] + "\t");
//		}
//		System.out.println();
//		
//		int Y[] = new int[N];
//		for (int i = 0; i < N; i++) {
//			Y[i] = (int)(9 * Math.random() + 1);
//			System.out.print(Y[i] + "\t");
//		}
//		System.out.println();
//		
//		long SUM[] = {0, 0, 0};
//		
//		for (int x = 0; x < N; x++) {
//			for (int y = 0; y < N; y++) {
//				SUM[(x + y) % 3] += X[x] * Y[y];
//			}
//		}
//		
//		System.out.println(SUM[0] + " " + SUM[2] + " " + SUM[1]);
//		
//		for (int x = 0; x < N; x++) {
//			System.out.println();
//			for (int y = 0; y < N; y++) {
//				System.out.print(X[x] * Y[y] + "\t");
//			}
//		}
//		System.out.println();
//		System.out.println();
//		System.out.println();
		
		// Testing new algorithm on large N values
//		int N = 10000000;
//		long sumBase[] = {0, 0, 0};
//		for (int x = 0; x < N; x++) {
//			sumBase[x % 3] += (long)(Math.random() * 9 + 1);
//		}
//		long sum[] = {0, 0, 0};
//		for (int y = 0; y < N; y++) {
//			long multiplier = (long)(Math.random() * 9 + 1);
//			for (int i = 0; i < 3; i++) {
//				sum[(i + y * 2) % 3] += sumBase[(i + y) % 3] * multiplier;
//			}
//		}
//		System.out.println(sum[0] + " " + sum[2] + " " + sum[1]);
		
		Scanner s = new Scanner(new FileReader("land.in"));
		
		while (s.hasNextInt()) {
			int n = s.nextInt();
			if (n == 0) break;
			
			long sumBase[] = {0, 0, 0};
			for (int x = 0; x < n; x++) {
				sumBase[x % 3] += s.nextInt();
			}
			
//			for (long l : sumBase) System.out.print(l + " ");
//			System.out.println();
			
			long sum[] = {0, 0, 0};
			for (int y = 0; y < n; y++) {
				int multiplier = s.nextInt();
				for (int i = 0; i < 3; i++) {
					sum[(i + y * 2) % 3] += sumBase[(i + y) % 3] * multiplier;
				}
//				sum[y % 3] += sumBase[y % 3] * s.nextInt();
			}
			
			System.out.println(sum[0] + " " + sum[2] + " " + sum[1]);
//			System.out.println();
//			System.out.println();
		}
		
		// Old solution (takes O(n^2))
//		while (s.hasNextInt()) {
//			int n = s.nextInt();
//			if (n == 0) break;
//			
//			long sumBase[] = {0, 0, 0};
//			long sumNew[] = {0, 0, 0};
//			
//			int X[] = new int[n];
//			for (int i = 0; i < n; i++) {
//				X[i] = s.nextInt();
//				sumBase[i % 3] += X[i];
//			}
//			
//			int Y[] = new int[n];
//			for (int i = 0; i < n; i++) {
//				Y[i] = s.nextInt();
//				sumNew[i % 3]
//				sumNew[i % 3] += sumBase * Y[i];
//			}
//			
//			long sum[] = {0, 0, 0};
//			
//			for (int x = 0; x < n; x++) {
//				for (int y = 0; y < n; y++) {
//					sum[(x + y) % 3] += X[x] * Y[y];
//				}
//			}
//			
//			System.out.println(sum[0] + " " + sum[2] + " " + sum[1]);
//			System.out.println(sumNew[0] + " " + sumNew[2] + " " + sumNew[1]);
//			
////			for (int x = 0; x < n; x++) {
////				System.out.println();
////				for (int y = 0; y < n; y++) {
////					System.out.print(X[x] * Y[y] + "\t");
////				}
////			}
////			System.out.println();
////			System.out.println();
////			System.out.println();
//		}
		
		s.close();
	}
	
	public static long[] arrayMultiply(long array[], int constant) {
		long tempArray[] = new long[array.length];
		for (int i = 0; i < tempArray.length; i++) {
			tempArray[i] = array[i] * constant;
		}
		return tempArray;
	}
	
	public static long[] arrayAdd(long array1[], long array2[]) {
		long tempArray[] = new long[array1.length];
		for (int i = 0; i < tempArray.length; i++) {
			tempArray[i] = array1[i] + array2[i];
		}
		return tempArray;
	}
}
