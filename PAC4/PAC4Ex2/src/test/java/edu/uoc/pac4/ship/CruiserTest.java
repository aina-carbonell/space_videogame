package edu.uoc.pac4.ship;

import edu.uoc.pac4.alien.Alien;
import edu.uoc.pac4.alien.HumanoidAlien;
import edu.uoc.pac4.alien.ShadowAlien;
import org.junit.jupiter.api.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CruiserTest {

    @Test
    @Order(1)
    @Tag("sanity")
    @DisplayName("Sanity - Fields definition")
    public void checkFields() {
        int numFields = 2;

        // Check attribute fields
        assertEquals(numFields, Cruiser.class.getDeclaredFields().length, "The class must have exactly " + numFields + " fields.");

        try {
            assertTrue(Modifier.isPrivate(Cruiser.class.getDeclaredField("CARGO_CAPACITY").getModifiers()), "The attribute CARGO_CAPACITY must be private.");
            assertTrue(Modifier.isStatic(Cruiser.class.getDeclaredField("CARGO_CAPACITY").getModifiers()), "The attribute CARGO_CAPACITY must be static.");
            assertTrue(Modifier.isFinal(Cruiser.class.getDeclaredField("CARGO_CAPACITY").getModifiers()), "The attribute CARGO_CAPACITY must be final.");
            assertEquals(double.class, Cruiser.class.getDeclaredField("CARGO_CAPACITY").getType(), "The attribute CARGO_CAPACITY must be of type double.");

            assertTrue(Modifier.isPrivate(Cruiser.class.getDeclaredField("numberOfCannons").getModifiers()), "The attribute numberOfCannons must be private.");
            assertFalse(Modifier.isStatic(Cruiser.class.getDeclaredField("numberOfCannons").getModifiers()), "The attribute numberOfCannons must not be static.");
            assertFalse(Modifier.isFinal(Cruiser.class.getDeclaredField("numberOfCannons").getModifiers()), "The attribute numberOfCannons must not be final.");
            assertEquals(int.class, Cruiser.class.getDeclaredField("numberOfCannons").getType(), "The attribute numberOfCannons must be of type int.");
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

        Constructor<?>[] declaredConstructors = Cruiser.class.getDeclaredConstructors();
        assertEquals(numConstructors, declaredConstructors.length,
                "The class must declare exactly " + numConstructors + " constructor");

        try {
            Constructor<?> constructor = Cruiser.class.getDeclaredConstructor(String.class, int.class, SpaceShipRolType.class, int.class);

            int modifiers = constructor.getModifiers();

            assertFalse(Modifier.isProtected(modifiers), "The constructor must not be protected");
            assertTrue(Modifier.isPublic(modifiers), "The constructor must be public");
            assertFalse(Modifier.isPrivate(modifiers), "The constructor must not be private");
        } catch (NoSuchMethodException e) {
            fail("[ERROR] There is some problem with the definition of constructors: " + e.getMessage());
        }
    }

    @Test
    @Order(3)
    @Tag("sanity")
    @DisplayName("Sanity - Inheritance definition")
    public void checkInheritance() {
        assertEquals(SpaceShip.class, Cruiser.class.getSuperclass(), "The class Cruiser must directly extend the SpaceShip class");
    }

    @Test
    @Order(4)
    @Tag("sanity")
    @DisplayName("Sanity - Methods definition")
    public void checkMethods() {
        int numMethods = 3;

        // Check number of methods
        assertEquals(numMethods, Cruiser.class.getDeclaredMethods().length, "The class must have exactly " + numMethods + " methods");

        try {
            assertTrue(Modifier.isPublic(Cruiser.class.getDeclaredMethod("getNumberOfCannons").getModifiers()), "The method getNumberOfCannons() must be public");
            assertFalse(Modifier.isStatic(Cruiser.class.getDeclaredMethod("getNumberOfCannons").getModifiers()), "The method getNumberOfCannons() must not be static");
            assertFalse(Modifier.isFinal(Cruiser.class.getDeclaredMethod("getNumberOfCannons").getModifiers()), "The method getNumberOfCannons() must not be final");
            assertEquals(int.class, Cruiser.class.getDeclaredMethod("getNumberOfCannons").getReturnType(), "The method getNumberOfCannons() must return a int");

            assertTrue(Modifier.isPublic(Cruiser.class.getDeclaredMethod("setNumberOfCannons", int.class).getModifiers()), "The method setNumberOfCannons(int) must be public");
            assertFalse(Modifier.isStatic(Cruiser.class.getDeclaredMethod("setNumberOfCannons", int.class).getModifiers()), "The method setNumberOfCannons(int) must not be static");
            assertFalse(Modifier.isFinal(Cruiser.class.getDeclaredMethod("setNumberOfCannons", int.class).getModifiers()), "The method setNumberOfCannons(int) must not be final");
            assertEquals(void.class, Cruiser.class.getDeclaredMethod("setNumberOfCannons", int.class).getReturnType(), "The method setNumberOfCannons(int) must return void");

            assertTrue(Modifier.isPublic(Cruiser.class.getDeclaredMethod("toString").getModifiers()), "The method toString() must be public");
            assertFalse(Modifier.isStatic(Cruiser.class.getDeclaredMethod("toString").getModifiers()), "The method toString() must not be static");
            assertFalse(Modifier.isFinal(Cruiser.class.getDeclaredMethod("toString").getModifiers()), "The method toString() must not be final");
            assertEquals(String.class, Cruiser.class.getDeclaredMethod("toString").getReturnType(), "The method toString() must return a String");
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the definition of methods: " + e.getMessage());
        }
    }

    @Test
    @Order(5)
    @Tag("minimum")
    @DisplayName("Minimum - Valid parameters")
    public void testValidParameters() {
        try {
            Cruiser cruiser = new Cruiser("SS-001", 200, SpaceShipRolType.DIPLOMATIC, 10);
            assertEquals("SS-001", cruiser.getId());
            assertEquals(8000.0, cruiser.getCargoCapacity());
            assertEquals(200, cruiser.getPeopleCapacity());
            assertEquals(SpaceShipRolType.DIPLOMATIC, cruiser.getSpaceShipRolType());
            assertEquals(10, cruiser.getNumberOfCannons());
        } catch (Exception e) {
            fail("Constructor threw an exception for valid parameters: " + e.getMessage());
        }
    }

    @Test
    @Order(6)
    @Tag("minimum")
    @DisplayName("Minimum - NumberOfCannons")
    public void testNumberOfCannons() {
        try {
            Exception exception = assertThrows(SpaceShipException.class, () -> new Cruiser("SS-002", 150, SpaceShipRolType.BATTLE, -5));
            assertEquals("[ERROR] Number of cannons cannot be negative.", exception.getMessage(), "Expected IllegalArgumentException for negative number of cannons");
            assertEquals(SpaceShipException.class, exception.getClass(), "Expected exception of type SpaceShipException");

            Cruiser cruiser = new Cruiser("SS-003", 150, SpaceShipRolType.BATTLE, 0);
            assertEquals(0, cruiser.getNumberOfCannons(), "Number of cannons should be set to 0");

            cruiser = new Cruiser("SS-004", 150, SpaceShipRolType.BATTLE, 20);
            assertEquals(20, cruiser.getNumberOfCannons(), "Number of cannons should be set to 20");

            cruiser.setNumberOfCannons(15);
            assertEquals(15, cruiser.getNumberOfCannons(), "Number of cannons should be updated to 15");

            Cruiser finalCruiser = cruiser;
            exception = assertThrows(SpaceShipException.class, () -> finalCruiser.setNumberOfCannons(-3));
            assertEquals("[ERROR] Number of cannons cannot be negative.", exception.getMessage(), "Expected SpaceShipException for negative number of cannons on setter");
            assertEquals(SpaceShipException.class, exception.getClass(), "Expected exception of type SpaceShipException");
        } catch (Exception e) {
            fail("Constructor threw an exception for valid parameters: " + e.getMessage());
        }
    }

    @Test
    @Order(7)
    @Tag("advanced")
    @DisplayName("Advanced - toString without aliens")
    public void testToStringWithoutAliens() {
        try {
            Cruiser cruiser = new Cruiser("SS-003", 350, SpaceShipRolType.BATTLE, 5);
            String expected = "{ \"type\": \"Cruiser\", \"details\": { \"id\": \"SS-003\", \"peopleCapacity\": 350, \"cargoCapacity\": 8000.0, \"rol\": \"Battle\", \"aliens\": [] }, \"numberOfCannons\": 5 }";
            assertEquals(expected, cruiser.toString());

            cruiser = new Cruiser("SS-004", 333, SpaceShipRolType.SCIENCE, 15);
            expected = "{ \"type\": \"Cruiser\", \"details\": { \"id\": \"SS-004\", \"peopleCapacity\": 333, \"cargoCapacity\": 8000.0, \"rol\": \"Science\", \"aliens\": [] }, \"numberOfCannons\": 15 }";
            assertEquals(expected, cruiser.toString());
        } catch (Exception e) {
            fail("toString method threw an exception: " + e.getMessage());
        }
    }

    @Test
    @Order(8)
    @Tag("advanced")
    @DisplayName("Advanced - toString with aliens")
    public void testToStringWithAliens() {
        try {
            Cruiser cruiser = new Cruiser("SS-005", 500, SpaceShipRolType.DIPLOMATIC, 10);
            Alien alien1 = new HumanoidAlien("Zorg", 70);
            Alien alien2 = new ShadowAlien("Xenon", 80);
            cruiser.addAlien(alien1);
            cruiser.addAlien(alien2);

            String expected = "{ \"type\": \"Cruiser\", \"details\": { \"id\": \"SS-005\", \"peopleCapacity\": 500, \"cargoCapacity\": 8000.0, \"rol\": \"Diplomatic\", \"aliens\": [{ \"type\": \"HumanoidAlien\", \"alienDetails\": { \"name\": \"Zorg\" }, \"stamina\": 70 }, { \"type\": \"ShadowAlien\", \"etherealAlienDetails\": { \"alienDetails\": { \"name\": \"Xenon\" }, \"transparencyLevel\": 0.85 }, \"stealthLevel\": 80 }] }, \"numberOfCannons\": 10 }";
            assertEquals(expected, cruiser.toString());
        } catch (Exception e) {
            fail("toString method threw an exception: " + e.getMessage());
        }
    }

}
