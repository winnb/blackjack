package blackjackpackage;

import java.util.ArrayList;

public class Hand
{
	ArrayList<Card> hand = new ArrayList<Card>();

	public void draw(Card newCard)
	{
		hand.add(newCard);
	}

	public ArrayList<Card> display()
	{
		return hand;
	}
	
	public int getHandValue()
	{
		int handValue = 0;
		int aceCount = 0;
		for (int i = 0; i < hand.size(); i++)
		{
			handValue += hand.get(i).getValue();
			if ("A".equals(hand.get(i).displayRank()))
				aceCount++;
		}
		if (handValue > 21)
		{
			while (aceCount > 0 && handValue > 21)
			{
				handValue -= 10;
				aceCount--;
			}		
		}
		return handValue;
	}
	
	public void resetHand()
	{
		hand.removeAll(hand);
	}
	
	public void hideCard()
	{
		hand.get(0).setFaceDown();
	}
	
	public void revealCard()
	{
		hand.get(0).setFaceUp();
	}
	
	public int getSize()
	{
		return hand.size();
	}
	
	public Card getCard(int cardNum)
	{
		return hand.get(cardNum);
	}
}