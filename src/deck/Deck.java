package deck;

import cards.StandardCard;
import java.util.ArrayList;
import java.util.Random;

public class Deck {
    private ArrayList<StandardCard> cards;
    private ArrayList<StandardCard> usedCards;

    public Deck(int i) {
        this.cards = new ArrayList<>();
        this.usedCards = new ArrayList<>();
        initializeDeck();
    }

    private void initializeDeck() {
        for (int i = 1; i <= 52; i++) {
            cards.add(new StandardCard(i));
        }
    }

    public void shuffleDeck() {
        Random rand = new Random();
        for (int i = 0; i < cards.size(); i++) {
            int randomIndex = i + rand.nextInt(cards.size() - i);
            StandardCard temp = cards.get(i);
            cards.set(i, cards.get(randomIndex));
            cards.set(randomIndex, temp);
        }
    }

    public StandardCard dealCard(int index) {
        if (index >= 0 && index < cards.size()) {
            StandardCard card = cards.remove(index);
            return card;
        }
        return null;
    }
    public void addUsedCards(StandardCard card) {
        usedCards.add(card);
    }

    public void restack() {
        while(!usedCards.isEmpty()) {
            cards.add(usedCards.remove(0));
        }
        shuffleDeck();
    }

    public ArrayList<StandardCard> getCards() {
        return cards;
    }

    public ArrayList<StandardCard> getUsedCards() {
        return usedCards;
    }

    @Override
    public String toString() {
        StringBuilder deckComposition = new StringBuilder("Deck: ");
        for(StandardCard card: cards)
            deckComposition.append(card).append(" ");
        return deckComposition.toString();
    }
}