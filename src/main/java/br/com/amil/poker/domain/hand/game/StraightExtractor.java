package br.com.amil.poker.domain.hand.game;

import br.com.amil.poker.domain.deck.Card;
import br.com.amil.poker.domain.hand.Hand;
import br.com.amil.poker.domain.hand.OrderedHand;

public class StraightExtractor implements GameExtractor {

    @Override
    public Game extract(OrderedHand hand) {
        Game straight = null;
        if ( !GameUtil.isAllSameSuit(hand) && GameUtil.largestSequence(hand) == 5 ) {
            straight = new StraightGame(hand, Game.GameType.STRAIGHT);
        }

        return straight;
    }

    protected class StraightGame extends Game {

        public StraightGame(Hand hand, GameType type) {
            super(hand, type);
        }

        @Override
        protected Integer getHandScore() {
            int handScore = super.getHandScore();
            boolean hasAS = false;
            boolean hasKing = false;
            for ( Card card : getHand() ) {
                if ( card.getNumber().equals(Card.CardNumber.AS) ) {
                    hasAS = true;
                }
                if ( card.getNumber().equals(Card.CardNumber.KING) ) {
                    hasKing = true;
                }
            }
            if ( hasAS && hasKing ) {
                handScore += 13;
            }
            return handScore;
        }
    }
}
