import java.util.*;
public class Path
{
    private ArrayList<Spot> lane;
    private String name;
    public Path(int size, String name)
    {
        lane = new ArrayList<Spot>();
        //This is temp array filler, real array will have actual values planted in appropriate spots
        //changes
        for(int i = 0; i < size; i++)
        {//Spot temp = new Spot(i,0,0,0,0,0,0);
          //  lane.add(temp);
        }
        this.name = name;
    }
    
    public Spot get(int pos)
    {
        return lane.get(pos);
    }

    public void setToFarming()
    {
        for(int i = 0; i < lane.size(); i++)
        {
            lane.remove(0);
        }
        
        //This needs to be an enterance spot: lane.add(new Spot(0,0,0,0,0,0));
       // lane.add(new Spot(1,0,2,0,0,0,0));
       // lane.add(new Spot(2,0,0,0,0,0,1));
       // lane.add(new Spot(3,0,0,1,0,0,0));
        // This depends on a throw of the dice lane.add(new Spot(4,
       // lane.add(new Spot(5,0,2,4,0,0,0));
       // lane.add(new Spot(6,0,0,6,0,0,0));
      //  lane.add(new Spot(7,5000,0,0,0,0,0));
     //   lane.add(new Spot(8,0,0,2,0,0,0));
        //This needs a spot that can access a player to half their happiness lane.add(new Spot(9
    }
    
    public void setToCollege()
    {
        for(int i = 0; i < lane.size(); i++)
        {
            lane.remove(0);
        }
        
        //This needs to be an enterance spot: lane.add(new Spot(0,0,0,0,0,0));
      //  lane.add(new Spot(1,0,0,4,0,0,0));
        //This needs to be able to make the player loose their next turn lane.add(new Spot(2
     //   lane.add(new Spot(3,0,0,2,0,0,0));
      //  lane.add(new Spot(4,0,0,2,0,0,0));
     //   lane.add(new Spot(5,0,0,0,0,2,0));
      //  lane.add(new Spot(6,0,6,0,0,0,0));
      //  lane.add(new Spot(7,0,0,0,0,2,0));
    }
    
    public void setToBuisness()
    {
        for(int i = 0; i < lane.size(); i++)
        {
            lane.remove(0);
        }
        
        //This needs to be an enterance spot    lane.add(new Spot(0;
     //   lane.add(new Spot(1,0,0,0,0,0,1));
     //   lane.add(new Spot(2,0,0,0,0,1,0));
     //   lane.add(new Spot(3,0,0,0,1000,0,0));
        //This needs to be able to make the player loose their next turn lane.add(new Spot(4,
     //   lane.add(new Spot(5,2000,0,0,0,0,0));
     //   lane.add(new Spot(6,0,0,0,2000,0,0));
     //   lane.add(new Spot(7,0,0,0,0,0,1));
     //   lane.add(new Spot(8,0,0,4,0,0,0));
        //This needs to be able to send the player to the park bench    lane.add(new Spot(9,
        //This needs to be able to half the players salary  lane.add(new Spot(10,0,0,0
      //  lane.add(new Spot(11,0,0,0,3000,0,0));
    }
    
    public void setToSea()
    {
        for(int i = 0; i < lane.size(); i++)
        {
            lane.remove(0);
        }  

        //This needs to be an enterance spot    lane.add(new Spot(0));
        //This needs to be able to send the player to the hospital  
      //  lane.add(new Spot(2,0,0,2,0,0,0));
      //  lane.add(new Spot(3,0,0,0,0,2,0));
      //  lane.add(new Spot(4,0,0,0,0,0,1));
        // This depends on a throw of the dice  lane.add(new Spot(5, 
      //  lane.add(new Spot(6,0,0,4,0,0,0));
      //  lane.add(new Spot(7,0,0,6,0,0,0));
        //This needs to be able to make the player loose their next turn        lane.add(new Spot(8,
     //   lane.add(new Spot(9,0,0,8,0,0,0));
    }
    
    public void setToPolitics()
    {   
        for(int i = 0; i < lane.size(); i++)
        {
            lane.remove(0);
        }
        
        //This needs to be an enterance spot    lane.add(new Spot(0));
        //This needs to be able to send the player to the park bench    lane.add(new Spot(1,
      //  lane.add(new Spot(2,0,0,0,0,2,0));
      //  lane.add(new Spot(3,0,4,0,0,0,0));
      //  lane.add(new Spot(4,0,0,2,0,0,0));
      //  lane.add(new Spot(5,0,0,0,0,0,2));
      // lane.add(new Spot(6,0,6,0,0,0,0));
       // lane.add(new Spot(7,0,2,4,0,0,0));
      //  lane.add(new Spot(8,0,8,0,0,0,0));
      //  lane.add(new Spot(9,5000,4,0,0,0,0));
        //This needs to be able to half the players fame    lane.add(new Spot(10
      //  lane.add(new Spot(11,0,12,0,0,0,0));
    }
}