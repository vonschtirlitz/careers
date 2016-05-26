public class Spot
{
    private int position;
    private int cashModifier;
    private int fameModifier;
    private int happinessModifier;
    private int salaryModifier;
    private int oppGiven;
    private int expGiven;
    private boolean skipsTurn;
    private int skipTurnRequirements;//amount of cash needed to skip the spot
    private int rollLessThan;
    private int minReq;
    private int minReturn;
    private int medReq;
    private int medReturn;
    private int maxReq;
    private int maxReturn;
    private boolean spendTimesDice;
    private boolean diceMod;
    private int moveToBoard;
    private int moveToSpot;
    
    public Spot(int newPosition, int cashModifier, int fameModifier, int happinessModifier, int salaryModifier,
                int oppGiven, int expGiven)
    {
        this.position = newPosition;
        this.cashModifier = cashModifier;
        this.fameModifier = fameModifier;
        this.happinessModifier = happinessModifier;
        this.salaryModifier = salaryModifier;
        this.oppGiven = oppGiven;
        this.expGiven = expGiven;
        
    }
    
    public Spot(int position, int cashModifier, int fameModifier, int happinessModifier)
    {
        this.position = position;
        this.cashModifier = cashModifier;
        this.fameModifier = fameModifier;
        this.happinessModifier = happinessModifier;
        this.diceMod = true;
    }
    
    public Spot(int position, boolean skipsTurn, int skipTurnRequirements, int rollLessThan)
    {
        this.position = position;
        this.skipsTurn = skipsTurn;
        this.skipTurnRequirements = skipTurnRequirements;
        this.rollLessThan = rollLessThan;
    }
    
    //
    public Spot(int position, int minReq, int minReturn, int medReq, int medReturn, int maxReq, int maxReturn, boolean spendTimesDice)
    {
        this.position = position;
        this.minReq = minReq;
        this.minReturn = minReturn;
        this.medReq = medReq;
        this.medReturn = medReturn;
        this.maxReq = maxReq;
        this.maxReturn = maxReturn;
        this.spendTimesDice = spendTimesDice;
    }
    
    //Switch Spot- moves player to another spot or board
    public Spot(int position, int moveToBoard, int moveToSpot)
    {
        this.position = position;
        this.moveToBoard = moveToBoard;
        this.moveToSpot = moveToSpot;
    }
    
    public int getCashModifier()
    {
        return cashModifier;
    }
    
    public void setCashModifier(int cashModifier)
    {
        this.cashModifier = cashModifier;
    }
    
    public int getFameModifier()
    {
        return fameModifier;
    }
    
    public void setFameModifier(int fameModifier)
    {
        this.fameModifier = fameModifier;
    }
    
    public int getHappinessModifier()
    {
        return happinessModifier;
    }
    
    public void setHappinessModifier(int happinessModifier)
    {
        this.happinessModifier = happinessModifier;
    }
    
    public int getSalaryModifier()
    {
        return salaryModifier;
    }
    
    public void setSalaryModifier(int salaryModifier)
    {
        this.salaryModifier = salaryModifier;
    }
    
    public int oppCardGiven()
    {
        return oppGiven;
    }
    
    public int expCardGiven()
    {
        return expGiven;
    }
    
    public boolean getSkipsTurn()
    {
        return skipsTurn;
    }
    
    public int getSkipTurnRequirements()
    {
        return skipTurnRequirements;
    }
    
    public int getRollLessThan()
    {
        return rollLessThan;
    }
    
    public boolean getDiceMod()
    {
        return diceMod;
    }
    
    public int getMoveBoard()
    {
        return moveToBoard;
    }
    
    public int getMoveSpot()
    {
        return moveToSpot;
    }
}
