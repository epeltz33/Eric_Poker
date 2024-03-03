package player;
import cards.Card;
import cards.StandardCard;
import hand.Hand; // Import the Hand class from the hand package

public class Player {
    private String id;
    private String name;
    private int bank;
    private Hand hand; // Add a Hand object to represent the player's hand

    public Player(String id, String name, int bank) {
        this.id = id;
        this.name = name;
        // System.out.println("Player " + name + " created with bank " + bank); // Debugging Print
        this.bank = bank;
        hand = new Hand(); // Initialize the Hand object
    }

    public Player(String s) {
        this("0000", "Guest", 1000);
    }

    public Player(String id, String name) {
        this(id, name, 1000);
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

    public void printCardRanks() {
        System.out.print(name + "'s Card Ranks: ");
        for (Card card : hand.getCards()) {
            System.out.print(((StandardCard) card).getCardRank() + " ");
        }
        System.out.println();
    }

    public String toString() {
        return "Player: " + name + ", id: " + id + " has a bank of " + bank;
    }
}