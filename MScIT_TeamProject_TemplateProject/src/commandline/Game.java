package commandline;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Game {

    private ArrayList<Player> players = new ArrayList<Player>();
    private Stack<Card> cardStack = new Stack<Card>();
    private Stack<Card> commonPile = new Stack<Card>();
    private int num;
    private int round = 1;
    private Player p;
    private Player p1;
    private ArrayList<Player> removedPlayer = new ArrayList<Player>();
    Scanner sc = new Scanner(System.in);


    public void play(){

        // Add cards to card list
        addCards();


        // First part of Game : Enter Name, Add Ai players
        System.out.println("-------Game Start-------");

        // Create Human Player
        System.out.println("Enter your name:");
        String str = sc.nextLine();
        p1 = new Player(str);
        players.add(p1);

        // Create AI numbers (1-4)
        addAI();

        // Create Decks to players
        createDeck();
        System.out.println("Game Start! You are player 1 and your name is: " + players.get(0).getName() + ". Try to defeat " + num + " AI players!");

        // Second part of Game: Show result, draw cards
        while (true) {

            for (int i = 0 ; i < players.size() ; i ++){
                if (players.get(i).getDeck().size() == 0){
                    System.out.println(players.get(i).getName() + " Lose!");
                    removedPlayer.add(players.get(i));
                }
            }

            for (int j = 0; j < removedPlayer.size(); j++) {
                players.remove(removedPlayer.get(j));
            }


            if (players.size() == 1){
                System.out.println(players.get(0).getName() + " Win!");
                break;
            }

            drawCard();

        }


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
        num = sc.nextInt(); sc.nextLine();
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



    // Print Round info and drew card
    private void drawCard() {
        Random r = new Random();
        int rp = 0;
        if (round == 1){
            rp = r.nextInt(players.size());
            p = players.get(rp);
        }

        System.out.println();
        System.out.println("Round " + round);
        System.out.println("Round " + round + ": Player have drawn their cards!");

        if (!p1.getDeck().empty()){
            System.out.println("You drew: " + "'" + p1.getDeck().peek().getName() + "'");

            for (int i = 0; i < 5 ; i++){
                String property = p1.getDeck().peek().properties[i];
                int value = p1.getDeck().peek().getValues(i);
                System.out.println("\t" + (i+1) + " >" + " " + property + ": " + value);
            }

            System.out.println("There are " + (p1.getDeck().size() - 1 ) + " cards left in your deck!");
        }
        chooseProperty();
    }

    // Choose property
    private void chooseProperty(){

        // Human player choose property
        if (p == p1){
            System.out.print("Now it is your turn, Choose your property: (1 - 5) ");
            int i = sc.nextInt(); sc.nextLine();
            while (true) {
                if (i >= 1 && i <= 5){
                    checkWin(i-1);
                    break;
                }
                else{
                    System.out.print("Enter error! Please re-enter: ");
                    i = sc.nextInt();
                }
            }
        }

        // AI player choose property
        else{
            ArrayList<Integer> option = new ArrayList<Integer>();
            ArrayList<Integer> randChoose = new ArrayList<Integer>();
            Random r = new Random();

            System.out.println("Now turn is " + p.getName());
            for (int k = 0; k < 5; k++) {
                option.add(p.getDeck().peek().getValues(k));
            }
            int max = Collections.max(option);
            int m = 0;
            for (int j = 0; j < option.size(); j++) {
                if (option.get(j) == max){
                    m++;
                    randChoose.add(j);
                }
            }

            int choose = option.indexOf(Collections.max(option));
            if (m == 1){
                checkWin(choose);
            }
            else{
                checkWin(randChoose.get(r.nextInt(randChoose.size())));
            }
            System.out.println("Press Enter to next round!");
            sc.nextLine();
        }
    }



    // Check biggest property
    private void checkWin(int i){
        ArrayList<Integer> check = new ArrayList<Integer>();
        for (int k = 0; k < players.size(); k++) {
            check.add(players.get(k).getDeck().peek().getValues(i));
        }
        int max = Collections.max(check);
        int m = 0;
        for (int j = 0; j < check.size(); j++) {
            if (check.get(j) == max){
                m++;
            }
        }

        int win = check.indexOf(Collections.max(check));
        // Only have one big property
        if (m == 1){
            System.out.println("Round " + round + ": " + players.get(win).getName() + " Win!");
            int cp = commonPile.size();
            for (int n = 0 ; n < cp ; n++){
                players.get(win).getDeck().add(0, commonPile.pop());
            }
            for (int q = 0; q < players.size(); q++) {
                players.get(win).getDeck().add(0, players.get(q).getDeck().peek());
            }

            showWinCard(players.get(win).getDeck().peek(),i);
            p = players.get(win);
        }
        // Have two+ same property
        else{
            // Add into common pile
            for (int k = 0; k < players.size(); k++) {
                commonPile.add(players.get(k).getDeck().peek());
                Collections.shuffle(commonPile);
            }
            System.out.println("This round was a Draw, common pile now has " + commonPile.size() + " cards");
            showWinCard(players.get(win).getDeck().peek(),i);
        }

        // Remove cards from this round
        for (int k = 0; k < players.size(); k++) {
            players.get(k).getDeck().pop();
        }
        round++;
    }

    private void showWinCard(Card c, int i){
        System.out.println("The winning card was '" + c.getName() + "':");
        for (int j = 0; j < 5 ; j++){
            if (i == j){
                System.out.println("\t" + ">" + " " + c.properties[j] + ": " + c.getValues(j) + " <--");
            }
            else{
                System.out.println("\t" + ">" + " " + c.properties[j] + ": " + c.getValues(j));
            }
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
