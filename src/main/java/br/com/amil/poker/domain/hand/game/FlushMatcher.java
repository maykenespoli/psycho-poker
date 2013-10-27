package br.com.amil.poker.domain.hand.game;

import br.com.amil.poker.domain.hand.OrderedHand;

import java.util.Arrays;
import java.util.List;

public class FlushMatcher implements GameMatcher {

    @Override
    public List<Game> matches(OrderedHand hand) {
        Game flush = null;
        if ( GameUtil.isAllSameSuit( hand ) ) {
            flush = new Game(hand, Game.GameType.FLUSH);
        }

        return flush == null ? null : Arrays.asList(flush);
    }
}
