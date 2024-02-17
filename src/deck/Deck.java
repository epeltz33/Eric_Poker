package deck;

import cards.Card;
import java.util.ArrayList;
import java.util.Random;

public class Deck {
    private ArrayList<Card> cards;
    private ArrayList<Card> usedCards;

    public Deck() {
        this.cards = new ArrayList<>();
        this.usedCards = new ArrayList<>();
        initializeDeck();
    }

    private void initializeDeck() {
        for (int i = 1; i <= 52; i++) {
            cards.add(new Card(i));
        }
    }

    // Changed from private static to public instance method and removed parameter
    public void shuffleDeck() {
        Random rand = new Random();
        for (int i = 0; i < cards.size(); i++) {
            int randomIndex = i + rand.nextInt(cards.size() - i);
            Card temp = cards.get(i);
            cards.set(i, cards.get(randomIndex));
            cards.set(randomIndex, temp);
        }
    }

    public Card dealCard(int index) {
        if (index >= 0 && index < cards.size()) {
            Card card = cards.remove(index);
            usedCards.add(card);
            return card;
        }
        return null;
    }

    public void addUsedCards(Card card) {
        usedCards.add(card);
    }

    public void restack() {
        while (!usedCards.isEmpty()) {
            cards.add(usedCards.remove(0));
        }
        shuffleDeck();
    }

    // New method to comply with the Dealer's requirements (1 of 2)
    public Card[] getCards() {
        return cards.toArray(new Card[0]);
    }

    // New method to comply with the Dealer's requirements (2 of 2)
    public Card[] getUsedCards() {
        return usedCards.toArray(new Card[0]); // Return the usedCards ArrayList as an array of Card objects
    }

    @Override
    public String toString() {
        String deckComposition = "Deck: ";
        for (int i = 0; i < cards.size(); i++) { // loop through the cards ArrayList and add each card to the deckComposition string
            deckComposition += cards.get(i) + " ";
        }
        return deckComposition;
    }
}
