import java.util.*;

public class GameMaster
{
    private ArrayList <Player> playerList;
    private ArrayList <Board> gameboard;
    private int turn;
    
    public GameMaster()
    {
        playerList = new ArrayList<Player>();
        gameboard = new ArrayList<Board>();
        this.turn = 0;
    }
    
    public void initPlayers()
    {
        MainStart alpha = new MainStart();
        ArrayList<Player> tempList = new ArrayList<Player>();
        PlayerCreator bravo = new PlayerCreator(alpha.getNumPlayers());
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
    
    public void initBoard()
    {
        Board main = new Board(32,"Main");
        Board business = new Board(11,"Business");
        Board college = new Board(7,"College");
        Board farming = new Board(9,"Farming");
        Board hollywood = new Board(9,"Hollywood");
        Board moon = new Board(13,"Moon");
        Board politics = new Board(11,"Politics");
        Board prospecting = new Board(11,"Prospecting");
        Board sea = new Board(9,"Sea");
        gameboard.add(main);
        gameboard.add(business);
        gameboard.add(college);
        gameboard.add(farming);
        gameboard.add(hollywood);
        gameboard.add(moon);
        gameboard.add(politics);
        gameboard.add(prospecting);
        gameboard.add(sea);
    }
    
    public void processTurn()
    {
        System.out.println("Turn "+(turn+1));
        for(Player curPlayer : playerList)
        {
            System.out.println("It's "+curPlayer.getName()+"'s turn");
            curPlayer.move(curPlayer.getBoard(),roll());
            Spot curSpot = gameboard.get(curPlayer.getBoard()).get(curPlayer.getPos());
            if((curPlayer.getCash()+curSpot.getCashModifier())<0)
                curPlayer.setCash(0);
            else
                curPlayer.addCash(curSpot.getCashModifier());
            if((curPlayer.getFame()+curSpot.getFameModifier())<0)
                curPlayer.setFame(0);
            else
                curPlayer.addFame(curSpot.getFameModifier());
            if((curPlayer.getHappiness()+curSpot.getHappinessModifier())<0)
                curPlayer.setHappiness(0);
            else
                curPlayer.addHappiness(curSpot.getHappinessModifier());
            if((curPlayer.getSalary()+curSpot.getSalaryModifier())<0)
                curPlayer.setSalary(0);
            else
                curPlayer.increaseSalary(curSpot.getSalaryModifier());
            //add stuff to be processed for player during turn
        }
        this.turn++;
    }
    
    //Pre-none
    //Post-returns random int 2-12
    public int roll()
    {
        System.out.println("rolling...");
        Scanner reader = new Scanner(System.in);
        reader.nextLine();
        return ((int)(Math.random()*6+1)+(int)(Math.random()*6)+1);
    }
    
    public void removePlayer()
    {
        //will be fixed? maybe?
    }
}
            
    