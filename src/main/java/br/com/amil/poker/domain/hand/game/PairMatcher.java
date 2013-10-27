package br.com.amil.poker.domain.hand.game;

import br.com.amil.poker.domain.deck.Card;
import br.com.amil.poker.domain.hand.OrderedHand;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class PairMatcher implements GameMatcher {

    @Override
    public List<Game> matches(OrderedHand hand) {
        Game pair = null;
        int pairCount = 0;
        Map<Card.CardNumber,List<Card>> cardsByRank = GameUtil.cardsByRank(hand);

        for (List<Card> cardsInRank : cardsByRank.values()) {
            if ( cardsInRank.size() == 2 ) {
                pairCount++;
            }
        }

        if ( pairCount == 1 ) {
            pair = new Game(hand, Game.GameType.ONE_PAIR);
        } else if ( pairCount == 2 ) {
            pair = new Game(hand, Game.GameType.TWO_PAIRS);
        }

        return pair == null ? null : Arrays.asList(pair);
    }
}
