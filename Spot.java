public class Spot
{
    private int position;
    private int cashModifier;
    private int fameModifier;
    private int happinessModifier;
    private int salaryModifier;
    private int oppGiven;
    private int expGiven;
    private boolean skipTurn;
    private boolean halfSalary;
    private boolean toHospital;
    private boolean toParkBench;
    private boolean payTaxesHere;
    private boolean automobileShow;
    private boolean isHospital;
    private boolean payFoodBills;
    private boolean isArtGallery;
    private boolean isParkBench;
    private boolean payRentHere;
    private boolean shoppingSpree;
    private boolean floridaVacation;
    private boolean isStockMarket;
    private boolean isYachtHarbor;
    private boolean isStatue;
    private boolean isPayday;
    private boolean farmingExperience;
    private boolean collegeExperience;
    private boolean buisnessExperience;
    private boolean seaExperience;
    private boolean politicsExperience;
    private boolean hollywoodExperience;
    private boolean uraniumExperience;
    private boolean moonExperience;
    public Spot(int newPosition, int cashModifier, int fameModifier, int happinessModifier, int salaryModifier,
                int oppGiven, int expGiven, boolean skip, boolean halfS, boolean goToHospital, boolean goToParkBench,
                boolean payTaxes, boolean autoShow, boolean hospital, boolean payFoodBillsHere, boolean artGallery, 
                boolean parkBench,boolean payRent, boolean payForShoppingSpree, boolean isFloridaVacation,
                boolean stockMarket, boolean yachtHarbor, boolean parkStatue, boolean payday, boolean farming, boolean college,
                boolean buisness, boolean sea, boolean politics, boolean hollywood, boolean uranium, boolean moon)
    {
        this.position = newPosition;
        this.cashModifier = cashModifier;
        this.fameModifier = fameModifier;
        this.happinessModifier = happinessModifier;
        this.salaryModifier = salaryModifier;
        this.oppGiven = oppGiven;
        this.expGiven = expGiven;
        this.skipTurn = skip;
        this.halfSalary = halfS;
        this.toHospital = goToHospital;
        this.toParkBench = goToParkBench;
        this.payTaxesHere = payTaxes;
        this.automobileShow = autoShow;
        this.isHospital = hospital;
        this.payFoodBills = payFoodBillsHere;
        this.isArtGallery = artGallery;
        this.isParkBench = parkBench;
        this.payRentHere = payRent;
        this.shoppingSpree = payForShoppingSpree;
        this.floridaVacation = isFloridaVacation;
        this.isStockMarket = stockMarket;
        this.isYachtHarbor = yachtHarbor;
        this.isStatue = parkStatue;
        this.isPayday = payday;
        this.farmingExperience = farming;
        this.collegeExperience = college;
        this.seaExperience = sea;
        this.politicsExperience = politics;
        this.hollywoodExperience = hollywood;
        this.uraniumExperience = uranium;
        this.moonExperience = moon;
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
}
