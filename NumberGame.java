import java.util.*;
public class NumberGame
{
    
    private static final int maxChances = 5;
    private static final int max = 100;
    private static final int min = 1;
    
    public static void main (String [] args)
    {
        int question;
        do {
        int roundnum = 1;
        System.out.println("***MAGIC NUMBER GAME***");
        System.out.println(" ");
        System.out.println("Let's Begin!!!");
        System.out.println(" ");
        do
        {
            System.out.println("Round number: " + roundnum);
            System.out.println(" ");
            int passorfail = round();
            if (passorfail != 1)
            {
                int Score = roundnum-1;
                System.out.println("Sorry you guessed a wrong number....");
                System.out.println("Your score is " + Score);
                break;
            }
            
            System.out.println("Your score is " + roundnum + ". Proceeding to next round...");
            System.out.println("");
            roundnum = roundnum + 1;
        }while (roundnum <= 5);
        
        System.out.println("");
        System.out.println("");
        System.out.println("You have sucessfully completed the MAGIC NUMBER GAME");
        System.out.println("Press '1' if you want to play again...");
        Scanner s = new Scanner(System.in);
        question = s.nextInt();
        }while (question == 1);
    }
    
    
    public static String check(int RN)
    {
        Scanner s = new Scanner(System.in);
		System.out.print("Enter your number: ");
		int user = s.nextInt();
		System.out.println("");
		
		if (user == RN){return "equal";}
		else if (user < RN){return "too low";}
		else if (user > RN){return "too high";}
		return null;
    }
    
    public static int round() 
	{
		Random r = new Random();
		int RN = r.nextInt(max - min + 1) + min;
		System.out.println("------------------>Random Number selected is: "+RN);
		int result = 0;
		int chances = maxChances;
		
		while (chances > 0)
		{
		    String ans = check(RN);
		    if ("equal".equals(ans)) 
		    {
                System.out.println("Congratulations you have passed this round...");
                result = 1;
                break;
            }
		    
		    if ( ans == "too low")
		    {
		        System.out.println("Sorry the number you have guessed is too low");
		        chances = chances - 1;
		        System.out.println("Please try again... remaining chances are " + chances);
		        System.out.println("");
		    }
		    
		    if ( ans == "too high")
		    {
		        System.out.println("Sorry the number you have guessed is too high");
		        chances = chances - 1;
		        System.out.println("Please try again... remaining chances are " + chances);
		        System.out.println("");
		    }
		}
		return result;
	}
}