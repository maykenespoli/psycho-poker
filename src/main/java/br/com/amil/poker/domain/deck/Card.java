package br.com.amil.poker.domain.deck;

public class Card {

    private CardSuit suit;
    private CardNumber number;

    public Card(CardSuit suit, CardNumber number) {
        this.suit = suit;
        this.number = number;
    }

    public CardSuit getSuit() {
        return suit;
    }

    public CardNumber getNumber() {
        return number;
    }

    public enum CardSuit {
        SPADES, HEARTS, DIAMONDS, CLUBS;
    }

    public enum CardNumber {
        AS, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING;
    }
}
