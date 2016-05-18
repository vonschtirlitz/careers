import java.util.*;

public class GameMaster
{
    private ArrayList <Player> playerList;
    private ArrayList <Path> gameboard;
    private int turn;
    private Dealer dealer;
    
    public GameMaster()
    {
        playerList = new ArrayList<Player>();
        gameboard = new ArrayList<Path>();
        dealer = new Dealer();
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
    
    public void initPath()
    {
        Path main = new Path(32,"Main");
        Path business = new Path(11,"Business");
        Path college = new Path(7,"College");
        Path farming = new Path(9,"Farming");
        Path hollywood = new Path(9,"Hollywood");
        Path moon = new Path(13,"Moon");
        Path politics = new Path(11,"Politics");
        Path prospecting = new Path(11,"Prospecting");
        Path sea = new Path(9,"Sea");
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
            if(curPlayer.getOppHand().size()>0);
            {
                //ask if wants to use card, then do shit
            }
            if(curPlayer.getExpHand().size()>0);
            {
                //ask if wants to use card, then do shit
            }
            curPlayer.move(curPlayer.getPath(),roll());
            Spot curSpot = gameboard.get(curPlayer.getPath()).get(curPlayer.getPos());
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
            for(int i=0;i<(curSpot.oppCardGiven());i++)
                curPlayer.addOpportunityCard(dealer.dealTopOpportunity());
            for(int i=0;i<(curSpot.expCardGiven());i++)
                curPlayer.addExperienceCard(dealer.dealTopExperience());
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
    
    public void PlayExperienceCard()
    {
        //fill me
    }
    
    public void PlayOpportunityCard()
    {
        //fill me
    }
    
    public void removePlayer()
    {
        //will be fixed? maybe?
    }
}
            
    
