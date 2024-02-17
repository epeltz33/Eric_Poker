package cards;

public class Card {
    protected int cardNumber; // Position of the card in the deck starting from 1
    private String suit;  // hearts (h), spades (s), diamonds (d), clubs (c)
    private int suitIndex;  // hearts (1), spades (0), diamonds (2), clubs (3)
    private int cardRank;
    protected String face;
    protected String cardImage;
    protected String color; // Black (b) or Red (r)

    private static int cardsCreated = 0;

    public Card(int cardNumber) {
        this.cardNumber = cardNumber;
        createCard();
        cardsCreated++;
    }

    public void createCard() { // something in this method causing the error I think
        this.suitIndex = (int) ((cardNumber - 1) / 13);
        //System.out.println("CardNumber: " + cardNumber + ", Suit Index: " + this.suitIndex); // Debugging Print
        this.cardRank = ((cardNumber - 1) % 13) + 1;

        setSuit();
        setCardValues();
        setCardImage();

    }



    private void setSuit() {
        switch (suitIndex) {
            case 0:
                this.suit = "s";
                this.color = "b";
                break;
            case 1:
                this.suit = "h";
                this.color = "r";
                break;
            case 2:
                this.suit = "d";
                this.color = "r";
                break;
            case 3:
                this.suit = "c";
                this.color = "b";
                break;

        }
    }

    //public abstract void createCard();

    private void setCardValues() {
        switch (this.cardRank) {
            case 1:
                this.face = "A";
                break;
            case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                    this.face = Integer.toString(this.cardRank); // Convert the integer to a string to represent the card face
                    break;
                case 10:
                    this.face = "T";
                    break;
                case 11:
                    this.face = "J";
                    break;
                case 12:
                    this.face = "Q";
                    break;
                case 13:
                    this.face = "K";
                    break;
                    case 14:
                    this.face = "A";
                    break;
        }
    }

    protected void setCardImage() {
        this.cardImage = (cardNumber) + ".png";
    }

    public String getSuit() {
        return suit;
    }
    public int getCardNumber() {
        return cardNumber;
    }
    public String getFace() {
        return face;
    }
    public String getColor() {
        return color;
    }
    public String getCardImage() {
        return cardImage;
    }
    public int getSuitIndex() {
        return suitIndex;
    }
    public int getCardRank() {
        return cardRank;
    }
    public static int getCardsCreated() {
        return cardsCreated;
    }

    @Override
    public String toString() {
        return suit + face;
    }
}