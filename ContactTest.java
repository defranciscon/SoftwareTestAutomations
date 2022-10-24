package contact_package;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ContactTest {

    Contact contact;

    @BeforeAll
    static void setupAll() {
        System.out.println("Should Print Before All Tests");
    }

    @BeforeEach
    void setUp() {
        contact = new Contact();
    }

    @Test
    void testContactVariableMatchesAssignment() {
        var contact = new Contact("Contact003", "Steven", "Richardson", "1234567890", "1000 Rocky Ct Jackson MI 70000");
        assertEquals("Contact003", contact.getContactID());
        assertNotEquals("Contact003 ", contact.getContactID());

        assertEquals("Steven", contact.getFirstName());
        assertNotEquals("Stephen", contact.getFirstName());

        assertEquals("Richardson", contact.getLastName());
        assertNotEquals("richardson", contact.getLastName());

        assertEquals("1234567890", contact.getPhone());
        assertNotEquals("2134567890", contact.getPhone());

        assertEquals("1000 Rocky Ct Jackson MI 70000", contact.getAddress());
        assertNotEquals("1000 Rocky Ct Jackson MA 70000", contact.getAddress());

    }

    @Test
    void testIllegalArgumentExceptionContact() {
        String contactID01 = "IllegalID01";
        String contactFirstName01 = "Steven";
        String contactLastName01 = "Richardson";
        String contactPhone01 = "1234567890";
        String contactAddress01 = "1000 Rocky Ct Jackson MA 70000";

        assertThrows(IllegalArgumentException.class, () -> {
            var contactIDTest = new Contact(contactID01, contactFirstName01, contactLastName01, contactPhone01, contactAddress01);
        });

        String contactID02 = "LegalID01";
        String contactFirstName02 = "Steven-alfonso";
        String contactLastName02 = "Richardson";
        String contactPhone02 = "1234567890";
        String contactAddress02 = "1000 Rocky Ct Jackson MA 70000";

        assertThrows(IllegalArgumentException.class, () -> {
            var contactFirstNameTest = new Contact(contactID02, contactFirstName02, contactLastName02, contactPhone02, contactAddress02);
        });

        String contactID03 = "LegalID01";
        String contactFirstName03 = "Steven";
        String contactLastName03 = "Richard-son";
        String contactPhone03 = "1234567890";
        String contactAddress03 = "1000 Rocky Ct Jackson MA 70000";

        assertThrows(IllegalArgumentException.class, () -> {
            var contactLastNameTest = new Contact(contactID03, contactFirstName03, contactLastName03, contactPhone03, contactAddress03);
        });

        String contactID04 = "LegalID01";
        String contactFirstName04 = "Steven";
        String contactLastName04 = "Richardson";
        String contactPhone04 = "01234567890";
        String contactAddress04 = "1000 Rocky Ct Jackson MI 70000";

        assertThrows(IllegalArgumentException.class, () -> {
            var contactPhoneTest = new Contact(contactID04, contactFirstName04, contactLastName04, contactPhone04, contactAddress04);
        });

        String contactID05 = "LegalID01";
        String contactFirstName05 = "Steven";
        String contactLastName05 = "Richardson";
        String contactPhone05= "1234567890";
        String contactAddress05 = "10001 Rocky Ct Jackson MI 70000";

        assertThrows(IllegalArgumentException.class, () -> {
            var contactLastNameTest = new Contact(contactID05, contactFirstName05, contactLastName05, contactPhone05, contactAddress05);
        });
    }

    @Test
    void testContactEmptyStrings() {
        assertThrows(IllegalArgumentException.class, () -> {
            var contactIDEmpty = new Contact("", "Steven", "Richardson", "1234567890", "1000 Rocky Ct Jackson MI 70000");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            var contactFirstNameEmpty = new Contact("Contact003", "          ", "Richardson", "1234567890", "1000 Rocky Ct Jackson MI 70000");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            var contactLastNameEmpty = new Contact("Contact003", "Steven", "          ", "1234567890", "1000 Rocky Ct Jackson MI 70000");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            var contactPhoneEmpty = new Contact("Contact003", "Steven", "Richardson", "          ", "1000 Rocky Ct Jackson MI 70000");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            var contactAddressEmpty = new Contact("Contact003", "Steven", "Richardson", "1234567890", "                              ");
        });

    }

    @Test
    void testContactSetPlusGet() {
        contact.setContactID("Contact004");
        contact.setFirstName("Stephen");
        contact.setLastName("Stevenson");
        contact.setPhone("0987654321");
        contact.setAddress("1000 Rocky Ct Jackson MI 70000");

        contact = new Contact(contact.getContactID(), contact.getFirstName(), contact.getLastName(), contact.getPhone(), contact.getAddress());

        assertEquals("Contact004", contact.getContactID());
        assertEquals("Stephen", contact.getFirstName());
        assertEquals("Stevenson", contact.getLastName());
        assertEquals("0987654321", contact.getPhone());
        assertEquals("1000 Rocky Ct Jackson MI 70000", contact.getAddress());
    }

    @AfterEach
    public void tearDown() {
        System.out.println("Should Execute After Each Test");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("Should be executed at the end of the Test");
    }
}