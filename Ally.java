public class Ally
{
    private String ally; 
    
    public Ally(String n)
    {
        String ally = n;
    }
    
    public int getAlly()
    {
        if (ally.equals("Ms.V"))
        {
            return 1;
        }
        else if (ally.equals("Ms.W"))
        {
            return 2;
        }
        else
        {
            return 0;
        }
    }
}







