package MainProject;

import java.util.Scanner;

public class mod3_Opt1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int userChoice = 1; //input for continuing the while loop. 
		int low = 10;//tax rates for program. too be called through the while loop.
		int mid = 15; 
		int midHi = 20;
		int high = 30; 

		while (userChoice == 1) {//while loop prompting to enter in a new income. used to test all tax rates.
		System.out.print("What is your weekly income?");
		double income = scan.nextDouble();
		
		double netIncome; //variable to capture new income in loop. called after directive is executed. 
		int taxRate; //new variable for tax. Shows users what their tax rate is for their weekly income
		
		if(income < 500) {//low tax rate
			netIncome = income - ( .10 * income);//shows the income after taxes
			taxRate = low; //shows tax rate 
			
			}else if(income >= 500 && income < 1500) {
				netIncome = income - ( .15 * income);
				taxRate = mid;
				
			}else if(income >= 1500 && income < 2500){
				netIncome = income - ( .20 * income);
				taxRate = midHi; 
				
			}else {
				netIncome = income - ( .30 * income); 
				taxRate = high; 
			}
		
		System.out.println("weekly income before taxes : " + income);//output for before, after, and tax rate for user input
		System.out.println("Weekly income after taxes: " + netIncome);
		System.out.println("Weekly tax on income: " + taxRate + "%");
		
		System.out.println("\nWould you like to enter another amount?");//prompt user to enter in a new amount our exit program. 
		System.out.println("1 = yes");
		System.out.println("2 = no");
		
		while(!scan.hasNextInt()){// if user is to enter in "y" instead of 1 it will prompt them to try again
			System.out.println("Invalid input please enter either 1 for yes or 2 for no");
			scan.next();
		}
		
		userChoice = scan.nextInt();
		
		while(userChoice !=1 && userChoice !=2) {//iterates through wrong input and exits program if 2 is entered. 
			System.out.println("invalid input. Enter 1 for yes or 2 for no: ");
			userChoice = scan.nextInt();
			}
		}
		
		System.out.println("Ending program... Thank you!");
		scan.close();
	}

}
