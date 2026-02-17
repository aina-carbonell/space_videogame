package edu.uoc.pac4.ship;

import edu.uoc.pac4.alien.Alien;
import edu.uoc.pac4.alien.HumanoidAlien;
import edu.uoc.pac4.alien.ShadowAlien;
import org.junit.jupiter.api.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CargoTest {

    @Test
    @Order(1)
    @Tag("sanity")
    @DisplayName("Sanity - Fields definition")
    public void checkFields() {
        int numFields = 2;

        // Check attribute fields
        assertEquals(numFields, Cargo.class.getDeclaredFields().length, "The class must have exactly " + numFields + " fields.");

        try {
            assertTrue(Modifier.isPrivate(Cargo.class.getDeclaredField("PEOPLE_CAPACITY").getModifiers()), "The attribute PEOPLE_CAPACITY must be private.");
            assertTrue(Modifier.isStatic(Cargo.class.getDeclaredField("PEOPLE_CAPACITY").getModifiers()), "The attribute PEOPLE_CAPACITY must be static.");
            assertTrue(Modifier.isFinal(Cargo.class.getDeclaredField("PEOPLE_CAPACITY").getModifiers()), "The attribute PEOPLE_CAPACITY must be final.");
            assertEquals(int.class, Cargo.class.getDeclaredField("PEOPLE_CAPACITY").getType(), "The attribute PEOPLE_CAPACITY must be of type int.");

            assertTrue(Modifier.isPrivate(Cargo.class.getDeclaredField("isRefrigerated").getModifiers()), "The attribute isRefrigerated must be private.");
            assertFalse(Modifier.isStatic(Cargo.class.getDeclaredField("isRefrigerated").getModifiers()), "The attribute isRefrigerated must not be static.");
            assertFalse(Modifier.isFinal(Cargo.class.getDeclaredField("isRefrigerated").getModifiers()), "The attribute isRefrigerated must not be final.");
            assertEquals(boolean.class, Cargo.class.getDeclaredField("isRefrigerated").getType(), "The attribute isRefrigerated must be of type boolean.");
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

        Constructor<?>[] declaredConstructors = Cargo.class.getDeclaredConstructors();
        assertEquals(numConstructors, declaredConstructors.length,
                "The class must declare exactly " + numConstructors + " constructor");

        try {
            Constructor<?> constructor = Cargo.class.getDeclaredConstructor(String.class, double.class, SpaceShipRolType.class, boolean.class);

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
        assertEquals(SpaceShip.class, Cargo.class.getSuperclass(), "The class Cargo must directly extend the SpaceShip class");
    }

    @Test
    @Order(4)
    @Tag("sanity")
    @DisplayName("Sanity - Methods definition")
    public void checkMethods() {
        int numMethods = 3;

        // Check number of methods
        assertEquals(numMethods, Cargo.class.getDeclaredMethods().length, "The class must have exactly " + numMethods + " methods");

        try {
            assertTrue(Modifier.isPublic(Cargo.class.getDeclaredMethod("isRefrigerated").getModifiers()), "The method isRefrigerated() must be public");
            assertFalse(Modifier.isStatic(Cargo.class.getDeclaredMethod("isRefrigerated").getModifiers()), "The method isRefrigerated() must not be static");
            assertFalse(Modifier.isFinal(Cargo.class.getDeclaredMethod("isRefrigerated").getModifiers()), "The method isRefrigerated() must not be final");
            assertEquals(boolean.class, Cargo.class.getDeclaredMethod("isRefrigerated").getReturnType(), "The method isRefrigerated() must return a boolean");

            assertTrue(Modifier.isPublic(Cargo.class.getDeclaredMethod("setRefrigerated", boolean.class).getModifiers()), "The method setRefrigerated(bool) must be public");
            assertFalse(Modifier.isStatic(Cargo.class.getDeclaredMethod("setRefrigerated", boolean.class).getModifiers()), "The method setRefrigerated(bool) must not be static");
            assertFalse(Modifier.isFinal(Cargo.class.getDeclaredMethod("setRefrigerated", boolean.class).getModifiers()), "The method setRefrigerated(bool) must not be final");
            assertEquals(void.class, Cargo.class.getDeclaredMethod("setRefrigerated", boolean.class).getReturnType(), "The method setRefrigerated(bool) must return void");

            assertTrue(Modifier.isPublic(Cargo.class.getDeclaredMethod("toString").getModifiers()), "The method toString() must be public");
            assertFalse(Modifier.isStatic(Cargo.class.getDeclaredMethod("toString").getModifiers()), "The method toString() must not be static");
            assertFalse(Modifier.isFinal(Cargo.class.getDeclaredMethod("toString").getModifiers()), "The method toString() must not be final");
            assertEquals(String.class, Cargo.class.getDeclaredMethod("toString").getReturnType(), "The method toString() must return a String");
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
            Cargo cargo = new Cargo("SS-001", 5000.0, SpaceShipRolType.SCIENCE, true);
            assertEquals("SS-001", cargo.getId());
            assertEquals(5000.0, cargo.getCargoCapacity());
            assertEquals(500, cargo.getPeopleCapacity());
            assertEquals(SpaceShipRolType.SCIENCE, cargo.getSpaceShipRolType());
            assertTrue(cargo.isRefrigerated());
        } catch (Exception e) {
            fail("Constructor threw an exception for valid parameters: " + e.getMessage());
        }
    }

    @Test
    @Order(6)
    @Tag("minimum")
    @DisplayName("Minimum - is Refrigerated")
    public void testIsRefrigerated() {
        try {
            Cargo cargo = new Cargo("SS-002", 3000.0, SpaceShipRolType.DIPLOMATIC, false);
            assertFalse(cargo.isRefrigerated());

            cargo.setRefrigerated(true);
            assertTrue(cargo.isRefrigerated());
        } catch (Exception e) {
            fail("Method threw an exception: " + e.getMessage());
        }
    }

    @Test
    @Order(7)
    @Tag("advanced")
    @DisplayName("Advanced - toString without aliens")
    public void testToStringWithoutAliens() {
        try {
            Cargo cargo = new Cargo("SS-003", 7500.0, SpaceShipRolType.BATTLE, true);
            String expected = "{ \"type\": \"Cargo\", \"details\": { \"id\": \"SS-003\", \"peopleCapacity\": 500, \"cargoCapacity\": 7500.0, \"rol\": \"Battle\", \"aliens\": [] }, \"isRefrigerated\": 1 }";
            assertEquals(expected, cargo.toString());

            cargo = new Cargo("SS-004", 6000.0, SpaceShipRolType.SCIENCE, false);
            expected = "{ \"type\": \"Cargo\", \"details\": { \"id\": \"SS-004\", \"peopleCapacity\": 500, \"cargoCapacity\": 6000.0, \"rol\": \"Science\", \"aliens\": [] }, \"isRefrigerated\": 0 }";
            assertEquals(expected, cargo.toString());
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
            Cargo cargo = new Cargo("SS-005", 8000.0, SpaceShipRolType.DIPLOMATIC, true);
            Alien alien1 = new HumanoidAlien("Zorg", 70);
            Alien alien2 = new ShadowAlien("Xenon", 80);
            cargo.addAlien(alien1);
            cargo.addAlien(alien2);

            String expected = "{ \"type\": \"Cargo\", \"details\": { \"id\": \"SS-005\", \"peopleCapacity\": 500, \"cargoCapacity\": 8000.0, \"rol\": \"Diplomatic\", \"aliens\": [{ \"type\": \"HumanoidAlien\", \"alienDetails\": { \"name\": \"Zorg\" }, \"stamina\": 70 }, { \"type\": \"ShadowAlien\", \"etherealAlienDetails\": { \"alienDetails\": { \"name\": \"Xenon\" }, \"transparencyLevel\": 0.85 }, \"stealthLevel\": 80 }] }, \"isRefrigerated\": 1 }";
            assertEquals(expected, cargo.toString());
        } catch (Exception e) {
            fail("toString method threw an exception: " + e.getMessage());
        }
    }

}
