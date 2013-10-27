package br.com.amil.poker.domain.hand.game;

import br.com.amil.poker.domain.deck.Card;
import br.com.amil.poker.domain.hand.OrderedHand;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class FullHouseMatcher implements GameMatcher {

    @Override
    public List<Game> matches(OrderedHand hand) {
        Game fh = null;

        Map<Card.CardNumber,List<Card>> cardsByRank = GameUtil.cardsByRank(hand);
        if ( cardsByRank.size() == 2) {
            List<Card> cards = cardsByRank.values().iterator().next();
            if ( cards.size() == 2 || cards.size() == 3 ) {
                fh = new Game(hand, Game.GameType.FULL_HOUSE);
            }
        }

        return fh == null ? null : Arrays.asList(fh);
    }
}
