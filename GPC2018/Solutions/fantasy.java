/*
 * Level: difficult
 * Time to read problem and solve: 0:45
 *   - Reading problem and figuring a solution: 5 minutes
 *   - Writing initial solution (deleted): 20 minutes
 *   - Writing second solution: 20 minutes
 *   - Solving bugs: 0 minutes
 * Concepts:
 *   1. Tree search (uninformed, DFS)
 *   2. Recursively permute arbitrary number of objects (alternative solution)
 * To remember:
 *   1. Instead of making a class that holds values related to a node, save the values in new Queues or Stacks
 *   2. Using Queue or Stack for graph search works like magic
 *   3. In search, consider whether main Queue or Stack is node-based or path-based
 *   4. Easier sorting method (instead of "implements Comparable<>...")
 *   	- Collections.sort(objectArrayList, (o1, o2) -> o1.attribute1.compareTo(o2.attribute1));
 *   	- Assuming attribute1:
 *   		1. Is an object
 *   		2. Implements compareTo
 */

import java.io.*;
import java.util.*;

public class fantasy {
	public static void main(String args[]) throws FileNotFoundException {
//		Player p1 = new Player(1, 2);
//		Player p2 = new Player(3, 4);
//		Player p3 = new Player(5, 6);
//		Player p4 = new Player(7, 8);
//		ArrayList<Player> pal = new ArrayList<>();
//		pal.add(p1); pal.add(p2); pal.add(p3); pal.add(p4);
//		System.out.println(pal.contains(p1));
		
		Scanner s = new Scanner(new FileReader("fantasy.in"));
		
		int T = s.nextInt();
		
		for (int t = 0; t < T; t++) {
			
			System.out.print((t + 1) + ". ");
			
			int B = s.nextInt(); // Budget
			int N = s.nextInt(); // Total number of players 
			int K = s.nextInt(); // Number of players required in the team
						
			ArrayList<Player> players = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				players.add(new Player(s.nextInt(), s.nextDouble()));
			}
			
//			System.out.println();
//			if (t + 1 != 15) continue;
			
			
			// Check if possible
			Collections.sort(players, (p1, p2) -> p1.cost.compareTo(p2.cost));
			double sumCostMinK = 0;
			for (int i = 0; i < K; i++) {
				sumCostMinK += players.get(i).cost;
			}
			if (sumCostMinK > B) {
				System.out.print("Impossible");
				System.out.println();
				continue;
			}
			
			// Possible... get maxPoints
			Collections.sort(players, (p1, p2) -> p2.points.compareTo(p1.points));
			
			Stack<ArrayList<Player>> playersS = new Stack<>();
			ArrayList<Player> playersInitial = new ArrayList<>();
			playersInitial.add(new Player(0, 0));
			playersS.add(playersInitial);
			
			Stack<Integer> pointsS = new Stack<>();
			pointsS.push(new Integer(0));
			
			Stack<Double> costS = new Stack<>();
			costS.push(new Double(0));
			
			Stack<Integer> levelS = new Stack<>();
			levelS.push(new Integer(0));
			
			boolean found = false;
			Integer maxPoints = new Integer(0);
			
			while (!playersS.isEmpty() && !found) {
				ArrayList<Player> tempPlayers = playersS.pop();
				Integer tempPoints = pointsS.pop();
				Double tempCost = costS.pop();
				Integer tempLevel = levelS.pop();
				
				if (tempCost <= B && tempLevel == K && tempPoints > maxPoints) {
					maxPoints = new Integer(tempPoints);
//					System.out.println(maxPoints);
					found = true;
				}
				
				for (int j = players.size() - 1; j >= 0; j--) {
					Player newPlayer = players.get(j);
					
					if (tempPlayers.contains(newPlayer)) continue;
					
					ArrayList<Player> newPlayers = new ArrayList<>(tempPlayers);
					newPlayers.add(newPlayer);
					Integer newPoints = new Integer(tempPoints + newPlayer.points);
					Double newCost = new Double(tempCost + newPlayer.cost);
					Integer newLevel = new Integer(tempLevel + 1);
					
					if (newCost <= B && newLevel <= K) {
						playersS.push(newPlayers);
						pointsS.push(newPoints);
						costS.push(newCost);
						levelS.push(newLevel);
					}
				}
			}
			
//			System.out.print(B + " " + N + " " + K + " ");
			System.out.print(maxPoints);
			System.out.println();
		}
		
		s.close();
	}
}

class Player {
	Integer points;
	Double cost;
//	Double ratio;
		
	public Player(int p, double c) {
		points = p;
		cost = c;
//		ratio = new Double(points) / cost;
	}
	
	public Player(Player p) {
		points = p.points;
		cost = p.cost;
	}
	
	public String toString() {
		return points + " " + cost;
	}
}