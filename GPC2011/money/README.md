# Number of Coin Combinations

The Central Bank is issuing a new series of `N` number of coins of values c<sub>1</sub>, c<sub>2</sub>, ..., c<sub>N</sub>. The bank wants to study the number of coin combinations (regardless of the order) that can sum to a certain amount `A` of money, assuming there is an infinite supply of each currency. Write a program that, given the series of coins and an amount of money, can find out how many combinations of these coins can form that specific amount of money.

For example, the series of `3` number of coins of values `2, 3, 5`, can form the amount of money `9` using the following combinations:
* 9 = 2 + 2 + 2 + 3
* 9 = 2 + 2 + 5
* 9 = 3 + 3 + 3

### Input
The "money.in" file starts with the number of test cases. Each of the test cases starts with the amount of money `A` and the number of coins `N`, followed by the value of each of the coins. Test cases are preceded with an empty line.

### Output
For each of the test cases, the output should print the number of combinations. Test cases should be separated by an empty line.

### Example
Given the following input:
```
3

5 3
1 2 3

9 2
2 3

6 0
```

The output should be:
```
5

2

0
```
