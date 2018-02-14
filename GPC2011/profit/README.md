# Period of Highest Profit

A company reported to you its profits of the last `n` number of years. Your task is to find the contiguous period (without skipping any year within the period) such that the accumulated profit is maximum.

### Input
The "profit.in" file starts with the number of test cases. Each of the test cases starts with the number of years, followed by the profit of each of the years. Test cases are preceded with an empty line.

### Output
For each of the test cases, the output should print the accumulated profit, followed by the beginning and the end indices of the profit-maximuzing period. If the accumulated profit is `null` or negative, then display `0`, followed by `-1 -1`.

### Example
Given the following input:
```
3

7 -5 1 3 -1 10 -2 0

9 -2 2 3 4 5 4 3 2 -3

4 -2 -3 0 -1
```

The output should be:
```
13 2 5
23 2 8
0 -1 -1
```
