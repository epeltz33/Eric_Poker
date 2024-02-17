package cards;

public class UnoCard extends Card {

    private boolean reverse;
    private int drawAmount;
    private boolean wild;
    private boolean skip;

    public UnoCard(int cardNumber) {
        super(cardNumber); // Call the constructor of the parent 'Card' class
    }


    @Override
    public void createCard() {
        setColor();
        setCardValues();

        super.setCardImage(); // in card class
    }


    public void setColor() {
        if (cardNumber > 96) {
            setLastCardsColor();
            return;
        }
        int colorNum = (cardNumber - 1) / 24;
        switch (colorNum) {
            case 0:
                color = "r";
                break;
            case 1:
                color = "g";
                break;
            case 2:
                color = "b";
                break;
            case 3:
                color = "y";
                break;
        }
    }

    private void setLastCardsColor() {
        switch (cardNumber) {
            case 97:
                color = "r";
                break;
            case 98:
                color = "y";
                break;
            case 99:
                color = "g";
                break;
            case 100:
                color = "b";
                break;
            default:
                color = "w";
                break;
        }
    }

    public void setCardValues() {
        if (cardNumber > 96) {
            setLastCardsValues();
            return;
        }
        // defaults
        drawAmount = 0;
        reverse = false; // overridden by reverse card (11)
        skip = false; // overridden by skip card (10)
        wild = false; // overridden by wild card (13)

        int cardRank = (cardNumber - 1) % 12 + 1;

        switch (cardRank) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                face = Integer.toString(cardRank);
                break;
            case 10:
                face = "SK";
                skip = true;
                break;
            case 11:
                face = "RV";
                reverse = true;
                break;
            case 12:
                face = "DR";
                drawAmount = 2;
                break;
        }
    }

    private void setLastCardsValues() {
        // defaults
        drawAmount = 0;
        reverse = false;
        skip = false;
        wild = false;

        switch (cardNumber) {
            case 97:
            case 98:
            case 99:
            case 100:
                face = "0";
                break;
            case 101:
            case 102:
            case 103:
            case 104:
                face = "WD";
                wild = true;
                break;
            default:
                face = "DR4";
                wild = true;
                drawAmount = 4;
                break;
        }
    }

    @Override
    public String toString() {
        if (wild) {
            return face;
        } else {
            return color + face;
        }
    }

    public boolean isReverse() {
        return reverse;
    }

    public int getDrawAmount() {
        return drawAmount;
    }

    public boolean isWild() {
        return wild;
    }

    public boolean isSkip() {
        return skip;
    }
}
