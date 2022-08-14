import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        int[][] maze = null;
        int[] sizes = new int[2];
        int[] goal = new int[2];

        try {
            File myObj = new File(args[0]);
            Scanner myReader = new Scanner(myObj);

            String strSize = myReader.nextLine();
            String[] strSizeArray = strSize.split(" ");
            sizes[0] = Integer.parseInt(strSizeArray[0]);
            sizes[1] = Integer.parseInt(strSizeArray[1]);

            maze = new int[sizes[0]][sizes[1]];
            for (int i = 0; i < sizes[0]; i++) {
                String mazeRow = myReader.nextLine();
                String[] mazeRowArray = mazeRow.split(" ");
                int columnIndex = 0;
                for (String value : mazeRowArray) {
                    maze[i][columnIndex] = Integer.parseInt(value);
                    columnIndex += 1;
                }
            }

            String goalLine = myReader.nextLine();
            String[] goalArray = goalLine.split(" ");
            goal[0] = Integer.parseInt(goalArray[0]);
            goal[1] = Integer.parseInt(goalArray[1]);


            myReader.close();
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


        System.out.println(solve(maze, goal, sizes));


    }

    public static int solve(int[][] maze, int[] goal, int[] sizes) {

        if (maze[0][0] == 1) {
            return 0;
        }
        int rowNum = goal[0] + 1;
        int colNum = goal[1] + 1;

        if (maze.length < goal[0] || maze[0].length < goal[1]) {
            return 0;
        }
        int[][] newBoard = new int[rowNum][colNum];

        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                if (maze[i][j] != 1) newBoard[i][j] = maze[i][j];
                else newBoard[i][j] = -1;
            }
        }
        boolean isXFound = false;
        for (int i = 0; i < rowNum; i++) {

            if (newBoard[i][0] != -1) {

                if (!isXFound) newBoard[i][0] = 1;
                else newBoard[i][0] = -1;

            } else {
                isXFound = true;
            }
        }

        boolean isYFound = false;
        for (int j = 0; j < colNum; j++) {
            if (newBoard[0][j] != -1) {

                if (!isYFound) newBoard[0][j] = 1;
                else newBoard[0][j] = -1;

            } else {
                isYFound = true;
            }
        }

        for (int i = 1; i < rowNum; i++) {
            for (int j = 1; j < colNum; j++) {
                if (newBoard[i][j] != -1) {
                    if (newBoard[i - 1][j] == -1 && newBoard[i][j - 1] != -1) {
                        newBoard[i][j] = newBoard[i][j - 1];
                    } else if (newBoard[i][j - 1] == -1 && newBoard[i - 1][j] != -1) {
                        newBoard[i][j] = newBoard[i - 1][j];
                    } else if (newBoard[i][j - 1] != -1 && newBoard[i - 1][j] != -1) {
                        newBoard[i][j] = newBoard[i - 1][j] + newBoard[i][j - 1];
                    } else {
                        newBoard[i][j] = -1;
                    }
                }
            }
        }
        if (newBoard[rowNum - 1][colNum - 1] != -1) {
            return newBoard[rowNum - 1][colNum - 1];
        } else return 0;
    }
}
