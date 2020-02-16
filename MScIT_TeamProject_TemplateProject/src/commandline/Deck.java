package commandline;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class Deck {

    private Stack<Card> deck = new Stack<Card>();


    // Get card details from StarCitizenDeck.txt and add to cardList
    public void addCards() {
        FileReader fr = null;
        try {
            fr = new FileReader("StarCitizenDeck.txt");
            Scanner s = new Scanner(fr);
            String line = s.nextLine(); // Ignore first line
            while (s.hasNextLine()) {
                // Begin with the second line
                line = s.nextLine();
                String[] tokens = line.split(" ");
                String description = tokens[0];
                int size = Integer.parseInt(tokens[1]);
                int speed = Integer.parseInt(tokens[2]);
                int range = Integer.parseInt(tokens[3]);
                int firepower = Integer.parseInt(tokens[4]);
                int cargo = Integer.parseInt(tokens[5]);
                deck.push(new Card(description, size, speed, range, firepower, cargo));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void shuffle(){
        Collections.shuffle(deck);
    }


    public Stack<Card> getStack() {
        return deck;
    }
}
