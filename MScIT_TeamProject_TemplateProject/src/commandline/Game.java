package commandline;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    private ArrayList<Player> players = new ArrayList<Player>();
    public ArrayList<Card> cardList = new ArrayList<Card>();
    private int num;
    private Player p1;
    Scanner sc = new Scanner(System.in);


    public void play(){

        // Add cards to card list
        addCards();


        // First part of Game : Enter Name, Add Ai players
        System.out.println("-------Game Start-------");
        System.out.println("Enter your name:");
        String str = sc.nextLine();
        this.p1 = new Player(str);
        createDeck(p1);
        System.out.println("Enter number of AI players:");
        this.num = sc.nextInt();
        addAI(num);
        System.out.println("Game Start! You are player 1 and your name is: " + p1.getName() + ". Try to defeat " + num + " AI players!");

        // Second part of Game: Show result, draw cards
        drawCard();
        chooseProperty();



    }


    // Add AI players, depend on num input
    private void addAI(int num){
        for (int i = 0; i < num ; i++){
            String str = "AI Player " + (i + 1);
            players.add(new Player(str));
            createDeck(players.get(i));
        }
    }


    // Create deck for player
    private void createDeck(Player p){
        for (int i = 0; i < cardList.size() ; i++){
            p.addCard(cardList.get(i));
            p.getDeck().shuffle();
        }
    }


    private void drawCard(){
        System.out.println(p1.getName() + ": " + p1.getDeck().peekAtTopCard().getName());
        for (int i = 0; i < num ; i++){
            System.out.println(players.get(i).getName() + ": " + players.get(i).getDeck().peekAtTopCard().getName());
        }
    }

    private void chooseProperty() {
        System.out.println("Choose your property: (1 - 5)");
        Integer i = sc.nextInt();
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
                cardList.add(new Card(description, size, speed, range, firepower, cargo));
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
