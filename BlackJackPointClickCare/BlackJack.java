
import java.util.Scanner;
import java.util.ArrayList;
public class BlackJack
{

	private ArrayList<Player> players;
	public BlackJack()
	{
		players = new ArrayList<Player>();
	}
	public void playGame()
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.print("How many players? ");
		int num = keyboard.nextInt();
		boolean choice = true;
		Dealer deal = new Dealer();
		deal.shuffle();
		char ch = ' ';
		int totalGames = 0;
		for (int i = 0; i < num; ++i)
		{
			players.add(new Player());
		}
		do
		{
			totalGames++;
			for (int i = 0; i < num; ++i)
			{
				players.get(i).resetHand();
				players.get(i).addCardToHand(deal.deal());
				players.get(i).addCardToHand(deal.deal());
			}
			for (int i = 0; i < num; ++i)
			{
				System.out.println("\nPlayer " + (i + 1) + "\'s Current hand :: " + players.get(i));
				System.out.print("Do you want to hit? {Y/N] ");
				ch = keyboard.next().charAt(0);
				choice = (ch == 'Y') || (ch == 'y');
				while ((choice) && !(players.get(i).hit()))
				{
					players.get(i).addCardToHand(deal.deal());
					System.out.println("Player " + (i + 1) + "\'s Current hand :: " + players.get(i));
					if (players.get(i).hit())
						break;
					System.out.print("Do you want to hit? {Y/N] ");
					ch = keyboard.next().charAt(0);
					choice = (ch == 'Y') || (ch == 'y');
				}
			}
			while (deal.getHandValue() < 17)
			{
				deal.addCardToHand(deal.deal());
			}
			
			for (int i = 0; i < num; ++i)
			{
				System.out.println("\n\nPLAYER " + (i + 1));
				System.out.println("Hand Value :: " + players.get(i).getHandValue());
				System.out.println("Hand Size :: " + players.get(i).getHandSize());
				System.out.println("Card in Hand :: " + players.get(i));
			}
			
			System.out.println("\n\nDEALER");
			System.out.println("Hand Value :: " + deal.getHandValue());
			System.out.println("Hand Size :: " + deal.getHandSize());
			System.out.println("Card in Hand :: " + deal + "\n\n");
			
			for (int i = 0; i < num; ++i)
			{
				if (players.get(i).hit())
				{
					System.out.println("Dealer wins - Player " + (i + 1) + " busted!");
				}
				else
				{
					if (deal.hit())
					{
						System.out.println("Player " + (i + 1) + " wins - Dealer busted!");
						players.get(i).incWinCount();
					}
					else if (players.get(i).getHandValue() > deal.getHandValue())
					{
						System.out.println("Player " + (i + 1) + " has bigger hand value!");
						players.get(i).incWinCount();
					}
					else
					{
						System.out.println("Dealer has bigger hand value!");
					}
				}
			}
			
			for (int i = 0; i < num; ++i)
			{
				System.out.println("\nDealer won " + (totalGames - players.get(i).getWinCount()) + " times.");
				System.out.println("Player " + (i + 1) + " won " + players.get(i).getWinCount() + " times.");
			}
			
			System.out.print("\nDo you want to play again? [Y,y,N,n] :: ");
			ch = keyboard.next().charAt(0);
			choice = (ch == 'Y') || (ch == 'y');
			keyboard.nextLine();
		}
		while (choice);
	}
	
	public static void main(String[] args)
	{
		BlackJack game = new BlackJack();
		game.playGame();
	}
}