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



    // Return the deck
    public Stack<Card> getDeck(){
        return deck;
    }

}
