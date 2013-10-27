package br.com.amil.poker.domain.hand.game;

import br.com.amil.poker.domain.deck.Card;
import br.com.amil.poker.domain.hand.OrderedHand;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class FourOfAKindMatcherTest {

    FourOfAKindMatcher matcher = new FourOfAKindMatcher();

    @Test
    public void fourOfAKingTest() {
        Card c1 = new Card(Card.CardSuit.HEARTS, Card.CardNumber.AS);
        Card c2 = new Card(Card.CardSuit.DIAMONDS, Card.CardNumber.AS);
        Card c3 = new Card(Card.CardSuit.CLUBS, Card.CardNumber.AS);
        Card c4 = new Card(Card.CardSuit.SPADES, Card.CardNumber.AS);
        Card c5 = new Card(Card.CardSuit.HEARTS, Card.CardNumber.FIVE);

        OrderedHand hand = new OrderedHand(c1,c2,c3,c4,c5);

        Game game = matcher.matches(hand);

        Assert.assertNotNull(game);
    }

    @Test
    public void notAFourOfAKingTest() {
        Card c1 = new Card(Card.CardSuit.HEARTS, Card.CardNumber.AS);
        Card c2 = new Card(Card.CardSuit.DIAMONDS, Card.CardNumber.AS);
        Card c3 = new Card(Card.CardSuit.CLUBS, Card.CardNumber.AS);
        Card c4 = new Card(Card.CardSuit.SPADES, Card.CardNumber.TWO);
        Card c5 = new Card(Card.CardSuit.HEARTS, Card.CardNumber.FIVE);

        OrderedHand hand = new OrderedHand(c1,c2,c3,c4,c5);

        Game game = matcher.matches(hand);

        Assert.assertNull(game);
    }
}
