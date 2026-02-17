package edu.uoc.pac4;

import org.junit.jupiter.api.*;

import java.lang.reflect.Modifier;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SpaceGameTest {

    @Test
    @Order(1)
    @Tag("sanity")
    @DisplayName("Sanity - Fields definition")
    public void checkFields() {
        int numFields = 3;

        // Check attribute fields
        assertEquals(numFields, SpaceGame.class.getDeclaredFields().length, "The class must have exactly " + numFields + " fields.");

        try {
            assertTrue(Modifier.isPrivate(SpaceGame.class.getDeclaredField("MAX_SPACESHIPS").getModifiers()), "The attribute MAX_SPACESHIPS must be private.");
            assertTrue(Modifier.isStatic(SpaceGame.class.getDeclaredField("MAX_SPACESHIPS").getModifiers()), "The attribute MAX_SPACESHIPS must be static.");
            assertTrue(Modifier.isFinal(SpaceGame.class.getDeclaredField("MAX_SPACESHIPS").getModifiers()), "The attribute MAX_SPACESHIPS must be final.");
            assertEquals(int.class, SpaceGame.class.getDeclaredField("MAX_SPACESHIPS").getType(), "The attribute MAX_SPACESHIPS must be of type int.");

            assertTrue(Modifier.isPrivate(SpaceGame.class.getDeclaredField("galaxyName").getModifiers()), "The attribute galaxyName must be private.");
            assertFalse(Modifier.isStatic(SpaceGame.class.getDeclaredField("galaxyName").getModifiers()), "The attribute galaxyName must not be static.");
            assertFalse(Modifier.isFinal(SpaceGame.class.getDeclaredField("galaxyName").getModifiers()), "The attribute galaxyName must not be final.");
            assertEquals(String.class, SpaceGame.class.getDeclaredField("galaxyName").getType(), "The attribute galaxyName must be of type String.");

            assertTrue(Modifier.isPrivate(SpaceGame.class.getDeclaredField("spaceships").getModifiers()), "The attribute spaceships must be private.");
            assertFalse(Modifier.isStatic(SpaceGame.class.getDeclaredField("spaceships").getModifiers()), "The attribute spaceships must not be static.");
            assertFalse(Modifier.isFinal(SpaceGame.class.getDeclaredField("spaceships").getModifiers()), "The attribute spaceships must not be final.");
            assertEquals(List.class, SpaceGame.class.getDeclaredField("spaceships").getType(), "The attribute spaceships must be of type List.");
        } catch (NoSuchFieldException e) {
            fail("[ERROR] There is some problem with the definition of the attributes: " + e.getMessage());
        }
    }

    @Test
    @Order(2)
    @Tag("sanity")
    @DisplayName("Sanity - Constructors definition")
    public void checkConstructors() {
        int numConstructors = 1;

        // Check number of constructors
        assertEquals(numConstructors, SpaceGame.class.getConstructors().length, "The class must have exactly " + numConstructors + " constructor");

        try {
            assertTrue(Modifier.isPublic(SpaceGame.class.getConstructor(String.class).getModifiers()), "The constructor SpaceGame(String) must be public");
        } catch (NoSuchMethodException e) {
            fail("[ERROR] There is some problem with the definition of constructors: " + e.getMessage());
        }
    }

    @Test
    @Order(3)
    @Tag("sanity")
    @DisplayName("Sanity - Methods definition")
    public void checkMethods() {
        int numMethods = 7;

        // Check number of methods
        assertEquals(numMethods, SpaceGame.class.getDeclaredMethods().length, "The class must have exactly " + numMethods + " methods");

        try {
            assertTrue(Modifier.isPublic(SpaceGame.class.getDeclaredMethod("getGalaxyName").getModifiers()), "The method getGalaxyName() must be public");
            assertFalse(Modifier.isStatic(SpaceGame.class.getDeclaredMethod("getGalaxyName").getModifiers()), "The method getGalaxyName() must not be static");
            assertFalse(Modifier.isFinal(SpaceGame.class.getDeclaredMethod("getGalaxyName").getModifiers()), "The method getGalaxyName() must not be final");
            assertEquals(String.class, SpaceGame.class.getDeclaredMethod("getGalaxyName").getReturnType(), "The method getGalaxyName() must return a String");

            assertTrue(Modifier.isPublic(SpaceGame.class.getDeclaredMethod("setGalaxyName", String.class).getModifiers()), "The method setGalaxyName(String) must be public");
            assertFalse(Modifier.isStatic(SpaceGame.class.getDeclaredMethod("setGalaxyName", String.class).getModifiers()), "The method setGalaxyName(String) must not be static");
            assertFalse(Modifier.isFinal(SpaceGame.class.getDeclaredMethod("setGalaxyName", String.class).getModifiers()), "The method setGalaxyName(String) must not be final");
            assertEquals(void.class, SpaceGame.class.getDeclaredMethod("setGalaxyName", String.class).getReturnType(), "The method setGalaxyName(String) must return void");

            assertTrue(Modifier.isPublic(SpaceGame.class.getDeclaredMethod("getSpaceships").getModifiers()), "The method getSpaceships() must be public");
            assertFalse(Modifier.isStatic(SpaceGame.class.getDeclaredMethod("getSpaceships").getModifiers()), "The method getSpaceships() must not be static");
            assertFalse(Modifier.isFinal(SpaceGame.class.getDeclaredMethod("getSpaceships").getModifiers()), "The method getSpaceships() must not be final");
            assertEquals(List.class, SpaceGame.class.getDeclaredMethod("getSpaceships").getReturnType(), "The method getSpaceships() must return a List");

            assertTrue(Modifier.isPublic(SpaceGame.class.getDeclaredMethod("getMaxSpaceships").getModifiers()), "The method getMaxSpaceships() must be public");
            assertFalse(Modifier.isStatic(SpaceGame.class.getDeclaredMethod("getMaxSpaceships").getModifiers()), "The method getMaxSpaceships() must not be static");
            assertFalse(Modifier.isFinal(SpaceGame.class.getDeclaredMethod("getMaxSpaceships").getModifiers()), "The method getMaxSpaceships() must not be final");
            assertEquals(int.class, SpaceGame.class.getDeclaredMethod("getMaxSpaceships").getReturnType(), "The method getMaxSpaceships() must return an int");

            assertTrue(Modifier.isPublic(SpaceGame.class.getDeclaredMethod("addSpaceShip", SpaceShip.class).getModifiers()), "The method addSpaceShip(SpaceShip) must be public");
            assertFalse(Modifier.isStatic(SpaceGame.class.getDeclaredMethod("addSpaceShip", SpaceShip.class).getModifiers()), "The method addSpaceShip(SpaceShip) must not be static");
            assertFalse(Modifier.isFinal(SpaceGame.class.getDeclaredMethod("addSpaceShip", SpaceShip.class).getModifiers()), "The method addSpaceShip(SpaceShip) must not be final");
            assertEquals(boolean.class, SpaceGame.class.getDeclaredMethod("addSpaceShip", SpaceShip.class).getReturnType(), "The method addSpaceShip(SpaceShip) must return void");

            assertTrue(Modifier.isPublic(SpaceGame.class.getDeclaredMethod("removeSpaceShip", SpaceShip.class).getModifiers()), "The method removeSpaceShip(SpaceShip) must be public");
            assertFalse(Modifier.isStatic(SpaceGame.class.getDeclaredMethod("removeSpaceShip", SpaceShip.class).getModifiers()), "The method removeSpaceShip(SpaceShip) must not be static");
            assertFalse(Modifier.isFinal(SpaceGame.class.getDeclaredMethod("removeSpaceShip", SpaceShip.class).getModifiers()), "The method removeSpaceShip(SpaceShip) must not be final");
            assertEquals(boolean.class, SpaceGame.class.getDeclaredMethod("removeSpaceShip", SpaceShip.class).getReturnType(), "The method removeSpaceShip(SpaceShip) must return void");

            assertTrue(Modifier.isPublic(SpaceGame.class.getDeclaredMethod("toString").getModifiers()), "The method toString() must be public");
            assertFalse(Modifier.isStatic(SpaceGame.class.getDeclaredMethod("toString").getModifiers()), "The method toString() must not be static");
            assertFalse(Modifier.isFinal(SpaceGame.class.getDeclaredMethod("toString").getModifiers()), "The method toString() must not be final");
            assertEquals(String.class, SpaceGame.class.getDeclaredMethod("toString").getReturnType(), "The method toString() must return a String");
        } catch (NoSuchMethodException e) {
            fail("[ERROR] There is some problem with the definition of methods: " + e.getMessage());
        }
    }

    @Test
    @Order(4)
    @Tag("minimum")
    @DisplayName("Minimum - Valid parameters")
    public void createSpaceGame() {
        try {
            SpaceGame spaceGame = new SpaceGame("Milky Way");

            assertEquals("Milky Way", spaceGame.getGalaxyName(), "The galaxy name must be 'Milky Way'.");
            assertNotNull(spaceGame.getSpaceships(), "The spaceships list must not be null.");
            assertEquals(0, spaceGame.getSpaceships().size(), "The spaceships list must be empty.");
            assertEquals(10, spaceGame.getMaxSpaceships(), "The maximum number of spaceships must be 10.");
        } catch (SpaceGameException e) {
            fail("SpaceGameException");
        }
    }

    @Test
    @Order(5)
    @Tag("minimum")
    @DisplayName("Minimum - Name")
    public void createSpaceGameName() {
        try {
            Exception exception = assertThrows(SpaceGameException.class, () -> new SpaceGame(null));
            assertEquals(SpaceGameException.class, exception.getClass(), "The exception must be of type SpaceGameException.");
            assertEquals(SpaceGameException.INVALID_GALAXY_NAME, exception.getMessage(), "SpaceGameException message must be INVALID_GALAXY_NAME.");

            exception = assertThrows(SpaceGameException.class, () -> new SpaceGame(""));
            assertEquals(SpaceGameException.class, exception.getClass(), "The exception must be of type SpaceGameException.");
            assertEquals(SpaceGameException.INVALID_GALAXY_NAME, exception.getMessage(), "SpaceGameException message must be INVALID_GALAXY_NAME.");

            exception = assertThrows(SpaceGameException.class, () -> new SpaceGame("   "));
            assertEquals(SpaceGameException.class, exception.getClass(), "The exception must be of type SpaceGameException.");
            assertEquals(SpaceGameException.INVALID_GALAXY_NAME, exception.getMessage(), "SpaceGameException message must be INVALID_GALAXY_NAME.");

            SpaceGame spaceGame = new SpaceGame("Andromeda");
            assertEquals("Andromeda", spaceGame.getGalaxyName(), "The galaxy name must be 'Andromeda'.");

            exception = assertThrows(SpaceGameException.class, () -> spaceGame.setGalaxyName(null));
            assertEquals(SpaceGameException.class, exception.getClass(), "The exception must be of type SpaceGameException.");
            assertEquals(SpaceGameException.INVALID_GALAXY_NAME, exception.getMessage(), "SpaceGameException message must be INVALID_GALAXY_NAME.");

            exception = assertThrows(SpaceGameException.class, () -> spaceGame.setGalaxyName(""));
            assertEquals(SpaceGameException.class, exception.getClass(), "The exception must be of type SpaceGameException.");
            assertEquals(SpaceGameException.INVALID_GALAXY_NAME, exception.getMessage(), "SpaceGameException message must be INVALID_GALAXY_NAME.");

            exception = assertThrows(SpaceGameException.class, () -> spaceGame.setGalaxyName("   "));
            assertEquals(SpaceGameException.class, exception.getClass(), "The exception must be of type SpaceGameException.");
            assertEquals(SpaceGameException.INVALID_GALAXY_NAME, exception.getMessage(), "SpaceGameException message must be INVALID_GALAXY_NAME.");

            spaceGame.setGalaxyName("Milky Way");
            assertEquals("Milky Way", spaceGame.getGalaxyName(), "The galaxy name must be 'Milky Way'.");
        } catch (SpaceGameException e) {
            fail("SpaceGameException");
        }
    }

    @Test
    @Order(6)
    @Tag("Advanced")
    @DisplayName("Advanced - Add SpaceShip")
    public void testAddSpaceShip() {
        try {
            SpaceGame spaceGame = new SpaceGame("Milky Way");

            Exception exception = assertThrows(SpaceGameException.class, () -> spaceGame.addSpaceShip(null));
            assertEquals(SpaceGameException.class, exception.getClass(), "The exception must be of type SpaceGameException.");
            assertEquals(SpaceGameException.NULL_SPACESHIP, exception.getMessage(), "SpaceGameException message must be NULL_SPACESHIP.");

            SpaceShip ship = new SpaceShip("SS-1", 100, 50.0, SpaceShipRolType.SCIENCE);
            assertTrue(spaceGame.addSpaceShip(ship));
            assertEquals(spaceGame.getSpaceships().getFirst(), ship, "The spaceship added must be SS-1.");
            assertEquals(1, spaceGame.getSpaceships().size(), "The number of spaceships must be 1.");

            SpaceShip duplicatedShip = ship;
            exception = assertThrows(SpaceGameException.class, () -> spaceGame.addSpaceShip(duplicatedShip));
            assertEquals(SpaceGameException.class, exception.getClass(), "The exception must be of type SpaceGameException.");
            assertEquals(SpaceGameException.SPACESHIP_ALREADY_EXISTS, exception.getMessage(), "SpaceGameException message must be SPACESHIP_ALREADY_EXISTS.");

            for (int i = 2; i <= spaceGame.getMaxSpaceships(); i++) {
                ship = new SpaceShip("SS-" + i, 100, 50.0, SpaceShipRolType.BATTLE);
                assertTrue(spaceGame.addSpaceShip(ship));
                assertEquals(spaceGame.getSpaceships().get(i - 1), ship, "The spaceship added must be SS-" + i + ".");
                assertEquals(i, spaceGame.getSpaceships().size(), "The number of spaceships must be " + i + ".");
            }

            SpaceShip extraShip = new SpaceShip("SS-Extra", 100, 50.0, SpaceShipRolType.DIPLOMATIC);
            exception = assertThrows(SpaceGameException.class, () -> spaceGame.addSpaceShip(extraShip));
            assertEquals(SpaceGameException.class, exception.getClass(), "The exception must be of type SpaceGameException.");
            assertEquals(SpaceGameException.MAX_SPACESHIPS_REACHED, exception.getMessage(), "SpaceGameException message must be MAX_SPACESHIPS_REACHED.");

            exception = assertThrows(SpaceGameException.class, () -> spaceGame.addSpaceShip(duplicatedShip));
            assertEquals(SpaceGameException.class, exception.getClass(), "The exception must be of type SpaceGameException.");
            assertEquals(SpaceGameException.SPACESHIP_ALREADY_EXISTS, exception.getMessage(), "SpaceGameException message must be SPACESHIP_ALREADY_EXISTS.");
        } catch (SpaceGameException | SpaceShipException e) {
            fail("SpaceGameException");
        }
    }

    @Test
    @Order(7)
    @Tag("Advanced")
    @DisplayName("Advanced - Remove SpaceShip")
    public void testRemoveSpaceShip() {
        try {
            SpaceGame spaceGame = new SpaceGame("Milky Way");

            SpaceShip ship1 = new SpaceShip("SS-1", 100, 50.0, SpaceShipRolType.SCIENCE);
            SpaceShip ship2 = new SpaceShip("SS-2", 100, 50.0, SpaceShipRolType.BATTLE);
            SpaceShip ship3 = new SpaceShip("SS-3", 100, 50.0, SpaceShipRolType.DIPLOMATIC);
            assertTrue(spaceGame.addSpaceShip(ship1));
            assertTrue(spaceGame.addSpaceShip(ship2));
            assertEquals(2, spaceGame.getSpaceships().size(), "The number of spaceships must be 2.");

            Exception exception = assertThrows(SpaceGameException.class, () -> spaceGame.removeSpaceShip(null));
            assertEquals(SpaceGameException.class, exception.getClass(), "The exception must be of type SpaceGameException.");
            assertEquals(SpaceGameException.NULL_SPACESHIP, exception.getMessage(), "SpaceGameException message must be NULL_SPACESHIP.");

            exception = assertThrows(SpaceGameException.class, () -> spaceGame.removeSpaceShip(ship3));
            assertEquals(SpaceGameException.class, exception.getClass(), "The exception must be of type SpaceGameException.");
            assertEquals(SpaceGameException.SPACESHIP_NOT_FOUND, exception.getMessage(), "SpaceGameException message must be SPACESHIP_NOT_FOUND.");

            assertTrue(spaceGame.removeSpaceShip(ship1));
            assertEquals(1, spaceGame.getSpaceships().size(), "The number of spaceships must be 1.");
            assertFalse(spaceGame.getSpaceships().contains(ship1), "The spaceship SS-1 must have been removed.");

            assertTrue(spaceGame.removeSpaceShip(ship2));
            assertEquals(0, spaceGame.getSpaceships().size(), "The number of spaceships must be 0.");
            assertFalse(spaceGame.getSpaceships().contains(ship2), "The spaceship SS-2 must have been removed.");
        } catch (SpaceGameException | SpaceShipException e) {
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
    @Order(8)
    @Tag("advanced")
    @DisplayName("Advanced - toString")
    public void testToString() {
        try {
            SpaceGame spaceGame = new SpaceGame("Milky Way");
            String expectedJsonEmpty = "{ \"galaxyName\": \"Milky Way\", \"spaceships\": [] }";
            assertEquals(normalizeJson(expectedJsonEmpty), normalizeJson(spaceGame.toString()), "The JSON representation of the empty SpaceGame is incorrect.");

            SpaceShip ship1 = new SpaceShip("SS-1", 100, 50.0, SpaceShipRolType.SCIENCE);
            SpaceShip ship2 = new SpaceShip("SS-2", 100, 50.0, SpaceShipRolType.BATTLE);
            spaceGame.addSpaceShip(ship1);
            spaceGame.addSpaceShip(ship2);

            String expectedJsonWithShips = "{ \"galaxyName\": \"Milky Way\", \"spaceships\": [ " +
                    ship1 + ", " +
                    ship2 +
                    " ] }";
            assertEquals(normalizeJson(expectedJsonWithShips), normalizeJson(spaceGame.toString()), "The JSON representation of the SpaceGame with spaceships is incorrect.");
        } catch (SpaceGameException | SpaceShipException e) {
            fail("SpaceGameException");
        }
    }

}
