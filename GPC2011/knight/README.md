# Knight's Game

There is a claim that a single knight in an MxM chessboard can visit N chess pieces in N moves, such that N is in the range of [M, M<sup>2</sup>). The knight moves in a rotated or flipped L-letter shape. In other words, it can move 2 steps north, east, south, or west, and then move 1 step in the perpendicular direction. It is required to write a program that verifies or denies the claim, given the knight's position and the chessboard layout.

### Input
The "knight.in" file starts with the number of test cases. Each of the test cases starts with the size of the chessboard (`M` value), followed by the chessboard layout, given as M lines of M letters, the letters are `K` (knight's initial position), `X` (spot to be attacked), or `E` (empty spot). The M value is at least 3.

### Output
For each of the test cases, the output should print `Y` if all the positions marked by `X` can be attacked in N moves, or `N` otherwise.

### Example
Given the following input:
```
2
3
KXE
EEX
XEE
4
XXEE
EKEE
EEEE
EXXE
```

The output should be:
```
Y
N
```
