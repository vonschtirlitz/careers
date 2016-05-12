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
    //ima a change wooo
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
		int position = 0;
		this.name = name;
    }
    
    public void useOpportunityCard(int cardPosition)
    {
        Opportunity temp = opportunityHand.get(cardPosition);
        handOffOpportunity(temp);
        opportunityHand.remove(cardPosition);
    }
    
    public void returnExperienceToDealer(int cardPosition)
    {
        experienceCard temp = experienceHand.get(cardPosition);
        handOffExperience(temp);
        experienceHand.remove(cardPosition);
    }
    
    public void handOffExperience(experienceCard card)
    {
        Dealer.collectExperienceCard(card);
    }
    
    public void handOffOpportunity(Opportunity card)
    {
        Dealer.collectOpportunityCard(card);
    }
    
    public void addOpportunityCard(Opportunity card)
    {
        opportunityHand.add(card);
    }
    
    public void addExperienceCard(experienceCard card)
    {
        experienceHand.add(card);
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
	
	public void setPos(int pos)
	{
	    this.position = pos;
	}

	public int getPos()
	{
	    return position;
	}
	
	public void setPath(int num)
	{
	    subPath = num;
	}
	
	public int getPath()
	{
	    return subPath;
	}
	
	public void move(int path, int addPos)
	{
	    this.subPath = path;
	    position += addPos;
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
}
    
