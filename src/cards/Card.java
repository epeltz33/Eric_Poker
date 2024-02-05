package cards;

public class Card {
    private final int cardNumber;
    private String suit;
    private int suitIndex;
    private String color;
    private int cardRank;
    private String face;
    private String cardImage;
    private static int cardsCreated = 0;

    public Card(int cardNumber) {
        this.cardNumber = cardNumber;
        createCard(); // Correction 1: Call createCard from constructor
        cardsCreated++;
    }

    private void createCard() {
        this.suitIndex = (cardNumber - 1) / 13;
        this.suit = new String[]{"s", "h", "d", "c"}[this.suitIndex];
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
