import java.lang.*;

public class SuperStudent extends Student
{
    private int Crit = 5;
    
    public SuperStudent()
    {
        super.studentAttack();
    }
    
    public int critAttack()
    {
        int chance = (int)(Math.random() * 100) + 1;
        if (chance > 80)
        {
            return 1;
        }
        else
        {
            return 2;
        }
        
    }
}

