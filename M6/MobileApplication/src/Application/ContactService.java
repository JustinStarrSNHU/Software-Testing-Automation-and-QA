package Application;

import java.util.List;
import java.util.ListIterator;
import java.util.ArrayList;


// ContactService Class
public class ContactService {
	
	// Array List for Contacts
	private static List<Contact> contacts = new ArrayList<Contact>();
	
	// addContact Method. Checks if contact already exists in Contact List. If Contact does not exist, it creates a new contact with the passed in strings
	public Contact addContact(String Id, String firstName, String lastName, String phone, String address) {
		
		Contact contact = null; 
		
		Contact tempContact = null;
		
		// used to iterate over the contacts list and make comparisons				
		ListIterator<Contact> litr = contacts.listIterator();
		
		while(litr.hasNext()) {
			
			tempContact = litr.next();
			
			if(Id != null && Id.equals(tempContact.getId())) { 
				
				throw new IllegalArgumentException("Contact ID Already In Use"); // Exception is thrown if the Id already exists
			}
		}
		
		if(contact==null) { // if the Id does not already exist
			
			contact = new Contact(Id, firstName, lastName, phone, address); // creates new Contact. Parameters are checked in Contact Class.
			contacts.add(contact); // adds the creates contact to the list of contacts.
		}
				
		return contact; // return type contact.
	}
	
	// deleteContact method. deletes a contact based on the Id string that is passed in if the Id exists.
	public Contact deleteContact(String Id) {
		
		Contact contact = null;
		
		Contact tempContact = null;
		
		ListIterator<Contact> litr = contacts.listIterator();
		
		if(Id == null || Id.length()>10) {
	          throw new IllegalArgumentException("Invalid ID"); // exception thrown if the passed in Id string is greater than 10 characters or is null.
	          
	    }
		
		//checks if the passed in Id exists. If the Id exists, the contact is removed from the list of contacts.
		while(litr.hasNext()) {
			tempContact = litr.next();
			if(Id==tempContact.getId()) {
				contact = tempContact;
				contacts.remove(contact);
				return contact;  //returns type contact once contact is removed.
			}
		}
		
		return contact;
		
		//return contact; // returns type contact when contact Id is not found
	}
	
	// updateFirstName method. Updates a contacts first name based on the unique Id passed in with the firstName that is passed in.
	public Contact updateFirstName(String Id, String firstName) {
		
		Contact contact = null;
		
		Contact tempContact = null;
		
		ListIterator<Contact> litr = contacts.listIterator();
		
		if(Id == null || Id.length()>10) {
	          throw new IllegalArgumentException("Invalid ID"); // exception thrown if the passed in Id string is greater than 10 characters or is null.
	          
	    }
		if(firstName == null || firstName.length()>10) {
			throw new IllegalArgumentException("Invalid First Name"); // exception thrown if the passed in firstName string is greater than 10 characters or is null.
		}
		
		//checks if the passed in Id exists. If the Id exists the firstName for that contact is updated with the passed in firstName.
		while(litr.hasNext()) {
			tempContact = litr.next();
			if(Id == tempContact.getId()) {
				tempContact.setFirstName(firstName);
				contact = tempContact;
				return contact; // returns type contact once the firstName is updated.
			}
		}
		return contact; // returns type contact if the contact Id is not found. 	
	}
	
	// updateLastName method. Updates a contacts last name based on the unique Id passed in with the lastName that is passed in.
	public Contact updateLastName(String Id, String lastName) {
		
		Contact contact = null;
		
		Contact tempContact = null;
		
		ListIterator<Contact> litr = contacts.listIterator(); 
		
		if(Id == null || Id.length()>10) {
	          throw new IllegalArgumentException("Invalid ID"); // exception thrown if the passed in Id string is greater than 10 characters or is null.
	          
	    }
		if(lastName == null || lastName.length()>10) {
			throw new IllegalArgumentException("Invalid Last Name"); // exception thrown if the passed in lastName string is greater than 10 characters or is null.
		}
		
		//checks if the passed in Id exists. If the Id exists the lastName for that contact is updated with the passed in lastName.
		while(litr.hasNext()) {
			tempContact = litr.next();
			if(Id == tempContact.getId()) {
				tempContact.setLastName(lastName);
				contact = tempContact;
				return contact; // return type contact once the lastName is updated.
			}
		}
		return contact; // returns type contact if the Id is not found.	
	}
	
	// updatePhone method. Updates a contacts phone number based on the unique Id passed in with the phone that is passed in.
	public Contact updatePhone(String Id, String phone) {
		
		Contact contact = null;
		
		Contact tempContact = null;
		
		ListIterator<Contact> litr = contacts.listIterator();
		
		if(Id == null || Id.length()>10) {
	          throw new IllegalArgumentException("Invalid ID"); // exception thrown if the passed in Id string is greater than 10 characters or is null.
	          
	    }
		if(phone == null || phone.length()!=10) {
			throw new IllegalArgumentException("Invalid Phone"); // exception thrown if the passed in phone is greater than 10 characters or is null.
		}
		
		//checks if the passed in Id exists. If the Id exists the phone for that contact is updated with the passed in phone.
		while(litr.hasNext()) {
			tempContact = litr.next();
			if(Id == tempContact.getId()) {
				tempContact.setPhone(phone);
				contact = tempContact;
				return contact; // returns type contact once the phone is updated.
			}
		}
		return contact; // returns type contact if the Id is not found. 	
	}
	
	// updateAddress method. Updates a contacts address based on the unique Id that is passed in with the address that is passed in.
	public Contact updateAddress(String Id, String address) {
		
		Contact contact = null;
		
		Contact tempContact = null;
		
		ListIterator<Contact> litr = contacts.listIterator();
		
		if(Id == null || Id.length()>10) {
	          throw new IllegalArgumentException("Invalid ID"); // throws exception if the passed in Id is greater than 10 characters or is null.
	          
	    }
		if(address == null || address.length()>30) {
			throw new IllegalArgumentException("Invalid Address"); // throws exception if the passed in address is greater than 30 characters or is null.
		}
		
		//checks if the passed in Id exists. If the Id exists the address for that contact is updated with the passed in address.
		while(litr.hasNext()) {
			tempContact = litr.next();
			if(Id == tempContact.getId()) {
				tempContact.setAddress(address);
				contact = tempContact;
				return contact; // returns type contact once the address is updated.
			}
		}
		return contact; // returns type contact if the Id is not found. 	
	}
}