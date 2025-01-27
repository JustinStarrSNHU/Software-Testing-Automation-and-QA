package Application;

public class Contact {
	private String Id;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
	public Contact(String Id, String firstName, String lastName, String phone, String address) {
		
		// the following IllegalArgumentExceptions are thrown if when a contact object that is created does not meet specifications
		
		
		
		if(Id == null || Id.length()>10) {
			throw new IllegalArgumentException("Invalid Id"); // The Id cannot be null and cannot be greater than 10 characters in length
		}
		if(firstName == null || firstName.length()>10) {
			throw new IllegalArgumentException("Invalid First Name"); //  The firstName cannot be null and cannot be greater than 10 characters in length
		}
		if(lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid Last Name");  //  The lastName cannot be null and cannot be greater than 10 characters in length
		}
		if(phone == null || phone.length() != 10) {
			throw new IllegalArgumentException("Invalid Phone");  //  The phone cannot be null and must be exactly 10 characters in length
		}
		if(address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid Address"); //  The address cannot be null and cannot be greater than 30 characters in length
		}
		
		// if not exceptions are thrown, the objects attributes are set.
		
		this.Id = Id;                   
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
		
	}
	
	// getter method for the contact's Id. There is no setter because the Id shall not be updatable.
	public String getId() {       
		return Id;
	}
	
	// getter method for the contact's first name.
	public String getFirstName() { 
		return firstName;
	}
	
	// setter method for fistName because it is updatable.
	public void setFirstName(String firstName) {
		if(firstName == null || firstName.length()>10) {
			throw new IllegalArgumentException("Invalid First Name");  // exception is thrown if the firstName being updated is null or greater than 10 characters.
		}
		this.firstName = firstName; // if no exception is thrown, the contact's first name is updated.
	}
	
	// getter method for the contact's last name.
	public String getLastName() {
		return lastName;
	}
	
	// setter method for the contact's last name because it is updatable.
	public void setLastName(String lastName) {
		if(lastName == null || lastName.length()>10) {
			throw new IllegalArgumentException("Invalid Last Name"); // exception is thrown if the lastName being updated is null or greater than 10 characters.
		}
		this.lastName = lastName; // if no exception is thrown, the contact's last name is updated
	}
	
	// getter method for the contact's phone number
	public String getPhone() {
		return phone;
	}
	
	// setter method for the contact's phone number because it is updatable.
	public void setPhone(String phone) {
		if(phone == null || phone.length()!=10) {
			throw new IllegalArgumentException("Invalid Phone"); // exception is thrown if the phone number being updated is null or not exactly 10 characters.
		}
		this.phone = phone; // if no exception is thrown, the contact's phone number is updated.
	}
	
	// getter method for the contact's address
	public String getAddress() {
		return address;
	}
	
	// setter method for the contact's address
	public void setAddress(String address) {
		if(address == null || address.length()>30) {
			throw new IllegalArgumentException("Invalid Address"); // exception is thrown if the address being updated is null or greater than 30 characters.
		}
		this.address = address; // if no exception is thrown, the contact's address is updated.
	}
	
	// toString method creates a readable string with the contact's set attributes
	public String toString() {
		return "Contact [Id=" + Id + ", First Name=" + firstName + ", Last Name=" + lastName + ", Phone Number= " + phone +", Address=" + address + "]";
	}
	
}