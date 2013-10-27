package br.com.amil.poker.domain.hand.game;

import br.com.amil.poker.domain.deck.Card;
import br.com.amil.poker.domain.hand.OrderedHand;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class StraightMatcherTest {

    StraightMatcher matcher = new StraightMatcher();

    @Test
    public void simpleStraight() {
        Card c1 = new Card(Card.CardSuit.HEARTS, Card.CardNumber.AS);
        Card c2 = new Card(Card.CardSuit.SPADES, Card.CardNumber.TWO);
        Card c3 = new Card(Card.CardSuit.HEARTS, Card.CardNumber.THREE);
        Card c4 = new Card(Card.CardSuit.CLUBS, Card.CardNumber.FOUR);
        Card c5 = new Card(Card.CardSuit.DIAMONDS, Card.CardNumber.FIVE);

        OrderedHand hand = new OrderedHand(c1,c2,c3,c4,c5);

        List<Game> games = matcher.matches(hand);

        Assert.assertNotNull(games);
        Assert.assertTrue(games.size() == 1);
    }

    @Test
    public void kingASStraight() {
        Card c1 = new Card(Card.CardSuit.CLUBS, Card.CardNumber.JACK);
        Card c2 = new Card(Card.CardSuit.CLUBS, Card.CardNumber.TEN);
        Card c3 = new Card(Card.CardSuit.HEARTS, Card.CardNumber.QUEEN);
        Card c4 = new Card(Card.CardSuit.DIAMONDS, Card.CardNumber.AS);
        Card c5 = new Card(Card.CardSuit.HEARTS, Card.CardNumber.KING);

        OrderedHand hand = new OrderedHand(c1,c2,c3,c4,c5);

        List<Game> games = matcher.matches(hand);

        Assert.assertNotNull(games);
        Assert.assertTrue(games.size() == 1);
    }

    @Test
    public void notAStraight() {
        Card c1 = new Card(Card.CardSuit.HEARTS, Card.CardNumber.JACK);
        Card c2 = new Card(Card.CardSuit.HEARTS, Card.CardNumber.TEN);
        Card c3 = new Card(Card.CardSuit.HEARTS, Card.CardNumber.QUEEN);
        Card c4 = new Card(Card.CardSuit.HEARTS, Card.CardNumber.FOUR);
        Card c5 = new Card(Card.CardSuit.HEARTS, Card.CardNumber.KING);

        OrderedHand hand = new OrderedHand(c1,c2,c3,c4,c5);

        List<Game> games = matcher.matches(hand);

        Assert.assertNull(games);
    }
}
