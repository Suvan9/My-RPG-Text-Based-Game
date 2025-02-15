//OPTION 1
import java.lang.*;
public class Item
{
    private int XC;
    private int YC;
    
    public Item()
    {
        XC = (int)(Math.random() * 2 + 4);
        YC = (int)(Math.random() * 2 + 4);
    }
    
    public int getXC()
    {
        return XC;
    }
    public int getYC()
    {
        return YC;
    }
}









