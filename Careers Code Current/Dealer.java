import java.util.*;

public class Dealer
{
    private static ArrayList <Opportunity> opportunityHand;
    private static ArrayList <experienceCard> experienceHand;
    
    //default constructor for dealer
    public Dealer()
    {
        opportunityHand = new ArrayList <Opportunity>();
        experienceHand = new ArrayList <experienceCard>();
        fillOpportunityHand();
        fillExperienceHand();
    }
    
    //pre - none
    //post - the array list has been filled with experience cards
    public void fillExperienceHand()
    {
        for(int i = 0; i < 6; i++)
        {
            experienceHand.add(new experienceCard(1));
        }
        for(int i = 0; i < 7; i++)
        {
            experienceHand.add(new experienceCard(2));
        }
        for(int i = 0; i < 5; i++)
        {
            experienceHand.add(new experienceCard(3));
        }
        for(int i = 0; i < 6; i++)
        {
            experienceHand.add(new experienceCard(4));
        }
    }
    
    //pre - none
    //post the opportunits array list has been filled with opportunity cards
    public void fillOpportunityHand()
    {
        opportunityHand.add(new Opportunity(true, 19, false));
        opportunityHand.add(new Opportunity(true, 22, false));
        opportunityHand.add(new Opportunity(true, 14, false));
        opportunityHand.add(new Opportunity(true, 27, false));
        opportunityHand.add(new Opportunity(true, 24, false));
        opportunityHand.add(new Opportunity(true, 24, false));
        opportunityHand.add(new Opportunity(false, 30, false));
        opportunityHand.add(new Opportunity(false, 27, false));
        opportunityHand.add(new Opportunity(false, 27, false));
        opportunityHand.add(new Opportunity(false, 4, false));
        opportunityHand.add(new Opportunity(false, 4, false));
        opportunityHand.add(new Opportunity(false, 22, false));
        opportunityHand.add(new Opportunity(false, 22, false));
        opportunityHand.add(new Opportunity(false, 19, false));
        opportunityHand.add(new Opportunity(false, 19, false));
        opportunityHand.add(new Opportunity(false, 7, false));
        opportunityHand.add(new Opportunity(false, 7, false));
        opportunityHand.add(new Opportunity(false, 7, false));
        opportunityHand.add(new Opportunity(false, 11, false));
        opportunityHand.add(new Opportunity(false, 11, false));
        opportunityHand.add(new Opportunity(false, 11, false));
        opportunityHand.add(new Opportunity(true, 14, true));
    }
    
    //pre - none
    //post - the array list of opportunity cards is returned
    public ArrayList <Opportunity> getOpportunityDeck()
    {
        return opportunityHand;
    }
    
    //pre - none
    //post - an opportunity card is removed from the deck and handed off
    public static Opportunity dealTopOpportunity()
    {
        return opportunityHand.remove(0);
    }
    
    //pre - none
    //post - an experience card is removed from the deck and handed off
    public static experienceCard dealTopExperience()
    {       
        return experienceHand.remove(0);
    }
    
    //pre - an experience card is provided
    //post - an experience card is handed to the dealer to place at the bottom of the experience card arrayList
    public static void collectExperienceCard(experienceCard card)
    {
        experienceHand.add(card);
    }
    
    //pre - an opportunity card is provided
    //post - an opporunity card is hjanded to the dealer to place at the bottom of the experience card arrayList
    public static void collectOpportunityCard(Opportunity card)
    {
        opportunityHand.add(card);
    }
}
