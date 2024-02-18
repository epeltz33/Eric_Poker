import java.util.ArrayList;
import java.util.Random;

public class Lab11_3 {
    public static void main(String[] args) {
        ArrayList<Integer> deck = new ArrayList<>();
        int[] player1 = new int[5];
        int[] player2 = new int[5];

        // Fill the deck with numbers 1 to 52
        for (int i = 1; i <= 52; i++) {
            deck.add(i);
        }

        // Print the deck before shuffle
        System.out.println("Deck before shuffle:");
        printDeck(deck);


        shuffleDeck(deck);

        // Print the deck after shuffle
        System.out.println("\nDeck after shuffle:");
        printDeck(deck);

        // Deal cards to players
        for (int i = 0; i < 5; i++) {
            player1[i] = deck.remove(0);
            player2[i] = deck.remove(0);
        }

        // Prepare and display each player's hand
        String player1Hand = prepareHand(player1);
        String player2Hand = prepareHand(player2);

        System.out.println("\nPlayer 2's hand: " + player2Hand + "\nPlayer 1's hand: " + player1Hand);

        // Print the deck after cards dealt
        System.out.println("\nDeck after cards dealt:");
        printDeck(deck);
    }

    // Method to shuffle the deck
    private static void shuffleDeck(ArrayList<Integer> deck) {
        Random rand = new Random();
        for (int i = 0; i < deck.size(); i++) {
            // Generate a random index between i and deck.size() - 1
            int randomIndex = i + rand.nextInt(deck.size() - i);
            // Swap the elements at indices i and randomIndex
            Integer temp = deck.get(i);
            deck.set(i, deck.get(randomIndex));
            deck.set(randomIndex, temp);
        }
    }

    // Method to print the deck in 13 columns
    private static void printDeck(ArrayList<Integer> deck) {
        for (int i = 0; i < deck.size(); i++) {
            System.out.printf("%-3d ", deck.get(i));
            if ((i + 1) % 13 == 0)
                System.out.println();
        }
    }

    // Method to prepare a player's hand for display without using StringBuilder
    private static String prepareHand(int[] hand) {
        String result = "";
        for (int card : hand) {
            result += card + "  ";
        }
        return result.trim();
    }
}
