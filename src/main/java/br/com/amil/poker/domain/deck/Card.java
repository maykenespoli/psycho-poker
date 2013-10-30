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

    @Override
    public String toString() {
        return number.toString() + suit;
    }

    public enum CardSuit {
        SPADES, HEARTS, DIAMONDS, CLUBS;

        private String name;

        private CardSuit() {
            name = this.name().substring(0,1);
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public enum CardNumber {
        AS("A"), TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN("T"), JACK("J"), QUEEN("Q"), KING("K");

        private String name;

        private CardNumber() {
            name = String.valueOf(this.ordinal() + 1);
        }

        private CardNumber(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
