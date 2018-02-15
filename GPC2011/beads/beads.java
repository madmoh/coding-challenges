package beads;

import java.io.*;
import java.util.*;

public class beads {
	public static void main(String args[]) throws IOException {
		Scanner s = new Scanner(new FileReader("beads.in"));
		
		int numTests = s.nextInt();
		
		for (int test = 0; test < numTests; test++) {
			String row[] = new String[4];
			for (int i = 0; i < row.length; i++) {
				row[i] = s.next();
			}
			
			String player1 = s.next();
			String player2 = s.next();
			
			int numOpportunityRows = 0;
			int numNotFullRows = 0;
			int numSingularRows = 0;
			for (int i = 0; i < row.length; i++) {
				if (row[i].charAt(row[i].length() - 1) == 'O') {
					numNotFullRows++;
					if (row[i].length() > 1 && row[i].charAt(row[i].length() - 2) == 'O') {
						numOpportunityRows++;
					} else {
						numSingularRows++;
					}
				}
			}
			
			if (numOpportunityRows == 1 && numNotFullRows % 2 == 1) {
				System.out.println(player1);
				
			} else if (numOpportunityRows == 1 && numNotFullRows % 2 == 0) {
				System.out.println(player2);
				
			} else if (numOpportunityRows == 0 && numSingularRows % 2 == 1) {
				System.out.println(player2);
				
			} else if (numOpportunityRows == 0 && numSingularRows % 2 == 0) {
				System.out.println(player1);
				
			} else {
				System.out.println("Uncertain");
			}
		}
		
		s.close();
	}
}
