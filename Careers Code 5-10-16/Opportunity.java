public class Opportunity
{
    boolean requirementsNotNeeded;
    int opportunity;
    boolean isCruise;
    
    public Opportunity(boolean isFree, int whereTo, boolean isCruiseCard)
    {
        requirementsNotNeeded = isFree;
        opportunity = whereTo;
        isCruise = isCruiseCard;
    }
    public void useCard()
    {
        //return opportunity;
    }
}
