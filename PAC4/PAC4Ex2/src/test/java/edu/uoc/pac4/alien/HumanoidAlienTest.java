package edu.uoc.pac4.alien;

import org.junit.jupiter.api.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class HumanoidAlienTest {

    @Test
    @Order(1)
    @Tag("sanity")
    @DisplayName("Sanity - Fields definition")
    public void checkFields() {
        int numFields = 1;

        // Check attribute fields
        assertEquals(numFields, HumanoidAlien.class.getDeclaredFields().length, "The class must have exactly " + numFields + " fields.");

        try {
            assertTrue(Modifier.isPrivate(HumanoidAlien.class.getDeclaredField("stamina").getModifiers()), "The attribute stamina must be private.");
            assertFalse(Modifier.isStatic(HumanoidAlien.class.getDeclaredField("stamina").getModifiers()), "The attribute stamina must not be static.");
            assertFalse(Modifier.isFinal(HumanoidAlien.class.getDeclaredField("stamina").getModifiers()), "The attribute stamina must not be final.");
            assertEquals(int.class, HumanoidAlien.class.getDeclaredField("stamina").getType(), "The attribute stamina must be of type int.");
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

        Constructor<?>[] declaredConstructors = HumanoidAlien.class.getDeclaredConstructors();
        assertEquals(numConstructors, declaredConstructors.length,
                "The class must declare exactly " + numConstructors + " constructor");

        try {
            Constructor<?> constructor = HumanoidAlien.class.getDeclaredConstructor(String.class, int.class);

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
        assertEquals(Alien.class, HumanoidAlien.class.getSuperclass(), "The class HumanoidAlien must directly extend the Alien class");
    }

    @Test
    @Order(4)
    @Tag("sanity")
    @DisplayName("Sanity - Methods definition")
    public void checkMethods() {
        int numMethods = 3;

        // Check number of methods
        assertEquals(numMethods, HumanoidAlien.class.getDeclaredMethods().length, "The class must have exactly " + numMethods + " methods");

        try {
            assertTrue(Modifier.isPublic(HumanoidAlien.class.getDeclaredMethod("getStamina").getModifiers()), "The method getStamina() must be public");
            assertFalse(Modifier.isStatic(HumanoidAlien.class.getDeclaredMethod("getStamina").getModifiers()), "The method getStamina() must not be static");
            assertFalse(Modifier.isFinal(HumanoidAlien.class.getDeclaredMethod("getStamina").getModifiers()), "The method getStamina() must not be final");
            assertEquals(int.class, HumanoidAlien.class.getDeclaredMethod("getStamina").getReturnType(), "The method getStamina() must return an int");

            assertTrue(Modifier.isPublic(HumanoidAlien.class.getDeclaredMethod("setStamina", int.class).getModifiers()), "The method setStamina(int) must be public");
            assertFalse(Modifier.isStatic(HumanoidAlien.class.getDeclaredMethod("setStamina", int.class).getModifiers()), "The method setStamina(int) must not be static");
            assertFalse(Modifier.isFinal(HumanoidAlien.class.getDeclaredMethod("setStamina", int.class).getModifiers()), "The method setStamina(int) must not be final");
            assertEquals(void.class, HumanoidAlien.class.getDeclaredMethod("setStamina", int.class).getReturnType(), "The method setStamina(int) must return void");

            assertTrue(Modifier.isPublic(HumanoidAlien.class.getDeclaredMethod("toString").getModifiers()), "The method toString() must be public");
            assertFalse(Modifier.isStatic(HumanoidAlien.class.getDeclaredMethod("toString").getModifiers()), "The method toString() must not be static");
            assertFalse(Modifier.isFinal(HumanoidAlien.class.getDeclaredMethod("toString").getModifiers()), "The method toString() must not be final");
            assertEquals(String.class, HumanoidAlien.class.getDeclaredMethod("toString").getReturnType(), "The method toString() must return a String");
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
            HumanoidAlien alien = new HumanoidAlien("Zorg", 75);
            assertEquals("Zorg", alien.getName(), "The name of the alien is incorrect.");
            assertEquals(75, alien.getStamina(), "The stamina of the alien is incorrect.");
        } catch (AlienException e) {
            fail("Constructor threw an exception for valid parameters: " + e.getMessage());
        }
    }

    @Test
    @Order(6)
    @Tag("minimum")
    @DisplayName("Minimum - Name")
    public void testName() {
        try {
            Exception exception = assertThrows(AlienException.class, () -> new HumanoidAlien(null, 50), "Constructor did not throw an exception for empty name.");
            assertEquals(AlienException.INVALID_ALIEN_NAME, exception.getMessage(), "The exception message for null name is incorrect.");
            assertEquals(AlienException.class, exception.getClass(), "The exception type for null name is incorrect.");

            exception = assertThrows(AlienException.class, () -> new HumanoidAlien("", 50), "Constructor did not throw an exception for empty name.");
            assertEquals(AlienException.INVALID_ALIEN_NAME, exception.getMessage(), "The exception message for empty name is incorrect.");
            assertEquals(AlienException.class, exception.getClass(), "The exception type for empty name is incorrect.");

            exception = assertThrows(AlienException.class, () -> new HumanoidAlien("    ", 50), "Constructor did not throw an exception for empty name.");
            assertEquals(AlienException.INVALID_ALIEN_NAME, exception.getMessage(), "The exception message for empty name is incorrect.");
            assertEquals(AlienException.class, exception.getClass(), "The exception type for empty name is incorrect.");

            Alien alien = new HumanoidAlien("Xenomorph", 60);
            assertEquals("Xenomorph", alien.getName(), "The name of the alien is incorrect.");

            exception = assertThrows(AlienException.class, () -> alien.setName(null), "setName did not throw an exception for null name.");
            assertEquals(AlienException.INVALID_ALIEN_NAME, exception.getMessage(), "The exception message for null name is incorrect.");
            assertEquals(AlienException.class, exception.getClass(), "The exception type for null name is incorrect.");

            exception = assertThrows(AlienException.class, () -> alien.setName(""), "setName did not throw an exception for empty name.");
            assertEquals(AlienException.INVALID_ALIEN_NAME, exception.getMessage(), "The exception message for empty name is incorrect.");
            assertEquals(AlienException.class, exception.getClass(), "The exception type for empty name is incorrect.");

            exception = assertThrows(AlienException.class, () -> alien.setName("   "), "setName did not throw an exception for empty name.");
            assertEquals(AlienException.INVALID_ALIEN_NAME, exception.getMessage(), "The exception message for empty name is incorrect.");
            assertEquals(AlienException.class, exception.getClass(), "The exception type for empty name is incorrect.");

            alien.setName("Predator");
            assertEquals("Predator", alien.getName(), "The name of the alien is incorrect after using setName.");
        } catch (AlienException e) {
            fail("setName threw an exception for valid name: " + e.getMessage());
        }
    }

    @Test
    @Order(7)
    @Tag("minimum")
    @DisplayName("Minimum - Stamina")
    public void testStamina() {
        try {
            HumanoidAlien alien = new HumanoidAlien("Martian", 50);
            assertEquals(50, alien.getStamina(), "The stamina of the alien is incorrect.");

            alien = new HumanoidAlien("Martian", -10);
            assertEquals(0, alien.getStamina(), "The stamina of the alien is incorrect for negative initial value.");

            alien = new HumanoidAlien("Martian", 150);
            assertEquals(100, alien.getStamina(), "The stamina of the alien is incorrect for initial value greater than 100.");

            alien.setStamina(80);
            assertEquals(80, alien.getStamina(), "The stamina of the alien is incorrect after using setStamina.");

            alien.setStamina(-20);
            assertEquals(0, alien.getStamina(), "The stamina of the alien is incorrect after using setStamina with negative value.");

            alien.setStamina(120);
            assertEquals(100, alien.getStamina(), "The stamina of the alien is incorrect after using setStamina with value greater than 100.");
        } catch (AlienException e) {
            fail("setStamina threw an exception for valid stamina: " + e.getMessage());
        }
    }

    @Test
    @Order(8)
    @Tag("advanced")
    @DisplayName("Advanced - toString")
    public void testToString() {
        try {
            HumanoidAlien alien = new HumanoidAlien("Klingon", 90);
            String expected = "{ \"type\": \"HumanoidAlien\", \"alienDetails\": { \"name\": \"Klingon\" }, \"stamina\": 90 }";
            assertEquals(expected, alien.toString(), "The toString() method does not return the expected string representation.");

            alien = new HumanoidAlien("Vulcan", 30);
            expected = "{ \"type\": \"HumanoidAlien\", \"alienDetails\": { \"name\": \"Vulcan\" }, \"stamina\": 30 }";
            assertEquals(expected, alien.toString(), "The toString() method does not return the expected string representation.");
        } catch (AlienException e) {
            fail("Constructor threw an exception for valid parameters: " + e.getMessage());
        }
    }

}
