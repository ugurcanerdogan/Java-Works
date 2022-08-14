// Uğurcan Erdoğan - Technical Questionnaire - SW Development Intern
// ugurcanerdogan3306@gmail.com

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        int[][] inputArray = create2DIntMatrixFromFile(Paths.get("input.txt"));
        System.out.println("Maximum path of the summation pyramid : " + engine(inputArray));
    }

    // Dynamic Programming solution (bottom-up approach)
    static int engine(int[][] myArray) {

        // Since we will use the bottom-up approach, we first need to check the prime status of the lowest leaf nodes.
        // This pre-control is necessary because priming control is not provided to the leaf nodes in the first step of engine function.
        for (int z = 0; z < myArray[myArray.length - 1].length; z++) {
            myArray[myArray.length - 1][z] = isNotPrime(myArray[myArray.length - 1][z]) ? myArray[myArray.length - 1][z] : 0;
        }

        // start counting
        for (int lengthIndex = myArray.length - 1; lengthIndex > 0; lengthIndex--)
            for (int i = 0; i < myArray[lengthIndex].length - 1; i++) {
                if ((lengthIndex == 1) || isNotPrime(myArray[lengthIndex - 1][i])) {    // check if the current value is prime or not
                    // if it is not prime, try to find max value of the root node's children.
                    myArray[lengthIndex - 1][i] += Math.max(myArray[lengthIndex][i], myArray[lengthIndex][i + 1]);
                } else {
                    myArray[lengthIndex - 1][i] = 0;    // set 0, useless.
                }
            }
        return myArray[0][0]; // return max sum value
    }


    static public int[][] create2DIntMatrixFromFile(Path path) throws IOException {
        // file to 2d array function that uses java 8 stream api
        return Files.lines(path).map((l) -> l.trim().split("\\s+")).map((sa) -> Stream.of(sa).mapToInt(Integer::parseInt).toArray()).toArray(int[][]::new);
    }

    static boolean isNotPrime(int num) {
        // not prime checker function
        if (num <= 1) return true;

        for (int i = 2; i < num; i++)
            if (num % i == 0) return true;

        return false;
    }
}

