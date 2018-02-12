# The Cavalier Number Maze

The Cavalier number maze is a grid of WIDTHxHEIGHT elements that contain integer values representing the number of steps that can be taken in the North, East, South, or West directions. The maze starts from the 0x0 element (top left), and the goal of it is to reach the element of value -1 in the shortest possible path.

### Example


Given the grid above, the shortest path to move from position (0, 0) to (5, 5) is:
(0, 0) (5, 0) (5, 4) (1, 4) (1, 1) (4, 1) (4, 3) (4, 5) (4, 2) (0, 2) (0, 1) (3, 1) (3, 5) (5, 5)

### Input
The "maze.in" file starts with the number of test cases. Each of the test cases start with the dimensions of the maze grid (WIDTH then HEIGHT), followed by the grid of WIDTHxHEIGHT elements. Test cases are preceded with an empty line.

### Output
For each of the test cases, the output should be the shortest path as `(0 0) (x_1 y_1) (x_2 y_2) ... (x_n y_n)` if there exists a valid path. Otherwise, the output should be `No Solution Possible.`. Test cases should be separated by an empty line.
