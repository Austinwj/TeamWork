package commandline;

import java.util.*;

public class Game {

    // Game statistics
    private int numGame;
    //  humanWin,ai1Win,ai2Win,ai3Win and ai4Win are rounds each player won in one game
    private int humanWin;
    private int ai1Win;
    private int ai2Win;
	private int ai3Win;
    private int ai4Win;
    private int winner; // = 0 means Human win, = 1-4 means Ai 1-4 win
    private int numDraw;


    private ArrayList<Player> players = new ArrayList<Player>();
    private Stack<Card> commonPile = new Stack<Card>();
    private int aiNum;
    private int round = 1;
    private Deck deck;
    private Player p;
    private String p1Name;
    private Player p1;
    private ArrayList<Player> removedPlayer = new ArrayList<Player>();
    private Log log = new Log();
    Scanner sc = new Scanner(System.in);


    public void play(){

        // Clear some array for new game
        players.clear();
        commonPile.clear();

        // Add cards to card list
        deck = new Deck();
        deck.addCards();
        log.writeDeck(deck);

        deck.shuffle();
        log.writeShuffle(deck);





        // First part of Game : Enter Name, Add Ai players
        System.out.println("-------Game Start-------");

        // Create Human Player
        if (numGame == 0){
            System.out.println("Enter your name:");
            p1Name = sc.nextLine();
        }
        p1 = new Player(p1Name);
        players.add(p1);

        // Create AI numbers (1-4)
        addAI();

        // Create Decks to players
        createDeck();
        log.writePlayerDecks(players);

        System.out.println("Game Start! You are player 1 and your name is: " + players.get(0).getName() + ". Try to defeat " + aiNum + " AI players!");

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
                System.out.println(players.get(0).getName() + " Win the Game! Congratulations!");
                log.writeGameWinner(players.get(0));

                if (players.get(0).getName() == p1.getName()){  
                    winner = 0;
                }
                if (players.get(0).getName().equals("AI Player 1")){   
                    winner = 1;
                }
                if (players.get(0).getName().equals("AI Player 2")){   
                    winner = 2;
                }
                if (players.get(0).getName().equals("AI Player 3")){   
                    winner = 3;
                }
                if (players.get(0).getName().equals("AI Player 4")){   
                    winner = 4;
                }
                // Add number of games and Reset round
                numGame++;      
                break;
            }
            drawCard();
            log.writeCommonPile(commonPile);
        }

        log.close();

    }


    // Add AI players, depend on num input
    private void addAI(){
        System.out.println("Enter number of AI players: (Min 1, Max 4)");
        aiNum = sc.nextInt(); sc.nextLine();
        while (true) {
            if (aiNum >= 1 && aiNum <= 4){
                for (int i = 0; i < aiNum ; i++){
                    String str = "AI Player " + (i + 1);
                    players.add(new Player(str));
                }
                break;
            }
            else{
                System.out.println("Enter error! Please re-enter: ");
                aiNum = sc.nextInt();
            }
        }
    }


    // Create deck for player
    private void createDeck() {
        Random r = new Random();
        int leftCards = deck.getStack().size() % (aiNum+1);
        while (true) {
            Collections.shuffle(deck.getStack());
            if (leftCards == 0){
                for (Player player : players) {
                    Collections.shuffle(deck.getStack());
                    player.getDeck().push(deck.getStack().pop());
                    if (deck.getStack().empty()) {
                        return;
                    }
                }
            }
            else{ // If card size mod player number not zero
                for (Player player : players) {
                    Collections.shuffle(deck.getStack());
                    player.getDeck().push(deck.getStack().pop());

                    // This loop is suitable for more than 4 players
                    if (deck.getStack().size() == leftCards) {
                        ArrayList<Integer> randPlayer = new ArrayList<Integer>();
                        for (int i = 0; i < players.size(); i++){
                            randPlayer.add(i);
                        }
                        for (int i = 0; i < leftCards; i++){
                            int j = r.nextInt(randPlayer.size());
                            players.get(randPlayer.get(j)).getDeck().push(deck.getStack().pop());
                            randPlayer.remove(j);
                            if (deck.getStack().empty()) {
                                return;
                            }
                        }

                    }
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
        log.writeCurrentCard(players, p);
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
            //System.out.println("Press Enter to next round!");
            //sc.nextLine();
        }

    }


    // Check biggest property
    private void checkWin(int i){
        log.writeSelectCategory(players, p, i);

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
            if(players.get(win).getName().equals(p1Name)) {
            	humanWin++;
            }
            if(players.get(win).getName().equals("AI Player 1")){
            	ai1Win++;
            }
            if(players.get(win).getName().equals("AI Player 2")){
            	ai2Win++;
            }
            if(players.get(win).getName().equals("AI Player 3")){
            	ai3Win++;
            }
            if(players.get(win).getName().equals("AI Player 4")){
            	ai4Win++;
            }

            log.writeRoundWinner(players.get(win), 1);

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
            numDraw++;
            log.writeRoundWinner(players.get(win), 0);
        }


        // Remove cards from this round
        for (int k = 0; k < players.size(); k++) {
            players.get(k).getDeck().pop();
        }
        round++;
    }


    // Print win card's property
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

    public void newLog(){
        log = new Log();
    }

    public void closeLog() {
        log.close();
    }

    public int getNumGame() {
        return numGame;
    }
    
	public int getAiNum() {
		return aiNum;
	}
	
    public int getAi1Win() {
		return ai1Win;
	}


	public int getAi2Win() {
		return ai2Win;
	}


	public int getAi3Win() {
		return ai3Win;
	}


	public int getAi4Win() {
		return ai4Win;
	}

    public int getHumanWin() {
        return humanWin;
    }

    public int getWinner() {
        return winner;
    }
	
    public int getNumDraw() {
		return numDraw;
	}

	public int getRound() {
		return round;
	}	
     
    public void resetGetter() {
    	round = 1;
    	humanWin =0;
    	ai1Win =0;
    	ai2Win =0;
    	ai3Win =0;
    	ai4Win =0;
    }

}
