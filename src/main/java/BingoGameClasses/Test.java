package BingoGameClasses;

/**
 *
 * @author zahid
 */
public class Test {

    public static void main(String[] args) {
        BingoGameController bgm = new BingoGameController();

        //BingoLinkedList<Integer> tombalaCard = BingoGameController.linkedListTombalaKartlariOlustur();
        bgm.randomCardGenerator();

    }
}
