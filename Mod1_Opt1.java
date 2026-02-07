package NameList;

import java.util.Scanner;

public class Mod1_Opt1 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("What is your first name?");
		String firstName = scan.nextLine();
		
		System.out.println("What si your last name?");
		String lastName = scan.nextLine();
		
		System.out.println("What is your street adress?");
		String address = scan.nextLine();
		
		System.out.println("What city do you live in?");
		String city = scan.nextLine();
		
		System.out.println("What is your zip code?");
		int zip = scan.nextInt();
		
		System.out.println("The individual " + firstName + lastName + "\nwhose address is: " + address + "\ncity: " + city + "\nzip code: " + zip); 
		

	}

}
