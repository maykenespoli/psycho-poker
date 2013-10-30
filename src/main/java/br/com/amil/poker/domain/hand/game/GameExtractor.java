package br.com.amil.poker.domain.hand.game;

import br.com.amil.poker.domain.hand.OrderedHand;

public interface GameExtractor {

    Game extract(OrderedHand hand);

}
