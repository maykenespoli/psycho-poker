package br.com.amil.poker.domain.hand;

import br.com.amil.poker.domain.deck.Card;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;


public class OrderedHandTest {

    @Test
    public void orderHand() {

        Card asOfHearts = new Card(Card.CardSuit.HEARTS, Card.CardNumber.AS);
        Card threeOfDiamonds = new Card(Card.CardSuit.DIAMONDS, Card.CardNumber.THREE);
        Card jackOfClubs = new Card(Card.CardSuit.CLUBS, Card.CardNumber.JACK);
        Card queenOfHearts = new Card(Card.CardSuit.HEARTS, Card.CardNumber.QUEEN);
        Card kingOfDiamonds = new Card(Card.CardSuit.DIAMONDS, Card.CardNumber.KING);

        Hand hand = new Hand(kingOfDiamonds, threeOfDiamonds,jackOfClubs,asOfHearts,queenOfHearts);

        Assert.assertEquals(Arrays.asList(asOfHearts, threeOfDiamonds, jackOfClubs, queenOfHearts, kingOfDiamonds), new OrderedHand(hand).getCards());
    }
}
