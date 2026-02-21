package MainProject;

import java.util.Scanner;

public class Mod4_Opt1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("enter in 5 numbers: ");
		double value = scan.nextDouble();
		
		int count = 1;
		
		double total = value;
		double max = value;
		double min = value; 
		
		while(count < 5) {
			System.out.print("enter in 5 numbers: ");
			value = scan.nextDouble();
			
			total += value;
			
			if(value > max) {
				max = value; 
			}
			if(value < min) {
				min = value; 
			}
			count++;
			
			
		}
		
		double average = total / 5;
		double interest = total * .20;
		
		System.out.println("total: " + total);
		System.out.println("averge: " + average);
		System.out.println("maximun: " + max);
		System.out.println("minimum: " + min);
		System.out.println("Interest on total at 20%: " +  interest);
	}

}
