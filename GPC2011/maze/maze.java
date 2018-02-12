package maze;

import java.util.*;
import java.io.*;

public class maze {
	static int maze[][];
	static Queue<Position> positions;
	static Queue<Position> path;
	static ArrayList<Position> visited;

	public static void main(String args[]) throws IOException {
		Scanner s = new Scanner(new FileReader("maze.in"));

		int numTests = s.nextInt();

		for (int test = 0; test < numTests; test++) {
			int w = s.nextInt();
			int h = s.nextInt();

			// System.out.println("Maze: " + w + " " + h);

			maze = new int[w][h];
			for (int col = 0; col < w; col++) {
				for (int row = 0; row < h; row++) {
					maze[col][row] = s.nextInt();
				}
			}

			positions = new LinkedList<>();
			path = new LinkedList<>();
			visited = new ArrayList<>();

			Position root = new Position(0, 0, w, h, visited);
			positions.add(root); // Enqueue the root
			visited.add(root);
			int step = maze[0][0];
			Position p;
			do {
				p = positions.poll(); // Dequeue
				path.add(p); // Enqueue to the path

				// Enqueue the children
				step = maze[p.y][p.x];
				Position up = new Position(p.x, p.y - step, w, h, visited);
				Position dn = new Position(p.x, p.y + step, w, h, visited);
				Position rt = new Position(p.x + step, p.y, w, h, visited);
				Position lt = new Position(p.x - step, p.y, w, h, visited);

				if (up.v) positions.add(up);
				if (dn.v) positions.add(dn);
				if (rt.v) positions.add(rt);
				if (lt.v) positions.add(lt);
			} while (step != -1 && positions.size() > 0);

			if (maze[p.x][p.y] == -1) {
				Stack<Position> pathS = new Stack<>();
				while (!path.isEmpty()) {
					pathS.push(path.poll());
				}

				Stack<Position> actualPath = new Stack<>();

				Position child = pathS.pop();
				actualPath.push(child);
				while (!pathS.isEmpty()) {

					if (child.isStepFrom(pathS.peek(), maze[pathS.peek().y][pathS.peek().x])) {
						child = pathS.pop();
						actualPath.push(child);
					} else {
						pathS.pop();
					}
				}
				while (!actualPath.isEmpty()) {
					System.out.print(actualPath.pop() + " ");
				}
			} else {
				System.out.println("No Solution Possible.");
			}
			System.out.println();
			System.out.println();
		}
		s.close();
	}

}

class Position {
	int x; // x-position
	int y; // y-position
	boolean v; // validity

	Position(int x, int y) {
		this.x = x;
		this.y = y;
		this.v = true;
	}

	Position(int x, int y, int w, int h, ArrayList<Position> p) {
		Position temp = new Position(x, y);
		for (int i = 0; i < p.size(); i++) {
			if (temp.equals(p.get(i))) {
				x = -2;
				break;
			}
		}
		if (x < 0 || x >= w || y < 0 || y >= h) {
			this.v = false;
			return;
		} else {
			this.x = x;
			this.y = y;
			this.v = true;
			p.add(this);
		}
	}

	public boolean equals(Position p) {
		return (this.x == p.x && this.y == p.y);
	}

	public boolean isStepFrom(Position p, int step) {
		if (this.x - step == p.x && this.y == p.y)
			return true;
		if (this.x + step == p.x && this.y == p.y)
			return true;
		if (this.x == p.x && this.y - step == p.y)
			return true;
		if (this.x == p.x && this.y + step == p.y)
			return true;
		return false;
	}

	public String toString() {
		return "(" + x + " " + y + ")";
	}
}
