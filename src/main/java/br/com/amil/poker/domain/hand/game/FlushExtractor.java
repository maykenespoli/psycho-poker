package br.com.amil.poker.domain.hand.game;

import br.com.amil.poker.domain.deck.Card;
import br.com.amil.poker.domain.hand.Hand;
import br.com.amil.poker.domain.hand.OrderedHand;

public class FlushExtractor implements GameExtractor {

    @Override
    public Game extract(OrderedHand hand) {
        Game flush = null;
        if ( GameUtil.isAllSameSuit( hand ) ) {
            flush = new FlushGame(hand, Game.GameType.FLUSH);
        }

        return flush;
    }

    private class FlushGame extends Game {

        private FlushGame(Hand hand, GameType type) {
            super(hand, type);
        }

        @Override
        protected Integer getHandScore() {
            int rank = 0;
            for(Card card : getHand()) {
                if ( card.getNumber().equals(Card.CardNumber.AS) ) {
                    rank = 13;
                    break;
                } else {
                    rank = Math.max(rank, card.getNumber().ordinal());
                }
            }
            return rank;
        }
    }
}
