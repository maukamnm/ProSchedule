import java.util.ArrayList;

public interface scheduling {

	ArrayList <Appointment>appts = new ArrayList<>();
	
	public void removeAppointment();
	
	public void changeAppointment();
	
	public void deleteUser();
	
	public void addUser(); //if admin handle one way, if not user, handle differently
	
	public void editUser();

	public void addAppointment();
	
//	String fName, String lName, long date, String time, String day, int index
//	String fName, String lName, long date, long time, String day
	
}
