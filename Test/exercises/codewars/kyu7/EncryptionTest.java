package exercises.codewars.kyu7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Ross Khapilov
 * @version 1.0 15.06.2018
 */
class EncryptionTest {

    @Test
    public void testEncrypt() {
        // assertEquals("expected", "actual");
        assertEquals("This is a test!", Encryption.encrypt("This is a test!", 0));
        assertEquals("hsi  etTi sats!", Encryption.encrypt("This is a test!", 1));
        assertEquals("s eT ashi tist!", Encryption.encrypt("This is a test!", 2));
        assertEquals(" Tah itse sits!", Encryption.encrypt("This is a test!", 3));
        assertEquals("This is a test!", Encryption.encrypt("This is a test!", 4));
        assertEquals("This is a test!", Encryption.encrypt("This is a test!", -1));
        assertEquals("hskt svr neetn!Ti aai eyitrsig", Encryption.encrypt("This kata is very interesting!", 1));
    }

    @Test
    public void testDecrypt() {
        // assertEquals("expected", "actual");
        assertEquals("This is a test!", Encryption.decrypt("This is a test!", 0));
        assertEquals("This is a test!", Encryption.decrypt("hsi  etTi sats!", 1));
        assertEquals("This is a test!", Encryption.decrypt("s eT ashi tist!", 2));
        assertEquals("This is a test!", Encryption.decrypt(" Tah itse sits!", 3));
        assertEquals("This is a test!", Encryption.decrypt("This is a test!", 4));
        assertEquals("This is a test!", Encryption.decrypt("This is a test!", -1));
        assertEquals("This kata is very interesting!", Encryption.decrypt("hskt svr neetn!Ti aai eyitrsig", 1));
    }

    @Test
    public void testNullOrEmpty() {
        // assertEquals("expected", "actual");
        assertEquals("", Encryption.encrypt("", 0));
        assertEquals("", Encryption.decrypt("", 0));
        assertEquals(null, Encryption.encrypt(null, 0));
        assertEquals(null, Encryption.decrypt(null, 0));
    }
}