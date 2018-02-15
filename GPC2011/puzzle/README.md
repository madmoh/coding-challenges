# Neighboring Letters Puzzle

In a puzzle, a sequence of pairs of letters is given. It is required to form a string of the letter pairs, such that the neighboring letters of consecutive pairs match. The puzzle rules do not allow swapping the letters of a pair, and it requires that, if more than one solution is possible, the chosen solution must have the closest order of appearance to the given sequence.

For example, given `AL CA LC`, there are 3 solutions:

1. `AL LC CA`
2. `CA AL LC`
3. `LC CA AL`

However, the first solution must be chosen because it is the closest to the given sequence.

### Input
The "puzzle.in" file starts with the number of test cases. Each of the test cases starts with the number of letter groups, followed by the sequence of letter pairs separated by spaces. All letters given are capital. Test cases are preceded with an empty line.

### Output
For each of the test cases, the output should print the solution of the puzzle. If there is no solution, simply print `-1`. Groups should be separated with a space. Test cases should be separated with empty lines.

### Example
Given the following input:
```
3

3
AB XA BX

5
FG EF AB HE GH

5
MN AB NR BC RA
```

The output should be:
```
AB BX XA

-1

MN NR RA AB BC
```
