package edu.uoc.pac1;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PAC1Ex2Test {

    private ByteArrayOutputStream outContent;
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    @Order(1)
    @DisplayName("getZoneArea")
    public void testGetZoneArea() {
        assertEquals(4.0, PAC1Ex2.getZoneArea(0), 0.001);
        assertEquals(2.5, PAC1Ex2.getZoneArea(1), 0.001);
        assertEquals(5.8, PAC1Ex2.getZoneArea(2), 0.001);
        assertEquals(3.2, PAC1Ex2.getZoneArea(3), 0.001);
        assertEquals(6.5, PAC1Ex2.getZoneArea(4), 0.001);
        assertEquals(4.9, PAC1Ex2.getZoneArea(5), 0.001);
        assertEquals(3.0, PAC1Ex2.getZoneArea(6), 0.001);
        assertEquals(7.1, PAC1Ex2.getZoneArea(7), 0.001);
    }

    @Test
    @Order(2)
    @DisplayName("calculateImpactDensity")
    public void testCalculateImpactDensity() {
        assertEquals(0.25, PAC1Ex2.calculateImpactDensity(1, 0), 0.001);
        assertEquals(0.4, PAC1Ex2.calculateImpactDensity(1, 1), 0.001);
        assertEquals(0.172, PAC1Ex2.calculateImpactDensity(1, 2), 0.001);
        assertEquals(0.313, PAC1Ex2.calculateImpactDensity(1, 3), 0.001);
        assertEquals(0.154, PAC1Ex2.calculateImpactDensity(1, 4), 0.001);
        assertEquals(0.204, PAC1Ex2.calculateImpactDensity(1, 5), 0.001);
        assertEquals(0.333, PAC1Ex2.calculateImpactDensity(1, 6), 0.001);
        assertEquals(0.14, PAC1Ex2.calculateImpactDensity(1, 7), 0.001);

        assertEquals(0.5, PAC1Ex2.calculateImpactDensity(2, 0), 0.001);
        assertEquals(0.8, PAC1Ex2.calculateImpactDensity(2, 1), 0.001);
        assertEquals(0.345, PAC1Ex2.calculateImpactDensity(2, 2), 0.001);
        assertEquals(0.625, PAC1Ex2.calculateImpactDensity(2, 3), 0.001);
        assertEquals(0.308, PAC1Ex2.calculateImpactDensity(2, 4), 0.001);
        assertEquals(0.408, PAC1Ex2.calculateImpactDensity(2, 5), 0.001);
        assertEquals(0.667, PAC1Ex2.calculateImpactDensity(2, 6), 0.001);
        assertEquals(0.282, PAC1Ex2.calculateImpactDensity(2, 7), 0.001);
    }

    @Test
    @Order(3)
    @DisplayName("needsUrgentRepair")
    public void testNeedsUrgentRepair() {
        assertTrue(PAC1Ex2.needsUrgentRepair(1, 0));
        assertTrue(PAC1Ex2.needsUrgentRepair(2, 1));
        assertFalse(PAC1Ex2.needsUrgentRepair(1, 2));
        assertTrue(PAC1Ex2.needsUrgentRepair(2, 3));
        assertFalse(PAC1Ex2.needsUrgentRepair(1, 4));
        assertFalse(PAC1Ex2.needsUrgentRepair(1, 5));
        assertTrue(PAC1Ex2.needsUrgentRepair(3, 6));
        assertFalse(PAC1Ex2.needsUrgentRepair(1, 7));
    }

    @Test
    @Order(4)
    @DisplayName("calculateTotalImpacts")
    public void testCalculateTotalImpacts() {
        int[] impactsArray = {1, 2, 3, 4, 5, 6, 7, 8};
        assertEquals(36, PAC1Ex2.calculateTotalImpacts(impactsArray));

        impactsArray = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
        assertEquals(0, PAC1Ex2.calculateTotalImpacts(impactsArray));
    }

    @Test
    @Order(5)
    @DisplayName("getMostDamagedZone")
    public void testGetMostDamagedZone() {
        int[] impactsArray = {1, 2, 3, 4, 5, 6, 7, 8};
        assertEquals(6, PAC1Ex2.getMostDamagedZone(impactsArray));

        impactsArray = new int[]{5, 10, 7, 8, 9, 6, 4, 3};
        assertEquals(1, PAC1Ex2.getMostDamagedZone(impactsArray));

        impactsArray = new int[]{4, 2, 1, 0, 0, 0, 3, 3};
        assertEquals(0, PAC1Ex2.getMostDamagedZone(impactsArray));

        impactsArray = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
        assertEquals(0, PAC1Ex2.getMostDamagedZone(impactsArray));
    }

    private String normalizeNewLines(String text) {
        return text.replace("\r\n", "\n").replace("\r", "\n");
    }

    @Test
    @Order(6)
    @DisplayName("printDamageReport")
    public void testPrintDamageReport() {
        String[] zoneNames = {
                "Front Shield",
                "Docking Hatch",
                "Left Hull",
                "Communication Panel",
                "Cargo Bay",
                "Central Module",
                "Sensor Array",
                "Upper Hull"
        };
        int[] impactsArray = {1, 2, 1, 4, 2, 1, 0, 0};

        PAC1Ex2.printDamageReport(zoneNames, impactsArray);

        String expectedOutput = """
                Meteor impact damage report:
                \tFront Shield: DENSITY 0.25 (URGENT REPAIR REQUIRED)
                \tDocking Hatch: DENSITY 0.8 (URGENT REPAIR REQUIRED)
                \tLeft Hull: DENSITY 0.172 (Normal)
                \tCommunication Panel: DENSITY 1.25 (URGENT REPAIR REQUIRED)
                \tCargo Bay: DENSITY 0.308 (URGENT REPAIR REQUIRED)
                \tCentral Module: DENSITY 0.204 (Normal)
                \tSensor Array: DENSITY 0.0 (Normal)
                \tUpper Hull: DENSITY 0.0 (Normal)
                Total impacts: 11
                Most damaged zone: Communication Panel
                Urgent repairs needed in 4 zones.
                """;

        assertEquals(normalizeNewLines(expectedOutput), normalizeNewLines(outContent.toString()));

        outContent.reset();

        impactsArray = new int[]{2, 0, 3, 0, 2, 0, 2, 3};

        PAC1Ex2.printDamageReport(zoneNames, impactsArray);

        expectedOutput = """
                Meteor impact damage report:
                \tFront Shield: DENSITY 0.5 (URGENT REPAIR REQUIRED)
                \tDocking Hatch: DENSITY 0.0 (Normal)
                \tLeft Hull: DENSITY 0.517 (URGENT REPAIR REQUIRED)
                \tCommunication Panel: DENSITY 0.0 (Normal)
                \tCargo Bay: DENSITY 0.308 (URGENT REPAIR REQUIRED)
                \tCentral Module: DENSITY 0.0 (Normal)
                \tSensor Array: DENSITY 0.667 (URGENT REPAIR REQUIRED)
                \tUpper Hull: DENSITY 0.423 (URGENT REPAIR REQUIRED)
                Total impacts: 12
                Most damaged zone: Sensor Array
                Urgent repairs needed in 5 zones.
                """;

        assertEquals(normalizeNewLines(expectedOutput), normalizeNewLines(outContent.toString()));
    }

}
