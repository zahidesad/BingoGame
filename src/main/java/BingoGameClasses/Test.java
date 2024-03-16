package BingoGameClasses;

/**
 *
 * @author zahid
 */
public class Test {

    public static void main(String[] args) {
        BingoGameController bgm = new BingoGameController();
        //bgm.CardNumbersGenerator();

        BingoLinkedList<BingoLinkedList<Integer>> tombalaCard = bgm.createTombalaCard();
        for (int i = 0; i < tombalaCard.size; i++) {
            BingoLinkedList<Integer> row = tombalaCard.get(i);
            for (int j = 0; j < row.size; j++) {
                int number = row.get(j);
                System.out.print(number + " ");
            }
            System.out.println();
        }
    }
}
