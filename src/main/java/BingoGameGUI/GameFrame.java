package BingoGameGUI;

import javax.swing.ImageIcon;
import BingoGameClasses.*;
import java.awt.Component;
import Custom_GUI_Components.CustomJLabel;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author zahid
 */
public class GameFrame extends javax.swing.JFrame {

    private Game game;
    private int playerCount;

    ImageIcon imageBag = new ImageIcon("bag-image.png");
    // Generate a BingoLinkedList for selecting a random number
    BingoLinkedList<Integer> randomNumbers = new BingoLinkedList<>();
    BingoLinkedList<JLabel> statusBingoLabel;

    public GameFrame(int playerCount) {
        initComponents();
        this.setSize(1172, 615);
        imageLabel.setIcon(imageBag);
        this.playerCount = playerCount;
        this.game = new Game(playerCount);
        setCardsVisibility(playerCount);
        addLabelsToList(playerCount);
        setCardNumbers(playerCount);
    }

    // To get player information
    public Player getPlayer(int index) {
        return game.getPlayer(index);
    }

    protected void setPlayerCount(int playerCount) {
        this.playerCount = playerCount;
    }

    private void setCardsVisibility(int playerCount) {
        // Set the cards and label visibility according to player count
        BingoLinkedList<JLabel> statusLabels = new BingoLinkedList<>();
        statusLabels.addToEnd(player2StatusLabel);
        statusLabels.addToEnd(player3StatusLabel);
        statusLabels.addToEnd(player4StatusLabel);

        BingoLinkedList<JLabel> bingoLabels = new BingoLinkedList<>();
        bingoLabels.addToEnd(Player2BingoLabel);
        bingoLabels.addToEnd(Player3BingoLabel);
        bingoLabels.addToEnd(Player4BingoLabel);

        BingoLinkedList<JPanel> cardPanels = new BingoLinkedList<>();
        cardPanels.addToEnd(Player2CardJPanel);
        cardPanels.addToEnd(Player3CardJPanel);
        cardPanels.addToEnd(Player4CardJPanel);

        statusBingoLabel = new BingoLinkedList<>();
        for (int i = 0; i < playerCount; i++) {
            try {
                String labelName = String.format("Player%dBingoLabel", i + 1);
                JLabel playerLabel = (JLabel) getClass().getDeclaredField(labelName).get(this);
                statusBingoLabel.addToEnd(playerLabel);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        for (int i = playerCount; i < 4; i++) {
            cardPanels.get(i - 1).setVisible(false);
            this.remove(cardPanels.get(i - 1));
            statusLabels.get(i - 1).setVisible(false);
            bingoLabels.get(i - 1).setVisible(false);
        }
        this.revalidate();
        this.repaint();
    }

    private void addLabelsToList(int playerCount) {
        JPanel[] cardPanels = {Player1CardJPanel, Player2CardJPanel, Player3CardJPanel, Player4CardJPanel};
        JLabel[] playerLabels = {player1Label, player2Label, player3Label, player4Label};

        for (int i = 0; i < playerCount; i++) {
            int index = 0;
            getPlayer(i).playerCard = new BingoLinkedList<>();
            Component[] cardComponents = cardPanels[i].getComponents();
            for (Component component : cardComponents) {
                if (component instanceof CustomJLabel && component != playerLabels[i]) {
                    getPlayer(i).playerCard.addByIndex(index, (CustomJLabel) component);
                    index++;
                }
            }
        }
    }

    private void setCardNumbers(int playerCount) {
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

    private void generateRandomPermutation(int boundry) {
        Random random = new Random();
        if (randomNumbers.size() < boundry) {
            int randomNumber;
            do {
                randomNumber = random.nextInt(boundry) + 1;
            } while (randomNumbers.contains(randomNumber));

            randomNumbers.addToEnd(randomNumber);
            numberLabel.setText(Integer.toString(randomNumber));

            JLabel[] bingoLabels = new JLabel[playerCount];
            for (int i = 0; i < playerCount; i++) {
                try {
                    String labelName = String.format("Player%dBingoLabel", i + 1);
                    JLabel playerLabel = (JLabel) getClass().getDeclaredField(labelName).get(this);
                    bingoLabels[i] = playerLabel;
                } catch (NoSuchFieldException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            game.checkNumbers(playerCount, numberLabel, bingoLabels, this);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainJPanel = new javax.swing.JPanel();
        HeaderJPanel = new javax.swing.JPanel();
        HeaderJLabel = new javax.swing.JLabel();
        Player1CardJPanel = new javax.swing.JPanel();
        Card1Circle1 = new Custom_GUI_Components.CustomJLabel();
        Card1Circle2 = new Custom_GUI_Components.CustomJLabel();
        Card1Circle3 = new Custom_GUI_Components.CustomJLabel();
        Card1Circle4 = new Custom_GUI_Components.CustomJLabel();
        Card1Circle5 = new Custom_GUI_Components.CustomJLabel();
        Card1Circle6 = new Custom_GUI_Components.CustomJLabel();
        Card1Circle7 = new Custom_GUI_Components.CustomJLabel();
        Card1Circle8 = new Custom_GUI_Components.CustomJLabel();
        Card1Circle9 = new Custom_GUI_Components.CustomJLabel();
        Card1Circle10 = new Custom_GUI_Components.CustomJLabel();
        Card1Circle11 = new Custom_GUI_Components.CustomJLabel();
        Card1Circle12 = new Custom_GUI_Components.CustomJLabel();
        Card1Circle13 = new Custom_GUI_Components.CustomJLabel();
        Card1Circle14 = new Custom_GUI_Components.CustomJLabel();
        Card1Circle15 = new Custom_GUI_Components.CustomJLabel();
        Card1Circle16 = new Custom_GUI_Components.CustomJLabel();
        Card1Circle17 = new Custom_GUI_Components.CustomJLabel();
        Card1Circle18 = new Custom_GUI_Components.CustomJLabel();
        Card1Circle19 = new Custom_GUI_Components.CustomJLabel();
        Card1Circle20 = new Custom_GUI_Components.CustomJLabel();
        Card1Circle21 = new Custom_GUI_Components.CustomJLabel();
        Card1Circle22 = new Custom_GUI_Components.CustomJLabel();
        Card1Circle23 = new Custom_GUI_Components.CustomJLabel();
        Card1Circle24 = new Custom_GUI_Components.CustomJLabel();
        Card1Circle25 = new Custom_GUI_Components.CustomJLabel();
        Card1Circle26 = new Custom_GUI_Components.CustomJLabel();
        Card1Circle27 = new Custom_GUI_Components.CustomJLabel();
        player1Label = new javax.swing.JLabel();
        Player3CardJPanel = new javax.swing.JPanel();
        Card3Circle1 = new Custom_GUI_Components.CustomJLabel();
        Card3Circle2 = new Custom_GUI_Components.CustomJLabel();
        Card3Circle3 = new Custom_GUI_Components.CustomJLabel();
        Card3Circle4 = new Custom_GUI_Components.CustomJLabel();
        Card3Circle5 = new Custom_GUI_Components.CustomJLabel();
        Card3Circle6 = new Custom_GUI_Components.CustomJLabel();
        Card3Circle7 = new Custom_GUI_Components.CustomJLabel();
        Card3Circle8 = new Custom_GUI_Components.CustomJLabel();
        Card3Circle9 = new Custom_GUI_Components.CustomJLabel();
        Card3Circle10 = new Custom_GUI_Components.CustomJLabel();
        Card3Circle11 = new Custom_GUI_Components.CustomJLabel();
        Card3Circle12 = new Custom_GUI_Components.CustomJLabel();
        Card3Circle13 = new Custom_GUI_Components.CustomJLabel();
        Card3Circle14 = new Custom_GUI_Components.CustomJLabel();
        Card3Circle15 = new Custom_GUI_Components.CustomJLabel();
        Card3Circle16 = new Custom_GUI_Components.CustomJLabel();
        Card3Circle17 = new Custom_GUI_Components.CustomJLabel();
        Card3Circle18 = new Custom_GUI_Components.CustomJLabel();
        Card3Circle19 = new Custom_GUI_Components.CustomJLabel();
        Card3Circle20 = new Custom_GUI_Components.CustomJLabel();
        Card3Circle21 = new Custom_GUI_Components.CustomJLabel();
        Card3Circle22 = new Custom_GUI_Components.CustomJLabel();
        Card3Circle23 = new Custom_GUI_Components.CustomJLabel();
        Card3Circle24 = new Custom_GUI_Components.CustomJLabel();
        Card3Circle25 = new Custom_GUI_Components.CustomJLabel();
        Card3Circle26 = new Custom_GUI_Components.CustomJLabel();
        Card3Circle27 = new Custom_GUI_Components.CustomJLabel();
        player3Label = new javax.swing.JLabel();
        Player4CardJPanel = new javax.swing.JPanel();
        Card4Circle1 = new Custom_GUI_Components.CustomJLabel();
        Card4Circle2 = new Custom_GUI_Components.CustomJLabel();
        Card4Circle3 = new Custom_GUI_Components.CustomJLabel();
        Card4Circle4 = new Custom_GUI_Components.CustomJLabel();
        Card4Circle5 = new Custom_GUI_Components.CustomJLabel();
        Card4Circle6 = new Custom_GUI_Components.CustomJLabel();
        Card4Circle7 = new Custom_GUI_Components.CustomJLabel();
        Card4Circle8 = new Custom_GUI_Components.CustomJLabel();
        Card4Circle9 = new Custom_GUI_Components.CustomJLabel();
        Card4Circle10 = new Custom_GUI_Components.CustomJLabel();
        Card4Circle11 = new Custom_GUI_Components.CustomJLabel();
        Card4Circle12 = new Custom_GUI_Components.CustomJLabel();
        Card4Circle13 = new Custom_GUI_Components.CustomJLabel();
        Card4Circle14 = new Custom_GUI_Components.CustomJLabel();
        Card4Circle15 = new Custom_GUI_Components.CustomJLabel();
        Card4Circle16 = new Custom_GUI_Components.CustomJLabel();
        Card4Circle17 = new Custom_GUI_Components.CustomJLabel();
        Card4Circle18 = new Custom_GUI_Components.CustomJLabel();
        Card4Circle19 = new Custom_GUI_Components.CustomJLabel();
        Card4Circle20 = new Custom_GUI_Components.CustomJLabel();
        Card4Circle21 = new Custom_GUI_Components.CustomJLabel();
        Card4Circle22 = new Custom_GUI_Components.CustomJLabel();
        Card4Circle23 = new Custom_GUI_Components.CustomJLabel();
        Card4Circle24 = new Custom_GUI_Components.CustomJLabel();
        Card4Circle25 = new Custom_GUI_Components.CustomJLabel();
        Card4Circle26 = new Custom_GUI_Components.CustomJLabel();
        Card4Circle27 = new Custom_GUI_Components.CustomJLabel();
        player4Label = new javax.swing.JLabel();
        Player2CardJPanel = new javax.swing.JPanel();
        player2Label = new javax.swing.JLabel();
        Card2Circle1 = new Custom_GUI_Components.CustomJLabel();
        Card2Circle2 = new Custom_GUI_Components.CustomJLabel();
        Card2Circle3 = new Custom_GUI_Components.CustomJLabel();
        Card2Circle4 = new Custom_GUI_Components.CustomJLabel();
        Card2Circle5 = new Custom_GUI_Components.CustomJLabel();
        Card2Circle6 = new Custom_GUI_Components.CustomJLabel();
        Card2Circle7 = new Custom_GUI_Components.CustomJLabel();
        Card2Circle8 = new Custom_GUI_Components.CustomJLabel();
        Card2Circle9 = new Custom_GUI_Components.CustomJLabel();
        Card2Circle10 = new Custom_GUI_Components.CustomJLabel();
        Card2Circle11 = new Custom_GUI_Components.CustomJLabel();
        Card2Circle12 = new Custom_GUI_Components.CustomJLabel();
        Card2Circle13 = new Custom_GUI_Components.CustomJLabel();
        Card2Circle14 = new Custom_GUI_Components.CustomJLabel();
        Card2Circle15 = new Custom_GUI_Components.CustomJLabel();
        Card2Circle16 = new Custom_GUI_Components.CustomJLabel();
        Card2Circle17 = new Custom_GUI_Components.CustomJLabel();
        Card2Circle18 = new Custom_GUI_Components.CustomJLabel();
        Card2Circle19 = new Custom_GUI_Components.CustomJLabel();
        Card2Circle20 = new Custom_GUI_Components.CustomJLabel();
        Card2Circle21 = new Custom_GUI_Components.CustomJLabel();
        Card2Circle22 = new Custom_GUI_Components.CustomJLabel();
        Card2Circle23 = new Custom_GUI_Components.CustomJLabel();
        Card2Circle24 = new Custom_GUI_Components.CustomJLabel();
        Card2Circle25 = new Custom_GUI_Components.CustomJLabel();
        Card2Circle26 = new Custom_GUI_Components.CustomJLabel();
        Card2Circle27 = new Custom_GUI_Components.CustomJLabel();
        ImageJPanel = new javax.swing.JPanel();
        numberLabel = new Custom_GUI_Components.CustomJLabel();
        imageLabel = new javax.swing.JLabel();
        newNumberButton = new Custom_GUI_Components.CustomJButton();
        jPanel1 = new javax.swing.JPanel();
        Player4BingoLabel = new javax.swing.JLabel();
        player2StatusLabel = new javax.swing.JLabel();
        Player1BingoLabel = new javax.swing.JLabel();
        player4StatusLabel = new javax.swing.JLabel();
        player1StatusLabel = new javax.swing.JLabel();
        player3StatusLabel = new javax.swing.JLabel();
        Player2BingoLabel = new javax.swing.JLabel();
        Player3BingoLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MainJPanel.setBackground(new java.awt.Color(95, 158, 160));
        MainJPanel.setMinimumSize(new java.awt.Dimension(1172, 615));
        MainJPanel.setPreferredSize(new java.awt.Dimension(1172, 615));
        MainJPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        HeaderJPanel.setBackground(new java.awt.Color(95, 158, 160));
        HeaderJPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        HeaderJPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        HeaderJLabel.setFont(new java.awt.Font("Stencil", 0, 48)); // NOI18N
        HeaderJLabel.setForeground(new java.awt.Color(0, 0, 0));
        HeaderJLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        HeaderJLabel.setText("BINGO GAME ");
        HeaderJPanel.add(HeaderJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 90));

        MainJPanel.add(HeaderJPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 1080, 90));

        Player1CardJPanel.setBackground(new java.awt.Color(95, 158, 160));
        Player1CardJPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Player1CardJPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Card1Circle1.setForeground(new java.awt.Color(0, 0, 0));
        Card1Circle1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card1Circle1.setBorderColor(new java.awt.Color(255, 255, 255));
        Card1Circle1.setColor(new java.awt.Color(95, 158, 160));
        Card1Circle1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card1Circle1.setRadius(560);
        Player1CardJPanel.add(Card1Circle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 40, 40));

        Card1Circle2.setForeground(new java.awt.Color(0, 0, 0));
        Card1Circle2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card1Circle2.setBorderColor(new java.awt.Color(255, 255, 255));
        Card1Circle2.setColor(new java.awt.Color(95, 158, 160));
        Card1Circle2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card1Circle2.setRadius(560);
        Player1CardJPanel.add(Card1Circle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 40, 40));

        Card1Circle3.setForeground(new java.awt.Color(0, 0, 0));
        Card1Circle3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card1Circle3.setBorderColor(new java.awt.Color(255, 255, 255));
        Card1Circle3.setColor(new java.awt.Color(95, 158, 160));
        Card1Circle3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card1Circle3.setRadius(560);
        Player1CardJPanel.add(Card1Circle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 40, 40));

        Card1Circle4.setForeground(new java.awt.Color(0, 0, 0));
        Card1Circle4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card1Circle4.setBorderColor(new java.awt.Color(255, 255, 255));
        Card1Circle4.setColor(new java.awt.Color(95, 158, 160));
        Card1Circle4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card1Circle4.setRadius(560);
        Player1CardJPanel.add(Card1Circle4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 40, 40));

        Card1Circle5.setForeground(new java.awt.Color(0, 0, 0));
        Card1Circle5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card1Circle5.setBorderColor(new java.awt.Color(255, 255, 255));
        Card1Circle5.setColor(new java.awt.Color(95, 158, 160));
        Card1Circle5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card1Circle5.setRadius(560);
        Player1CardJPanel.add(Card1Circle5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 40, 40));

        Card1Circle6.setForeground(new java.awt.Color(0, 0, 0));
        Card1Circle6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card1Circle6.setBorderColor(new java.awt.Color(255, 255, 255));
        Card1Circle6.setColor(new java.awt.Color(95, 158, 160));
        Card1Circle6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card1Circle6.setRadius(560);
        Player1CardJPanel.add(Card1Circle6, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, 40, 40));

        Card1Circle7.setForeground(new java.awt.Color(0, 0, 0));
        Card1Circle7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card1Circle7.setBorderColor(new java.awt.Color(255, 255, 255));
        Card1Circle7.setColor(new java.awt.Color(95, 158, 160));
        Card1Circle7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card1Circle7.setRadius(560);
        Player1CardJPanel.add(Card1Circle7, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, 40, 40));

        Card1Circle8.setForeground(new java.awt.Color(0, 0, 0));
        Card1Circle8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card1Circle8.setBorderColor(new java.awt.Color(255, 255, 255));
        Card1Circle8.setColor(new java.awt.Color(95, 158, 160));
        Card1Circle8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card1Circle8.setRadius(560);
        Player1CardJPanel.add(Card1Circle8, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, 40, 40));

        Card1Circle9.setForeground(new java.awt.Color(0, 0, 0));
        Card1Circle9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card1Circle9.setBorderColor(new java.awt.Color(255, 255, 255));
        Card1Circle9.setColor(new java.awt.Color(95, 158, 160));
        Card1Circle9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card1Circle9.setRadius(560);
        Player1CardJPanel.add(Card1Circle9, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 30, 40, 40));

        Card1Circle10.setForeground(new java.awt.Color(0, 0, 0));
        Card1Circle10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card1Circle10.setBorderColor(new java.awt.Color(255, 255, 255));
        Card1Circle10.setColor(new java.awt.Color(95, 158, 160));
        Card1Circle10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card1Circle10.setRadius(560);
        Player1CardJPanel.add(Card1Circle10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 40, 40));

        Card1Circle11.setForeground(new java.awt.Color(0, 0, 0));
        Card1Circle11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card1Circle11.setBorderColor(new java.awt.Color(255, 255, 255));
        Card1Circle11.setColor(new java.awt.Color(95, 158, 160));
        Card1Circle11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card1Circle11.setRadius(560);
        Player1CardJPanel.add(Card1Circle11, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 40, 40));

        Card1Circle12.setForeground(new java.awt.Color(0, 0, 0));
        Card1Circle12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card1Circle12.setBorderColor(new java.awt.Color(255, 255, 255));
        Card1Circle12.setColor(new java.awt.Color(95, 158, 160));
        Card1Circle12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card1Circle12.setRadius(560);
        Player1CardJPanel.add(Card1Circle12, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 40, 40));

        Card1Circle13.setForeground(new java.awt.Color(0, 0, 0));
        Card1Circle13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card1Circle13.setBorderColor(new java.awt.Color(255, 255, 255));
        Card1Circle13.setColor(new java.awt.Color(95, 158, 160));
        Card1Circle13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card1Circle13.setRadius(560);
        Player1CardJPanel.add(Card1Circle13, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 40, 40));

        Card1Circle14.setForeground(new java.awt.Color(0, 0, 0));
        Card1Circle14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card1Circle14.setBorderColor(new java.awt.Color(255, 255, 255));
        Card1Circle14.setColor(new java.awt.Color(95, 158, 160));
        Card1Circle14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card1Circle14.setRadius(560);
        Player1CardJPanel.add(Card1Circle14, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 40, 40));

        Card1Circle15.setForeground(new java.awt.Color(0, 0, 0));
        Card1Circle15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card1Circle15.setBorderColor(new java.awt.Color(255, 255, 255));
        Card1Circle15.setColor(new java.awt.Color(95, 158, 160));
        Card1Circle15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card1Circle15.setRadius(560);
        Player1CardJPanel.add(Card1Circle15, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, 40, 40));

        Card1Circle16.setForeground(new java.awt.Color(0, 0, 0));
        Card1Circle16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card1Circle16.setBorderColor(new java.awt.Color(255, 255, 255));
        Card1Circle16.setColor(new java.awt.Color(95, 158, 160));
        Card1Circle16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card1Circle16.setRadius(560);
        Player1CardJPanel.add(Card1Circle16, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, 40, 40));

        Card1Circle17.setForeground(new java.awt.Color(0, 0, 0));
        Card1Circle17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card1Circle17.setBorderColor(new java.awt.Color(255, 255, 255));
        Card1Circle17.setColor(new java.awt.Color(95, 158, 160));
        Card1Circle17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card1Circle17.setRadius(560);
        Player1CardJPanel.add(Card1Circle17, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, 40, 40));

        Card1Circle18.setForeground(new java.awt.Color(0, 0, 0));
        Card1Circle18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card1Circle18.setBorderColor(new java.awt.Color(255, 255, 255));
        Card1Circle18.setColor(new java.awt.Color(95, 158, 160));
        Card1Circle18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card1Circle18.setRadius(560);
        Player1CardJPanel.add(Card1Circle18, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, 40, 40));

        Card1Circle19.setForeground(new java.awt.Color(0, 0, 0));
        Card1Circle19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card1Circle19.setBorderColor(new java.awt.Color(255, 255, 255));
        Card1Circle19.setColor(new java.awt.Color(95, 158, 160));
        Card1Circle19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card1Circle19.setRadius(560);
        Player1CardJPanel.add(Card1Circle19, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 40, 40));

        Card1Circle20.setForeground(new java.awt.Color(0, 0, 0));
        Card1Circle20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card1Circle20.setBorderColor(new java.awt.Color(255, 255, 255));
        Card1Circle20.setColor(new java.awt.Color(95, 158, 160));
        Card1Circle20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card1Circle20.setRadius(560);
        Player1CardJPanel.add(Card1Circle20, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 40, 40));

        Card1Circle21.setForeground(new java.awt.Color(0, 0, 0));
        Card1Circle21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card1Circle21.setBorderColor(new java.awt.Color(255, 255, 255));
        Card1Circle21.setColor(new java.awt.Color(95, 158, 160));
        Card1Circle21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card1Circle21.setRadius(560);
        Player1CardJPanel.add(Card1Circle21, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 40, 40));

        Card1Circle22.setForeground(new java.awt.Color(0, 0, 0));
        Card1Circle22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card1Circle22.setBorderColor(new java.awt.Color(255, 255, 255));
        Card1Circle22.setColor(new java.awt.Color(95, 158, 160));
        Card1Circle22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card1Circle22.setRadius(560);
        Player1CardJPanel.add(Card1Circle22, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 40, 40));

        Card1Circle23.setForeground(new java.awt.Color(0, 0, 0));
        Card1Circle23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card1Circle23.setBorderColor(new java.awt.Color(255, 255, 255));
        Card1Circle23.setColor(new java.awt.Color(95, 158, 160));
        Card1Circle23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card1Circle23.setRadius(560);
        Player1CardJPanel.add(Card1Circle23, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 40, 40));

        Card1Circle24.setForeground(new java.awt.Color(0, 0, 0));
        Card1Circle24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card1Circle24.setBorderColor(new java.awt.Color(255, 255, 255));
        Card1Circle24.setColor(new java.awt.Color(95, 158, 160));
        Card1Circle24.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card1Circle24.setRadius(560);
        Player1CardJPanel.add(Card1Circle24, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, 40, 40));

        Card1Circle25.setForeground(new java.awt.Color(0, 0, 0));
        Card1Circle25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card1Circle25.setBorderColor(new java.awt.Color(255, 255, 255));
        Card1Circle25.setColor(new java.awt.Color(95, 158, 160));
        Card1Circle25.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card1Circle25.setRadius(560);
        Player1CardJPanel.add(Card1Circle25, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 110, 40, 40));

        Card1Circle26.setForeground(new java.awt.Color(0, 0, 0));
        Card1Circle26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card1Circle26.setBorderColor(new java.awt.Color(255, 255, 255));
        Card1Circle26.setColor(new java.awt.Color(95, 158, 160));
        Card1Circle26.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card1Circle26.setRadius(560);
        Player1CardJPanel.add(Card1Circle26, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 110, 40, 40));

        Card1Circle27.setForeground(new java.awt.Color(0, 0, 0));
        Card1Circle27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card1Circle27.setBorderColor(new java.awt.Color(255, 255, 255));
        Card1Circle27.setColor(new java.awt.Color(95, 158, 160));
        Card1Circle27.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card1Circle27.setRadius(560);
        Player1CardJPanel.add(Card1Circle27, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 110, 40, 40));

        player1Label.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        player1Label.setForeground(new java.awt.Color(0, 0, 0));
        player1Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        player1Label.setText("PLAYER 1");
        Player1CardJPanel.add(player1Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 30));

        MainJPanel.add(Player1CardJPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 440, 180));

        Player3CardJPanel.setBackground(new java.awt.Color(95, 158, 160));
        Player3CardJPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Player3CardJPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Card3Circle1.setForeground(new java.awt.Color(0, 0, 0));
        Card3Circle1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card3Circle1.setBorderColor(new java.awt.Color(255, 255, 255));
        Card3Circle1.setColor(new java.awt.Color(95, 158, 160));
        Card3Circle1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card3Circle1.setRadius(560);
        Player3CardJPanel.add(Card3Circle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 40, 40));

        Card3Circle2.setForeground(new java.awt.Color(0, 0, 0));
        Card3Circle2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card3Circle2.setBorderColor(new java.awt.Color(255, 255, 255));
        Card3Circle2.setColor(new java.awt.Color(95, 158, 160));
        Card3Circle2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card3Circle2.setRadius(560);
        Player3CardJPanel.add(Card3Circle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 40, 40));

        Card3Circle3.setForeground(new java.awt.Color(0, 0, 0));
        Card3Circle3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card3Circle3.setBorderColor(new java.awt.Color(255, 255, 255));
        Card3Circle3.setColor(new java.awt.Color(95, 158, 160));
        Card3Circle3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card3Circle3.setRadius(560);
        Player3CardJPanel.add(Card3Circle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 40, 40));

        Card3Circle4.setForeground(new java.awt.Color(0, 0, 0));
        Card3Circle4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card3Circle4.setBorderColor(new java.awt.Color(255, 255, 255));
        Card3Circle4.setColor(new java.awt.Color(95, 158, 160));
        Card3Circle4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card3Circle4.setRadius(560);
        Player3CardJPanel.add(Card3Circle4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 40, 40));

        Card3Circle5.setForeground(new java.awt.Color(0, 0, 0));
        Card3Circle5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card3Circle5.setBorderColor(new java.awt.Color(255, 255, 255));
        Card3Circle5.setColor(new java.awt.Color(95, 158, 160));
        Card3Circle5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card3Circle5.setRadius(560);
        Player3CardJPanel.add(Card3Circle5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 40, 40));

        Card3Circle6.setForeground(new java.awt.Color(0, 0, 0));
        Card3Circle6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card3Circle6.setBorderColor(new java.awt.Color(255, 255, 255));
        Card3Circle6.setColor(new java.awt.Color(95, 158, 160));
        Card3Circle6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card3Circle6.setRadius(560);
        Player3CardJPanel.add(Card3Circle6, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, 40, 40));

        Card3Circle7.setForeground(new java.awt.Color(0, 0, 0));
        Card3Circle7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card3Circle7.setBorderColor(new java.awt.Color(255, 255, 255));
        Card3Circle7.setColor(new java.awt.Color(95, 158, 160));
        Card3Circle7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card3Circle7.setRadius(560);
        Player3CardJPanel.add(Card3Circle7, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, 40, 40));

        Card3Circle8.setForeground(new java.awt.Color(0, 0, 0));
        Card3Circle8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card3Circle8.setBorderColor(new java.awt.Color(255, 255, 255));
        Card3Circle8.setColor(new java.awt.Color(95, 158, 160));
        Card3Circle8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card3Circle8.setRadius(560);
        Player3CardJPanel.add(Card3Circle8, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, 40, 40));

        Card3Circle9.setForeground(new java.awt.Color(0, 0, 0));
        Card3Circle9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card3Circle9.setBorderColor(new java.awt.Color(255, 255, 255));
        Card3Circle9.setColor(new java.awt.Color(95, 158, 160));
        Card3Circle9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card3Circle9.setRadius(560);
        Player3CardJPanel.add(Card3Circle9, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 30, 40, 40));

        Card3Circle10.setForeground(new java.awt.Color(0, 0, 0));
        Card3Circle10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card3Circle10.setBorderColor(new java.awt.Color(255, 255, 255));
        Card3Circle10.setColor(new java.awt.Color(95, 158, 160));
        Card3Circle10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card3Circle10.setRadius(560);
        Player3CardJPanel.add(Card3Circle10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 40, 40));

        Card3Circle11.setForeground(new java.awt.Color(0, 0, 0));
        Card3Circle11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card3Circle11.setBorderColor(new java.awt.Color(255, 255, 255));
        Card3Circle11.setColor(new java.awt.Color(95, 158, 160));
        Card3Circle11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card3Circle11.setRadius(560);
        Player3CardJPanel.add(Card3Circle11, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 40, 40));

        Card3Circle12.setForeground(new java.awt.Color(0, 0, 0));
        Card3Circle12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card3Circle12.setBorderColor(new java.awt.Color(255, 255, 255));
        Card3Circle12.setColor(new java.awt.Color(95, 158, 160));
        Card3Circle12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card3Circle12.setRadius(560);
        Player3CardJPanel.add(Card3Circle12, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 40, 40));

        Card3Circle13.setForeground(new java.awt.Color(0, 0, 0));
        Card3Circle13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card3Circle13.setBorderColor(new java.awt.Color(255, 255, 255));
        Card3Circle13.setColor(new java.awt.Color(95, 158, 160));
        Card3Circle13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card3Circle13.setRadius(560);
        Player3CardJPanel.add(Card3Circle13, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 40, 40));

        Card3Circle14.setForeground(new java.awt.Color(0, 0, 0));
        Card3Circle14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card3Circle14.setBorderColor(new java.awt.Color(255, 255, 255));
        Card3Circle14.setColor(new java.awt.Color(95, 158, 160));
        Card3Circle14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card3Circle14.setRadius(560);
        Player3CardJPanel.add(Card3Circle14, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 40, 40));

        Card3Circle15.setForeground(new java.awt.Color(0, 0, 0));
        Card3Circle15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card3Circle15.setBorderColor(new java.awt.Color(255, 255, 255));
        Card3Circle15.setColor(new java.awt.Color(95, 158, 160));
        Card3Circle15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card3Circle15.setRadius(560);
        Player3CardJPanel.add(Card3Circle15, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, 40, 40));

        Card3Circle16.setForeground(new java.awt.Color(0, 0, 0));
        Card3Circle16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card3Circle16.setBorderColor(new java.awt.Color(255, 255, 255));
        Card3Circle16.setColor(new java.awt.Color(95, 158, 160));
        Card3Circle16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card3Circle16.setRadius(560);
        Player3CardJPanel.add(Card3Circle16, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, 40, 40));

        Card3Circle17.setForeground(new java.awt.Color(0, 0, 0));
        Card3Circle17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card3Circle17.setBorderColor(new java.awt.Color(255, 255, 255));
        Card3Circle17.setColor(new java.awt.Color(95, 158, 160));
        Card3Circle17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card3Circle17.setRadius(560);
        Player3CardJPanel.add(Card3Circle17, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, 40, 40));

        Card3Circle18.setForeground(new java.awt.Color(0, 0, 0));
        Card3Circle18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card3Circle18.setBorderColor(new java.awt.Color(255, 255, 255));
        Card3Circle18.setColor(new java.awt.Color(95, 158, 160));
        Card3Circle18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card3Circle18.setRadius(560);
        Player3CardJPanel.add(Card3Circle18, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, 40, 40));

        Card3Circle19.setForeground(new java.awt.Color(0, 0, 0));
        Card3Circle19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card3Circle19.setBorderColor(new java.awt.Color(255, 255, 255));
        Card3Circle19.setColor(new java.awt.Color(95, 158, 160));
        Card3Circle19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card3Circle19.setRadius(560);
        Player3CardJPanel.add(Card3Circle19, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 40, 40));

        Card3Circle20.setForeground(new java.awt.Color(0, 0, 0));
        Card3Circle20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card3Circle20.setBorderColor(new java.awt.Color(255, 255, 255));
        Card3Circle20.setColor(new java.awt.Color(95, 158, 160));
        Card3Circle20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card3Circle20.setRadius(560);
        Player3CardJPanel.add(Card3Circle20, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 40, 40));

        Card3Circle21.setForeground(new java.awt.Color(0, 0, 0));
        Card3Circle21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card3Circle21.setBorderColor(new java.awt.Color(255, 255, 255));
        Card3Circle21.setColor(new java.awt.Color(95, 158, 160));
        Card3Circle21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card3Circle21.setRadius(560);
        Player3CardJPanel.add(Card3Circle21, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 40, 40));

        Card3Circle22.setForeground(new java.awt.Color(0, 0, 0));
        Card3Circle22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card3Circle22.setBorderColor(new java.awt.Color(255, 255, 255));
        Card3Circle22.setColor(new java.awt.Color(95, 158, 160));
        Card3Circle22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card3Circle22.setRadius(560);
        Player3CardJPanel.add(Card3Circle22, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 40, 40));

        Card3Circle23.setForeground(new java.awt.Color(0, 0, 0));
        Card3Circle23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card3Circle23.setBorderColor(new java.awt.Color(255, 255, 255));
        Card3Circle23.setColor(new java.awt.Color(95, 158, 160));
        Card3Circle23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card3Circle23.setRadius(560);
        Player3CardJPanel.add(Card3Circle23, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 40, 40));

        Card3Circle24.setForeground(new java.awt.Color(0, 0, 0));
        Card3Circle24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card3Circle24.setBorderColor(new java.awt.Color(255, 255, 255));
        Card3Circle24.setColor(new java.awt.Color(95, 158, 160));
        Card3Circle24.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card3Circle24.setRadius(560);
        Player3CardJPanel.add(Card3Circle24, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, 40, 40));

        Card3Circle25.setForeground(new java.awt.Color(0, 0, 0));
        Card3Circle25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card3Circle25.setBorderColor(new java.awt.Color(255, 255, 255));
        Card3Circle25.setColor(new java.awt.Color(95, 158, 160));
        Card3Circle25.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card3Circle25.setRadius(560);
        Player3CardJPanel.add(Card3Circle25, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 110, 40, 40));

        Card3Circle26.setForeground(new java.awt.Color(0, 0, 0));
        Card3Circle26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card3Circle26.setBorderColor(new java.awt.Color(255, 255, 255));
        Card3Circle26.setColor(new java.awt.Color(95, 158, 160));
        Card3Circle26.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card3Circle26.setRadius(560);
        Player3CardJPanel.add(Card3Circle26, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 110, 40, 40));

        Card3Circle27.setForeground(new java.awt.Color(0, 0, 0));
        Card3Circle27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card3Circle27.setBorderColor(new java.awt.Color(255, 255, 255));
        Card3Circle27.setColor(new java.awt.Color(95, 158, 160));
        Card3Circle27.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card3Circle27.setRadius(560);
        Player3CardJPanel.add(Card3Circle27, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 110, 40, 40));

        player3Label.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        player3Label.setForeground(new java.awt.Color(0, 0, 0));
        player3Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        player3Label.setText("PLAYER 3");
        Player3CardJPanel.add(player3Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 30));

        MainJPanel.add(Player3CardJPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 440, 180));

        Player4CardJPanel.setBackground(new java.awt.Color(95, 158, 160));
        Player4CardJPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Player4CardJPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Card4Circle1.setForeground(new java.awt.Color(0, 0, 0));
        Card4Circle1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card4Circle1.setBorderColor(new java.awt.Color(255, 255, 255));
        Card4Circle1.setColor(new java.awt.Color(95, 158, 160));
        Card4Circle1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card4Circle1.setRadius(560);
        Player4CardJPanel.add(Card4Circle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 40, 40));

        Card4Circle2.setForeground(new java.awt.Color(0, 0, 0));
        Card4Circle2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card4Circle2.setBorderColor(new java.awt.Color(255, 255, 255));
        Card4Circle2.setColor(new java.awt.Color(95, 158, 160));
        Card4Circle2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card4Circle2.setRadius(560);
        Player4CardJPanel.add(Card4Circle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 40, 40));

        Card4Circle3.setForeground(new java.awt.Color(0, 0, 0));
        Card4Circle3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card4Circle3.setBorderColor(new java.awt.Color(255, 255, 255));
        Card4Circle3.setColor(new java.awt.Color(95, 158, 160));
        Card4Circle3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card4Circle3.setRadius(560);
        Player4CardJPanel.add(Card4Circle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 40, 40));

        Card4Circle4.setForeground(new java.awt.Color(0, 0, 0));
        Card4Circle4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card4Circle4.setBorderColor(new java.awt.Color(255, 255, 255));
        Card4Circle4.setColor(new java.awt.Color(95, 158, 160));
        Card4Circle4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card4Circle4.setRadius(560);
        Player4CardJPanel.add(Card4Circle4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 40, 40));

        Card4Circle5.setForeground(new java.awt.Color(0, 0, 0));
        Card4Circle5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card4Circle5.setBorderColor(new java.awt.Color(255, 255, 255));
        Card4Circle5.setColor(new java.awt.Color(95, 158, 160));
        Card4Circle5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card4Circle5.setRadius(560);
        Player4CardJPanel.add(Card4Circle5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 40, 40));

        Card4Circle6.setForeground(new java.awt.Color(0, 0, 0));
        Card4Circle6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card4Circle6.setBorderColor(new java.awt.Color(255, 255, 255));
        Card4Circle6.setColor(new java.awt.Color(95, 158, 160));
        Card4Circle6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card4Circle6.setRadius(560);
        Player4CardJPanel.add(Card4Circle6, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, 40, 40));

        Card4Circle7.setForeground(new java.awt.Color(0, 0, 0));
        Card4Circle7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card4Circle7.setBorderColor(new java.awt.Color(255, 255, 255));
        Card4Circle7.setColor(new java.awt.Color(95, 158, 160));
        Card4Circle7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card4Circle7.setRadius(560);
        Player4CardJPanel.add(Card4Circle7, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, 40, 40));

        Card4Circle8.setForeground(new java.awt.Color(0, 0, 0));
        Card4Circle8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card4Circle8.setBorderColor(new java.awt.Color(255, 255, 255));
        Card4Circle8.setColor(new java.awt.Color(95, 158, 160));
        Card4Circle8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card4Circle8.setRadius(560);
        Player4CardJPanel.add(Card4Circle8, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, 40, 40));

        Card4Circle9.setForeground(new java.awt.Color(0, 0, 0));
        Card4Circle9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card4Circle9.setBorderColor(new java.awt.Color(255, 255, 255));
        Card4Circle9.setColor(new java.awt.Color(95, 158, 160));
        Card4Circle9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card4Circle9.setRadius(560);
        Player4CardJPanel.add(Card4Circle9, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 30, 40, 40));

        Card4Circle10.setForeground(new java.awt.Color(0, 0, 0));
        Card4Circle10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card4Circle10.setBorderColor(new java.awt.Color(255, 255, 255));
        Card4Circle10.setColor(new java.awt.Color(95, 158, 160));
        Card4Circle10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card4Circle10.setRadius(560);
        Player4CardJPanel.add(Card4Circle10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 40, 40));

        Card4Circle11.setForeground(new java.awt.Color(0, 0, 0));
        Card4Circle11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card4Circle11.setBorderColor(new java.awt.Color(255, 255, 255));
        Card4Circle11.setColor(new java.awt.Color(95, 158, 160));
        Card4Circle11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card4Circle11.setRadius(560);
        Player4CardJPanel.add(Card4Circle11, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 40, 40));

        Card4Circle12.setForeground(new java.awt.Color(0, 0, 0));
        Card4Circle12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card4Circle12.setBorderColor(new java.awt.Color(255, 255, 255));
        Card4Circle12.setColor(new java.awt.Color(95, 158, 160));
        Card4Circle12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card4Circle12.setRadius(560);
        Player4CardJPanel.add(Card4Circle12, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 40, 40));

        Card4Circle13.setForeground(new java.awt.Color(0, 0, 0));
        Card4Circle13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card4Circle13.setBorderColor(new java.awt.Color(255, 255, 255));
        Card4Circle13.setColor(new java.awt.Color(95, 158, 160));
        Card4Circle13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card4Circle13.setRadius(560);
        Player4CardJPanel.add(Card4Circle13, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 40, 40));

        Card4Circle14.setForeground(new java.awt.Color(0, 0, 0));
        Card4Circle14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card4Circle14.setBorderColor(new java.awt.Color(255, 255, 255));
        Card4Circle14.setColor(new java.awt.Color(95, 158, 160));
        Card4Circle14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card4Circle14.setRadius(560);
        Player4CardJPanel.add(Card4Circle14, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 40, 40));

        Card4Circle15.setForeground(new java.awt.Color(0, 0, 0));
        Card4Circle15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card4Circle15.setBorderColor(new java.awt.Color(255, 255, 255));
        Card4Circle15.setColor(new java.awt.Color(95, 158, 160));
        Card4Circle15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card4Circle15.setRadius(560);
        Player4CardJPanel.add(Card4Circle15, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, 40, 40));

        Card4Circle16.setForeground(new java.awt.Color(0, 0, 0));
        Card4Circle16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card4Circle16.setBorderColor(new java.awt.Color(255, 255, 255));
        Card4Circle16.setColor(new java.awt.Color(95, 158, 160));
        Card4Circle16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card4Circle16.setRadius(560);
        Player4CardJPanel.add(Card4Circle16, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, 40, 40));

        Card4Circle17.setForeground(new java.awt.Color(0, 0, 0));
        Card4Circle17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card4Circle17.setBorderColor(new java.awt.Color(255, 255, 255));
        Card4Circle17.setColor(new java.awt.Color(95, 158, 160));
        Card4Circle17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card4Circle17.setRadius(560);
        Player4CardJPanel.add(Card4Circle17, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, 40, 40));

        Card4Circle18.setForeground(new java.awt.Color(0, 0, 0));
        Card4Circle18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card4Circle18.setBorderColor(new java.awt.Color(255, 255, 255));
        Card4Circle18.setColor(new java.awt.Color(95, 158, 160));
        Card4Circle18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card4Circle18.setRadius(560);
        Player4CardJPanel.add(Card4Circle18, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, 40, 40));

        Card4Circle19.setForeground(new java.awt.Color(0, 0, 0));
        Card4Circle19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card4Circle19.setBorderColor(new java.awt.Color(255, 255, 255));
        Card4Circle19.setColor(new java.awt.Color(95, 158, 160));
        Card4Circle19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card4Circle19.setRadius(560);
        Player4CardJPanel.add(Card4Circle19, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 40, 40));

        Card4Circle20.setForeground(new java.awt.Color(0, 0, 0));
        Card4Circle20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card4Circle20.setBorderColor(new java.awt.Color(255, 255, 255));
        Card4Circle20.setColor(new java.awt.Color(95, 158, 160));
        Card4Circle20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card4Circle20.setRadius(560);
        Player4CardJPanel.add(Card4Circle20, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 40, 40));

        Card4Circle21.setForeground(new java.awt.Color(0, 0, 0));
        Card4Circle21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card4Circle21.setBorderColor(new java.awt.Color(255, 255, 255));
        Card4Circle21.setColor(new java.awt.Color(95, 158, 160));
        Card4Circle21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card4Circle21.setRadius(560);
        Player4CardJPanel.add(Card4Circle21, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 40, 40));

        Card4Circle22.setForeground(new java.awt.Color(0, 0, 0));
        Card4Circle22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card4Circle22.setBorderColor(new java.awt.Color(255, 255, 255));
        Card4Circle22.setColor(new java.awt.Color(95, 158, 160));
        Card4Circle22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card4Circle22.setRadius(560);
        Player4CardJPanel.add(Card4Circle22, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 40, 40));

        Card4Circle23.setForeground(new java.awt.Color(0, 0, 0));
        Card4Circle23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card4Circle23.setBorderColor(new java.awt.Color(255, 255, 255));
        Card4Circle23.setColor(new java.awt.Color(95, 158, 160));
        Card4Circle23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card4Circle23.setRadius(560);
        Player4CardJPanel.add(Card4Circle23, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 40, 40));

        Card4Circle24.setForeground(new java.awt.Color(0, 0, 0));
        Card4Circle24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card4Circle24.setBorderColor(new java.awt.Color(255, 255, 255));
        Card4Circle24.setColor(new java.awt.Color(95, 158, 160));
        Card4Circle24.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card4Circle24.setRadius(560);
        Player4CardJPanel.add(Card4Circle24, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, 40, 40));

        Card4Circle25.setForeground(new java.awt.Color(0, 0, 0));
        Card4Circle25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card4Circle25.setBorderColor(new java.awt.Color(255, 255, 255));
        Card4Circle25.setColor(new java.awt.Color(95, 158, 160));
        Card4Circle25.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card4Circle25.setRadius(560);
        Player4CardJPanel.add(Card4Circle25, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 110, 40, 40));

        Card4Circle26.setForeground(new java.awt.Color(0, 0, 0));
        Card4Circle26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card4Circle26.setBorderColor(new java.awt.Color(255, 255, 255));
        Card4Circle26.setColor(new java.awt.Color(95, 158, 160));
        Card4Circle26.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card4Circle26.setRadius(560);
        Player4CardJPanel.add(Card4Circle26, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 110, 40, 40));

        Card4Circle27.setForeground(new java.awt.Color(0, 0, 0));
        Card4Circle27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card4Circle27.setBorderColor(new java.awt.Color(255, 255, 255));
        Card4Circle27.setColor(new java.awt.Color(95, 158, 160));
        Card4Circle27.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card4Circle27.setRadius(560);
        Player4CardJPanel.add(Card4Circle27, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 110, 40, 40));

        player4Label.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        player4Label.setForeground(new java.awt.Color(0, 0, 0));
        player4Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        player4Label.setText("PLAYER 4");
        Player4CardJPanel.add(player4Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 30));

        MainJPanel.add(Player4CardJPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 370, 440, 180));

        Player2CardJPanel.setBackground(new java.awt.Color(95, 158, 160));
        Player2CardJPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Player2CardJPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        player2Label.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        player2Label.setForeground(new java.awt.Color(0, 0, 0));
        player2Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        player2Label.setText("PLAYER 2");
        Player2CardJPanel.add(player2Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 30));

        Card2Circle1.setForeground(new java.awt.Color(0, 0, 0));
        Card2Circle1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card2Circle1.setBorderColor(new java.awt.Color(255, 255, 255));
        Card2Circle1.setColor(new java.awt.Color(95, 158, 160));
        Card2Circle1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card2Circle1.setRadius(560);
        Player2CardJPanel.add(Card2Circle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 40, 40));

        Card2Circle2.setForeground(new java.awt.Color(0, 0, 0));
        Card2Circle2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card2Circle2.setBorderColor(new java.awt.Color(255, 255, 255));
        Card2Circle2.setColor(new java.awt.Color(95, 158, 160));
        Card2Circle2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card2Circle2.setRadius(560);
        Player2CardJPanel.add(Card2Circle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 40, 40));

        Card2Circle3.setForeground(new java.awt.Color(0, 0, 0));
        Card2Circle3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card2Circle3.setBorderColor(new java.awt.Color(255, 255, 255));
        Card2Circle3.setColor(new java.awt.Color(95, 158, 160));
        Card2Circle3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card2Circle3.setRadius(560);
        Player2CardJPanel.add(Card2Circle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 40, 40));

        Card2Circle4.setForeground(new java.awt.Color(0, 0, 0));
        Card2Circle4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card2Circle4.setBorderColor(new java.awt.Color(255, 255, 255));
        Card2Circle4.setColor(new java.awt.Color(95, 158, 160));
        Card2Circle4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card2Circle4.setRadius(560);
        Player2CardJPanel.add(Card2Circle4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 40, 40));

        Card2Circle5.setForeground(new java.awt.Color(0, 0, 0));
        Card2Circle5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card2Circle5.setBorderColor(new java.awt.Color(255, 255, 255));
        Card2Circle5.setColor(new java.awt.Color(95, 158, 160));
        Card2Circle5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card2Circle5.setRadius(560);
        Player2CardJPanel.add(Card2Circle5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 40, 40));

        Card2Circle6.setForeground(new java.awt.Color(0, 0, 0));
        Card2Circle6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card2Circle6.setBorderColor(new java.awt.Color(255, 255, 255));
        Card2Circle6.setColor(new java.awt.Color(95, 158, 160));
        Card2Circle6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card2Circle6.setRadius(560);
        Player2CardJPanel.add(Card2Circle6, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, 40, 40));

        Card2Circle7.setForeground(new java.awt.Color(0, 0, 0));
        Card2Circle7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card2Circle7.setBorderColor(new java.awt.Color(255, 255, 255));
        Card2Circle7.setColor(new java.awt.Color(95, 158, 160));
        Card2Circle7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card2Circle7.setRadius(560);
        Player2CardJPanel.add(Card2Circle7, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, 40, 40));

        Card2Circle8.setForeground(new java.awt.Color(0, 0, 0));
        Card2Circle8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card2Circle8.setBorderColor(new java.awt.Color(255, 255, 255));
        Card2Circle8.setColor(new java.awt.Color(95, 158, 160));
        Card2Circle8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card2Circle8.setRadius(560);
        Player2CardJPanel.add(Card2Circle8, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, 40, 40));

        Card2Circle9.setForeground(new java.awt.Color(0, 0, 0));
        Card2Circle9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card2Circle9.setBorderColor(new java.awt.Color(255, 255, 255));
        Card2Circle9.setColor(new java.awt.Color(95, 158, 160));
        Card2Circle9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card2Circle9.setRadius(560);
        Player2CardJPanel.add(Card2Circle9, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 30, 40, 40));

        Card2Circle10.setForeground(new java.awt.Color(0, 0, 0));
        Card2Circle10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card2Circle10.setBorderColor(new java.awt.Color(255, 255, 255));
        Card2Circle10.setColor(new java.awt.Color(95, 158, 160));
        Card2Circle10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card2Circle10.setRadius(560);
        Player2CardJPanel.add(Card2Circle10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 40, 40));

        Card2Circle11.setForeground(new java.awt.Color(0, 0, 0));
        Card2Circle11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card2Circle11.setBorderColor(new java.awt.Color(255, 255, 255));
        Card2Circle11.setColor(new java.awt.Color(95, 158, 160));
        Card2Circle11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card2Circle11.setRadius(560);
        Player2CardJPanel.add(Card2Circle11, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 40, 40));

        Card2Circle12.setForeground(new java.awt.Color(0, 0, 0));
        Card2Circle12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card2Circle12.setBorderColor(new java.awt.Color(255, 255, 255));
        Card2Circle12.setColor(new java.awt.Color(95, 158, 160));
        Card2Circle12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card2Circle12.setRadius(560);
        Player2CardJPanel.add(Card2Circle12, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 40, 40));

        Card2Circle13.setForeground(new java.awt.Color(0, 0, 0));
        Card2Circle13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card2Circle13.setBorderColor(new java.awt.Color(255, 255, 255));
        Card2Circle13.setColor(new java.awt.Color(95, 158, 160));
        Card2Circle13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card2Circle13.setRadius(560);
        Player2CardJPanel.add(Card2Circle13, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 40, 40));

        Card2Circle14.setForeground(new java.awt.Color(0, 0, 0));
        Card2Circle14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card2Circle14.setBorderColor(new java.awt.Color(255, 255, 255));
        Card2Circle14.setColor(new java.awt.Color(95, 158, 160));
        Card2Circle14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card2Circle14.setRadius(560);
        Player2CardJPanel.add(Card2Circle14, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 40, 40));

        Card2Circle15.setForeground(new java.awt.Color(0, 0, 0));
        Card2Circle15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card2Circle15.setBorderColor(new java.awt.Color(255, 255, 255));
        Card2Circle15.setColor(new java.awt.Color(95, 158, 160));
        Card2Circle15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card2Circle15.setRadius(560);
        Player2CardJPanel.add(Card2Circle15, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, 40, 40));

        Card2Circle16.setForeground(new java.awt.Color(0, 0, 0));
        Card2Circle16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card2Circle16.setBorderColor(new java.awt.Color(255, 255, 255));
        Card2Circle16.setColor(new java.awt.Color(95, 158, 160));
        Card2Circle16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card2Circle16.setRadius(560);
        Player2CardJPanel.add(Card2Circle16, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, 40, 40));

        Card2Circle17.setForeground(new java.awt.Color(0, 0, 0));
        Card2Circle17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card2Circle17.setBorderColor(new java.awt.Color(255, 255, 255));
        Card2Circle17.setColor(new java.awt.Color(95, 158, 160));
        Card2Circle17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card2Circle17.setRadius(560);
        Player2CardJPanel.add(Card2Circle17, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, 40, 40));

        Card2Circle18.setForeground(new java.awt.Color(0, 0, 0));
        Card2Circle18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card2Circle18.setBorderColor(new java.awt.Color(255, 255, 255));
        Card2Circle18.setColor(new java.awt.Color(95, 158, 160));
        Card2Circle18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card2Circle18.setRadius(560);
        Player2CardJPanel.add(Card2Circle18, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, 40, 40));

        Card2Circle19.setForeground(new java.awt.Color(0, 0, 0));
        Card2Circle19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card2Circle19.setBorderColor(new java.awt.Color(255, 255, 255));
        Card2Circle19.setColor(new java.awt.Color(95, 158, 160));
        Card2Circle19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card2Circle19.setRadius(560);
        Player2CardJPanel.add(Card2Circle19, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 40, 40));

        Card2Circle20.setForeground(new java.awt.Color(0, 0, 0));
        Card2Circle20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card2Circle20.setBorderColor(new java.awt.Color(255, 255, 255));
        Card2Circle20.setColor(new java.awt.Color(95, 158, 160));
        Card2Circle20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card2Circle20.setRadius(560);
        Player2CardJPanel.add(Card2Circle20, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 40, 40));

        Card2Circle21.setForeground(new java.awt.Color(0, 0, 0));
        Card2Circle21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card2Circle21.setBorderColor(new java.awt.Color(255, 255, 255));
        Card2Circle21.setColor(new java.awt.Color(95, 158, 160));
        Card2Circle21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card2Circle21.setRadius(560);
        Player2CardJPanel.add(Card2Circle21, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 40, 40));

        Card2Circle22.setForeground(new java.awt.Color(0, 0, 0));
        Card2Circle22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card2Circle22.setBorderColor(new java.awt.Color(255, 255, 255));
        Card2Circle22.setColor(new java.awt.Color(95, 158, 160));
        Card2Circle22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card2Circle22.setRadius(560);
        Player2CardJPanel.add(Card2Circle22, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 40, 40));

        Card2Circle23.setForeground(new java.awt.Color(0, 0, 0));
        Card2Circle23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card2Circle23.setBorderColor(new java.awt.Color(255, 255, 255));
        Card2Circle23.setColor(new java.awt.Color(95, 158, 160));
        Card2Circle23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card2Circle23.setRadius(560);
        Player2CardJPanel.add(Card2Circle23, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 40, 40));

        Card2Circle24.setForeground(new java.awt.Color(0, 0, 0));
        Card2Circle24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card2Circle24.setBorderColor(new java.awt.Color(255, 255, 255));
        Card2Circle24.setColor(new java.awt.Color(95, 158, 160));
        Card2Circle24.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card2Circle24.setRadius(560);
        Player2CardJPanel.add(Card2Circle24, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, 40, 40));

        Card2Circle25.setForeground(new java.awt.Color(0, 0, 0));
        Card2Circle25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card2Circle25.setBorderColor(new java.awt.Color(255, 255, 255));
        Card2Circle25.setColor(new java.awt.Color(95, 158, 160));
        Card2Circle25.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card2Circle25.setRadius(560);
        Player2CardJPanel.add(Card2Circle25, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 110, 40, 40));

        Card2Circle26.setForeground(new java.awt.Color(0, 0, 0));
        Card2Circle26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card2Circle26.setBorderColor(new java.awt.Color(255, 255, 255));
        Card2Circle26.setColor(new java.awt.Color(95, 158, 160));
        Card2Circle26.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card2Circle26.setRadius(560);
        Player2CardJPanel.add(Card2Circle26, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 110, 40, 40));

        Card2Circle27.setForeground(new java.awt.Color(0, 0, 0));
        Card2Circle27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Card2Circle27.setBorderColor(new java.awt.Color(255, 255, 255));
        Card2Circle27.setColor(new java.awt.Color(95, 158, 160));
        Card2Circle27.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Card2Circle27.setRadius(560);
        Player2CardJPanel.add(Card2Circle27, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 110, 40, 40));

        MainJPanel.add(Player2CardJPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 160, 440, 180));

        ImageJPanel.setBackground(new java.awt.Color(95, 158, 160));
        ImageJPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ImageJPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        numberLabel.setForeground(new java.awt.Color(0, 0, 0));
        numberLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        numberLabel.setBorderColor(new java.awt.Color(255, 255, 255));
        numberLabel.setColor(new java.awt.Color(95, 158, 160));
        numberLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        numberLabel.setRadius(560);
        ImageJPanel.add(numberLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 35, 32));
        ImageJPanel.add(imageLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -30, 196, 156));

        newNumberButton.setBackground(new java.awt.Color(95, 158, 160));
        newNumberButton.setForeground(new java.awt.Color(0, 0, 0));
        newNumberButton.setText("Click for new number");
        newNumberButton.setBorderColor(new java.awt.Color(255, 255, 255));
        newNumberButton.setColorClick(new java.awt.Color(95, 158, 160));
        newNumberButton.setColorOver(new java.awt.Color(95, 158, 160));
        newNumberButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        newNumberButton.setRadius(40);
        newNumberButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newNumberButtonActionPerformed(evt);
            }
        });
        ImageJPanel.add(newNumberButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 130, 150, 40));

        MainJPanel.add(ImageJPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 160, 200, 180));

        jPanel1.setBackground(new java.awt.Color(95, 158, 160));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Player4BingoLabel.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        Player4BingoLabel.setForeground(new java.awt.Color(0, 0, 0));
        Player4BingoLabel.setText("No Bingo");
        jPanel1.add(Player4BingoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, -1, -1));

        player2StatusLabel.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        player2StatusLabel.setForeground(new java.awt.Color(0, 0, 0));
        player2StatusLabel.setText("PLAYER 2: ");
        jPanel1.add(player2StatusLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        Player1BingoLabel.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        Player1BingoLabel.setForeground(new java.awt.Color(0, 0, 0));
        Player1BingoLabel.setText("No Bingo");
        jPanel1.add(Player1BingoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, -1));

        player4StatusLabel.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        player4StatusLabel.setForeground(new java.awt.Color(0, 0, 0));
        player4StatusLabel.setText("PLAYER 4: ");
        jPanel1.add(player4StatusLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        player1StatusLabel.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        player1StatusLabel.setForeground(new java.awt.Color(0, 0, 0));
        player1StatusLabel.setText("PLAYER 1: ");
        jPanel1.add(player1StatusLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        player3StatusLabel.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        player3StatusLabel.setForeground(new java.awt.Color(0, 0, 0));
        player3StatusLabel.setText("PLAYER 3: ");
        jPanel1.add(player3StatusLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        Player2BingoLabel.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        Player2BingoLabel.setForeground(new java.awt.Color(0, 0, 0));
        Player2BingoLabel.setText("No Bingo");
        jPanel1.add(Player2BingoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, -1, -1));

        Player3BingoLabel.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        Player3BingoLabel.setForeground(new java.awt.Color(0, 0, 0));
        Player3BingoLabel.setText("No Bingo");
        jPanel1.add(Player3BingoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, -1, -1));

        MainJPanel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 370, 200, 180));

        getContentPane().add(MainJPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1172, 615));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newNumberButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newNumberButtonActionPerformed
        generateRandomPermutation(90);
    }//GEN-LAST:event_newNumberButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameFrame(0).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Custom_GUI_Components.CustomJLabel Card1Circle1;
    private Custom_GUI_Components.CustomJLabel Card1Circle10;
    private Custom_GUI_Components.CustomJLabel Card1Circle11;
    private Custom_GUI_Components.CustomJLabel Card1Circle12;
    private Custom_GUI_Components.CustomJLabel Card1Circle13;
    private Custom_GUI_Components.CustomJLabel Card1Circle14;
    private Custom_GUI_Components.CustomJLabel Card1Circle15;
    private Custom_GUI_Components.CustomJLabel Card1Circle16;
    private Custom_GUI_Components.CustomJLabel Card1Circle17;
    private Custom_GUI_Components.CustomJLabel Card1Circle18;
    private Custom_GUI_Components.CustomJLabel Card1Circle19;
    private Custom_GUI_Components.CustomJLabel Card1Circle2;
    private Custom_GUI_Components.CustomJLabel Card1Circle20;
    private Custom_GUI_Components.CustomJLabel Card1Circle21;
    private Custom_GUI_Components.CustomJLabel Card1Circle22;
    private Custom_GUI_Components.CustomJLabel Card1Circle23;
    private Custom_GUI_Components.CustomJLabel Card1Circle24;
    private Custom_GUI_Components.CustomJLabel Card1Circle25;
    private Custom_GUI_Components.CustomJLabel Card1Circle26;
    private Custom_GUI_Components.CustomJLabel Card1Circle27;
    private Custom_GUI_Components.CustomJLabel Card1Circle3;
    private Custom_GUI_Components.CustomJLabel Card1Circle4;
    private Custom_GUI_Components.CustomJLabel Card1Circle5;
    private Custom_GUI_Components.CustomJLabel Card1Circle6;
    private Custom_GUI_Components.CustomJLabel Card1Circle7;
    private Custom_GUI_Components.CustomJLabel Card1Circle8;
    private Custom_GUI_Components.CustomJLabel Card1Circle9;
    private Custom_GUI_Components.CustomJLabel Card2Circle1;
    private Custom_GUI_Components.CustomJLabel Card2Circle10;
    private Custom_GUI_Components.CustomJLabel Card2Circle11;
    private Custom_GUI_Components.CustomJLabel Card2Circle12;
    private Custom_GUI_Components.CustomJLabel Card2Circle13;
    private Custom_GUI_Components.CustomJLabel Card2Circle14;
    private Custom_GUI_Components.CustomJLabel Card2Circle15;
    private Custom_GUI_Components.CustomJLabel Card2Circle16;
    private Custom_GUI_Components.CustomJLabel Card2Circle17;
    private Custom_GUI_Components.CustomJLabel Card2Circle18;
    private Custom_GUI_Components.CustomJLabel Card2Circle19;
    private Custom_GUI_Components.CustomJLabel Card2Circle2;
    private Custom_GUI_Components.CustomJLabel Card2Circle20;
    private Custom_GUI_Components.CustomJLabel Card2Circle21;
    private Custom_GUI_Components.CustomJLabel Card2Circle22;
    private Custom_GUI_Components.CustomJLabel Card2Circle23;
    private Custom_GUI_Components.CustomJLabel Card2Circle24;
    private Custom_GUI_Components.CustomJLabel Card2Circle25;
    private Custom_GUI_Components.CustomJLabel Card2Circle26;
    private Custom_GUI_Components.CustomJLabel Card2Circle27;
    private Custom_GUI_Components.CustomJLabel Card2Circle3;
    private Custom_GUI_Components.CustomJLabel Card2Circle4;
    private Custom_GUI_Components.CustomJLabel Card2Circle5;
    private Custom_GUI_Components.CustomJLabel Card2Circle6;
    private Custom_GUI_Components.CustomJLabel Card2Circle7;
    private Custom_GUI_Components.CustomJLabel Card2Circle8;
    private Custom_GUI_Components.CustomJLabel Card2Circle9;
    private Custom_GUI_Components.CustomJLabel Card3Circle1;
    private Custom_GUI_Components.CustomJLabel Card3Circle10;
    private Custom_GUI_Components.CustomJLabel Card3Circle11;
    private Custom_GUI_Components.CustomJLabel Card3Circle12;
    private Custom_GUI_Components.CustomJLabel Card3Circle13;
    private Custom_GUI_Components.CustomJLabel Card3Circle14;
    private Custom_GUI_Components.CustomJLabel Card3Circle15;
    private Custom_GUI_Components.CustomJLabel Card3Circle16;
    private Custom_GUI_Components.CustomJLabel Card3Circle17;
    private Custom_GUI_Components.CustomJLabel Card3Circle18;
    private Custom_GUI_Components.CustomJLabel Card3Circle19;
    private Custom_GUI_Components.CustomJLabel Card3Circle2;
    private Custom_GUI_Components.CustomJLabel Card3Circle20;
    private Custom_GUI_Components.CustomJLabel Card3Circle21;
    private Custom_GUI_Components.CustomJLabel Card3Circle22;
    private Custom_GUI_Components.CustomJLabel Card3Circle23;
    private Custom_GUI_Components.CustomJLabel Card3Circle24;
    private Custom_GUI_Components.CustomJLabel Card3Circle25;
    private Custom_GUI_Components.CustomJLabel Card3Circle26;
    private Custom_GUI_Components.CustomJLabel Card3Circle27;
    private Custom_GUI_Components.CustomJLabel Card3Circle3;
    private Custom_GUI_Components.CustomJLabel Card3Circle4;
    private Custom_GUI_Components.CustomJLabel Card3Circle5;
    private Custom_GUI_Components.CustomJLabel Card3Circle6;
    private Custom_GUI_Components.CustomJLabel Card3Circle7;
    private Custom_GUI_Components.CustomJLabel Card3Circle8;
    private Custom_GUI_Components.CustomJLabel Card3Circle9;
    private Custom_GUI_Components.CustomJLabel Card4Circle1;
    private Custom_GUI_Components.CustomJLabel Card4Circle10;
    private Custom_GUI_Components.CustomJLabel Card4Circle11;
    private Custom_GUI_Components.CustomJLabel Card4Circle12;
    private Custom_GUI_Components.CustomJLabel Card4Circle13;
    private Custom_GUI_Components.CustomJLabel Card4Circle14;
    private Custom_GUI_Components.CustomJLabel Card4Circle15;
    private Custom_GUI_Components.CustomJLabel Card4Circle16;
    private Custom_GUI_Components.CustomJLabel Card4Circle17;
    private Custom_GUI_Components.CustomJLabel Card4Circle18;
    private Custom_GUI_Components.CustomJLabel Card4Circle19;
    private Custom_GUI_Components.CustomJLabel Card4Circle2;
    private Custom_GUI_Components.CustomJLabel Card4Circle20;
    private Custom_GUI_Components.CustomJLabel Card4Circle21;
    private Custom_GUI_Components.CustomJLabel Card4Circle22;
    private Custom_GUI_Components.CustomJLabel Card4Circle23;
    private Custom_GUI_Components.CustomJLabel Card4Circle24;
    private Custom_GUI_Components.CustomJLabel Card4Circle25;
    private Custom_GUI_Components.CustomJLabel Card4Circle26;
    private Custom_GUI_Components.CustomJLabel Card4Circle27;
    private Custom_GUI_Components.CustomJLabel Card4Circle3;
    private Custom_GUI_Components.CustomJLabel Card4Circle4;
    private Custom_GUI_Components.CustomJLabel Card4Circle5;
    private Custom_GUI_Components.CustomJLabel Card4Circle6;
    private Custom_GUI_Components.CustomJLabel Card4Circle7;
    private Custom_GUI_Components.CustomJLabel Card4Circle8;
    private Custom_GUI_Components.CustomJLabel Card4Circle9;
    private javax.swing.JLabel HeaderJLabel;
    private javax.swing.JPanel HeaderJPanel;
    private javax.swing.JPanel ImageJPanel;
    private javax.swing.JPanel MainJPanel;
    private javax.swing.JLabel Player1BingoLabel;
    private javax.swing.JPanel Player1CardJPanel;
    private javax.swing.JLabel Player2BingoLabel;
    private javax.swing.JPanel Player2CardJPanel;
    private javax.swing.JLabel Player3BingoLabel;
    private javax.swing.JPanel Player3CardJPanel;
    private javax.swing.JLabel Player4BingoLabel;
    private javax.swing.JPanel Player4CardJPanel;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JPanel jPanel1;
    private Custom_GUI_Components.CustomJButton newNumberButton;
    private Custom_GUI_Components.CustomJLabel numberLabel;
    private javax.swing.JLabel player1Label;
    private javax.swing.JLabel player1StatusLabel;
    private javax.swing.JLabel player2Label;
    private javax.swing.JLabel player2StatusLabel;
    private javax.swing.JLabel player3Label;
    private javax.swing.JLabel player3StatusLabel;
    private javax.swing.JLabel player4Label;
    private javax.swing.JLabel player4StatusLabel;
    // End of variables declaration//GEN-END:variables
}
