public class Opportunity
{
    boolean requirementsNotNeeded;
    int opportunity;
    boolean isCruise;
    
    // general constructor for opportunity card
    public Opportunity(boolean isFree, int whereTo, boolean isCruiseCard)
    {
        requirementsNotNeeded = isFree;
        opportunity = whereTo;
        isCruise = isCruiseCard;
    }
    
    //pre - none
    //post - returns a boolean on if a player moves into a sub path for free
    public boolean isFree()
    {
    	return requirementsNotNeeded;
    }
    
    //pre - none
    //post - returns an int with where the player is moved to
    public int getOpportunity()
    {
    	return opportunity;
    }
    
    //replaces the toString method so that a called opportunity card displays choices to the user on the terminal.
    public String toString()
    {
    	if(isCruise)
    		return "Special Opportunity to go to Sea on the 4-masted schooner \"American Beauty\" ... all expenses paid";
    	if(opportunity==4)
    		return "Opportunity to start Farming ... meet normal requirements";
    	if(opportunity==7)
    		return "Opportunity to enter College ... meet normal requirements";
    	if(opportunity==11)
    		return "Opportunity to enter Big Business ... meet normal requirements";
    	if(opportunity==14)
    		return "Opportunity to go to Sea ... meet normal requirements";
    	if(opportunity==19)
    		if(requirementsNotNeeded)
    			return "Special Oportunity to enter Politics ... because of your great hand-shaking ability, all expenses paid";
    		else
    			return "Opportunity to enter Politics ... meet normal requirements";
    	if(opportunity==22)
    		if(requirementsNotNeeded)
    			return "Special Opportunity to enter Holywood ... because of your great beauty, all expenses paid";
    		else
    			return "Opportunity to enter hollywood ... meet normal requirements";
    	if(opportunity==24)
    		return "Opportunity to take Florida Vacation";
    	if(opportunity==27)
    		if(requirementsNotNeeded)
    			return "Special Oportunity to join Uranium Expedition ... because of your great skill as a mountain-climber, all expenses paid";
    		else
    			return "Opportunity to join Uranium Expedition ... meet normal requirements";
    	if(opportunity==30)
    		return "Opportunity to go to the Moon ... meet normal requirements";
        return "ERROR 404";
    }
}
