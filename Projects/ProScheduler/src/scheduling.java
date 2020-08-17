import java.util.ArrayList;

public interface scheduling {

	ArrayList <Appointment>appts = new ArrayList<>();
	
	public void addAppointment();
	
	public void removeAppointment();
	
	public void changeAppointment();
	
	public void deleteUser();
	
	public void addUser(); //if admin handle one way, if not user, handle differently
	
	public void editUser();
	
	
}
