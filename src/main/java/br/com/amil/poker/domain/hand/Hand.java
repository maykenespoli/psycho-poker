package br.com.amil.poker.domain.hand;

import br.com.amil.poker.domain.deck.Card;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hand {
    protected static final int HAND_SIZE = 5;
    protected ArrayList<Card> cards = new ArrayList<Card>(HAND_SIZE);

    public Hand() {
    }

    public Hand( Card ... cards) {
        if ( cards.length > HAND_SIZE) {
            throw new IllegalArgumentException(String.format("The maximum number of cards per hand is %i", HAND_SIZE));
        }
        this.cards.addAll(Arrays.asList(cards));
    }

    public Hand addCard(Card card) {
        if ( cards.size() < HAND_SIZE ) {
            cards.add(card);
        } else {
            throw new IllegalStateException("Cant add more cards, hand is full");
        }

        return this;
    }

    public Hand setCardAt(int pos, Card card) {
        this.cards.add(pos, card);
        return this;
    }

    public List<Card> getCards() {
        return new ArrayList<Card>(this.cards);
    }
}
