import cards.Card;
import cards.UnoCard;
import player.Player;

import java.util.Random;

public class Assignment2_1 {
    public static void main(String[] args) {
        // Create arrays for decks
        Card[] deck = new Card[52];
        UnoCard[] unoDeck = new UnoCard[108];

        // Create the standard and Uno cards
        for (int i = 0; i < deck.length; i++) {
            deck[i] = new Card(i + 1);
        }
        for (int i = 0; i < unoDeck.length; i++) {
            unoDeck[i] = new UnoCard(i + 1);
        }

        // Print and shuffle
        printDeck(deck);
        printDeck(unoDeck);

        shuffleDeck(deck);
        shuffleDeck(unoDeck);

        printDeck(deck);
        printDeck(unoDeck);

        // Create Players
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");

        // Deal Uno Cards to player1 and Cards to player2

        // Display Player Hands
        System.out.println("\nPlayer 1's Hand:");
        System.out.println(player1.getHand());
        System.out.println("\nPlayer 2's Hand:");
        System.out.println(player2.getHand());
    }

    // Helper Methods
    private static void printDeck(Card[] deck) {
        for (Card card : deck) {
            System.out.println(card);
        }
    }

    private static void shuffleDeck(Card[] deck) {
        Random rand = new Random();
        for (int i = 0; i < deck.length; i++) {
            int randomIndex = rand.nextInt(deck.length);
            Card temp = deck[i];
            deck[i] = deck[randomIndex];
            deck[randomIndex] = temp;
        }
    }
}