package BingoGameClasses;

import java.util.Random;

/**
 *
 * @author zahid
 */
public class BingoGameController {

    public static BingoLinkedList<Integer> randomCardNumberGenerator() {

        BingoLinkedList<Integer> allNumbers = new BingoLinkedList<>();
        BingoLinkedList<Integer> cardNumbers = new BingoLinkedList<>();

        Random rand = new Random();

        for (int j = 0; j < 3; j++) {
            // Add all numbers 1-90 to the list
            for (int i = 1; i <= 90; i++) {
                allNumbers.addToEnd(i);
            }

            for (int i = 0; i < 5; i++) {
                int index = rand.nextInt(allNumbers.size);
                int selectedNumber = allNumbers.get(index);

                while (cardNumbers.contains(selectedNumber)) {
                    index = rand.nextInt(allNumbers.size);
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
        sortSubList(cardNumbers, 0, 4);
        sortSubList(cardNumbers, 5, 9);
        sortSubList(cardNumbers, 10, 14);
        return cardNumbers;

    }

    public static void sortSubList(BingoLinkedList<Integer> list, int start, int end) {
        for (int i = start; i <= end; i++) {
            for (int j = i + 1; j <= end; j++) {
                if (list.get(i) > list.get(j)) {
                    // Swap işlemi
                    int temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }
    }

}
