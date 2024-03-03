
import deck.Deck;
import player.Dealer;
import player.Player;
import cards.StandardCard;

public class Assignment2_3 {
    public static void main(String[] args) {

        // Instantiate a new Dealer object and send its constructor a new 52 card Deck object.
        Dealer dealer = new Dealer(new Deck(52), "Dealer Eric");

        // Print the deck
        System.out.println("Before deal Deck: ");
        printDeck(dealer.getDeck());

        // Create a player object.
        Player player = new Player("Player 1", "FastFreddy");

        // Deal 5 cards each to the player object and to the dealer object
        for (int i = 0; i < 5; i++) {
            dealer.dealCard(player);
            dealer.dealCard(dealer);
        }

        // Print the deck again. This time, cards should be missing.
        System.out.println("\n\nAfter deal Deck: ");
        printDeck(dealer.getDeck());

        // Evaluate the hands to see which won.
        player.getHand().evaluateHand();
        dealer.getHand().evaluateHand();

        // Display the player and dealer hands, including hand description
        System.out.println("\n\nFastFreddy's hand: " + player.getHand());


        // Display the player and dealer card ranks
        player.printCardRanks();
        dealer.printCardRanks();

        // Display the winner
        int result = player.getHand().compareHand(dealer.getHand());
        if(result > 0) {
            System.out.println("\n\nFastFreddy wins!");
        } else if(result < 0) {
            System.out.println("\n\nDealer Eric wins!");
        } else {
            System.out.println("\n\nIt's a tie!");
        }

        // Send the player and dealer cards to the usedCards pile.
        dealer.gatherUsedCards(player);
        dealer.gatherUsedCards(dealer);

        // Print the deck again. This time you should see cards in the deck and used cards
        System.out.println("\n\nAfter discard Deck: ");
        printDeck(dealer.getDeck());

        // Restack the deck
        dealer.getDeck().restack();

        // Print the deck again. The deck should be whole again.
        System.out.println("\n\nAfter restock Deck: ");
        printDeck(dealer.getDeck());
    }

    private static void printDeck(Deck deck) {
        int cardsPerRow = 13;
        for (int i = 0; i < deck.getCards().size(); i++) {
            if (i != 0 && i % cardsPerRow == 0) {
                System.out.println();
            }
            System.out.print(deck.getCards().get(i) + " ");
        }
        System.out.println();
    }
}