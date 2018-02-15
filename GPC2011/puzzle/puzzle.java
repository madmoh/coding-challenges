package puzzle;

import java.io.*;
import java.util.*;

public class puzzle {
	public static void main(String args[]) throws IOException {
		Scanner s = new Scanner(new FileReader("puzzle.in"));
		
		int numTests = s.nextInt();
		
		for (int test = 0; test < numTests; test++) {
			int numGroups = s.nextInt();
			
			ArrayList<String> groups = new ArrayList<>();
			for (int group = 0; group < numGroups; group++) {
				groups.add(s.next());
			}
			
			Queue<String> groupsSequence = new LinkedList<>();
			
			for (int group = 0; group < numGroups; group++) {
				ArrayList<String> groupsCopy = new ArrayList<>(groups);
				Stack<String> groupsStack = new Stack<>();
				groupsStack.push(groupsCopy.get(group));
				groupsCopy.remove(group);
				
				groupsSequence.clear();
				
				String lastGroup;
				while (!groupsStack.isEmpty() && groupsSequence.size() < numGroups) {
					lastGroup = groupsStack.pop();
					groupsSequence.add(lastGroup);
					
					for (int i = 0; i < groupsCopy.size(); i++) {
						if (lastGroup.charAt(1) == groupsCopy.get(i).charAt(0)) {
							groupsStack.push(groupsCopy.get(i));
							groupsCopy.remove(i);
						}
					}
				}
				
				if (groupsSequence.size() == numGroups)
					break;
			}
			
			
			if (groupsSequence.size() == numGroups) {
				while (!groupsSequence.isEmpty())
					System.out.print(groupsSequence.poll() + " ");
				System.out.println();
			} else {
				System.out.println(-1);
			}
			System.out.println();
		}
		
		s.close();
	}
}