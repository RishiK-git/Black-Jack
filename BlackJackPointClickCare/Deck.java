// imports
import java.util.ArrayList;
import java.util.Collections;

public class Deck
{
	// instance vars
	public static final int NUMFACES = 13;
	public static final int NUMSUITS = 4;
	public static final int NUMCARDS = 52;

	public static final String SUITS[] = {"CLUBS","SPADES","DIAMONDS","HEARTS"};

	private int topCardIndex;
	private ArrayList<Card> stackOfCards;

	// constructor
	public Deck()
	{
		//initialize data - stackOfCards - topCardIndex
		stackOfCards = new ArrayList<Card>();
		topCardIndex = 0;
		
		//loop through suits
		for (String suit : SUITS)
		{
			//loop through faces
			for (int f = 1; f <= NUMFACES; ++f)
			{
				//add in a new card
				stackOfCards.add(new BlackJackCard(f, suit));
			}
		}
		
	}

	//modifiers
   public void shuffle()
	{
		//shuffle the deck
		Collections.shuffle(stackOfCards);
		//reset variables as needed
		topCardIndex = 0;
	}

   //accessors
	public int size()
	{
		return NUMCARDS;
	}

	public int numCardsLeft()
	{
		return stackOfCards.size();
	}

	public Card nextCard()
	{
		topCardIndex++;
		return stackOfCards.get(topCardIndex - 1);
	}

	public String toString()
	{
		return stackOfCards + "   topCardIndex = " + topCardIndex;
	} 
}