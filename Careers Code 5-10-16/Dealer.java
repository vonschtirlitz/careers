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
        opportunityHand.add(new Opportunity(true, "Politics", false));
        opportunityHand.add(new Opportunity(true, "Hollywood", false));
        opportunityHand.add(new Opportunity(true, "Sea", false));
        opportunityHand.add(new Opportunity(true, "Uranium", false));
        opportunityHand.add(new Opportunity(true, "Vacation", false));
        opportunityHand.add(new Opportunity(true, "Vacation", false));
        opportunityHand.add(new Opportunity(false, "Moon", false));
        opportunityHand.add(new Opportunity(false, "Uranium", false));
        opportunityHand.add(new Opportunity(false, "Uranium", false));
        opportunityHand.add(new Opportunity(false, "Farming", false));
        opportunityHand.add(new Opportunity(false, "Farming", false));
        opportunityHand.add(new Opportunity(false, "Hollywood", false));
        opportunityHand.add(new Opportunity(false, "Hollywood", false));
        opportunityHand.add(new Opportunity(false, "Politics", false));
        opportunityHand.add(new Opportunity(false, "Politics", false));
        opportunityHand.add(new Opportunity(false, "College", false));
        opportunityHand.add(new Opportunity(false, "College", false));
        opportunityHand.add(new Opportunity(false, "College", false));
        opportunityHand.add(new Opportunity(false, "Business", false));
        opportunityHand.add(new Opportunity(false, "Business", false));
        opportunityHand.add(new Opportunity(false, "Business", false));
        opportunityHand.add(new Opportunity(false, "Your Choice", false));
        opportunityHand.add(new Opportunity(false, "Your Choice", false));
        opportunityHand.add(new Opportunity(true, "Cruise", true));
    }
    
    public ArrayList <Opportunity> getOpportunityDeck()
    {
        return opportunityHand;
    }
    
    public static Opportunity dealTopOpportunity()
    {
        Opportunity temp = opportunityHand.get(1);
        opportunityHand.remove(1);
        return temp;
    }
    
    public static experienceCard dealTopExperience()
    {
        experienceCard temp = experienceHand.get(1);
        experienceHand.remove(1);
        return temp;
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