public class Dealer extends Player
{
	//define a deck of cards
	private Deck d;
	// constructor
	public Dealer() {
		resetHand();
		setWinCount(0);
		d = new Deck();
	}
	// shuffle method
	public void shuffle()
	{
	    d.shuffle();
	}
	// deal method
	public Card deal(){
	    return d.nextCard();
	}
	public int numCardsLeftInDeck()
	{
		return d.numCardsLeft();
	}
	// hit thru super
	public boolean hit()
	{
	    return super.hit();
    }
}








