//package GameFiles; //only in Eclipse

import java.lang.Math;

public class Student
{
    private int attack;
    private int xCoord;
    private int yCoord;
    private boolean hasPhone = false;
    
    //Default constructor
    public Student()
    {
        xCoord = (int)(Math.random() * 4 + 2);
        yCoord = (int)(Math.random() * 4 + 2);
    }
    
    //Generates a random attack between 1 - 10
    public int studentAttack()
    {
        return (int)(Math.random()*10 + 1);
    }
    
    
    public void phone()
    {
    	int chance = (int)(Math.random() * 100);
    	if (chance >= 50)
        {
            hasPhone = false;
        }
        else
        {
            hasPhone = true;
        }
    }
    
    //Returns students location
    public int getXCoord()
    {
    	return this.xCoord;
    }
    
    public int getYCoord()
    {
    	return this.yCoord;
    }
    

    
    //checks if student has a phone or not
    public boolean hasPhone()
    {
        if (hasPhone == false)
        {
        	return false;
        }
        else
        {
        	return true;
        }
    }
    
    //Re-rolls Student Location
    public void studentReroll()
    {
    	xCoord = (int)(Math.random() * 6);
        yCoord = (int)(Math.random() * 6);
    }
}















