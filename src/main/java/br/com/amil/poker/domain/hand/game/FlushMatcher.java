package br.com.amil.poker.domain.hand.game;

import br.com.amil.poker.domain.hand.OrderedHand;

public class FlushMatcher implements GameMatcher {

    @Override
    public Game matches(OrderedHand hand) {
        Game flush = null;
        if ( GameUtil.isAllSameSuit( hand ) ) {
            flush = new Game(hand, Game.GameType.FLUSH);
        }

        return flush;
    }
}
