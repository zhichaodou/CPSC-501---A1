package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import map.ErrorMessage;

public class HighScoreData {

	/**
	 * Reads the previous highest score from the file HighScores.txt
	 * Returns int currentHighScore that the player has to beat in order to get the highest score.
	 */
	public int getPreviousHighScore(int currentHighScore) {
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
	
	public boolean compareScores(int userScore, int currentHighScore) {
		boolean isHigher = false;
		if (userScore > currentHighScore) {
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
	
	public void writeInNewScore(int userScore) {
		String fileName = "src/main/HighScores.txt";
		BufferedWriter bWriter = null;
		FileWriter fWriter = null;
		try {
			String writeIn = String.valueOf(userScore);
			fWriter = new FileWriter(fileName);
			bWriter = new BufferedWriter(fWriter);
			bWriter.write(writeIn);
			bWriter.close();
			fWriter.close();
		} catch(IOException ex) {
			ErrorMessage.addError("Can't find file to write scores to");
		}
	}

}
