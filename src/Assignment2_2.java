import deck.Deck;
import player.Dealer;
import player.Player;
//import cards.UnoCard;

public class Assignment2_2 {
    public static void main(String[] args) {

        // Create the dealer with new deck of 52 cards
        Dealer dealer = new Dealer(new Deck(52),  "Dealer");

        System.out.println("Initial Deck: \n" + dealer.getDeck());

        Player eric = new Player("Player 1");
        for (int i = 0; i < 5; i++) {
            dealer.dealCard(eric);
            dealer.dealCard(dealer);
        }

        System.out.println("\n\nDeck after dealing cards: " + dealer.getDeck());

        // Evaluate hands - This requires implementing a method to evaluate and compare hands


        // Display hands and determine the winner
        System.out.println("\n\nPlayer's hand: " + eric.getHand());
        System.out.println("\n\nDealer's hand: " + dealer.getHand());


        // Sending cards to used pile
        dealer.gatherUsedCards(eric);
        dealer.gatherUsedCards(dealer);

        System.out.println("\n\nDeck after discard: " + dealer.getDeck());

        // Restack the deck
        dealer.getDeck().restack();

        System.out.println("\n\nDeck after restacking: " + dealer.getDeck());
    }
}
