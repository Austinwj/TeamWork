package online.dwResources;

import java.io.IOException;
import java.util.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import commandline.*;

import online.configuration.TopTrumpsJSONConfiguration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.eclipse.jetty.util.IO;

@Path("/toptrumps") // Resources specified here should be hosted at http://localhost:7777/toptrumps
@Produces(MediaType.APPLICATION_JSON) // This resource returns JSON content
@Consumes(MediaType.APPLICATION_JSON) // This resource can take JSON content as input
/**
 * This is a Dropwizard Resource that specifies what to provide when a user
 * requests a particular URL. In this case, the URLs are associated to the
 * different REST API methods that you will need to expose the game commands
 * to the Web page.
 * 
 * Below are provided some sample methods that illustrate how to create
 * REST API methods in Dropwizard. You will need to replace these with
 * methods that allow a TopTrumps game to be controled from a Web page.
 */
public class TopTrumpsRESTAPI {

	/** A Jackson Object writer. It allows us to turn Java objects
	 * into JSON strings easily. */
	ObjectWriter oWriter = new ObjectMapper().writerWithDefaultPrettyPrinter();

	private ArrayList<Player> players = new ArrayList<Player>();
	private Stack<Card> commonPile = new Stack<Card>();
	private int aiNum;
	private int round = 1;
	private Deck deck;
	private Player p;
	private Player p1;
	private ArrayList<Player> removedPlayer = new ArrayList<Player>();
	//private Game game;
	private Card[] card = new Card[5];
	private String message = "Hello!";
	private int gameWinner;
	private int roundWinner;
	private Database db;

	// Game statistics
	private int numGame;
	private int humanWin;
	private int ai1Win;
	private int ai2Win;
	private int ai3Win;
	private int ai4Win;
	private int winner; // = 0 means Human win, = 1 means Ai win
	private int numDraw;
	private int avgDraw;
	private int largestRound;
	private ArrayList<Integer> roundCount = new ArrayList<Integer>();


	
	/**
	 * Contructor method for the REST API. This is called first. It provides
	 * a TopTrumpsJSONConfiguration from which you can get the location of
	 * the deck file and the number of AI players.
	 * @param conf
	 */
	public TopTrumpsRESTAPI(TopTrumpsJSONConfiguration conf) {
		// ----------------------------------------------------
		// Add relevant initalization here
		// ----------------------------------------------------

		//game = new Game();
		deck = new Deck();
		p1 = new Player("Human Player");
		db = new Database();
		db.createTable();

	}

	// ----------------------------------------------------
	// Add relevant API methods here
	// ----------------------------------------------------
	@GET
	@Path("/newGame")
	public void newGame() {
		// Reset
		//game = new Game();
		deck = new Deck();
		p1 = new Player("Human Player");
	}


	@GET
	@Path("/addPlayer")
	public void addPlayer(@QueryParam("Number") int number) throws IOException {

		// Add cards to card list
		deck.addCards();
		System.out.println("########## Deck Size: " + deck.getStack().size());
		players.add(p1);
		System.out.println("########## Players Size: " + players.size());
		this.aiNum = number;
		for (int i = 0; i < aiNum ; i++){
			String str = "AI Player " + (i + 1);
			players.add(new Player(str));
		}
		createDeck();
		System.out.println("########## Players Size: " + players.size());
	}


	// Reset
	@GET
	@Path("/reset")
	public void reset() {
		// Clear some array for new game
		players.clear();
		p1.getDeck().clear();
		commonPile.clear();

		// Add cards to card list
		deck.getStack().clear();

		round = 1;
	}


	@GET
	@Path("/drawCard")
	// Print Round info and drew card
	public void drawCard() {
		Random r = new Random();
		int rp;
		if (round == 1){
			rp = r.nextInt(players.size());
			p = players.get(rp);
		}

//		System.out.println();
//		System.out.println("Round " + round);
//		System.out.println("Round " + round + ": Player have drawn their cards!");

//		if (!p1.getDeck().empty()){
//			System.out.println("You drew: " + "'" + p1.getDeck().peek().getName() + "'");

//			for (int i = 0; i < 5 ; i++){
//				String property = p1.getDeck().peek().properties[i];
//				int value = p1.getDeck().peek().getValues(i);
//				System.out.println("\t" + (i+1) + " >" + " " + property + ": " + value);
//			}

//			System.out.println("There are " + (p1.getDeck().size() - 1 ) + " cards left in your deck!");
//		}
	}


	@GET
	@Path("/choose")
	public void choose(@QueryParam("Number") int num) throws IOException {

		// Human player choose property
		if (num >= 0 && num <= 4){
			checkWin(num);
		}
		// AI player choose property
		else{
			ArrayList<Integer> option = new ArrayList<Integer>();
			ArrayList<Integer> randChoose = new ArrayList<Integer>();
			Random r = new Random();

			System.out.println("########" + p.getName());
			System.out.println("######## " + p.getDeck().size());

			//System.out.println("Now turn is " + p.getName());
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
		}


		round++;
		removeCard();
		//drawCard();

		int b = 0;
		for (int a = 0; a < players.size(); a ++){
			if (players.get(a).getDeck().size() != 0){
				b++;
			}
		}

		if (b == 1) {
			for (int c = 0; c < players.size(); c++) {
				if (players.get(c).getDeck().size() != 0){
					message = "Winner is " + players.get(c).getName() + " !! Congratulations!";
					gameWinner = 1;

					if(players.get(c).getName().equals("Human Player")) {
						humanWin++;
						winner = 0;
					}
					if(players.get(c).getName().equals("AI Player 1")){
						ai1Win++;
						winner = 1;
					}
					if(players.get(c).getName().equals("AI Player 2")){
						ai2Win++;
						winner = 1;
					}
					if(players.get(c).getName().equals("AI Player 3")){
						ai3Win++;
						winner = 1;
					}
					if(players.get(c).getName().equals("AI Player 4")){
						ai4Win++;
						winner = 1;
					}

					numGame++;
					roundCount.add(round);

					db.uploadGameRecord(getNumGame(), getAvgDraw(), getLargestRound(), getWinner());

					if(getAiNum()==4) {
						db.uploadRoundData(getNumGame(), 0, getHumanWin());
						db.uploadRoundData(getNumGame(), 1, getAi1Win());
						db.uploadRoundData(getNumGame(), 2, getAi2Win());
						db.uploadRoundData(getNumGame(), 3, getAi3Win());
						db.uploadRoundData(getNumGame(), 4, getAi4Win());
					}
					if(getAiNum()==3) {
						db.uploadRoundData(getNumGame(), 0, getHumanWin());
						db.uploadRoundData(getNumGame(), 1, getAi1Win());
						db.uploadRoundData(getNumGame(), 2, getAi2Win());
						db.uploadRoundData(getNumGame(), 3, getAi3Win());
					}
					if(getAiNum()==2) {
						db.uploadRoundData(getNumGame(), 0, getHumanWin());
						db.uploadRoundData(getNumGame(), 1, getAi1Win());
						db.uploadRoundData(getNumGame(), 2, getAi2Win());
					}
					if(getAiNum()==1) {
						db.uploadRoundData(getNumGame(), 0, getHumanWin());
						db.uploadRoundData(getNumGame(), 1, getAi1Win());
					}
					resetGetter();
				}
			}
		}

		System.out.println("########## Players Size: " + players.size());
	}

	
	@GET
	@Path("/getMessage")
	public String getMessage() throws IOException {
		return message;
	}

	@GET
	@Path("/getGameWinner")
	public int getGameWinner() throws IOException{
		return gameWinner;
	}



	@GET
	@Path("/getPlayer")
	public String getPlayer() throws IOException {
		Random r = new Random();
		int rp;
		if (round == 1){
			rp = r.nextInt(players.size());
			p = players.get(rp);
			message = "Now turn is " + p.getName() + ", time to Choose Property!";
		}

		return p.getName();
	}


	@GET
	@Path("/nextRound")
	public String nextRound() throws IOException{
		Random r = new Random();
		int rp;
		if (round == 1){
			rp = r.nextInt(players.size());
			p = players.get(rp);
		}
		message = "Now turn is " + p.getName() + ", time to Choose Property!";
		return message;
	}

	@GET
	@Path("/getCard")
	public String getCard() throws IOException {
		for (int i = 0; i < players.size(); i++) {
			if (players.get(i).getDeck().size() == 0) {
				card[i] = null;
			}
			else {
				card[i] = players.get(i).getDeck().peek();
			}
		}
		String list = oWriter.writeValueAsString(card);
		return list;
	}



	@GET
	@Path("/getRoundWinner")
	public int getRoundWinner() throws IOException {
		return roundWinner;
	}



	@GET
	@Path("/removeCard")
	public void removeCard() throws IOException {
		for (int k = 0; k < players.size(); k++) {
			if (players.get(k).getDeck().size() == 0) {
				continue;
			}
			else {
				players.get(k).getDeck().pop();
			}
		}
	}

	@GET
	@Path("/getPile")
	public String getPile() throws IOException {
		int[] piles = new int[6];

		for (int i = 0; i < 5; i++) {
			if (i < players.size()){
				piles[i] = players.get(i).getDeck().size() - 1;
			}
			else {
				piles[i] = 0;
			}

		}
		piles[5] = commonPile.size();

		String pilesList = oWriter.writeValueAsString(piles);
		System.out.println("##############" + pilesList);

		return pilesList;

	}

	@GET
	@Path("/getRound")
	public int getRound() throws IOException{
		return round;
	}


	// Check biggest property
	private void checkWin(int i){

		ArrayList<Integer> check = new ArrayList<Integer>();
		for (int k = 0; k < players.size(); k++) {
			if (players.get(k).getDeck().size() == 0) {
				check.add(-1);
			}
			else {
				check.add(players.get(k).getDeck().peek().getValues(i));
			}
		}
		int max = Collections.max(check);
		int m = 0;
		for (int j = 0; j < check.size(); j++) {
			if (check.get(j) == max) {
				m++;
			}
		}

		int win = check.indexOf(Collections.max(check));
		// Only have one big property
		if (m == 1) {
			System.out.println("Round " + round + ": " + players.get(win).getName() + " Win!");
			int cp = commonPile.size();
			for (int n = 0; n < cp; n++) {
				players.get(win).getDeck().add(0, commonPile.pop());
			}
			for (int q = 0; q < players.size(); q++) {
				if (players.get(q).getDeck().size() == 0) {
					continue;
				}
				else {
					players.get(win).getDeck().add(0, players.get(q).getDeck().peek());
				}
			}

			//showWinCard(players.get(win).getDeck().peek(),i);
			roundWinner = win;
			message = players.get(win).getName() + " Win! The Winning Card is " + "'" + players.get(win).getDeck().peek().getName() + "'";
			p = players.get(win);
		}
		// Have two+ same property
		else {
			// Add into common pile
			for (int k = 0; k < players.size(); k++) {
				if (players.get(k).getDeck().size() == 0) {
					continue;
				}
				else {
					commonPile.add(players.get(k).getDeck().peek());
					Collections.shuffle(commonPile);
				}
			}
			//System.out.println("This round was a Draw, common pile now has " + commonPile.size() + " cards");
			//showWinCard(players.get(win).getDeck().peek(),i);
			message = "Draw!" ;
			numDraw++;
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


	// Get Game Data


	@GET
	@Path("/getGameStatistics")
	public void getGameStatistics(){
		db.showRecord();
		db.dropDatabase();
		db.closeConnection();
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

	public void resetGetter() {
		humanWin =0;
		ai1Win =0;
		ai2Win =0;
		ai3Win =0;
		ai4Win =0;
	}

	public int getAvgDraw() {
		if (numGame == 0){
			avgDraw = 0;
			return avgDraw;
		}
		avgDraw = Math.round(numDraw / numGame);
		return avgDraw;
	}

	public int getLargestRound() {
		if (numGame == 0){
			largestRound = 0;
			return largestRound;
		}
		largestRound = Collections.max(roundCount);
		return largestRound;
	}
	
	@GET
	@Path("/helloJSONList")
	/**
	 * Here is an example of a simple REST get request that returns a String.
	 * We also illustrate here how we can convert Java objects to JSON strings.
	 * @return - List of words as JSON
	 * @throws IOException
	 */
	public String helloJSONList() throws IOException {
		
		List<String> listOfWords = new ArrayList<String>();
		listOfWords.add("Hello");
		listOfWords.add("World!");
		
		// We can turn arbatory Java objects directly into JSON strings using
		// Jackson seralization, assuming that the Java objects are not too complex.
		String listAsJSONString = oWriter.writeValueAsString(listOfWords);
		
		return listAsJSONString;
	}
	
	@GET
	@Path("/helloWord")
	/**
	 * Here is an example of how to read parameters provided in an HTML Get request.
	 * @param Word - A word
	 * @return - A String
	 * @throws IOException
	 */
	public String helloWord(@QueryParam("Word") String Word) throws IOException {
		return "Hello "+Word;
	}
	
}
