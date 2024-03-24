package BingoGameClasses;

import java.awt.Color;
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
    private BingoLinkedList<Player> players;

    public Game(int playerCount) {
        this.playerCount = playerCount;
        this.players = new BingoLinkedList<>();
        for (int i = 0; i < playerCount; i++) {
            players.addToEnd(new Player());
        }
    }

    public int getPlayerCount() {
        return playerCount;
    }

    public void setPlayerCount(int playerCount) {
        this.playerCount = playerCount;
    }

    public Player getPlayer(int index) {
        if (index < 0 || index >= players.size()) {
            return null; // veya uygun bir hata işlemi yapabilirsiniz
        }
        return players.get(index);
    }

    public int playersLength() {
        return players.size();
    }

    public void setCardNumbers(int playerCount) {
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

        BingoLinkedList<Integer> cardNumbers = new BingoLinkedList<>();
        cardNumbers = BingoCardNumber.cardNumberGenerator();

        return cardNumbers;
    }

    private void setPlayerCardNumbers(Player player, BingoLinkedList<Integer> cardNumbers) {
        int numberIndex = 0;
        int number = cardNumbers.get(numberIndex);
        int numberColumnIndex = number / 10;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                player.playerCard.getWithDownNode((i * 9) + (number != 90 ? numberColumnIndex : numberColumnIndex - 1)).setText(Integer.toString(number));
                numberIndex++;
                if (numberIndex >= cardNumbers.size()) {
                    continue;
                }
                number = cardNumbers.getWithDownNode(numberIndex);
                numberColumnIndex = number / 10;
            }
        }
    }

    public void checkNumbers(int playerCount, JLabel numberLabel, JLabel[] bingoLabels, JFrame jFrame) {
        int number = Integer.parseInt(numberLabel.getText());

        for (int j = 0; j < players.size(); j++) {
            Player player = players.get(j);
            JLabel bingoLabel = bingoLabels[j];
            for (int i = 0; i < player.playerCard.size(); i++) {
                String text = player.playerCard.getWithDownNode(i).getText().trim();
                if (!text.isEmpty()) {
                    int parsedNumber = Integer.parseInt(text);
                    if (parsedNumber == number) {
                        player.playerCard.getWithDownNode(i).setIsFound(true);
                        player.playerCard.getWithDownNode(i).setColor(new Color(255, 153, 153));
                        player.checkStatus();
                        switch (player.status) {
                            case NO_BINGO:
                                bingoLabel.setText("NO BINGO");
                                break;
                            case FIRST_BINGO:
                                bingoLabel.setText("FIRST BINGO");
                                break;
                            case SECOND_BINGO:
                                bingoLabel.setText("SECOND BINGO");
                                break;
                            case BINGO:
                                bingoLabel.setText("BINGO");
                                break;
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
