package br.com.amil.poker.domain.hand.game;

import br.com.amil.poker.domain.deck.Card;
import br.com.amil.poker.domain.hand.Hand;
import br.com.amil.poker.domain.hand.OrderedHand;

import java.util.List;

final class GameUtil {

    public static boolean isAllSameSuit(Hand hand) {
        Card last = null;
        for( Card card : hand ) {
            if ( last == null || last.getSuit().equals(card.getSuit()) ) {
                last = card;
            } else {
                return false;
            }
        }
        return true;
    }

    public static int largestSequence( OrderedHand hand ) {
        int seqSize = 0;
        int maxSize = 0;
        int valueDiff;
        List<Card> cards = hand.getCards();
        for (int i = 0, j = 1 ; i < cards.size() - 1; i++, j++ ) {
            valueDiff = cards.get(j).getNumber().ordinal() - cards.get(i).getNumber().ordinal();
            if ( valueDiff == 1 ) {
                seqSize++;
            } else if (valueDiff > 1) {
                maxSize = Math.max(maxSize, seqSize);
                seqSize = 0;
            }
        }

        if ( Card.CardNumber.AS.equals(hand.getFirstCard().getNumber()) && Card.CardNumber.KING.equals(hand.getLastCard().getNumber())) {
            seqSize++;
        }
        maxSize = Math.max(maxSize, seqSize);

        return maxSize == 0 ? 0 : maxSize+1;
    }
}
