/*
 * Level: difficult
 * Time to read problem and solve: 1:35
 *   - Reading problem and figuring a solution: 30 minutes
 *   - Writing initial solution (deleted): 45 minutes
 *   - Writing second solution: 15 minutes
 *   - Solving bugs: 5 minutes
 * Concepts:
 *   1. Tree search (uninformed, BFS or DFS)
 * To remember:
 *   1. Don't over-define classes
 *   	- Use simple String to represent the chain, instead of an entire class
 *   2. Almost always use: new Object(...)
 *   3. Keep in mind whether comparing values or addresses (Java is frustrating)
 *   4. Don't alter the parent nodes while searching the tree (create new nodes for the children)
 */

import java.io.*;
import java.util.*;

public class chain {
	public static void main(String args[]) throws FileNotFoundException {
//		String abcd = "abcdab";
//		System.out.println(abcd.replaceFirst("ab", ""));
		Scanner s = new Scanner(new FileReader("chain.in"));
		
		while (s.hasNextInt()) {
			int chainLength = s.nextInt();
			if (chainLength == 0) break;
			
			String chainOriginal = s.next();
			
			int numCustomers = s.nextInt();
			ArrayList<Customer> customers = new ArrayList<>();
			for (int i = 0; i < numCustomers; i++) {
				String customerChain = s.next();
				Integer customerPrice = s.nextInt();
//				customers.add(new Customer(customerChain, customerPrice));
				customers.add(new Customer(reverseString(customerChain), customerPrice));
			}
			Collections.sort(customers);
			Collections.reverse(customers);
			
//			for (Customer c : customers) System.out.print(c.price + " ");
//			System.out.println();
			
//			System.out.println(customers.size());
			
//			System.out.println("here");
			
			Queue<String> chainQ = new LinkedList<>();
			chainQ.add(new String(chainOriginal));
			
			Queue<Integer> priceQ = new LinkedList<>();
			priceQ.add(new Integer(0));
			
			Integer maxPrice = 0;
			
			while (!chainQ.isEmpty()) {
				String tempChain = chainQ.poll();
				Integer tempPrice = priceQ.poll();
				
				for (Customer c : customers) {
//					System.out.println(c.chain);
					if (tempChain.contains(c.chain)) {
						String newChain = new String(tempChain.replaceFirst(c.chain, ""));
						Integer newPrice = new Integer(tempPrice + c.price);
						
						chainQ.add(new String(newChain));
						priceQ.add(new Integer(newPrice));
						
						if (newPrice > maxPrice) {
							maxPrice = newPrice;
							System.out.print(maxPrice + " ");
						}
					}
				}
			}
			
			System.out.println(maxPrice);
		}
		
		s.close();
	}
	
	public static String reverseString(String str) {
		String temp = "";
		for (int i = str.length() - 1; i >= 0; i--) temp += str.charAt(i);
		return temp;
	}
}

//class ChainString {
//	String chain;
//	
//	public ChainString(String c) {
//		chain = c;
//	}
//	
//	public ChainString(ChainString c) {
//		chain = c.chain;
//	}
//	
//	public boolean doesHave(String c) {
//		return chain.contains(c);
//	}
//	
//	public boolean doesHaveReverse(String c) {
//		String rc = "";
//		for (int i = c.length() - 1; i >= 0; i--) {
//			rc += c.charAt(i);
//		}
//		return chain.contains(rc);
//	}
//	
//	public void extract(String c) {
//		if (doesHave(c)) {
//			chain.replaceFirst(c, "");
//		} else if (doesHaveReverse(c)) {
//			String rc = "";
//			for (int i = c.length() - 1; i >= 0; i--) {
//				rc += c.charAt(i);
//			}
//			chain.replaceFirst(rc, "");
//		}
//	}
//}

class Customer implements Comparable<Customer> {
	String chain;
	int price;
	
	public Customer(String c, int p) {
		chain = c;
		price = p;
	}
	
	public int compareTo(Customer compareCustomer) {
		if (this.price - compareCustomer.price > 0) return -1;
		else return +1;
	}
}
