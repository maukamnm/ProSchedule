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
	private int index;
	static Scanner sc = new Scanner(System.in);

	static ArrayList<Appointment> appts = new ArrayList<>();

	String pattern = "yyyy-MM-dd";
	SimpleDateFormat format = new SimpleDateFormat(pattern);

	static final String DB_URL = "jdbc:mysql://127.0.0.1/greendragon";
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
		try {
			appts.add(new Appointment(fName, lName, date, day, time));

		} catch (Exception e) {
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
