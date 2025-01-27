package Application;

import java.util.Date;

public class Appointment {
	private String appointmentId;
	private Date appointmentDate;
	private String appointmentDescription;
	
	public Appointment(String appointmentId, Date appointmentDate, String appointmentDescription) {
		if(appointmentId == null || appointmentId.length() > 10) {
			throw new IllegalArgumentException("Invalid Appointment Id");
		}
		if(appointmentDate == null || appointmentDate.before(new Date())) {
			throw new IllegalArgumentException("Invalid Appointment Date");
		}
		if(appointmentDescription == null || appointmentDescription.length() > 50) {
			throw new IllegalArgumentException("Invalid Appointment Description");
		}
		
		this.appointmentId = appointmentId;
		this.appointmentDate = appointmentDate;
		this.appointmentDescription = appointmentDescription;
	}
	
	public String getAppointmentId() {
		return appointmentId;
	}
	
	public Date getAppointmentDate() {
		return appointmentDate;
	}
	
	public void setAppointmentDate(Date appointmentDate) {
		if(appointmentDate == null || appointmentDate.before(new Date())) {
			throw new IllegalArgumentException("Invalid Appointment Date");
		}
		this.appointmentDate = appointmentDate;
	}
	
	public String getAppointmentDescription() {
		return appointmentDescription;
	}
	
	public void setAppointmentDescription(String appointmentDescription) {
		if(appointmentDescription == null || appointmentDescription.length() > 50) {
			throw new IllegalArgumentException("Invalid Appointment Description");
		}
		this.appointmentDescription = appointmentDescription;
	}
	
	public String toString() {
		return ("Appointment [Id=" + appointmentId + ", Date=" + appointmentDate + ", Description=" + appointmentDescription + "]");
	}
}
