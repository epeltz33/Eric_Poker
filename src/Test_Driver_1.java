import cards.Card;


public class Test_Driver_1 {

    public static void main(String[] args) {
        Card[] deck = new Card[52];
        // Create the deck
        for (int i = 0; i < deck.length; i++) {
            deck[i] = new Card(i + 1);
        }


        shuffleDeck(deck);

        // Print the shuffled deck in rows of 13 cards
        System.out.println("Shuffled Deck:");
        int cardsPerRow = 13;
        for (int i = 0; i < deck.length; i++) {
            System.out.print(deck[i].toString() + " ");
            if ((i + 1) % cardsPerRow == 0) {
                System.out.println(); // Move to a new line after every 13 cards
            }
        }
    }
    // shuffleDeck method
    private static void shuffleDeck(Card[] deck) {
        for (int i = 0; i < deck.length; i++) {
            int index = (int) (Math.random() * deck.length);
            Card temp = deck[i];
            deck[i] = deck[index];
            deck[index] = temp;
        }
    }
}