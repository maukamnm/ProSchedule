
public class Appointment {

private long date;
private String day;
private String time;
private String fName;
private String lName;
 
public Appointment() { }

public Appointment( String fName, String lName, long date, String day, String time) {
	super();
	this.fName = fName;
	this.lName = lName;
	this.date = date;
	this.day = day;
	this.time = time;
}

@Override
public String toString() {
	return "Appointment for: " + fName + " " + lName + "\nDate: " 
	+ date + " " + day + ", at" + time;
}

}
