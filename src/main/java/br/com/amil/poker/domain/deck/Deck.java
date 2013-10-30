package br.com.amil.poker.domain.deck;

import java.util.*;

public class Deck {

    private Queue<Card> cards = new LinkedList<Card>();

    public Deck() {

    }

    public Deck (Card ... cards) {
        addCards(cards);
    }

    public void addCards(Card... cards) {
        this.cards.addAll(Arrays.asList(cards));
    }

    public Card getNext() {
        return cards.poll();
    }

    public List<Card> getNext(int number) {
        List<Card> nexts = new LinkedList<Card>();
        for ( int i = 0 ; i < number ; i++) {
            nexts.add(cards.poll());
        }
        return nexts;
    }

    public List<Card> lookAtNext(int number) {
        List<Card> nexts = new LinkedList<Card>();
        for( Card card : cards ) {
            if ( nexts.size() >= number ) break;
            nexts.add(card);
        }
        return nexts;
    }

    public List<Card> getCards() {
        return new ArrayList<Card>(this.cards);
    }

    @Override
    public String toString() {
        return cards.toString();
    }
}
