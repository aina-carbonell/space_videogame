package edu.uoc.pac4;

import org.junit.jupiter.api.*;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SpaceShipTest {

    @Test
    @Order(1)
    @Tag("sanity")
    @DisplayName("Sanity - Fields definition")
    public void checkFields() {
        int numFields = 4;

        // Check attribute fields
        assertEquals(numFields, SpaceShip.class.getDeclaredFields().length, "The class must have exactly " + numFields + " fields.");

        try {
            assertTrue(Modifier.isPrivate(SpaceShip.class.getDeclaredField("id").getModifiers()), "The attribute id must be private.");
            assertFalse(Modifier.isStatic(SpaceShip.class.getDeclaredField("id").getModifiers()), "The attribute id must not be static.");
            assertFalse(Modifier.isFinal(SpaceShip.class.getDeclaredField("id").getModifiers()), "The attribute id must not be final.");
            assertEquals(String.class, SpaceShip.class.getDeclaredField("id").getType(), "The attribute id must be of type String.");

            assertTrue(Modifier.isPrivate(SpaceShip.class.getDeclaredField("peopleCapacity").getModifiers()), "The attribute peopleCapacity must be private.");
            assertFalse(Modifier.isStatic(SpaceShip.class.getDeclaredField("peopleCapacity").getModifiers()), "The attribute peopleCapacity must not be static.");
            assertFalse(Modifier.isFinal(SpaceShip.class.getDeclaredField("peopleCapacity").getModifiers()), "The attribute peopleCapacity must not be final.");
            assertEquals(int.class, SpaceShip.class.getDeclaredField("peopleCapacity").getType(), "The attribute peopleCapacity must be of type int.");

            assertTrue(Modifier.isPrivate(SpaceShip.class.getDeclaredField("cargoCapacity").getModifiers()), "The attribute cargoCapacity must be private.");
            assertFalse(Modifier.isStatic(SpaceShip.class.getDeclaredField("cargoCapacity").getModifiers()), "The attribute cargoCapacity must not be static.");
            assertFalse(Modifier.isFinal(SpaceShip.class.getDeclaredField("cargoCapacity").getModifiers()), "The attribute cargoCapacity must not be final.");
            assertEquals(double.class, SpaceShip.class.getDeclaredField("cargoCapacity").getType(), "The attribute cargoCapacity must be of type double.");

            assertTrue(Modifier.isPrivate(SpaceShip.class.getDeclaredField("spaceShipRolType").getModifiers()), "The attribute rolType must be private.");
            assertFalse(Modifier.isStatic(SpaceShip.class.getDeclaredField("spaceShipRolType").getModifiers()), "The attribute rolType must not be static.");
            assertFalse(Modifier.isFinal(SpaceShip.class.getDeclaredField("spaceShipRolType").getModifiers()), "The attribute rolType must not be final.");
            assertEquals(SpaceShipRolType.class, SpaceShip.class.getDeclaredField("spaceShipRolType").getType(), "The attribute rolType must be of type SpaceShipRolType.");
        } catch (NoSuchFieldException e) {
            fail("[ERROR] There is some problem with the definition of the attributes: " + e.getMessage());
        }
    }

    @Test
    @Order(2)
    @Tag("sanity")
    @DisplayName("Sanity - Constructors definition")
    public void checkConstructor() {
        int numConstructors = 1;

        // Check number of constructors
        assertEquals(numConstructors, SpaceShip.class.getConstructors().length, "The class must have exactly " + numConstructors + " constructor");

        try {
            assertTrue(Modifier.isPublic(SpaceShip.class.getConstructor(String.class, int.class, double.class, SpaceShipRolType.class).getModifiers()), "The constructor SpaceShip(String, SpaceShipRolType) must be public");
        } catch (NoSuchMethodException e) {
            fail("[ERROR] There is some problem with the definition of constructors: " + e.getMessage());
        }
    }

    @Test
    @Order(3)
    @Tag("sanity")
    @DisplayName("Sanity - Methods definition")
    public void checkMethods() {
        int numMethods = 9;

        // Check number of methods
        assertEquals(numMethods, SpaceShip.class.getDeclaredMethods().length, "The class must have exactly " + numMethods + " method");

        try {
            assertTrue(Modifier.isPublic(SpaceShip.class.getMethod("getId").getModifiers()), "The method getId() must be public");
            assertFalse(Modifier.isStatic(SpaceShip.class.getMethod("getId").getModifiers()), "The method getId() must not be static");
            assertFalse(Modifier.isFinal(SpaceShip.class.getMethod("getId").getModifiers()), "The method getId() must not be final");
            assertEquals(String.class, SpaceShip.class.getMethod("getId").getReturnType(), "The method getId() must return a String");

            assertTrue(Modifier.isPrivate(SpaceShip.class.getDeclaredMethod("setId", String.class).getModifiers()), "The method setId(String) must be private");
            assertFalse(Modifier.isStatic(SpaceShip.class.getDeclaredMethod("setId", String.class).getModifiers()), "The method setId(String) must not be static");
            assertFalse(Modifier.isFinal(SpaceShip.class.getDeclaredMethod("setId", String.class).getModifiers()), "The method setId(String) must not be final");
            assertEquals(void.class, SpaceShip.class.getDeclaredMethod("setId", String.class).getReturnType(), "The method setId(String) must return void");

            assertTrue(Modifier.isPublic(SpaceShip.class.getMethod("getCargoCapacity").getModifiers()), "The method getCargoCapacity() must be public");
            assertFalse(Modifier.isStatic(SpaceShip.class.getMethod("getCargoCapacity").getModifiers()), "The method getCargoCapacity() must not be static");
            assertFalse(Modifier.isFinal(SpaceShip.class.getMethod("getCargoCapacity").getModifiers()), "The method getCargoCapacity() must not be final");
            assertEquals(double.class, SpaceShip.class.getMethod("getCargoCapacity").getReturnType(), "The method getCargoCapacity() must return a double");

            assertTrue(Modifier.isPrivate(SpaceShip.class.getDeclaredMethod("setCargoCapacity", double.class).getModifiers()), "The method setCargoCapacity(double) must be private");
            assertFalse(Modifier.isStatic(SpaceShip.class.getDeclaredMethod("setCargoCapacity", double.class).getModifiers()), "The method setCargoCapacity(double) must not be static");
            assertFalse(Modifier.isFinal(SpaceShip.class.getDeclaredMethod("setCargoCapacity", double.class).getModifiers()), "The method setCargoCapacity(double) must not be final");
            assertEquals(void.class, SpaceShip.class.getDeclaredMethod("setCargoCapacity", double.class).getReturnType(), "The method setCargoCapacity(double) must return void");

            assertTrue(Modifier.isPublic(SpaceShip.class.getMethod("getCargoCapacity").getModifiers()), "The method getCargoCapacity() must be public");
            assertFalse(Modifier.isStatic(SpaceShip.class.getMethod("getCargoCapacity").getModifiers()), "The method getCargoCapacity() must not be static");
            assertFalse(Modifier.isFinal(SpaceShip.class.getMethod("getCargoCapacity").getModifiers()), "The method getCargoCapacity() must not be final");
            assertEquals(double.class, SpaceShip.class.getMethod("getCargoCapacity").getReturnType(), "The method getCargoCapacity() must return a double");

            assertTrue(Modifier.isPrivate(SpaceShip.class.getDeclaredMethod("setCargoCapacity", double.class).getModifiers()), "The method setCargoCapacity(double) must be private");
            assertFalse(Modifier.isStatic(SpaceShip.class.getDeclaredMethod("setCargoCapacity", double.class).getModifiers()), "The method setCargoCapacity(double) must not be static");
            assertFalse(Modifier.isFinal(SpaceShip.class.getDeclaredMethod("setCargoCapacity", double.class).getModifiers()), "The method setCargoCapacity(double) must not be final");
            assertEquals(void.class, SpaceShip.class.getDeclaredMethod("setCargoCapacity", double.class).getReturnType(), "The method setCargoCapacity(double) must return void");

            assertTrue(Modifier.isPublic(SpaceShip.class.getMethod("getSpaceShipRolType").getModifiers()), "The method getSpaceShipRolType() must be public");
            assertFalse(Modifier.isStatic(SpaceShip.class.getMethod("getSpaceShipRolType").getModifiers()), "The method getSpaceShipRolType() must not be static");
            assertFalse(Modifier.isFinal(SpaceShip.class.getMethod("getSpaceShipRolType").getModifiers()), "The method getSpaceShipRolType() must not be final");
            assertEquals(SpaceShipRolType.class, SpaceShip.class.getMethod("getSpaceShipRolType").getReturnType(), "The method getSpaceShipRolType() must return a SpaceShipRolType");

            assertTrue(Modifier.isPublic(SpaceShip.class.getDeclaredMethod("setSpaceShipRolType", SpaceShipRolType.class).getModifiers()), "The method setSpaceShipRolType(SpaceShipRolType) must be public");
            assertFalse(Modifier.isStatic(SpaceShip.class.getDeclaredMethod("setSpaceShipRolType", SpaceShipRolType.class).getModifiers()), "The method setSpaceShipRolType(SpaceShipRolType) must not be static");
            assertFalse(Modifier.isFinal(SpaceShip.class.getDeclaredMethod("setSpaceShipRolType", SpaceShipRolType.class).getModifiers()), "The method setSpaceShipRolType(SpaceShipRolType) must not be final");
            assertEquals(void.class, SpaceShip.class.getDeclaredMethod("setSpaceShipRolType", SpaceShipRolType.class).getReturnType(), "The method setSpaceShipRolType(SpaceShipRolType) must return void");

            assertTrue(Modifier.isPublic(SpaceShip.class.getMethod("toString").getModifiers()), "The method toString() must be public");
            assertFalse(Modifier.isStatic(SpaceShip.class.getMethod("toString").getModifiers()), "The method toString() must not be static");
            assertFalse(Modifier.isFinal(SpaceShip.class.getMethod("toString").getModifiers()), "The method toString() must not be final");
            assertEquals(String.class, SpaceShip.class.getMethod("toString").getReturnType(), "The method toString() must return a String");
        } catch (NoSuchMethodException e) {
            fail("[ERROR] There is some problem with the definition of methods: " + e.getMessage());
        }
    }

    @Test
    @Order(4)
    @Tag("minimum")
    @DisplayName("Minimum - Valid parameters")
    public void testSpaceShipValidParameters() {
        try {
            SpaceShip ship = new SpaceShip("SS-001", 100, 50.0, SpaceShipRolType.BATTLE);
            assertEquals("SS-001", ship.getId(), "The spaceship ID is incorrect.");
            assertEquals(SpaceShipRolType.BATTLE, ship.getSpaceShipRolType(), "The spaceship role type is incorrect.");

            ship = new SpaceShip("SS-100", 100, 50.0, SpaceShipRolType.DIPLOMATIC);
            assertEquals("SS-100", ship.getId(), "The spaceship ID is incorrect.");
            assertEquals(SpaceShipRolType.DIPLOMATIC, ship.getSpaceShipRolType(), "The spaceship role type is incorrect.");

            ship = new SpaceShip("SS-AAA", 100, 50.0, SpaceShipRolType.SCIENCE);
            assertEquals("SS-AAA", ship.getId(), "The spaceship ID is incorrect.");
            assertEquals(SpaceShipRolType.SCIENCE, ship.getSpaceShipRolType(), "The spaceship role type is incorrect.");
        } catch (SpaceShipException e) {
            fail("SpaceShipException");
        }
    }

    @Test
    @Order(5)
    @Tag("minimum")
    @DisplayName("Minimum - Id")
    public void testSpaceShipId() {
        try {
            Exception exception = assertThrows(SpaceShipException.class, () -> new SpaceShip(null, 100, 50.0, SpaceShipRolType.BATTLE));
            assertEquals(SpaceShipException.class, exception.getClass(), "Exception type for null ID is incorrect.");
            assertEquals(SpaceShipException.INVALID_SPACESHIP_ID, exception.getMessage(), "Exception message for invalid ID is incorrect.");

            exception = assertThrows(SpaceShipException.class, () -> new SpaceShip("", 100, 50.0, SpaceShipRolType.BATTLE));
            assertEquals(SpaceShipException.class, exception.getClass(), "Exception type for empty ID is incorrect.");
            assertEquals(SpaceShipException.INVALID_SPACESHIP_ID, exception.getMessage(), "Exception message for invalid ID is incorrect.");

            exception = assertThrows(SpaceShipException.class, () -> new SpaceShip("001", 100, 50.0, SpaceShipRolType.BATTLE));
            assertEquals(SpaceShipException.class, exception.getClass(), "Exception type for ID not starting with 'SS-' is incorrect.");
            assertEquals(SpaceShipException.INVALID_SPACESHIP_ID, exception.getMessage(), "Exception message for invalid ID is incorrect.");

            exception = assertThrows(SpaceShipException.class, () -> new SpaceShip("SS001", 100, 50.0, SpaceShipRolType.BATTLE));
            assertEquals(SpaceShipException.class, exception.getClass(), "Exception type for ID not starting with 'SS-' is incorrect.");
            assertEquals(SpaceShipException.INVALID_SPACESHIP_ID, exception.getMessage(), "Exception message for invalid ID is incorrect.");

            SpaceShip spaceShip = new SpaceShip("SS-123", 100, 50.0, SpaceShipRolType.SCIENCE);
            assertEquals("SS-123", spaceShip.getId(), "The spaceship ID is incorrect.");

            spaceShip = new SpaceShip("SS-456", 100, 50.0, SpaceShipRolType.DIPLOMATIC);
            assertEquals("SS-456", spaceShip.getId(), "The spaceship ID is incorrect.");
        } catch (SpaceShipException e) {
            fail("SpaceGameException");
        }
    }

    @Test
    @Order(6)
    @Tag("minimum")
    @DisplayName("Minimum - People Capacity")
    public void testSpaceShipPeopleCapacity() {
        try {
            SpaceShip spaceShip = new SpaceShip("SS-123", 100, 50.0, SpaceShipRolType.BATTLE);
            assertEquals(100, spaceShip.getPeopleCapacity(), "The spaceship people capacity is incorrect.");

            spaceShip = new SpaceShip("SS-456", 0, 50.0, SpaceShipRolType.SCIENCE);
            assertEquals(0, spaceShip.getPeopleCapacity(), "The spaceship people capacity is incorrect.");

            spaceShip = new SpaceShip("SS-789", -10, 50.0, SpaceShipRolType.DIPLOMATIC);
            assertEquals(0, spaceShip.getPeopleCapacity(), "The spaceship people capacity should be set to 0 for negative values.");
        } catch (SpaceShipException e) {
            fail("SpaceGameException");
        }
    }

    @Test
    @Order(7)
    @Tag("minimum")
    @DisplayName("Minimum - Cargo Capacity")
    public void testSpaceShipCargoCapacity() {
        try {
            SpaceShip spaceShip = new SpaceShip("SS-123", 100, 100.0, SpaceShipRolType.BATTLE);
            assertEquals(100.0, spaceShip.getCargoCapacity(), "The spaceship cargo capacity is incorrect.");

            spaceShip = new SpaceShip("SS-456", 100, 0.0, SpaceShipRolType.SCIENCE);
            assertEquals(0.0, spaceShip.getCargoCapacity(), "The spaceship cargo capacity is incorrect.");

            spaceShip = new SpaceShip("SS-789", 100, -50.0, SpaceShipRolType.DIPLOMATIC);
            assertEquals(0.0, spaceShip.getCargoCapacity(), "The spaceship cargo capacity should be set to 0 for negative values.");
        } catch (SpaceShipException e) {
            fail("SpaceGameException");
        }
    }

    @Test
    @Order(8)
    @Tag("minimum")
    @DisplayName("Minimum - Role Type")
    public void testSpaceShipRoleType() {
        try {
            Exception exception = assertThrows(SpaceShipException.class, () -> new SpaceShip("SS-001", 100, 50.0, null));
            assertEquals(SpaceShipException.class, exception.getClass(), "Exception type for null role type is incorrect.");
            assertEquals(SpaceShipException.INVALID_SPACESHIP_ROL_TYPE, exception.getMessage(), "Exception message for null role type is incorrect.");

            SpaceShip spaceShip = new SpaceShip("SS-123", 100, 50.0, SpaceShipRolType.BATTLE);
            assertEquals(SpaceShipRolType.BATTLE, spaceShip.getSpaceShipRolType(), "The spaceship role type is incorrect.");

            exception = assertThrows(SpaceShipException.class, () -> spaceShip.setSpaceShipRolType(null));
            assertEquals(SpaceShipException.class, exception.getClass(), "Exception type for null role type is incorrect.");
            assertEquals(SpaceShipException.INVALID_SPACESHIP_ROL_TYPE, exception.getMessage(), "Exception message for null role type is incorrect.");

            spaceShip.setSpaceShipRolType(SpaceShipRolType.SCIENCE);
            assertEquals(SpaceShipRolType.SCIENCE, spaceShip.getSpaceShipRolType(), "The spaceship role type is incorrect.");

            spaceShip.setSpaceShipRolType(SpaceShipRolType.DIPLOMATIC);
            assertEquals(SpaceShipRolType.DIPLOMATIC, spaceShip.getSpaceShipRolType(), "The spaceship role type is incorrect.");
        } catch (SpaceShipException e) {
            fail("SpaceGameException");
        }
    }

    private String normalizeJson(String s) {
        if (s == null) return null;

        StringBuilder result = new StringBuilder();
        boolean insideQuotes = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '\"') {
                insideQuotes = !insideQuotes;
                result.append(c);
                continue;
            }

            if (!insideQuotes && Character.isWhitespace(c)) {
                continue;
            }

            result.append(c);
        }

        return result.toString();
    }

    @Test
    @Order(9)
    @Tag("advanced")
    @DisplayName("Advanced - toString")
    public void testToString() {
        try {
            SpaceShip ship = new SpaceShip("SS-001", 100, 100.0, SpaceShipRolType.BATTLE);
            String expected = "{ \"id\": \"SS-001\", \"peopleCapacity\": 100, \"cargoCapacity\": 100.0, \"rol\": \"Battle\" }";
            assertEquals(
                    normalizeJson(expected),
                    normalizeJson(ship.toString()),
                    "The toString() method output is incorrect."
            );

            ship = new SpaceShip("SS-100", 80, -10.0, SpaceShipRolType.DIPLOMATIC);
            expected = "{ \"id\": \"SS-100\", \"peopleCapacity\": 80, \"cargoCapacity\": 0.0, \"rol\": \"Diplomatic\" }";
            assertEquals(
                    normalizeJson(expected),
                    normalizeJson(ship.toString()),
                    "The toString() method output is incorrect."
            );

            ship = new SpaceShip("SS-200", -10, 75.0, SpaceShipRolType.SCIENCE);
            expected = "{ \"id\": \"SS-200\", \"peopleCapacity\": 0, \"cargoCapacity\": 75.0, \"rol\": \"Science\" }";
            assertEquals(
                    normalizeJson(expected),
                    normalizeJson(ship.toString()),
                    "The toString() method output is incorrect."
            );
        } catch (SpaceShipException e) {
            fail("SpaceGameException");
        }
    }

}
