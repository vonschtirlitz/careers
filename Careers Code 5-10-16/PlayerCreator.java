//TODO-makes a player with GUI elements
//

public class PlayerCreator
{
    private int playerMax;
    private int currentPlayerNum;
    
    public PlayerCreator()
    {
        playerMax = 4;
        currentPlayerNum = 1;
    }
    
    public PlayerCreator(int playerMax)
    {
        playerMax = playerMax;
        currentPlayerNum = 1;
    }
    
    public Player newPlayer()
    {
        System.out.println("currentplayernum = " + currentPlayerNum);
        Player tempResult = new Player(1000,1000,1000,1000,this.currentPlayerNum);
        this.currentPlayerNum = currentPlayerNum+1;
        return tempResult;
    }
}