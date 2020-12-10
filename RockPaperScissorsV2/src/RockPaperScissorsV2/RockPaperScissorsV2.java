package RockPaperScissorsV2;

//Rules of Rock Paper Scissors Game:
//1. The Rock beats the Scissors .
//2. The Scissors beats the Paper.
//3. The Paper beats the Rock.
//4. If both opponents chose the same property then it´s a tie.

import java.util.Scanner;

public class RockPaperScissorsV2 {

	public static void main(String[] args) {

		String numberOfPlayers = "";
		String myMove;
		String opponentMove;

		// Display the introduction message
		introMsg();

		// Loop through game length.
		// numberOfPlayers != quit
		while (!numberOfPlayers.equals("quit")) {
			// Get numberOfPlayers
			numberOfPlayers = getNumberOfPlayers();

			// If statement to exit the game.
			if (numberOfPlayers.equals("quit"))
				break;

			System.out.println("Player 1: Enter your move");
			myMove = getMove();

			// If statement to exit the game.
			if (myMove.equals("quit"))
				break;

			// check to see if it is 2 player mode
			if (numberOfPlayers.equals("2")) {
				System.out.println("Player 2: Enter your move");
				opponentMove = getMove();

				// If statement to exit the game.
				if (myMove.equals("quit"))
					break;
			} else
				// get computer move
				opponentMove = getComputerMove();

			// Checking if a game is a tie or someone wins.
			if (myMove.equals(opponentMove))
				System.out.println("It's a tie!");
			else if ((myMove.equals("rock") && opponentMove.equals("scissors"))
					|| (myMove.equals("scissors") && opponentMove.equals("paper")
							|| (myMove.equals("paper") && opponentMove.equals("rock"))))

			{
				System.out.println("Player 1 wins!");
			} else {
				if (numberOfPlayers.equals("1"))
					System.out.println("Computer wins!");
				else
					System.out.println("Player 2 wins!");
			}

			System.out.println();
		}

		// Display exit message
		exitMsg();
	}

	public static String getComputerMove() {
		String computerMove;

		// Randomly create the opponent move (0,1,2)
		int rand = (int) (Math.random() * 3);
		computerMove = "";

		if (rand == 0)
			computerMove = "rock";
		else if (rand == 1)
			computerMove = "paper";
		else
			computerMove = "scissors";

		System.out.println("Computer move = " + computerMove);
		System.out.println();

		return computerMove;
	}

	public static String getMove() {
		// Get the users input.
		Scanner inputTxt = new Scanner(System.in);
		String userInputString;
		String userMove = "";

		while (userMove.equals("")) {
			System.out.println();
			System.out.println("Choose one of the following:");
			System.out.println("1. Rock");
			System.out.println("2. Paper");
			System.out.println("3. Scissors");
			System.out.println();
			System.out.println("Enter q to quit");

			userInputString = inputTxt.nextLine();
			userInputString = userInputString.toLowerCase();

			if (userInputString.equals("rock") || userInputString.equals("paper")
					|| userInputString.equals("scissors")) {
				userMove = userInputString;
			} else if (userInputString.length() == 1 && userInputString.charAt(0) == '1')
				userMove = "rock";
			else if (userInputString.length() == 1 && userInputString.charAt(0) == '2')
				userMove = "paper";
			else if (userInputString.length() == 1 && userInputString.charAt(0) == '3')
				userMove = "scissors";
			else if (userInputString.length() == 1 && userInputString.charAt(0) == 'q')
				userMove = "quit";
			else {
				System.out.println("Invalid input, try again!");
				System.out.println();
			}
		}
		System.out.println("Your move = " + userMove);
		System.out.println();

		return userMove;
	}

	public static String getNumberOfPlayers() {
		// Get the users input.
		Scanner inputTxt = new Scanner(System.in);
		String userInputString;
		String numberOfPlayers = "";

		while (numberOfPlayers.equals("")) {

			System.out.println("How many players? (1 or 2)");
			System.out.println("Enter q to quit");

			userInputString = inputTxt.nextLine();
			userInputString = userInputString.toLowerCase();

			// check userInputString length = 1
			// and the value is either 1 or 2
			// then return numberOfPlayers
			if (userInputString.length() == 1
					&& (userInputString.charAt(0) == '1' || userInputString.charAt(0) == '2')) {
				numberOfPlayers = userInputString;
			} else if (userInputString.charAt(0) == 'q') {
				// set numberOfPlayers to quit
				numberOfPlayers = "quit";
			} else {
				System.out.println("Invalid input, try again!");
				System.out.println();
			}
		}

		System.out.println();

		return numberOfPlayers;
	}

	public static void introMsg() {
		System.out.println();
		System.out.println("Welcome to the game of Rock, Scissors, Paper!");
		System.out.println("=============================================");
		System.out.println();
		System.out.println("This game can be played either 2 players or Single player against AI player");
		System.out.println();
	}

	public static void exitMsg() {
		System.out.println();
		System.out.println("==========================");
		System.out.println("| Thanks for playing. :) |");
		System.out.println("==========================");
		System.out.println();
	}

}
