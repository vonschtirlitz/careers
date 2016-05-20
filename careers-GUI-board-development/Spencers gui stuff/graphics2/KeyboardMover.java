//Casey McNamara
//5/13/2009
//Moves a ball around with the arrow keys

import javax.swing.*;
import java.awt.event.*;

public class KeyboardMover implements KeyListener
{
    private JFrame frame;                       //The window
    private ImagePanel imagePanel;              //The panel the ball moves around in
    
    private int xPosition, yPosition;
    
    public KeyboardMover() 
    {
        xPosition = 0;
        yPosition = 0;
        init();
    }
    
    public void init()
    {
        frame = new JFrame("Move the ball with the arrow keys!");
        imagePanel = new ImagePanel("Images\\backgroundv3.JPG");
        imagePanel.setImage(new ImageIcon("Images\\redBall.gif").getImage());
        imagePanel.updateImage(0, 0);
        frame.addKeyListener(this);
        frame.add(imagePanel);
        frame.setSize(imagePanel.getPreferredSize());
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void keyPressed(KeyEvent e)
    {
        int keyCode = e.getKeyCode();
        System.out.println("Key Pressed...");
        switch(keyCode)
        {
            case KeyEvent.VK_LEFT:  //left arrow
                System.out.println("Left arrow pressed!");
                xPosition -= 10;
                System.out.println(xPosition + " " + yPosition);
                imagePanel.updateImage(xPosition, yPosition);
                break;
            case KeyEvent.VK_UP:    //up arrow
                System.out.println("Up arrow pressed!");
                yPosition -= 10;
                System.out.println(xPosition + " " + yPosition);
                imagePanel.updateImage(xPosition, yPosition);
                break;
            case KeyEvent.VK_DOWN:  //down arrow
                System.out.println("Down arrow pressed!");
                yPosition += 10;
                System.out.println(xPosition + " " + yPosition);
                imagePanel.updateImage(xPosition, yPosition);
                break;
            case KeyEvent.VK_RIGHT: //right arrow
                System.out.println("Right arrow pressed!");
                xPosition += 10;
                System.out.println(xPosition + " " + yPosition);
                imagePanel.updateImage(xPosition, yPosition);
                break;
            default:
                //other key pressed: ignore
                break; 
        }
        
    }
    
    public void keyReleased(KeyEvent e)
    {
        System.out.println("Key Released!");
        //ignore
    }
    
    public void keyTyped(KeyEvent e)
    {
        System.out.println("Key Typed!");
        //ignore
    }
    
    public static void main(String[] args)
    {
        KeyboardMover a = new KeyboardMover();
    }
}