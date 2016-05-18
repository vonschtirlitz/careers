import java.util.*;

public class Dealer
{
    private static ArrayList <Opportunity> opportunityHand;
    private static ArrayList <experienceCard> experienceHand;
    public Dealer()
    {
        opportunityHand = new ArrayList <Opportunity>();
        experienceHand = new ArrayList <experienceCard>();
        fillOpportunityHand();
        fillExperienceHand();
    }
    
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
        opportunityHand.add(new Opportunity(false, -1, false));
        opportunityHand.add(new Opportunity(false, -1, false));
        opportunityHand.add(new Opportunity(true, 14, true));
    }
    
    public ArrayList <Opportunity> getOpportunityDeck()
    {
        return opportunityHand;
    }
    
    public static Opportunity dealTopOpportunity()
    {
        return opportunityHand.remove(0);
    }
    
    public static experienceCard dealTopExperience()
    {       
        return experienceHand.remove(0);
    }
    
    public static void collectExperienceCard(experienceCard card)
    {
        experienceHand.add(card);
    }
    
    public static void collectOpportunityCard(Opportunity card)
    {
        opportunityHand.add(card);
    }
}
