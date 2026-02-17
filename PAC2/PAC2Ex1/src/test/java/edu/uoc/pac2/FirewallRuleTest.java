package edu.uoc.pac2;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

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
    @DisplayName("Sanity - Fields definition")
    public void checkFieldsSanity() {
        assertEquals(17, FirewallRule.class.getDeclaredFields().length);

        try {
            assertTrue(Modifier.isPrivate(FirewallRule.class.getDeclaredField("ruleName").getModifiers()));
            assertFalse(Modifier.isStatic(FirewallRule.class.getDeclaredField("ruleName").getModifiers()));
            assertFalse(Modifier.isFinal(FirewallRule.class.getDeclaredField("ruleName").getModifiers()));
            assertEquals(String.class, FirewallRule.class.getDeclaredField("ruleName").getType());

            assertTrue(Modifier.isPrivate(FirewallRule.class.getDeclaredField("sourceIP").getModifiers()));
            assertFalse(Modifier.isStatic(FirewallRule.class.getDeclaredField("sourceIP").getModifiers()));
            assertFalse(Modifier.isFinal(FirewallRule.class.getDeclaredField("sourceIP").getModifiers()));
            assertEquals(String.class, FirewallRule.class.getDeclaredField("sourceIP").getType());

            assertTrue(Modifier.isPrivate(FirewallRule.class.getDeclaredField("destinationIP").getModifiers()));
            assertFalse(Modifier.isStatic(FirewallRule.class.getDeclaredField("destinationIP").getModifiers()));
            assertFalse(Modifier.isFinal(FirewallRule.class.getDeclaredField("destinationIP").getModifiers()));
            assertEquals(String.class, FirewallRule.class.getDeclaredField("destinationIP").getType());

            assertTrue(Modifier.isPrivate(FirewallRule.class.getDeclaredField("protocol").getModifiers()));
            assertFalse(Modifier.isStatic(FirewallRule.class.getDeclaredField("protocol").getModifiers()));
            assertFalse(Modifier.isFinal(FirewallRule.class.getDeclaredField("protocol").getModifiers()));
            assertEquals(String.class, FirewallRule.class.getDeclaredField("protocol").getType());

            assertTrue(Modifier.isPrivate(FirewallRule.class.getDeclaredField("port").getModifiers()));
            assertFalse(Modifier.isStatic(FirewallRule.class.getDeclaredField("port").getModifiers()));
            assertFalse(Modifier.isFinal(FirewallRule.class.getDeclaredField("port").getModifiers()));
            assertEquals(int.class, FirewallRule.class.getDeclaredField("port").getType());

            assertTrue(Modifier.isPrivate(FirewallRule.class.getDeclaredField("action").getModifiers()));
            assertFalse(Modifier.isStatic(FirewallRule.class.getDeclaredField("action").getModifiers()));
            assertFalse(Modifier.isFinal(FirewallRule.class.getDeclaredField("action").getModifiers()));
            assertEquals(String.class, FirewallRule.class.getDeclaredField("action").getType());

            assertTrue(Modifier.isPrivate(FirewallRule.class.getDeclaredField("isEnabled").getModifiers()));
            assertFalse(Modifier.isStatic(FirewallRule.class.getDeclaredField("isEnabled").getModifiers()));
            assertFalse(Modifier.isFinal(FirewallRule.class.getDeclaredField("isEnabled").getModifiers()));
            assertEquals(boolean.class, FirewallRule.class.getDeclaredField("isEnabled").getType());

            assertTrue(Modifier.isPrivate(FirewallRule.class.getDeclaredField("creationDate").getModifiers()));
            assertFalse(Modifier.isStatic(FirewallRule.class.getDeclaredField("creationDate").getModifiers()));
            assertFalse(Modifier.isFinal(FirewallRule.class.getDeclaredField("creationDate").getModifiers()));
            assertEquals(LocalDate.class, FirewallRule.class.getDeclaredField("creationDate").getType());

            assertTrue(Modifier.isPrivate(FirewallRule.class.getDeclaredField("validUntil").getModifiers()));
            assertFalse(Modifier.isStatic(FirewallRule.class.getDeclaredField("validUntil").getModifiers()));
            assertFalse(Modifier.isFinal(FirewallRule.class.getDeclaredField("validUntil").getModifiers()));
            assertEquals(LocalDate.class, FirewallRule.class.getDeclaredField("validUntil").getType());

            assertTrue(Modifier.isPrivate(FirewallRule.class.getDeclaredField("minPort").getModifiers()));
            assertTrue(Modifier.isStatic(FirewallRule.class.getDeclaredField("minPort").getModifiers()));
            assertFalse(Modifier.isFinal(FirewallRule.class.getDeclaredField("minPort").getModifiers()));
            assertEquals(int.class, FirewallRule.class.getDeclaredField("minPort").getType());

            assertTrue(Modifier.isPrivate(FirewallRule.class.getDeclaredField("maxPort").getModifiers()));
            assertTrue(Modifier.isStatic(FirewallRule.class.getDeclaredField("maxPort").getModifiers()));
            assertFalse(Modifier.isFinal(FirewallRule.class.getDeclaredField("maxPort").getModifiers()));
            assertEquals(int.class, FirewallRule.class.getDeclaredField("maxPort").getType());

            assertTrue(Modifier.isPrivate(FirewallRule.class.getDeclaredField("ftpPort").getModifiers()));
            assertTrue(Modifier.isStatic(FirewallRule.class.getDeclaredField("ftpPort").getModifiers()));
            assertFalse(Modifier.isFinal(FirewallRule.class.getDeclaredField("ftpPort").getModifiers()));
            assertEquals(int.class, FirewallRule.class.getDeclaredField("ftpPort").getType());

            assertTrue(Modifier.isPrivate(FirewallRule.class.getDeclaredField("sshPort").getModifiers()));
            assertTrue(Modifier.isStatic(FirewallRule.class.getDeclaredField("sshPort").getModifiers()));
            assertFalse(Modifier.isFinal(FirewallRule.class.getDeclaredField("sshPort").getModifiers()));
            assertEquals(int.class, FirewallRule.class.getDeclaredField("sshPort").getType());

            assertTrue(Modifier.isPrivate(FirewallRule.class.getDeclaredField("httpPort").getModifiers()));
            assertTrue(Modifier.isStatic(FirewallRule.class.getDeclaredField("httpPort").getModifiers()));
            assertFalse(Modifier.isFinal(FirewallRule.class.getDeclaredField("httpPort").getModifiers()));
            assertEquals(int.class, FirewallRule.class.getDeclaredField("httpPort").getType());

            assertTrue(Modifier.isPrivate(FirewallRule.class.getDeclaredField("httpsPort").getModifiers()));
            assertTrue(Modifier.isStatic(FirewallRule.class.getDeclaredField("httpsPort").getModifiers()));
            assertFalse(Modifier.isFinal(FirewallRule.class.getDeclaredField("httpsPort").getModifiers()));
            assertEquals(int.class, FirewallRule.class.getDeclaredField("httpsPort").getType());

            assertTrue(Modifier.isPrivate(FirewallRule.class.getDeclaredField("validProtocols").getModifiers()));
            assertTrue(Modifier.isStatic(FirewallRule.class.getDeclaredField("validProtocols").getModifiers()));
            assertFalse(Modifier.isFinal(FirewallRule.class.getDeclaredField("validProtocols").getModifiers()));
            assertEquals(String[].class, FirewallRule.class.getDeclaredField("validProtocols").getType());

            assertTrue(Modifier.isPrivate(FirewallRule.class.getDeclaredField("validActions").getModifiers()));
            assertTrue(Modifier.isStatic(FirewallRule.class.getDeclaredField("validActions").getModifiers()));
            assertFalse(Modifier.isFinal(FirewallRule.class.getDeclaredField("validActions").getModifiers()));
            assertEquals(String[].class, FirewallRule.class.getDeclaredField("validActions").getType());
        } catch (NoSuchFieldException e) {
            fail("[ERROR] There is some problem with the definition of the attributes!");
        }
    }

    @Test
    @Order(2)
    @DisplayName("Sanity - Constructor definition")
    public void checkConstructorSanity() {
        try {
            assertEquals(1, FirewallRule.class.getDeclaredConstructors().length);

            Constructor<FirewallRule> constructor = FirewallRule.class.getDeclaredConstructor(String.class, String.class,
                    String.class, String.class, int.class, String.class, boolean.class, LocalDate.class, LocalDate.class);

            assertTrue(Modifier.isPublic(constructor.getModifiers()));
        } catch (NoSuchMethodException e) {
            fail("[ERROR] There is some problem with the definition of the constructor!");
        }
    }

    @Test
    @Order(3)
    @DisplayName("Sanity - Methods definition")
    public void checkMethodsSanity() {
        assertEquals(29, FirewallRule.class.getDeclaredMethods().length);

        try {
            assertTrue(Modifier.isPublic(FirewallRule.class.getDeclaredMethod("getRuleName").getModifiers()));
            assertFalse(Modifier.isStatic(FirewallRule.class.getDeclaredMethod("getRuleName").getModifiers()));
            assertFalse(Modifier.isFinal(FirewallRule.class.getDeclaredMethod("getRuleName").getModifiers()));
            assertEquals(String.class, FirewallRule.class.getDeclaredMethod("getRuleName").getReturnType());

            assertTrue(Modifier.isPublic(FirewallRule.class.getDeclaredMethod("setRuleName", String.class).getModifiers()));
            assertFalse(Modifier.isStatic(FirewallRule.class.getDeclaredMethod("setRuleName", String.class).getModifiers()));
            assertFalse(Modifier.isFinal(FirewallRule.class.getDeclaredMethod("setRuleName", String.class).getModifiers()));
            assertEquals(void.class, FirewallRule.class.getDeclaredMethod("setRuleName", String.class).getReturnType());

            assertTrue(Modifier.isPublic(FirewallRule.class.getDeclaredMethod("getSourceIP").getModifiers()));
            assertFalse(Modifier.isStatic(FirewallRule.class.getDeclaredMethod("getSourceIP").getModifiers()));
            assertFalse(Modifier.isFinal(FirewallRule.class.getDeclaredMethod("getSourceIP").getModifiers()));
            assertEquals(String.class, FirewallRule.class.getDeclaredMethod("getSourceIP").getReturnType());

            assertTrue(Modifier.isPrivate(FirewallRule.class.getDeclaredMethod("isValidIP", String.class).getModifiers()));
            assertFalse(Modifier.isStatic(FirewallRule.class.getDeclaredMethod("isValidIP", String.class).getModifiers()));
            assertFalse(Modifier.isFinal(FirewallRule.class.getDeclaredMethod("isValidIP", String.class).getModifiers()));
            assertEquals(boolean.class, FirewallRule.class.getDeclaredMethod("isValidIP", String.class).getReturnType());

            assertTrue(Modifier.isPublic(FirewallRule.class.getDeclaredMethod("setSourceIP", String.class).getModifiers()));
            assertFalse(Modifier.isStatic(FirewallRule.class.getDeclaredMethod("setSourceIP", String.class).getModifiers()));
            assertFalse(Modifier.isFinal(FirewallRule.class.getDeclaredMethod("setSourceIP", String.class).getModifiers()));
            assertEquals(void.class, FirewallRule.class.getDeclaredMethod("setSourceIP", String.class).getReturnType());

            assertTrue(Modifier.isPublic(FirewallRule.class.getDeclaredMethod("getDestinationIP").getModifiers()));
            assertFalse(Modifier.isStatic(FirewallRule.class.getDeclaredMethod("getDestinationIP").getModifiers()));
            assertFalse(Modifier.isFinal(FirewallRule.class.getDeclaredMethod("getDestinationIP").getModifiers()));
            assertEquals(String.class, FirewallRule.class.getDeclaredMethod("getDestinationIP").getReturnType());

            assertTrue(Modifier.isPublic(FirewallRule.class.getDeclaredMethod("setDestinationIP", String.class).getModifiers()));
            assertFalse(Modifier.isStatic(FirewallRule.class.getDeclaredMethod("setDestinationIP", String.class).getModifiers()));
            assertFalse(Modifier.isFinal(FirewallRule.class.getDeclaredMethod("setDestinationIP", String.class).getModifiers()));
            assertEquals(void.class, FirewallRule.class.getDeclaredMethod("setDestinationIP", String.class).getReturnType());

            assertTrue(Modifier.isPublic(FirewallRule.class.getDeclaredMethod("getProtocol").getModifiers()));
            assertFalse(Modifier.isStatic(FirewallRule.class.getDeclaredMethod("getProtocol").getModifiers()));
            assertFalse(Modifier.isFinal(FirewallRule.class.getDeclaredMethod("getProtocol").getModifiers()));
            assertEquals(String.class, FirewallRule.class.getDeclaredMethod("getProtocol").getReturnType());

            assertTrue(Modifier.isPrivate(FirewallRule.class.getDeclaredMethod("isValidProtocol", String.class).getModifiers()));
            assertFalse(Modifier.isStatic(FirewallRule.class.getDeclaredMethod("isValidProtocol", String.class).getModifiers()));
            assertFalse(Modifier.isFinal(FirewallRule.class.getDeclaredMethod("isValidProtocol", String.class).getModifiers()));
            assertEquals(boolean.class, FirewallRule.class.getDeclaredMethod("isValidProtocol", String.class).getReturnType());

            assertTrue(Modifier.isPublic(FirewallRule.class.getDeclaredMethod("setProtocol", String.class).getModifiers()));
            assertFalse(Modifier.isStatic(FirewallRule.class.getDeclaredMethod("setProtocol", String.class).getModifiers()));
            assertFalse(Modifier.isFinal(FirewallRule.class.getDeclaredMethod("setProtocol", String.class).getModifiers()));
            assertEquals(void.class, FirewallRule.class.getDeclaredMethod("setProtocol", String.class).getReturnType());

            assertTrue(Modifier.isPublic(FirewallRule.class.getDeclaredMethod("getPort").getModifiers()));
            assertFalse(Modifier.isStatic(FirewallRule.class.getDeclaredMethod("getPort").getModifiers()));
            assertFalse(Modifier.isFinal(FirewallRule.class.getDeclaredMethod("getPort").getModifiers()));
            assertEquals(int.class, FirewallRule.class.getDeclaredMethod("getPort").getReturnType());

            assertTrue(Modifier.isPublic(FirewallRule.class.getDeclaredMethod("setPort", int.class).getModifiers()));
            assertFalse(Modifier.isStatic(FirewallRule.class.getDeclaredMethod("setPort", int.class).getModifiers()));
            assertFalse(Modifier.isFinal(FirewallRule.class.getDeclaredMethod("setPort", int.class).getModifiers()));
            assertEquals(void.class, FirewallRule.class.getDeclaredMethod("setPort", int.class).getReturnType());

            assertTrue(Modifier.isPublic(FirewallRule.class.getDeclaredMethod("getAction").getModifiers()));
            assertFalse(Modifier.isStatic(FirewallRule.class.getDeclaredMethod("getAction").getModifiers()));
            assertFalse(Modifier.isFinal(FirewallRule.class.getDeclaredMethod("getAction").getModifiers()));
            assertEquals(String.class, FirewallRule.class.getDeclaredMethod("getAction").getReturnType());

            assertTrue(Modifier.isPrivate(FirewallRule.class.getDeclaredMethod("isValidAction", String.class).getModifiers()));
            assertFalse(Modifier.isStatic(FirewallRule.class.getDeclaredMethod("isValidAction", String.class).getModifiers()));
            assertFalse(Modifier.isFinal(FirewallRule.class.getDeclaredMethod("isValidAction", String.class).getModifiers()));
            assertEquals(boolean.class, FirewallRule.class.getDeclaredMethod("isValidAction", String.class).getReturnType());

            assertTrue(Modifier.isPublic(FirewallRule.class.getDeclaredMethod("setAction", String.class).getModifiers()));
            assertFalse(Modifier.isStatic(FirewallRule.class.getDeclaredMethod("setAction", String.class).getModifiers()));
            assertFalse(Modifier.isFinal(FirewallRule.class.getDeclaredMethod("setAction", String.class).getModifiers()));
            assertEquals(void.class, FirewallRule.class.getDeclaredMethod("setAction", String.class).getReturnType());

            assertTrue(Modifier.isPublic(FirewallRule.class.getDeclaredMethod("isEnabled").getModifiers()));
            assertFalse(Modifier.isStatic(FirewallRule.class.getDeclaredMethod("isEnabled").getModifiers()));
            assertFalse(Modifier.isFinal(FirewallRule.class.getDeclaredMethod("isEnabled").getModifiers()));
            assertEquals(boolean.class, FirewallRule.class.getDeclaredMethod("isEnabled").getReturnType());

            assertTrue(Modifier.isPublic(FirewallRule.class.getDeclaredMethod("setEnabled", boolean.class).getModifiers()));
            assertFalse(Modifier.isStatic(FirewallRule.class.getDeclaredMethod("setEnabled", boolean.class).getModifiers()));
            assertFalse(Modifier.isFinal(FirewallRule.class.getDeclaredMethod("setEnabled", boolean.class).getModifiers()));
            assertEquals(void.class, FirewallRule.class.getDeclaredMethod("setEnabled", boolean.class).getReturnType());

            assertTrue(Modifier.isPublic(FirewallRule.class.getDeclaredMethod("getCreationDate").getModifiers()));
            assertFalse(Modifier.isStatic(FirewallRule.class.getDeclaredMethod("getCreationDate").getModifiers()));
            assertFalse(Modifier.isFinal(FirewallRule.class.getDeclaredMethod("getCreationDate").getModifiers()));
            assertEquals(LocalDate.class, FirewallRule.class.getDeclaredMethod("getCreationDate").getReturnType());

            assertTrue(Modifier.isPublic(FirewallRule.class.getDeclaredMethod("setCreationDate", LocalDate.class).getModifiers()));
            assertFalse(Modifier.isStatic(FirewallRule.class.getDeclaredMethod("setCreationDate", LocalDate.class).getModifiers()));
            assertFalse(Modifier.isFinal(FirewallRule.class.getDeclaredMethod("setCreationDate", LocalDate.class).getModifiers()));
            assertEquals(void.class, FirewallRule.class.getDeclaredMethod("setCreationDate", LocalDate.class).getReturnType());

            assertTrue(Modifier.isPublic(FirewallRule.class.getDeclaredMethod("getValidUntil").getModifiers()));
            assertFalse(Modifier.isStatic(FirewallRule.class.getDeclaredMethod("getValidUntil").getModifiers()));
            assertFalse(Modifier.isFinal(FirewallRule.class.getDeclaredMethod("getValidUntil").getModifiers()));
            assertEquals(LocalDate.class, FirewallRule.class.getDeclaredMethod("getValidUntil").getReturnType());

            assertTrue(Modifier.isPublic(FirewallRule.class.getDeclaredMethod("setValidUntil", LocalDate.class).getModifiers()));
            assertFalse(Modifier.isStatic(FirewallRule.class.getDeclaredMethod("setValidUntil", LocalDate.class).getModifiers()));
            assertFalse(Modifier.isFinal(FirewallRule.class.getDeclaredMethod("setValidUntil", LocalDate.class).getModifiers()));
            assertEquals(void.class, FirewallRule.class.getDeclaredMethod("setValidUntil", LocalDate.class).getReturnType());

            assertTrue(Modifier.isPublic(FirewallRule.class.getDeclaredMethod("isNotExpired").getModifiers()));
            assertFalse(Modifier.isStatic(FirewallRule.class.getDeclaredMethod("isNotExpired").getModifiers()));
            assertFalse(Modifier.isFinal(FirewallRule.class.getDeclaredMethod("isNotExpired").getModifiers()));
            assertEquals(boolean.class, FirewallRule.class.getDeclaredMethod("isNotExpired").getReturnType());

            assertTrue(Modifier.isPublic(FirewallRule.class.getDeclaredMethod("isCriticalPort").getModifiers()));
            assertFalse(Modifier.isStatic(FirewallRule.class.getDeclaredMethod("isCriticalPort").getModifiers()));
            assertFalse(Modifier.isFinal(FirewallRule.class.getDeclaredMethod("isCriticalPort").getModifiers()));
            assertEquals(boolean.class, FirewallRule.class.getDeclaredMethod("isCriticalPort").getReturnType());

            assertTrue(Modifier.isPublic(FirewallRule.class.getDeclaredMethod("isCriticalRule").getModifiers()));
            assertFalse(Modifier.isStatic(FirewallRule.class.getDeclaredMethod("isCriticalRule").getModifiers()));
            assertFalse(Modifier.isFinal(FirewallRule.class.getDeclaredMethod("isCriticalRule").getModifiers()));
            assertEquals(boolean.class, FirewallRule.class.getDeclaredMethod("isCriticalRule").getReturnType());

            assertTrue(Modifier.isPublic(FirewallRule.class.getDeclaredMethod("isApplicable", String.class, String.class, String.class, int.class).getModifiers()));
            assertFalse(Modifier.isStatic(FirewallRule.class.getDeclaredMethod("isApplicable", String.class, String.class, String.class, int.class).getModifiers()));
            assertFalse(Modifier.isFinal(FirewallRule.class.getDeclaredMethod("isApplicable", String.class, String.class, String.class, int.class).getModifiers()));
            assertEquals(boolean.class, FirewallRule.class.getDeclaredMethod("isApplicable", String.class, String.class, String.class, int.class).getReturnType());

            assertTrue(Modifier.isPublic(FirewallRule.class.getDeclaredMethod("countMatchingRulesByAction", String[].class, String[].class, String[].class, int[].class, String.class).getModifiers()));
            assertFalse(Modifier.isStatic(FirewallRule.class.getDeclaredMethod("countMatchingRulesByAction", String[].class, String[].class, String[].class, int[].class, String.class).getModifiers()));
            assertFalse(Modifier.isFinal(FirewallRule.class.getDeclaredMethod("countMatchingRulesByAction", String[].class, String[].class, String[].class, int[].class, String.class).getModifiers()));
            assertEquals(int.class, FirewallRule.class.getDeclaredMethod("countMatchingRulesByAction", String[].class, String[].class, String[].class, int[].class, String.class).getReturnType());

            assertTrue(Modifier.isPrivate(FirewallRule.class.getDeclaredMethod("areInputsValid", String[].class, String[].class, String[].class, int[].class).getModifiers()));
            assertFalse(Modifier.isStatic(FirewallRule.class.getDeclaredMethod("areInputsValid", String[].class, String[].class, String[].class, int[].class).getModifiers()));
            assertFalse(Modifier.isFinal(FirewallRule.class.getDeclaredMethod("areInputsValid", String[].class, String[].class, String[].class, int[].class).getModifiers()));
            assertEquals(boolean.class, FirewallRule.class.getDeclaredMethod("areInputsValid", String[].class, String[].class, String[].class, int[].class).getReturnType());

            assertTrue(Modifier.isPublic(FirewallRule.class.getDeclaredMethod("calculateAllowedTrafficPct", String[].class, String[].class, String[].class, int[].class).getModifiers()));
            assertFalse(Modifier.isStatic(FirewallRule.class.getDeclaredMethod("calculateAllowedTrafficPct", String[].class, String[].class, String[].class, int[].class).getModifiers()));
            assertFalse(Modifier.isFinal(FirewallRule.class.getDeclaredMethod("calculateAllowedTrafficPct", String[].class, String[].class, String[].class, int[].class).getModifiers()));
            assertEquals(double.class, FirewallRule.class.getDeclaredMethod("calculateAllowedTrafficPct", String[].class, String[].class, String[].class, int[].class).getReturnType());

            assertTrue(Modifier.isPublic(FirewallRule.class.getDeclaredMethod("calculateDeniedTrafficPct", String[].class, String[].class, String[].class, int[].class).getModifiers()));
            assertFalse(Modifier.isStatic(FirewallRule.class.getDeclaredMethod("calculateDeniedTrafficPct", String[].class, String[].class, String[].class, int[].class).getModifiers()));
            assertFalse(Modifier.isFinal(FirewallRule.class.getDeclaredMethod("calculateDeniedTrafficPct", String[].class, String[].class, String[].class, int[].class).getModifiers()));
            assertEquals(double.class, FirewallRule.class.getDeclaredMethod("calculateDeniedTrafficPct", String[].class, String[].class, String[].class, int[].class).getReturnType());
        } catch (NoSuchMethodException e) {
            fail("[ERROR] There is some problem with the definition of the methods!");
        }
    }

    @Test
    @Order(4)
    @DisplayName("Minimum - setRuleName")
    public void testSetRuleName() {
        new FirewallRule(null, "192.1.1.168", "90.254.10.10", "TCP", 8080, "ALLOW", true, LocalDate.now(), LocalDate.now().plusDays(10));
        assertEquals("[ERROR] Rule name cannot be null, empty or contain only whitespace.", outContent.toString().trim());
        restoreStreams();

        new FirewallRule("", "192.1.1.168", "90.254.10.10", "TCP", 8080, "ALLOW", true, LocalDate.now(), LocalDate.now().plusDays(10));
        assertEquals("[ERROR] Rule name cannot be null, empty or contain only whitespace.", outContent.toString().trim());
        restoreStreams();

        new FirewallRule("   ", "192.1.1.168", "90.254.10.10", "TCP", 8080, "ALLOW", true, LocalDate.now(), LocalDate.now().plusDays(10));
        assertEquals("[ERROR] Rule name cannot be null, empty or contain only whitespace.", outContent.toString().trim());
        restoreStreams();

        FirewallRule rule = new FirewallRule("Test Rule", "192.1.1.168", "90.254.10.10", "TCP", 8080, "ALLOW", true, LocalDate.now(), LocalDate.now().plusDays(10));
        assertEquals("Test Rule", rule.getRuleName());

        rule.setRuleName("Updated Rule");
        assertEquals("Updated Rule", rule.getRuleName());

        rule.setRuleName(null);
        assertEquals("[ERROR] Rule name cannot be null, empty or contain only whitespace.", outContent.toString().trim());
        restoreStreams();
        assertEquals("Updated Rule", rule.getRuleName());

        rule.setRuleName("");
        assertEquals("[ERROR] Rule name cannot be null, empty or contain only whitespace.", outContent.toString().trim());
        restoreStreams();
        assertEquals("Updated Rule", rule.getRuleName());

        rule.setRuleName("  ");
        assertEquals("[ERROR] Rule name cannot be null, empty or contain only whitespace.", outContent.toString().trim());
        restoreStreams();
        assertEquals("Updated Rule", rule.getRuleName());

        rule.setRuleName("  New Rule  ");
        assertEquals("New Rule", rule.getRuleName());
    }

    @Test
    @Order(5)
    @DisplayName("Minimum - setSourceIP")
    public void testSetSourceIP() {
        new FirewallRule("Test Rule", null, "90.254.10.10", "TCP", 8080, "ALLOW", true, LocalDate.now(), LocalDate.now().plusDays(10));
        assertEquals("[ERROR] Source IP must be a valid IPv4 address.", outContent.toString().trim());
        restoreStreams();

        new FirewallRule("Test Rule", "", "90.254.10.10", "TCP", 8080, "ALLOW", true, LocalDate.now(), LocalDate.now().plusDays(10));
        assertEquals("[ERROR] Source IP must be a valid IPv4 address.", outContent.toString().trim());
        restoreStreams();

        new FirewallRule("Test Rule", "xxx.xxx.xxx.xxx", "90.254.10.10", "TCP", 8080, "ALLOW", true, LocalDate.now(), LocalDate.now().plusDays(10));
        assertEquals("[ERROR] Source IP must be a valid IPv4 address.", outContent.toString().trim());
        restoreStreams();

        new FirewallRule("Test Rule", "111.111.111", "90.254.10.10", "TCP", 8080, "ALLOW", true, LocalDate.now(), LocalDate.now().plusDays(10));
        assertEquals("[ERROR] Source IP must be a valid IPv4 address.", outContent.toString().trim());
        restoreStreams();

        new FirewallRule("Test Rule", "111.111.111.111.111", "90.254.10.10", "TCP", 8080, "ALLOW", true, LocalDate.now(), LocalDate.now().plusDays(10));
        assertEquals("[ERROR] Source IP must be a valid IPv4 address.", outContent.toString().trim());
        restoreStreams();

        new FirewallRule("Test Rule", "11a.11a.11a.11a", "90.254.10.10", "TCP", 8080, "ALLOW", true, LocalDate.now(), LocalDate.now().plusDays(10));
        assertEquals("[ERROR] Source IP must be a valid IPv4 address.", outContent.toString().trim());
        restoreStreams();

        FirewallRule rule = new FirewallRule("Test Rule", "192.1.1.168", "90.254.10.10", "TCP", 8080, "ALLOW", true, LocalDate.now(), LocalDate.now().plusDays(10));
        assertEquals("192.1.1.168", rule.getSourceIP());

        rule.setSourceIP(null);
        assertEquals("[ERROR] Source IP must be a valid IPv4 address.", outContent.toString().trim());
        restoreStreams();
        assertEquals("192.1.1.168", rule.getSourceIP());

        rule.setSourceIP("");
        assertEquals("[ERROR] Source IP must be a valid IPv4 address.", outContent.toString().trim());
        restoreStreams();
        assertEquals("192.1.1.168", rule.getSourceIP());

        rule.setSourceIP("xxx.xxx.xxx.xxx");
        assertEquals("[ERROR] Source IP must be a valid IPv4 address.", outContent.toString().trim());
        restoreStreams();
        assertEquals("192.1.1.168", rule.getSourceIP());

        rule.setSourceIP("111.111.111");
        assertEquals("[ERROR] Source IP must be a valid IPv4 address.", outContent.toString().trim());
        restoreStreams();
        assertEquals("192.1.1.168", rule.getSourceIP());

        rule.setSourceIP("111.111.111.111.111");
        assertEquals("[ERROR] Source IP must be a valid IPv4 address.", outContent.toString().trim());
        restoreStreams();
        assertEquals("192.1.1.168", rule.getSourceIP());

        rule.setSourceIP("11a.11a.11a.11a");
        assertEquals("[ERROR] Source IP must be a valid IPv4 address.", outContent.toString().trim());
        restoreStreams();
        assertEquals("192.1.1.168", rule.getSourceIP());

        rule.setSourceIP("1.1.1.1");
        assertEquals("1.1.1.1", rule.getSourceIP());

        rule.setSourceIP("999.999.999.999");
        assertEquals("999.999.999.999", rule.getSourceIP());
    }

    @Test
    @Order(6)
    @DisplayName("Minimum - setDestinationIP")
    public void testSetDestinationIP() {
        new FirewallRule("Test Rule", "90.254.10.10", null, "TCP", 8080, "ALLOW", true, LocalDate.now(), LocalDate.now().plusDays(10));
        assertEquals("[ERROR] Destination IP must be a valid IPv4 address.", outContent.toString().trim());
        restoreStreams();

        new FirewallRule("Test Rule", "90.254.10.10", "", "TCP", 8080, "ALLOW", true, LocalDate.now(), LocalDate.now().plusDays(10));
        assertEquals("[ERROR] Destination IP must be a valid IPv4 address.", outContent.toString().trim());
        restoreStreams();

        new FirewallRule("Test Rule", "90.254.10.10", "xxx.xxx.xxx.xxx", "TCP", 8080, "ALLOW", true, LocalDate.now(), LocalDate.now().plusDays(10));
        assertEquals("[ERROR] Destination IP must be a valid IPv4 address.", outContent.toString().trim());
        restoreStreams();

        new FirewallRule("Test Rule", "90.254.10.10", "111.111.111", "TCP", 8080, "ALLOW", true, LocalDate.now(), LocalDate.now().plusDays(10));
        assertEquals("[ERROR] Destination IP must be a valid IPv4 address.", outContent.toString().trim());
        restoreStreams();

        new FirewallRule("Test Rule", "90.254.10.10", "111.111.111.111.111", "TCP", 8080, "ALLOW", true, LocalDate.now(), LocalDate.now().plusDays(10));
        assertEquals("[ERROR] Destination IP must be a valid IPv4 address.", outContent.toString().trim());
        restoreStreams();

        new FirewallRule("Test Rule", "90.254.10.10", "11a.11a.11a.11a", "TCP", 8080, "ALLOW", true, LocalDate.now(), LocalDate.now().plusDays(10));
        assertEquals("[ERROR] Destination IP must be a valid IPv4 address.", outContent.toString().trim());
        restoreStreams();

        FirewallRule rule = new FirewallRule("Test Rule", "90.254.10.10", "192.1.1.168", "TCP", 8080, "ALLOW", true, LocalDate.now(), LocalDate.now().plusDays(10));
        assertEquals("192.1.1.168", rule.getDestinationIP());

        rule.setDestinationIP(null);
        assertEquals("[ERROR] Destination IP must be a valid IPv4 address.", outContent.toString().trim());
        restoreStreams();
        assertEquals("192.1.1.168", rule.getDestinationIP());

        rule.setDestinationIP("");
        assertEquals("[ERROR] Destination IP must be a valid IPv4 address.", outContent.toString().trim());
        restoreStreams();
        assertEquals("192.1.1.168", rule.getDestinationIP());

        rule.setDestinationIP("xxx.xxx.xxx.xxx");
        assertEquals("[ERROR] Destination IP must be a valid IPv4 address.", outContent.toString().trim());
        restoreStreams();
        assertEquals("192.1.1.168", rule.getDestinationIP());

        rule.setDestinationIP("111.111.111");
        assertEquals("[ERROR] Destination IP must be a valid IPv4 address.", outContent.toString().trim());
        restoreStreams();
        assertEquals("192.1.1.168", rule.getDestinationIP());

        rule.setDestinationIP("111.111.111.111.111");
        assertEquals("[ERROR] Destination IP must be a valid IPv4 address.", outContent.toString().trim());
        restoreStreams();
        assertEquals("192.1.1.168", rule.getDestinationIP());

        rule.setDestinationIP("11a.11a.11a.11a");
        assertEquals("[ERROR] Destination IP must be a valid IPv4 address.", outContent.toString().trim());
        restoreStreams();
        assertEquals("192.1.1.168", rule.getDestinationIP());

        rule.setDestinationIP("1.1.1.1");
        assertEquals("1.1.1.1", rule.getDestinationIP());

        rule.setDestinationIP("999.999.999.999");
        assertEquals("999.999.999.999", rule.getDestinationIP());
    }

    @Test
    @Order(7)
    @DisplayName("Minimum - setProtocol")
    public void testSetProtocol() {
        new FirewallRule("Test Rule", "90.254.10.10", "90.254.10.10", null, 8080, "ALLOW", true, LocalDate.now(), LocalDate.now().plusDays(10));
        assertEquals("[ERROR] Protocol must be one of: TCP, UDP, ICMP.", outContent.toString().trim());
        restoreStreams();

        new FirewallRule("Test Rule", "90.254.10.10", "90.254.10.10", "", 8080, "ALLOW", true, LocalDate.now(), LocalDate.now().plusDays(10));
        assertEquals("[ERROR] Protocol must be one of: TCP, UDP, ICMP.", outContent.toString().trim());
        restoreStreams();

        new FirewallRule("Test Rule", "90.254.10.10", "90.254.10.10", "UPD", 8080, "ALLOW", true, LocalDate.now(), LocalDate.now().plusDays(10));
        assertEquals("[ERROR] Protocol must be one of: TCP, UDP, ICMP.", outContent.toString().trim());
        restoreStreams();

        FirewallRule rule = new FirewallRule("Test Rule", "90.254.10.10", "90.254.10.10", "UDP", 8080, "ALLOW", true, LocalDate.now(), LocalDate.now().plusDays(10));
        assertEquals("UDP", rule.getProtocol());

        rule = new FirewallRule("Test Rule", "90.254.10.10", "90.254.10.10", "udp", 8080, "ALLOW", true, LocalDate.now(), LocalDate.now().plusDays(10));
        assertEquals("UDP", rule.getProtocol());

        rule = new FirewallRule("Test Rule", "90.254.10.10", "90.254.10.10", "TCP", 8080, "ALLOW", true, LocalDate.now(), LocalDate.now().plusDays(10));
        assertEquals("TCP", rule.getProtocol());

        rule = new FirewallRule("Test Rule", "90.254.10.10", "90.254.10.10", "tCp", 8080, "ALLOW", true, LocalDate.now(), LocalDate.now().plusDays(10));
        assertEquals("TCP", rule.getProtocol());

        rule = new FirewallRule("Test Rule", "90.254.10.10", "90.254.10.10", "ICMP", 8080, "ALLOW", true, LocalDate.now(), LocalDate.now().plusDays(10));
        assertEquals("ICMP", rule.getProtocol());

        rule = new FirewallRule("Test Rule", "90.254.10.10", "90.254.10.10", "IcmP", 8080, "ALLOW", true, LocalDate.now(), LocalDate.now().plusDays(10));
        assertEquals("ICMP", rule.getProtocol());

        rule.setProtocol(null);
        assertEquals("[ERROR] Protocol must be one of: TCP, UDP, ICMP.", outContent.toString().trim());
        restoreStreams();
        assertEquals("ICMP", rule.getProtocol());

        rule.setProtocol("");
        assertEquals("[ERROR] Protocol must be one of: TCP, UDP, ICMP.", outContent.toString().trim());
        restoreStreams();
        assertEquals("ICMP", rule.getProtocol());

        rule.setProtocol("UPD");
        assertEquals("[ERROR] Protocol must be one of: TCP, UDP, ICMP.", outContent.toString().trim());
        restoreStreams();
        assertEquals("ICMP", rule.getProtocol());

        rule.setProtocol("FTP");
        assertEquals("[ERROR] Protocol must be one of: TCP, UDP, ICMP.", outContent.toString().trim());
        restoreStreams();
        assertEquals("ICMP", rule.getProtocol());

        rule.setProtocol("UDP");
        assertEquals("UDP", rule.getProtocol());

        rule.setProtocol("tcp");
        assertEquals("TCP", rule.getProtocol());

        rule.setProtocol("icMp");
        assertEquals("ICMP", rule.getProtocol());

        rule.setProtocol("ICMP");
        assertEquals("ICMP", rule.getProtocol());

        rule.setProtocol("TCP");
        assertEquals("TCP", rule.getProtocol());
    }

    @Test
    @Order(8)
    @DisplayName("Minimum - setPort")
    public void testSetPort() {
        new FirewallRule("Test Rule", "90.254.10.10", "90.254.10.10", "TCP", -1, "ALLOW", true, LocalDate.now(), LocalDate.now().plusDays(10));
        assertEquals("[ERROR] The port number must be greater than or equal to 1 and less than or equal to 65535.", outContent.toString().trim());
        restoreStreams();

        new FirewallRule("Test Rule", "90.254.10.10", "90.254.10.10", "TCP", 0, "ALLOW", true, LocalDate.now(), LocalDate.now().plusDays(10));
        assertEquals("[ERROR] The port number must be greater than or equal to 1 and less than or equal to 65535.", outContent.toString().trim());
        restoreStreams();

        new FirewallRule("Test Rule", "90.254.10.10", "90.254.10.10", "TCP", 65536, "ALLOW", true, LocalDate.now(), LocalDate.now().plusDays(10));
        assertEquals("[ERROR] The port number must be greater than or equal to 1 and less than or equal to 65535.", outContent.toString().trim());
        restoreStreams();

        FirewallRule rule = new FirewallRule("Test Rule", "90.254.10.10", "90.254.10.10", "TCP", 8080, "ALLOW", true, LocalDate.now(), LocalDate.now().plusDays(10));
        assertEquals(8080, rule.getPort());

        rule.setPort(-1);
        assertEquals("[ERROR] The port number must be greater than or equal to 1 and less than or equal to 65535.", outContent.toString().trim());
        restoreStreams();
        assertEquals(8080, rule.getPort());

        rule.setPort(0);
        assertEquals("[ERROR] The port number must be greater than or equal to 1 and less than or equal to 65535.", outContent.toString().trim());
        restoreStreams();
        assertEquals(8080, rule.getPort());

        rule.setPort(65536);
        assertEquals("[ERROR] The port number must be greater than or equal to 1 and less than or equal to 65535.", outContent.toString().trim());
        restoreStreams();
        assertEquals(8080, rule.getPort());

        rule.setPort(8081);
        assertEquals(8081, rule.getPort());

        rule.setPort(1);
        assertEquals(1, rule.getPort());

        rule.setPort(65535);
        assertEquals(65535, rule.getPort());
    }

    @Test
    @Order(9)
    @DisplayName("Minimum - setAction")
    public void testSetAction() {
        new FirewallRule("Test Rule", "90.254.10.10", "90.254.10.10", "TCP", 8080, null, true, LocalDate.now(), LocalDate.now().plusDays(10));
        assertEquals("[ERROR] Action must be one of: ALLOW, DENY.", outContent.toString().trim());
        restoreStreams();

        new FirewallRule("Test Rule", "90.254.10.10", "90.254.10.10", "TCP", 8080, "", true, LocalDate.now(), LocalDate.now().plusDays(10));
        assertEquals("[ERROR] Action must be one of: ALLOW, DENY.", outContent.toString().trim());
        restoreStreams();

        new FirewallRule("Test Rule", "90.254.10.10", "90.254.10.10", "TCP", 8080, "   ", true, LocalDate.now(), LocalDate.now().plusDays(10));
        assertEquals("[ERROR] Action must be one of: ALLOW, DENY.", outContent.toString().trim());
        restoreStreams();

        new FirewallRule("Test Rule", "90.254.10.10", "90.254.10.10", "TCP", 8080, "DENNY", true, LocalDate.now(), LocalDate.now().plusDays(10));
        assertEquals("[ERROR] Action must be one of: ALLOW, DENY.", outContent.toString().trim());
        restoreStreams();

        new FirewallRule("Test Rule", "90.254.10.10", "90.254.10.10", "TCP", 8080, "ALOWw", true, LocalDate.now(), LocalDate.now().plusDays(10));
        assertEquals("[ERROR] Action must be one of: ALLOW, DENY.", outContent.toString().trim());
        restoreStreams();

        FirewallRule rule = new FirewallRule("Test Rule", "90.254.10.10", "90.254.10.10", "TCP", 8080, "ALLOW", true, LocalDate.now(), LocalDate.now().plusDays(10));
        assertEquals("ALLOW", rule.getAction());

        rule = new FirewallRule("Test Rule", "90.254.10.10", "90.254.10.10", "TCP", 8080, "aLLow", true, LocalDate.now(), LocalDate.now().plusDays(10));
        assertEquals("ALLOW", rule.getAction());

        rule = new FirewallRule("Test Rule", "90.254.10.10", "90.254.10.10", "TCP", 8080, "deny", true, LocalDate.now(), LocalDate.now().plusDays(10));
        assertEquals("DENY", rule.getAction());

        rule = new FirewallRule("Test Rule", "90.254.10.10", "90.254.10.10", "TCP", 8080, "DENY", true, LocalDate.now(), LocalDate.now().plusDays(10));
        assertEquals("DENY", rule.getAction());

        rule.setAction(null);
        assertEquals("[ERROR] Action must be one of: ALLOW, DENY.", outContent.toString().trim());
        restoreStreams();
        assertEquals("DENY", rule.getAction());

        rule.setAction("");
        assertEquals("[ERROR] Action must be one of: ALLOW, DENY.", outContent.toString().trim());
        restoreStreams();
        assertEquals("DENY", rule.getAction());

        rule.setAction("   ");
        assertEquals("[ERROR] Action must be one of: ALLOW, DENY.", outContent.toString().trim());
        restoreStreams();
        assertEquals("DENY", rule.getAction());

        rule.setAction("DENNY");
        assertEquals("[ERROR] Action must be one of: ALLOW, DENY.", outContent.toString().trim());
        restoreStreams();
        assertEquals("DENY", rule.getAction());

        rule.setAction("ALOWw");
        assertEquals("[ERROR] Action must be one of: ALLOW, DENY.", outContent.toString().trim());
        restoreStreams();
        assertEquals("DENY", rule.getAction());

        rule.setAction("ALLOW");
        assertEquals("ALLOW", rule.getAction());

        rule.setAction("aLLow");
        assertEquals("ALLOW", rule.getAction());

        rule.setAction("deny");
        assertEquals("DENY", rule.getAction());

        rule.setAction("DENY");
        assertEquals("DENY", rule.getAction());
    }

    @Test
    @Order(10)
    @DisplayName("Minimum - setEnabled")
    public void testSetEnabled() {
        FirewallRule rule = new FirewallRule("Test Rule", "90.254.10.10", "90.254.10.10", "TCP", 8080, "ALLOW", true, LocalDate.now(), LocalDate.now().plusDays(10));
        assertTrue(rule.isEnabled());

        rule = new FirewallRule("Test Rule", "90.254.10.10", "90.254.10.10", "TCP", 8080, "ALLOW", false, LocalDate.now(), LocalDate.now().plusDays(10));
        assertFalse(rule.isEnabled());

        rule.setEnabled(true);
        assertTrue(rule.isEnabled());

        rule.setEnabled(false);
        assertFalse(rule.isEnabled());
    }

    @Test
    @Order(11)
    @DisplayName("Minimum - setCreationDate")
    public void testSetCreationDate() {
        new FirewallRule("Test Rule", "90.254.10.10", "90.254.10.10", "TCP", 8080, "ALLOW", true, null, LocalDate.now().plusDays(10));
        assertEquals("[ERROR] Creation date cannot be null or in the future.[ERROR] Valid until date cannot be null or before the creation date.", outContent.toString().trim().replaceAll("[\\r\\n]", ""));
        restoreStreams();

        new FirewallRule("Test Rule", "90.254.10.10", "90.254.10.10", "TCP", 8080, "ALLOW", true, LocalDate.now().plusDays(1), LocalDate.now().plusDays(10));
        assertEquals("[ERROR] Creation date cannot be null or in the future.[ERROR] Valid until date cannot be null or before the creation date.", outContent.toString().trim().replaceAll("[\\r\\n]", ""));
        restoreStreams();

        FirewallRule rule = new FirewallRule("Test Rule", "90.254.10.10", "90.254.10.10", "TCP", 8080, "ALLOW", true, LocalDate.now(), LocalDate.now().plusDays(10));
        assertEquals(LocalDate.now(), rule.getCreationDate());

        rule.setCreationDate(null);
        assertEquals("[ERROR] Creation date cannot be null or in the future.", outContent.toString().trim());
        restoreStreams();
        assertEquals(LocalDate.now(), rule.getCreationDate());

        rule.setCreationDate(LocalDate.now().plusDays(1));
        assertEquals("[ERROR] Creation date cannot be null or in the future.", outContent.toString().trim());
        restoreStreams();
        assertEquals(LocalDate.now(), rule.getCreationDate());

        rule.setCreationDate(LocalDate.now().minusDays(1));
        assertEquals(LocalDate.now().minusDays(1), rule.getCreationDate());

        rule.setCreationDate(LocalDate.now());
        assertEquals(LocalDate.now(), rule.getCreationDate());
    }

    @Test
    @Order(12)
    @DisplayName("Minimum - setValidUntil")
    public void testSetValidUntil() {
        new FirewallRule("Test Rule", "90.254.10.10", "90.254.10.10", "TCP", 8080, "ALLOW", true, LocalDate.now(), null);
        assertEquals("[ERROR] Valid until date cannot be null or before the creation date.", outContent.toString().trim());
        restoreStreams();

        new FirewallRule("Test Rule", "90.254.10.10", "90.254.10.10", "TCP", 8080, "ALLOW", true, LocalDate.now(), LocalDate.now().minusDays(1));
        assertEquals("[ERROR] Valid until date cannot be null or before the creation date.", outContent.toString().trim());
        restoreStreams();

        FirewallRule rule = new FirewallRule("Test Rule", "90.254.10.10", "90.254.10.10", "TCP", 8080, "ALLOW", true, LocalDate.now(), LocalDate.now().plusDays(1));
        assertEquals(LocalDate.now().plusDays(1), rule.getValidUntil());

        rule.setValidUntil(null);
        assertEquals("[ERROR] Valid until date cannot be null or before the creation date.", outContent.toString().trim());
        restoreStreams();
        assertEquals(LocalDate.now().plusDays(1), rule.getValidUntil());

        rule.setValidUntil(LocalDate.now().minusDays(1));
        assertEquals("[ERROR] Valid until date cannot be null or before the creation date.", outContent.toString().trim());
        restoreStreams();
        assertEquals(LocalDate.now().plusDays(1), rule.getValidUntil());

        rule.setCreationDate(LocalDate.now().minusDays(5));
        rule.setValidUntil(LocalDate.now().minusDays(6));
        assertEquals("[ERROR] Valid until date cannot be null or before the creation date.", outContent.toString().trim());
        restoreStreams();
        assertEquals(LocalDate.now().minusDays(5), rule.getCreationDate());
    }

    @Test
    @Order(13)
    @DisplayName("Minimum - isNotExpired")
    public void testIsNotExpired() {
        FirewallRule rule = new FirewallRule(
                "Test Rule",
                "90.254.10.10",
                "90.254.10.10",
                "TCP",
                8080,
                "ALLOW",
                true,
                LocalDate.now().minusDays(10),
                LocalDate.now().plusDays(1)
        );
        assertTrue(rule.isNotExpired());

        rule.setValidUntil(LocalDate.now().minusDays(1));
        assertFalse(rule.isNotExpired());

        rule.setValidUntil(LocalDate.now());
        assertTrue(rule.isNotExpired());
    }

    @Test
    @Order(14)
    @DisplayName("Minimum - isCriticalPort")
    public void testIsCriticalPort() {
        FirewallRule rule = new FirewallRule(
                "Critical SSH Rule",
                "192.168.1.1",
                "192.168.1.2",
                "TCP",
                22,
                "ALLOW",
                true,
                LocalDate.now().minusDays(10),
                LocalDate.now().plusDays(1)
        );
        assertTrue(rule.isCriticalPort());

        rule.setPort(21);
        assertTrue(rule.isCriticalPort());

        rule.setPort(80);
        assertTrue(rule.isCriticalPort());

        rule.setPort(443);
        assertTrue(rule.isCriticalPort());

        rule.setPort(8080);
        assertFalse(rule.isCriticalPort());
    }

    @Test
    @Order(15)
    @DisplayName("Minimum - isCriticalRule")
    public void testIsCriticalRule() {
        FirewallRule rule = new FirewallRule(
                "Critical SSH Rule",
                "192.168.1.1",
                "192.168.1.2",
                "TCP",
                22,
                "ALLOW",
                true,
                LocalDate.now().minusDays(10),
                LocalDate.now().plusDays(1)
        );
        assertTrue(rule.isCriticalRule());

        rule.setEnabled(false);
        assertFalse(rule.isCriticalRule());
        rule.setEnabled(true);

        rule.setValidUntil(LocalDate.now().minusDays(1));
        assertFalse(rule.isCriticalRule());
        rule.setValidUntil(LocalDate.now().plusDays(1));

        rule.setPort(8080);
        assertFalse(rule.isCriticalRule());
    }

    @Test
    @Order(16)
    @DisplayName("Minimum - isApplicable")
    public void testIsApplicable() {
        FirewallRule rule = new FirewallRule(
                "Test Rule",
                "90.254.10.10",
                "90.254.10.10",
                "TCP",
                8080,
                "ALLOW",
                true,
                LocalDate.now().minusDays(10),
                LocalDate.now().plusDays(1)
        );

        assertTrue(rule.isApplicable("90.254.10.10", "90.254.10.10", "TCP", 8080));

        rule.setEnabled(false);
        assertFalse(rule.isApplicable("90.254.10.10", "90.254.10.10", "TCP", 8080));
        rule.setEnabled(true);

        rule.setValidUntil(LocalDate.now().minusDays(1));
        assertFalse(rule.isApplicable("90.254.10.10", "90.254.10.10", "TCP", 8080));
        rule.setValidUntil(LocalDate.now().plusDays(1));

        assertFalse(rule.isApplicable("192.168.1.1", "90.254.10.10", "TCP", 8080));
        assertFalse(rule.isApplicable("90.254.10.10", "192.168.1.1", "TCP", 8080));
        assertFalse(rule.isApplicable("90.254.10.10", "90.254.10.10", "UDP", 8080));
        assertFalse(rule.isApplicable("90.254.10.10", "90.254.10.10", "TCP", 9090));
    }

}
