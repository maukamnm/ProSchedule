import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.io.*;
import java.sql.*;

public class AppointmentBook {

	private long date;
	private String day;
	private long time;
	private String fName;
	private String lName;
	private static int index;
	static Scanner sc = new Scanner(System.in);

	static ArrayList<Appointment> appts = new ArrayList<>();

	String pattern = "yyyy-MM-dd";
	SimpleDateFormat format = new SimpleDateFormat(pattern);

	static final String DB_URL = "jdbc:mysql://127.0.0.1/SchedulePro";
	static final String USER = "root";
	static final String PASS = "root";

	static Connection connection;

	AppointmentBook() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(DB_URL, USER, PASS);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void menu() {
		do {
			System.out.println("SchedulePro Menu");
			System.out.println("======================");
			System.out.println("0. Exit");
			System.out.println("1. See all Appointments");
			System.out.println("2. Create Appointment");
			System.out.println("3. Search for Appointment");
			System.out.println("4. Delete Appointment");

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
			case 5:
				// Add student
				addStudent();
				break;
			case 6:
				// Show all Appointments
				ShowAppointments();
				break;
			case 7:
				// Add Appointment
				addAppointment();
				break;
			case 8:
				// Edit Appointment
				System.out.println(appts);
				System.out.println("Enter the ID for the contact you would like to delete");
				changeAppointment();
				break;
			case 9:
				// Remove Appointment
				removeAppointment();
				break;
			}

		} while (true); // We will handle the exit in the loop
	}

	private static void ShowAppointments() {
		// TODO Auto-generated method stub
		
	}

	private static void addStudent() {
		
	}

	public static void addAppointment() {
		
		boolean addAnother = true;
		
		System.out.println("****************************");
		System.out.println("*** ADD APPOINTMENT ***");
		System.out.println("****************************");
		
		do {
		try {
			
			
			String sql = "INSERT INTO Appointment "
					+ "(Appointment_ID, Lesson_type, Student_ID, Student_fname, "
					+ "Student_lname, FL_instructor_ID, FL_fname, FL_lname, Plane_ID, Date_Time) VALUES (?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement stmt = connection.prepareStatement(sql);

			System.out.println("Student First Name : ");
			String name = sc.next();
			System.out.println("Student Last Name : ");
			String last_name = sc.next();
			System.out.println("Student ID : ");
			int StudID = sc.nextInt();
			System.out.println("Flight Instructor First Name : ");
			String FL_fname = sc.next();
			System.out.println("Flight Instructor Last Name : ");
			String FL_lname = sc.next();
			System.out.println("Flight Instructor ID : ");
			int FL_ID = sc.nextInt();
			System.out.println("Lesson Type? (PPL || IR || ME) ");
			String type = sc.next();
			System.out.println("Plane ID : ");
			int Plane_ID = sc.nextInt();
			System.out.println("Appointment Date and Time : \nFormat : YYYY-MM-DD, HH:MM-HH:MM");
			String dateTime = sc.next();
			System.out.println("Add another Appointment? (Y/N)");
			String ans = sc.next().toUpperCase();
			if (ans.equals("N")) {
				addAnother = false;
			} else {
				addAnother = true;
			}

		} catch (Exception e) {
			System.out.println("Invalid input. Try again.");
			addAppointment();
		}
		} while (addAnother == true);

	}
	
	public static void removeAppointment() {
		boolean removeAnother = true;
		try {
			String sql = "SELECT Appointment_ID, Lesson_type, Student_ID, Student_fname, "
					+ "Student_lname, FL_instructor_ID, FL_fname, FL_lname, "
					+ "Plane_ID, Date_Time FROM Appointment";
			System.out.println("Welcome!");
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet results = stmt.executeQuery();
			while (results.next()) {	
				System.out.print(results.getInt("Appointment_ID") + ") ");
				System.out.print("\t" + results.getString("Lesson_type") + " | ");
				System.out.print("\t" + results.getInt("Student_ID") + " | ");
				System.out.print("\t" + results.getString("Student_fname") + " ");
				System.out.print("\t" + results.getString("Student_lname") + " | ");
				System.out.print("\t" + results.getInt("Plane_ID") + "|");
				System.out.print("\t" + results.getString("Date_Time") + "\n");
			}
			System.out.println("Which Appointment do you want to delete [THERE IS NO UNDO]?");
			int id = sc.nextInt();
			// DELETE a record from the table
			sql = "DELETE FROM Appointment WHERE Appointment_ID = ?";
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.print("Oops, try again!");
			removeAppointment();
		}
	}

	public static void changeAppointment() {

	}
	
	public static void viewAppointments() {
		int counter = 1;
		System.out.println("***********************");
		System.out.println("*** DISPLAY APPOINTMENTS ***");
		System.out.println("***********************");

		try {

			String sql = "SELECT Appointment_ID, Lesson_type, Student_ID, Student_fname, "
					+ "Student_lname, FL_instructor_ID, FL_fname, FL_lname, "
					+ "Plane_ID, Date_Time FROM Appointment ORDER BY Appointment_ID";
			Statement statement = connection.createStatement();
			ResultSet results = statement.executeQuery(sql);
			System.out.println("Appointments");
			System.out.println("==========");
			while (results.next()) {
				System.out.print(results.getInt("Appointment_ID") + ") ");
				System.out.print(results.getString("Lesson_type") + " | ");
				System.out.print(results.getInt("Student_ID") + " | ");
				System.out.print(results.getString("Student_fname") + " ");
				System.out.print(results.getString("Student_lname") + " | ");
				System.out.print(results.getInt("Plane_ID") + "|");
				System.out.print(results.getString("Date_Time") + "\n");			
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.print("Oops, lets try again!");
			menu();
		}
	}

	public void deleteUser() {
		

	}

	public void addUser() {
		

	}

	public void editUser() {
		

	}

}
