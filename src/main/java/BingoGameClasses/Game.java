package BingoGameClasses;

import java.awt.Color;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author zahid
 */
public class Game {

    public static final int MAX_PLAYERS = 4;
    private int playerCount;
    private final BingoLinkedList<Player> players;

    private int currentIndex;
    private int index = 0;
    private int[] randomPermutation = {6,15,36,67,74,21,34,55,65,90,3,10,50,64,73}; // <---------------------------------- Please write your own numbers.

    public Game(int playerCount) {
        this.playerCount = playerCount;
        this.players = new BingoLinkedList<>();
        for (int i = 0; i < playerCount; i++) {
            players.addToEnd(new Player());
        }
    }

    public int[][][] manuelTombalaCardGeneretor() { // <-------------------------- Please write your own card numbers
        int[][] card1
                = {{5, -1, 22, -1, 45, -1, 60, 73, -1},
                {-1, 10, -1, 31, 47, 58, 68, -1, -1},
                {-1, 17, 26, 38, -1, -1, -1, 79, 86}};

        int[][] card2
                = {{8, -1, 21, -1, 43, -1, 64, -1, 88},
                {-1, 13, 28, -1, -1, 54, 67, -1, 85},
                {2, -1, -1, 35, -1, 52, 62, 72, -1}};

        int[][] card3
                = {{2, 10, -1, -1, 48, -1, -1, 77, 88},
                {1, -1, 23, 34, -1, -1, 60, 78, 84},
                {3, 16, -1, -1, 40, -1, 62, 71, -1}};

        int[][] card4
                = {{6, 15, -1, 36, -1, -1, 67, 74, -1},
                {-1, -1, 21, 34, -1, 55, 65, -1, 90},
                {3, 10, -1, -1, -1, 50, 64, 73, -1}};

        int[][][] allCards = {card1, card2, card3, card4};
        return allCards;
    }

    public int getPlayerCount() {
        return playerCount;
    }

    public void setPlayerCount(int playerCount) {
        this.playerCount = playerCount;
    }

    public Player getPlayer(int index) {
        if (index < 0 || index >= players.size()) {
            return null;
        }
        return players.get(index);
    }

    public int playersLength() {
        return players.size();
    }

    public void updateAndCheckBingoNumber(boolean isRandom, JLabel numberLabel, BingoLinkedList<JLabel> statusBingoLabel, JFrame jFrame) {
        if (isRandom) {
            int nextNumber = this.getNextNumber();
            numberLabel.setText(String.valueOf(nextNumber));
            checkNumbers(playerCount, numberLabel, statusBingoLabel, jFrame);
        } else if (!isRandom && index < randomPermutation.length) {
            numberLabel.setText(String.valueOf(randomPermutation[index++]));
            checkNumbers(playerCount, numberLabel, statusBingoLabel, jFrame);
        } else {
            index = 0;
        }
    }

    public void initializePermutation(int n) {
        randomPermutation = generatePermutation(n);
        currentIndex = 0;
    }

    public int getNextNumber() {
        if (currentIndex >= randomPermutation.length) {
            randomPermutation = generatePermutation(randomPermutation.length);
            currentIndex = 0;
        }
        int nextNumber = randomPermutation[currentIndex];
        currentIndex++;
        return nextNumber;
    }

    public int[] generatePermutation(int n) {
        int[] permutation = new int[n];
        for (int i = 0; i < n; i++) {
            permutation[i] = i + 1;
        }
        Random random = new Random();
        for (int i = n - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            int temp = permutation[i];
            permutation[i] = permutation[j];
            permutation[j] = temp;
        }
        return permutation;
    }

    int[][][] allCards = manuelTombalaCardGeneretor();

    public void setCardNumbersManually(int playerCount) {
        Player player;
        for (int p = 0; p < playerCount; p++) {
            player = getPlayer(p);
            if (allCards != null && player != null) {
                setPlayerCardNumbers(player, allCards[p]);
            }
        }
    }

    public void setCardNumbersRandomly(int playerCount) {
        BingoLinkedList<Integer> cardNumbers;
        Player player;
        for (int p = 0; p < playerCount; p++) {
            cardNumbers = getCardNumbers(p);
            player = getPlayer(p);
            if (cardNumbers != null && player != null) {
                setPlayerCardNumbers(player, cardNumbers);
            }
        }
    }

    private BingoLinkedList<Integer> getCardNumbers(int playerIndex) {
        if (playerIndex < 0 || playerIndex >= Game.MAX_PLAYERS) {
            return null;
        }

        BingoLinkedList<Integer> cardNumbers;
        cardNumbers = BingoCardNumber.cardNumberGenerator();

        return cardNumbers;
    }

    private void setPlayerCardNumbers(Player player, BingoLinkedList<Integer> cardNumbers) {
        int numberIndex = 0;
        int number = cardNumbers.get(numberIndex);
        int numberColumnIndex = number / 10;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                player.playerCard.getWithDownNode((i * 9) + numberColumnIndex).setText(Integer.toString(number));
                numberIndex++;
                if (numberIndex >= cardNumbers.size()) {
                    continue;
                }
                number = cardNumbers.getWithDownNode(numberIndex);
                numberColumnIndex = number / 10;
            }
        }
    }

    private void setPlayerCardNumbers(Player player, int[][] cardNumbers) { // Method overloading for generating card numbers using array
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                if (cardNumbers[i][j] != -1) {
                    player.playerCard.getWithDownNode((i * 9) + j).setText(Integer.toString(cardNumbers[i][j]));
                }
            }
        }
    }

    public void checkNumbers(int playerCount, JLabel numberLabel, BingoLinkedList<JLabel> bingoLabels, JFrame jFrame) {
        int number = Integer.parseInt(numberLabel.getText());

        for (int j = 0; j < players.size(); j++) {
            Player player = players.get(j);
            JLabel bingoLabel = bingoLabels.get(j);
            for (int i = 0; i < player.playerCard.size(); i++) {
                if (player.isOver()) {
                    return;
                }
                String text = player.playerCard.getWithDownNode(i).getText().trim();
                if (!text.isEmpty()) {
                    int parsedNumber = Integer.parseInt(text);
                    if (parsedNumber == number) {
                        player.playerCard.getWithDownNode(i).setIsFound(true);
                        player.playerCard.getWithDownNode(i).setColor(new Color(255, 153, 153));
                        player.checkStatus();
                        switch (player.status) {
                            case NO_BINGO ->
                                bingoLabel.setText("NO BINGO");
                            case FIRST_BINGO ->
                                bingoLabel.setText("FIRST BINGO");
                            case SECOND_BINGO ->
                                bingoLabel.setText("SECOND BINGO");
                            case BINGO ->
                                bingoLabel.setText("BINGO");
                        }
                        if (player.isOver()) {
                            bingoLabel.setText("BINGO");
                            JOptionPane.showMessageDialog(jFrame, "PLAYER " + (j + 1) + " WON", "GAME OVER", JOptionPane.INFORMATION_MESSAGE);
                            jFrame.dispose();
                            jFrame.setVisible(false);
                            return;
                        }
                    }
                }
            }
        }
    }
}
