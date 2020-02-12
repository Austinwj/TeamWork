package commandline;

import java.util.Scanner;

/**
 * Top Trumps command line application
 */
public class TopTrumpsCLIApplication {

	/**
	 * This main method is called by TopTrumps.java when the user specifies that they want to run in
	 * command line mode. The contents of args[0] is whether we should write game logs to a file.
 	 * @param args
	 */
	public static void main(String[] args) {

		//boolean writeGameLogsToFile = false; // Should we write game logs to file?
		//if (args[0].equalsIgnoreCase("true")) writeGameLogsToFile=true; // Command line selection
		
		// State
		boolean userWantsToQuit = false; // flag to check whether the user wants to quit the application
		
		// Loop until the user wants to exit the game
		while (!userWantsToQuit) {

			// ----------------------------------------------------
			// Add your game logic here based on the requirements
			// ----------------------------------------------------
			Game game = new Game();

			while (true) {
				System.out.println("Do you want to see past results or play a game?");
				System.out.println("1: Play Game");
				System.out.println("2: Print Game Statistics");
				System.out.println("3: Quit");
				System.out.print("Enter the number for your selection: ");
				Scanner sc = new Scanner(System.in);
				Integer input = sc.nextInt();

				if (input == 1) {
					game.play();
					System.out.println("Ends!");

				} else if (input == 2) {
				/*Database db = new Database();
				System.out.println(db.getGameStatistics());
				db.closeConnection();
				db = null;*/

					System.out.println("Number of games played: " + game.getNumGame());
					System.out.println("Times that AI player won: " + game.getAiWin());
					System.out.println("Times that Human player won: " + game.getHumanWin());
					System.out.println("The average number of draws: " + game.getAvgDraw());
					System.out.println("The largest number of rounds played in a single game : " + game.getLargestRound());
					System.out.println("------------------");
			} else if (input == 3) {
					System.out.println("Exit!");
					userWantsToQuit = true;
					System.exit(1);
				}
				else {
					System.out.println("Sorry, input not recognised, please try again...");
				}

				userWantsToQuit=true; // use this when the user wants to exit the game
			}

			
		}


	}

}
