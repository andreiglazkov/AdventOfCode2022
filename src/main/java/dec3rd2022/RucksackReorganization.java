package dec3rd2022;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RucksackReorganization {
    public static void main(String[] args) throws FileNotFoundException {
        final File file = new File("input-files/dec3rd2022.txt");
        final Scanner scanner = new Scanner(file);
        final CharListManager charListManager = new CharListManager();
        int sum = 0;
        int lines = 0;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String firstHalf = line.substring(0, line.length() / 2);
            String secondHalf = line.substring(line.length() / 2);
            char commonChar;
            int charValue = 0;
            boolean continueSearch = true;

            for (int i = 0; i < firstHalf.length() && continueSearch; i++) {
                for (int j = 0; j < secondHalf.length() && continueSearch; j++) {
                    if (firstHalf.charAt(i) == secondHalf.charAt(j)) {
                        commonChar = secondHalf.charAt(j);
                        charValue = charListManager.characterList.indexOf(commonChar) + 1;
                        continueSearch = false;
                    }
                }
            }
            sum += charValue;
        }
        System.out.println("Sum of priorities of the items: " + sum);
    }
}
