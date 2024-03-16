package BingoGameClasses;

import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author zahid
 */
public class BingoGameController {


    /*Random random = new Random();

    public BingoLinkedList<Integer> cardNumberGenerator() {
        BingoLinkedList<Integer> bll = new BingoLinkedList<>();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                int origin = (j == 0) ? 1 : ((Math.floorDiv(bll.tail.data, 10) + 1) * 10);
                int boundry = (5 + j) * 10;

                int num = random.nextInt(origin, boundry);
                if (bll.contains(num)) {
                    j--;
                    continue;
                }

                System.out.print(num + " ");
                bll.addToEnd(num);
            }
            System.out.println();
        }

        return bll;
    }*/
    // Yardımcı metod: Verilen aralıkta, daha önce kullanılmamış rastgele bir sayı üretir.
    /*private static int rastgeleSayiUret(BingoLinkedList<Integer> kullanilanlar, int altSinir, int ustSinir) {
        Random random = new Random();
        int rastgeleSayi;
        do {
            rastgeleSayi = random.nextInt(ustSinir - altSinir + 1) + altSinir;
        } while (kullanilanlar.contains(rastgeleSayi));
        kullanilanlar.addToEnd(rastgeleSayi);
        return rastgeleSayi;
    }

    // Tombala kartlarını oluşturan metod
    public static BingoLinkedList linkedListTombalaKartlariOlustur() {
        BingoLinkedList<Integer> kullanilanlar = new BingoLinkedList<>(); // Daha önce kullanılmış sayıları saklayacak liste
        BingoLinkedList<Integer> kartlar = new BingoLinkedList<>(); // Tombala kartını oluşturacak ana liste

        // Her satır için işlem yap
        for (int i = 0; i < 3; i++) {
            BingoLinkedList<Integer> satir = new BingoLinkedList<>(); // Her satır için bir linkedList oluştur

            // Her sütun için işlem yap
            for (int j = 0; j < 5; j++) {
                int altSinir = j * 10 + 1; // Alt sınırdaki sayı 21
                int ustSinir = (j + 1) * 10; // Üst sınırdaki sayı 30
                // Eğer son sütundaysak üst sınıra 90'i dahil et
                if (j == 4) {
                    ustSinir = 90;
                }

                int rastgeleSayi = rastgeleSayiUret(kullanilanlar, altSinir, ustSinir);
                satir.addToEnd(rastgeleSayi);
                System.out.print(rastgeleSayi + " ");
            }
            // Satırı küçükten büyüğe doğru sırala
            satir.sort();
            // Oluşturulan satırı ana karta ekle
            kartlar.addAll(satir);
            System.out.println();
        }
        return kartlar;
    }*/

    public static LinkedList<Integer> randomCardGenerator() {

        LinkedList<Integer> allNumbers = new LinkedList<>();
        LinkedList<Integer> selectedNumbers = new LinkedList<>();

        Random rand = new Random();

        for (int j = 0; j < 3; j++) {
            // 1-90 arası tüm sayıları listeye ekleyelim
            for (int i = 1; i <= 90; i++) {
                allNumbers.add(i);
            }

            for (int i = 0; i < 5; i++) {
                int index = rand.nextInt(allNumbers.size());
                int selectedNumber = allNumbers.get(index);

                while (selectedNumbers.contains(selectedNumber)) {
                    index = rand.nextInt(allNumbers.size());
                    selectedNumber = allNumbers.get(index);
                }

                selectedNumbers.add(selectedNumber);
                allNumbers.remove(Integer.valueOf(selectedNumber));

                int lowerBound = (selectedNumber / 10) * 10;
                int upperBound = lowerBound + 10;

                allNumbers.removeIf(n -> (n >= lowerBound && n < upperBound));
                System.out.print(selectedNumber + " ");
            }

            allNumbers.clear();
            System.out.println();
        }
        return selectedNumbers;

    }

}
