import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AppointmentBook{

	static ArrayList <Appointment> appts = new ArrayList<>();
	
	//connection 
	
	private static long date;
	private static String day;
	private static long time;
	private static String fName;
	private static String lName;
	static int index;
	
	public static void menu() {
		Scanner sc = new Scanner(System.in);
		// Create and show a menu for the user and one for FL instructor
		// Keep showing until they enter a 0
		do {
			System.out.println("SchedulePro Menu");
			System.out.println("======================");
			System.out.println("0. Exit");
			System.out.println("1. See all Appointments");
			System.out.println("2. Create Appointment");
			System.out.println("3. Search for Appointment");

			int choice = 0;
			try {
			choice = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Wrong input! Try again!");
				menu();
			}
			
			// Pick the option from the switch statement
			switch (choice) {
			case 0:
				// Exit the program
				System.exit(0);
				break;
			case 1:
				// Show all Appointments
				System.out.println(appts);
				break;
			case 2:
				// Add Appointment
				addAppointment();
				break;
			case 3:
				// Edit Appointment
				System.out.println(appts);
				System.out.println("Enter the ID for the contact you would like to delete");
				changeAppointment();
				break;
			case 4:
				// Remove Appointment
				removeAppointment();
				break;
			}

		} while (true); // We will handle the exit in the loop
	}

	
	public static void addAppointment() {
		try{
			appts.add(new Appointment(fName, lName, date, day, time));

		}
		catch(Exception e){
			System.out.println("Whoops! Try again..");
			addAppointment();
		}
	}

	public static void removeAppointment() {
			appts.remove(index);
	}

	public static void changeAppointment() {
		
	}

	public void deleteUser() {
		// delete user in array list
		
	}

	public void addUser() {
		// add user 
		
	}

	public void editUser() {
		// edit user
		
	}

}
