package edu.uoc.pac4.ship;

import edu.uoc.pac4.alien.Alien;
import edu.uoc.pac4.alien.HumanoidAlien;
import edu.uoc.pac4.alien.ShadowAlien;
import org.junit.jupiter.api.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DeathStarTest {

    @Test
    @Order(1)
    @Tag("sanity")
    @DisplayName("Sanity - Fields definition")
    public void checkFields() {
        int numFields = 3;

        // Check attribute fields
        assertEquals(numFields, DeathStar.class.getDeclaredFields().length, "The class must have exactly " + numFields + " fields.");

        try {
            assertTrue(Modifier.isPrivate(Cargo.class.getDeclaredField("PEOPLE_CAPACITY").getModifiers()), "The attribute PEOPLE_CAPACITY must be private.");
            assertTrue(Modifier.isStatic(Cargo.class.getDeclaredField("PEOPLE_CAPACITY").getModifiers()), "The attribute PEOPLE_CAPACITY must be static.");
            assertTrue(Modifier.isFinal(Cargo.class.getDeclaredField("PEOPLE_CAPACITY").getModifiers()), "The attribute PEOPLE_CAPACITY must be final.");
            assertEquals(int.class, Cargo.class.getDeclaredField("PEOPLE_CAPACITY").getType(), "The attribute PEOPLE_CAPACITY must be of type int.");

            assertTrue(Modifier.isPrivate(DeathStar.class.getDeclaredField("CARGO_CAPACITY").getModifiers()), "The attribute CARGO_CAPACITY must be private.");
            assertTrue(Modifier.isStatic(DeathStar.class.getDeclaredField("CARGO_CAPACITY").getModifiers()), "The attribute CARGO_CAPACITY must be static.");
            assertTrue(Modifier.isFinal(DeathStar.class.getDeclaredField("CARGO_CAPACITY").getModifiers()), "The attribute CARGO_CAPACITY must be final.");
            assertEquals(double.class, DeathStar.class.getDeclaredField("CARGO_CAPACITY").getType(), "The attribute CARGO_CAPACITY must be of type double.");

            assertTrue(Modifier.isPrivate(DeathStar.class.getDeclaredField("laserPower").getModifiers()), "The attribute laserPower must be private.");
            assertFalse(Modifier.isStatic(DeathStar.class.getDeclaredField("laserPower").getModifiers()), "The attribute laserPower must not be static.");
            assertFalse(Modifier.isFinal(DeathStar.class.getDeclaredField("laserPower").getModifiers()), "The attribute laserPower must not be final.");
            assertEquals(double.class, DeathStar.class.getDeclaredField("laserPower").getType(), "The attribute laserPower must be of type double.");
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

        Constructor<?>[] declaredConstructors = DeathStar.class.getDeclaredConstructors();
        assertEquals(numConstructors, declaredConstructors.length,
                "The class must declare exactly " + numConstructors + " constructor");

        try {
            Constructor<?> constructor = DeathStar.class.getDeclaredConstructor(String.class, SpaceShipRolType.class, double.class);

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
        assertEquals(SpaceShip.class, DeathStar.class.getSuperclass(), "The class DeathStar must directly extend the SpaceShip class");
    }

    @Test
    @Order(4)
    @Tag("sanity")
    @DisplayName("Sanity - Methods definition")
    public void checkMethods() {
        int numMethods = 3;

        // Check number of methods
        assertEquals(numMethods, DeathStar.class.getDeclaredMethods().length, "The class must have exactly " + numMethods + " methods");

        try {
            assertTrue(Modifier.isPublic(DeathStar.class.getDeclaredMethod("getLaserPower").getModifiers()), "The method getLaserPower() must be public");
            assertFalse(Modifier.isStatic(DeathStar.class.getDeclaredMethod("getLaserPower").getModifiers()), "The method getLaserPower() must not be static");
            assertFalse(Modifier.isFinal(DeathStar.class.getDeclaredMethod("getLaserPower").getModifiers()), "The method getLaserPower() must not be final");
            assertEquals(double.class, DeathStar.class.getDeclaredMethod("getLaserPower").getReturnType(), "The method getLaserPower() must return a double");

            assertTrue(Modifier.isPublic(DeathStar.class.getDeclaredMethod("setLaserPower", double.class).getModifiers()), "The method setLaserPower(double) must be public");
            assertFalse(Modifier.isStatic(DeathStar.class.getDeclaredMethod("setLaserPower", double.class).getModifiers()), "The method setLaserPower(double) must not be static");
            assertFalse(Modifier.isFinal(DeathStar.class.getDeclaredMethod("setLaserPower", double.class).getModifiers()), "The method setLaserPower(double) must not be final");
            assertEquals(void.class, DeathStar.class.getDeclaredMethod("setLaserPower", double.class).getReturnType(), "The method setLaserPower(double) must return void");

            assertTrue(Modifier.isPublic(DeathStar.class.getDeclaredMethod("toString").getModifiers()), "The method toString() must be public");
            assertFalse(Modifier.isStatic(DeathStar.class.getDeclaredMethod("toString").getModifiers()), "The method toString() must not be static");
            assertFalse(Modifier.isFinal(DeathStar.class.getDeclaredMethod("toString").getModifiers()), "The method toString() must not be final");
            assertEquals(String.class, DeathStar.class.getDeclaredMethod("toString").getReturnType(), "The method toString() must return a String");
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
            DeathStar deathStar = new DeathStar("SS-001", SpaceShipRolType.BATTLE, 150.0);
            assertEquals("SS-001", deathStar.getId());
            assertEquals(5000, deathStar.getCargoCapacity());
            assertEquals(10000, deathStar.getPeopleCapacity());
            assertEquals(SpaceShipRolType.BATTLE, deathStar.getSpaceShipRolType());
            assertEquals(150.0, deathStar.getLaserPower());
        } catch (Exception e) {
            fail("Constructor threw an exception for valid parameters: " + e.getMessage());
        }
    }

    @Test
    @Order(6)
    @Tag("minimum")
    @DisplayName("Minimum - Laser power")
    public void testLaserPower() {
        try {
            Exception exception = assertThrows(SpaceShipException.class, () -> new DeathStar("SS-002", SpaceShipRolType.SCIENCE, 0.0));
            assertEquals("[ERROR] Laser power must be greater than 0.", exception.getMessage());
            assertEquals(SpaceShipException.class, exception.getClass());

            DeathStar deathStar = new DeathStar("SS-003", SpaceShipRolType.DIPLOMATIC, 0.1);
            assertEquals(0.1, deathStar.getLaserPower());

            deathStar = new DeathStar("SS-004", SpaceShipRolType.BATTLE, 100.5);
            assertEquals(100.5, deathStar.getLaserPower());

            deathStar.setLaserPower(50.0);
            assertEquals(50.0, deathStar.getLaserPower());

            DeathStar finalDeathStar = deathStar;
            exception = assertThrows(SpaceShipException.class, () -> finalDeathStar.setLaserPower(-0.1));
            assertEquals("[ERROR] Laser power must be greater than 0.", exception.getMessage());
            assertEquals(SpaceShipException.class, exception.getClass());
        } catch (Exception e) {
            fail("Constructor threw an exception for valid laser power: " + e.getMessage());
        }
    }

    @Test
    @Order(7)
    @Tag("advanced")
    @DisplayName("Advanced - toString without aliens")
    public void testToStringWithoutAliens() {
        try {
            DeathStar deathStar = new DeathStar("SS-003", SpaceShipRolType.BATTLE, 5.0);
            String expected = "{ \"type\": \"DeathStar\", \"details\": { \"id\": \"SS-003\", \"peopleCapacity\": 10000, \"cargoCapacity\": 5000.0, \"rol\": \"Battle\", \"aliens\": [] }, \"laserPower\": 5.00 }";
            assertEquals(expected, deathStar.toString());

            deathStar = new DeathStar("SS-004", SpaceShipRolType.SCIENCE, 15.0);
            expected = "{ \"type\": \"DeathStar\", \"details\": { \"id\": \"SS-004\", \"peopleCapacity\": 10000, \"cargoCapacity\": 5000.0, \"rol\": \"Science\", \"aliens\": [] }, \"laserPower\": 15.00 }";
            assertEquals(expected, deathStar.toString());
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
            DeathStar deathStar = new DeathStar("SS-005", SpaceShipRolType.DIPLOMATIC, 100.7);
            Alien alien1 = new HumanoidAlien("Zorg", 70);
            Alien alien2 = new ShadowAlien("Xenon", 80);
            deathStar.addAlien(alien1);
            deathStar.addAlien(alien2);

            String expected = "{ \"type\": \"DeathStar\", \"details\": { \"id\": \"SS-005\", \"peopleCapacity\": 10000, \"cargoCapacity\": 5000.0, \"rol\": \"Diplomatic\", \"aliens\": [{ \"type\": \"HumanoidAlien\", \"alienDetails\": { \"name\": \"Zorg\" }, \"stamina\": 70 }, { \"type\": \"ShadowAlien\", \"etherealAlienDetails\": { \"alienDetails\": { \"name\": \"Xenon\" }, \"transparencyLevel\": 0.85 }, \"stealthLevel\": 80 }] }, \"laserPower\": 100.70 }";
            assertEquals(expected, deathStar.toString());
        } catch (Exception e) {
            fail("toString method threw an exception: " + e.getMessage());
        }
    }

}
