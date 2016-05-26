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
    private int moveToBoard = -1;
    private int moveToSpot = -1;
    private int xPos;
    private int yPos;
    private boolean halveCash;
    private boolean halveFame;
    private boolean halveHappiness;
    private boolean halveSalary;
    private boolean isStart;
    
    //default, normal adds x amount of stuff to player
    public Spot(int newPosition, int xPos, int yPos, int cashModifier, int fameModifier, int happinessModifier, int salaryModifier,
                int oppGiven, int expGiven)
    {
        this.position = newPosition;
        this.cashModifier = cashModifier;
        this.fameModifier = fameModifier;
        this.happinessModifier = happinessModifier;
        this.salaryModifier = salaryModifier;
        this.oppGiven = oppGiven;
        this.expGiven = expGiven;
        this.xPos = xPos;
        this.yPos = yPos;
    }
    
    //spot 0,0 start
    public Spot(int newPosition, int xPos, int yPos, boolean start)
    {
        this.position = newPosition;
        this.isStart=start;
        this.xPos = xPos;
        this.yPos = yPos;
    }
    
    //dicemod, number times dice roll
    public Spot(int position, int xPos, int yPos, int cashModifier, int fameModifier, int happinessModifier,int salaryModifier)
    {
        this.position = position;
        this.cashModifier = cashModifier;
        this.fameModifier = fameModifier;
        this.happinessModifier = happinessModifier;
        this.salaryModifier = salaryModifier;
        this.diceMod = true;
        this.xPos = xPos;
        this.yPos = yPos;
    }
    
    //halves the amount of stuff
    public Spot(int position, int xPos, int yPos, boolean halveCash, boolean halveFame, boolean halveHappiness, boolean halveSalary)
    {
        this.position = position;
        this.halveCash = halveCash;
        this.halveFame = halveFame;
        this.halveHappiness = halveHappiness;
        this.halveSalary = halveSalary;
        this.xPos = xPos;
        this.yPos = yPos;
    }
    
    //skips turn, with optional requirements
    public Spot(int position, int xPos, int yPos, boolean skipsTurn, int skipTurnRequirements, int rollLessThan)
    {
        this.position = position;
        this.skipsTurn = skipsTurn;
        this.skipTurnRequirements = skipTurnRequirements;
        this.rollLessThan = rollLessThan;
        this.xPos = xPos;
        this.yPos = yPos;
    }
    
    //special sell spots, WIP, but for main path
    public Spot(int position, int xPos, int yPos, int minReq, int minReturn, int medReq, int medReturn, int maxReq, int maxReturn, boolean spendTimesDice)
    {
        this.position = position;
        this.minReq = minReq;
        this.minReturn = minReturn;
        this.medReq = medReq;
        this.medReturn = medReturn;
        this.maxReq = maxReq;
        this.maxReturn = maxReturn;
        this.spendTimesDice = spendTimesDice;
        this.xPos = xPos;
        this.yPos = yPos;
    }
    
    //Switch Spot- moves player to another spot or board
    public Spot(int position, int xPos, int yPos, int moveToBoard, int moveToSpot)
    {
        this.position = position;
        this.moveToBoard = moveToBoard;
        this.moveToSpot = moveToSpot;
        this.xPos = xPos;
        this.yPos = yPos;
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
    
    public int getXPos()
    {
        return xPos;
    }
    
    public int getYPos()
    {
        return yPos;
    }
    
    public boolean getHalveCash()
    {
        return halveCash;
    }
    
    public boolean getHalveFame()
    {
        return halveFame;
    }
    
    public boolean getHalveHappiness()
    {
        return halveHappiness;
    }
    
    public boolean getHalveSalary()
    {
        return halveSalary;
    }
    
    public boolean getStart()
    {
        return isStart;
    }
}
