//Casey McNamara
//4/27/2009; modified 5/13/2009 for KeyboardMover
//Extends JPanel to better paint images in arbitrary places
//This specific implementation has a background image and one foreground image

import java.awt.*;
import javax.swing.*;
import java.util.*;

public class ImagePanel extends JPanel {

    private Image background;                   //The background image
    private Image foreground;
    //private ArrayList<Player> players;
    private int xPosition, yPosition;
    
    /*
    public void setPlayers()
    {
        ArrayList<Player> temp = getPlayerList();
        for(int x; x < alpha.getNumPlayers(); x++)
        {
            players.add(temp.get(x));
        }
    }
    */
    
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

    //This is called whenever the computer decides to repaint the window
    //It's a method in JPanel that I've overwritten to paint the background and foreground images
    public void paintComponent(Graphics g) 
    {
        //Paint the background with its upper left corner at the upper left corner of the panel
        g.drawImage(background, 0, 0, null); 
        //Paint the image in the foreground where it should go
        g.drawImage(foreground, xPosition, yPosition, null);
        /*
        for(x = 0, x < alpha.getNumPlayers(), x++)
        {
            g.drawImage(foreground, (players.get(x)).getXpos, (players.get(x)).getYpos)
        }
        */
    }
    
    //Sets the foreground image to display
    public void setImage(Image newImage)
    {
        foreground = newImage;
    }
    
    //Updates the image's position
    public void updateImage(int x, int y)
    {
        xPosition = x;
        yPosition = y;
        repaint();  //This repaints stuff... you don't need to know how it works
    }
}
