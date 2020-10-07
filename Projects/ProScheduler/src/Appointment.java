
public class Appointment {

private long date;
private String day;
private long time;
private String fName;
private String lName;
private long Student_ID;
private String Student_flname;
private String FL_instructor_ID;

Appointment() {
	
}

public Appointment(String fName, String lName, long date, String day, long time) {
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
