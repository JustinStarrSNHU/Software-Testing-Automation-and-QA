package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import Application.Contact;
import Application.ContactService;

class ContactServiceTest {
	
	ContactService service = new ContactService();
	

	//-------------------------  TESTS FOR addContact  -------------------------------------------------
	
	@Test
	void testAddContactUniqueIdIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.addContact(null, "Justin", "Starr", "0123456789", "My Home Address");
		});
	}
	
	@Test
	void testAddContactUniqueIdIsTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.addContact("01234567890", "Justin", "Starr", "0123456789", "My Home Address");
		});
	}
	
	@Test
	void testAddContactFirstNameIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.addContact("0123456789", null, "Starr", "0123456789", "My Home Address");
		});
	}
	
	@Test
	void testAddContactFirstNameIsTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.addContact("0123456789", "JustinJustin", "Starr", "0123456789", "My Home Address");
		});
	}
	
	@Test
	void testAddContactLastNameIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.addContact("0123456789", "Justin", null, "0123456789", "My Home Address");
		});
	}
	
	@Test
	void testAddContactLastNameIsTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.addContact("0123456789", "Justin", "StarrStarrStarr", "0123456789", "My Home Address");
		});
	}
	
	@Test
	void testAddContactPhoneIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.addContact("0123456789", "Justin", "Starr", null, "My Home Address");
		});
	}
	
	@Test
	void testAddContactPhoneIsTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.addContact("0123456789", "Justin", "Starr", "01234567890", "My Home Address");
		});
	}
	
	@Test
	void testAddContactAddressIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.addContact("0123456789", "Justin", "Starr", "0123456789", null);
		});
	}
	
	@Test
	void testAddContactAddressIsTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.addContact("0123456789", "Justin", "Starr", "0123456789", "My Home Address My Home Address");
		});
	}
	
	@Test
	void testAddContactWithSameIdDoesNotAddContact() {
		service.addContact("01233210", "Justin", "Starr", "0123456789", "My Home Address"); // adds a new contact
		try {
			service.addContact("01233210", "Justin", "Starr", "0123456789", "My Home Address");  // tries to add a new contact with a contactId that has already been used
			fail("Exception Not Thrown"); // if the contactId is not found, the test fails
			
		} 
		catch (IllegalArgumentException e) {
			assertEquals(e.getMessage(), "Contact ID Already In Use"); // an exception is thrown if the contactId is found
		} 
		
	}
	
	@Test
	void testAddContactWithSameIdSecondTest() {
		service.addContact("01", "Justin", "Starr", "0123456789", "My Home Address");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.addContact("01", "J", "S", "1010101010", "My Home");  // second test to show that again an exception is thrown because the contact already exists
		});
	}
	
	@Test
    void testAddValidContact() {
  
      Contact testContact = service.addContact("555", "5", "55", "5657585950", "Contact 555");
      
      assertEquals("555", testContact.getId());
      assertEquals("5", testContact.getFirstName());
      assertEquals("55", testContact.getLastName());
      assertEquals("5657585950", testContact.getPhone());
      assertEquals("Contact 555", testContact.getAddress());
      
    }
	
	
	//---------------------------  TESTS FOR deleteContact  -------------------------------------------
	
	@Test
	void testDeleteContactIdIsNull() {
		service.addContact("0123401234", "Justin", "Starr", "0123456789", "My Home Address");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.deleteContact(null);
		});
	}
	
	@Test
	void testDeleteContactIdIsTooLong() {
		service.addContact("01234012", "Justin", "Starr", "0123456789", "My Home Address");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.deleteContact("012345012345123");
		});
	}
	
	@Test
	void testDeleteContactDeletesContact() {
		service.addContact("9999999999", "Delete", "Me", "8888888888", "I don't belong here");
      	service.deleteContact("9999999999");
		assertNull(service.deleteContact("9999999999"));
	}
	
	// The following test expects a null result because a null value is returned when either a contact is deleted or when a contact is not found.
	// The following test proves that when the contact Id was not found a null value is returned and no contact was deleted.
	// If the test ran as assertNotNull, it would fail.
	
	@Test
	void testDeleteContactDidNotDelete() {
		service.addContact("9595959595", "JJ", "SS", "1526152615", "New New New");
		service.deleteContact("9595959595");
		assertNull(service.deleteContact("9595959594"));
	}
		
	//----------------------------  TESTS FOR updateFirstName  ------------------------------------------
	
	@Test
	void testUpdateContactFirstNameIdIsNull() {
		service.addContact("0000011111", "Justin", "Starr", "0123456789", "My Home Address");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.updateFirstName(null, "New Name");
		});
	}
	
	@Test
	void testUpdateContactFirstNameIdIsTooLong() {
		service.addContact("0102030405", "Justin", "Starr", "0123456789", "My Home Address");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.updateFirstName("01233211233", "New Name");
		});
	}
	
	@Test
	void testUpdateContactFirstNameNewFirstNameIsnull() {
		service.addContact("0123321123", "Justin", "Starr", "0123456789", "My Home Address");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.updateFirstName("2222233333", null);
		});
	}
	
	@Test
	void testUpdateContactFirstNameNewFirstNameIsTooLong() {
		service.addContact("0504030201", "Justin", "Starr", "0123456789", "My Home Address");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.updateFirstName("2222244445", "My Name Is Too Long");
		});
	}
	
	@Test
	void testContactFirstNameDidNotUpdate() {
		service.addContact("5555444422", "Delete", "Me", "8888888888", "I don't belong here");
      	assertNull(service.updateFirstName("5555444423", "My Name"));
	}


	@Test
	void testContactFirstNameDidUpdate() {
		service.addContact("7654765432", "Delete", "Me", "8888888888", "I don't belong here");
      	assertNotNull(service.updateFirstName("7654765432", "My Name"));
	}
	
	
	//----------------------------   TESTS FOR updateLastName   -----------------------------------------
	
	@Test
	void testUpdateContactLastNameIdIsNull() {
		service.addContact("0000022222", "Justin", "Starr", "0123456789", "My Home Address");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.updateLastName(null, "New Name");
		});
	}
	
	@Test
	void testUpdateContactLastNameIdIsTooLong() {
		service.addContact("0001112223", "Justin", "Starr", "0123456789", "My Home Address");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.updateLastName("01233211233", "New Name");
		});
	}
	
	@Test
	void testUpdateContactLastNameNewLastNameIsNull() {
		service.addContact("0204060810", "Justin", "Starr", "0123456789", "My Home Address");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.updateLastName("030403040304", null);
		});
	}
	
	@Test
	void testUpdateContactLastNameNewLastNameIsTooLong() {
		service.addContact("3214321432", "Justin", "Starr", "0123456789", "My Home Address");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.updateLastName("3214321432", "My Name Is Too Long");
		});
	}
	
	@Test
	void testContactLastNameDidNotUpdate() {
		service.addContact("8888888866", "Delete", "Me", "8888888888", "I don't belong here");
      	assertNull(service.updateLastName("8888888865", "My Name"));
	}
	
	@Test
	void testContactLastNameDidUpdate() {
		service.addContact("7878787878", "Delete", "Me", "8888888888", "I don't belong here");
      	assertNotNull(service.updateLastName("7878787878", "My Name"));
	}
	
	
	//----------------------------    TESTS FOR updatePhone   -------------------------------------------
	
	@Test
	void testUpdateContactPhoneIdIsNull() {
		service.addContact("0000033333", "Justin", "Starr", "0123456789", "My Home Address");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.updatePhone(null, "1212121212");
		});
	}
	
	@Test
	void testUpdateContactPhoneIdIsTooLong() {
		service.addContact("0011331133", "Justin", "Starr", "0123456789", "My Home Address");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.updatePhone("01233211233", "1212121212");
		});
	}
	
	@Test
	void testUpdateContactPhoneNewPhoneIsNull() {
		service.addContact("0203040506", "Justin", "Starr", "0123456789", "My Home Address");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.updatePhone("2222233333", null);
		});
	}
	
	@Test
	void testUpdateContactPhoneNewPhoneIsTooLong() {
		service.addContact("2222244444", "Justin", "Starr", "0123456789", "My Home Address");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.updatePhone("2222244445", "100100100100");
		});
	}
	
	@Test
	void testContactPhoneDidNotUpdate() {
		service.addContact("8888888888", "Delete", "Me", "8888888888", "I don't belong here");
      	assertNull(service.updatePhone("8888888765", "1516171819"));
	}
	
	@Test
	void testContactPhoneDidUpdate() {
		service.addContact("7777777777", "Delete", "Me", "8888888888", "I don't belong here");
      	assertNotNull(service.updatePhone("7777777777", "1516171819"));
	}
	
	
	//---------------------------   TESTS FOR updateAddress   ---------------------------------------------
	
	@Test
	void testUpdateContactAddressIdIsNull() {
		service.addContact("1122331122", "Justin", "Starr", "0123456789", "My Home Address");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.updateAddress(null, "This is my new address");
		});
	}
	
	@Test
	void testUpdateContactAddressIdIsTooLong() {
		service.addContact("1122331133", "Justin", "Starr", "0123456789", "My Home Address");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.updateAddress("01233211233", "This is my new address");
		});
	}
	
	@Test
	void testUpdateContactAddressNewAddressIsNull() {
		service.addContact("1021233441", "Justin", "Starr", "0123456789", "My Home Address");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.updateAddress("2222233333", null);
		});
	}
	
	@Test
	void testUpdateContactAddressNewAddressIsTooLong() {
		service.addContact("1040708090", "Justin", "Starr", "0123456789", "My Home Address");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.updateAddress("2222244445", "My New address is way to long for me to update my address");
		});
	}
	
	@Test
	void testContactAddressDidNotUpdate() {
		service.addContact("8484848484", "Delete", "Me", "8888888888", "I don't belong here");
      	assertNull(service.updateAddress("8484848485", "My new address"));
	}
	
	@Test
	void testContactAddressDidUpdate() {
		service.addContact("8989898989", "Delete", "Me", "8888888888", "I don't belong here");
      	assertNotNull(service.updateAddress("8989898989", "My new address"));
	}
	


}