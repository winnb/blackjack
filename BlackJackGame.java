package blackjackpackage;

import java.util.Scanner;

public class BlackJackGame 
{
	private Scanner in = new Scanner(System.in);
	private String answer;
	private Hand player = new Hand();
	private Hand dealer = new Hand();
	private int wallet;
	private boolean validInput;
	private boolean hitMe;
	private int bet;
	private String table;
	private String intList;
	private String validInputList;
	
	public BlackJackGame()
	{
		wallet = 10;
		validInput = false;
		hitMe = true;
		intList = "";
		validInputList = "yesYESnoNO";
		
	}
	
	public Deck startGame(Deck deck)
	{
		//Reset relevant variables at the start of each game
		hitMe = true;
		player.resetHand();
		dealer.resetHand();
		
		//Dynamically create list of valid inputs
		for (int i = 1; i < wallet+1; i++)
		{
			intList += Integer.toString(i);
		}
		
		if (tooBroke() == false && deck.getSize() > 9)
		{
			//Get bet
			System.out.println("There are "+ deck.getSize() +" cards in the deck.\nYou have $"+ wallet +". ");
			bet = getBet();
			
			//Dealer draws a face down card
			Card newCard = deck.deal();
			dealer.draw(newCard); 
			dealer.hideCard();
			
			//Dealer draws a face up card
			newCard = deck.deal();
			dealer.draw(newCard);
			
			//Player is dealt their first card
			newCard = deck.deal();
			player.draw(newCard);
			
			//Continue to offer player more cards until they decline
			while (hitMe == true)
			{
				//Player is dealt another card
				newCard = deck.deal();
				player.draw(newCard);
				displayTable();
				if (player.getHandValue() < 21)
					requestCard();
				else
					hitMe = false;
			}
			if (player.getHandValue() < 21)
			{
				while (dealer.getHandValue() < 17)
				{
					newCard = deck.deal();
					dealer.draw(newCard);
					System.out.println("Dealer takes a card: "+ dealer.getCard(0).displayRank() +" of "+ dealer.getCard(0).displaySuit()+".");
				}
			}
			dealer.revealCard();
			getResults();	
		}
		else if (tooBroke() == false && deck.getSize() < 10)
		{
			System.out.println("There are less than 10 cards left in the deck. Please get a new deck to play again.");
		}
		else
		{
			System.out.println("It looks like you're all out of money. Please exit the premesis. There are no free-loaders welcome here.");
		}
		return deck;
	}
	
	public boolean tooBroke()
	{
		if (wallet < 1)
			return true;
		else
			return false;
	}
	
	public int getBet()
	{
		validInput = false;
		while (validInput == false)
		{
			System.out.print("How much do you want to bet?\n");
			answer = in.next();
			if (intList.contains(answer) && Integer.parseInt(answer) <= wallet)
				validInput = true;
			else
				System.err.println("Please enter a valid amount.\n");
		}
		return Integer.parseInt(answer);
	}
	
	public void displayTable()
	{
		if (hitMe == true)
			table = "Dealer:          ";
		else
			table = "Dealer:          Total: "+ dealer.getHandValue() +"\n                 ";
		
		for (int i = 0; i < dealer.getSize(); i++)
		{
			table += dealer.getCard(i).displayRank() +" of "+ dealer.getCard(i).displaySuit() +"\n                 ";
		}
		table += "\nPlayer:          Total: "+ player.getHandValue() +"\n                 ";
		for (int i = 0; i < player.getSize(); i++)
		{
			table += player.getCard(i).displayRank() +" of "+ player.getCard(i).displaySuit() +"\n                 ";
		}
		
		System.out.println(table);
	}
	
	public void requestCard()
	{
		validInput = false;
		while (validInput == false)
		{
			System.out.println("Do you want another card? [Y/N] ");
			answer = in.next();
			if ("N".equals(answer.toUpperCase()) || "NO".equals(answer.toUpperCase()))
			{
				validInput = true;
				hitMe = false;
			}
			else if ("Y".equals(answer.toUpperCase()) || "YES".equals(answer.toUpperCase()))
			{
				validInput = true;
				hitMe = true;
			}
			else if (!validInputList.contains(answer))
				System.err.println("Please enter Y or N.\n");
		}
	}
	
	public void getResults()
	{
		dealer.revealCard();
		if (dealer.getHandValue() < 21 && player.getHandValue() < 21)
		{
			System.out.println("Dealer stands...\n\nResults:\n");
			displayTable();
			if (dealer.getHandValue() > player.getHandValue())
			{
				System.out.println("Dealer is closer to 21. You lose.");
				wallet -= bet;
			}
			else if (dealer.getHandValue() < player.getHandValue())
			{
				System.out.println("Player is closer to 21. Congrats! You win.");
				wallet += bet;
			}
			else
			{
				System.out.println("Player and dealer are tied. Rules state that the player breaks ties. Congrats! You win.");
				wallet += bet;
			}
		}
		else if (dealer.getHandValue() == 21)
		{
			System.out.println("Dealer has blackjack...\n\nResults:\n");
			displayTable();
			System.out.println("Sorry pal, you lose.");
			wallet -= bet;
		}
		else if (dealer.getHandValue() > 21)
		{
			System.out.println("Dealer busts...\n\nResults:\n");
			displayTable();
			System.out.println("You got lucky this time. Congrats! You win.");
			wallet += bet;
		}
		else if (player.getHandValue() == 21)
		{
			System.out.println("Player has blackjack...\n\nResults:\n");
			displayTable();
			System.out.println("Congrats! You win.");
			wallet += bet;
		}
		else if (player.getHandValue() > 21)
		{
			System.out.println("Player busts...\n\nResults:\n");
			displayTable();
			System.out.println("Sorry pal, you lose.");
			wallet -= bet;
		}
		else
		{
			System.out.println("\nResults:\n");
			displayTable();
			System.out.println("We couldn't find out who won for some reason.");
		}
		System.out.println("You have $"+ wallet +".\n");
	}
}