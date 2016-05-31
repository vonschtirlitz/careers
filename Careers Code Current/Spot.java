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
    private boolean quarterCash;
    private boolean payHalfSalary;
    private boolean tenPercent;
    private boolean entrySpot;
    private int cashRequirement;
    
    //default constructor, normal adds x amount of stuff to player
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
    
    //pre - integers for the new position, xPosition, y position and a boolean for the start is provided
    //post - a spot is constructed
    //start spot constructor
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
    
    //psyhalf salary spot is constructed
    public Spot(int position, int xPos, int yPos, boolean payHalfSalary,int random)
    {
        this.position = position;
        this.xPos = xPos;
        this.yPos = yPos;
        this.payHalfSalary = payHalfSalary;
    }
    
    //halves the amount of stuff spot is construced, with what it halves and where the spot is located
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
    
    //constructor
    public Spot(int position, int xPos, int yPos, boolean quarterCash, boolean random)
    {
         this.position = position;
         this.xPos = xPos;
         this.yPos = yPos;
         this.quarterCash=quarterCash;
    }
    
    //skips turn, with optional requirements spot is constructed
    public Spot(int position, int xPos, int yPos, boolean skipsTurn, int skipTurnRequirements, int rollLessThan)
    {
        this.position = position;
        this.skipsTurn = skipsTurn;
        this.skipTurnRequirements = skipTurnRequirements;
        this.rollLessThan = rollLessThan;
        this.xPos = xPos;
        this.yPos = yPos;
    }
    
    //special sell spots, WIP, but for main path is constructed
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
    
    //Switch Spot- moves player to another spot or board is construced
    public Spot(int position, int xPos, int yPos, int moveToBoard, int moveToSpot)
    {
        this.position = position;
        this.moveToBoard = moveToBoard;
        this.moveToSpot = moveToSpot;
        this.xPos = xPos;
        this.yPos = yPos;
    }
    
    //constructor
    public Spot(int position, int xPos, int yPos, boolean tenPercent,String random)
    {
        this.position = position;
         this.xPos = xPos;
         this.yPos = yPos;
         this.tenPercent = tenPercent;
    }
    
    //constructor
    public Spot(int position, int xPos, int yPos, boolean entrySpot, int moveToBoard, int moveToSpot, int cashRequirement)
    {
        this.position = position;
         this.xPos = xPos;
         this.yPos = yPos;
         this.entrySpot = entrySpot;
         this.moveToBoard = moveToBoard;
         this.moveToSpot = moveToSpot;
         this.cashRequirement = cashRequirement;
    }
    
    //pre - none
    //post - the integer for a spots position is provided
    public int getPosition()
    {
        return position;
    }
    
    //pre - none
    //post - an int for the cash to be modified is returned
    public int getCashModifier()
    {
        return cashModifier;
    }
    
    //pre - an int to set a cash modifier is proivided
    //post - none
    public void setCashModifier(int cashModifier)
    {
        this.cashModifier = cashModifier;
    }
    
    //pre - none
    //post - an int for the fame modifier is provided
    public int getFameModifier()
    {
        return fameModifier;
    }
    
    //pre - a fame modifier to be set is provided
    //post - none
    public void setFameModifier(int fameModifier)
    {
        this.fameModifier = fameModifier;
    }
    
    //pre - none
    //post - an int is returned
    public int getHappinessModifier()
    {
        return happinessModifier;
    }
    
    //pre - an int for the happiness modifer is provided
    //post - none
    public void setHappinessModifier(int happinessModifier)
    {
        this.happinessModifier = happinessModifier;
    }
    
    //pre - none
    //post - an int is returned
    public int getSalaryModifier()
    {
        return salaryModifier;
    }
    
    //pre - an int to set a salary modifer is provided
    //post - none
    public void setSalaryModifier(int salaryModifier)
    {
        this.salaryModifier = salaryModifier;
    }
    
    //pre - none
    //post - an int is returned
    public int oppCardGiven()
    {
        return oppGiven;
    }
    
    //pre - none
    //post - an int is returned
    public int expCardGiven()
    {
        return expGiven;
    }
    
    //pre - none
    //post - a boolean is returned
    public boolean getSkipsTurn()
    {
        return skipsTurn;
    }
    
    //pre - none
    //post - an int is returned
    public int getSkipTurnRequirements()
    {
        return skipTurnRequirements;
    }
    
    //pre - none
    //post - an int is returned
    public int getRollLessThan()
    {
        return rollLessThan;
    }
    
    //pre - none
    //post - a boolean is returned
    public boolean getDiceMod()
    {
        return diceMod;
    }
    
    //pre - none
    //post - an int is returned
    public int getMoveBoard()
    {
        return moveToBoard;
    }
    
    //pre - none
    //post - an int is returned
    public int getMoveSpot()
    {
        return moveToSpot;
    }
    
    //pre - none
    //post - an int is returned
    public int getXPos()
    {
        return xPos;
    }
    
    //pre - none
    //post - an int is returned
    public int getYPos()
    {
        return yPos;
    }
    
    //pre - none
    //post - a boolean is returned
    public boolean getHalveCash()
    {
        return halveCash;
    }
    
    //pre - none
    //post - a boolean is returned
    public boolean getHalveFame()
    {
        return halveFame;
    }
    
    //pre - none
    //post - a boolean is returned
    public boolean getHalveHappiness()
    {
        return halveHappiness;
    }
    
    //pre - none
    //post - aboolean is returned
    public boolean getHalveSalary()
    {
        return halveSalary;
    }
    
    //pre - none
    //post - a boolean is returned
    public boolean getStart()
    {
        return isStart;
    }
    
    //pre - none
    //post - a boolean is returned
    public boolean getQuarterCash()
    {
        return quarterCash;
    }
    
    //pre - none
    //post - a boolean is returned
    public boolean getPayHalfSalary()
    {
        return payHalfSalary;
    }
    
    //pre - none
    //post - a boolean is returned
    public boolean getTenPercent()
    {
        return tenPercent;
    }
    
    //pre - none
    //post - a boolean is returned
    public boolean getEntrySpot()
    {
        return entrySpot;
    }
    
    //pre - none
    //post - an int is returned
    public int getCashRequirement()
    {
        return cashRequirement;
    }
}
