package MainProject;

import java.util.ArrayList;
import java.util.Scanner;

public class Mod5 {

	public static void main(String[] args) {
		
		int userInput = 1;
		ArrayList<String> days = new ArrayList<String>();//arrayList for days of the week
		ArrayList<Integer> temp = new ArrayList<Integer>();//arrayList for temperature 
		
		days.add("Monday");//.add to append new information to arraylist
		days.add("Tuesday");
		days.add("Wednesday");
		days.add("Thursday");
		days.add("Friday");
		days.add("Saturday");
		days.add("Sunday");
		
		temp.add(32);
		temp.add(42);
		temp.add(45);
		temp.add(38);
		temp.add(40);
		temp.add(46);
		temp.add(39);
		
		Scanner scan = new Scanner(System.in);
		
		while(userInput == 1) {//asks user if they want to search another day of the week. Searches regardless upper/lowercase 'moNdaY'
			System.out.print("Which day of the week would you like to see the temp for? Or type 'week' to see all: ");
			String input = scan.next();
			input = input.substring(0,1).toUpperCase() + input.substring(1).toLowerCase();
			
			if(input.equalsIgnoreCase("week") ) {//returns all days of the week if 'week' is entered
				int avgTemp = 0;
				
				System.out.println("Here is how the week looked: ");
				for(int i = 0; i < days.size(); i++) {//for loop to iterate through arrayList and return days of the week and temps. 
					System.out.println(days.get(i) + " : " + temp.get(i));
					avgTemp += temp.get(i);//total for temp. 
				}
				
				double weeklyAvg = (double) avgTemp / days.size();//average temp for week
				System.out.printf("Average temp for the week was: %.2f\n", weeklyAvg);//prints decimal value to 2 spaces
				
				}else {//searches index of arraylist to return day and temp
					
					int index = days.indexOf(input);
					
					if(index != -1) {
						System.out.println(days.get(index) + " : " + temp.get(index));
						
					}else {
						System.out.println("Thats not a valids day, please try again.");
					}
				}
			
				System.out.print("Enter 1 to continue or 0 to quit: ");
				//while loop to ask user if they want to enter more day of the week 
				while(!scan.hasNextInt()) {
					System.out.print("invalid entry! - please enter a 1 or 0.");
					scan.next();
					System.out.print("Enter 1 to coninout or 0 to quite: ");
				}
				 
				userInput = scan.nextInt(); 
				
				while(userInput != 0 && userInput != 1) {//if 1 or 0 is not entered loop continues and ask user for required input. 
					System.out.println("Invalid choice - enter 1 to continue or 0 to quite: ");
					
					while(!scan.hasNextInt()) {
						System.out.println("Invalid entery - you must enter in a number.");
						scan.next();
					}
					
					userInput = scan.nextInt(); 
				}
				
				if(userInput == 0) {
					System.out.println("System exiting... Thank you!");
					break; 
		}
		
		
		}
		
		scan.close();

		}
	}



