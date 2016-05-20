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
            boolean allowOthers = true;
            
            //SkipTurn block
            //Currently operating on 2 dice
            if(curPlayer.getSkipTurn())
            {
                Spot playerSpot = gameboard.get(curPlayer.getPath()).get(curPlayer.getPos());
                if(playerSpot.getSkipTurnRequirements()>0)
                {
                    //implement asking player to deposit cash to move
                    boolean ask = false; //true if player accepts money penalty, false otherwise
                    if(ask)
                    {
                        curPlayer.setSkipTurn(false);
                    }
                    else
                    {
                        if(rollTwo()< playerSpot.getRollLessThan())
                        {
                            curPlayer.setSkipTurn(false);
                        }
                        else
                            allowOthers = false;
                    }
                }
                else
                {
                    if(rollTwo()< playerSpot.getRollLessThan())
                        {
                            curPlayer.setSkipTurn(false);
                        }
                        else
                            allowOthers = false;
                }
            }
            
            if(allowOthers)
            {
                if(curPlayer.getOppHand().size()>0 && curPlayer.getExpHand().size()>0)
                {
                    System.out.println("Your hand is:");
                    for(int i=0;i<curPlayer.getOppHand().size();i++)
                    {
                        System.out.println(curPlayer.getOppHand().get(i));
                    }
                    for(int i=0;i<curPlayer.getExpHand().size();i++)
                    {
                        System.out.println(curPlayer.getExpHand().get(i));
                    }
                }
                else
                    curPlayer.move(curPlayer.getPath(),rollTwo());
                Spot curSpot = gameboard.get(curPlayer.getPath()).get(curPlayer.getPos());
                if((curPlayer.getCash()+curSpot.getCashModifier())<0)
                    curPlayer.setCash(0);
                else
                {
                    if(curSpot.getDiceMod())
                    {
                        curPlayer.addCash(curSpot.getCashModifier()*rollOne());
                    }
                    else
                        curPlayer.addCash(curSpot.getCashModifier());
                }
                if((curPlayer.getFame()+curSpot.getFameModifier())<0)
                    curPlayer.setFame(0);
                else
                {
                    if(curSpot.getDiceMod())
                    {
                        curPlayer.addFame(curSpot.getFameModifier()*rollOne());
                    }
                    else
                        curPlayer.addFame(curSpot.getFameModifier());
                }
                if((curPlayer.getHappiness()+curSpot.getHappinessModifier())<0)
                    curPlayer.setHappiness(0);
                else
                {
                    if(curSpot.getDiceMod())
                    {
                        curPlayer.addHappiness(curSpot.getHappinessModifier()*rollOne());
                    }
                    else
                        curPlayer.addHappiness(curSpot.getHappinessModifier());
                }
                if((curPlayer.getSalary()+curSpot.getSalaryModifier())<0)
                    curPlayer.setSalary(0);
                else
                {
                    if(curSpot.getDiceMod())
                    {
                        curPlayer.increaseSalary(curSpot.getSalaryModifier()*rollOne());
                    }
                    else
                        curPlayer.increaseSalary(curSpot.getSalaryModifier());
                }
                for(int i=0;i<(curSpot.oppCardGiven());i++)
                {
                    curPlayer.addOpportunityCard(dealer.dealTopOpportunity());
                }
                for(int i=0;i<(curSpot.expCardGiven());i++)
                {
                    curPlayer.addExperienceCard(dealer.dealTopExperience());
                }
                //add stuff to be processed for player during turn
            }
            this.turn++;
        }
    }
    
    //Pre-none
    //Post-returns random int 2-12
    public int rollTwo()
    {
        System.out.println("rolling...");
        Scanner reader = new Scanner(System.in);
        reader.nextLine();
        return ((int)(Math.random()*6+1)+(int)(Math.random()*6)+1);
    }
    
    public int rollOne()
    {
        System.out.println("rolling...");
        Scanner reader = new Scanner(System.in);
        reader.nextLine();
        return ((int)(Math.random()*6+1));
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
            
    
