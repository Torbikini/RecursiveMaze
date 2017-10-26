/**
 * Created by Ryan on 10/24/2017.
 */
public class MazeRunner {
    private char[][] maze;
    private int rowLength;
    private int numOfRows;
    private boolean solved = false;

    public MazeRunner(char[][] maze) {
        this.maze = maze;
        rowLength = maze[0].length;
        numOfRows = maze.length;
        solveMaze();
    }

    public void solveMaze(int row, int column) {
        if(maze[row][column] == 'F') {
            maze[row][column] = 'X';
            System.out.println();
            this.print();
            System.out.println("The maze has been solved!");
            solved = true;
        } else if(!solved && (maze[row][column] == '.' || maze[row][column] == 'S')){
            System.out.println();
            maze[row][column] = 'X';
            this.print();
            if(column < rowLength - 1) {
                solveMaze(row, column + 1);
            }
            if(row < numOfRows - 1) {
                solveMaze(row+1, column);
            }
            if(row > 0 ) {
                solveMaze(row-1, column);
            }
            if(column > 0) {
                solveMaze(row, column - 1);
            }
        }
    }

    public void solveMaze() {
        int row = 0;
        int column = 0;
        for (int r = 0; r <= maze.length - 1; r++) {
            if (r == 0 || r == maze.length - 1) {
                for (int c = 0; c < maze[r].length; c++) {
                    if (maze[r][c] == '.') {
                        row = r;
                        column = c;
                    }
                }
            } else {
                if (maze[r][0] == '.') {
                    row = r;
                    column = 0;
                }
                if (maze[r][maze[r].length - 1] == '.') {
                    row = r;
                    column = maze[r].length - 1;
                }
            }
        }
        // Marks starting location with an S
        maze[row][column] = 'S';
        print();
        solveMaze(row, column);
    }

    public void print() {
        for (int r = 0; r < maze.length; r++) {
            String result = "";
            for (int c = 0; c < maze[r].length; c++) {
                result += maze[r][c];
            }
            System.out.println(result);
        }
    }
}
