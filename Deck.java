package blackjackpackage;

import java.util.ArrayList;
import java.util.Collections;

public class Deck 
{
	ArrayList<Card> deck = new ArrayList<Card>();

	public Deck()
	{
		resetDeck();
	}
	
	public String display()
	{
		String cardList = "";
		String row1 = "";
		String row2 = "";
		String row3 = "";
		String row4 = "";
		for (int cardNum = 0; cardNum < deck.size(); cardNum++)
		{
			if (cardNum >= 0 && cardNum < 13)
				row1 += deck.get(cardNum).toString() + ",";
			else if (cardNum >= 13 && cardNum < 26)
				row2 += deck.get(cardNum).toString() + ",";
			else if (cardNum >= 26 && cardNum < 39)
				row3 += deck.get(cardNum).toString() + ",";
			else if (cardNum >= 39 && cardNum < 52)
				row4 += deck.get(cardNum).toString() + ",";
			cardList = row1+"\n"+row2+"\n"+row3+"\n"+row4;
		}
		return cardList;
	}
	
	public ArrayList<Card> getDeck()
	{
		return deck;
	}
	
	public void resetDeck()
	{
		//clears deck
		deck.removeAll(deck);
		//spades
		deck.add(new Card('\u2660', "A", true));
		deck.add(new Card('\u2660', "2", true));
		deck.add(new Card('\u2660', "3", true));
		deck.add(new Card('\u2660', "4", true));
		deck.add(new Card('\u2660', "5", true));
		deck.add(new Card('\u2660', "6", true));
		deck.add(new Card('\u2660', "7", true));
		deck.add(new Card('\u2660', "8", true));
		deck.add(new Card('\u2660', "9", true));
		deck.add(new Card('\u2660', "10", true));
		deck.add(new Card('\u2660', "J", true));
		deck.add(new Card('\u2660', "Q", true));
		deck.add(new Card('\u2660', "K", true));
		//hearts
		deck.add(new Card('\u2665', "A", true));
		deck.add(new Card('\u2665', "2", true));
		deck.add(new Card('\u2665', "3", true));
		deck.add(new Card('\u2665', "4", true));
		deck.add(new Card('\u2665', "5", true));
		deck.add(new Card('\u2665', "6", true));
		deck.add(new Card('\u2665', "7", true));
		deck.add(new Card('\u2665', "8", true));
		deck.add(new Card('\u2665', "9", true));
		deck.add(new Card('\u2665', "10", true));
		deck.add(new Card('\u2665', "J", true));
		deck.add(new Card('\u2665', "Q", true));
		deck.add(new Card('\u2665', "K", true));
		//diamonds
		deck.add(new Card('\u2666', "A", true));
		deck.add(new Card('\u2666', "2", true));
		deck.add(new Card('\u2666', "3", true));
		deck.add(new Card('\u2666', "4", true));
		deck.add(new Card('\u2666', "5", true));
		deck.add(new Card('\u2666', "6", true));
		deck.add(new Card('\u2666', "7", true));
		deck.add(new Card('\u2666', "8", true));
		deck.add(new Card('\u2666', "9", true));
		deck.add(new Card('\u2666', "10", true));
		deck.add(new Card('\u2666', "J", true));
		deck.add(new Card('\u2666', "Q", true));
		deck.add(new Card('\u2666', "K", true));
		//clubs
		deck.add(new Card('\u2663', "A", true));
		deck.add(new Card('\u2663', "2", true));
		deck.add(new Card('\u2663', "3", true));
		deck.add(new Card('\u2663', "4", true));
		deck.add(new Card('\u2663', "5", true));
		deck.add(new Card('\u2663', "6", true));
		deck.add(new Card('\u2663', "7", true));
		deck.add(new Card('\u2663', "8", true));
		deck.add(new Card('\u2663', "9", true));
		deck.add(new Card('\u2663', "10", true));
		deck.add(new Card('\u2663', "J", true));
		deck.add(new Card('\u2663', "Q", true));
		deck.add(new Card('\u2663', "K", true));
	}
	
	public void shuffle()
	{
		Collections.shuffle(deck);
	}
	
	public Card deal()
	{
		Card newCard = deck.get(0);
		deck.remove(0);
		return newCard;
	}
	
	public int getSize()
	{
		return deck.size();
	}
}
