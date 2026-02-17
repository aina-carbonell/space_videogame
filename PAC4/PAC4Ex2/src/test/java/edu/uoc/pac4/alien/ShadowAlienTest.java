package edu.uoc.pac4.alien;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ShadowAlienTest {

    @Test
    @Order(1)
    @Tag("sanity")
    @DisplayName("Sanity - Fields definition")
    public void checkFields() {
        int numFields = 2;

        // Check attribute fields
        assertEquals(numFields, ShadowAlien.class.getDeclaredFields().length, "The class must have exactly " + numFields + " fields.");

        try {
            assertTrue(Modifier.isPrivate(ShadowAlien.class.getDeclaredField("TRANSPARENCY_LEVEL").getModifiers()), "The attribute TRANSPARENCY_LEVEL must be private.");
            assertTrue(Modifier.isStatic(ShadowAlien.class.getDeclaredField("TRANSPARENCY_LEVEL").getModifiers()), "The attribute TRANSPARENCY_LEVEL must be static.");
            assertTrue(Modifier.isFinal(ShadowAlien.class.getDeclaredField("TRANSPARENCY_LEVEL").getModifiers()), "The attribute TRANSPARENCY_LEVEL must be final.");
            assertEquals(double.class, ShadowAlien.class.getDeclaredField("TRANSPARENCY_LEVEL").getType(), "The attribute TRANSPARENCY_LEVEL must be of type double.");

            assertTrue(Modifier.isPrivate(ShadowAlien.class.getDeclaredField("stealthLevel").getModifiers()), "The attribute stealthLevel must be private.");
            assertFalse(Modifier.isStatic(ShadowAlien.class.getDeclaredField("stealthLevel").getModifiers()), "The attribute stealthLevel must not be static.");
            assertFalse(Modifier.isFinal(ShadowAlien.class.getDeclaredField("stealthLevel").getModifiers()), "The attribute stealthLevel must not be final.");
            assertEquals(int.class, ShadowAlien.class.getDeclaredField("stealthLevel").getType(), "The attribute stealthLevel must be of type int.");
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

        Constructor<?>[] declaredConstructors = ShadowAlien.class.getDeclaredConstructors();
        assertEquals(numConstructors, declaredConstructors.length,
                "The class must declare exactly " + numConstructors + " constructor");

        try {
            Constructor<?> constructor = ShadowAlien.class.getDeclaredConstructor(String.class, int.class);

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
        assertEquals(EtherealAlien.class, ShadowAlien.class.getSuperclass(), "The class ShadowAlien must directly extend the EtherealAlien class");
    }

    @Test
    @Order(4)
    @Tag("sanity")
    @DisplayName("Sanity - Methods definition")
    public void checkMethods() {
        int numMethods = 4;

        // Check number of methods
        assertEquals(numMethods, ShadowAlien.class.getDeclaredMethods().length, "The class must have exactly " + numMethods + " methods");

        try {
            assertTrue(Modifier.isPublic(ShadowAlien.class.getDeclaredMethod("getStealthLevel").getModifiers()), "The method getStealthLevel() must be public");
            assertFalse(Modifier.isStatic(ShadowAlien.class.getDeclaredMethod("getStealthLevel").getModifiers()), "The method getStealthLevel() must not be static");
            assertFalse(Modifier.isFinal(ShadowAlien.class.getDeclaredMethod("getStealthLevel").getModifiers()), "The method getStealthLevel() must not be final");
            assertEquals(int.class, ShadowAlien.class.getDeclaredMethod("getStealthLevel").getReturnType(), "The method getStealthLevel() must return an int");

            assertTrue(Modifier.isPublic(ShadowAlien.class.getDeclaredMethod("setStealthLevel", int.class).getModifiers()), "The method setStealthLevel(int) must be public");
            assertFalse(Modifier.isStatic(ShadowAlien.class.getDeclaredMethod("setStealthLevel", int.class).getModifiers()), "The method setStealthLevel(int) must not be static");
            assertFalse(Modifier.isFinal(ShadowAlien.class.getDeclaredMethod("setStealthLevel", int.class).getModifiers()), "The method setStealthLevel(int) must not be final");
            assertEquals(void.class, ShadowAlien.class.getDeclaredMethod("setStealthLevel", int.class).getReturnType(), "The method setStealthLevel(int) must return void");

            assertTrue(Modifier.isPublic(ShadowAlien.class.getDeclaredMethod("changeName").getModifiers()), "The method changeName() must be public");
            assertFalse(Modifier.isStatic(ShadowAlien.class.getDeclaredMethod("changeName").getModifiers()), "The method changeName() must not be static");
            assertFalse(Modifier.isFinal(ShadowAlien.class.getDeclaredMethod("changeName").getModifiers()), "The method changeName() must not be final");
            assertEquals(void.class, ShadowAlien.class.getDeclaredMethod("changeName").getReturnType(), "The method changeName() must return void");

            assertTrue(Modifier.isPublic(ShadowAlien.class.getDeclaredMethod("toString").getModifiers()), "The method toString() must be public");
            assertFalse(Modifier.isStatic(ShadowAlien.class.getDeclaredMethod("toString").getModifiers()), "The method toString() must not be static");
            assertFalse(Modifier.isFinal(ShadowAlien.class.getDeclaredMethod("toString").getModifiers()), "The method toString() must not be final");
            assertEquals(String.class, ShadowAlien.class.getDeclaredMethod("toString").getReturnType(), "The method toString() must return a String");
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
            ShadowAlien alien = new ShadowAlien("Shadow", 50);
            assertEquals("Shadow", alien.getName(), "The name of the alien is incorrect.");
            assertEquals(50, alien.getStealthLevel(), "The stealth level is incorrect.");
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
            Exception exception = assertThrows(AlienException.class, () -> new ShadowAlien(null, 50), "Constructor did not throw an exception for null name.");
            assertEquals(AlienException.INVALID_ALIEN_NAME, exception.getMessage(), "The exception message for null name is incorrect.");
            assertEquals(AlienException.class, exception.getClass(), "The exception type for null name is incorrect.");

            exception = assertThrows(AlienException.class, () -> new ShadowAlien("", 50), "Constructor did not throw an exception for empty name.");
            assertEquals(AlienException.INVALID_ALIEN_NAME, exception.getMessage(), "The exception message for empty name is incorrect.");
            assertEquals(AlienException.class, exception.getClass(), "The exception type for empty name is incorrect.");

            exception = assertThrows(AlienException.class, () -> new ShadowAlien("   ", 50), "Constructor did not throw an exception for blank name.");
            assertEquals(AlienException.INVALID_ALIEN_NAME, exception.getMessage(), "The exception message for blank name is incorrect.");
            assertEquals(AlienException.class, exception.getClass(), "The exception type for blank name is incorrect.");

            Alien alien = new ShadowAlien("Shadow", 50);
            assertEquals("Shadow", alien.getName(), "The name of the alien is incorrect.");

            exception = assertThrows(AlienException.class, () -> alien.setName(null), "setName did not throw an exception for null name.");
            assertEquals(AlienException.INVALID_ALIEN_NAME, exception.getMessage(), "The exception message for null name is incorrect.");
            assertEquals(AlienException.class, exception.getClass(), "The exception type for null name is incorrect.");

            exception = assertThrows(AlienException.class, () -> alien.setName(""), "setName did not throw an exception for empty name.");
            assertEquals(AlienException.INVALID_ALIEN_NAME, exception.getMessage(), "The exception message for empty name is incorrect.");
            assertEquals(AlienException.class, exception.getClass(), "The exception type for empty name is incorrect.");

            exception = assertThrows(AlienException.class, () -> alien.setName("   "), "setName did not throw an exception for blank name.");
            assertEquals(AlienException.INVALID_ALIEN_NAME, exception.getMessage(), "The exception message for blank name is incorrect.");
            assertEquals(AlienException.class, exception.getClass(), "The exception type for blank name is incorrect.");

            alien.setName("Darkness");
            assertEquals("Darkness", alien.getName(), "The name of the alien is incorrect after using setName.");
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
            ShadowAlien alien = new ShadowAlien("Shadow", 70);
            assertEquals(0.85, alien.getTransparencyLevel(), 0.001, "The transparency level is incorrect.");

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
    @DisplayName("Minimum - Morphing Ability")
    public void testMorphingAbility() {
        try {
            Exception exception = assertThrows(AlienException.class, () -> new ShadowAlien("Recursion", -1), "Constructor did not throw an exception for stealth ability below 0.");
            assertEquals(AlienException.INVALID_STEALTH_LEVEL, exception.getMessage(), "The exception message for stealth ability below 0 is incorrect.");
            assertEquals(AlienException.class, exception.getClass(), "The exception type for stealth ability below 0 is incorrect.");

            exception = assertThrows(AlienException.class, () -> new ShadowAlien("Recursion", 101), "Constructor did not throw an exception for stealth ability above 100.");
            assertEquals(AlienException.INVALID_STEALTH_LEVEL, exception.getMessage(), "The exception message for stealth ability above 100 is incorrect.");
            assertEquals(AlienException.class, exception.getClass(), "The exception type for stealth ability above 100 is incorrect.");

            ShadowAlien alien = new ShadowAlien("Recursion", 50);
            assertEquals(50, alien.getStealthLevel(), "The stealth level is incorrect.");

            alien.setStealthLevel(80);
            assertEquals(80, alien.getStealthLevel(), "The stealth level is incorrect after setting to 80.");

            exception = assertThrows(AlienException.class, () -> alien.setStealthLevel(-5), "setStealthLevel did not throw an exception for stealth ability below 0.");
            assertEquals(AlienException.INVALID_STEALTH_LEVEL, exception.getMessage(), "The exception message for stealth ability below 0 is incorrect.");
            assertEquals(AlienException.class, exception.getClass(), "The exception type for stealth ability below 0 is incorrect.");

            exception = assertThrows(AlienException.class, () -> alien.setStealthLevel(150), "setStealthLevel did not throw an exception for stealth ability above 100.");
            assertEquals(AlienException.INVALID_STEALTH_LEVEL, exception.getMessage(), "The exception message for stealth ability above 100 is incorrect.");
            assertEquals(AlienException.class, exception.getClass(), "The exception type for stealth ability above 100 is incorrect.");
        } catch (AlienException e) {
            fail("Constructor threw an exception for valid parameters: " + e.getMessage());
        }
    }

    @Test
    @Order(8)
    @Tag("advanced")
    @DisplayName("Advanced - changeName")
    public void testChangeName() {
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            PrintStream originalOut = System.out;
            System.setOut(new PrintStream(outputStream));

            ShadowAlien alien = new ShadowAlien("Darkness", 70);

            alien.changeName();

            System.setOut(originalOut);

            String printed = outputStream.toString().replace("\n", "").replace("\r", "");
            assertEquals("Shape shifting...", printed, "The changeName() method did not print the expected message.");
            assertEquals("Darkness (Shadow)", alien.getName(), "The name was not changed correctly by changeName().");
        } catch (AlienException e) {
            fail("Constructor threw an exception for valid parameters: " + e.getMessage());
        }
    }

    @Test
    @Order(9)
    @Tag("advanced")
    @DisplayName("Advanced - toString")
    public void testToString() {
        try {
            ShadowAlien alien = new ShadowAlien("Shadow", 70);
            String expected = "{ \"type\": \"ShadowAlien\", \"etherealAlienDetails\": { \"alienDetails\": { \"name\": \"Shadow\" }, \"transparencyLevel\": 0.85 }, \"stealthLevel\": 70 }";
            assertEquals(expected, alien.toString(), "The toString() method returned an incorrect string representation.");

            alien = new ShadowAlien("Darkness", 10);
            alien.setTransparencyLevel(0.5);
            expected = "{ \"type\": \"ShadowAlien\", \"etherealAlienDetails\": { \"alienDetails\": { \"name\": \"Darkness\" }, \"transparencyLevel\": 0.50 }, \"stealthLevel\": 10 }";
            assertEquals(expected, alien.toString(), "The toString() method returned an incorrect string representation after modifications.");
        } catch (AlienException e) {
            fail("Constructor threw an exception for valid parameters: " + e.getMessage());
        }
    }

}
