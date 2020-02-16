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
			Database db = new Database();	
			db.createTable();
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
					db.uploadGameRecord(game.getNumGame(), game.getNumDraw(), game.getRound(), game.getWinner());
					
					if(game.getAiNum()==4) {
						db.uploadRoundData(game.getNumGame(), 0, game.getHumanWin());
						db.uploadRoundData(game.getNumGame(), 1, game.getAi1Win());
						db.uploadRoundData(game.getNumGame(), 2, game.getAi2Win());
						db.uploadRoundData(game.getNumGame(), 3, game.getAi3Win());
						db.uploadRoundData(game.getNumGame(), 4, game.getAi4Win());
					}
					if(game.getAiNum()==3) {
						db.uploadRoundData(game.getNumGame(), 0, game.getHumanWin());
						db.uploadRoundData(game.getNumGame(), 1, game.getAi1Win());
						db.uploadRoundData(game.getNumGame(), 2, game.getAi2Win());
						db.uploadRoundData(game.getNumGame(), 3, game.getAi3Win());
					}
					if(game.getAiNum()==2) {
						db.uploadRoundData(game.getNumGame(), 0, game.getHumanWin());
						db.uploadRoundData(game.getNumGame(), 1, game.getAi1Win());
						db.uploadRoundData(game.getNumGame(), 2, game.getAi2Win());
					}
					if(game.getAiNum()==1) {
						db.uploadRoundData(game.getNumGame(), 0, game.getHumanWin());
						db.uploadRoundData(game.getNumGame(), 1, game.getAi1Win());
						}
					game.resetGetter();
					System.out.println("Ends!");

				} else if (input == 2) {

					db.showRecord();
					db.closeConnection();

			} else if (input == 3) {
					System.out.println("Exit!");
					db.dropDatabase();
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
