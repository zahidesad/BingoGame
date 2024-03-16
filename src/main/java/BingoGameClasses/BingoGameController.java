package BingoGameClasses;

import static java.lang.Math.random;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author zahid
 */
public class BingoGameController {

    Random random = new Random();

    public BingoLinkedList<BingoLinkedList<Integer>> createTombalaCard() {
        BingoLinkedList<BingoLinkedList<Integer>> card = new BingoLinkedList<>();
        BingoLinkedList<Integer> usedNumbers = new BingoLinkedList<>();

        for (int i = 0; i < 3; i++) {
            BingoLinkedList<Integer> row = new BingoLinkedList<>();
            for (int j = 0; j < 5; j++) {
                int number;
                do {
                    number = random.nextInt(90) + 1;
                } while (usedNumbers.contains(number) || rowContainsNumberInSameRange(row, number));

                usedNumbers.addToEnd(number);
                row.addToEnd(number);
            }
            sortRow(row);
            card.addToEnd(row);
        }
        return card;
    }

    private boolean rowContainsNumberInSameRange(BingoLinkedList<Integer> row, int number) {
        int lowerBound = (number - 1) / 10 * 10;
        int upperBound = lowerBound + 9;

        for (int i = 0; i < row.size; i++) {
            int num = row.get(i);
            if (num >= lowerBound && num <= upperBound) {
                return true;
            }
        }

        return false;
    }

    private void sortRow(BingoLinkedList<Integer> row) {
        for (int i = 0; i < row.size; i++) {
            for (int j = i + 1; j < row.size; j++) {
                if (row.get(i) > row.get(j)) {
                    int temp = row.get(i);
                    row.set(i, row.get(j));
                    row.set(j, temp);
                }
            }
        }
    }
}
