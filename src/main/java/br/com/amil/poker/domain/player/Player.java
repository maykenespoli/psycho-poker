package br.com.amil.poker.domain.player;

import br.com.amil.poker.domain.deck.Card;
import br.com.amil.poker.domain.hand.Hand;
import br.com.amil.poker.domain.hand.game.Game;

import java.util.Collection;

public interface Player {

    void setHand(Hand hand);

    Collection<Card> playDiscard();

    void addCards(Card ... cards);

    Game showGame();
}
