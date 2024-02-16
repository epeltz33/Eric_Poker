import cards.Card;
import cards.UnoCard;
import player.Player;


public class Assignment2_1 {
    public static void main(String[] args) {
        Card[] deck = new Card[52];
        for (int i = 0; i < deck.length; i++) {
            deck[i] = new Card((i + 1));
        }
        // array to hold uno cards
        UnoCard[] unoDeck = new UnoCard[108];
        for (int i = 0; i < unoDeck.length; i++) {
            unoDeck[i] = new UnoCard((i + 1));
        }
        // print the deck of cards
        System.out.println("Standard Deck: ");
        printDeck(deck);

        System.out.println("\n\nUno Deck:");
        printDeck(unoDeck);

        shuffleDeck(deck);
        shuffleDeck(unoDeck);

        // print shuffled deck
        System.out.println("\n\nShuffled Standard Deck: ");
        printDeck(deck);

        System.out.println("\n\nShuffled Uno Deck: ");
        printDeck(unoDeck);

        System.out.println();

        // create player objects
        Player fastFreddy = new Player("9765467", "FastFreddy", 2650);
        Player oneEyedJack = new Player("2435573", "OneEyedJack", 1400);

        //Deal 7 Uno cards to freddy (player 1)
        for (int i = 0; i < 7; i++) {
            fastFreddy.getHand().addCard(unoDeck[i]);
        }
        //Deal 5 standard cards to oneEyedJack (player 2)
        for (int i = 0; i < 5; i++) {
            oneEyedJack.getHand().addCard(deck[i]);
        }
        // print hands
        System.out.println("\n" + fastFreddy.getName() + "'s Hand:");
        for (int i = 0; i < fastFreddy.getHand().getCards().length; i++) {
            System.out.print(fastFreddy.getHand().getCards()[i] + "\t");
        }
        System.out.println("\n");

        System.out.println("\n" + oneEyedJack.getName() + "'s Hand:");
        for (int i = 0; i < oneEyedJack.getHand().getCards().length; i++) {
            System.out.print(oneEyedJack.getHand().getCards()[i] + "\t");
        }
        System.out.println("\n\n\n");

    }

    private static void printDeck(Card[] deck) {
        for (int i = 0; i < deck.length; i++) {
            if (i != 0 && i % 13 == 0) {
                System.out.println();
            }
            System.out.print(deck[i] + "\t");
        }
    }

    private static void shuffleDeck(Card[] deck) {
        Card temp;
        int randomIndex;
        for (int i = 0; i < deck.length; i++) {
            randomIndex = (int) (Math.random() * deck.length);
            temp = deck[i];
            deck[i] = deck[randomIndex];
            deck[randomIndex] = temp;
        }
    }
}
