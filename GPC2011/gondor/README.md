# Battle of Gondor

The Kingdom of Rensor attacked The State of Gondor with `N` number of battleships. The commander in chief of Gondor has to respond by destroying `3` of the battleships. Some of the unattacked battleships will be thwarted and indirectly destroyed if they are inside the area covered by the three directly destroyed battleships. Therefore, it is required to know what is the maximum number of battleships that can be destroyed (regardless whether they were directly or indirectly attacked).

### Input
The "gondor.in" file starts with the number of test cases. Each of the test cases starts with the number of battleships, followed by the X and Y coordinates of each of the battleships. Test cases are preceded with an empty line.

### Output
For each of the test cases, the output should print the message `Maximum battleships that can be destroyed: S`, where `S` is the total number of battleships that can be destroyed.

### Example
Given the following input:
```
2

6
0 0
5 0
3 3
-5 -4
10 -4
3 20

6
10 10
20 10
15 0
13 13
50 50
50 60
```

The output should be:
```
Maximum battleships that can be destroyed: 6
Maximum battleships that can be destroyed: 5
```
