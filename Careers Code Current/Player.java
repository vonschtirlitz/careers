//Player
//Methods for creating and handling game data for each player
import java.util.*;

public class Player
{
    private int targetCash;
    private int cash;
    private int targetFame;
    private int fame;
    private int targetHappiness;
    private int happiness;
    private int playerNumber;
    private String education;
    private int salary;
    private ArrayList <Opportunity> opportunityHand;
    private ArrayList <experienceCard> experienceHand;
    private ArrayList <String> workExperience;
    private boolean hasWon;
    private int position;
    private int subPath;
    private String name;
    private int specialPosition;
    private boolean skipTurn;
    private int xPosition = 0;
    private int yPosition = 0;
    private boolean[] experience;
    private boolean[] degrees;

    //Constructor
    public Player(int cashGoal, int fameGoal, int happinessGoal,int startingSalary, int playerNumber, String name)
    {
        targetCash = cashGoal;
        targetFame = fameGoal;
        targetHappiness = happinessGoal;
        cash = 0;
        fame = 0;
        happiness = 0;
        this.playerNumber = playerNumber;
        education = "NONE";
        salary = startingSalary;
        opportunityHand = new ArrayList <Opportunity>();
        experienceHand = new ArrayList <experienceCard>();
        workExperience = new ArrayList <String>();
        hasWon = false;
        subPath=0;
        position = 0;
        this.name = name;
    }
    
    //pre - an integer describingt the cardPosition in the arrayList is provided
    //post - an opportunity card is removed from the arrayList and used
    public void useOpportunityCard(int cardPosition)
    {
        Opportunity temp = opportunityHand.get(cardPosition);
        Dealer.collectOpportunityCard(temp);
        opportunityHand.remove(cardPosition);
    }
    
    //pre - an integer describingt the cardPosition in the arrayList is provided
    //post - an experience card is removed from the arrayList and used, then handed back to the dealer
    public void returnExperienceToDealer(int cardPosition)
    {
        experienceCard temp = experienceHand.get(cardPosition);
        Dealer.collectExperienceCard(temp);
        experienceHand.remove(cardPosition);
    }
    
    //pre - an opporunity card is provided
    //post - an opportunity card is removed from the arrayList and used, then handed back to the dealer
    public void addOpportunityCard(Opportunity card)
    {
        opportunityHand.add(card);
    }
    
    //pre - an experience card is provided
    //post - an experience card is added to the arrayList of the players hand
    public void addExperienceCard(experienceCard card)
    {
        experienceHand.add(card);
    }
    
    //pre - none
    //post - the opportunity card Hand is returned
    public ArrayList <Opportunity> getOppHand()
    {
        return opportunityHand;
    }
    
    //pre - none
    //post the experiencecardHand is returned
    public ArrayList <experienceCard> getExpHand()
    {
        return experienceHand;
    }
    //Salary Methods
    
    //Pre- none
    //Post- returns salary value
    public int getSalary()
    {
        return salary;
    }
    
    //Do we need increase decrease salary methods? Why not use neg ints for increase salary to decrease?
    
    //Pre- int increase >= 0
    //Post- adds int increase to salary
    public int increaseSalary(int increase)
    {
        salary += increase;
        return salary;
    }
    
    //Pre- int decrease >= 0
    //Post- int decrease subtracted from salary
    public int decreaseSalary(int decrease)
    {
        salary -= decrease;
        return salary;
    }
    
    //Pre- int amount >=0
    //Post- sets salary to int amount
    public int setSalary(int amount)
    {
        salary = amount;
        return salary;
    }
    
    //Cash Methods
    
    //pre - none
    //post - returns current cash
    public int getCash()
    {
        return cash;
    }
    
    //pre - cash to be added
    //post - returns current cash
    public int addCash(int added)
    {
        cash += added;
        return cash;
    }
    
    //pre - cash to be removed
    //post - returns current cash
    public int removeCash(int removed)
    {
        cash -= removed;
        return cash;
    }
    
    //pre- int amount >= 0
    //post- sets cash to amount
    public void setCash(int amount)
    {
        cash = amount;
    }
    
    //Fame Methods
    
    //pre - none
    //post - returns current fame
    public int getFame()
    {
        return fame;
    }
    
    //pre - fame to be added
    //post - returns current fame
    public int addFame(int added)
    {
        fame += added;
        return fame;
    }
    
    //pre - fame to be removed
    //post - returns current fame
    public int removeFame(int removed)
    {
        fame -= removed;
        return fame;
    }
    
    //pre- amount >=0
    //post- sets fame to value
    public void setFame(int amount)
    {
        fame = amount;
    }
    
    //Happiness Methods
    
    //pre - none
    //post - returns current happiness
    public int getHappiness()
    {
        return happiness;
    }
    
    //pre - happiness to be added
    //post - returns current happiness
    public int addHappiness(int added)
    {
        happiness += added;
        return happiness;
    }
    
    //pre - happiness to be removed
    //post - returns current happiness
    public int removeHappiness(int removed)
    {
        happiness -= removed;
        return happiness;
    }
    
    //pre- amount >=0
    //post- sets happiness to 0
    public void setHappiness(int amount)
    {
        happiness = amount;
    }
    
    //Board Methods
    
    //pre - a position integer is provided
    //post - sets the player position to the given int
    public void setPos(int pos)
    {
        this.position = pos;
    }

    //pre - none
    //post - an integer for the player position in an array is returned
    public int getPos()
    {
        return position;
    }
    
    //pre - an integer for the path number to be set to is provided
    //post - the player path is set to the provided integer
    public void setPath(int num)
    {
        subPath = num;
    }
    
    //pre - none
    //post - an integer for the current player path is returned
    public int getPath()
    {
        return subPath;
    }
    
    //pre - an int for both the path and the position in that path are provided
    //post - the subpath number and the position in that path is provided
    public void move(int path, int setPos)
    {
        this.subPath = path;
        this.position = setPos;
    }
    
    /*
    public void setSpecialPos(int board, int position, int specialPosition)
    {
        this.subBoard = board;
        position += addPos;
    }
    */

    //Misc Methods
    
    public String getName()
    {
        return name;
    }
    
    //pre - none
    //post - a boolean for if the player may play is returned
    public boolean getSkipTurn()
    {
        return skipTurn;
    }
    
    //pre - a boolean is provided
    //post - the variable for skip turn is updated
    public void setSkipTurn(boolean result)
    {
        skipTurn = result;
    }
    
    //pre - none
    //post - returns if a player has meet the victory condition
    public boolean isVictoryMeet()
    {
        boolean answer = true;
        if(cash < targetCash)
            answer = false;
        if(fame < targetFame)
            answer = false;
        if(happiness < targetHappiness)
            answer = false;
        if(answer)
            hasWon = true;
        return answer;
    }
    
    //pre - none
    //post - the player and player number is returned
    public String getNumber()
    {
        return "Player "+playerNumber;
    }
    
    //pre - an int for the x position is provided
    //post - the xPosition is updated
    public void setXpos(int input)
    {
        this.xPosition = input;
    }
    
    //pre - an int for the y position is provided
    //post - the yPosition is updated
    public void setYpos(int input)
    {
        this.yPosition = input;
    }

    //pre - none
    //post the x position is returned
    public int getXpos()
    {
        return this.xPosition;
    }
    
    //pre - none
    //post the y position is returned
    public int getYpos()
    {
        return this.yPosition;
    }
    
    //pre - none
    //post - an int for the opportunity hand size is returned
    public int getOpHandSize()
    {
        return opportunityHand.size();
    }
    
    //pre - none
    public String toString()
    {
        String result = "";
        result+=("Player "+this.playerNumber+"\n");
        result+=("Cash: "+this.cash+"\n");
        result+=("Fame: "+this.fame+"\n");
        result+=("Happiness: "+this.happiness+"\n");
        result+=("Salary: "+this.salary+"\n");
        return result;
    }
}
    
