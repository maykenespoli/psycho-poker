package br.com.amil.poker.domain.hand.game;

import br.com.amil.poker.domain.deck.Card;
import br.com.amil.poker.domain.hand.OrderedHand;
import org.junit.Assert;
import org.junit.Test;

public class StraightExtractorTest {

    StraightExtractor matcher = new StraightExtractor();

    @Test
    public void simpleStraight() {
        Card c1 = new Card(Card.CardSuit.HEARTS, Card.CardNumber.AS);
        Card c2 = new Card(Card.CardSuit.SPADES, Card.CardNumber.TWO);
        Card c3 = new Card(Card.CardSuit.HEARTS, Card.CardNumber.THREE);
        Card c4 = new Card(Card.CardSuit.CLUBS, Card.CardNumber.FOUR);
        Card c5 = new Card(Card.CardSuit.DIAMONDS, Card.CardNumber.FIVE);

        OrderedHand hand = new OrderedHand(c1,c2,c3,c4,c5);

        Game game = matcher.extract(hand);

        Assert.assertNotNull(game);
    }

    @Test
    public void kingASStraight() {
        Card c1 = new Card(Card.CardSuit.CLUBS, Card.CardNumber.JACK);
        Card c2 = new Card(Card.CardSuit.CLUBS, Card.CardNumber.TEN);
        Card c3 = new Card(Card.CardSuit.HEARTS, Card.CardNumber.QUEEN);
        Card c4 = new Card(Card.CardSuit.DIAMONDS, Card.CardNumber.AS);
        Card c5 = new Card(Card.CardSuit.HEARTS, Card.CardNumber.KING);

        OrderedHand hand = new OrderedHand(c1,c2,c3,c4,c5);

        Game game = matcher.extract(hand);

        Assert.assertNotNull(game);
    }

    @Test
    public void notAStraight() {
        Card c1 = new Card(Card.CardSuit.HEARTS, Card.CardNumber.JACK);
        Card c2 = new Card(Card.CardSuit.HEARTS, Card.CardNumber.TEN);
        Card c3 = new Card(Card.CardSuit.HEARTS, Card.CardNumber.QUEEN);
        Card c4 = new Card(Card.CardSuit.HEARTS, Card.CardNumber.FOUR);
        Card c5 = new Card(Card.CardSuit.HEARTS, Card.CardNumber.KING);

        OrderedHand hand = new OrderedHand(c1,c2,c3,c4,c5);

        Game game = matcher.extract(hand);

        Assert.assertNull(game);
    }
}
