//TODO-makes a player with GUI elements
//
import java.util.*;

public class PlayerCreator
{
    private int playerMax;
    private int currentPlayerNum;
    private int constructNum = 1;
    
    //Constructor
    public PlayerCreator()
    {
        playerMax = 4;
        currentPlayerNum = 1;
    }
    
    //pre - an int for the number of players is provided
    //post - a new player creator is constructed
    public PlayerCreator(int playerMax)
    {
        playerMax = playerMax;
        currentPlayerNum = 1;
    }
    
    //pre - none
    //post - a player is returned
    public Player newPlayer()
    {
        Player tempResult = new Player(1000,1000,1000,1000,this.currentPlayerNum, "Joe");
        this.currentPlayerNum = currentPlayerNum+1;
        return tempResult;
    }
    
    //pre - none
    //post - a player is returned
    public Player createPlayer()
    {
        int cashGoal = 0;
        int fameGoal = 0;
        int happinessGoal = 0;
        String name = "";
        Scanner reader = new Scanner(System.in);
        System.out.println(" Greetings Player " + constructNum);
        System.out.println("Type in cash goal");
        cashGoal = reader.nextInt();
        System.out.println("Type in fame goal");
        fameGoal = reader.nextInt();
        System.out.println("Type in happiness goal");
        happinessGoal = reader.nextInt();
        System.out.println("Type in your name");
        name = reader.next();
        Player tempResult = new Player(cashGoal,fameGoal,happinessGoal,1000,this.currentPlayerNum, name);
        this.currentPlayerNum = currentPlayerNum+1;
        constructNum++;
        return tempResult;
    }
        
}