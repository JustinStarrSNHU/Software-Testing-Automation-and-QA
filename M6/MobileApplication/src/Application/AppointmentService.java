package Application;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Date;

public class AppointmentService {
	
	private static List<Appointment> appointments = new ArrayList<Appointment>();
	
	public Appointment addAppointment(String appointmentId, Date appointmentDate, String appointmentDescription) {
		
		if(appointmentId == null || appointmentId.length() > 10) {
			throw new IllegalArgumentException("Invalid ID");
		}
		if(appointmentDate == null || appointmentDate.before(new Date())) {
			throw new IllegalArgumentException("Invalid Date");
		}
		if(appointmentDescription == null || appointmentDescription.length() > 50 ) {
			throw new IllegalArgumentException("Invalid Appointment Description");
		}
		
		Appointment appointment = null;
		
		ListIterator<Appointment> litr = appointments.listIterator();
		
		while(litr.hasNext()) {
			appointment = litr.next();
			if(appointmentId != null && appointmentId.equals(appointment.getAppointmentId())) {
				throw new IllegalArgumentException("Appointment ID Already In Use");
			}
		}
		appointment = new Appointment(appointmentId, appointmentDate, appointmentDescription);
		appointments.add(appointment);
		return appointment;
	}
	
	public Appointment deleteAppointment(String appointmentId) {
		
		if(appointmentId == null || appointmentId.length() > 10) {
			throw new IllegalArgumentException("Invalid ID");
		}
		
		Appointment appointment = null;
		
		Appointment tempAppointment = null;
		
		ListIterator<Appointment> litr = appointments.listIterator();
		
		while(litr.hasNext()) {
			tempAppointment = litr.next();
			if(appointmentId.equals(tempAppointment.getAppointmentId())) {
				appointment = tempAppointment;
				appointments.remove(appointment);
				return appointment;
			}
		}
		return appointment;	
	}
}
