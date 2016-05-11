import java.util.*;
public class Board
{
    private ArrayList<Spot> path;
    private String name;
    public Board(int size, String name)
    {
        path = new ArrayList<Spot>();
        for(int i = 0; i<size; i++)
        {
            Spot temp = new Spot(i);
            path.add(temp);
        }
        this.name = name;
    }
}