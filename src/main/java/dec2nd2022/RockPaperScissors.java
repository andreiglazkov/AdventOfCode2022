package dec2nd2022;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) throws FileNotFoundException {
        final File file = new File("input-files/dec2nd2022.txt");
        final Scanner scanner = new Scanner(file);
        int partOneScore = 0;
        int partTwoScore = 0;

        /*  A, X - Rock (+1 if I choose it)
         *  B, Y - Paper (+2 if I choose it)
         *  C, Z - Scissors (+3 if I choose it)
         *
         *  Lost = 0, Draw = 3, Won = 6
         *
         */

        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] splittedLine = line.split(" ");
            String movePlayer1 = splittedLine[0];
            String myMove = splittedLine[1];
            int roundOutcome = 0;
            int countForShape = 0;
            int countForShapePartTwo = 0;
            int roundOutcomePartTwo = 0;

            switch (movePlayer1) {
                case "A":
                    switch (myMove) {
                        case "X":
                            countForShape = 1;
                            roundOutcome = 3;

                            countForShapePartTwo = 3;
                            break;
                        case "Y":
                            countForShape = 2;
                            roundOutcome = 6;

                            countForShapePartTwo = 1;
                            roundOutcomePartTwo = 3;
                            break;
                        case "Z":
                            countForShape = 3;
                            countForShapePartTwo = 2;
                            roundOutcomePartTwo = 6;
                            break;
                    }
                    break;

                case "B":
                    switch (myMove) {
                        case "X":
                            countForShape = 1;
                            countForShapePartTwo = 1;
                            break;
                        case "Y":
                            countForShape = 2;
                            roundOutcome = 3;
                            countForShapePartTwo = 2;
                            roundOutcomePartTwo = 3;
                            break;
                        case "Z":
                            countForShape = 3;
                            roundOutcome = 6;
                            countForShapePartTwo = countForShape;
                            roundOutcomePartTwo = 6;
                            break;
                    }
                    break;

                case "C":
                    switch (myMove) {
                        case "X":
                            countForShape = 1;
                            roundOutcome = 6;
                            countForShapePartTwo = 2;
                            break;
                        case "Y":
                            countForShape = 2;
                            roundOutcomePartTwo = 3;
                            countForShapePartTwo = 3;
                            break;
                        case "Z":
                            countForShape = 3;
                            roundOutcome = 3;
                            roundOutcomePartTwo = 6;
                            countForShapePartTwo = 1;
                            break;
                    }
                    break;
            }
            partOneScore += (countForShape + roundOutcome);
            partTwoScore += (countForShapePartTwo + roundOutcomePartTwo);
        }
        System.out.println("Part one score: " + partOneScore);
        System.out.println("Part two score: " + partTwoScore);
    }
}
