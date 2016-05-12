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
        for(int i = 0; i<size; i++)
        {
            Spot temp = new Spot(i,0,0,0,0,0,0);
            lane.add(temp);
        }
        this.name = name;
    }
    
    public Spot get(int pos)
    {
        return lane.get(pos);
    }
}