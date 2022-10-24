package contact_package;

import static contact_package.ContactService.contactInfo;
import static contact_package.ContactService.initializeContactInfo;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ContactServiceTest {

    ContactService contactService;
    private Contact contact;

    @BeforeAll
    public void setupAll() {
        System.out.println("Should Print Before All Tests");
    }

    @BeforeEach
    void setUp() {
        contactService = new ContactService();
    }

    @Test
    void testFindContactByID() {
        initializeContactInfo();

        assertTrue(contactService.findContactByID("TestID1"));
        assertTrue(contactService.findContactByID("Contact001"));
        assertTrue(contactService.findContactByID("Contact002"));

        assertFalse(contactService.findContactByID("Contact004"));
    }

    @Test
    void testAddContact() {
        initializeContactInfo();
        Contact contact1 = new Contact("Contact003", "Steven", "Richardson", "1234567890", "1000 Rock Ct Jackson MI 70000");
        Contact contact2 = new Contact("Contact005", "Steven", "Richardson", "1234567890", "1000 Rock Ct Jackson MI 70000");

        new ContactService().addNewContact(contact1);
        new ContactService().addNewContact(contact2);

        assertEquals(5, contactInfo.size());
    }

    @Test
    void testDeleteContact() {
        initializeContactInfo();
        Contact contact1 = new Contact("Contact003", "Steven", "Richardson", "1234567890", "1000 Rock Ct Jackson MI 70000");
        Contact contact2 = new Contact("Contact005", "Steven", "Richardson", "1234567890", "1000 Rock Ct Jackson MI 70000");

        contactService.deleteContact(contact1);
        contactService.deleteContact(contact2);

        assertEquals(3, contactInfo.size());
    }

    @Test
    void updateFirstName() {
        initializeContactInfo();

        var contactUpdate = new Contact("Contact003", "Steven", "Richardson", "1234567890", "1000 Rock Ct Jackson MI 70000");
        var firstNameUpdate = new ContactService(contactUpdate);
        firstNameUpdate.updateFirstName("Richard");

        assertEquals("Richard", contactUpdate.getFirstName());
        assertNotEquals("Steven", contactUpdate.getFirstName());

    }

    @Test
    void updateLastName() {
        initializeContactInfo();

        var contactUpdate = new Contact("Contact003", "Steven", "Richardson", "1234567890", "1000 Rock Ct Jackson MI 70000");
        var lastNameUpdate = new ContactService(contactUpdate);
        lastNameUpdate.updateLastName("Boyd");

        assertEquals("Boyd", contactUpdate.getLastName());
        assertNotEquals("Richardson", contactUpdate.getLastName());
    }

    @Test
    void updatePhone() {
        initializeContactInfo();

        var contactUpdate = new Contact("Contact003", "Steven", "Richardson", "1234567890", "1000 Rock Ct Jackson MI 70000");
        var phoneUpdate = new ContactService(contactUpdate);
        phoneUpdate.updatePhone("0987654321");

        assertEquals("0987654321", contactUpdate.getPhone());
        assertNotEquals("1234567890", contactUpdate.getPhone());
    }

    @Test
    void updateAddress() {
        initializeContactInfo();

        var contactUpdate = new Contact("Contact003", "Steven", "Richardson", "1234567890", "1000 Rock Ct Jackson MI 70000");
        var addressUpdate = new ContactService(contactUpdate);
        addressUpdate.updateAddress("9999 Fall St Phoenix AZ 00007");

        assertEquals("9999 Fall St Phoenix AZ 00007", contactUpdate.getAddress());
        assertNotEquals("1000 Rock Ct Jackson MI 70000", contactUpdate.getAddress());
    }

    @AfterEach
    public void tearDown() {
        System.out.println("Should Execute After Each Test");
    }

    @AfterAll
    public void tearDownAll() {
        System.out.println("Should be executed at the end of the Test");
    }

}

