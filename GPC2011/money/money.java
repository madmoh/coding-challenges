package money;

import java.util.*;
import java.io.*;

public class money {
	public static void main(String args[]) throws IOException {
		Scanner s = new Scanner(new FileReader("money.in"));
		
		int numTests = s.nextInt();
		
		for (int i = 0; i < numTests; i++) {
			int A = s.nextInt();
			int M = s.nextInt();
			
			String line = "";
			while (line.isEmpty() && s.hasNextLine()) {
				line = s.nextLine();
			}
			
			Scanner n = new Scanner(line);
			int coins[] = new int[M];
			for (int j = 0; j < coins.length; j++) {
				coins[j] = n.nextInt();
			}
			n.close();
			
			if (coins.length == 0) System.out.println(0);
			else System.out.println(numComb(coins, A) + "\n");
		}
		
		s.close();
	}
	
	public static int[] subArray(int array[], int start, int end) {
		int temp[] = new int[end - start + 1];
		for (int i = 0; i < temp.length; i++) {
			temp[i] = array[i + start];
		}
		return temp;
	}
	
	public static int numComb(int coins[], int amount) {
		if (coins.length == 1) {
			return (amount % coins[0] == 0) ? 1 : 0;
		} else if (amount == 0) {
			return 1;
		} else if (amount < coins[0]) {
			return 0;
		} else {
			return numComb(subArray(coins, 0, coins.length - 2), amount)
					+ numComb(coins, amount - coins[coins.length - 1]);
		}
	}
}
