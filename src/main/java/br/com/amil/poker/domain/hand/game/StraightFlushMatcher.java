package br.com.amil.poker.domain.hand.game;

import br.com.amil.poker.domain.hand.OrderedHand;

import java.util.Arrays;
import java.util.List;

public class StraightFlushMatcher implements GameMatcher {

    @Override
    public List<Game> matches(OrderedHand hand) {
        Game sf = null;
        if ( GameUtil.isAllSameSuit(hand) && GameUtil.largestSequence(hand) == 5 ) {
            sf = new Game(hand, Game.GameType.STRAIGHT_FLUSH);
        }

        return sf == null ? null : Arrays.asList(sf);
    }

}
