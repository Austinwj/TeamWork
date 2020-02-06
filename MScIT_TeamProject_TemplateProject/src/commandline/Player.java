package commandline;

import java.util.*;

public class Player {

    private Stack<Card> cards = new Stack<>();
    private Deck deck = new Deck(cards);
    private String name;
	private int i;

    public Player(String name) {
        this.name = name;
    }

    public void addCard(Card c){
        cards.push(c);
    }

    public Card peekAtTopCard(){

        return deck.getCards().peek();

    }

    public Deck getDeck(){

        return deck;
    }

    public Card removeCardFromDeck() {

        return deck.getCards().pop();
    }

    public CategoryType chooseRandomCategory() {

        List<CategoryType> categoryTypes = Arrays.asList(CategoryType.values());

        Random randomCategory = new Random();

        return categoryTypes.get(randomCategory.nextInt(categoryTypes.size()));
    }

    public CategoryType chooseCategory() {

        List<CategoryType> categoryTypes = Arrays.asList(CategoryType.values());

        return null;
    }

    public Card addToBottomOfDeck() {
        return null;

    }
}
