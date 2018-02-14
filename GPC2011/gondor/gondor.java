package gondor;

import java.util.*;
import java.io.*;

public class gondor {
	public static void main(String args[]) throws IOException {
		Scanner s = new Scanner(new FileReader("gondor.in"));

		int numTests = s.nextInt();

		for (int test = 0; test < numTests; test++) {
			int numBS = s.nextInt();

			ArrayList<Point> bs = new ArrayList<>();
			for (int i = 0; i < numBS; i++) {
				bs.add(new Point(s.nextDouble(), s.nextDouble()));
			}

			int maxBInside = 0;
			for (int i = 0; i < bs.size(); i++) {
				for (int j = 0; j < bs.size(); j++) {
					if (j == i) continue;
					for (int k = 0; k < bs.size(); k++) {
						if (k == i || k == j) continue;
						
						int bInside = 0;
						for (int n = 0; n < bs.size(); n++) {
							if (n == i || n == j || n == k) continue;
							double fullArea = area(bs.get(i), bs.get(j), bs.get(k));
							double partialArea1 = area(bs.get(i), bs.get(j), bs.get(n));
							double partialArea2 = area(bs.get(i), bs.get(n), bs.get(k));
							double partialArea3 = area(bs.get(n), bs.get(j), bs.get(k));
							if (fullArea == partialArea1 + partialArea2 + partialArea3) {
								bInside++;
							}
						}
						if (bInside > maxBInside) maxBInside = bInside;
					}
				}
			}
			maxBInside += 3;

			System.out.println("Maximum battleships that can be destroyed: " + maxBInside);
		}

		s.close();
	}

	static double area(Point a, Point b, Point c) {
		return Math.abs((float)((a.x * (b.y - c.y) + b.x * (c.y - a.y) + c.x * (a.y - b.y)) / 2));
	}
}

class Point {
	double x;
	double y;

	Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
}