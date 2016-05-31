import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class GameMaster
{
    private ArrayList <Player> playerList;
    private ArrayList <Path> gameboard;
    private int turn;
    private Dealer dealer;
    private boolean usedOpportunityCard;
    private boolean usedExperienceCard;
    private Opportunity opportunityCardUsed;
    private int experienceCardUsed;
    private JFrame frame;                     
    private ImagePanel imagePanel;
    private MainStart alpha;
    
    //Constructor
    public GameMaster()
    {
        playerList = new ArrayList<Player>();
        gameboard = new ArrayList<Path>();
        dealer = new Dealer();
        this.turn = 0;
        usedOpportunityCard = false;
        usedExperienceCard = false;
    }
    
    //pre - none
    //post - the GUI is initialized
    public void initGui()
    {
        frame = new JFrame("Careers!: The Game");
        imagePanel = new ImagePanel("Images\\backgroundv3.JPG");
        imagePanel.setImage(new ImageIcon("Images\\redBall.gif").getImage());
        frame.add(imagePanel);
        frame.setSize(imagePanel.getPreferredSize());
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        imagePanel.setPlayers(this,alpha);
    }
    
    //pre - none
    //post - the game is run
    public void runGame()
    {
        initPlayers();
        initPath();
        initGui();
        boolean keepPlaying = true;
        while(keepPlaying)
        {
            processTurn();
            for(Player curPlayer : playerList)
            {
                if(curPlayer.isVictoryMeet())
                {
                    keepPlaying = false;
                    System.out.println(curPlayer.getNumber()+" has won!");
                }
            }
        }
    }
    
    //pre - none
    //post - the players are added to the game
    public void initPlayers()
    {
        alpha = new MainStart();
        ArrayList<Player> tempList = new ArrayList<Player>();
        PlayerCreator bravo = new PlayerCreator(alpha.getNumPlayers());
        for(int i = 0; i<alpha.getNumPlayers(); i++)
        {          
            tempList.add(bravo.createPlayer());
        }
        
        for(int i =0; i<alpha.getNumPlayers();i++)
        {
            int rand = (int)(Math.random()*tempList.size());
            playerList.add(tempList.remove(rand));
        }
        
    }
    
    //pre - none
    //post the paths are initialized
    public void initPath()
    {
        Path main = new Path(32,"Main");
        main.setToMain();
        Path business = new Path(11,"Business");
        business.setToBusiness();
        Path college = new Path(7,"College");
        college.setToCollege();
        Path farming = new Path(9,"Farming");
        farming.setToFarming();
        Path hollywood = new Path(9,"Hollywood");
        hollywood.setToHollywood();
        Path moon = new Path(13,"Moon");
        moon.setToMoon();
        Path politics = new Path(11,"Politics");
        politics.setToPolitics();
        Path prospecting = new Path(11,"Prospecting");
        prospecting.setToUranium();
        Path sea = new Path(9,"Sea");
        sea.setToSea();
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
    
    //pre - none
    //post - the logic for the game is below. The game is played and the turns are run out
    public void processTurn()
    {
        System.out.println("Turn "+(turn+1));
        for(Player curPlayer : playerList)
        {
            System.out.println("It's "+curPlayer.getName()+"'s turn");
            boolean allowOtherMethods = true;
            usedOpportunityCard = false;
            usedExperienceCard = false;

            //SkipTurn block
            //Currently operating on 2 dice
            if(curPlayer.getSkipTurn())
            {
                Spot playerSpot = gameboard.get(curPlayer.getPath()).get(curPlayer.getPos());
                if(curPlayer.getXpos() == 20 && curPlayer.getYpos() == 40)
                {
                    int attemptA = rollOne();
                    int attemptB = rollOne();
                    if((attemptA + attemptB) == 7)
                    {
                        curPlayer.setSkipTurn(false);
                        System.out.println("You rolled a 7! Social Security programs got you back on your feet!");
                    }
                    else if((attemptA + attemptB) == 11)
                    {
                        curPlayer.setSkipTurn(false);
                        System.out.println("You rolled an 11! Your family got together to rent you a new Apartment!");
                    }
                    else if(attemptA == attemptB)
                    {
                        curPlayer.setSkipTurn(false);
                        System.out.println("You rolled doubles! You found a golden ticket from a sewer pipe that took you an magical journey in a chocolate moguls' mysterious factory! It also won you the lottery!");
                    }
                    else
                    {
                        allowOtherMethods = false;
                    }
                }
                else if(playerSpot.getSkipTurnRequirements()>0)
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
                            allowOtherMethods = false;
                    }
                }
                else
                {
                    if(rollTwo()< playerSpot.getRollLessThan())
                        {
                            curPlayer.setSkipTurn(false);
                        }
                        else
                            allowOtherMethods = false;
                }
            }
            
            if(allowOtherMethods)
            {
                if(curPlayer.getOppHand().size()>0 && curPlayer.getExpHand().size()>0)
                {
                    System.out.println("Your hand is:");
                    for(int i=0;i<curPlayer.getOppHand().size();i++)
                        System.out.println(curPlayer.getOppHand().get(i));
                        
                    for(int i=0;i<curPlayer.getExpHand().size();i++)
                        System.out.println(curPlayer.getExpHand().get(i));
                    cardsMainMenu(curPlayer);
                }
                
                if(!usedOpportunityCard)
                {
                    int rollTwo;
                    int rollOne;
                    System.out.println("Rolling...");
                    Scanner reader = new Scanner(System.in); 
                    reader.nextLine();
                    if(usedExperienceCard)
                    {
                        rollTwo = experienceCardUsed;
                        rollOne = experienceCardUsed;
                    }
                    else
                    {
                        rollTwo = rollTwo();
                        rollOne = rollOne();
                    }
                    
                    int pathSize = gameboard.get(curPlayer.getPath()).getSize();
                    
                    if(curPlayer.getPath()==0)
                    {
                        int tempPos = rollTwo + curPlayer.getPos();
                        if(tempPos > 31)
                        {
                            curPlayer.setPos(tempPos-31);
                            curPlayer.addCash(curPlayer.getSalary());
                        }
                        else
                        {
                            curPlayer.setPos(tempPos);
                        }
                    }
                    
                    if(curPlayer.getPath()==1)
                    {
                        System.out.println("Rolled a "+rollOne);
                        int tempPos = rollOne + curPlayer.getPos();
                        if(tempPos > 9)
                        {
                            curPlayer.setPath(0);
                            curPlayer.setPos((tempPos - 9) + 4);
                        }
                        else
                        {
                            curPlayer.setPos(curPlayer.getPos() + rollOne);
                        }
                    }
                    
                    if(curPlayer.getPath()==2)
                    {
                        System.out.println("Rolled a "+rollOne);
                        int tempPos = rollOne + curPlayer.getPos();
                        if(tempPos > 7)
                        {
                            curPlayer.setPath(0);
                            curPlayer.setPos((tempPos - 7) + 9);
                        }
                        else
                        {
                            curPlayer.setPos(curPlayer.getPos() + rollOne);
                        }
                    }
                    
                    if(curPlayer.getPath()==3)
                    {
                        System.out.println("Rolled a "+rollOne);
                        int tempPos = rollOne + curPlayer.getPos();
                        if(tempPos > 11)
                        {
                            curPlayer.setPath(0);
                            curPlayer.setPos((tempPos - 11) + 11);
                        }
                        else
                        {
                            curPlayer.setPos(curPlayer.getPos() + rollOne);
                        }
                    }
                    
                    if(curPlayer.getPath()==4)
                    {
                        System.out.println("Rolled a "+rollOne);
                        int tempPos = rollOne + curPlayer.getPos();
                        if(tempPos > 9)
                        {
                            curPlayer.setPath(0);
                            curPlayer.setPos((tempPos - 9) + 16);
                        }
                        else
                        {
                            curPlayer.setPos(curPlayer.getPos() + rollOne);
                        }
                    }
                    
                    if(curPlayer.getPath()==5)
                    {
                        System.out.println("Rolled a "+rollOne);
                        int tempPos = rollOne + curPlayer.getPos();
                        if(tempPos > 11)
                        {
                            curPlayer.setPath(0);
                            curPlayer.setPos((tempPos - 11) + 19);
                        }
                        else
                        {
                            curPlayer.setPos(curPlayer.getPos() + rollOne);
                        }
                    }
                    
                    if(curPlayer.getPath()==6)
                    {
                        System.out.println("Rolled a "+rollOne);
                        int tempPos = rollOne + curPlayer.getPos();
                        if(tempPos > 9)
                        {
                            curPlayer.setPath(0);
                            curPlayer.setPos((tempPos - 9) + 24);
                        }
                        else
                        {
                            curPlayer.setPos(curPlayer.getPos() + rollOne);
                        }
                    }
                    
                    if(curPlayer.getPath()==7)
                    {
                        System.out.println("Rolled a "+rollOne);
                        int tempPos = rollOne + curPlayer.getPos();
                        if(tempPos > 11)
                        {
                            curPlayer.setPath(0);
                            if(((tempPos - 11) + 27) <= 31)
                            {
                                curPlayer.setPos((tempPos - 11) + 27);
                            }
                            else
                            {
                                int tempValue = tempPos - 11 + 27;
                                tempValue -= 32;
                                curPlayer.setPos(tempValue);
                            }
                        }
                    }
                    
                    if(curPlayer.getPath()==8)
                    {
                        System.out.println("Rolled a "+rollOne);
                        int tempPos = rollOne + curPlayer.getPos();
                        if(tempPos > 13)
                        {
                            curPlayer.setPath(0);
                            if(((tempPos - 13) + 0) <= 31)
                            {
                                curPlayer.setPath((tempPos - 13) + 0);
                            }
                            else
                            {
                                int tempValue = tempPos - 13;
                                tempValue -= 32;
                                curPlayer.setPos(tempValue);
                            }
                        }
                    }
                    
                }
            }
            Spot curSpot = gameboard.get(curPlayer.getPath()).get(curPlayer.getPos());
          //teleports
            if(curSpot.getEntrySpot())
            {
                ArrayList<Opportunity> oppHand = curPlayer.getOppHand();
                boolean allowIntoSpot = false;
                for(int x = 0; x < curPlayer.getOpHandSize(); x++)
                {
                    if((oppHand.get(x).getOpportunity()==curSpot.getPosition()))
                    {
                        if(oppHand.get(x).isFree() == true)
                        {
                            allowIntoSpot = true;
                            x = curPlayer.getOpHandSize();
                        }
                        else
                        {
                            x = curPlayer.getOpHandSize();
                        }
                    }
                }
                
                if(allowIntoSpot)
                {
                    Scanner reader = new Scanner(System.in);
                    System.out.println("You are eligible to enter a path for free. Continue? \n 1. Yes\n2. No");
                    int number = reader.nextInt();
                    if(number==1)
                    {
                        curPlayer.move(curSpot.getMoveBoard(),curSpot.getMoveSpot());
                    }
                }
                else if(curSpot.getCashRequirement()<=curPlayer.getCash())
                {
                    Scanner reader = new Scanner(System.in);
                    System.out.println("You are eligible to enter a path for $"+curSpot.getCashRequirement()+". Continue? \n 1. Yes\n2. No");
                    int number = reader.nextInt();
                    if(number==1)
                    {
                        curPlayer.addCash(curSpot.getCashRequirement()*-1);
                        curPlayer.move(curSpot.getMoveBoard(),curSpot.getMoveSpot());
                    }
                }
            }
        
            if((curSpot.getMoveBoard()>-1)&&(curSpot.getEntrySpot()))
            {
                curPlayer.move(curSpot.getMoveBoard(),curSpot.getMoveSpot());
            }
            curSpot = gameboard.get(curPlayer.getPath()).get(curPlayer.getPos());
            curPlayer.setXpos(curSpot.getXPos());
            //System.out.println(curSpot.getXPos());
            curPlayer.setYpos(curSpot.getYPos());
            //System.out.println(curSpot.getYPos());
            int rollMod = rollOne();//for roll dice to
            imagePanel.updateImage();
            System.out.println("I'm at "+curPlayer.getPath()+"\t"+curPlayer.getPos());
            
            //mod amount of cash
            if((curPlayer.getCash() + curSpot.getCashModifier())<0)
                curPlayer.setCash(0);
            else
            {
                if(curSpot.getDiceMod())
                {
                    curPlayer.addCash(curSpot.getCashModifier()*rollMod);
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
                    curPlayer.addFame(curSpot.getFameModifier()*rollMod);
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
                    curPlayer.addHappiness(curSpot.getHappinessModifier()*rollMod);
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
                    curPlayer.increaseSalary(curSpot.getSalaryModifier()*rollMod);
                }
                else
                    curPlayer.increaseSalary(curSpot.getSalaryModifier());
            }
            
            if(curSpot.getHalveCash())
            {
                curPlayer.setCash(curPlayer.getCash()/2);
            }
            
            if(curSpot.getQuarterCash())
            {
                curPlayer.setCash(curPlayer.getCash()*3/4);
            }
            
             if(curSpot.getHalveFame())
            {
                curPlayer.setFame(curPlayer.getFame()/2);
            }
            
             if(curSpot.getHalveHappiness())
            {
                curPlayer.setHappiness(curPlayer.getHappiness()/2);
            }
            
            if(curSpot.getPayHalfSalary())
            {
                curPlayer.addCash(curPlayer.getSalary()/-2);
            }
            
             if(curSpot.getHalveSalary())
            {
                curPlayer.setSalary(curPlayer.getSalary()/2);
            }
            
            if(curSpot.getStart())
            {
                curPlayer.addCash(curPlayer.getSalary());
            }
            
            if(curSpot.getTenPercent())
            {
                curPlayer.addCash(curPlayer.getSalary()/10*((int)(Math.random()*6+1)));
            }
            
            if(curPlayer.getXpos() == 20 && curPlayer.getYpos() == 40)
            {
            }
            
            for(int i=0;i<(curSpot.oppCardGiven());i++)
            {
                curPlayer.addOpportunityCard(dealer.dealTopOpportunity());
            }
            
            for(int i=0;i<(curSpot.expCardGiven());i++)
            {
                curPlayer.addExperienceCard(dealer.dealTopExperience());
            }
            System.out.println(curPlayer);
            System.out.println("Im at "+curPlayer.getPos());
            /*
            //add stuff to be processed for player during turn
            if(curPlayer.isVictoryMeet())
            {
                break;
            }
            */        
        }
        this.turn++;
    }
    
    //Pre-none
    //Post-returns random int 2-12
    public int rollTwo()
    {
        return rollOne()+rollOne();
    }
    
    //pre - none
    //post - an int is returned
    public int rollOne()
    {
        return ((int)(Math.random()*6+1));
    }
    
    //pre - none
    //post an array list of players is returned
    public ArrayList<Player> returnPlayers()
    {
        return playerList;
    }
    
    //pre - none
    //post an array list of players is returned
    public ArrayList<Player> getPlayerList()
    {
        return this.playerList;
    }
    
    //pre - a player is provided
    //post - the cards menu is called
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
    
    //pre - a player and a scanner is provided
    //post - both card menues are displayed
    public void cardsBothMenu(Player curPlayer, Scanner user)
    {
        System.out.println("1 to use an experience card, 2 to use an opportunity card, 0 to roll");
        if(user.nextInt()==1)
            cardsExpPlaying(curPlayer,user);
            
        if(user.nextInt()==2)
            cardsOppPlaying(curPlayer,user);
            
        if(user.nextInt()==0)
            {}//nothing happens
        else
            cardsBothMenu(curPlayer,user);
    }
    
    //pre - a player and a scanner is provided
    //post - cards menue for experience is displayed
     public void cardsExpMenu(Player curPlayer, Scanner user)
    {
        System.out.println("1 to use an experience card, 0 to roll");
        if(user.nextInt()==1)
            cardsExpPlaying(curPlayer,user);
            
        if(user.nextInt()==0)
            {}//nothing happens
        else
            cardsExpMenu(curPlayer,user);
    }
    
    //pre - a player and a scanner is provided
    //post - cards menue for opportunity is displayed
     public void cardsOppMenu(Player curPlayer, Scanner user)
    {
        System.out.println("1 to use an opportunity card, 0 to roll");
        if(user.nextInt()==1)
            cardsOppPlaying(curPlayer,user);
            
        if(user.nextInt()==0)
            {}//nothing happens
        else
            cardsOppMenu(curPlayer,user);
    }
    
    //pre - a player and a scanner is provided
    //post - cards menue for experience is displayed
    public void cardsExpPlaying(Player curPlayer, Scanner user)
    {
        for(int i=0;i<curPlayer.getExpHand().size();i++)
        {
            System.out.println(i+": move "+ curPlayer.getExpHand().get(i).getValue()+"spaces");
        }
        System.out.println("Or -1 to go back/nWhich card do you want to use?");
        int cardNumber=user.nextInt();
        if(cardNumber<=curPlayer.getExpHand().size() && cardNumber>=0)
            playExperienceCard(curPlayer,cardNumber);
        else if(cardNumber==-1)
            {}//nothing happens
    }
    
    //pre - a player and a scanner is provided
    //post - cards menue for opportunity is displayed
    public void cardsOppPlaying(Player curPlayer, Scanner user)
    {
        for(int i=0;i<curPlayer.getOppHand().size();i++)
                    System.out.println(i+":"+curPlayer.getOppHand().get(i));
        System.out.println("Or -1 to go back/nWhich card do you want to use?");
        int cardNumber=user.nextInt();
        if(cardNumber<=curPlayer.getOppHand().size() && cardNumber>=0)
            playOpportunityCard(curPlayer,cardNumber);
        else if(cardNumber==-1)
            {}//nothing happens
    }
    
    //pre - a player and a card number to be used is provided
    //post - an experience card is played
    public void playExperienceCard(Player curPlayer,int cardNumber)
    {
        
        experienceCard temp = curPlayer.getExpHand().get(cardNumber);
        Dealer.collectExperienceCard(temp);
        experienceCardUsed = temp.getValue();
        usedExperienceCard = true;
        curPlayer.getExpHand().remove(cardNumber);    
    }
    
    //pre - a player and a card number to be used is provided
    //post - an opportunity card is played
    public void playOpportunityCard(Player curPlayer,int cardNumber)
    {
        if(curPlayer.getOppHand().get(cardNumber).getOpportunity()==4)
        {
            curPlayer.setXpos(390);
            curPlayer.setYpos(790);
            curPlayer.setPos(4);
        }
        
        if(curPlayer.getOppHand().get(cardNumber).getOpportunity()==7)
        {
            curPlayer.setXpos(140);
            curPlayer.setYpos(790);
            curPlayer.setPos(7);
        }
        
        if(curPlayer.getOppHand().get(cardNumber).getOpportunity()==11)
        {
            curPlayer.setXpos(20);
            curPlayer.setYpos(490);
            curPlayer.setPos(11);
        }
        
        if(curPlayer.getOppHand().get(cardNumber).getOpportunity()==14)
        {
            curPlayer.setXpos(20);
            curPlayer.setYpos(230);
            curPlayer.setPos(14);
        }
        
        if(curPlayer.getOppHand().get(cardNumber).getOpportunity()==19)
        {
            if(curPlayer.getOppHand().get(cardNumber).isFree())
            {
                curPlayer.setXpos(310);
                curPlayer.setYpos(40);
                curPlayer.setPos(19);
            }
            else
            {
                curPlayer.setXpos(760);
                curPlayer.setYpos(320);
                curPlayer.setPos(27);
            }
        }
        
        if(curPlayer.getOppHand().get(cardNumber).getOpportunity()==22)
        {
            if(curPlayer.getOppHand().get(cardNumber).isFree())
            {
                curPlayer.setXpos(570);
                curPlayer.setYpos(40);
                curPlayer.setPos(22);
            }
            else
            {
                curPlayer.setXpos(760);
                curPlayer.setYpos(320);
                curPlayer.setPos(27);
            }
        }
        
        if(curPlayer.getOppHand().get(cardNumber).getOpportunity()==24)
        {
            curPlayer.setXpos(760);
            curPlayer.setYpos(40);
            curPlayer.setPos(24);
        }
        
        if(curPlayer.getOppHand().get(cardNumber).getOpportunity()==27)
        {
            if(curPlayer.getOppHand().get(cardNumber).isFree())
            {
                curPlayer.setXpos(760);
                curPlayer.setYpos(320);
                curPlayer.setPos(27);
            }
            else
            {
                curPlayer.setXpos(760);
                curPlayer.setYpos(320);
                curPlayer.setPos(27);
            }
        }
        
        if(curPlayer.getOppHand().get(cardNumber).getOpportunity()==30)
        {
            curPlayer.setXpos(760);
            curPlayer.setYpos(570);
            curPlayer.setPos(30);
        }
        
        Opportunity temp = curPlayer.getOppHand().get(cardNumber);
        Dealer.collectOpportunityCard(temp);
        opportunityCardUsed = temp;
        usedOpportunityCard = true;
        curPlayer.getOppHand().remove(cardNumber);
    }
}
            
    
