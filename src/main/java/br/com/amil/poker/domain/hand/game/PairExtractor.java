package br.com.amil.poker.domain.hand.game;

import br.com.amil.poker.domain.deck.Card;
import br.com.amil.poker.domain.hand.Hand;
import br.com.amil.poker.domain.hand.OrderedHand;

import java.util.List;
import java.util.Map;

public class PairExtractor implements GameExtractor {

    @Override
    public Game extract(OrderedHand hand) {
        Game pair = null;
        int pairCount = 0;
        int pairRank = 0;
        Map<Card.CardNumber,List<Card>> cardsByRank = GameUtil.cardsByRank(hand);

        for (List<Card> cardsInRank : cardsByRank.values()) {
            if ( cardsInRank.size() == 2 ) {
                pairCount++;
                if ( cardsInRank.get(0).getNumber() == Card.CardNumber.AS) {
                    pairRank = 13;
                } else {
                    pairRank = Math.max(pairRank, cardsInRank.get(0).getNumber().ordinal());
                }
            }
        }

        if ( pairCount == 1 ) {
            pair = new Game(hand, Game.GameType.ONE_PAIR);
        } else if ( pairCount == 2 ) {
            pair = new PairGame(hand, Game.GameType.TWO_PAIRS, pairRank);
        }

        return pair;
    }

    private class PairGame extends Game {
        private int handScore;
        private PairGame(Hand hand, GameType type, int handScore) {
            super(hand, type);
            this.handScore = handScore;
        }

        @Override
        protected Integer getHandScore() {
            return handScore;
        }
    }
}
