import java.util.Scanner;
//package GameFiles; //only in Eclipse

public class Game
{
    public static void main(String[] args) 
    {
        //Prompts
        System.out.println("You are a new principal at Alexander Hamiltion and your goal is to survive the school day.");
        
        //Take in user input for name
        Scanner scan = new Scanner(System.in);
        System.out.println("What is your name?");
        String name = scan.nextLine();
        int timeCount = 0;
        int hour = 0;

       // Choosing ally
        System.out.println("Choose your Ally: [1] Ms.V (+1 Vision) [2] Ms.W (+1 Movement Speed)");
        int allyChoice = scan.nextInt();
        Ally a1 = null;

        //Item item = new Item()
        //Create Principal object 
        Principal p1 = new Principal(name);
        
        //Create student object
        SuperStudent s1 = new SuperStudent();
        
        //Item object
        Item i1 = new Item();
        
        //Chance to spawn student with phone
        s1.phone();
        //Count amount of phones
        int health = p1.getHealth();
        int count = 0;
        //Game play
        boolean gameRun = true;
        while (gameRun)
        {
            if (allyChoice == 1)                                                                                                                                         
            {
                a1 = new Ally("Ms.V");
            
            
                System.out.println("[1] Check location [2] Move [3] Check Health [0] Quit");
                int choice = scan.nextInt();
                if (choice == 0)
            {
                System.out.println("Game Over");
                System.exit(0); //This will end the program entirely
            }
            else if (choice == 1)
            {
                System.out.println("Your current coordinates are (" + p1.getXCoord() + ", " + p1.getYCoord() + ").");
            }
            else if (choice == 3)
            {
            	System.out.println("Your current health is: " + p1.getHealth());
            }
            else if (choice == 2)
            {
                // Amount of hours they have
                timeCount++;
                if (timeCount == 5)
                {
                    hour++;
                    timeCount = 0;
                    System.out.println("There is " + (7 - hour) + " hours left in the school day.");
                    if (hour == 7)
                    {
                        System.out.println("Game Over");
                System.exit(0); 
                    }
                }
            	//View of Principal
                System.out.println("[1] Up [2] Down [3] Right [4] Left");
                int direction = scan.nextInt();
                int changeOfX = p1.getXCoord() - s1.getXCoord();
                int changeOfY = p1.getYCoord() - s1.getYCoord();
                if (direction == 1 || direction == 2)
                {
                    p1.changeYCoordV(direction);
                    
                    if (i1.getXC() == p1.getXCoord() && i1.getYC() == p1.getYCoord())
                    {
                        System.out.println("You found a special Item.");
                        System.out.println("You get +1 phone.");
                        count++;
                        System.out.println("You need " + (5 - count) + " more phones.");
                    }
                    if (Math.sqrt(Math.pow(changeOfX, 2) + Math.pow(changeOfY, 2)) < 3)
                    {
                    	System.out.println("You have spotted a Student");
                    	if (s1.hasPhone())
                    	{
                    	System.out.println("The student seems to have something in his hands");
                    	}
                    	System.out.println("[1] Check For Phone [2] Leave Kid Alone ");
                    	int choice2 = scan.nextInt();
                    	if (choice2 == 1)
                    	{
                    		if (s1.hasPhone())
                    		{
                    			count++;
                    			System.out.println("They have a phone. You need " + (5 - count) + " more phones.");
                    			/*TO DO: Write a method in student class that re-rolls location*/
                    			s1.studentReroll();
                    			s1.phone();
                    			if (count == 5)
                    			{
                    			    System.out.println("Congrats. You have survived the school day.");
                    			    System.exit(0);
                    			}
                    		}
                    		else if (s1.critAttack() == 1 && !s1.hasPhone())
                    		{
                    		    System.out.println("You have been hit by a Super Student. -10 health.");
                    		    p1.decreaseHealth();
                    		    p1.decreaseHealth();
                    		    health-=10;
                    		    if (health == 0)
                	            {
                	                System.out.println("Game Over");
                	                System.exit(0); //This will end the program entirely
                	            }
                    		}
                    		else if (s1.critAttack() == 2 && !s1.hasPhone())
                    		{
                    		    System.out.println("They do not have a phone. School loses health: -5");
                    			p1.decreaseHealth();
                    			health-=5;
                    			if (health == 0)
                	            {
                	                System.out.println("Game Over");
                	                System.exit(0); //This will end the program entirely
                	            }
                    		}
                    		else
                    		{
                    			System.out.println("They do not have a phone. School loses health: -5");
                    			p1.decreaseHealth();
                    			health-=5;
                    			if (health == 0)
                	            {
                	                System.out.println("Game Over");
                	                System.exit(0); //This will end the program entirely
                	            }
                    		}
                    	}
                    	else if (choice2 == 3)
                    	{
                    	    if (a1.getAlly() == 1)
                    	    {
                    	        if (s1.hasPhone())
                    		    {
                    			    System.out.println("Come get it at the end of the day!!!");
                    			    count++;
                    			    System.out.println("They have a phone. You need " + (5 - count) + " more phones.");
                    			    /*TO DO: Write a method in student class that re-rolls location*/
                    			    s1.studentReroll();
                    			    s1.phone();
                    			    if (count == 5)
                    			{
                    			    System.out.println("Congrats. You have survived the school day.");
                    			    System.exit(0);
                    			}
                    		    }
                    		    else if (s1.critAttack() == 1 && !s1.hasPhone())
                    		{
                    		    System.out.println("You have been hit by a Super Student. -10 health.");
                    		    p1.decreaseHealth();
                    		    p1.decreaseHealth();
                    		    health-=10;
                    		    if (health == 0)
                	            {
                	                System.out.println("Game Over");
                	                System.exit(0); //This will end the program entirely
                	            }
                    		}
                    		else if (s1.critAttack() == 2 && !s1.hasPhone())
                    		{
                    		    System.out.println("They do not have a phone. School loses health: -5");
                    			p1.decreaseHealth();
                    			health-=5;
                    			if (health == 0)
                	            {
                	                System.out.println("Game Over");
                	                System.exit(0); //This will end the program entirely
                	            }
                    		}
                    		    else
                    		    {
                    			    System.out.println("They do not have a phone. School loses health: -5");
                    			    p1.decreaseHealth();
                    			    health-=5;
                    			    if (health == 0)
                    	            {
                    	                System.out.println("Game Over");
                    	                System.exit(0); //This will end the program entirely
                    	            }
                    	        }
                    	    }
                    	    else if (a1.getAlly() == 2)
                    	    {
                    	        if (s1.hasPhone())
                    		    {
                    			    System.out.println("Come get it at the end of the day!!!");
                    			    count++;
                    			    System.out.println("They have a phone. You need " + (5 - count) + " more phones.");
                    			    /*TO DO: Write a method in student class that re-rolls location*/
                    			    s1.studentReroll();
                    			    s1.phone();
                    			    if (count == 5)
                    			{
                    			    System.out.println("Congrats. You have survived the school day.");
                    			    System.exit(0);
                    			}
                    		    }
                    		    else if (s1.critAttack() == 1 && !s1.hasPhone())
                    		{
                    		    System.out.println("You have been hit by a Super Student. -10 health.");
                    		    p1.decreaseHealth();
                    		    p1.decreaseHealth();
                    		    health-=10;
                    		    if (health == 0)
                	            {
                	                System.out.println("Game Over");
                	                System.exit(0); //This will end the program entirely
                	            }
                    		}
                    		else if (s1.critAttack() == 2 && !s1.hasPhone())
                    		{
                    		    System.out.println("They do not have a phone. School loses health: -5");
                    			p1.decreaseHealth();
                    			health-=5;
                    			if (health == 0)
                	            {
                	                System.out.println("Game Over");
                	                System.exit(0); //This will end the program entirely
                	            }
                    		}
                    		    else
                    		    {
                    			    System.out.println("They do not have a phone. School loses health: -5");
                    			    p1.decreaseHealth();
                    			    health-=5;
                    			    if (health == 0)
                    	            {
                    	                System.out.println("Game Over");
                    	                System.exit(0); //This will end the program entirely
                    	            }
                    	        }
                    	    }
                        }
                    }
                }
                
                else if (direction == 3 || direction == 4)
                {
                    p1.changeXCoordV(direction);
                    if (i1.getXC() == p1.getXCoord() && i1.getYC() == p1.getYCoord())
            {
                System.out.println("You found a special Item.");
                System.out.println("You get +1 phone.");
                count++;
                System.out.println("You need " + (5 - count) + " more phones.");
            }
                    if (Math.sqrt(Math.pow(changeOfX, 2) + Math.pow(changeOfY, 2)) < 2)
                    {
                    	System.out.println("You have spotted a Student");
                    	if (s1.hasPhone())
                    	{
                    	System.out.println("The student seems to have something in his hands");
                    	}
                    	System.out.println("[1] Check For Phone [2] Leave Kid Alone");                                                        
                    	int choice2 = scan.nextInt();
                    	if (choice2 == 1)
                    	{
                    		if (s1.hasPhone())
                    		{
                    			count++;
                    			System.out.println("They have a phone. You need " + (5 - count) + " more phones.");
                    			/*TO DO: Write a method in student class that re-rolls location*/
                    			s1.studentReroll();
                    			s1.phone();
                    			if (count == 5)
                    			{
                    			    System.out.println("Congrats. You have survived the school day.");
                    			    System.exit(0);
                    			}
                    		}
                    		else
                    		{
                    			System.out.println("They do not have a phone. School loses health: -5");
                    			p1.decreaseHealth();
                    			health-=5;
                    			if (health == 0)
                	            {
                	                System.out.println("Game Over");
                	                System.exit(0); //This will end the program entirely
                	            }
                    		}
                    	}
                    	else if (choice2 == 3)
                    	{
                    	    if (a1.getAlly() == 1)
                    	    {
                    	        if (s1.hasPhone())
                    		    {
                    			    System.out.println("Come get it at the end of the day!!!");
                    			    count++;
                    			    System.out.println("They have a phone. You need " + (5 - count) + " more phones.");
                    			    /*TO DO: Write a method in student class that re-rolls location*/
                    			    s1.studentReroll();
                    			    s1.phone();
                    			    if (count == 5)
                    			{
                    			    System.out.println("Congrats. You have survived the school day.");
                    			    System.exit(0);
                    			}
                    		    }
                    		    else if (s1.critAttack() == 1 && !s1.hasPhone())
                    		{
                    		    System.out.println("You have been hit by a Super Student. -10 health.");
                    		    p1.decreaseHealth();
                    		    p1.decreaseHealth();
                    		    health-=10;
                    		    if (health == 0)
                	            {
                	                System.out.println("Game Over");
                	                System.exit(0); //This will end the program entirely
                	            }
                    		}
                    		else if (s1.critAttack() == 2 && !s1.hasPhone())
                    		{
                    		    System.out.println("They do not have a phone. School loses health: -5");
                    			p1.decreaseHealth();
                    			health-=5;
                    			if (health == 0)
                	            {
                	                System.out.println("Game Over");
                	                System.exit(0); //This will end the program entirely
                	            }
                    		}
                    		    else
                    		    {
                    			    System.out.println("They do not have a phone. School loses health: -5");
                    			    p1.decreaseHealth();
                    			    health-=5;
                    			    if (health == 0)
                    	            {
                    	                System.out.println("Game Over");
                    	                System.exit(0); //This will end the program entirely
                    	            }
                    	        }
                    	    }
                    	    else if (a1.getAlly() == 2)
                    	    {
                    	        if (s1.hasPhone())
                    		    {
                    			    count++;
                    			    System.out.println("They have a phone. You need " + (5 - count) + " more phones.");
                    			    /*TO DO: Write a method in student class that re-rolls location*/
                    			    s1.studentReroll();
                    			    s1.phone();
                    		    }
                    		    else
                    		    {
                    			    System.out.println("They do not have a phone. School loses health: -5");
                    			    p1.decreaseHealth();
                    			    health-=5;
                    			    if (health == 0)
                    	            {
                    	                System.out.println("Game Over");
                    	                System.exit(0); //This will end the program entirely
                    	            }
                    	        }
                    	    }
                        }
                    }
                }
                else
                {
                    System.out.println("That's not a choice.");
                }
                }
            else
            {
                System.out.println("Please choose again.");
            }
            }
            else if (allyChoice == 2)
            {
                a1 = new Ally("Ms.W");
                System.out.println("[1] Check location [2] Move [3] Check Health [0] Quit");
            int choice = scan.nextInt();
            if (choice == 0 || p1.getHealth() == 0)
            {
                System.out.println("Game Over");
                System.exit(0); //This will end the program entirely
            }
            else if (choice == 1)
            {
                System.out.println("Your current coordinates are (" + p1.getXCoord() + ", " + p1.getYCoord() + ").");
            }
            else if (choice == 3)
            {
            	System.out.println("Your current health is: " + p1.getHealth());
            }
            else if (choice == 2)
            {
                // Amount of hours they have
     timeCount++;
                if (timeCount == 5)
                {
                    hour++;
                    timeCount = 0;
                    System.out.println("There is " + (7 - hour) + " hours left in the school day.");
                    if (hour == 7)
                    {
                        System.out.println("Game Over");
                System.exit(0); 
                    }
                }
            	//View of Principal
                System.out.println("[1] Up [2] Down [3] Right [4] Left");
                int direction = scan.nextInt();
                int changeOfX = p1.getXCoord() - s1.getXCoord();
                int changeOfY = p1.getYCoord() - s1.getYCoord();
                if (direction == 1 || direction == 2)
                {
                    p1.changeYCoordW(direction);
                    if (i1.getXC() == p1.getXCoord() && i1.getYC() == p1.getYCoord())
                    {
                    	System.out.println("You found a special Item.");
                    	System.out.println("You get +1 phone.");
                    	count++;
                    	System.out.println("You need " + (5 - count) + " more phones.");
                    }
                    if (Math.sqrt(Math.pow(changeOfX, 2) + Math.pow(changeOfY, 2)) < 2)
                    {
                    	System.out.println("You have spotted a student");
                    	System.out.println("[1] Check For Phone [2] Leave Kid Alone");
                    	int choice2 = scan.nextInt();
                    	if (choice2 == 1)
                    	{
                    		if (s1.hasPhone())
                    		{
                    			count++;
                    			System.out.println("They have a phone. You need " + (5 - count) + " more phones.");
                    			/*TO DO: Write a method in student class that re-rolls location*/
                    			s1.studentReroll();
                    			s1.phone();
                    			if (count == 5)
                    			{
                    			    System.out.println("Congrats. You have survived the school day.");
                    			    System.exit(0);
                    			}
                    		}
                    		else if (s1.critAttack() == 1 && !s1.hasPhone())
                    		{
                    		    System.out.println("You have been hit by a Super Student. -10 health.");
                    		    p1.decreaseHealth();
                    		    p1.decreaseHealth();
                    		    health-=10;
                    		    if (health == 0)
                	            {
                	                System.out.println("Game Over");
                	                System.exit(0); //This will end the program entirely
                	            }
                    		}
                    		else if (s1.critAttack() == 2 && !s1.hasPhone())
                    		{
                    		    System.out.println("They do not have a phone. School loses health: -5");
                    			p1.decreaseHealth();
                    			health-=5;
                    			if (health == 0)
                	            {
                	                System.out.println("Game Over");
                	                System.exit(0); //This will end the program entirely
                	            }
                    		}
                    		else
                    		{
                    			System.out.println("They do not have a phone. You lose health.");
                    			p1.decreaseHealth();
                    			health-=5;
                    			if (health == 0)
                	            {
                	                System.out.println("Game Over");
                	                System.exit(0); //This will end the program entirely
                	            }
                    		}
                    	}
                    	else if (choice2 == 3)
                    	{
                    	    if (a1.getAlly() == 1)
                    	    {
                    	        if (s1.hasPhone())
                    		    {
                    			    count++;
                    			    System.out.println("They have a phone. You need " + (5 - count) + " more phones.");
                    			    /*TO DO: Write a method in student class that re-rolls location*/
                    			    s1.studentReroll();
                    			    s1.phone();
                    			    if (count == 5)
                    			{
                    			    System.out.println("Congrats. You have survived the school day.");
                    			    System.exit(0);
                    			}
                    		    }
                    		    else if (s1.critAttack() == 1 && !s1.hasPhone())
                    		{
                    		    System.out.println("You have been hit by a Super Student. -10 health.");
                    		    p1.decreaseHealth();
                    		    p1.decreaseHealth();
                    		    health-=10;
                    		    if (health == 0)
                	            {
                	                System.out.println("Game Over");
                	                System.exit(0); //This will end the program entirely
                	            }
                    		}
                    		else if (s1.critAttack() == 2 && !s1.hasPhone())
                    		{
                    		    System.out.println("They do not have a phone. School loses health: -5");
                    			p1.decreaseHealth();
                    			health-=5;
                    			if (health == 0)
                	            {
                	                System.out.println("Game Over");
                	                System.exit(0); //This will end the program entirely
                	            }
                    		}
                    		    else
                    		    {
                    			    System.out.println("They do not have a phone. School loses health: -5");
                    			    p1.decreaseHealth();
                    			    health-=5;
                    			    if (health == 0)
                    	            {
                    	                System.out.println("Game Over");
                    	                System.exit(0); //This will end the program entirely
                    	            }
                    	        }
                    	    }
                    	    else if (a1.getAlly() == 2)
                    	    {
                    	        if (s1.hasPhone())
                    		    {
                    			    System.out.println("Come get it at the end of the day!!!");
                    			    count++;
                    			    System.out.println("They have a phone. You need " + (5 - count) + " more phones.");
                    			    /*TO DO: Write a method in student class that re-rolls location*/
                    			    s1.studentReroll();
                    			    s1.phone();
                    			    if (count == 5)
                    			{
                    			    System.out.println("Congrats. You have survived the school day.");
                    			    System.exit(0);
                    			}
                    		    }
                    		    else
                    		    {
                    			    System.out.println("They do not have a phone. School loses health: -5");
                    			    p1.decreaseHealth();
                    			    health-=5;
                    			    if (health == 0)
                    	            {
                    	                System.out.println("Game Over");
                    	                System.exit(0); //This will end the program entirely
                    	            }
                    	        }
                    	    }
                        }
                    }
                }
                
                else if (direction == 3 || direction == 4)
                {
                    p1.changeXCoordW(direction);
                    if (i1.getXC() == p1.getXCoord() && i1.getYC() == p1.getYCoord())
                    {
                    	System.out.println("You found a special Item.");
                    	System.out.println("You get +1 phone.");
                    	count++;
                    	System.out.println("You need " + (5 - count) + " more phones.");
                    }
                    if (Math.sqrt(Math.pow(changeOfX, 2) + Math.pow(changeOfY, 2)) < 3)
                    {
                    	System.out.println("You have spotted a Student");
                    	System.out.println("[1] Check For Phone [2] Leave Kid Alone");
                    	int choice2 = scan.nextInt();
                    	if (choice2 == 1)
                    	{
                    		if (s1.hasPhone())
                    		{
                    			count++;
                    			System.out.println("They have a phone. You need " + (5 - count) + " more phones.");
                    			/*TO DO: Write a method in student class that re-rolls location*/
                    			s1.studentReroll();
                    			s1.phone();
                    			if (count == 5)
                    			{
                    			    System.out.println("Congrats. You have survived the school day.");
                    			    System.exit(0);
                    			}
                    		}
                    		else if (s1.critAttack() == 1 && !s1.hasPhone())
                    		{
                    		    System.out.println("You have been hit by a Super Student. -10 health.");
                    		    p1.decreaseHealth();
                    		    p1.decreaseHealth();
                    		    health-=10;
                    		    if (health == 0)
                	            {
                	                System.out.println("Game Over");
                	                System.exit(0); //This will end the program entirely
                	            }
                    		}
                    		else if (s1.critAttack() == 2 && !s1.hasPhone())
                    		{
                    		    System.out.println("They do not have a phone. School loses health: -5");
                    			p1.decreaseHealth();
                    			health-=5;
                    			if (health == 0)
                	            {
                	                System.out.println("Game Over");
                	                System.exit(0); //This will end the program entirely
                	            }
                    		}
                    		else
                    		{
                    			System.out.println("They do not have a phone. School loses health: -5");
                    			p1.decreaseHealth();
                    			health-=5;
                    			if (health == 0)
                	            {
                	                System.out.println("Game Over");
                	                System.exit(0); //This will end the program entirely
                	            }
                    		}
                    	}
                    	else if (choice2 == 3)
                    	{
                    	    if (a1.getAlly() == 1)
                    	    {
                    	        if (s1.hasPhone())
                    		    {
                    			    System.out.println("Come get it at the end of the day!!!");
                    			    count++;
                    			    System.out.println("They have a phone. You need " + (5 - count) + " more phones.");
                    			    /*TO DO: Write a method in student class that re-rolls location*/
                    			    s1.studentReroll();
                    			    s1.phone();
                    			    if (count == 5)
                    			{
                    			    System.out.println("Congrats. You have survived the school day.");
                    			    System.exit(0);
                    			}
                    		    }
                    		    else
                    		    {
                    			    System.out.println("They do not have a phone. School loses health: -5");
                    			    p1.decreaseHealth();
                    			    health-=5;
                    			    if (health == 0)
                    	            {
                    	                System.out.println("Game Over");
                    	                System.exit(0); //This will end the program entirely
                    	            }
                    	        }
                    	    }
                    	    else if (a1.getAlly() == 2)
                    	    {
                    	        if (s1.hasPhone())
                    		    {
                    			    System.out.println("Come get it at the end of the day!!!");
                    			    count++;
                    			    System.out.println("They have a phone. You need " + (5 - count) + " more phones.");
                    			    /*TO DO: Write a method in student class that re-rolls location*/
                    			    s1.studentReroll();
                    			    s1.phone();
                    			    if (count == 5)
                    			{
                    			    System.out.println("Congrats. You have survived the school day.");
                    			    System.exit(0);
                    			}
                    		    }
                    		    else
                    		    {
                    			    System.out.println("They do not have a phone. School loses health: -5");
                    			    p1.decreaseHealth();
                    			    health-=5;
                    	            if (health == 0)
                    	            {
                    	                System.out.println("Game Over");
                    	                System.exit(0); //This will end the program entirely
                    	            }
                    	        }
                    	    }
                        }
                    }
                }
                else
                {
                    System.out.println("That's not a choice.");
                }
                }
            else
            {
                System.out.println("Please choose again.");
            }
            }

        }
    }
}
