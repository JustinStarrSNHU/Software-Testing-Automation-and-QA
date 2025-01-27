package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Date;

import Application.Appointment;
import Application.AppointmentService;

class AppointmentServiceTest {
	
	AppointmentService appService = new AppointmentService();
	
	String dateString = "2023-10-30";
	Date date = Date.valueOf(dateString);
	
// -------------------------------     Tests for addAppointment ----------------------------------------------

	
	// ID TESTS
	
	
	@Test
	void testAddAppointmentIdIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			appService.addAppointment(null, date, "Future Appointment");
		});
	}
	
	@Test
	void testAddAppointmentIdIsNotNull() {
		Appointment appointment = appService.addAppointment("001", date, "Future Appointment");
		assertNotNull(appointment.getAppointmentId());
	}
	
	@Test
	void testAddAppointmentIdIsTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			appService.addAppointment("01234567890", date, "Future Appointment");
		});
	}
	
	@Test
	void testAddAppointmentIdIsLessThan10Characters() {
		Appointment appointment = appService.addAppointment("002", date, "Future Appointment");
		assertTrue(appointment.getAppointmentId().length() < 10);
	}
	
	@Test
	void testAddAppointmentIsExactly10Characters() {
		Appointment appointment = appService.addAppointment("0020020020", date, "Future Appointment");
		assertTrue(appointment.getAppointmentId().length() == 10);
	}
	
	
	// DATE TESTS
	
	
	@Test
	void testAddAppointmentDateIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			appService.addAppointment("003", null, "Future Appointment");
		});
	}
	
	@Test
	void testAddAppointmentDateIsNotNull() {
		Appointment appointment = appService.addAppointment("004", date, "Future Appointment");
		assertNotNull(appointment.getAppointmentDate());
	}
	
	@Test
	void testAddAppointmentDateIsInThePast() {
		String dateString1 = "2023-08-30";
		Date date1 = Date.valueOf(dateString1);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			appService.addAppointment("005",  date1,  "Past Appointment");
		});
	}
	
	@Test
	void testAddAppointmentAddsAppointmentInTheFuture() {
		Appointment appointment = appService.addAppointment("005", date, "Future Appointment");
		assertEquals(date, appointment.getAppointmentDate());
	}
	
	@Test
	void testAddAppointmentDateIsTodaysDate() {
		java.util.Date date1 = new java.util.Date();
		Appointment appointment = appService.addAppointment("017",  date1,  "todays date");
		assertEquals(date1, appointment.getAppointmentDate());
	}
	
	
	// DESCRIPTION TESTS
	
	
	@Test 
	void testAddAppointmentDescriptionIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			appService.addAppointment("006", date, null);
		});
	}
	
	@Test
	void testAppointmentDescriptionIsNotNull() {
		Appointment appointment = appService.addAppointment("007", date, "Future Appointment");
		assertNotNull(appointment.getAppointmentDescription());
	}
	
	@Test 
	void testAddAppointmentDescriptionIsLessThan50Characters() {
		Appointment appointment = appService.addAppointment("008", date, "Future Appointment");
		assertTrue(appointment.getAppointmentDescription().length() < 50);
	}
	
	@Test
	void testAddAppointmentDescriptionIstOOlONG() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		appService.addAppointment("009", date, "012345678901234567890123456789012345678901234567890123456789");
		});
	}
	
	@Test 
	void testAddAppointmentDescriptionIsExactly50Characters() {
		Appointment appointment = appService.addAppointment("010",  date,  "01234567890123456789012345678901234567890123456789");
		assertTrue(appointment.getAppointmentDescription().length() == 50); 
		
	}
	
	
	// ADD APPOINTMENT TESTS
	
	@Test
	void testAddAppointmentAddsAppointment() {
		Appointment appointment = appService.addAppointment("011", date, "Appointment 11");
		assertEquals("011", appointment.getAppointmentId());
		assertEquals(date, appointment.getAppointmentDate());
		assertEquals("Appointment 11", appointment.getAppointmentDescription());
	}
	
	@Test
	void testAddTwoAppointmentsDoesNotEqualEachOther() {
		Appointment appointment1 = appService.addAppointment("020", date, "Appointment 20");
		Appointment appointment2 = appService.addAppointment("021", date, "Appointment 21");
		assertNotEquals(appointment1, appointment2);
	}
	
	@Test 
	void testAddAppointmentWithSameIdDoesNotAddAppointment() {
		appService.addAppointment("012",  date,  "Appointment 12");
		try {
			appService.addAppointment("012",  date,  "Appointment 13");
			fail("Exception Not Thrown");
		}
		catch (IllegalArgumentException e) {
			assertEquals(e.getMessage(), "Appointment ID Already In Use");
		}
	}
	
	@Test
	void testAddAppointmentWithSameIdDoesNotAddSecondTest() {
		appService.addAppointment("013", date, "Appointment 13");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			appService.addAppointment("013",  date,  "Appointment 14");
		});
	}
	
// -------------------------------     Tests for deleteAppointment ----------------------------------------------
	
	// TESTS for ID
	
	@Test
	void testDeleteAppointmentIdIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			appService.deleteAppointment(null);
		});
	}
	
	@Test 
	void testDeleteAppointmentIdIsNotNull() {
		appService.addAppointment("014",  date,  "Appointment 14");
		assertNotNull(appService.deleteAppointment("014"));
		
	}
	
	@Test
	void testDeleteAppointmentDeletesAppointment() {
		appService.addAppointment("015",  date,  "Appointment 15");
		appService.deleteAppointment("015");
		assertNull(appService.deleteAppointment("015"));
	}
	
	@Test
	void testDeleteAppointmentDoesNotDeleteAppointment() {
		appService.addAppointment("016",  date,  "Appointment 16");
		assertNull(appService.deleteAppointment("017"));
	}

}
