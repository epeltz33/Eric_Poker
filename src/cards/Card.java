package cards;

public abstract class Card {
    protected int cardNumber;
    protected String color;
    protected String face;
    protected String cardImage;
    protected static int cardsCreated;

    public Card(int cardNum) {
        this.cardNumber = cardNum;
        createCard();
        cardsCreated++;
    }

    abstract void createCard();

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

    public static int getCardsCreated() {
        return cardsCreated;
    }

    abstract void setCardImage();
}