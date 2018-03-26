/*
 * Level: easy
 * Time to read problem and solve: 0:25
 *   - Reading problem and figuring a solution: 5 minutes
 *   - Writing initial solution: 15 minutes
 *   - Solving bugs: 5 minutes
 * Concepts:
 *   1. UX-related system development
 * To remember:
 *   1. Forget anything about efficiency (unless explicitly stated or required)
 */

import java.io.*;
import java.util.*;

public class keyboard {
	public static void main(String args[]) throws FileNotFoundException {
		Scanner s = new Scanner(new FileReader("keyboard.in"));
		
		char keyboard[][] = {
			{'1', '2', '3'},
			{'4', '5', '6'},
			{'7', '8', '9'},
			{'*', '0', '#'},
		};
		
		int T = s.nextInt();
		
		for (int t = 0; t < T; t++) {
			System.out.println((t + 1));
			int R = s.nextInt();
			int S = s.nextInt();
			
			for (int sen = 0; sen < S; sen++) {
				String inputString = s.next();
				int y = 1, x = 1;
				
				for (int i = 0; i < inputString.length(); i++) {
					char input = inputString.charAt(i);
					
					if (y > 0 &&
							(input == 'U' && R == 0 ||
							input == 'R' && R == 90 ||
							input == 'D' && R == 180 ||
							input == 'L' && R == 270)) y--;
					if (x < 2 &&
							(input == 'R' && R == 0 ||
							input == 'D' && R == 90 ||
							input == 'L' && R == 180 ||
							input == 'U' && R == 270)) x++;
					if (y < 3 &&
							(input == 'D' && R == 0 ||
							input == 'L' && R == 90 ||
							input == 'U' && R == 180 ||
							input == 'R' && R == 270)) y++;
					if (x > 0 &&
							(input == 'L' && R == 0 ||
							input == 'U' && R == 90 ||
							input == 'R' && R == 180 ||
							input == 'D' && R == 270)) x--;
					if (input == 'K' && keyboard[y][x] != '*' && keyboard[y][x] != '#') {
						System.out.print(keyboard[y][x]);
					}
					
				}
				System.out.println();
			}
		}
		
		s.close();
	}
}
