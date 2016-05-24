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
            if(curPlayer.getOppHand().size()>0 && curPlayer.getExpHand().size()>0)
            {
                System.out.println("Your hand is:");
                for(int i=0;i<curPlayer.getOppHand().size();i++)
                    System.out.println(curPlayer.getOppHand().get(i));
                for(int i=0;i<curPlayer.getExpHand().size();i++)
                    System.out.println(curPlayer.getExpHand().get(i));
                cardsMainMenu(curPlayer);
            }
            else
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
    
    public void cardsMainMenu(Player curPlayer)
    {
        Scanner user = new Scanner(System.in);
        if(curPlayer.getOppHand().size()>0)
        {
            if(curPlayer.getExpHand().size()>0)
                cardsBothMenu(curPlayer,user);
            else
                cardsOppMenu(curPlayer,user);
        }
        else
            cardsExpMenu(curPlayer,user);
    }
    
    public void cardsBothMenu(Player curPlayer, Scanner user)
    {
        System.out.println("1 to use an experience card, 2 to use an opportunity card, 0 to roll");
        if(user.nextInt()==1)
            cardsExpPlaying(curPlayer,user);
        if(user.nextInt()==2)
            cardsOppPlaying(curPlayer,user);
        if(user.nextInt()==0)
            usedCard=false;
        else
            cardsBothMenu(curPlayer,user);
    }
    
     public void cardsExpMenu(Player curPlayer, Scanner user)
    {
        System.out.println("1 to use an experience card, 0 to roll");
        if(user.nextInt()==1)
            cardsExpPlaying(curPlayer,user);
        if(user.nextInt()==0)
            usedCard=false;
        else
            cardsExpMenu(curPlayer,user);
    }
    
     public void cardsOppMenu(Player curPlayer, Scanner user)
    {
        System.out.println("1 to use an opportunity card, 0 to roll");
        if(user.nextInt()==1)
            cardsOppPlaying(curPlayer,user);
        if(user.nextInt()==0)
            usedCard=false;
        else
            cardsOppMenu(curPlayer,user);
    }
    
    public void cardsExpPlaying(Player curPlayer, Scanner user)
    {
        for(int i=1;i<curPlayer.getExpHand().size()+1;i++)
                    System.out.println(i+": move "+ curPlayer.getExpHand().get(i-1).getValue()+"spaces");
        System.out.println("Or 0 to go back/nWhich card do you want to use?");
        int cardNumber=user.nextInt();
        if(cardNumber<=curPlayer.getExpHand().size()+1 && cardNumber>0)
            playExperienceCard(curPlayer,cardNumber);
    }
    
    public void cardsOppPlaying(Player curPlayer, Scanner user)
    {
        for(int i=1;i<curPlayer.getOppHand().size()+1;i++)
                    System.out.println(curPlayer.getOppHand().get(i));
    }
    
    public void playExperienceCard(Player curPlayer,int cardNumber)
    {
        //fill me
    }
    
    public void playOpportunityCard(Player curPlayer,int cardNumber)
    {
        //fill me
    }
    
    public void removePlayer()
    {
        //will be fixed? maybe?
    }
}
            
    
