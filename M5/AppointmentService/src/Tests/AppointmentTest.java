package Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import Application.Appointment;

class AppointmentTest {
	
	String dateString = "2023-10-30";
	Date date = Date.valueOf(dateString);
	
	// The following tests provide 100% coverage for the Appointment class

	@Test
	void testAppointmentClass() {
		
		Appointment appointment = new Appointment("001", date, "Future Appointment");
		assertTrue(appointment.getAppointmentId().equals("001"));
		assertTrue(appointment.getAppointmentDate().equals(date));
		assertTrue(appointment.getAppointmentDescription().equals("Future Appointment"));
	}
	
// ----------------------------------------  Tests for appointmentId  ---------------------------------------------
	
	@Test
	void testAppointmentIdIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(null, date, "Future Appointment");
		});
	}
	
	@Test
	void testAppointmentIdIsNotNull() {
		Appointment appointment = new Appointment("001", date, "Future Appointment");
		assertNotNull(appointment.getAppointmentId());
	}
	
	@Test
	void testAppointmentIdIsTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("01234567890", date, "Future Appointment");
		});
	}
	
	@Test
	void testAppointmentIdIsLessThan10Characters() {
		Appointment appointment = new Appointment("001", date, "Future Appoinment");
		assertTrue(appointment.getAppointmentId().length() < 10);
	}
	
	@Test
	void testAppointmentIdIsExactly10Characters() {
		Appointment appointment = new Appointment("0010010010", date, "Future Appointment");
		assertTrue(appointment.getAppointmentId().length() == 10);
	}
	
// --------------------------------------  Tests for appointmentDate  -------------------------------------------
	
	@Test
	void testAppointmentDateIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("001", null, "Future Appointment");
		});
	}
	
	@Test
	void testAppointmentDateIsNotNull() {
		Appointment appointment = new Appointment("001", date, "Future Appointment");
		assertNotNull(appointment.getAppointmentId());
	}
	
	@Test
	void testAppointmentDateIsInThePast() {
		String dateString1 = "2023-09-20";
		Date date1 = Date.valueOf(dateString1);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("002", date1, "date1 is a past date");
		});
		
	}
	
	@Test
	void testAppointmentDateIsInTheFuture() {
		String dateString1 = "2023-10-31";
		Date date1 = Date.valueOf(dateString1);
		Appointment appointment = new Appointment("003", date1,"date1 is in the future");
		assertNotNull(appointment.getAppointmentDate());
	}
	
	@Test
	void testAppointmentDateIsTodaysDate() {
		java.util.Date date1 = new java.util.Date();
		Appointment appointment = new Appointment("021",  date1,  "date1 is today");
		assertEquals(date1, appointment.getAppointmentDate());
		
	}
	


// ----------------------------------  Tests for appointmentDescription  ---------------------------------------
	
	@Test
	void testAppointmentDescriptionIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("006", date, null);
		});
	}
	
	@Test
	void testAppointmentDescriptionIsNotNull() {
		Appointment appointment = new Appointment("007", date, "Future Appointment");
		assertNotNull(appointment.getAppointmentDescription());
	}
	
	@Test
	void testAppointmentDescriptionIsLessThan50Characters() {
		Appointment appointment = new Appointment("008", date, "Future Appointment");
		assertTrue(appointment.getAppointmentDescription().length() < 50);
	}
	
	@Test
	void testAppointmentDescriptionIsTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("009", date, "This is way too longThis is way too longThis is way too long");
		});
	}
	
	@Test
	void testAppointmentDescriptionIsExactly50Characters() {
		Appointment appointment = new Appointment("010", date, "This is exactly 50 characters I still need chars!!");
		assertTrue(appointment.getAppointmentDescription().length()==50);
	}
	
// ----------------------------------  Tests setter method for appointment date  ---------------------------------------
	
	@Test
	void testSetAppointmentDateIsNull() {
		Appointment appointment = new Appointment("011", date, "Future Appointment");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			appointment.setAppointmentDate(null);
		});
	}
	
	@Test
	void testSetAppointmentDateIsNotNull() {
		Appointment appointment = new Appointment("012", date, "Future Appointment");
		assertNotNull(appointment.getAppointmentDate());
	}
	
	@Test
	void testSetAppointmentDateIsInThePast() {
		String dateString1 = "2023-09-20";
		Date date1 = Date.valueOf(dateString1);
		Appointment appointment = new Appointment("013", date, "Future Appoinment");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			appointment.setAppointmentDate(date1);
		});
	}
	
	@Test
	void testSetAppointmentDateIsInTheFutureAndSets() {
		String dateString1 = "2023-10-31";
		Date date1 = Date.valueOf(dateString1);
		Appointment appointment = new Appointment("014", date, "Future Appoinment");
		appointment.setAppointmentDate(date1);
		assertEquals(appointment.getAppointmentDate(), date1);
	}
	
	@Test 
	void testSetAppointmentDateCannotBeToday() {
		java.util.Date date1 = new java.util.Date();
		Appointment appointment = new Appointment("021",  date1,  "todays date");
		assertEquals(date1, appointment.getAppointmentDate());
	}
	
// ------------------------------  Tests setter method for appointment description  -----------------------------------
	
	@Test
	void testSetAppointmentDescriptionIsNull() {
		Appointment appointment = new Appointment("016", date, "Present Day Appointment");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			appointment.setAppointmentDescription(null);
		});
	}
	
	@Test
	void testSetAppointmentDescriptionIsNotNull() {
		Appointment appointment = new Appointment("017", date, "Present Day Appointment");
		appointment.setAppointmentDescription("I am not null");
		assertNotNull(appointment.getAppointmentDescription());
	}
	
	@Test
	void testSetAppointmentDescriptionIsTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("018", date, "This is way too longThis is way too longThis is way too long");
		});
	}
	
	@Test
	void testSetAppointmentDescriptionIsLessThan50Characters() {
		Appointment appointment = new Appointment("019", date, "Future Appoinment");
		assertTrue(appointment.getAppointmentDescription().length() < 50);
	}
	
	@Test
	void testSetAppointmentDescriptionIsExactly50Characters() {
		Appointment appointment = new Appointment("020", date, "This is exactly 50 characters I still need chars!!");
		assertTrue(appointment.getAppointmentDescription().length() == 50);
	}
	
	@Test
	void testSetAppointmentDescriptionSets() {
		Appointment appointment = new Appointment("019", date, "Future Appoinment");
		appointment.setAppointmentDescription("New Description");
		assertEquals(appointment.getAppointmentDescription(), "New Description");
	}
	
// ----------------------------------------  Tests toString method  ----------------------------------------------
	
	@Test
	void testToStringMethod() {
		Appointment appointment = new Appointment("020", date, "Future Appointment");
		assertEquals(appointment.toString(), "Appointment [Id=" + "020" + ", Date=" + "2023-10-30" + ", Description=" + "Future Appointment" + "]");
	}

	

}
