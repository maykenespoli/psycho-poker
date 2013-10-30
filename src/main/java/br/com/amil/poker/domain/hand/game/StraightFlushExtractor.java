package br.com.amil.poker.domain.hand.game;

import br.com.amil.poker.domain.hand.OrderedHand;

public class StraightFlushExtractor extends StraightExtractor implements GameExtractor {

    @Override
    public Game extract(OrderedHand hand) {
        Game sf = null;
        if ( GameUtil.isAllSameSuit(hand) && GameUtil.largestSequence(hand) == 5 ) {
            sf = new StraightGame(hand, Game.GameType.STRAIGHT_FLUSH);
        }

        return sf;
    }

}
