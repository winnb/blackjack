package blackjackpackage;

public class Card 
{
	//initialize variables
	private char suit;
	private String rank;
	private boolean faceUp;
	
	//set default values of blackjack
	public Card(char startingSuit, String startingRank, boolean startingFaceUp)
	{
		suit = startingSuit;
		rank = startingRank;
		faceUp = true;
	}
	
	public void setFaceUp()
	{
		faceUp = true;
	}
	
	public void setFaceDown()
	{
		faceUp = false;
	}
	
	public int getValue()
	{
		if (rank == "A")
			return 11;
		else if (rank == "2")
			return 2;
		else if (rank == "3")
			return 3;
		else if (rank == "4")
			return 4;
		else if (rank == "5")
			return 5;
		else if (rank == "6")
			return 6;
		else if (rank == "7")
			return 7;
		else if (rank == "8")
			return 8;
		else if (rank == "9")
			return 9;
		else
			return 10;
	}
	
	public char displaySuit()
	{
		if (faceUp == true)
		{
			return suit;
		}
		else
			return '?';
	}
	
	public String displayRank()
	{
		if (faceUp == true)
			return rank;
		else
			return "?";
	}
	
	public void setSuit(int suitNum)
	{	
		if (suitNum == 0)
			suit = '\u2660'; //spades
		if (suitNum == 1)
			suit = '\u2665'; //hearts
		if (suitNum == 2)
			suit = '\u2666'; //diamonds
		if (suitNum == 3)
			suit = '\u2663'; //clubs
	}
	
	public void setRank(int rankNum)
	{
		if (rankNum == 0)
			rank = "A";
		if (rankNum == 1)
			rank = "2";
		if (rankNum == 2)
			rank = "3";
		if (rankNum == 3)
			rank = "4";
		if (rankNum == 4)
			rank = "5";
		if (rankNum == 5)
			rank = "6";
		if (rankNum == 6)
			rank = "7";
		if (rankNum == 7)
			rank = "8";
		if (rankNum == 8)
			rank = "9";
		if (rankNum == 9)
			rank = "10";
		if (rankNum == 10)
			rank = "J";
		if (rankNum == 11)
			rank = "Q";
		if (rankNum == 12)
			rank = "K";
	}
	
	@Override
    public String toString() 
	{
        return this.rank +" of "+ suit;
    }
}
