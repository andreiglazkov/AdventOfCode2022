package dec3rd2022;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RucksackReorganization {
    static final CharListManager charListManager = new CharListManager();

    public static void main(String[] args) throws FileNotFoundException {
        final File file = new File("input-files/dec3rd2022.txt");
        final Scanner scanner = new Scanner(file);
        final List<String> allGroups = new ArrayList<>();

        int sum = 0;
        int wrongCharValue;

        while (scanner.hasNextLine()) {

            String line = scanner.nextLine();
            String firstHalf = line.substring(0, line.length() / 2);
            String secondHalf = line.substring(line.length() / 2);
            allGroups.add(line);

            wrongCharValue = getCharValue(firstHalf, secondHalf);
            sum += wrongCharValue;
        }
        System.out.println("Sum of priorities of the items: " + sum);
        System.out.println("Sum of badges: " + getSumOfBadges(allGroups));
    }

    public static int getCharValue(String firstHalf, String secondHalf) {
        char commonChar;
        int charValue = 0;
        boolean continueSearch = true;

        for (int i = 0; i < firstHalf.length() && continueSearch; i++) {
            for (int j = 0; j < secondHalf.length() && continueSearch; j++) {
                if (firstHalf.charAt(i) == secondHalf.charAt(j)) {
                    commonChar = secondHalf.charAt(j);
                    charValue = getCharValue(commonChar);
                    continueSearch = false;
                }
            }
        }
        return charValue;
    }

    public static int getCharValue(char c) {
        return charListManager.characterList.indexOf(c) + 1;
    }

    public static char getCommonChar(String line1, String line2, String line3) {
        char commonChar = 0;
        List<Character> commonCharacters = new ArrayList<>();

        //compare line1 & line2
        for (int i = 0; i < line1.length(); i++) {
            for (int j = 0; j < line2.length(); j++) {
                if (line1.charAt(i) == line2.charAt(j) && !commonCharacters.contains(line1.charAt(i))) {
                    commonCharacters.add(line1.charAt(i));
                }
            }
        }

        //find common parts with the third line
        for (int i = 0; i < line3.length(); i++) {
            if (commonCharacters.contains(line3.charAt(i))) {
                commonChar = line3.charAt(i);
            }
        }
        return commonChar;
    }

    public static int getSumOfBadges(List<String> allGroups) {
        char commonChar;
        int sumOfBadges = 0;

        for (int i = 0; i < allGroups.size(); i++) {
            System.out.println(allGroups.get(i));
            if (i % 3 == 0) {
                if (i != 0) {
                    commonChar = getCommonChar(allGroups.get(i), allGroups.get(i - 1), allGroups.get(i - 2));
                    System.out.println("Common char " + commonChar + " Value: " + getCharValue(commonChar));
                    sumOfBadges += getCharValue(commonChar);
                }
            }
        }
        return sumOfBadges;
    }
}
