package dec1st2022;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CalorieCounting {
    public static void main(String[] args) throws FileNotFoundException {
        final File file = new File("input-files/dec1st2022.txt");
        Scanner scanner = new Scanner(file);
        List<Elf> elves = new ArrayList<>();
        int number = 0;
        int backSpace = 0;
        long calories = 0;

        while (scanner.hasNext()) {
            String caloriesEntry = scanner.nextLine();

            if (caloriesEntry.length() != 0) {
                calories += Long.parseLong(caloriesEntry);
            } else {
                Elf elf = new Elf(number, calories);
                elves.add(elf);
                number++;
                calories = 0;
            }
        }

        Elf strongestElf = findStrongestElf(elves);
        System.out.println("Number of strongest elf: " + strongestElf.getNumber() + " He's carrying " + strongestElf.getCalories() + " calories!");
        List<Elf> strongestElves = findTopStrongestElves(elves, 3);
        System.out.println("Sum of calories carried by strongest elves: " + sumOfStrongestElves(strongestElves));
    }

    public static Elf findStrongestElf(List<Elf> elves) {
        long maxCalories = elves.get(0).getCalories();
        Elf elf = new Elf(0, 0);

        for (Elf e : elves) {
            if (e.getCalories() > maxCalories) {
                maxCalories = e.getCalories();
                elf.setNumber(e.getNumber());
                elf.setCalories(e.getCalories());
            }
        }
        return elf;
    }

    public static List<Elf> findTopStrongestElves(List<Elf> elves, int amount) {
        List<Elf> strongestElves = new ArrayList<>();

        while (strongestElves.size() < amount) {
            var strongestElf = findStrongestElf(elves);
            strongestElves.add(strongestElf);
            elves.removeIf(elf -> elf.equals(strongestElf));
        }
        return strongestElves;
    }

    public static long sumOfStrongestElves(List<Elf> elves) {
        return elves.stream().mapToLong(Elf::getCalories).sum();
    }
}
