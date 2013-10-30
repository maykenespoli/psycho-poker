package br.com.amil.poker.domain.hand.game;

import br.com.amil.poker.domain.deck.Card;
import br.com.amil.poker.domain.hand.Hand;
import br.com.amil.poker.domain.hand.OrderedHand;

import java.util.ArrayList;
import java.util.List;

public class Game implements Comparable<Game> {

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

    protected Integer getHandScore() {
        int score = 0;
        for ( Card card : hand) {
            score += card.getNumber() == Card.CardNumber.AS ? 13 : card.getNumber().ordinal();
        }
        return score;
    }

    @Override
    public int compareTo(Game game) {
        int compareResult = this.getType().compareTo(game.getType());
        return compareResult == 0 ? this.getHandScore().compareTo(game.getHandScore()) : compareResult;
    }

    public enum GameType {
        HIGHEST_CARD, ONE_PAIR, TWO_PAIRS, THREE_OF_A_KIND, STRAIGHT, FLUSH, FULL_HOUSE, FOUR_OF_A_KIND, STRAIGHT_FLUSH;
    }

    public static Game findBestGameFor(Hand hand) {
        return findBestGameFor(new OrderedHand(hand));
    }

    public static Game findBestGameFor(OrderedHand hand) {
        Game game = null;
        for(GameExtractor matcher : GAME_MATCHERS) {
            game = matcher.extract(hand);
            if ( game != null) break;
        }

        if ( game == null ) {
            game = new Game(hand, GameType.HIGHEST_CARD);
        }

        return game;
    }

    private static final List<GameExtractor> GAME_MATCHERS = new ArrayList<GameExtractor>(7){{
        add(new StraightFlushExtractor());
        add(new FourOfAKindExtractor());
        add(new FullHouseExtractor());
        add(new FlushExtractor());
        add(new StraightExtractor());
        add(new ThreeOfAKindExtractor());
        add(new PairExtractor());
    }};
}
