package BingoGameClasses;

/**
 *
 * @author zahid
 */
public class Test {

    public static void main(String[] args) {
        BingoCardNumber bgm = new BingoCardNumber();
        BingoLinkedList<Integer> list1 = bgm.cardNumberGenerator();
        BingoLinkedList<Integer> list2 = bgm.cardNumberGenerator();
        BingoLinkedList<Integer> list3 = bgm.cardNumberGenerator();
        BingoLinkedList<Integer> list4 = bgm.cardNumberGenerator();

        for (int i = 0; i < list1.size(); i++) {
            System.out.print(list1.getWithDownNode(i) + " ");

            if (i == 4 || i == 9) {
                System.out.println("");
            }
        }

        System.out.println("");
        System.out.println("");
        for (int i = 0; i < list2.size(); i++) {
            System.out.print(list2.getWithDownNode(i) + " ");

            if (i == 4 || i == 9) {
                System.out.println("");
            }
        }

        System.out.println("");
        System.out.println("");
        for (int i = 0; i < list3.size(); i++) {
            System.out.print(list3.getWithDownNode(i) + " ");

            if (i == 4 || i == 9) {
                System.out.println("");
            }
        }

        System.out.println("");
        System.out.println("");
        for (int i = 0; i < list4.size(); i++) {
            System.out.print(list4.getWithDownNode(i) + " ");

            if (i == 4 || i == 9) {
                System.out.println("");
            }
        }

        System.out.println("");
        System.out.println("");
    }
}
