package edu.uoc.pac2;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FirewallRuleTest {

    private ByteArrayOutputStream outContent;

    @BeforeEach
    public void setUpStreams() {
        restoreStreams();
    }

    @BeforeEach
    public void restoreStreams() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    @Order(1)
    @DisplayName("Exception setRuleName")
    public void testExceptionSetRuleName() {
        Exception exception = assertThrows(Exception.class, () -> new FirewallRule(null, "192.1.1.168", "90.254.10.10", "TCP", 8080, "ALLOW", true, LocalDate.now(), LocalDate.now().plusDays(10)));
        assertFalse(exception instanceof IllegalArgumentException);
        assertFalse(exception instanceof NullPointerException);
        assertEquals("[ERROR] Rule name cannot be null, empty or contain only whitespace.", exception.getMessage());

        assertEquals("", outContent.toString());
        restoreStreams();

        try {
            FirewallRule rule = new FirewallRule("Test Rule", "192.1.1.168", "90.254.10.10", "TCP", 8080, "ALLOW", true, LocalDate.now(), LocalDate.now().plusDays(10));
            exception = assertThrows(Exception.class, () -> rule.setRuleName(null));
            assertFalse(exception instanceof IllegalArgumentException);
            assertFalse(exception instanceof NullPointerException);
            assertEquals("[ERROR] Rule name cannot be null, empty or contain only whitespace.", exception.getMessage());

            assertEquals("", outContent.toString());
            restoreStreams();
        } catch (Exception e) {
            fail("Exception not expected");
        }
    }

    @Test
    @Order(2)
    @DisplayName("Exception setSourceIP")
    public void testExceptionSetSourceIP() {
        Exception exception = assertThrows(Exception.class, () -> new FirewallRule("Test Rule", null, "90.254.10.10", "TCP", 8080, "ALLOW", true, LocalDate.now(), LocalDate.now().plusDays(10)));
        assertFalse(exception instanceof IllegalArgumentException);
        assertFalse(exception instanceof NullPointerException);
        assertEquals("[ERROR] Source IP must be a valid IPv4 address.", exception.getMessage());

        assertEquals("", outContent.toString());
        restoreStreams();

        try {
            FirewallRule rule = new FirewallRule("Test Rule", "192.1.1.168", "90.254.10.10", "TCP", 8080, "ALLOW", true, LocalDate.now(), LocalDate.now().plusDays(10));
            exception = assertThrows(Exception.class, () -> rule.setSourceIP(null));
            assertFalse(exception instanceof IllegalArgumentException);
            assertFalse(exception instanceof NullPointerException);
            assertEquals("[ERROR] Source IP must be a valid IPv4 address.", exception.getMessage());

            assertEquals("", outContent.toString());
            restoreStreams();
        } catch (Exception e) {
            fail("Exception not expected");
        }
    }

    @Test
    @Order(3)
    @DisplayName("Exception setDestinationIP")
    public void testExceptionSetDestinationIP() {
        Exception exception = assertThrows(Exception.class, () -> new FirewallRule("Test Rule", "192.1.1.168", null, "TCP", 8080, "ALLOW", true, LocalDate.now(), LocalDate.now().plusDays(10)));
        assertFalse(exception instanceof IllegalArgumentException);
        assertFalse(exception instanceof NullPointerException);
        assertEquals("[ERROR] Destination IP must be a valid IPv4 address.", exception.getMessage());

        assertEquals("", outContent.toString());
        restoreStreams();

        try {
            FirewallRule rule = new FirewallRule("Test Rule", "192.1.1.168", "90.254.10.10", "TCP", 8080, "ALLOW", true, LocalDate.now(), LocalDate.now().plusDays(10));
            exception = assertThrows(Exception.class, () -> rule.setDestinationIP(null));
            assertFalse(exception instanceof IllegalArgumentException);
            assertFalse(exception instanceof NullPointerException);
            assertEquals("[ERROR] Destination IP must be a valid IPv4 address.", exception.getMessage());

            assertEquals("", outContent.toString());
            restoreStreams();
        } catch (Exception e) {
            fail("Exception not expected");
        }
    }

    @Test
    @Order(4)
    @DisplayName("Exception setProtocol")
    public void testExceptionSetProtocol() {
        Exception exception = assertThrows(Exception.class, () -> new FirewallRule("Test Rule", "192.1.1.168", "90.254.10.10", null, 8080, "ALLOW", true, LocalDate.now(), LocalDate.now().plusDays(10)));
        assertFalse(exception instanceof IllegalArgumentException);
        assertFalse(exception instanceof NullPointerException);
        assertEquals("[ERROR] Protocol must be one of: TCP, UDP, ICMP.", exception.getMessage());

        assertEquals("", outContent.toString());
        restoreStreams();

        try {
            FirewallRule rule = new FirewallRule("Test Rule", "192.1.1.168", "90.254.10.10", "TCP", 8080, "ALLOW", true, LocalDate.now(), LocalDate.now().plusDays(10));
            exception = assertThrows(Exception.class, () -> rule.setProtocol(null));
            assertFalse(exception instanceof IllegalArgumentException);
            assertFalse(exception instanceof NullPointerException);
            assertEquals("[ERROR] Protocol must be one of: TCP, UDP, ICMP.", exception.getMessage());

            assertEquals("", outContent.toString());
            restoreStreams();
        } catch (Exception e) {
            fail("Exception not expected");
        }
    }

    @Test
    @Order(5)
    @DisplayName("Exception setPort")
    public void testExceptionSetPort() {
        Exception exception = assertThrows(Exception.class, () -> new FirewallRule("Test Rule", "192.1.1.168", "90.254.10.10", "TCP", 0, "ALLOW", true, LocalDate.now(), LocalDate.now().plusDays(10)));
        assertFalse(exception instanceof IllegalArgumentException);
        assertFalse(exception instanceof NullPointerException);
        assertEquals("[ERROR] The port number must be greater than or equal to 1 and less than or equal to 65535.", exception.getMessage());

        assertEquals("", outContent.toString());
        restoreStreams();

        try {
            FirewallRule rule = new FirewallRule("Test Rule", "192.1.1.168", "90.254.10.10", "TCP", 8080, "ALLOW", true, LocalDate.now(), LocalDate.now().plusDays(10));
            exception = assertThrows(Exception.class, () -> rule.setPort(0));
            assertFalse(exception instanceof IllegalArgumentException);
            assertFalse(exception instanceof NullPointerException);
            assertEquals("[ERROR] The port number must be greater than or equal to 1 and less than or equal to 65535.", exception.getMessage());

            assertEquals("", outContent.toString());
            restoreStreams();
        } catch (Exception e) {
            fail("Exception not expected");
        }
    }

    @Test
    @Order(6)
    @DisplayName("Exception setAction")
    public void testExceptionSetAction() {
        Exception exception = assertThrows(Exception.class, () -> new FirewallRule("Test Rule", "192.1.1.168", "90.254.10.10", "TCP", 8080, null, true, LocalDate.now(), LocalDate.now().plusDays(10)));
        assertFalse(exception instanceof IllegalArgumentException);
        assertFalse(exception instanceof NullPointerException);
        assertEquals("[ERROR] Action must be one of: ALLOW, DENY.", exception.getMessage());

        assertEquals("", outContent.toString());
        restoreStreams();

        try {
            FirewallRule rule = new FirewallRule("Test Rule", "192.1.1.168", "90.254.10.10", "TCP", 8080, "ALLOW", true, LocalDate.now(), LocalDate.now().plusDays(10));
            exception = assertThrows(Exception.class, () -> rule.setAction(null));
            assertFalse(exception instanceof IllegalArgumentException);
            assertFalse(exception instanceof NullPointerException);
            assertEquals("[ERROR] Action must be one of: ALLOW, DENY.", exception.getMessage());

            assertEquals("", outContent.toString());
            restoreStreams();
        } catch (Exception e) {
            fail("Exception not expected");
        }
    }

    @Test
    @Order(7)
    @DisplayName("Exception setCreationDate")
    public void testExceptionSetCreationDate() {
        Exception exception = assertThrows(Exception.class, () -> new FirewallRule("Test Rule", "192.1.1.168", "90.254.10.10", "TCP", 8080, "ALLOW", true, null, LocalDate.now().plusDays(10)));
        assertFalse(exception instanceof IllegalArgumentException);
        assertFalse(exception instanceof NullPointerException);
        assertEquals("[ERROR] Creation date cannot be null or in the future.", exception.getMessage());

        assertEquals("", outContent.toString());
        restoreStreams();

        try {
            FirewallRule rule = new FirewallRule("Test Rule", "192.1.1.168", "90.254.10.10", "TCP", 8080, "ALLOW", true, LocalDate.now(), LocalDate.now().plusDays(10));
            exception = assertThrows(Exception.class, () -> rule.setCreationDate(null));
            assertFalse(exception instanceof IllegalArgumentException);
            assertFalse(exception instanceof NullPointerException);
            assertEquals("[ERROR] Creation date cannot be null or in the future.", exception.getMessage());

            assertEquals("", outContent.toString());
            restoreStreams();
        } catch (Exception e) {
            fail("Exception not expected");
        }
    }

    @Test
    @Order(8)
    @DisplayName("Exception setValidUntil")
    public void testExceptionSetValidUntil() {
        Exception exception = assertThrows(Exception.class, () -> new FirewallRule("Test Rule", "192.1.1.168", "90.254.10.10", "TCP", 8080, "ALLOW", true, LocalDate.now(), null));
        assertFalse(exception instanceof IllegalArgumentException);
        assertFalse(exception instanceof NullPointerException);
        assertEquals("[ERROR] Valid until date cannot be null or before the creation date.", exception.getMessage());

        assertEquals("", outContent.toString());
        restoreStreams();

        try {
            FirewallRule rule = new FirewallRule("Test Rule", "192.1.1.168", "90.254.10.10", "TCP", 8080, "ALLOW", true, LocalDate.now(), LocalDate.now().plusDays(10));
            exception = assertThrows(Exception.class, () -> rule.setValidUntil(null));
            assertFalse(exception instanceof IllegalArgumentException);
            assertFalse(exception instanceof NullPointerException);
            assertEquals("[ERROR] Valid until date cannot be null or before the creation date.", exception.getMessage());

            assertEquals("", outContent.toString());
            restoreStreams();
        } catch (Exception e) {
            fail("Exception not expected");
        }
    }

    @Test
    @Order(9)
    @DisplayName("Exception calculateAllowedTrafficPct")
    public void testCalculateAllowedTrafficPct() {
        try {
            FirewallRule rule = new FirewallRule("Test Rule", "192.1.1.168", "90.254.10.10", "TCP", 8080, "ALLOW", true, LocalDate.now(), LocalDate.now().plusDays(10));

            // Valid parameters just to prevent a warning in FirewallRule
            double dummy = rule.calculateAllowedTrafficPct(new String[]{}, new String[]{}, new String[]{}, new int[]{});
            assertEquals(0, dummy);

            Exception exception = assertThrows(Exception.class, () -> rule.calculateAllowedTrafficPct(null, null, null, null));
            assertFalse(exception instanceof IllegalArgumentException);
            assertFalse(exception instanceof NullPointerException);
            assertEquals("[ERROR] Invalid input data for traffic percentage calculation.", exception.getMessage());
        } catch (Exception e) {
            fail("Exception not expected");
        }
    }

    @Test
    @Order(10)
    @DisplayName("Exception calculateDeniedTrafficPct")
    public void testCalculateDeniedTrafficPct() {
        try {
            FirewallRule rule = new FirewallRule("Test Rule", "192.1.1.168", "90.254.10.10", "TCP", 8080, "ALLOW", true, LocalDate.now(), LocalDate.now().plusDays(10));

            // Valid parameters just to prevent a warning in FirewallRule
            double dummy = rule.calculateDeniedTrafficPct(new String[]{}, new String[]{}, new String[]{}, new int[]{});
            assertEquals(0, dummy);

            Exception exception = assertThrows(Exception.class, () -> rule.calculateDeniedTrafficPct(null, null, null, null));
            assertFalse(exception instanceof IllegalArgumentException);
            assertFalse(exception instanceof NullPointerException);
            assertEquals("[ERROR] Invalid input data for traffic percentage calculation.", exception.getMessage());
        } catch (Exception e) {
            fail("Exception not expected");
        }
    }

}
