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
}