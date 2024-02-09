
package player;

import cards.Card;
import hand.Hand; // Import the Hand class from the hand package

public class Player {
    private String id;
    private String name;
    private int bank;
    private Hand hand; // Add a Hand object to represent the player's hand

    public Player(String id, String name, int bank) {
        this.id = id;
        this.name = name;
        this.bank = bank;
        this.hand = new Hand(); // Initialize the Hand object
    }

    public Player(String id, String name) {
        this(id, name, 1000);
    }

    public Player() {
        this("00000", "Guest", 1000);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBank() {
        return bank;
    }

    public void setBank(int bank) {
        this.bank = bank;
    }

    // Getter for the Hand object
    public Hand getHand() {
        return hand;
    }

    // Setter for the Hand object, to replace the player's hand
    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public void addCardToHand(Card card) {
        this.hand.addCard(card);
    }

    @Override
    public String toString() {
        return String.format("%s %s %d", id, name, bank);
    }
}
