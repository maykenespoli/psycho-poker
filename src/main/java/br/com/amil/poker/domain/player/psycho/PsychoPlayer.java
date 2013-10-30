package br.com.amil.poker.domain.player.psycho;

import br.com.amil.poker.domain.deck.Card;
import br.com.amil.poker.domain.deck.Deck;
import br.com.amil.poker.domain.hand.Hand;
import br.com.amil.poker.domain.hand.OrderedHand;
import br.com.amil.poker.domain.hand.game.Game;
import br.com.amil.poker.domain.player.Player;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class PsychoPlayer implements Player {

    private Deck deck;
    private Hand hand;

    private PsychoGameFinder psychoGameFinder = new PsychoGameFinder();

    public PsychoPlayer(Deck deck) {
        this.deck = deck;
    }

    @Override
    public void setHand(Hand hand) {
        this.hand = new Hand(hand.getCards());
    }

    @Override
    public Collection<Card> playDiscard() {
        List<Card> toDiscard = usePsychicPowersToDiscard();
        hand.discard(toDiscard);
        return toDiscard;
    }

    @Override
    public void addCards(Card... cards) {
        hand.addCards(Arrays.asList(cards));
    }

    @Override
    public void addCards(Collection<Card> cards) {
        hand.addCards(cards);
    }

    @Override
    public Game showGame() {
        return Game.findBestGameFor(hand);
    }

    protected List<Card> usePsychicPowersToDiscard() {

        List<Card> futureCards = deck.lookAtNext(5);

        Game bestGame = psychoGameFinder.findBestGame(hand.getCards(), futureCards);

        List<Card> discard = hand.getCards();
        discard.removeAll(bestGame.getHand().getCards());

        return discard;
    }

    protected class PsychoGameFinder {

        public Game findBestGame(List<Card> handCards, List<Card> futureCards) {
            Game bestGame = Game.findBestGameFor(new OrderedHand(handCards));
            return combineGame(bestGame, handCards, futureCards);

        }

        private Game combineGame(Game currentBest, List<Card> handCards, List<Card> futureCards) {
            List<Card> tailFuture = new LinkedList<Card>(futureCards);
            Card nextFuture = tailFuture.remove(0);
            for ( int i = 0; i < futureCards.size(); i++ ) {
                Hand hand = new Hand(handCards);
                hand.setCardAt(i, nextFuture);
                currentBest = max(currentBest, Game.findBestGameFor(hand));
                if ( tailFuture.size() > 0 ) {
                    List<Card> newHand = new LinkedList<Card>(handCards);
                    newHand.remove(i);
                    newHand.add(nextFuture);
                    currentBest = combineGame(currentBest,newHand , tailFuture);
                }
            }
            return currentBest;
        }

        protected Game max(Game game1, Game game2) {
            return (game1 == null || game1.compareTo(game2) < 0) ? game2 : game1;
        }
    }
}
