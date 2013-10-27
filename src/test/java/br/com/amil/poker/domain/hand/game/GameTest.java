package br.com.amil.poker.domain.hand.game;

import br.com.amil.poker.domain.deck.Card;
import br.com.amil.poker.domain.hand.OrderedHand;
import org.junit.Assert;
import org.junit.Test;

public class GameTest {

    @Test
    public void findSimpleStraightFlush() {
        Card c1 = new Card(Card.CardSuit.HEARTS, Card.CardNumber.AS);
        Card c2 = new Card(Card.CardSuit.HEARTS, Card.CardNumber.TWO);
        Card c3 = new Card(Card.CardSuit.HEARTS, Card.CardNumber.THREE);
        Card c4 = new Card(Card.CardSuit.HEARTS, Card.CardNumber.FOUR);
        Card c5 = new Card(Card.CardSuit.HEARTS, Card.CardNumber.FIVE);

        OrderedHand hand = new OrderedHand(c1,c2,c3,c4,c5);

        Game game = Game.findBestGameFor(hand);

        Assert.assertNotNull(game);
        Assert.assertEquals(Game.GameType.STRAIGHT_FLUSH, game.getType());
    }

    @Test
    public void findKingASStraightFlush() {
        Card c1 = new Card(Card.CardSuit.HEARTS, Card.CardNumber.JACK);
        Card c2 = new Card(Card.CardSuit.HEARTS, Card.CardNumber.TEN);
        Card c3 = new Card(Card.CardSuit.HEARTS, Card.CardNumber.QUEEN);
        Card c4 = new Card(Card.CardSuit.HEARTS, Card.CardNumber.AS);
        Card c5 = new Card(Card.CardSuit.HEARTS, Card.CardNumber.KING);

        OrderedHand hand = new OrderedHand(c1,c2,c3,c4,c5);

        Game game = Game.findBestGameFor(hand);

        Assert.assertNotNull(game);
        Assert.assertEquals(Game.GameType.STRAIGHT_FLUSH, game.getType());
    }

    @Test
    public void findFourOfAKingTest() {
        Card c1 = new Card(Card.CardSuit.HEARTS, Card.CardNumber.AS);
        Card c2 = new Card(Card.CardSuit.DIAMONDS, Card.CardNumber.AS);
        Card c3 = new Card(Card.CardSuit.CLUBS, Card.CardNumber.AS);
        Card c4 = new Card(Card.CardSuit.SPADES, Card.CardNumber.AS);
        Card c5 = new Card(Card.CardSuit.HEARTS, Card.CardNumber.FIVE);

        OrderedHand hand = new OrderedHand(c1,c2,c3,c4,c5);

        Game game = Game.findBestGameFor(hand);

        Assert.assertNotNull(game);
        Assert.assertEquals(Game.GameType.FOUR_OF_A_KIND, game.getType());
    }

    @Test
    public void findFullHouseTest() {
        Card c1 = new Card(Card.CardSuit.HEARTS, Card.CardNumber.AS);
        Card c2 = new Card(Card.CardSuit.DIAMONDS, Card.CardNumber.AS);
        Card c3 = new Card(Card.CardSuit.CLUBS, Card.CardNumber.AS);
        Card c4 = new Card(Card.CardSuit.SPADES, Card.CardNumber.FIVE);
        Card c5 = new Card(Card.CardSuit.HEARTS, Card.CardNumber.FIVE);

        OrderedHand hand = new OrderedHand(c1,c2,c3,c4,c5);

        Game game = Game.findBestGameFor(hand);

        Assert.assertNotNull(game);
        Assert.assertEquals(Game.GameType.FULL_HOUSE, game.getType());
    }

    @Test
    public void findFlush() {
        Card c1 = new Card(Card.CardSuit.HEARTS, Card.CardNumber.JACK);
        Card c2 = new Card(Card.CardSuit.HEARTS, Card.CardNumber.FOUR);
        Card c3 = new Card(Card.CardSuit.HEARTS, Card.CardNumber.QUEEN);
        Card c4 = new Card(Card.CardSuit.HEARTS, Card.CardNumber.NINE);
        Card c5 = new Card(Card.CardSuit.HEARTS, Card.CardNumber.KING);

        OrderedHand hand = new OrderedHand(c1,c2,c3,c4,c5);

        Game game = Game.findBestGameFor(hand);

        Assert.assertNotNull(game);
        Assert.assertEquals(Game.GameType.FLUSH, game.getType());
    }

    @Test
    public void findSimpleStraight() {
        Card c1 = new Card(Card.CardSuit.HEARTS, Card.CardNumber.AS);
        Card c2 = new Card(Card.CardSuit.SPADES, Card.CardNumber.TWO);
        Card c3 = new Card(Card.CardSuit.HEARTS, Card.CardNumber.THREE);
        Card c4 = new Card(Card.CardSuit.CLUBS, Card.CardNumber.FOUR);
        Card c5 = new Card(Card.CardSuit.DIAMONDS, Card.CardNumber.FIVE);

        OrderedHand hand = new OrderedHand(c1,c2,c3,c4,c5);

        Game game = Game.findBestGameFor(hand);

        Assert.assertNotNull(game);
        Assert.assertEquals(Game.GameType.STRAIGHT, game.getType());

    }

    @Test
    public void findThreeOfAKind() {
        Card c1 = new Card(Card.CardSuit.HEARTS, Card.CardNumber.AS);
        Card c2 = new Card(Card.CardSuit.SPADES, Card.CardNumber.AS);
        Card c3 = new Card(Card.CardSuit.HEARTS, Card.CardNumber.THREE);
        Card c4 = new Card(Card.CardSuit.CLUBS, Card.CardNumber.AS);
        Card c5 = new Card(Card.CardSuit.DIAMONDS, Card.CardNumber.FIVE);

        OrderedHand hand = new OrderedHand(c1,c2,c3,c4,c5);

        Game game = Game.findBestGameFor(hand);

        Assert.assertNotNull(game);
        Assert.assertEquals(Game.GameType.THREE_OF_A_KIND, game.getType());

    }

    @Test
    public void findTwoPairs() {
        Card c1 = new Card(Card.CardSuit.HEARTS, Card.CardNumber.AS);
        Card c2 = new Card(Card.CardSuit.SPADES, Card.CardNumber.AS);
        Card c3 = new Card(Card.CardSuit.HEARTS, Card.CardNumber.THREE);
        Card c4 = new Card(Card.CardSuit.CLUBS, Card.CardNumber.THREE);
        Card c5 = new Card(Card.CardSuit.DIAMONDS, Card.CardNumber.FIVE);

        OrderedHand hand = new OrderedHand(c1,c2,c3,c4,c5);

        Game game = Game.findBestGameFor(hand);

        Assert.assertNotNull(game);
        Assert.assertEquals(Game.GameType.TWO_PAIRS, game.getType());

    }

    @Test
    public void findOnePair() {
        Card c1 = new Card(Card.CardSuit.HEARTS, Card.CardNumber.AS);
        Card c2 = new Card(Card.CardSuit.SPADES, Card.CardNumber.AS);
        Card c3 = new Card(Card.CardSuit.HEARTS, Card.CardNumber.THREE);
        Card c4 = new Card(Card.CardSuit.CLUBS, Card.CardNumber.KING);
        Card c5 = new Card(Card.CardSuit.DIAMONDS, Card.CardNumber.FIVE);

        OrderedHand hand = new OrderedHand(c1,c2,c3,c4,c5);

        Game game = Game.findBestGameFor(hand);

        Assert.assertNotNull(game);
        Assert.assertEquals(Game.GameType.ONE_PAIR, game.getType());

    }

    @Test
    public void findNoGame() {
        Card c1 = new Card(Card.CardSuit.HEARTS, Card.CardNumber.AS);
        Card c2 = new Card(Card.CardSuit.SPADES, Card.CardNumber.SIX);
        Card c3 = new Card(Card.CardSuit.HEARTS, Card.CardNumber.THREE);
        Card c4 = new Card(Card.CardSuit.CLUBS, Card.CardNumber.KING);
        Card c5 = new Card(Card.CardSuit.DIAMONDS, Card.CardNumber.FIVE);

        OrderedHand hand = new OrderedHand(c1,c2,c3,c4,c5);

        Game game = Game.findBestGameFor(hand);

        Assert.assertNull(game);

    }

}
