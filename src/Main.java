import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Ryan on 10/24/2017.
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the name of the input file.");
        loadFile(input.nextLine());
    }

    private static void loadFile(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            int row = 0;
            int rowMax = lineCount(fileName);
            int colMax = lineWidth(fileName);
            char[][] maze = new char[rowMax][colMax];
            System.out.println("Line Count: " + lineCount(fileName) + " Line Width: " + lineWidth(fileName));
            while ((line = br.readLine()) != null) {
                if (!(line.equals(""))) {
                    System.out.println(line);
                    //removes spaces from line before parsing
                    line = line.replace(" ", "");
                    for (int col = 0; col < colMax; col++) {
                        maze[row][col] = line.charAt(col);
                    }
                    row++;
                }
            }
            System.out.println("\nMaze \"" + fileName + "\" loaded.\n");
            MazeRunner mazeRunner = new MazeRunner(maze);
        } catch (IOException exception) {
            System.out.println("The system cannot find the file specified.");
        }
    }

    private static int lineCount(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            int result = 0;
            String line;
            while ((line = br.readLine()) != null) {
                if (!(line.equals(""))) {
                    result++;
                }
            }
            return result;
        } catch (IOException exception) {
            System.out.println("The system cannot find the file specified.");
        }
        return -1;
    }

    private static int lineWidth(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            if ((line = br.readLine()) != null) {
                line = line.replace(" ", "");
                return line.length();
            }
        } catch (IOException exception) {
            System.out.println("The system cannot find the file specified.");
        }
        return -1;
    }
}
