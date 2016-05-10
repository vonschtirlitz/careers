import java.util.*;

public class GameMaster
{
    private ArrayList <Player> playerList;
    private int turn;
    
    public GameMaster()
    {
        MainStart alpha = new MainStart();
        ArrayList<Player> tempList = new ArrayList<Player>();
        playerList = new ArrayList<Player>();
        PlayerCreator bravo = new PlayerCreator(alpha.getNumPlayers());
        turn = 0;
        for(int i = 0; i<alpha.getNumPlayers(); i++)
        {          
            tempList.add(bravo.newPlayer());
        }
        for(int i =0; i<alpha.getNumPlayers();i++)
        {
            int rand = (int)(Math.random()*tempList.size());
            playerList.add(tempList.remove(rand));
        }
    }
    
    //Pre-none
    //Post-returns 
    public int roll()
    {
        Scanner reader = new Scanner(System.in);
        reader.nextLine();
        return ((int)(Math.random()*6)+(int)(Math.random()*6));
    }
    
    public void removePlayer()
    {
        //will be fixed? maybe?
    }
}
            
    