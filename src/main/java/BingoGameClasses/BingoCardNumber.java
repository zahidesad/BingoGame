package BingoGameClasses;

import java.util.Random;

/**
 *
 * @author zahid
 */
public class BingoCardNumber {

    public static BingoLinkedList<Integer> cardNumberGenerator() {
        BingoLinkedList<Integer> unsortedList = randomNumberGenerator();
        BingoLinkedList<Integer> sortedList = new BingoLinkedList<>();
        int index = 0, col = 0, row = 0;

        while (sortedList.size() < 15) {
            int currentNumber = unsortedList.get(index);
            int numberRange = currentNumber / 10;

            if (col == 0) {
                sortedList.addByIndex(row * 5, currentNumber);
                unsortedList.remove(currentNumber);
                col++;
                continue;
            }

            boolean placed = false;
            for (int i = row * 5; i < (row * 5) + col; i++) {
                int sortedNumberRange = sortedList.getWithDownNode(i) / 10;

                if (numberRange == sortedNumberRange) {
                    index++;
                    placed = true;
                    break;
                } else if (numberRange < sortedNumberRange) {
                    sortedList.addByIndex(i, currentNumber);
                    unsortedList.remove(currentNumber);
                    col++;
                    placed = true;
                    break;
                }
            }

            if (!placed) {
                sortedList.addByIndex((row * 5) + col, currentNumber);
                unsortedList.remove(currentNumber);
                col++;
            }

            if (col == 5) {
                col = 0;
                index = 0;
                row++;
            }
        }

        return sortedList;
    }

    public static BingoLinkedList<Integer> randomNumberGenerator() {
        BingoLinkedList<Integer> allNumbers = new BingoLinkedList<>();
        BingoLinkedList<Integer> cardNumbers = new BingoLinkedList<>();
        Random rand = new Random();

        for (int j = 0; j < 3; j++) {
            // Add all numbers 1-90 to the list
            for (int i = 1; i <= 90; i++) {
                allNumbers.addToEnd(i);
            }
            for (int i = 0; i < 5; i++) {

                int index = rand.nextInt(allNumbers.size());
                int selectedNumber = allNumbers.get(index);

                while (cardNumbers.contains(selectedNumber)) {
                    index = rand.nextInt(allNumbers.size());
                    selectedNumber = allNumbers.get(index);
                }
                cardNumbers.addToEnd(selectedNumber);
                allNumbers.remove(selectedNumber);

                int lowerBound = (selectedNumber / 10) * 10;
                int upperBound = lowerBound + 10;

                allNumbers.removeIf(n -> (n >= lowerBound && n < upperBound));

            }
            allNumbers.clear();
        }
        BingoLinkedList<Integer> rearrangedCardNumbers = rearrangeNumbers(cardNumbers);
        return rearrangedCardNumbers;
    }

    //If there are 3 numbers in the same range, put them first
    public static BingoLinkedList<Integer> rearrangeNumbers(BingoLinkedList<Integer> cardNumbers) {
        BingoLinkedList<Integer> rearrangedNumbers = new BingoLinkedList<>();
        int[] counts = new int[10];

        // Count numbers in each 10's range
        for (Integer num : cardNumbers) {
            int rangeIndex = num / 10;
            counts[rangeIndex]++;
        }

        // Check for triplets in each 10's range
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] >= 3) {
                int lowerBound = i * 10;
                int upperBound = lowerBound + 10;
                for (Integer num : cardNumbers) {
                    if (num >= lowerBound && num < upperBound) {
                        rearrangedNumbers.addToFirst(num);
                    }
                }
            }
        }

        // Add remaining numbers
        for (Integer num : cardNumbers) {
            if (!rearrangedNumbers.contains(num)) {
                rearrangedNumbers.addToEnd(num);
            }
        }
        return rearrangedNumbers;
    }

}
