package MainProject;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Mod8_Opt1 {
//private variables
	private String make; 
	private String model;
	private String color; 
	private int year;
	private int mileage;
	private static int idCounter = 1;
	
	private HashMap<String, Mod8_Opt1> vehicle = new HashMap<>();//Hashmap for attributes for vehicle(make, model, color,year, mileage)
	
	public Mod8_Opt1() {
	}
	//getters and setters
	public Mod8_Opt1(String make, String model, String color, int year, int mileage) { 
		this.make = make;
		this.model = model;
		this.color = color;
		this.year = year;
		this.mileage = mileage;
	}
	
	public HashMap<String, Mod8_Opt1> getVehicle(){
		return vehicle;
		
	}

	public void setVehicle(HashMap<String, Mod8_Opt1> vehicle) {
		this.vehicle = vehicle;
	}


	public String getMake() {
		return make;
	}


	public String getModel() {return model; }
	public void setMake(String make) {this.make = make;}



	public void setModel(String model) {
		this.model = model;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}


	public int getMileage() {
		return mileage;
	}


	public void setMileage(int mileage) {
		this.mileage = mileage;
	}


	public int getValidInt(Scanner scan, String message) {//method to validate users input for correct data. Cant put "two thousand twenty". Throws exception until 
		//int is entered
		while(true) {
			try {
				System.out.println(message);
				int value = scan.nextInt();
				scan.nextLine();
				return value;
				
			}catch(InputMismatchException e) {
				System.out.println("Invalid input. Please enter a valid number: ");
				scan.nextLine();
			}
		}
	}
	
	
	public void addVehicle(Scanner scan) {
		
	try {//simple method of collecting attributes for vehicle.
		
		System.out.print("what is the make of the vehicle: ");
		setMake(scan.next());
		
		System.out.print("what is the model of the vehicle: ");
		setModel(scan.next());
		
		System.out.print("what is the color of the vehicle: ");
		setColor(scan.next());
		
		setYear(getValidInt(scan,"what is the year of the vehicle: "));
		
		setMileage(getValidInt(scan,"what is the mileage on the vehicle: "));
		
		String key = "Car" + idCounter;
		vehicle.put(key, new Mod8_Opt1(make, model, color, year, mileage));
		idCounter++;
		System.out.println("Vehicle added Succcessfully!\n");
		
		
	}catch(Exception e){
		System.out.println("Error adding vehicle. Please try again." + e.getMessage());
		scan.nextLine();
	}
		
	}

	public void listVechicles() {//displays vehicle attributes.
		System.out.println("\nStored vehicles: ");
		
		if(vehicle.isEmpty()) {
			System.out.println("No vehicles stored in inventory!\n");
			return;
		}
		
		for(String key : vehicle.keySet()) {
			System.out.println("Vehicle ID: " + key + vehicle.get(key));
			
		}
	}
	

	public void removeVehicle(Scanner scan) {//removes vehicle based on its VechicleID
		
		listVechicles(); //previous stored vehicles
		
		System.out.println("Enter the ID of the vehicle you would like to remove (Car1, Car2): ");
		String removeKey = scan.next();
		
		if(getVehicle().containsKey(removeKey)) {
			getVehicle().remove(removeKey);
			System.out.println("\nVehicle " + removeKey + " removed successfully.\n");
		}else {
			System.out.println("No vehicle found with that ID:" + removeKey);
		}
	}

	public void updateVehicle(Scanner scan){
		try {//look first to see if anything is stored. Returns user to option menu if empty
			if(vehicle.isEmpty()) {
				System.out.println("\nStored vehicles: ");
				System.out.println("No vehicles stored in inventory!\n");
				
				return; 
			}
		
		listVechicles();
		
		String id;
		
		while(true) {//prompts user for vehicle ID to update attributes of the vehicle
		System.out.println("Which vehicle would you like to update(Car1, Car2): ");
		id = scan.next();
		
		if(vehicle.containsKey(id)) {
			break; 
			
		}else {
			System.out.println("Invalid Vehicle ID. No vechicle found w/ that ID: " + id);
			return; 
			
		}
	}
		
		Mod8_Opt1 update = vehicle.get(id);
		
		while(true) {//switch method to update attributes. Simple scan and replace, obtained by a new scan = attr.
		System.out.println("make, model, color, year, mileage");
		String attr = scan.next();
		
		switch(attr) {
			case "make":
				System.out.println("Enter new Make: ");
				update.setMake(scan.next());
				System.out.println("Make updated to: " + update.getMake() + "\n");
				return;
			
			case "model":
				System.out.println("Enter new Model: ");
				update.setModel(scan.next());
				System.out.println("Model updated to: " + update.getModel() + "\n");
				return;
				
			case "color":
				System.out.println("Enter new Color: ");
				update.setColor(scan.next());
				System.out.println("Color updated to: " + update.getColor() + "\n");
				return;
			
			case "year":
				update.setYear(getValidInt(scan,"what is the year of the vehicle: "));//call my method to validate user input(INT not STRING)
				System.out.print("year updated to: " + update.getYear() + "\n");
				return;
				
			case "mileage":
				update.setMileage(getValidInt(scan,"what is the mileage of the vehicle: "));//call my method to validate user input(INT not STRING)
				System.out.println("mileage updated to: " + update.getMileage() + "\n");
				return; 
				
			default:
				System.out.println("Invalid attribute!\n");//catch for the wrong input. 
				}
			}
		}catch(Exception e) {
			System.out.print("Error updating vehicles: " + e.getMessage());
			}
		}

	public void printVehicleToFile() {// print to file
		
		try{
			
			PrintWriter writer = new PrintWriter(new FileWriter("vehicle.txt"));//name of file
			if(vehicle.isEmpty()) {
				System.out.println("No vehicles stored in inventory.");
				
			}else {
				
				writer.println("Total vehicles stored: "  + vehicle.size());//writing information to file
				writer.println("----------------------\n");
				writer.println("Vehicle List: \n");
				
				for(String id : vehicle.keySet()) {//displaying all vehicles stored. 
				
				Mod8_Opt1 car = vehicle.get(id);
				
				writer.println("\nCar ID: " + id   //all vehicle attributes written to file
						+ "\nMake: " + car.getMake() 
						+ " \nModel: " + car.getModel() 
						+ " \nColor: " + car.getColor() 
						+ " \nYear: " + car.getYear() 
						+ " \nMileage: " + car.getMileage());
			}
		}
		
		writer.close();
		
		System.out.println("Vehicle list successfully written to vehicle.txt\n");
		
	}catch(IOException e) {
		System.out.println("Error wrinting vehicles to file: " + e.getMessage());
	}
}
	public String toString() {//return of all attributes for vehicles. 
		return " \nMake: " + make 
				+ " \nModel: " + model 
				+ " \nColor: " + color 
				+ " \nYear: " + year 
				+ " \nMileage: " + mileage + "\n";
	}

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		Mod8_Opt1 obj = new Mod8_Opt1();// Creates a new instance of the Mod8_Opt1 class so its methods and attributes can be used.
		
		
		
		while(true) {//prompt users for what they want to do for the program. 
			
			System.out.println("Choose from the following options: ");
			System.out.println("'A' to add a vehicle "
					+ "\n'R' to remove a vhicle "
					+ "\n'L' to list stored vehicles "
					+ "\n'U' to update an attribute of the vehicle "
					+ "\n'P' to print car list to file to quit program"
					+ "\n'Q' to exit and quit program.");
			
			String add = scan.next();//taking user information and calling methods to main. 
			
			if(add.equalsIgnoreCase("A")) {//add, remove, list, update, exit, and print to file depending on user inputer
				obj.addVehicle(scan);
				
			}else if(add.equalsIgnoreCase("R")) {
				obj.removeVehicle(scan);
				
			}else if(add.equalsIgnoreCase("L")) {
				obj.listVechicles();
				
			}else if(add.equalsIgnoreCase("U")) {
				obj.updateVehicle(scan);
			
			}else if(add.equalsIgnoreCase("Q")) {
				System.out.println("Exiting program...");
				break;
				
			}else if(add.equalsIgnoreCase("P")) {
				obj.printVehicleToFile();
				
			}else {
				System.out.println("Invalid input. ");
			}
		}
		
		//System.out.println("Vehicles stored!");
		obj.listVechicles();
		
		scan.close();
	}

}