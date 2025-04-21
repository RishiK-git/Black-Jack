// imports
import java.util.ArrayList;
public class Player
{
	// instance vars
	private ArrayList<Card> hand;
	private int winCount;
	// constructor default
	public Player()
	{
		hand = new ArrayList<Card>();
		winCount = 0;
	}
	// constructor parameters
	public Player(int score)
	{
		hand = new ArrayList<Card>();
		winCount = score;
	}
	// adds topmost card to hand
	public void addCardToHand(Card temp)
	{
		hand.add(temp);
	}
	// clears hand
	public void resetHand()
	{
		hand.clear();
	}
	public void setWinCount(int numwins)
	{
		winCount = numwins;
	}
	public void incWinCount()
	{
		winCount++;
	}
	// returns win count, hand size
	public int getWinCount() { return winCount; }
	public int getHandSize() { return hand.size(); }
	// hand val return
	public int getHandValue()
	{
		int value = 0;
		for (int i = 0; i < hand.size(); ++i)
		{
			value += hand.get(i).getValue();
		}
		return value;
	}
	public boolean hit()
	{
		return getHandValue() > 21;
	}
	// returns hand as string
	public String toString()
	{
		String h = "hand = " + hand + " - " + getHandValue();
		return h;
	}
}