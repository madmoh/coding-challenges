/*
 * Level: difficult
 * Time to read problem and solve: 1:24
 *   - Reading problem and figuring a solution: 10 minutes
 *   - Writing initial solution: 20 minutes
 *   - Solving bugs: 60 minutes
 * Concepts:
 *   1. Tree search (uninformed, DFS)
 * To remember:
 *   1. *Deep* copying of Objects (ArrayList, Stack,...)
 *   	- DOOOO use: ArrayList<Object> newArrayList = new ArrayList<>(oldArrayList);
 *   	- Don't use: ArrayList<Object> newArrayList = oldArrayList;
 *   2. == for some Objects (String, Integer,...) is overridden, therefore can't be used to compare object addresses
 *   	- DOOOO use: Object newObject = new Object(...);
 *   	- Don't use: Object newObject = ...;
 *   3. DFS from left to right is done by entering children nodes from right to left
 *   	- DOOOO use: for (j = last; j >= 0; j--) {...}
 *   	- Don't use: for (Object o : anArrayList) {...}
 */

import java.io.*;
import java.util.*;

public class square {
	public static void main(String args[]) throws FileNotFoundException {	
//		ArrayList<Integer> ali1 = new ArrayList<>();
//		ali1.add(1); ali1.add(3); ali1.add(3);
//		ArrayList<Integer> ali2 = new ArrayList<>(ali1);
//		System.out.println(ali1);
//		System.out.println(ali2);
//		ali2.remove(0);
//		System.out.println(ali1);
//		System.out.println(ali2);
		
//		System.out.println(isSquare(15 + 10));
		
//		Stack<Integer> S = new Stack<>();
//		Integer i2 = 2;
//		S.push(i2);
//		S.push(i2);
//		System.out.println(S);
		
//		Integer i1 = new Integer(10);
//		Integer i2 = new Integer(10);
//		System.out.println(i1 == i2);
		
		Scanner s = new Scanner(new FileReader("square.in"));
		
		while (s.hasNextInt()) {
			int N = s.nextInt();
			if (N == 0) break;
			
			ArrayList<Integer> numbers = new ArrayList<>();
			for (int n = 0; n < N; n++) numbers.add(new Integer(s.nextInt()));
			Collections.sort(numbers);
			
			ArrayList<Integer> solution = new ArrayList<>();
			boolean solved = false;
			
			for (Integer i : numbers) {
//				System.out.println(i);
				
				Stack<Integer> sequence = new Stack<>();
				sequence.push(new Integer(i));
				
				Stack<ArrayList<Integer>> sequencePath = new Stack<>();
				ArrayList<Integer> initial = new ArrayList<>(); initial.add(new Integer(i));
				sequencePath.push(initial);
				
				boolean found = false;
				
//				ArrayList<Integer> numbersCopy = new ArrayList<>(numbers);
//				System.out.println("\t" + numbersCopy);
				
//				int lastSize = 0;
				
				while (!sequence.isEmpty() && !found) {
					Integer node = sequence.pop();
					ArrayList<Integer> path = sequencePath.pop();
					
//					if (lastSize > path.size()) {
//						numbersCopy = new ArrayList<>(numbers);
//						System.out.println("\t" + numbersCopy);
//					}
//					lastSize = path.size();
					
//					System.out.println(path + " " + path.size());
					if (path.size() == numbers.size()) {
						found = true;
						solution = new ArrayList<>(path);
					}
					
					for (int j = numbers.size() - 1; j >= 0; j--) {
						if (i == numbers.get(j)) continue;
						
						boolean isInPath = false;
						for (Integer k : path) {
							if (k == numbers.get(j)) {
								isInPath = true;
								break;
							}
						}
						if (isSquare(node + numbers.get(j)) && !isInPath) {
							sequence.push(new Integer(numbers.get(j)));
							ArrayList<Integer> tempPath = new ArrayList<>(path);
							tempPath.add(numbers.get(j));
							sequencePath.push(tempPath);
//							numbers.remove(j);
						}
					}
				}
				
				if (found) {
					solved = true;
					break;
				}
			}
			
			if (solved) {
				for (Integer i : solution) {
					System.out.print(i + " ");
				}
				System.out.println();
			} else {
				System.out.println("No solution");
			}
		}
		
		s.close();
	}
	
	static boolean isSquare(int number) {
		double sqrt = Math.sqrt(number);
		return (sqrt == Math.floor(sqrt));
	}
}
