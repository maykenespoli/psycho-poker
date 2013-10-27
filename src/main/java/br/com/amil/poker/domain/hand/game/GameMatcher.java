package br.com.amil.poker.domain.hand.game;

import br.com.amil.poker.domain.hand.OrderedHand;

public interface GameMatcher {

    Game matches(OrderedHand hand);

}
