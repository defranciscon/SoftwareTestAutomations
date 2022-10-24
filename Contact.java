package contact_package;

public class Contact {


	private String id;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;

	public Contact() {}

	// constructor
	public Contact(String contactID, String firstName, String lastName, String phone, String address) {
		id = contactID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;

			if(contactID == null || contactID.length() > 10) {
				throw new IllegalArgumentException("Invalid contactID");
			}
			if(firstName == null || firstName.length() > 10) {
				throw new IllegalArgumentException("Invalid First Name");
			}
			if(lastName == null || lastName.length() > 10) {
				throw new IllegalArgumentException("Invalid Last Name");
			}
			if(phone == null || phone.length() > 10) {
				throw new IllegalArgumentException("Invalid Phone");
			}
			if(address == null || address.length() > 30) {
				throw new IllegalArgumentException("Invalid Address");
			}
	}

	public String getContactID() {
		return id;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public String getPhone() {
		return this.phone;
	}

	public String getAddress() {
		return this.address;
	}

	public void setContactID(String contactID) {
		this.id = contactID;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String toString() {
		return id + "; " + firstName + "; " + lastName + "; " + phone + "; " + address;
	}

}
















