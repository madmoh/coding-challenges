package profit;

import java.io.*;
import java.util.*;

public class profit {
	public static void main(String args[]) throws IOException {
		Scanner in = new Scanner(new FileReader("profit.in"));
		
		int numTests = in.nextInt();
		
		for (int i = 0; i < numTests; i++) {
			int numYears = in.nextInt();
			
			float profit[] = new float[numYears];
			for (int j = 0; j < numYears; j++) {
				profit[j] = in.nextFloat();
			}
			maxProfit(profit);
			
		}
		
		in.close();
	}
	
	static void maxProfit(float p[]) {
		int maxP = 0;
		int from = 0;
		int to = 0;
		for (int i = 0; i < p.length; i++) {
			for (int j = i + 1; j < p.length; j++) {
				int curP = 0;
				for (int x = i; x <= j; x++) {
					curP += p[x];
				}
				if (curP > maxP) {
					maxP = curP;
					from = i + 1;
					to = j + 1;
				}
			}
		}
		if (maxP <= 0) {
			maxP = 0;
			from = to = -1;
		}
		System.out.println(maxP + " " + from + " " + to);
	}
}
