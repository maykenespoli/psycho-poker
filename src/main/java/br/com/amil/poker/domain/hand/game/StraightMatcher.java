package br.com.amil.poker.domain.hand.game;

import br.com.amil.poker.domain.hand.OrderedHand;

public class StraightMatcher implements GameMatcher{

    @Override
    public Game matches(OrderedHand hand) {
        Game straight = null;
        if ( !GameUtil.isAllSameSuit(hand) && GameUtil.largestSequence(hand) == 5 ) {
            straight = new Game(hand, Game.GameType.STRAIGHT);
        }

        return straight;
    }
}
