package commandline;

import java.util.*;

public class Player {

    private Stack<Card> deck = new Stack<>();
    private String name;
	private int i;

	// Constructor
    public Player(String name) {
        this.name = name;
    }


    // Get Player name
    public String getName() {
        return this.name;
    }


    // Add a card to the top of stack
    /*public void addCard(Card c){
        cards.push(c);
    }*/


/*    // Return a Card from top of stack
    public Card peekAtTopCard(){
       //return deck.getCards().peek();
        return cards.peek();
    }*/


    // Return the deck (use method from deck class)
    public Stack<Card> getDeck(){
        return deck;
    }


/*    // Remove the card from the top of stack
    public Card removeCardFromDeck() {
       //return deck.getCards().pop();
        return cards.pop();
    }*/


    //
    public CategoryType chooseRandomCategory() {
        List<CategoryType> categoryTypes = Arrays.asList(CategoryType.values());
        Random randomCategory = new Random();
        return categoryTypes.get(randomCategory.nextInt(categoryTypes.size()));
    }


    //
    public CategoryType chooseCategory() {
        List<CategoryType> categoryTypes = Arrays.asList(CategoryType.values());
        return null;
    }


    //
    public Card addToBottomOfDeck() {
        return null;
    }
}
