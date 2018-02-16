# Pineapple Pyramid

A closed warehouse of limited height wants to store cube-shaped pineapples in a pyramid form. The pyramid has a square base of B<sup>2</sup> pineapples, and each layer is 1 pineapple smaller than the one below it (which means the second layer has (B-1)<sup>2</sup> pineapples).

Since the warehouse has a limited height, it is required sometimes to have a larger base (higher B), such that it is possible to store all the pineapples in a limited amount of layers.

### Input
The "pyramid.in" file has a number of test cases, each of the test cases contains information about the pineapples and the warehouse. The information is given as three integers separated by spaces: P (length of one of the pineapple edges), H (height of the warehouse), and N (number of pineapples). Test cases are preceded with an empty line. The end of the input is determined with 3 space-separated zeros.

### Output
For each of the test cases, the output should print the B value (base edge size). Test cases should be printed in separate lines.

### Example
Given the following input:
```
10 101 1000
10 110 1000
10 300 25000
0 0 0
```

The output should be:
```
15
14
43
```
