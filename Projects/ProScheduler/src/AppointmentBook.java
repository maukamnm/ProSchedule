import java.util.ArrayList;

public class AppointmentBook implements scheduling{

	ArrayList <Appointment> appts = new ArrayList<>();
	
	//connection 
	
//	private long date;
//	private String day;
//	private String time;
//	private String fName;
//	private String lName;
	@Override
	public void addAppointment(String fName, String lName, long date, String time, String day) {
		try{
			appts.add(new Appointment(fName, lName, date, day, time));

		}
		catch(Exception e){
			System.out.println("Whoops! Try again..");
			addAppointment(fName, lName, date, day, time);
		}
	}

	@Override
	public void removeAppointment(int index) {
			appts.remove(index);
	}

	@Override
	public void changeAppointment(String fName, String lName, long date, String time, String day, int index) {
		
	}

	@Override
	public void deleteUser() {
		// delete item in array list
		
	}

	@Override
	public void addUser() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editUser() {
		// TODO Auto-generated method stub
		
	}

}
