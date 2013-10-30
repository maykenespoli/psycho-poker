package br.com.amil.poker.domain.hand.game;

import br.com.amil.poker.domain.deck.Card;
import br.com.amil.poker.domain.hand.Hand;
import br.com.amil.poker.domain.hand.OrderedHand;

import java.util.List;
import java.util.Map;

public class FourOfAKindExtractor implements GameExtractor {

    @Override
    public Game extract(OrderedHand hand) {
        FourOfAKindGame foak = null;

        Map<Card.CardNumber, List<Card>>  cardsByNumber = GameUtil.cardsByRank(hand);

        if ( cardsByNumber.size() == 2 ) {
            for (List<Card> cardList : cardsByNumber.values()) {
                if ( cardList.size() == 4 ) {
                    foak = new FourOfAKindGame(hand, Game.GameType.FOUR_OF_A_KIND);

                    List<Card> handCards = hand.getCards();
                    handCards.removeAll(cardList);
                    Card rankCard = handCards.get(0);
                    if ( rankCard.getNumber().equals(Card.CardNumber.AS) ) {
                        foak.setRank(13);
                    } else {
                        foak.setRank(rankCard.getNumber().ordinal());
                    }
                    break;
                }
            }
        }

        return foak;
    }

    private class FourOfAKindGame extends Game {
        private int rank;

        public FourOfAKindGame(Hand hand, GameType type) {
            super(hand, type);
        }

        public void setRank(int rank) {
            this.rank = rank;
        }

        @Override
        protected Integer getHandScore() {
            return rank;
        }
    }
}
