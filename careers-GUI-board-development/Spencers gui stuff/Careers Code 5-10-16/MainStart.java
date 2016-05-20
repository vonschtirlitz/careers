
//TODO-GUI for selecting number of players.
//getNumPlayers()
import java.util.*;
public class MainStart
{
    private int playerNum;
    public MainStart()
    {
        System.out.println("Welcome to the game of Careers!\nPlease enter the total number of players.");
        while(!(playerNum<7&&playerNum>1))
        {
            askNum();
        }
        System.out.println("Thank you");
    }
    
    private void askNum()
    {
        Scanner reader = new Scanner(System.in);
        System.out.println("Please remember that your number of players MUST be between 2-6.");
        playerNum = reader.nextInt();
    }
    
    public int getNumPlayers()
    {
        return this.playerNum;
    }
}
        
