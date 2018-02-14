# Perfect Roads

The chief of transportation department wants the road network to be 'perfect', where all roads are straight, and no road can intersect with another. Roads have an ID, cartesian coordinates of starting and ending points, length, and number of intersections. The following table shows a list of 6 intersecting roads:

| ID  | x<sub>1</sub> | y<sub>1</sub> | x<sub>2</sub> | y<sub>2</sub> | Length | Number of Intersections |
| --- | ---           | ---           | ---           | ---           | ---    | ---                     |
| 0   | 0             | 4             | 12            | 4             | 12     | 2                       |
| 1   | 11            | 2             | 5             | 5.5           | 6.95   | 4                       |
| 2   | 10            | 2.5           | 12            | 2.5           | 2      | 2                       |
| 3   | 1.1           | 8             | 1.1           | 0             | 8      | 1                       |
| 4   | 10.1          | 0.8           | 10            | 2.8           | 2      | 2                       |
| 5   | 4.5           | 3             | 12            | 3             | 7      | 1                       |

### Input
The "perfect.in" file starts with the number of test cases. Each of the test cases starts with the number of roads, followed by the coordinates of each of the roads, given as `x1 y1 x2 y2`. The ID of the roads are implicitly given based on their input order (first road has ID of 0, second road has ID of 1, and so on). Test cases are preceded with an empty line.

### Output
For each of the test cases, the output should print the road with most intersections, followed by the next road with most intersections but with length smaller or equal to the first road. If multiple roads have the same number of intersections, they should be sorted based on their lengths in descending order. If multiple roads have the same number of intersections and length, they should be sorted based on their IDs in ascending order. Roads displayed must be printed to show the ID, the length (accuracy of 2 decimal places), and the number of intersections. In case all roads don't intersect with any other road, print `This is a perfect network!` for the test case.

### Example
Given the following input:
```
3

8
-2 8 8 8
-2 4 8 4
-2 2 8 2
-2 0 8 0
-2 -10 -2 -2
0 -10 0 -2
2 -10 2 -2
4 -10 4 3

5
-4 4 4 4
-6 3 6 3
-8 2 8 2
-10 0 10 0
0 -1 0 5

6
-1 4.5 1 4.5
-4 4 4 4
-6 3 6 3
-8 2 8 2
-10 0 10 0
-1 5 1 5
```

The output should be:
```
7 13.00 2
2 10.00 1
3 10.00 1

4 6.00 4

This is a perfect network!
```
