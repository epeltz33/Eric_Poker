import deck.Deck;
import player.Dealer;
import player.Player;

public class Assignment2_2 {
    public static void main(String[] args) {

        Dealer dealer = new Dealer(new Deck());
        System.out.println("Initial Deck: " + dealer.getDeck());

        Player player = new Player("Player 1");
        for (int i = 0; i < 5; i++) {
            dealer.dealCard(player);
            dealer.dealCard(dealer); // Assuming Dealer class extends Player
        }

        System.out.println("Deck after dealing cards: " + dealer.getDeck());

        // Evaluate hands - This requires implementing a method to evaluate and compare hands


        // Display hands and determine the winner

        // Sending cards to used pile
        dealer.gatherUsedCards(player);
        dealer.gatherUsedCards(dealer);

        System.out.println("Deck with used cards: " + dealer.getDeck());

        // Restack the deck
        dealer.getDeck().restack();

        System.out.println("Deck after restacking: " + dealer.getDeck());
    }
}
