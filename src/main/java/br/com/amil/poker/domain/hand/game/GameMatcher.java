package br.com.amil.poker.domain.hand.game;

import br.com.amil.poker.domain.hand.OrderedHand;

import java.util.List;

public interface GameMatcher {

    List<Game> matches(OrderedHand hand);

}
