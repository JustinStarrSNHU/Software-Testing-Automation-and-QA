package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import Application.Contact;


class ContactTest {
	
	// The following tests provide 100% coverage for the Contact Class

	@Test
	void testContactClass() {
		Contact contact = new Contact("1234567890", "Justin", "Starr", "1234567890", "My Home Address");
		assertTrue(contact.getId().equals("1234567890"));
		assertTrue(contact.getFirstName().equals("Justin"));
		assertTrue(contact.getLastName().equals("Starr"));
		assertTrue(contact.getPhone().equals("1234567890"));
		assertTrue(contact.getAddress().equals("My Home Address"));
	}
	
// ----------------------------------------  Tests for Id -----------------------------------------------	
	@Test
	void testUniqueIdIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "Justin", "Starr", "1234567890", "My Home Address");
		});
	}
	
	@Test
	void testUniqueIdIsNotNull() {
		Contact contact = new Contact("15", "1", "5", "1515151515", "15's address");
		assertNotNull(contact.getId());
	}
	
	@Test
	void testContactUniqueIdTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("09876543210123", "Justin", "Starr", "0123456789", "My Home Address");
		});
	}
	
	@Test
	void testContactUniqueIdIsLessThan10Characters() {
		Contact contact = new Contact("14", "A", "B", "1112111211", "Home");
		assertTrue(contact.getId().length()<10);
	}
	
	@Test
	void testContactUniqueIdIsEqualTo10Characters() {
		Contact contact = new Contact("1414141414", "A", "B", "1112111211", "Home");
		assertTrue(contact.getId().length()==10);
	}
	
	
	
	
	
//  -------------------------------     Tests for firstName   -------------------------------------------
	
	
	@Test
	void testContactFirstNameIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("0123456789", null,  "Starr", "0123456780", "My Home Address");
		});
	}
	
	@Test 
	void testFirstNameIsNotNull() {
		Contact contact = new Contact("16", "1", "6", "1616161616", "16's address");
		assertNotNull(contact.getFirstName());
	}
	
	@Test
	void testContactFirstNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("0987654321", "JustinJustin", "Starr", "0123456789", "My Home Address");
		});
	}
	
	@Test
	void testContactFirstNameIsLessThan10Characters() {
		Contact contact = new Contact("12", "Justin", "Starr", "1234567890", "My Home Address");
      	assertTrue(contact.getFirstName().length()<10);
	}
	
	@Test
	void testContactFirstNameIsEqualTo10Characters() {
		Contact contact = new Contact("13", "JustinStar", "Starr", "1234567890", "My Home Address");
      	assertTrue(contact.getFirstName().length()==10);
	}
	
//  -------------------------------     Tests for lastName   -------------------------------------------	
	
	@Test
	void testContactLastNameIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("0987654321", "Justin", null, "0123456789", "My Home Address");
		});
	}
	
	@Test
	void testContactLastNameIsNotNull() {
		Contact contact = new Contact("17", "1", "7", "1717171717", "17's address");
		assertNotNull(contact.getLastName());
	}
	
	@Test
	void testContactLastNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("0123456789", "Justin", "StarrStarrStarr", "0123456789", "My Home Address");
		});
	}
	
	@Test 
	void testContactLastNameIsLessThan10Characters() {
		Contact contact = new Contact("18", "1", "8", "1818181818", "18's address");
		assertTrue(contact.getLastName().length()<10);
	}
	
	@Test
	void testContactLastNameIsEqualTo10Characters() {
		Contact contact = new Contact("19", "1", "1919191919", "1919191919", "19's address");
		assertTrue(contact.getLastName().length()==10);
	}

//  --------------------------------     Tests for phone   ----------------------------------------------
	
	@Test
	void testContactPhoneIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("0123456789", "Justin", "Starr", null, "My Home Address");
		});
	}
	
	@Test
	void testContactPhoneIsNotNull() {
		Contact contact = new Contact("20", "2", "0", "2020202020", "20's address");
		assertNotNull(contact.getPhone());
	}
	
	@Test
	void testContactPhoneTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("0123456789", "Justin", "Starr", "012345678901", "My Home Address");
		});
	}
	
	@Test
	void testContactPhoneTooShort() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("0123456789", "Justin", "Starr", "01234567", "My Home Address");
		});
	}
	
	@Test
	void testContactPhoneEquals10Characters() {
		Contact contact = new Contact("21", "2", "1", "2121212121", "21's address");
		assertTrue(contact.getPhone().length()==10);
	}
	
//  -------------------------------     Tests for address     --------------------------------------------
	
	@Test
	void testContactAddressIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("0123456789", "Justin", "Starr", "0123456789", null);
		});
	}
	
	@Test
	void testContactAddressIsNotNull() {
		Contact contact = new Contact("22", "2", "2", "2222222222", "22's address");
		assertNotNull(contact.getAddress());
	}
	
	@Test
	void testContactAddressIsTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("0123456789", "Justin", "StarrStarr", "0123456789", "My Home Address My Home Address");
		});
	}
	
	@Test
	void testContactAddressIsLessThan30Characters() {
		Contact contact = new Contact("23", "2", "3", "2323232323", "23's address");
		assertTrue(contact.getAddress().length()<30);
	}
	
	@Test
	void testContactAddressIsEqualTo30Characters() {
		Contact contact = new Contact("24", "2", "4", "2424242424", "My address is exactly thirty c");
		assertTrue(contact.getAddress().length()==30);
	}

// -------------------   tests for the setter method for the contact's firstName  --------------------------
	
	@Test
	void testSetFirstNameIsNull() {
		Contact contact = new Contact("0123456789", "Justin", "Starr", "0123456789", "My Home Address");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setFirstName(null);
		});
	}
	
	@Test
	void testSetFirstNameIsNotNull() {
		Contact contact = new Contact("25", "2", "5", "2525252525", "25's address");
		contact.setFirstName("2");
		assertNotNull(contact.getFirstName());	
	}
	
	@Test
	void testSetFirstNameIsTooLong() {
		Contact contact = new Contact("0123456789", "Justin", "Starr", "0123456789", "My Home Address");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setFirstName("JustinJustin");
		});
	}
	
	@Test
	void testSetFirstNameIsLessThan10Characters() {
		Contact contact = new Contact("26", "2", "6", "2626262626", "26's address");
		contact.setFirstName("2626");
		assertTrue(contact.getFirstName().length()<10);
	}
	
	@Test 
	void testSetFirstNameIsEqualTo10Characters() {
		Contact contact = new Contact("27", "2", "7", "2727272727", "27's address");
		contact.setFirstName("2727272727");
		assertTrue(contact.getFirstName().length()==10);
	}
	
	@Test
    void TestSetFirstNameSets() {
        Contact contact = new Contact("0123456789", "Justin", "Starr", "0123456789", "My Home Address");
        contact.setFirstName("My Friend");
        assertEquals(contact.getFirstName(), "My Friend");
    }
// -------------------   tests for the setter method for the contact's lastName  --------------------------
	
	@Test
	void testSetLastNameIsNull() {
		Contact contact = new Contact("0123456789", "Justin", "Starr", "0123456789", "My Home Address");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setLastName(null);
		});
	}
	
	@Test
	void testSetLastNameIsNotNull() {
		Contact contact = new Contact("28", "2", "8", "2828282828", "28's address");
		contact.setLastName("2828");
		assertNotNull(contact.getLastName());
	}
	
	@Test
	void testSetLastNameIsTooLong() {
		Contact contact = new Contact("0123456789", "Justin", "Starr", "0123456789", "My Home Address");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setLastName("StarrStarrStarr");
		});
	}
	
	@Test
	void testSetlastNameIsLessThan10Characters() {
		Contact contact = new Contact("29", "2", "9", "2929292929", "29's address");
		contact.setLastName("2929");
		assertTrue(contact.getLastName().length()<10);
	}
	
	@Test
	void testSetLastNameIsEqualTo10Characters() {
		Contact contact = new Contact("30", "3", "0", "3030303030", "30's address");
		contact.setLastName("3030303030");
		assertTrue(contact.getLastName().length()==10);
	}
	
	@Test
    void TestSetLastNameIsSet() {
        Contact contact = new Contact("0123456789", "Justin", "Starr", "0123456789", "My Home Address");
        contact.setLastName("Starr");
        assertEquals(contact.getLastName(), "Starr");
    }
	
	// -------------------   tests for the setter method for the contact's phone  --------------------------
	@Test
	void testSetPhoneIsNull() {
		Contact contact = new Contact("0123456789", "Justin", "Starr", "0123456789", "My Home Address");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setPhone(null);
		});
	}
	
	@Test
	void testSetPhoneIsNotNull() {
		Contact contact = new Contact("31", "3", "1", "3131313131", "31's address");
		contact.setPhone("1313131313");
		assertNotNull(contact.getPhone());
	}
	
	@Test
	void testSetPhoneIsTooLong() {
		Contact contact = new Contact("0123456789", "Justin", "Starr", "0123456789", "My Home Address");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setPhone("01234567890");
		});
	}
	
	@Test
	void testSetPhoneIsTooFewCharacters() {
		Contact contact = new Contact("32", "3", "2", "3232323232", "32's address");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setPhone("3232");
		});
	}
	
	@Test
	void testSetPhoneIsExactly10Characters() {
		Contact contact = new Contact("33", "3", "3", "3333333333", "34's address");
		contact.setPhone("1231231231");
		assertTrue(contact.getPhone().length()==10);
	}
	
	@Test
    void TestSetPhoneIsSet() {
        Contact contact = new Contact("0123456789", "Justin", "Starr", "0123456789", "My Home Address");
        contact.setPhone("0123456789");
        assertEquals(contact.getPhone(), "0123456789");
    }
	
	// -------------------   tests for the setter method for the contact's address  --------------------------
	
	@Test
	void testSetAddressisNull() {
		Contact contact = new Contact("0123456789", "Justin", "Starr", "0123456789", "My Home Address");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setAddress(null);
		});
	}
	
	@Test 
	void testSetAddressIsNotNull() {
		Contact contact = new Contact("35", "3", "5", "3535353535", "35's address");
		contact.setAddress("35's new address");
		assertNotNull(contact.getAddress());
	}
	
	@Test
	void testSetAddressIsTooLong() {
		Contact contact = new Contact("0123456789", "Justin", "Starr", "0123456789", "My Home Address");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setAddress("My Home Address My Home Address");	
		});
	}
	
	@Test
	void testSetAddressIsNot30Characters() {
		Contact contact = new Contact("36", "3", "6", "3636363636", "36's address");
		contact.setAddress("36's new address");
		assertTrue(contact.getAddress().length()<30);
	}
	
	@Test
	void testSetAddressIsExactle30Characters() {
		Contact contact = new Contact("36", "3", "6", "3636363636", "36's address");
		contact.setAddress("My address is exactly 30 chars");
		assertTrue(contact.getAddress().length()==30);
	}
	
	@Test
    void TestSetAddressIsSet() {
        Contact contact = new Contact("0123456789", "Justin", "Starr", "0123456789", "My Home Address");
        contact.setAddress("My Home Address");
        assertEquals(contact.getAddress(), "My Home Address");
    }

	
	// -----------------------------      test for the toString method     ---------------------------------
	
	@Test
    void testStringToString() {
      	Contact contact = new Contact("0123456789", "My", "Friend", "0123456789", "My Friends Address");
      	assertEquals(contact.toString(), "Contact [Id=" + "0123456789" + ", First Name=" + "My" + ", Last Name=" + "Friend" + ", Phone Number= " + "0123456789" +", Address=" + "My Friends Address" + "]");
    }
	
		
		
	
}
