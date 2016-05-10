//TODO-GUI for selecting number of players.
//getNumPlayers()
public class MainStart
{
    private int playerNum;
    public MainStart()
    {
        System.out.println("Welcome to the game of Careers!");
        Scanner reader = new Scanner(System.in);
        System.out.println("Please enter the total number of players. \nPlease remember that your number of players MUST be between 2-6.");
        playerNum = reader.nextInt();
        System.out.println("Thank you");
    }
    
    public int getNumPlayers()
    {
        return this.playerNum;
    }
}
        
