import java.util.ArrayList;

public interface scheduling {

	ArrayList <Appointment>appts = new ArrayList<>();
	
	public void removeAppointment(int index);
	
	public void changeAppointment(String fName, String lName, long date, String time, String day, int index);
	
	public void deleteUser();
	
	public void addUser(); //if admin handle one way, if not user, handle differently
	
	public void editUser();

	void addAppointment(String fName, String lName, long date, String date2, String day);
	
	
}
