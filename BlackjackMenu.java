/*
 * Brandon Winn
 * CECS 274-05
 * Prog 2 Blackjack
 * Oct 3, 2017
 * 
 */
package blackjackpackage;

import java.util.Scanner;

public class BlackjackMenu
{
	public static void main(String[] args) 
	{
		//Instantiate objects
		Scanner in = new Scanner(System.in);
		BlackJackGame game = new BlackJackGame();
		
		Deck deck = new Deck();
		
		//Declare variables
		String validInputs = "12345";
		String answer;
		boolean exit = false;
		
		while (exit == false)
		{
			//Generate menu
			System.out.println("1. New deck \n2. Shuffle cards in deck \n3. Display all cards remaining in the deck \n4. Play Blackjack \n5. Exit");
			answer = in.next();
			
			//1. New deck
			if ("1".equals(answer))
			{
				deck.resetDeck();
				System.out.println("A new deck has been succesfully created.\n");
			}
			//2. shuffle deck
			else if ("2".equals(answer))
			{
				deck.shuffle();
				System.out.println("The deck has been successfully shuffled.\n");
			}
				
			//3. display all cards
			else if ("3".equals(answer))
			    System.out.println(deck.display()+"\n");
			//4. play blackjack
			else if ("4".equals(answer))
			{
				System.out.println();	
				deck = game.startGame(deck);
			}
			else if ("5".equals(answer))
						exit = true;
			if (!validInputs.contains(answer))
				System.err.println("Please enter 1-5.\n");
		}
		in.close();
	}
}
