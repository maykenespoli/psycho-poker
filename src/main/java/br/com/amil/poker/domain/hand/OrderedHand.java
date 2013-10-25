package br.com.amil.poker.domain.hand;

import br.com.amil.poker.domain.deck.Card;

import java.util.Collections;
import java.util.Comparator;

public class OrderedHand extends Hand {

    public OrderedHand(Hand hand) {
        this(hand.getCards().toArray(new Card[]{}));
    }

    public OrderedHand(Card... cards) {
        super(cards);
        order();
    }

    @Override
    public Hand addCard(Card card) {
        super.addCard(card);
        order();
        return this;
    }

    @Override
    public Hand setCardAt(int pos, Card card) {
        super.setCardAt(pos, card);
        order();
        return this;
    }

    private void order() {
        Collections.sort(this.cards, CARD_COMPARATOR);
    }

    private static final Comparator<Card>  CARD_COMPARATOR = new Comparator<Card> () {
        @Override
        public int compare(Card card, Card card2) {
            return card.getNumber().compareTo(card2.getNumber());
        }
    };
}
