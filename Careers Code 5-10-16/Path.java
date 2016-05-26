import java.util.*;
public class Path
{
    private ArrayList<Spot> lane;
    private String name;
    private int pathSize;
    
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
    
    public int getSize()
    {
        return pathSize;
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
    
    public void setToBuisness()
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