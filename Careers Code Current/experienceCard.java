public class experienceCard
{
    private int squaresToMove;
    public experienceCard(int toMove)
    {
        squaresToMove = toMove;
    }
    
    public int getValue()
    {
        return squaresToMove;
    }
    
    public String toString()
    {
        return "You can move "+squaresToMove+" spaces";
    }
}