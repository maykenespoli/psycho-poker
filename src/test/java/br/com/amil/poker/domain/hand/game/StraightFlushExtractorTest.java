package br.com.amil.poker.domain.hand.game;

import br.com.amil.poker.domain.deck.Card;
import br.com.amil.poker.domain.hand.OrderedHand;
import org.junit.Assert;
import org.junit.Test;

public class StraightFlushExtractorTest {

    StraightFlushExtractor matcher = new StraightFlushExtractor();

    @Test
    public void simpleStraightFlush() {
        Card c1 = new Card(Card.CardSuit.HEARTS, Card.CardNumber.AS);
        Card c2 = new Card(Card.CardSuit.HEARTS, Card.CardNumber.TWO);
        Card c3 = new Card(Card.CardSuit.HEARTS, Card.CardNumber.THREE);
        Card c4 = new Card(Card.CardSuit.HEARTS, Card.CardNumber.FOUR);
        Card c5 = new Card(Card.CardSuit.HEARTS, Card.CardNumber.FIVE);

        OrderedHand hand = new OrderedHand(c1,c2,c3,c4,c5);

        Game game = matcher.extract(hand);

        Assert.assertNotNull(game);
        Assert.assertEquals(Game.GameType.STRAIGHT_FLUSH, game.getType());
    }

    @Test
    public void kingASStraightFlush() {
        Card c1 = new Card(Card.CardSuit.HEARTS, Card.CardNumber.JACK);
        Card c2 = new Card(Card.CardSuit.HEARTS, Card.CardNumber.TEN);
        Card c3 = new Card(Card.CardSuit.HEARTS, Card.CardNumber.QUEEN);
        Card c4 = new Card(Card.CardSuit.HEARTS, Card.CardNumber.AS);
        Card c5 = new Card(Card.CardSuit.HEARTS, Card.CardNumber.KING);

        OrderedHand hand = new OrderedHand(c1,c2,c3,c4,c5);

        Game game = matcher.extract(hand);

        Assert.assertNotNull(game);
        Assert.assertEquals(Game.GameType.STRAIGHT_FLUSH, game.getType());
    }

    @Test
    public void notAStraightFlush() {
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
