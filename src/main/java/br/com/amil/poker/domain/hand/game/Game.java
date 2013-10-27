package br.com.amil.poker.domain.hand.game;

import br.com.amil.poker.domain.hand.Hand;
import br.com.amil.poker.domain.hand.OrderedHand;

import java.util.ArrayList;
import java.util.List;

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

    public GameType getType() {
        return type;
    }

    public enum GameType {
        HIGHEST_CARD, ONE_PAIR, TWO_PAIRS, THREE_OF_A_KIND, STRAIGHT, FLUSH, FULL_HOUSE, FOUR_OF_A_KIND, STRAIGHT_FLUSH;
    }

    public static Game findBestGameFor(Hand hand) {
        return findBestGameFor(new OrderedHand(hand));
    }

    public static Game findBestGameFor(OrderedHand hand) {
        Game game = null;
        for(GameMatcher matcher : GAME_MATCHERS) {
            game = matcher.matches(hand);
            if ( game != null) break;
        }

        return game;
    }

    private static final List<GameMatcher> GAME_MATCHERS = new ArrayList<GameMatcher>(7){{
        add(new StraightFlushMatcher());
        add(new FourOfAKindMatcher());
        add(new FullHouseMatcher());
        add(new FlushMatcher());
        add(new StraightMatcher());
        add(new ThreeOfAKindMatcher());
        add(new PairMatcher());
    }};
}
