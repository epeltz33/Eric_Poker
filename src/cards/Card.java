package cards;

public class Card {
    protected int cardNumber;
    protected String suit;
    protected int suitIndex;
    protected String color;
    protected int cardRank;
    protected String face;
    protected String cardImage;
    protected static int cardsCreated = 0;

    public Card(int cardNumber) {
        this.cardNumber = cardNumber;
        createCard();
        cardsCreated++;
    }

    private void createCard() { // something in this method causing the error I think
        this.suitIndex = cardNumber % 13;
        System.out.println("CardNumber: " + cardNumber + ", Suit Index: " + this.suitIndex); // Debugging Print
        this.suit = new String[]{"c", "d", "h", "s"}[this.suitIndex]; // Updated array order
        if (suitIndex < 2) this.color = "b";
        else this.color = "r";
        this.cardRank = (cardNumber - 1) % 13 + 1;
        // Correction 2: Correct face for 10
        if ((cardRank == 10)) {
            this.face = "T";
        } else {
            if (cardRank > 10) this.face = "" + "JQKA".charAt(cardRank - 11);
            else this.face = String.valueOf(cardRank);
        }
        this.cardImage = cardNumber + ".png";
    }

    // Getters
    public int getCardNumber() {
        return cardNumber; // Correction 3: Getter for cardNumber
    }

    public static int getCardsCreated() {
        return cardsCreated; // Correction 3: Getter for cardsCreated
    }

    // Existing getters for other attributes
    public String getSuit() { return suit; }
    public String getColor() { return color; }
    public int getCardRank() { return cardRank; }
    public String getFace() { return face; }
    public String getCardImage() { return cardImage; }



}
