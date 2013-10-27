package br.com.amil.poker.domain.hand.game;

import br.com.amil.poker.domain.deck.Card;
import br.com.amil.poker.domain.hand.OrderedHand;

import java.util.List;
import java.util.Map;

public class ThreeOfAKindMatcher implements GameMatcher {

    @Override
    public Game matches(OrderedHand hand) {
        Game toak = null;

        Map<Card.CardNumber,List<Card>> cardsByRank = GameUtil.cardsByRank(hand);

        if ( cardsByRank.size() == 3) {
            for (List<Card> cardsInRank : cardsByRank.values()) {
                if (cardsInRank.size() == 3) {
                    toak = new Game(hand, Game.GameType.THREE_OF_A_KIND);
                } else if (cardsInRank.size() != 1) {
                    break;
                }
            }
        }

        return toak;
    }
}
