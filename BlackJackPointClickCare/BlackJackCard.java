
public class BlackJackCard extends Card
{
  	//constructors
	public BlackJackCard()
	{
		setFace(0);
		setSuit("");
	}
	public BlackJackCard(int i, String s)
	{
		setFace(i);
		setSuit(s);
	}
  	public int getValue()
  	{
  		//enables you to build the value for the game into the card
		if (super.getValue() == 1) return 11;
		else if (super.getValue() <= 10) return super.getValue();
		else return 10;
  	}
}