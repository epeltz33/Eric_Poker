/*
import player.Player;
import cards.Card;
import hand.Hand;
import java.util.Random;


public class Assignment1_2 {
    public static void main(String[] args) {
        Card[] deck = new Card[52];
        for (int i = 0; i < deck.length; i++) {
            deck[i] = new Card(i + 1);
        }

        // shuffle deck
        System.out.println("Shuffled Deck:");
        shuffleDeck(deck);

        for (int i = 0; i < deck.length; i++) {
            System.out.print(deck[i] + "\t"); // Print the card and a tab space
            if ((i + 1) % 13 == 0) { // After every 13 cards, move to a new line
                System.out.println();

            }
        }
        System.out.println();

        // initialize players
        Player fastFreddy = new Player("9765467", "FastFreddy", 2650);
        Player oneEyedJack = new Player("2435573", "OneEyedJack", 1400);

        // deal 5 cards to each player
        int cardIndex = 0;
        for (int i = 0; i < 5; i++) {
            fastFreddy.getHand().addCard(deck[cardIndex]); // Deal to FastFreddy's hand
            cardIndex++;
            oneEyedJack.getHand().addCard(deck[cardIndex]); // Deal to OneEyedJack's hand
            cardIndex++;
        }

        // Evaluate hands and print hands
        System.out.println("\n5 Card Poker:");
        printPlayerHand(fastFreddy);
        printPlayerHand(oneEyedJack);

        // Compare hands and print winner
        System.out.println("\n Card Poker Results:");
        announceWinner(fastFreddy, oneEyedJack);
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


    private static void printPlayerHand(Player player) {
        System.out.println(player.getName() + "'s Hand:");
        for (int i = 0; i < 5; i++) {
            System.out.print(player.getHand().getCard(i) + "\t");
        }
        System.out.println();
    }


    private static void announceWinner(Player player1, Player player2) {
        int result = player1.getHand().compareHand(player2.getHand());
        if (result > 0) {
            System.out.println("Results: " + player1.getName() + " wins!");
        } else if (result < 0) {
            System.out.println("Results: " + player2.getName() + " wins!");
        } else {
            System.out.println("Results: It's a tie!");
        }
    }
}

*/
