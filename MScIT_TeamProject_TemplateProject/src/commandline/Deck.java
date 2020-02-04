package commandline;

import java.util.Collections;
import java.util.EmptyStackException;
import java.util.Stack;

    public class Deck {

        private Stack<Card> cards;

        public Deck(Stack<Card> cards) {

            this.cards = cards;

        }

        public Stack<Card> getCards() {
            return cards;
        }

        public int getSizeofDeck() {

            return cards.size();
        }

        public void shuffle() {

            for (int i = 0; i < 6; i++) {
                Collections.shuffle(cards);
            }
        }

        public Card deal() {

            if(cards.size() > 0) {
                return cards.pop();
            } else {
                throw new EmptyStackException();
            }
        }
    }