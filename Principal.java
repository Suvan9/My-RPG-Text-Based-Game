//package GameFiles; //only in Eclipse

public class Principal
{
    private String name;
    private int health;
    private int xCoord;
    private int yCoord;
    private boolean isCapped = true;
    
    /*
    Default constructor
    Principal spawns at main office (0,0)
    */
    public Principal(String n)
    {
        name = n;
        health = 100;
        xCoord = 0;
        yCoord = 0;
    }
    
    /*
    Decrease health
    */
    public void decreaseHealth()
    {
        health -= 5;
        if (health < 0)
        {
            health = 0;
        }
    }

    /*
    Getter Methods / Accessor Methods
    Retrieves Principal's location
    */
    public int getXCoord()
    {
        return xCoord;
    }
    
    public int getYCoord()
    {
        return yCoord;
    }
    
    /*
    Setter Methods / Mutator Methods
    Moving the principal
    */
    public void changeYCoordV(int num)
    {
        if (num == 1)
        {
            yCoord++;
            if (yCoord > 5)
            {
                yCoord = 5;
            }
        }
        else if (num == 2)
        {
            yCoord--;
            if (yCoord < 0)
            {
                yCoord = 0;
            }
        }
    }    
    
    public void changeYCoordW(int num)
    {
        if (num == 1)
        {
            yCoord += 2;
            if (yCoord > 5)
            {
                yCoord = 5;
            }
        }
        else if (num == 2)
        {
            yCoord -= 2;
            if (yCoord < 0)
            {
                yCoord = 0;
            }
        }
    }
    
    public void changeXCoordV(int num)
    {
        if (num == 3)
        {
            xCoord++;
            if (xCoord > 5)
            {
                xCoord = 5;
            }
        }
        else if (num == 4)
        {
            xCoord--;
            if (xCoord < 0)
            {
                xCoord = 0;
            }
        }
    }    
    
    public void changeXCoordW(int num)
    {
        if (num == 3)
        {
            xCoord += 2;
            if (xCoord > 5)
            {
                xCoord = 5;
            }
        }
        else if (num == 4)
        {
            xCoord -= 2;
            if (xCoord < 0)
            {
                xCoord = 0;
            }
        }
    }    
    
    //returns School health
    public int getHealth()
    {
    	return health;
    }
    
    /*
    Prints out information of the principal
    */
    public String toString()
    {
        return "You are Principal " + name + ". Your current school health is " + health + ".";
    }
}














































