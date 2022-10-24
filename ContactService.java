package contact_package;

import java.util.ArrayList;

public class ContactService extends Contact {

	// Define variables
	static ArrayList<Contact> contactInfo = new ArrayList<>();           // Initializes ArrayList of contacts from Contact class
	private Contact contact;
	
	public ContactService() {}

	public ContactService(Contact contact) {
		this.contact = contact;
	}

	public static void initializeContactInfo() {
		Contact contactDefault = new Contact("TestID1", "TestFirst", "TestLast", "0123456789", "TestAddress");
		Contact contactTest1 = new Contact("Contact001", "Jacob", "Adams", "7579531487", "2520 Gold Rd Norfolk VA 23321");
		Contact contactTest2 = new Contact("Contact002", "Michael", "Mariveles", "2531441797", "1000 Barn St Suffolk VA 22100");
		contactInfo.add(contactDefault);
		contactInfo.add(contactTest1);
		contactInfo.add(contactTest2);

	}

	public boolean findContactByID(String contactID) {
		for (Contact contact : contactInfo) {
			if (contact.getContactID().equals(contactID)) {
				return true;
			}
		}
		return false;
	}

	public void addNewContact(Contact contact) {
		if (findContactByID(getContactID())) {
			System.out.println("Contact Already Exists.");
		}
		else {
			contactInfo.add(contact);
		}

	}

	public void deleteContact(Contact contact) {
			contactInfo.remove(contact);
	}

	public void updateFirstName(String firstName) {
		contact.setFirstName(firstName);
	}

	public void updateLastName(String lastName) {
		contact.setLastName(lastName);
	}

	public void updatePhone(String phone) {
		contact.setPhone(phone);
	}

	public void updateAddress(String address) {
		contact.setAddress(address);
	}
}
