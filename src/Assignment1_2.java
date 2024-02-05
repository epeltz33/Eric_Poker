// Assume necessary imports for Player and Card classes
import player.Player;
import cards.Card;
import java.util.ArrayList;
import java.util.Collections;

public class Assignment1_2 {
    public static void main(String[] args) {
        ArrayList<Card> deck = new ArrayList<>(52);
        for (int i = 1; i <= 52; i++) {
            deck.add(new Card(i));
        }

        Collections.shuffle(deck);

        Player fastFreddy = new Player("9765467", "FastFreddy", 2650);
        Player oneEyedJack = new Player("2435573", "OneEyedJack", 1400);

        for (int i = 0; i < 5; i++) {
            fastFreddy.getHand().addCard(deck.remove(0));
            oneEyedJack.getHand().addCard(deck.remove(0));
        }

        fastFreddy.getHand().evaluateHand();
        oneEyedJack.getHand().evaluateHand();

        printPlayerHand(fastFreddy);
        printPlayerHand(oneEyedJack);

        // Compare hands and announce a winner
        announceWinner(fastFreddy, oneEyedJack);
    }

    private static void printPlayerHand(Player player) {
        System.out.println(player.getName() + "'s hand: " + player.getHand());
        System.out.println("Description: " + player.getHand().getHandDescr());
    }

    private static void announceWinner(Player player1, Player player2) {
        int result = player1.getHand().compareHand(player2.getHand());
        if (result > 0) {
            System.out.println(player1.getName() + " wins!");
        } else if (result < 0) {
            System.out.println(player2.getName() + " wins!");
        } else {
            System.out.println("It's a tie!");
        }
    }
}
