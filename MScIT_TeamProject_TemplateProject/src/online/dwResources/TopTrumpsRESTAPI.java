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
	private String p1Name;
	private Player p1;
	private ArrayList<Player> removedPlayer = new ArrayList<Player>();


	
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

		// Reset
		reset();
	}
	
	// ----------------------------------------------------
	// Add relevant API methods here
	// ----------------------------------------------------
	@GET
	@Path("/addPlayer")
	public void addPlayer(@QueryParam("Number") int number) throws IOException {
		p1 = new Player("Human Player");
		players.add(p1);
		this.aiNum = number;
		for (int i = 0; i < aiNum ; i++){
			String str = "AI Player " + (i + 1);
			players.add(new Player(str));
		}
	}


	// Reset
	private void reset() {
		// Clear some array for new game
		players.clear();
		commonPile.clear();

		// Add cards to card list
		deck = new Deck();
		deck.addCards();
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
