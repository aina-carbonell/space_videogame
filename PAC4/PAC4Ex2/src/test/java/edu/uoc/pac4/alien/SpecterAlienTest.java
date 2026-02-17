package edu.uoc.pac4.alien;

import org.junit.jupiter.api.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SpecterAlienTest {

    @Test
    @Order(1)
    @Tag("sanity")
    @DisplayName("Sanity - Fields definition")
    public void checkFields() {
        int numFields = 2;

        // Check attribute fields
        assertEquals(numFields, SpecterAlien.class.getDeclaredFields().length, "The class must have exactly " + numFields + " fields.");

        try {
            assertTrue(Modifier.isPrivate(SpecterAlien.class.getDeclaredField("TRANSPARENCY_LEVEL").getModifiers()), "The attribute TRANSPARENCY_LEVEL must be private.");
            assertTrue(Modifier.isStatic(SpecterAlien.class.getDeclaredField("TRANSPARENCY_LEVEL").getModifiers()), "The attribute TRANSPARENCY_LEVEL must be static.");
            assertTrue(Modifier.isFinal(SpecterAlien.class.getDeclaredField("TRANSPARENCY_LEVEL").getModifiers()), "The attribute TRANSPARENCY_LEVEL must be final.");
            assertEquals(double.class, SpecterAlien.class.getDeclaredField("TRANSPARENCY_LEVEL").getType(), "The attribute TRANSPARENCY_LEVEL must be of type double.");

            assertTrue(Modifier.isPrivate(SpecterAlien.class.getDeclaredField("hauntingPower").getModifiers()), "The attribute hauntingPower must be private.");
            assertFalse(Modifier.isStatic(SpecterAlien.class.getDeclaredField("hauntingPower").getModifiers()), "The attribute hauntingPower must not be static.");
            assertFalse(Modifier.isFinal(SpecterAlien.class.getDeclaredField("hauntingPower").getModifiers()), "The attribute hauntingPower must not be final.");
            assertEquals(int.class, SpecterAlien.class.getDeclaredField("hauntingPower").getType(), "The attribute hauntingPower must be of type int.");
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

        Constructor<?>[] declaredConstructors = SpecterAlien.class.getDeclaredConstructors();
        assertEquals(numConstructors, declaredConstructors.length,
                "The class must declare exactly " + numConstructors + " constructor");

        try {
            Constructor<?> constructor = SpecterAlien.class.getDeclaredConstructor(String.class, int.class);

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
        assertEquals(EtherealAlien.class, SpecterAlien.class.getSuperclass(), "The class SpecterAlien must directly extend the EtherealAlien class");
    }

    @Test
    @Order(4)
    @Tag("sanity")
    @DisplayName("Sanity - Methods definition")
    public void checkMethods() {
        int numMethods = 3;

        // Check number of methods
        assertEquals(numMethods, SpecterAlien.class.getDeclaredMethods().length, "The class must have exactly " + numMethods + " methods");

        try {
            assertTrue(Modifier.isPublic(SpecterAlien.class.getDeclaredMethod("getHauntingPower").getModifiers()), "The method getHauntingPower() must be public");
            assertFalse(Modifier.isStatic(SpecterAlien.class.getDeclaredMethod("getHauntingPower").getModifiers()), "The method getHauntingPower() must not be static");
            assertFalse(Modifier.isFinal(SpecterAlien.class.getDeclaredMethod("getHauntingPower").getModifiers()), "The method getHauntingPower() must not be final");
            assertEquals(int.class, SpecterAlien.class.getDeclaredMethod("getHauntingPower").getReturnType(), "The method getHauntingPower() must return an int");

            assertTrue(Modifier.isPublic(SpecterAlien.class.getDeclaredMethod("setHauntingPower", int.class).getModifiers()), "The method setHauntingPower(int) must be public");
            assertFalse(Modifier.isStatic(SpecterAlien.class.getDeclaredMethod("setHauntingPower", int.class).getModifiers()), "The method setHauntingPower(int) must not be static");
            assertFalse(Modifier.isFinal(SpecterAlien.class.getDeclaredMethod("setHauntingPower", int.class).getModifiers()), "The method setHauntingPower(int) must not be final");
            assertEquals(void.class, SpecterAlien.class.getDeclaredMethod("setHauntingPower", int.class).getReturnType(), "The method setHauntingPower(int) must return void");

            assertTrue(Modifier.isPublic(SpecterAlien.class.getDeclaredMethod("toString").getModifiers()), "The method toString() must be public");
            assertFalse(Modifier.isStatic(SpecterAlien.class.getDeclaredMethod("toString").getModifiers()), "The method toString() must not be static");
            assertFalse(Modifier.isFinal(SpecterAlien.class.getDeclaredMethod("toString").getModifiers()), "The method toString() must not be final");
            assertEquals(String.class, SpecterAlien.class.getDeclaredMethod("toString").getReturnType(), "The method toString() must return a String");
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
            SpecterAlien alien = new SpecterAlien("SpecterOne", 80);
            assertEquals("SpecterOne", alien.getName(), "The name of the alien is incorrect.");
            assertEquals(80, alien.getHauntingPower(), "The haunting power of the alien is incorrect.");
        } catch (AlienException e) {
            fail("[ERROR] Exception should not be thrown for valid parameters: " + e.getMessage());
        }
    }

    @Test
    @Order(6)
    @Tag("minimum")
    @DisplayName("Minimum - Name")
    public void testName() {
        try {
            Exception exception = assertThrows(AlienException.class, () -> new SpecterAlien(null, 70), "Constructor did not throw an exception for null name.");
            assertEquals(AlienException.INVALID_ALIEN_NAME, exception.getMessage(), "The exception message for null name is incorrect.");
            assertEquals(AlienException.class, exception.getClass(), "The exception type for null name is incorrect.");

            exception = assertThrows(AlienException.class, () -> new SpecterAlien("", 70), "Constructor did not throw an exception for empty name.");
            assertEquals(AlienException.INVALID_ALIEN_NAME, exception.getMessage(), "The exception message for empty name is incorrect.");
            assertEquals(AlienException.class, exception.getClass(), "The exception type for empty name is incorrect.");

            exception = assertThrows(AlienException.class, () -> new SpecterAlien("   ", 70), "Constructor did not throw an exception for blank name.");
            assertEquals(AlienException.INVALID_ALIEN_NAME, exception.getMessage(), "The exception message for blank name is incorrect.");
            assertEquals(AlienException.class, exception.getClass(), "The exception type for blank name is incorrect.");

            Alien alien = new SpecterAlien("Ghost", 70);
            assertEquals("Ghost", alien.getName(), "The name of the alien is incorrect.");

            exception = assertThrows(AlienException.class, () -> alien.setName(null), "setName did not throw an exception for null name.");
            assertEquals(AlienException.INVALID_ALIEN_NAME, exception.getMessage(), "The exception message for null name is incorrect.");
            assertEquals(AlienException.class, exception.getClass(), "The exception type for null name is incorrect.");

            exception = assertThrows(AlienException.class, () -> alien.setName(""), "setName did not throw an exception for empty name.");
            assertEquals(AlienException.INVALID_ALIEN_NAME, exception.getMessage(), "The exception message for empty name is incorrect.");
            assertEquals(AlienException.class, exception.getClass(), "The exception type for empty name is incorrect.");

            exception = assertThrows(AlienException.class, () -> alien.setName("   "), "setName did not throw an exception for blank name.");
            assertEquals(AlienException.INVALID_ALIEN_NAME, exception.getMessage(), "The exception message for blank name is incorrect.");
            assertEquals(AlienException.class, exception.getClass(), "The exception type for blank name is incorrect.");

            alien.setName("Phantom");
            assertEquals("Phantom", alien.getName(), "The name of the alien is incorrect after using setName.");
        } catch (AlienException e) {
            fail("setName threw an exception for valid name: " + e.getMessage());
        }
    }

    @Test
    @Order(7)
    @Tag("minimum")
    @DisplayName("Minimum - Transparency Level")
    public void testTransparencyLevel() {
        try {
            SpecterAlien alien = new SpecterAlien("SpecterTwo", 90);
            assertEquals(0.95, alien.getTransparencyLevel(), 0.001, "The transparency level is incorrect.");

            alien.setTransparencyLevel(1.1);
            assertEquals(1.0, alien.getTransparencyLevel(), 0.001, "The transparency level should be capped at 1.0.");

            alien.setTransparencyLevel(-0.2);
            assertEquals(0.0, alien.getTransparencyLevel(), 0.001, "The transparency level should be floored at 0.0.");

            alien.setTransparencyLevel(0.5);
            assertEquals(0.5, alien.getTransparencyLevel(), 0.001, "The transparency level is incorrect after setting to 0.5.");
        } catch (AlienException e) {
            fail("[ERROR] Exception should not be thrown for valid parameters: " + e.getMessage());
        }
    }

    @Test
    @Order(8)
    @Tag("minimum")
    @DisplayName("Minimum - Haunting Power")
    public void testHauntingPower() {
        try {
            Exception exception = assertThrows(AlienException.class, () -> new SpecterAlien("SpecterInvalid", 0), "Constructor did not throw an exception for zero haunting power.");
            assertEquals(AlienException.INVALID_HAUNTING_POWER, exception.getMessage(), "The exception message for zero haunting power is incorrect.");
            assertEquals(AlienException.class, exception.getClass(), "The exception type for zero haunting power is incorrect.");

            exception = assertThrows(AlienException.class, () -> new SpecterAlien("SpecterInvalid", -20), "Constructor did not throw an exception for negative haunting power.");
            assertEquals(AlienException.INVALID_HAUNTING_POWER, exception.getMessage(), "The exception message for negative haunting power is incorrect.");
            assertEquals(AlienException.class, exception.getClass(), "The exception type for negative haunting power is incorrect.");

            SpecterAlien alien = new SpecterAlien("SpecterThree", 60);
            assertEquals(60, alien.getHauntingPower(), "The haunting power is incorrect.");

            alien.setHauntingPower(101);
            assertEquals(101, alien.getHauntingPower(), "The haunting power is incorrect after setting to 101.");

            exception = assertThrows(AlienException.class, () -> alien.setHauntingPower(0), "setHauntingPower did not throw an exception for zero haunting power.");
            assertEquals(AlienException.INVALID_HAUNTING_POWER, exception.getMessage(), "The exception message for zero haunting power is incorrect.");
            assertEquals(AlienException.class, exception.getClass(), "The exception type for zero haunting power is incorrect.");

            exception = assertThrows(AlienException.class, () -> alien.setHauntingPower(-10), "setHauntingPower did not throw an exception for negative haunting power.");
            assertEquals(AlienException.INVALID_HAUNTING_POWER, exception.getMessage(), "The exception message for negative haunting power is incorrect.");
            assertEquals(AlienException.class, exception.getClass(), "The exception type for negative haunting power is incorrect.");
        } catch (AlienException e) {
            fail("Constructor threw an exception for valid parameters: " + e.getMessage());
        }
    }

    @Test
    @Order(8)
    @Tag("advanced")
    @DisplayName("Advanced - toString")
    public void testToString() {
        try {
            SpecterAlien alien = new SpecterAlien("SpecterFour", 75);
            String expected = "{ \"type\": \"SpecterAlien\", \"etherealAlienDetails\": { \"alienDetails\": { \"name\": \"SpecterFour\" }, \"transparencyLevel\": 0.95 }, \"hauntingPower\": 75 }";
            assertEquals(expected, alien.toString(), "The toString() method does not return the expected string.");

            alien = new SpecterAlien("SpecterFive", 50);
            alien.setTransparencyLevel(0.3);
            expected = "{ \"type\": \"SpecterAlien\", \"etherealAlienDetails\": { \"alienDetails\": { \"name\": \"SpecterFive\" }, \"transparencyLevel\": 0.30 }, \"hauntingPower\": 50 }";
            assertEquals(expected, alien.toString(), "The toString() method does not return the expected string after changing transparency level.");
        } catch (AlienException e) {
            fail("Constructor threw an exception for valid parameters: " + e.getMessage());
        }
    }

}
