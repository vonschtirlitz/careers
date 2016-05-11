public class Spot
{
    private int position;
    private int cashModifier;
    private int fameModifier;
    private int happinessModifier;
    private int salaryModifier;
    public Spot(int newPosition, int cashModifier, int fameModifier, int happinessModifier, int salaryModifier)
    {
        this.position = newPosition;
        this.cashModifier = cashModifier;
        this.fameModifier = fameModifier;
        this.happinessModifier = happinessModifier;
        this.salaryModifier = salaryModifier;
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
}