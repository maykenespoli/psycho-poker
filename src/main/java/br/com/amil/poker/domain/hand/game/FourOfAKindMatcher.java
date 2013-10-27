package br.com.amil.poker.domain.hand.game;

import br.com.amil.poker.domain.deck.Card;
import br.com.amil.poker.domain.hand.OrderedHand;

import java.util.*;

public class FourOfAKindMatcher implements GameMatcher {

    @Override
    public List<Game> matches(OrderedHand hand) {
        Game foak = null;

        Map<Card.CardNumber, List<Card>>  cardsByNumber = GameUtil.cardsByRank(hand);

        if ( cardsByNumber.size() == 2 ) {
            for (List<Card> cardList : cardsByNumber.values()) {
                if ( cardList.size() == 4 ) {
                    foak = new Game(hand, Game.GameType.FOUR_OF_A_KIND);
                    break;
                }
            }
        }

        return foak == null ? null : Arrays.asList(foak);
    }
}
