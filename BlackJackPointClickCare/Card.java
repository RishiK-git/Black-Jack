public class Card
{
	public static final String FACES[] = {"ZERO","ACE","TWO","THREE","FOUR",
			"FIVE","SIX","SEVEN","EIGHT","NINE","TEN","JACK","QUEEN","KING"};

	private String suit;
	private int face;

  	//constructors
	public Card()
	{
		suit = "";
		face = 0;
	}
	public Card(int f, String s)
	{
		suit = s;
		face = f;
	}
	//modifiers
	public void setSuit(String s)
	{
		suit = s;
	}
	public void setFace(int f)
	{
		face = f;
	}
  	//accessors
	public String getSuit()
	{
		return suit;
	}
  	public int getValue()
  	{
  		return face;
  	}

	public boolean equals(Object obj)
	{
		Card ob = (Card)obj;
		return ((this.getSuit() == ob.getSuit()) && (this.getValue() == ob.getValue()));
	}
  	//toString
  	public String toString()
	{
		return FACES[face] + " of " + getSuit()/* + " | value = " + getValue()*/;
	}
}