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
                if (playerCard.get((i * 9) + j).getIsFound()) {
                    isFoundCounter++;
                }
            }
            if (isFoundCounter == 5) {
                bingoCount++;
            }

        }

        if (bingoCount == 0) {
            status = STATUS.NO_BINGO;
        } else if (bingoCount == 1) {
            status = STATUS.FIRST_BINGO;
        } else if (bingoCount == 2) {
            status = STATUS.SECOND_BINGO;
        } else if (bingoCount == 3) {
            status = STATUS.BINGO;
        }
    }

    public boolean isOver() {
        return status == STATUS.BINGO;
    }
}
