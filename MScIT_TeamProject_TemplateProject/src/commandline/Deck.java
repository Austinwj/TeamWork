package commandline;

import java.util.Collections;
import java.util.EmptyStackException;
import java.util.Stack;

    public class Deck {

        private Stack<Card> cards;


        // Constructor
        public Deck(Stack<Card> cards) {
            this.cards = cards;
        }


        // Get card class
        public Stack<Card> getCards() {
            return cards;
        }


        // Get the size of deck (return how many cards in the deck)
        public int getSizeofDeck() {
            return cards.size();
        }


        // Return a Card from top of stack
        public Card peekAtTopCard(){
            //return deck.getCards().peek();
            return cards.peek();
        }


        // Remove the card from the top of stack
        public Card removeCardFromDeck() {
            //return deck.getCards().pop();
            return cards.pop();
        }


        // When push cards into stack, all in order so it must shuffle
        public void shuffle() {
            for (int i = 0; i < 6; i++) {
                Collections.shuffle(cards);
            }
        }


        //
        public Card deal() {
            if(cards.size() > 0) {
                return cards.pop();
            } else {
                throw new EmptyStackException();
            }
        }
    }