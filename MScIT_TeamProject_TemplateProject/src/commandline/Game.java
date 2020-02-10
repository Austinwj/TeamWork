package commandline;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Game {

    private ArrayList<Player> players = new ArrayList<Player>();
    private Stack<Card> cardStack = new Stack<Card>();
    private int num;
    //private Player p1;
    Scanner sc = new Scanner(System.in);


    public void play(){

        // Add cards to card list
        addCards();


        // First part of Game : Enter Name, Add Ai players
        System.out.println("-------Game Start-------");

        // Create Human Player
        System.out.println("Enter your name:");
        String str = sc.nextLine();
        players.add(new Player(str));

        // Create AI numbers (1-4)
        addAI();

        // Create Decks to players
        createDeck();
        System.out.println("Game Start! You are player 1 and your name is: " + players.get(0).getName() + ". Try to defeat " + num + " AI players!");

        // Second part of Game: Show result, draw cards
        //drawCard();
        //chooseProperty();

        // --------Test-------
        System.out.println(cardStack.size());
        System.out.println(players.get(0).getDeck().size());
        System.out.println(players.get(1).getDeck().size());
        System.out.println(players.get(2).getDeck().size());
        //System.out.println(players.get(3).getDeck().size());
        //System.out.println(players.get(4).getDeck().size());



    }


    // Add AI players, depend on num input
    private void addAI(){
        System.out.println("Enter number of AI players: (Min 1, Max 4)");
        num = sc.nextInt();
        while (true) {
            if (num >= 1 && num <= 4){
                for (int i = 0; i < num ; i++){
                    String str = "AI Player " + (i + 1);
                    players.add(new Player(str));
                }
                break;
            }
            else{
                System.out.println("Enter error! Please re-enter: ");
                num = sc.nextInt();
            }
        }
    }


    // Create deck for player
    private void createDeck() {
        Random r = new Random();
        while (true) {
            Collections.shuffle(cardStack);
            if (cardStack.empty()) {
                break;
            } else {
                for (int k = 0; k < players.size(); k++) {
                    players.get(k).getDeck().push(cardStack.pop());
                    if (cardStack.size() == 1){
                        int j = r.nextInt(players.size());
                        players.get(j).getDeck().push(cardStack.pop());
                        break;
                    }
                }
            }
        }
    }


    private void drawCard(){
        for (int i = 0; i < players.size() ; i++){
            System.out.println(players.get(i).getName() + ": " + players.get(i).getDeck().peek().getName());
        }
    }

    private void chooseProperty() {
        System.out.println("Choose your property: (1 - 5)");
        int i = sc.nextInt();
        while (true) {
            if (i >= 1 && i <= 5){
                System.out.println("Test ok!");
                break;
            }
            else{
                System.out.println("Enter error! Please re-enter: ");
                i = sc.nextInt();
            }
        }
        System.out.println("test!");

    }


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
                cardStack.push(new Card(description, size, speed, range, firepower, cargo));
                Collections.shuffle(cardStack);
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

}
