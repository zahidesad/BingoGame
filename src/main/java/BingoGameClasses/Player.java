package BingoGameClasses;

import Custom_GUI_Components.CustomJLabel;

/**
 *
 * @author zahid
 */
public class Player {

    public BingoLinkedList<CustomJLabel> playerCard;
    public STATUS status;
    public int bingoCount = 0;

    public static enum STATUS {
        NO_BINGO,
        FIRST_BINGO,
        SECOND_BINGO,
        BINGO,
    }

    public Player() {
        status = STATUS.NO_BINGO;
    }

    public void checkStatus() {
        bingoCount = 0;
        for (int i = 0; i < 3; i++) {
            int isFoundCounter = 0;
            for (int j = 0; j < 9; j++) {
                if (playerCard.getWithDownNode((i * 9) + j).getIsFound()) {
                    isFoundCounter++;
                }
            }
            if (isFoundCounter == 5) {
                bingoCount++;
            }

        }
        switch (bingoCount) {
            case 0 -> status = STATUS.NO_BINGO;
            case 1 -> status = STATUS.FIRST_BINGO;
            case 2 -> status = STATUS.SECOND_BINGO;
            case 3 -> status = STATUS.BINGO;
            default -> {
            }
        }
    }

    public boolean isOver() {
        return status == STATUS.BINGO;
    }
}
