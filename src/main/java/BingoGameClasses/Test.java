package BingoGameClasses;

/**
 *
 * @author zahid
 */
public class Test {

    public static void main(String[] args) {
        BingoGameController bgm = new BingoGameController();
        //LinkedList list = new LinkedList();
        //BingoLinkedList<Integer> tombalaCard = BingoGameController.linkedListTombalaKartlariOlustur();
        BingoLinkedList<Integer> list = bgm.randomCardNumberGenerator();

        for (int i = 0; i < list.size; i++) {
            System.out.print(list.get(i) + " ");

            if (i == 4 || i == 9) {
                System.out.println();
            }
        }

    }
}
