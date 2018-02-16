# 16 Beads Game

The 16 beads game has a layout of 4 rows of beads, where the first row has 1 bead, the second row has 3 beads, the third row has 5 beads, and the fourth row has 7 beads, as shown below:
```
   ○
  ○○○
 ○○○○○
○○○○○○○
```
The game is turn-based, and played by two players. In one move, a player must remove at least one bead out of one row. Beads removed should be consecutive. It is possible to start removing the beads from the middle of the row. The player who takes the last bead loses the game.

After a number of moves, it becomes possible to determine who of the two players can certainly win the game if the player plays perfectly. For example, consider the following state of the game:
```
   ○
  ●●○
 ●●●●●
●●●●●○○
```
It can be guaranteed that the player of the next turn can win with 100% certainty if all moves are done perfectly. Because removing only one bead of the fourth row will force the other player to eventually lose the game.

### Input
The "beads.in" file starts with the number of test cases. Each of the test cases has 4 strings that determine the state of the game (letter `O`: present bead, letter `X`: removed bead). The following 2 strings determine the names of the players, the first of which is going to play next.

### Output
For each of the test cases, the output should print the name of the player who can win with certainty.

### Example
Given the following input:
```
4
O XXO XXXXX XXXXXOO A B
O XXO XXXXX XXXXXOO B A
O XXO XXXXX XXXXXXX A B
X XXX XXXXX OOOOOOO A B
```

The output should be:
```
A
B
A
A
```
