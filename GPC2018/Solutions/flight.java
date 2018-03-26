/*
 * Level: easy
 * Time to read problem and solve: 0:15
 *   - Reading problem and figuring a solution: 5 minutes
 *   - Writing initial solution: 5 minutes
 *   - Solving bugs: 5 minutes
 * Concepts:
 *   1. Time-based calculations
 * To remember:
 *   1. For time-based calculations, always consider extreme cases and unexpected input
 */

import java.io.*;
import java.util.*;

public class flight {
	public static void main(String args[]) throws FileNotFoundException {
		Scanner s = new Scanner(new FileReader("flight.in"));
		
		int T = s.nextInt();
		
		for (int t = 0; t < T; t++) {
			String hm1 = s.next();
			int hh1 = Integer.parseInt(hm1.substring(0, 2));
			int mm1 = Integer.parseInt(hm1.substring(3));
			String gmt1 = s.next();
			int dd1 = Integer.parseInt(gmt1.substring(0, 3));
			
			String hm2 = s.next();
			int hh2 = Integer.parseInt(hm2.substring(0, 2));
			int mm2 = Integer.parseInt(hm2.substring(3));
			String gmt2 = s.next();
			int dd2 = Integer.parseInt(gmt2.substring(0, 3));
			
			int t1 = hh1 * 60 + mm1 - dd1 * 60;
			int t2 = hh2 * 60 + mm2 - dd2 * 60;
			
			int diff = t2 - t1;
			if (diff < 0) diff = 24 * 60 + diff;
			if (diff > 24 * 60) diff -= 24 * 60;
			
			String diffH = "" + (diff / 60);
			String diffM = "" + (diff % 60);
			if (diffM.length() == 1) diffM = "0" + diffM;
			
			System.out.println((t + 1) + ". " + diffH + ":" + diffM);
		}
		
		s.close();
	}
}
