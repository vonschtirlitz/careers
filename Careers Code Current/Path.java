import java.util.*;
public class Path
{
    private ArrayList<Spot> lane;
    private String name;
    private int pathSize;
    
    //Constructor
    public Path(int size, String name)
    {
        lane = new ArrayList<Spot>();
        //This is temp array filler, real array will have actual values planted in appropriate spots
        //changes
        for(int i = 0; i < size; i++)
        {
            Spot temp = new Spot(i,0,0,0,0,0,0,0,0);
            lane.add(temp);
        }
        this.name = name;
        this.pathSize = size-1;
    }
    
    //pre - none
    //post - an integer for the size of the path is returned
    public int getSize()
    {
        return pathSize;
    }
    
    //pre - an int for the position is provided
    //post - a spot is returned from a lane in a given position
    public Spot get(int pos)
    {
        return lane.get(pos);
    }
    
    //pre - none
    //post - the lane is set to the outer board
    public void setToMain()
    {
        for(int i = 0; i < lane.size(); i++)
        {
            lane.remove(0);
        }
        
        lane.add(new Spot(0,760,790,true));//start
        lane.add(new Spot(1,650,790,0,0,0,0,1,0));
        lane.add(new Spot(2,570,790,true,false,false,false));
        lane.add(new Spot(3,480,790,0,0,0,0,1,0));
        lane.add(new Spot(4,390,790, true, 1,0,1000));
        lane.add(new Spot(5,310,790,0,0,0,0,1,0));
        lane.add(new Spot(6,220,790,0,0,0,0,0,0));//special spot
        lane.add(new Spot(7,140,790,true,2,0,500));
        lane.add(new Spot(8,20,790,true,5000,6));//hospital
        lane.add(new Spot(9,20,660,0,0,0,0,1,0));
        lane.add(new Spot(10,20,570,true,false));
        lane.add(new Spot(11,20,490,true,3,0,500));
        lane.add(new Spot(12,20,400,0,0,0,0,1,0));
        lane.add(new Spot(13,20,320,-3000,1,0,0));
        lane.add(new Spot(14,20,230,true,4,0,100));
        lane.add(new Spot(15,20,150,0,0,0,0,1,0));
        lane.add(new Spot(16,20,40,0,0,0,0,0,0));
        lane.add(new Spot(17,150,40,0,0,0,0,1,0));
        lane.add(new Spot(18,230,40,true,0));
        lane.add(new Spot(19,310,40,true, 5,0,3000));
        lane.add(new Spot(20,400,40,0,0,0,0,1,0));
        lane.add(new Spot(21,480,40,true,""));
        lane.add(new Spot(22,570,40,true,6,0,1000));
        lane.add(new Spot(23,650,40, 0,0,0,0,1,0));
        lane.add(new Spot(24,760,40,0,0,0,0,0,0));//coord checker
        lane.add(new Spot(25,760,150,0,0,0,0,1,0));
        lane.add(new Spot(26,760,230,0,0,0,0,0,0));//stock market coord checker
        lane.add(new Spot(27,760,320,true,7,0,4000));
        lane.add(new Spot(28,760,400,0,0,0,0,1,0));
        lane.add(new Spot(29,760,490,0,0,0,0,0,0));//speshul spawt
        lane.add(new Spot(30,760,570,true,8,0,5000));
        lane.add(new Spot(31,760,660,0,0,0,0,0,0));//speshuls
    }
    
    //pre - none
    //post - the lane is set to the farming sub path
    public void setToFarming()
    {
        for(int i = 0; i < lane.size(); i++)
        {
            lane.remove(0);
        }
        
        lane.add(new Spot(0,390,790,0,0,0,0,0,0));//null entry spot
        lane.add(new Spot(1,370,385,0,0,2,0,0,0));
        lane.add(new Spot(2,370,640,0,0,0,0,0,1));
        lane.add(new Spot(3,370,600,0,0,1,0,0,0));
        lane.add(new Spot(4,370,560,1000,0,0,0));//dicemod
        lane.add(new Spot(5,330,560,0,2,4,0,0,0));
        lane.add(new Spot(6,290,560,0,0,6,0,0,0));
        lane.add(new Spot(7,290,600,5000,0,0,0,0,0));
        lane.add(new Spot(8,290,640,0,0,2,0,0,0));
        lane.add(new Spot(9,290,680,false,false,true,false));
        lane.add(new Spot(10,310,790,0,5));
    }
    
    //pre - none
    //post - the path is set to the college subPath
    public void setToCollege()
    {
        for(int i = 0; i < lane.size(); i++)
        {
            lane.remove(0);
        }
        
        lane.add(new Spot(0,140,780,0,0,0,0,0,0));
        lane.add(new Spot(1,160,680,0,0,4,0,0,0));
        lane.add(new Spot(2,200,640,true,0,0));
        lane.add(new Spot(3,200,600,0,0,2,0,0,0));
        lane.add(new Spot(4,200,550,0,0,2,0,0,0));
        lane.add(new Spot(5,160,550,0,0,0,0,2,0));
        lane.add(new Spot(6,115,550,0,6,0,0,0,0));
        lane.add(new Spot(7,20,570,0,0,0,0,2,0));
    }
    
    //pre - none
    //post - the path is set to the buisness sub path
    public void setToBusiness()
    {
        for(int i = 0; i < lane.size(); i++)
        {
            lane.remove(0);
        }
        
        lane.add(new Spot(0,20,490,0,0,0,0,0,0));
        lane.add(new Spot(1,120,465,0,0,0,0,0,1));
        lane.add(new Spot(2,160,465,0,0,0,0,1,0));
        lane.add(new Spot(3,200,465,0,0,0,1000,0,0));
        lane.add(new Spot(2,250,470,true,0,0));
        lane.add(new Spot(5,250,420,2000,0,0,0,0,0));
        lane.add(new Spot(6,250,380,0,0,0,2000,0,0));
        lane.add(new Spot(7,250,340,0,0,0,0,0,1));
        lane.add(new Spot(8,200,335,0,0,4,0,0,0));
        lane.add(new Spot(9,160,335,0,16));
        lane.add(new Spot(10,160,380,false,false,false,true));
        lane.add(new Spot(11,120,380,0,0,0,3000,0,0));
        lane.add(new Spot(12,20,400,0,12));
    }
    
    //pre - none
    //post - the lane is set to the sea sub path
    public void setToSea()
    {
        for(int i = 0; i < lane.size(); i++)
        {
            lane.remove(0);
        }  

        lane.add(new Spot(0,20,230,0,0,0,0,0,0));
        lane.add(new Spot(1,120,250,0,8));  
        lane.add(new Spot(2,160,250,0,0,2,0,0,0));
        lane.add(new Spot(3,205,250,0,0,0,0,2,0));
        lane.add(new Spot(4,250,250,0,0,0,0,0,1));
        lane.add(new Spot(5,250,210,1000,0,0,0)); 
        lane.add(new Spot(6,250,170,0,0,4,0,0,0));
        lane.add(new Spot(7,210,170,0,0,6,0,0,0));
        lane.add(new Spot(8,160,170,true,0,0));
        lane.add(new Spot(9,160,130,0,0,8,0,0,0));
        lane.add(new Spot(10,150,40,0,17));
    }
    
    //pre - none
    //post - the lane is set to the politics sub path
    public void setToPolitics()
    {   
        for(int i = 0; i < lane.size(); i++)
        {
            lane.remove(0);
        }
        
        lane.add(new Spot(0,310,40,0,0,0,0,0,0));
        lane.add(new Spot(1,335,120,0,16));
        lane.add(new Spot(2,335,170,0,0,0,0,2,0));
        lane.add(new Spot(3,335,210,0,4,0,0,0,0));
        lane.add(new Spot(4,335,250,0,0,2,0,0,0));
        lane.add(new Spot(5,375,250,0,0,0,0,0,2));
        lane.add(new Spot(6,420,250,0,6,0,0,0,0));
        lane.add(new Spot(7,460,250,0,2,4,0,0,0));
        lane.add(new Spot(8,460,210,0,8,0,0,0,0));
        lane.add(new Spot(9,460,165,5000,4,0,0,0,0));
        lane.add(new Spot(10,420,165,false,true,false,false));
        lane.add(new Spot(11,420,125,0,12,0,0,0,0));
        lane.add(new Spot(12,400,40,0,20));
    }
    
    //pre - none
    //post - the lane is set to the Hollywood sub path
    public void setToHollywood()
    {
        for(int i = 0; i < lane.size(); i++)
        {
            lane.remove(0);
        }
        
        lane.add(new Spot(0,570,40,0,0,0,0,0,0));
        lane.add(new Spot(1,550,125,0,2,0,0,0,0));
        lane.add(new Spot(2,550,165,0,0,0,0,0,1));
        lane.add(new Spot(3,550,120,0,0,0,0,2,0));
        lane.add(new Spot(4,550,250,0,6,2,0,0,0));
        lane.add(new Spot(5,592,250,0,0,0,1000,0,0));
        lane.add(new Spot(6,635,250,false,false,false,true));
        lane.add(new Spot(7,635,210,0,10,-10000,0,0,0));
        lane.add(new Spot(8,635,170,0,0,0,1000));
        lane.add(new Spot(9,680,170,0,12,0,0,0,0));
        lane.add(new Spot(10,760,150,0,25));
    }
    
    //pre - none
    //post - the path is set to the Uranium subpath
    public void setToUranium()
    {
        for(int i = 0; i < lane.size(); i++)
        {
            lane.remove(0);
        }
        
        lane.add(new Spot(0,760,320,0,0,0,0,0,0));
        lane.add(new Spot(1,680,340,0,0,2,0,0,0));
        lane.add(new Spot(2,635,340,true,0,0));
        lane.add(new Spot(3,592,340,-2000,0,0,0,0,0));
        lane.add(new Spot(4,550,340,0,0,2,0,0,0));
        lane.add(new Spot(5,550,380, 0,0,0,0,0,2));
        lane.add(new Spot(6,550,425,0,0,4,0,0,0));
        lane.add(new Spot(7,550,470,0,8));
        lane.add(new Spot(8,592,460,10000,0,0,0,0,0));
        lane.add(new Spot(9,635,470,0,2,0,0,0,0));
        lane.add(new Spot(10,640,425,0,0,6,0,0,0));
        lane.add(new Spot(11,680,425,20000,0,0,0,0,0));
        lane.add(new Spot(12,760,400,0,28));
    }
    
    //pre - none
    //post - the lane is set to the moon sub path
    public void setToMoon()
    {
        for(int i = 0; i < lane.size(); i++)
        {
            lane.remove(0);
        }
        
        lane.add(new Spot(0,760,570,0,0,0,0,0,0));
        lane.add(new Spot(1,680,555,0,0,2,0,0,0));
        lane.add(new Spot(2,635,555,0,6,0,0,0,0));
        lane.add(new Spot(3,590,555,0,-10000,0,0,0,0));
        lane.add(new Spot(4,550,555,-1000000,0,0,0,0,0));
        lane.add(new Spot(5,505,555,0,2,4,0,0,0));
        lane.add(new Spot(6,460,555,0,0,0,2000,0,0));
        lane.add(new Spot(7,460,600,0,0,0,0,0,2));
        lane.add(new Spot(8,460,640,0,16,0,0,0,0));
        lane.add(new Spot(9,505,640,0,0,10,0,0,0));
        lane.add(new Spot(10,550,640,10000,0,0,0,0,0));
        lane.add(new Spot(11,590,640,0,8));
        lane.add(new Spot(12,635,640,0,6,4,0,0,0));
        lane.add(new Spot(13,635,685,5000,0,0,0,0,0));
        lane.add(new Spot(14,650,790,0,1));
    }
}