package edu.uoc.pac2;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RomanConverterTest {

    @Test
    @Order(1)
    @DisplayName("Minimum - romanCharToInt")
    public void testRomanCharToInt() {
        assertEquals(1, RomanConverter.romanCharToInt('I'));
        assertEquals(5, RomanConverter.romanCharToInt('V'));
        assertEquals(10, RomanConverter.romanCharToInt('X'));
        assertEquals(50, RomanConverter.romanCharToInt('L'));
        assertEquals(100, RomanConverter.romanCharToInt('C'));
        assertEquals(500, RomanConverter.romanCharToInt('D'));
        assertEquals(1000, RomanConverter.romanCharToInt('M'));

        assertEquals(-1, RomanConverter.romanCharToInt('A'));
        assertEquals(-1, RomanConverter.romanCharToInt('B'));
        assertEquals(-1, RomanConverter.romanCharToInt('i'));
        assertEquals(-1, RomanConverter.romanCharToInt('c'));
    }

    @Test
    @Order(2)
    @DisplayName("Advanced - romanToDecimal")
    public void testRomanToDecimal() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> RomanConverter.romanToDecimal(null));
        assertEquals("Invalid Roman numeral format.", ex.getMessage());

        ex = assertThrows(IllegalArgumentException.class, () -> RomanConverter.romanToDecimal(""));
        assertEquals("Invalid Roman numeral format.", ex.getMessage());

        ex = assertThrows(IllegalArgumentException.class, () -> RomanConverter.romanToDecimal("AAA"));
        assertEquals("Invalid Roman numeral format.", ex.getMessage());

        assertEquals(1, RomanConverter.romanToDecimal("I"));
        assertEquals(5, RomanConverter.romanToDecimal("V"));
        assertEquals(10, RomanConverter.romanToDecimal("X"));
        assertEquals(50, RomanConverter.romanToDecimal("L"));
        assertEquals(100, RomanConverter.romanToDecimal("C"));
        assertEquals(500, RomanConverter.romanToDecimal("D"));
        assertEquals(1000, RomanConverter.romanToDecimal("M"));

        assertEquals(2, RomanConverter.romanToDecimal("II"));
        assertEquals(3, RomanConverter.romanToDecimal("III"));
        assertEquals(4, RomanConverter.romanToDecimal("IV"));
        assertEquals(9, RomanConverter.romanToDecimal("IX"));
        assertEquals(40, RomanConverter.romanToDecimal("XL"));
        assertEquals(90, RomanConverter.romanToDecimal("XC"));
        assertEquals(400, RomanConverter.romanToDecimal("CD"));
        assertEquals(900, RomanConverter.romanToDecimal("CM"));

        assertEquals(58, RomanConverter.romanToDecimal("LVIII"));
        assertEquals(1994, RomanConverter.romanToDecimal("MCMXCIV"));

        assertEquals(3999, RomanConverter.romanToDecimal("MMMCMXCIX"));
    }

    @Test
    @Order(3)
    @DisplayName("Advanced - decimalToRoman")
    public void testDecimalToRoman() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> RomanConverter.decimalToRoman(0));
        assertEquals("Number must be between 1 and 3999.", ex.getMessage());

        ex = assertThrows(IllegalArgumentException.class, () -> RomanConverter.decimalToRoman(-5));
        assertEquals("Number must be between 1 and 3999.", ex.getMessage());

        ex = assertThrows(IllegalArgumentException.class, () -> RomanConverter.decimalToRoman(4000));
        assertEquals("Number must be between 1 and 3999.", ex.getMessage());

        assertEquals("I", RomanConverter.decimalToRoman(1));
        assertEquals("V", RomanConverter.decimalToRoman(5));
        assertEquals("X", RomanConverter.decimalToRoman(10));
        assertEquals("L", RomanConverter.decimalToRoman(50));
        assertEquals("C", RomanConverter.decimalToRoman(100));
        assertEquals("D", RomanConverter.decimalToRoman(500));
        assertEquals("M", RomanConverter.decimalToRoman(1000));

        assertEquals("II", RomanConverter.decimalToRoman(2));
        assertEquals("III", RomanConverter.decimalToRoman(3));
        assertEquals("IV", RomanConverter.decimalToRoman(4));
        assertEquals("IX", RomanConverter.decimalToRoman(9));
        assertEquals("XL", RomanConverter.decimalToRoman(40));
        assertEquals("XC", RomanConverter.decimalToRoman(90));
        assertEquals("CD", RomanConverter.decimalToRoman(400));
        assertEquals("CM", RomanConverter.decimalToRoman(900));

        assertEquals("LVIII", RomanConverter.decimalToRoman(58));
        assertEquals("MCMXCIV", RomanConverter.decimalToRoman(1994));

        assertEquals("MMMCMXCIX", RomanConverter.decimalToRoman(3999));
    }

}
