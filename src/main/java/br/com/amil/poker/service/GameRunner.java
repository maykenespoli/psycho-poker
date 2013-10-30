package br.com.amil.poker.service;

import br.com.amil.poker.domain.deck.Card;
import br.com.amil.poker.domain.deck.Deck;
import br.com.amil.poker.domain.hand.Hand;
import br.com.amil.poker.domain.hand.game.Game;
import br.com.amil.poker.domain.player.Player;
import br.com.amil.poker.domain.player.psycho.PsychoPlayer;

import java.util.Collection;
import java.util.List;

public class GameRunner {

    public void runLine(String line) {
        runGame(parseLine(line));
    }

    public void runGame(GameCase gameCase) {
        Deck deck = gameCase.getDeck();
        List<Card> initialDeck = deck.getCards();
        Player player = new PsychoPlayer(deck);

        player.setHand(gameCase.getHand());

        Collection<Card> discard = player.playDiscard();
        player.addCards(deck.getNext(discard.size()));

        Game game = player.showGame();

        System.out.printf("Mao: %s \t\t Monte : %s \t\t Melhor Jogo : %s(%s)\n", gameCase.getHand(), initialDeck, game.getType(), game.getHand());

    }

    private GameCase parseLine(String line) {
        String [] cards = line.split("\\s+");
        Hand hand = new Hand();
        Deck deck = new Deck();

        for( int i = 0; i < 5; i++ ) {
            hand.addCard(cardFromString(cards[i]));
        }
        for( int i = 5; i < cards.length; i++ ) {
            deck.addCards(cardFromString(cards[i]));
        }

        return new GameCase(hand, deck);
    }

    private Card cardFromString(String cardName) {
        Card.CardNumber number = null;
        Card.CardSuit suit = null;
        switch (cardName.charAt(0)) {
            case 'T' :
                number = Card.CardNumber.TEN;
                break;
            case 'J':
                number = Card.CardNumber.JACK;
                break;
            case 'Q':
                number = Card.CardNumber.QUEEN;
                break;
            case 'K':
                number = Card.CardNumber.KING;
                break;
            case 'A':
                number = Card.CardNumber.AS;
                break;
            default :
                number = Card.CardNumber.values()[Integer.valueOf(String.valueOf(cardName.charAt(0)))-1];
        }

        switch (cardName.charAt(1)) {
            case 'D' :
                suit = Card.CardSuit.DIAMONDS;
                break;
            case 'H' :
                suit = Card.CardSuit.HEARTS;
                break;
            case 'S' :
                suit = Card.CardSuit.SPADES;
                break;
            case 'C' :
                suit = Card.CardSuit.CLUBS;
                break;
        }

        return new Card(suit, number);
    }

    public class GameCase {
        private Hand hand;
        private Deck deck;

        private GameCase(Hand hand, Deck deck) {
            this.hand = hand;
            this.deck = deck;
        }

        private Hand getHand() {
            return hand;
        }

        private Deck getDeck() {
            return deck;
        }
    }
}
