package edu.uoc.pac4.ship;

import edu.uoc.pac4.alien.Alien;
import edu.uoc.pac4.alien.HumanoidAlien;
import edu.uoc.pac4.alien.ShadowAlien;
import org.junit.jupiter.api.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SpaceShipTest {

    @Test
    @Order(1)
    @Tag("sanity")
    @DisplayName("Sanity - Fields definition")
    public void checkFields() {
        int numFields = 5;

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

            assertTrue(Modifier.isPrivate(SpaceShip.class.getDeclaredField("aliens").getModifiers()), "The attribute aliens must be private.");
            assertFalse(Modifier.isStatic(SpaceShip.class.getDeclaredField("aliens").getModifiers()), "The attribute aliens must not be static.");
            assertFalse(Modifier.isFinal(SpaceShip.class.getDeclaredField("aliens").getModifiers()), "The attribute aliens must not be final.");
            assertEquals(List.class, SpaceShip.class.getDeclaredField("aliens").getType(), "The attribute aliens must be of type int.");
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

        Constructor<?>[] declaredConstructors = SpaceShip.class.getDeclaredConstructors();
        assertEquals(numConstructors, declaredConstructors.length,
                "The class must declare exactly " + numConstructors + " constructor");

        try {
            Constructor<?> constructor = SpaceShip.class.getDeclaredConstructor(
                    String.class, int.class, double.class, SpaceShipRolType.class);

            int modifiers = constructor.getModifiers();

            assertTrue(Modifier.isProtected(modifiers), "The constructor SpaceShip(String, int, double, SpaceShipRolType) must be protected");
            assertFalse(Modifier.isPublic(modifiers), "The constructor must not be public");
            assertFalse(Modifier.isPrivate(modifiers), "The constructor must not be private");
        } catch (NoSuchMethodException e) {
            fail("[ERROR] There is some problem with the definition of constructors: " + e.getMessage());
        }
    }

    @Test
    @Order(3)
    @Tag("sanity")
    @DisplayName("Sanity - Abstract definition")
    public void checkAbstract() {
        assertTrue(Modifier.isAbstract(SpaceShip.class.getModifiers()), "The class SpaceShip must be abstract");
    }

    @Test
    @Order(4)
    @Tag("sanity")
    @DisplayName("Sanity - Methods definition")
    public void checkMethods() {
        int numMethods = 12;

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

            assertTrue(Modifier.isPublic(SpaceShip.class.getMethod("getAliens").getModifiers()), "The method getAliens() must be public");
            assertFalse(Modifier.isStatic(SpaceShip.class.getMethod("getAliens").getModifiers()), "The method getAliens() must not be static");
            assertFalse(Modifier.isFinal(SpaceShip.class.getMethod("getAliens").getModifiers()), "The method getAliens() must not be final");
            assertEquals(List.class, SpaceShip.class.getMethod("getAliens").getReturnType(), "The method getAliens() must return a List");

            assertTrue(Modifier.isPublic(SpaceShip.class.getMethod("addAlien", Alien.class).getModifiers()), "The method addAlien(Alien) must be public");
            assertFalse(Modifier.isStatic(SpaceShip.class.getMethod("addAlien", Alien.class).getModifiers()), "The method addAlien(Alien) must not be static");
            assertFalse(Modifier.isFinal(SpaceShip.class.getMethod("addAlien", Alien.class).getModifiers()), "The method addAlien(Alien) must not be final");
            assertEquals(boolean.class, SpaceShip.class.getMethod("addAlien", Alien.class).getReturnType(), "The method addAlien(Alien) must return void");

            assertTrue(Modifier.isPublic(SpaceShip.class.getMethod("removeAlien", Alien.class).getModifiers()), "The method removeAlien(Alien) must be public");
            assertFalse(Modifier.isStatic(SpaceShip.class.getMethod("removeAlien", Alien.class).getModifiers()), "The method removeAlien(Alien) must not be static");
            assertFalse(Modifier.isFinal(SpaceShip.class.getMethod("removeAlien", Alien.class).getModifiers()), "The method removeAlien(Alien) must not be final");
            assertEquals(boolean.class, SpaceShip.class.getMethod("removeAlien", Alien.class).getReturnType(), "The method removeAlien(Alien) must return void");
        } catch (NoSuchMethodException e) {
            fail("[ERROR] There is some problem with the definition of methods: " + e.getMessage());
        }
    }

    @Test
    @Order(5)
    @Tag("advanced")
    @DisplayName("Advanced - Add aliens")
    public void testAddAliens() {
        try {
            SpaceShip spaceShip = new Cargo("SS-01", 100, SpaceShipRolType.DIPLOMATIC, true);
            Alien alien1 = new ShadowAlien("Alien-001", 85);
            Alien alien2 = new HumanoidAlien("Alien-002", 90);

            Exception exception = assertThrows(SpaceShipException.class, () -> spaceShip.addAlien(null));
            assertEquals("[ERROR] Alien cannot be null.", exception.getMessage(), "Adding a null alien should throw SpaceShipException with correct message");
            assertEquals(SpaceShipException.class, exception.getClass(), "Adding a null alien should throw SpaceShipException");

            assertTrue(spaceShip.addAlien(alien1), "Adding first alien should return true");
            assertTrue(spaceShip.getAliens().contains(alien1));

            assertTrue(spaceShip.addAlien(alien2), "Adding second alien should return true");
            assertTrue(spaceShip.getAliens().contains(alien2));

            exception = assertThrows(SpaceShipException.class, () -> spaceShip.addAlien(alien1));
            assertEquals("[ERROR] Alien already exists in the spaceship.", exception.getMessage(), "Adding duplicate alien should throw SpaceShipException with correct message");
            assertEquals(SpaceShipException.class, exception.getClass(), "Adding duplicate alien should throw SpaceShipException");

            for (int i = 3; i <= 500; i++) {
                Alien alien = new HumanoidAlien("Alien-" + String.format("%03d", i), 70 + i % 30);
                assertTrue(spaceShip.addAlien(alien), "Adding alien " + alien.getName() + " should return true");
                assertTrue(spaceShip.getAliens().contains(alien));
            }

            exception = assertThrows(SpaceShipException.class, () -> spaceShip.addAlien(new ShadowAlien("Alien-501", 95)));
            assertEquals("[ERROR] People capacity exceeded.", exception.getMessage(), "Adding alien beyond capacity should throw SpaceShipException with correct message");
            assertEquals(SpaceShipException.class, exception.getClass(), "Adding alien beyond capacity should throw SpaceShipException");

            exception = assertThrows(SpaceShipException.class, () -> spaceShip.addAlien(alien1));
            assertEquals("[ERROR] Alien already exists in the spaceship.", exception.getMessage(), "Adding duplicate alien should still throw SpaceShipException with correct message");
            assertEquals(SpaceShipException.class, exception.getClass(), "Adding duplicate alien should still throw SpaceShipException");
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the definition of methods: " + e.getMessage());
        }
    }

    @Test
    @Order(6)
    @Tag("advanced")
    @DisplayName("Advanced - Remove aliens")
    public void testRemoveAliens() {
        try {
            SpaceShip spaceShip = new Cruiser("SS-02", 50, SpaceShipRolType.BATTLE, 10);
            Alien alien1 = new ShadowAlien("Alien-101", 80);
            Alien alien2 = new HumanoidAlien("Alien-102", 90);

            assertTrue(spaceShip.addAlien(alien1), "Adding first alien should return true");
            assertTrue(spaceShip.getAliens().contains(alien1));

            assertTrue(spaceShip.addAlien(alien2), "Adding second alien should return true");
            assertTrue(spaceShip.getAliens().contains(alien2));

            Exception exception = assertThrows(SpaceShipException.class, () -> spaceShip.removeAlien(null));
            assertEquals("[ERROR] Alien cannot be null.", exception.getMessage(), "Removing a null alien should throw SpaceShipException with correct message");
            assertEquals(SpaceShipException.class, exception.getClass(), "Removing a null alien should throw SpaceShipException");

            assertTrue(spaceShip.removeAlien(alien1), "Removing existing alien should return true");
            assertFalse(spaceShip.getAliens().contains(alien1), "Alien1 should no longer be in the spaceship");

            assertFalse(spaceShip.removeAlien(alien1), "Removing non-existing alien should return false");

            assertTrue(spaceShip.removeAlien(alien2), "Removing existing alien should return true");
            assertFalse(spaceShip.getAliens().contains(alien2), "Alien2 should no longer be in the spaceship");
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the definition of methods: " + e.getMessage());
        }
    }

}
