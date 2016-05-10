public class Opportunity
{
    boolean requirementsNotNeeded;
    String opportunity;
    boolean isCruise;
    public Opportunity(boolean isFree, String whereTo, boolean isCruiseCard)
    {
        requirementsNotNeeded = isFree;
        opportunity = whereTo;
        isCruise = isCruiseCard;
    }
}