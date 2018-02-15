# -1 +i Representation

Like the binary representation of numerical values, the (-1 +i) representation uses the complex number (-1 +i) as the radix, where i is the imaginary number (i<sup>2</sup> = -1). The general representation of any complex number using the (-1 +i) base is expressed as X = a<sub>0</sub>(-1 +i)<sup>0</sup> + a<sub>1</sub>(-1 +i)<sup>1</sup> + a<sub>2</sub>(-1 +i)<sup>2</sup> + a<sub>3</sub>(-1 +i)<sup>3</sup> + ..., where a<sub>0</sub>, a<sub>1</sub>, a<sub>2</sub>, a<sub>3</sub>... are either 0 or 1.

For example, the complex number (-1 -i) is represented as 110, because (-1 -i) = (0)(-1 +i)<sup>0</sup> + (1)(-1 +i)<sup>1</sup> + (1)(-1 +i)<sup>2</sup>.

For a given complex number, it is required to write the -1 +i representation of it as the series of a<sub>0</sub>, a<sub>1</sub>, a<sub>2</sub>, a<sub>3</sub>...

### Input
The "i1rep.in" file starts with the number of test cases. Each of the test cases has a complex number (a +ib) given as two numbers, the first one is `a`, and the second one is `b`. For all given test cases, `a` and `b` are integers.

### Output
For each of the test cases, the output should print the sequence of a<sub>0</sub>, a<sub>1</sub>, a<sub>2</sub>, a<sub>3</sub>... that represent the given complex number. The output should not show any additional zeros to the left of the representation.

### Example
Given the following input:
```
3
-1 -1
2 1
1 3
```

The output should be:
```
110
1111
1010
```
