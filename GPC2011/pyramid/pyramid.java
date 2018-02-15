package pyramid;

import java.io.*;
import java.util.*;

public class pyramid {
	public static void main(String args[]) throws IOException {
		Scanner s = new Scanner(new FileReader("pyramid.in"));
		
		while (s.hasNextLine()) {
			int P = s.nextInt();
			int H = s.nextInt();
			int N = s.nextInt();
			if (P == 0 && H == 0 && N == 0) break;
			
			int start = 0;
			while (squaredSumForIndices(start, H / P + start) < N) {
				System.out.println(H / P + start);
				start++;
				
			}
			System.out.println(H / P + start);
			System.out.println();
		}
		
		s.close();
	}
	
	public static int squaredSumForIndices(int start, int end) {
		int n = 0;
		while (end > start) {
			n += end * end;
			end--;
		}
		return n;
	}
	
	public static int indexForSquaredSum(int n) {
		int i = 0;
		while (n > 0) {
			i++;
			n -= i * i;
		}
		return i;
	}
}
