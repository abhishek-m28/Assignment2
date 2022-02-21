package amohabe.asu.edu;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CaesarTest {

    private Caesar caesarCipher = new Caesar();

    @Test
    void testCipherTextOffset2() {
        assertEquals("cdjkujgmoqjcdg", caesarCipher.cipher("abhishekmohabe", 2));
    }

    @Test
    void testEmptyCipher() {
        assertEquals("", caesarCipher.cipher("", 7));
    }

    @Test
    void testDecryptOffset2(){
        assertEquals("abhishekmohabe", caesarCipher.decrypt("cdjkujgmoqjcdg", 2));
    }

    @Test
    void testDecryptEmpty(){
        assertEquals("", caesarCipher.decrypt("", 2));
    }
}