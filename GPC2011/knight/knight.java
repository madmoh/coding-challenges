package knight;

import java.util.*;
import java.io.*;

public class knight {
	public static void main(String args[]) throws IOException {
		Scanner s = new Scanner(new FileReader("knight.in"));
		
		int numTests = s.nextInt();
		
		for (int test = 0; test < numTests; test++) {
			int S = s.nextInt(); // size
			
			char grid[][] = new char[S][S];
			Position curPos = new Position(0, 0, 0, 'K', 0);
			int numX = 0;
			for (int row = 0; row < S; row++) {
				String states = s.next();
				for (int col = 0; col < S; col++) {
					grid[row][col] = states.charAt(col);
					if (grid[row][col] == 'K') curPos = new Position(row, col, S, grid[row][col], 0);
					if (grid[row][col] == 'X') numX++;
				}
			}
			
			int numMaxAllowedMoves = numX;
			
			Queue<Position> posQueue = new LinkedList<>();
			ArrayList<Position> posVisited = new ArrayList<>();
			posQueue.add(curPos);
			
			while (!posQueue.isEmpty() && curPos.level <= numMaxAllowedMoves && numX > 0) {
				curPos = posQueue.poll();
				posVisited.add(curPos);
//				System.out.println(curPos);
				if (curPos.state == 'X') numX--;
				
				int xPos[] = {
					curPos.x + 1, curPos.x + 2,
					curPos.x + 2, curPos.x + 1,
					curPos.x - 1, curPos.x - 2,
					curPos.x - 2, curPos.x - 1
				};
				int yPos[] = {
					curPos.y - 2, curPos.y - 1,
					curPos.y + 1, curPos.y + 2,
					curPos.y + 2, curPos.y + 1,
					curPos.y - 1, curPos.y - 2
				};
				for (int i = 0; i < 8; i++) {
					if (xPos[i] < 0 || xPos[i] >= S || yPos[i] < 0 || yPos[i] >= S) continue;
					
					Position nextPos = new Position(xPos[i], yPos[i], S, grid[yPos[i]][xPos[i]], curPos.level + 1);
					boolean toAdd = true;
					if (nextPos.state != 'X') toAdd = false;
					for (int j = 0; j < posVisited.size(); j++) {
						if (nextPos.x == posVisited.get(j).x && nextPos.y == posVisited.get(j).y) {
							toAdd = false;
							break;
						}
					}
					if (toAdd) posQueue.add(nextPos);
				}
				
//				if (posQueue.isEmpty()) System.out.println("queue is empty");
//				if (curPos.level > numMaxAllowedMoves) System.out.println("exceeded maximum moves");
//				if (numX <= 0) System.out.println("got rid of all X");
			}
			
			if (numX == 0) System.out.println("Y");
			else System.out.println("N");
		}
		
		s.close();
	}
}

class Position {
	int x;
	int y;
	int s;
	char state;
	int level;
	
	Position(int x, int y, int s, char state, int level) {
		this.x = x;
		this.y = y;
		this.s = s;
		this.state = state;
		this.level = level;
	}
	
//	public String toString() {
//		return "(" + x + ", " + y + ") level: " + level;
//	}
}