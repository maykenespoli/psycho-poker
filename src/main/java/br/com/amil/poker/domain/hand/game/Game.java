package br.com.amil.poker.domain.hand.game;

import br.com.amil.poker.domain.hand.Hand;

public class Game {

    private Hand hand;
    private GameType type;

    public Game(Hand hand, GameType type) {
        this.hand = hand;
        this.type = type;
    }

    public Hand getHand() {
        return hand;
    }

    public enum GameType {
        HIGHEST_CARD, ONE_PAIR, TWO_PAIRS, THREE_OF_A_KIND, STRAIGHT, FLUSH, FULL_HOUSE, FOUR_OF_A_KIND, STRAIGHT_FLUSH;
    }
}
