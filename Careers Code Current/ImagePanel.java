import java.awt.*;
import javax.swing.*;
import java.util.*;

public class ImagePanel extends JPanel 
{

    private Image background;                   //The background image
    private Image foreground;
    private ArrayList<Player> players;
    private int xPosition1 = 760, yPosition1 = 790, xPosition2 = 760, yPosition2 = 790, xPosition3 = 760, yPosition3 = 790, xPosition4 = 760, yPosition4 = 790, xPosition5 = 760, yPosition5 = 790, xPosition6 = 760, yPosition6 = 79;
    private int numPlayers = 0;
    
    //pre - gamemaster and mainstart is provided
    //post - none
    public void setPlayers(GameMaster zeus, MainStart alpha)
    {
        this.players = zeus.getPlayerList();
        numPlayers = alpha.getNumPlayers();
    }
    
    //Constructs a new ImagePanel with the background image specified by the file path given
    public ImagePanel(String img) 
    {
        this(new ImageIcon(img).getImage());    
            //The easiest way to make images from file paths in Swing
    }

    //Constructs a new ImagePanel with the background image given
    public ImagePanel(Image img)
    {
        background = img;
        Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));    
            //Get the size of the image
        //Thoroughly make the size of the panel equal to the size of the image
        //(Various layout managers will try to mess with the size of things to fit everything)
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
    }
    
    //pre - graphics is provided
    //post - components are painted
    public void paintComponent(Graphics g) 
    {
        //Paint the background with its upper left corner at the upper left corner of the panel
        g.drawImage(background, 0, 0, null); 
        //Paint the image in the foreground where it should go
        g.drawImage(foreground, xPosition1, yPosition1, null);
        g.drawImage(foreground, xPosition2, yPosition2, null);
        if(numPlayers > 2)
        {
            g.drawImage(foreground, xPosition3, yPosition3, null);
        }
        if (numPlayers > 3)
        {
            g.drawImage(foreground, xPosition4, yPosition4, null);
        }
        if (numPlayers > 4)
        {
            g.drawImage(foreground, xPosition5, yPosition5, null);
        }
        if (numPlayers > 5)
        {
            g.drawImage(foreground, xPosition6, yPosition6, null);
        }
    }
    
    //Sets the foreground image to display
    //pre - an image for a player is provided
    //post - the foreground object is supplied
    public void setImage(Image newImage)
    {
        foreground = newImage;
    }
    
    //Updates the image's position
    //pre - none
    //post - the image is updated
    public void updateImage()
    {
        xPosition1 = (players.get(0)).getXpos();
        yPosition1 = (players.get(0)).getYpos();
        xPosition2 = (players.get(1)).getXpos();
        yPosition2 = (players.get(1)).getYpos();
        if(numPlayers>2)
        {
         xPosition3 = (players.get(2)).getXpos();
         yPosition3 = (players.get(2)).getYpos();
        }
        if (numPlayers>3)
        {
         xPosition4 = (players.get(3)).getXpos();
         yPosition4 = (players.get(3)).getYpos();
        }
        if (numPlayers>4)
        {
         xPosition5 = (players.get(4)).getXpos();
         yPosition5 = (players.get(4)).getYpos();
        }
        if (numPlayers>5)
        {
         xPosition6 = (players.get(5)).getXpos();
         yPosition6 = (players.get(5)).getYpos();
        }
        repaint();  //This repaints stuff... you don't need to know how it works
    }
}