package MainProject;

import java.util.Scanner;

public class mod3_Opt1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int userChoice = 1; 

		while (userChoice == 1) {
		System.out.print("What is your weekly income?");
		double income = scan.nextDouble();
		
		double netIncome;
		
		if(income < 500) {
			netIncome = income - ( .10 * income);
			
			}else if(income >= 500 && income < 1500) {
				netIncome = income - ( .15 * income);
				
			}else if(income >= 1500 && income < 2500){
				netIncome = income - ( .20 * income);
				
			}else {
				netIncome = income - ( .30 * income); 
				
			}
		
		System.out.println("weekly income before taxes : " + income);
		System.out.println("Weekly income after taxes: " + netIncome);
		
		System.out.println("\nWould you like to enter another amount?");
		System.out.println("1 = yes");
		System.out.println("2 = no");
		
		while(!scan.hasNextInt()){
			System.out.println("Invalid input please enter either 1 for yes or 2 for no");
			scan.next();
		}
		
		userChoice = scan.nextInt();
		
		while(userChoice !=1 && userChoice !=2) {
			System.out.println("invalid input. Ent4r 1 for yes or 2 for no: ");
			userChoice = scan.nextInt();
			}
		}
		
		System.out.println("Ending program... Thank you!");
		scan.close();
	}

}
