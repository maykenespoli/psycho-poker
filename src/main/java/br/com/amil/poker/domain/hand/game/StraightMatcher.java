package br.com.amil.poker.domain.hand.game;

import br.com.amil.poker.domain.hand.OrderedHand;

import java.util.Arrays;
import java.util.List;

public class StraightMatcher implements GameMatcher{

    @Override
    public List<Game> matches(OrderedHand hand) {
        Game straight = null;
        if ( !GameUtil.isAllSameSuit(hand) && GameUtil.largestSequence(hand) == 5 ) {
            straight = new Game(hand, Game.GameType.STRAIGHT_FLUSH);
        }

        return straight == null ? null : Arrays.asList(straight);
    }
}
