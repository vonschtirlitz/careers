
//TODO-GUI for selecting number of players.
//getNumPlayers()
import java.util.*;
public class MainStart
{
    private int playerNum;
    //Constructor
    public MainStart()
    {
        System.out.println("Welcome to the game of Careers!\nPlease enter the total number of players.");
        while(!(playerNum<7&&playerNum>1))
        {
            askNum();
        }
        System.out.println("Thank you");
    }
    
    //pre - none
    //post - the player is asked for a number
    private void askNum()
    {
        Scanner reader = new Scanner(System.in);
        System.out.println("Please remember that your number of players MUST be between 2-6.");
        playerNum = reader.nextInt();
    }
    
    //pre - none
    //post an integer is returned for the number of players
    public int getNumPlayers()
    {
        return this.playerNum;
    }
}
        
