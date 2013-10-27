package br.com.amil.poker.domain.hand.game;

import br.com.amil.poker.domain.hand.OrderedHand;

public class StraightFlushMatcher implements GameMatcher {

    @Override
    public Game matches(OrderedHand hand) {
        Game sf = null;
        if ( GameUtil.isAllSameSuit(hand) && GameUtil.largestSequence(hand) == 5 ) {
            sf = new Game(hand, Game.GameType.STRAIGHT_FLUSH);
        }

        return sf;
    }

}
