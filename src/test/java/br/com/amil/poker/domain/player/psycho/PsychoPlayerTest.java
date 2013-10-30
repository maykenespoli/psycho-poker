package br.com.amil.poker.domain.player.psycho;

import br.com.amil.poker.domain.deck.Card;
import br.com.amil.poker.domain.deck.Deck;
import br.com.amil.poker.domain.hand.Hand;
import br.com.amil.poker.domain.hand.game.Game;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;

public class PsychoPlayerTest {

    @Test
    public void mustGoForStraightFlush() {
        Card c1 = new Card(Card.CardSuit.HEARTS, Card.CardNumber.TEN);
        Card c2 = new Card(Card.CardSuit.HEARTS, Card.CardNumber.JACK);
        Card c3 = new Card(Card.CardSuit.CLUBS, Card.CardNumber.QUEEN);
        Card c4 = new Card(Card.CardSuit.DIAMONDS, Card.CardNumber.QUEEN);
        Card c5 = new Card(Card.CardSuit.SPADES, Card.CardNumber.QUEEN);

        Card d1 = new Card(Card.CardSuit.HEARTS, Card.CardNumber.QUEEN);
        Card d2 = new Card(Card.CardSuit.HEARTS, Card.CardNumber.KING);
        Card d3 = new Card(Card.CardSuit.HEARTS, Card.CardNumber.AS);
        Card d4 = new Card(Card.CardSuit.SPADES, Card.CardNumber.TWO);
        Card d5 = new Card(Card.CardSuit.SPADES, Card.CardNumber.SIX);

        Hand hand = new Hand(c1,c2,c3,c4,c5);
        Deck deck = new Deck(d1,d2,d3,d4,d5);

        PsychoPlayer player = new PsychoPlayer(deck);
        player.setHand(hand);

        Collection<Card> discard = player.playDiscard();
        player.addCards(deck.getNext(discard.size()));

        Game game = player.showGame();

        Assert.assertNotNull(game);
        Assert.assertEquals(Game.GameType.STRAIGHT_FLUSH, game.getType());
    }


    @Test
    public void mustGoForFourOfAKind() {
        Card c1 = new Card(Card.CardSuit.HEARTS, Card.CardNumber.TWO);
        Card c2 = new Card(Card.CardSuit.SPADES, Card.CardNumber.TWO);
        Card c3 = new Card(Card.CardSuit.HEARTS, Card.CardNumber.THREE);
        Card c4 = new Card(Card.CardSuit.SPADES, Card.CardNumber.THREE);
        Card c5 = new Card(Card.CardSuit.CLUBS, Card.CardNumber.THREE);

        Card d1 = new Card(Card.CardSuit.DIAMONDS, Card.CardNumber.TWO);
        Card d2 = new Card(Card.CardSuit.DIAMONDS, Card.CardNumber.THREE);
        Card d3 = new Card(Card.CardSuit.CLUBS, Card.CardNumber.SIX);
        Card d4 = new Card(Card.CardSuit.CLUBS, Card.CardNumber.NINE);
        Card d5 = new Card(Card.CardSuit.HEARTS, Card.CardNumber.TEN);

        Hand hand = new Hand(c1,c2,c3,c4,c5);
        Deck deck = new Deck(d1,d2,d3,d4,d5);

        PsychoPlayer player = new PsychoPlayer(deck);
        player.setHand(hand);

        Collection<Card> discard = player.playDiscard();
        player.addCards(deck.getNext(discard.size()));

        Game game = player.showGame();

        Assert.assertNotNull(game);
        Assert.assertEquals(Game.GameType.FOUR_OF_A_KIND, game.getType());
    }

    @Test
    public void mustGoForFullHouse() {
        Card c1 = new Card(Card.CardSuit.HEARTS, Card.CardNumber.TWO);
        Card c2 = new Card(Card.CardSuit.SPADES, Card.CardNumber.TWO);
        Card c3 = new Card(Card.CardSuit.HEARTS, Card.CardNumber.THREE);
        Card c4 = new Card(Card.CardSuit.SPADES, Card.CardNumber.THREE);
        Card c5 = new Card(Card.CardSuit.CLUBS, Card.CardNumber.THREE);

        Card d1 = new Card(Card.CardSuit.DIAMONDS, Card.CardNumber.TWO);
        Card d2 = new Card(Card.CardSuit.CLUBS, Card.CardNumber.NINE);
        Card d3 = new Card(Card.CardSuit.DIAMONDS, Card.CardNumber.THREE);
        Card d4 = new Card(Card.CardSuit.CLUBS, Card.CardNumber.SIX);
        Card d5 = new Card(Card.CardSuit.HEARTS, Card.CardNumber.TEN);

        Hand hand = new Hand(c1,c2,c3,c4,c5);
        Deck deck = new Deck(d1,d2,d3,d4,d5);

        PsychoPlayer player = new PsychoPlayer(deck);
        player.setHand(hand);

        Collection<Card> discard = player.playDiscard();
        player.addCards(deck.getNext(discard.size()));

        Game game = player.showGame();

        Assert.assertNotNull(game);
        Assert.assertEquals(Game.GameType.FULL_HOUSE, game.getType());
    }

}
