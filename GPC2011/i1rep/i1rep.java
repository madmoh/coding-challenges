package i1rep;

import java.io.*;
import java.util.*;

public class i1rep {
	public static void main(String args[]) throws IOException {
		Scanner s = new Scanner(new FileReader("i1rep.in"));
		
		int numTests = s.nextInt();
		
		for (int test = 0; test < numTests; test++) {
			Complex c = new Complex(s.nextInt(), s.nextInt());
			
			Stack<Integer> result = new Stack<>();
			
			while (!c.equals(0, 0)) {
				result.push(c.divide());
			}
			
			while (!result.isEmpty()) {
				System.out.print(result.pop());
			}
			
			System.out.println();
		}
		
		s.close();
	}
}

class Complex {
	int a;
	int b;
	
	Complex(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	public boolean isDivisible() {
		if (a % 2 == 0 ^ b % 2 == 0) return false;
		else return true;
	}
	
	public int divide() {
		if (this.isDivisible()) {
			int tempA = this.a;
			int tempB = this.b;
			
			this.a = (-tempA + tempB) / 2;
			this.b = (-tempA - tempB) / 2;
			
			return 0;
		} else {
			int tempA = this.a;
			int tempB = this.b;
			
			this.a = (-tempA + tempB + 1) / 2;
			this.b = (-tempA - tempB + 1) / 2;
			
			return 1;
		}
	}
	
	public boolean equals(int a, int b) {
		if (this.a == a && this.b == b) return true;
		else return false;
	}
}
