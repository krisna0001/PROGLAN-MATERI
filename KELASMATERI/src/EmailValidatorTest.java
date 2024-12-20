import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailValidatorTest {

    @Test
    public void testValidEmails() {
        assertTrue(EmailValidator.isValidEmail("test@example.com"));
        assertTrue(EmailValidator.isValidEmail("user.name+tag@domain.co.id"));
        assertTrue(EmailValidator.isValidEmail("valid_email123@gmail.com"));
        assertTrue(EmailValidator.isValidEmail("example@sub.domain.com"));
    }

    @Test
    void testInvalidEmails() {
        assertFalse(EmailValidator.isValidEmail("plainaddress"));             // Tidak ada '@'
        assertFalse(EmailValidator.isValidEmail("@missingusername.com"));    // Tidak ada username
        assertFalse(EmailValidator.isValidEmail("username@.com"));           // Tidak ada nama domain
        assertFalse(EmailValidator.isValidEmail("username@domain..com"));    // Domain ganda
        assertFalse(EmailValidator.isValidEmail("username@domain,com"));     // Karakter ilegal ','
    }

    @Test
    void testNullAndEmptyEmails() {
        assertFalse(EmailValidator.isValidEmail(null));  // Null
        assertFalse(EmailValidator.isValidEmail(""));    // String kosong
    }

    @Test
    void testEmailsWithSpecialCharacters() {
        assertFalse(EmailValidator.isValidEmail("user@domain.com!"));    // Karakter ilegal '!'
        assertFalse(EmailValidator.isValidEmail("user@domain#.com"));    // Karakter ilegal '#'
        assertFalse(EmailValidator.isValidEmail("user@domain$.com"));    // Karakter ilegal '$'
    }
}
