package main;

import map.Coin;
import map.ErrorMessage;
import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;


public class HighScore {
	private int userScore = 0;
	private int currentHighScore = 0;
	private Timer score = new Timer();
	private String userName = "John";
	private Coin coin = new Coin();
	private boolean gameInProgress = true;
	
	/**
	 * Defines the event for the Timer to preform every time it goes off
	 * It adds 1 point to user score every 500 miliseconds
	 */
	TimerTask count = new TimerTask() {
		public void run(){
			userScore++;
		}
	};

	/**
	 * Starts the timer, calling it to go off every 500 miliseconds
	 */
	public void start() {
		score.scheduleAtFixedRate(count, 0, 500);
	}

	/**
	 * Getter method for the current userScore calculated from the timer.
	 * Called in HighScoreGUI to write the score in the JFrame.
	 */
	public int getUserScore() {
		return userScore;
	}

	/**
	 * Called by HighScoreGUI to set the userName of the player
	 * Stores the player's name so that it can be recorded in the score board
	 * at the end of the game.
	 */
	public void setUserName() {
		userName = JOptionPane.showInputDialog("Enter your initials:");
	}

	/**
	 * Reads the previous highest score from the file HighScores.txt
	 * Returns int currentHighScore that the player has to beat in order to get the highest score.
	 */
	public int previousHighScore() {
		String fileName = "src/main/HighScores.txt";
		String line = null;
		String scoreInFile = "";

		try {
			FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
	
			while ((line = bufferedReader.readLine()) != null) {
				scoreInFile = line;
			}
			bufferedReader.close();
		} catch(FileNotFoundException ex) {
			ErrorMessage.addError("Unable to open file in HighScore");
		} catch(IOException ex) {
			ErrorMessage.addError("Error reading file in HighScore");
		}
		currentHighScore = Integer.parseInt(scoreInFile);
		return currentHighScore;
	}

	/**
	 * When the game ends the score of the user is compared to the previous highest score (currentHighScore)
	 * returns boolean isHigher true if the user score is greater than the previous high score.
	 */
	public boolean compareScores() {
		boolean isHigher = false;
		if (this.userScore > this.currentHighScore) {
			isHigher = true;
		} else {
			isHigher = false;
		}
		return isHigher;
	}
	

	/**
	 * If the user has gotten a new high score then it is written into the file
	 * recording the highest score (HighScores.txt), overwriting the previously recorded score.
	 */
	public void writeInNewScore() {
		String fileName = "src/main/HighScores.txt";
		BufferedWriter bWriter = null;
		FileWriter fWriter = null;
		try {
			String writeIn = String.valueOf(this.userScore);
			fWriter = new FileWriter(fileName);
			bWriter = new BufferedWriter(fWriter);
			bWriter.write(writeIn);
			bWriter.close();
			fWriter.close();
		} catch(IOException ex) {
			ErrorMessage.addError("Can't find file to write scores to");
		}
	}

	/**
	 * Called by when the player collides with and object (game over);
	 * Runs the sequence of events needed to stop the timer and compare
	 * and record the new user score and the previous high score.
	 * Called in HighScoreGUI
	 */
	public void gameHasEnded() {
		if (gameInProgress) {
			score.cancel();
			userScore = userScore + coin.getCollectedcoins();
			currentHighScore = this.previousHighScore();
			boolean isHigher = this.compareScores();
			if (isHigher) {
				this.writeInNewScore();
			}
			this.updateHighScoreBoard(this.userName, this.userScore);
			gameInProgress = false;
		}
	}
	
	/**
	 * Reads all high scores in from the file HighScoreBoard.txt
	 * Prints each score on the line with the name of who got it
	 * @param String playerName is a String of the current user name
	 * @param int userScore is an int with the score just accumulated by the player.
	 */
	public void updateHighScoreBoard(String playerName, int userScore) {
		ArrayList<String> scores = new ArrayList<>();
		ArrayList<Integer> sortingScores = new ArrayList<Integer>();
		String fileName = "src/main/HighScoreBoard.txt";
		String line = null;
		try{
			FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			while((line = bufferedReader.readLine()) != null){
				scores.add(line);
			}
			bufferedReader.close();
		}catch(FileNotFoundException ex){
			ErrorMessage.addError("Unable to open file for score board");
		}catch(IOException ex){
			ErrorMessage.addError("Error reading file for score board");
		}

		//takes the numbers from the scores and puts them in a list so that they can
		//be ordered properly
        int index = 0;
        int length = scores.size();
        for (index = 0; index < length; index++){
        	String linefromScores = scores.get(index);
        	String[] elem = linefromScores.split(" ");
        	int nextScore = Integer.parseInt(elem[0]);
        	sortingScores.add(nextScore);
        }

        //adds new user score and resorts the list
        sortingScores.add(userScore);
        Collections.sort(sortingScores);
        Collections.reverse(sortingScores);

        //get index of where new user score fits on the array
        int placement = sortingScores.indexOf(userScore);
        String newScore = userScore + " " + userName;
        scores.add(placement, newScore);
        printBoardToScreen(scores);
	}

	/**
	 * Writes the previous high scores from the array made from file to the
	 * GUI for the player when they game over
	 * @param Arraylist scores is the array made by updateHighScoreBoard()
	 * that holds all the previously gotten high scores.
	 */
	public void printBoardToScreen(ArrayList<String> scores) {
		String fileName = "src/main/HighScoreBoard.txt";
		try {
			FileWriter fWriter = new FileWriter(fileName);
			BufferedWriter bWriter = new BufferedWriter(fWriter);
			int size = scores.size();
			if (size>10) {
				size = 10;
			}
			for (int i=0; i<size; i++) {
				String writeIn = scores.get(i).toString();
				bWriter.write(writeIn);
				bWriter.newLine();
			}
			bWriter.close();
			fWriter.close();
		} catch(FileNotFoundException ex) {
			ErrorMessage.addError("Unable to open file for score board");
		} catch(IOException ex) {
			ErrorMessage.addError("Error reading file for score board");
		}
	}
	
}
