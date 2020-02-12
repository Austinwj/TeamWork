package commandline;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLConn {
	
	public boolean status;
	private String logLink, user, password; 
	private Statement stmt = null;
	private ResultSet rs;
	private Connection con = null;
	
	public SQLConn(){

		this.logLink = "jdbc:postgresql://52.24.215.108:5432/";
		this.user = "AtlusTech";
		this.password = "AtlusTech";
		
	}
	
	public Connection getConnection() {
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(logLink, user, password);
			if (con != null) {
				System.out.println("Database connection succeeded!");
				status = true;
			} else {
				System.err.println("Failed to make connection!");
				status = false;
				}
		} catch (Exception e) {
			e.printStackTrace();
			status = false;
		}
		return con;
	}
	
	public void closeConnection() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void createTable() {
		try{
			Connection c = getConnection();
			stmt = c.createStatement();
			String SQL = "CREATE TABLE DATA " +
                    "(round INT PRIMARY KEY     NOT NULL," +
                    " draws           REAL    NOT NULL, " +
                    " rounds          INT     NOT NULL, " +
                    " winner          INT		NOT NULL); ";
			stmt.executeUpdate(SQL);
			stmt.close();
		}catch(Exception e) {
			System.err.println("Something wrong in creating table");
			e.printStackTrace();
			return;
		}
	}
	
	public int getNumOfGames()  {
		int num = 0;
		try {
			Connection c = getConnection();
			stmt = c.createStatement();
			this.rs = stmt.executeQuery("SELECT count(*) FROM GameRecord");
			if(this.rs.next()) {
				num = rs.getInt("count");
			}
		} catch (SQLException e) {
			System.err.println("Error to get number of games!");
			e.printStackTrace();
		}
		return num;
		
	}
	
	public int getNumOfUserWins() {
		int num = 0;
		try {
			Connection c = getConnection();
			stmt = c.createStatement();
			this.rs = stmt.executeQuery("SELECT count(*) AS sumHumanWin FROM GameRecord WHERE WINNER = 0");
			if(this.rs.next()) {
				num = rs.getInt("sumHumanWin");
			}
		} catch (SQLException e) {
			System.err.println("Error to get number of Uerwin!");
			e.printStackTrace();
		}
		return num;
		
	}
	
	public int getNumOfAIWins() {
		int num = 0;
		try {
			Connection c = getConnection();
			stmt = c.createStatement();
			this.rs = stmt.executeQuery("SELECT count(*) AS sumAIWin FROM GameRecord WHERE WINNER != 0");
			if(this.rs.next()) {
				num = rs.getInt("sumAIWin");
			}
		} catch (SQLException e) {
			System.err.println("Error to get number of AIwin!");
			e.printStackTrace();
		}
		return num;
		
	}
	
	public double getAvgNumOfDw() {
		double avgDraws = 0.0;
		try {
			Connection c = getConnection();
			stmt = c.createStatement();
			rs = stmt.executeQuery("SELECT AVG(DRAWS) AS avgDraws FROM GameRecord");
			if(this.rs.next()){
				avgDraws = rs.getInt("avgDraws");
			}
		}catch(Exception e) {
			System.err.println("Something wrong in getting average number of draws");
			e.printStackTrace();			
		}
		return avgDraws;
		
	}
	
	public int getLongestRuond() {
		int num = 0;
		try {
			Connection c = getConnection();
			stmt = c.createStatement();
			this.rs = stmt.executeQuery("SELECT MAX(ROUNDS) AS LongestRuond FROM GameRecord");
			if(this.rs.next())
				num = this.rs.getInt("LongestRuond");
		} catch (SQLException e) {
			System.err.println("Query is Failed!");
			e.printStackTrace();
		}
		return num;
		
	}
	
	public void uploadGameRecord(int ROUND, int DRAWS, int ROUNDS, int WINNER) {
		try {
			Connection c = getConnection();
			PreparedStatement create = c.prepareStatement(
					"INSERT INTO GameRecord(ROUND,DRAWS,ROUNDS,WINNER) "
					+ "values('"+ROUND+"','"+DRAWS+"','"+ROUNDS+"','"+WINNER+"')");

			create.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();;
		}
	}
	
	public void showRecord() {
		System.out.println("Game statistics: ");
		System.out.println("Number of Games: " + getNumOfGames());
		System.out.println("Number of AI Wins: " + getNumOfAIWins());
		System.out.println("Number of User Wins: " + getNumOfUserWins());
		System.out.println("Average number of Draws: " + getAvgNumOfDw());
		System.out.println("Longest Game: " + getLongestRuond());
		closeConnection();
	}
			
}

