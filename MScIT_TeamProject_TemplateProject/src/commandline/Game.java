package commandline;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Game {

    private ArrayList<Player> players = new ArrayList<Player>();
    private Stack<Card> cardStack = new Stack<Card>();
    private int num;
    private int round = 1;
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
        drawCard();
        //chooseProperty();

        // --------Test-------
        /*System.out.println(cardStack.size());
        System.out.println(players.get(0).getDeck().size());
        System.out.println(players.get(1).getDeck().size());
        System.out.println(players.get(2).getDeck().size());

        System.out.println("----------");
        for (int m = 0; m < players.get(0).getDeck().size() ; m++) {
            System.out.print(players.get(0).getDeck().get(m).getName());
            System.out.print(" ");
        }
        System.out.println("----------");

        for (int m = 0; m < players.get(1).getDeck().size() ; m++) {
            System.out.print(players.get(1).getDeck().get(m).getName());
            System.out.print(" ");
        }
        System.out.println("----------");
        for (int m = 0; m < players.get(2).getDeck().size() ; m++) {
            System.out.print(players.get(2).getDeck().get(m).getName());
            System.out.print(" ");
        }*/



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
            }
            else if (cardStack.size() == 1){
                    int j = r.nextInt(players.size());
                    players.get(j).getDeck().push(cardStack.pop());
                    break;
            }
            else {
                for (int k = 0; k < players.size(); k++) {
                    players.get(k).getDeck().push(cardStack.pop());
                }
            }
        }
    }



    private void drawCard() {
        while (true) {
            System.out.println("Round " + round);
            System.out.println("Round " + round + ": Player have drew their cards!");
            System.out.println("You drew: " + "'" + players.get(0).getDeck().peek().getName() + "'");
            System.out.println("\t" + "1 >" + " " + "Size: " + players.get(0).getDeck().peek().getSize());
            System.out.println("\t" + "2 >" + " " + "Speed: " + players.get(0).getDeck().peek().getSpeed());
            System.out.println("\t" + "3 >" + " " + "Range: " + players.get(0).getDeck().peek().getRange());
            System.out.println("\t" + "4 >" + " " + "Firepower: " + players.get(0).getDeck().peek().getFirepower());
            System.out.println("\t" + "5 >" + " " + "Cargo: " + players.get(0).getDeck().peek().getCargo());
            System.out.println("There are " + (players.get(0).getDeck().size() - 1 ) + " cards left in your deck!");
            System.out.print("Choose your property: (1 - 5) ");
            int i = sc.nextInt();
            while (true) {
                if (i >= 1 && i <= 5){
                    checkWin(i);
                    break;
                }
                else{
                    System.out.print("Enter error! Please re-enter: ");
                    i = sc.nextInt();
                }
            }
            break;

        }

    }

    // Check biggest property
    private void checkWin(int i){
        ArrayList<Integer> check = new ArrayList<Integer>();
        for (int k = 0; k < players.size(); k++) {
            check.add(players.get(k).getDeck().pop().getValues(i));
        }
        int max = Collections.max(check);
        int m = 0;
        for (int j = 0; j < check.size(); j++) {
            if (check.get(j) == max){
                m++;
            }
        }
        if (m == 1){
            int win = check.indexOf(Collections.max(check));
            System.out.println("Round " + round + ": " + players.get(win).getName() + " Win!");
        }
        else{
            System.out.println("Round " + round + ": drew!");
        }
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
