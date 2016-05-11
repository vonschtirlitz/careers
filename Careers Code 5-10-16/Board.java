import java.util.*;
public class Board
{
    private ArrayList<Spot> path;
    private String name;
    public Board(int size, String name)
    {
        path = new ArrayList<Spot>();
        //This is temp array filler, real array will have actual values planted in appropriate spots
        for(int i = 0; i<size; i++)
        {
            Spot temp = new Spot(i,0,0,0,0,0,0);
            path.add(temp);
        }
        this.name = name;
    }
    
    public Spot get(int pos)
    {
        return path.get(pos);
    }
}