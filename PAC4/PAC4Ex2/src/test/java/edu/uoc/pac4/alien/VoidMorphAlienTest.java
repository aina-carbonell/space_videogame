package edu.uoc.pac4.alien;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class VoidMorphAlienTest {

    @Test
    @Order(1)
    @Tag("sanity")
    @DisplayName("Sanity - Fields definition")
    public void checkFields() {
        int numFields = 2;

        // Check attribute fields
        assertEquals(numFields, VoidMorphAlien.class.getDeclaredFields().length, "The class must have exactly " + numFields + " fields.");

        try {
            assertTrue(Modifier.isPrivate(VoidMorphAlien.class.getDeclaredField("TRANSPARENCY_LEVEL").getModifiers()), "The attribute TRANSPARENCY_LEVEL must be private.");
            assertTrue(Modifier.isStatic(VoidMorphAlien.class.getDeclaredField("TRANSPARENCY_LEVEL").getModifiers()), "The attribute TRANSPARENCY_LEVEL must be static.");
            assertTrue(Modifier.isFinal(VoidMorphAlien.class.getDeclaredField("TRANSPARENCY_LEVEL").getModifiers()), "The attribute TRANSPARENCY_LEVEL must be final.");
            assertEquals(double.class, VoidMorphAlien.class.getDeclaredField("TRANSPARENCY_LEVEL").getType(), "The attribute TRANSPARENCY_LEVEL must be of type double.");

            assertTrue(Modifier.isPrivate(VoidMorphAlien.class.getDeclaredField("morphingAbility").getModifiers()), "The attribute morphingAbility must be private.");
            assertFalse(Modifier.isStatic(VoidMorphAlien.class.getDeclaredField("morphingAbility").getModifiers()), "The attribute morphingAbility must not be static.");
            assertFalse(Modifier.isFinal(VoidMorphAlien.class.getDeclaredField("morphingAbility").getModifiers()), "The attribute morphingAbility must not be final.");
            assertEquals(double.class, VoidMorphAlien.class.getDeclaredField("morphingAbility").getType(), "The attribute morphingAbility must be of type double.");
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

        Constructor<?>[] declaredConstructors = VoidMorphAlien.class.getDeclaredConstructors();
        assertEquals(numConstructors, declaredConstructors.length,
                "The class must declare exactly " + numConstructors + " constructor");

        try {
            Constructor<?> constructor = VoidMorphAlien.class.getDeclaredConstructor(String.class, double.class);

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
        assertEquals(EtherealAlien.class, VoidMorphAlien.class.getSuperclass(), "The class VoidMorphAlien must directly extend the EtherealAlien class");
    }

    @Test
    @Order(4)
    @Tag("sanity")
    @DisplayName("Sanity - Methods definition")
    public void checkMethods() {
        int numMethods = 4;

        // Check number of methods
        assertEquals(numMethods, VoidMorphAlien.class.getDeclaredMethods().length, "The class must have exactly " + numMethods + " methods");

        try {
            assertTrue(Modifier.isPublic(VoidMorphAlien.class.getDeclaredMethod("getMorphingAbility").getModifiers()), "The method getMorphingAbility() must be public");
            assertFalse(Modifier.isStatic(VoidMorphAlien.class.getDeclaredMethod("getMorphingAbility").getModifiers()), "The method getMorphingAbility() must not be static");
            assertFalse(Modifier.isFinal(VoidMorphAlien.class.getDeclaredMethod("getMorphingAbility").getModifiers()), "The method getMorphingAbility() must not be final");
            assertEquals(double.class, VoidMorphAlien.class.getDeclaredMethod("getMorphingAbility").getReturnType(), "The method getMorphingAbility() must return an double");

            assertTrue(Modifier.isPublic(VoidMorphAlien.class.getDeclaredMethod("setMorphingAbility", double.class).getModifiers()), "The method setMorphingAbility(double) must be public");
            assertFalse(Modifier.isStatic(VoidMorphAlien.class.getDeclaredMethod("setMorphingAbility", double.class).getModifiers()), "The method setMorphingAbility(double) must not be static");
            assertFalse(Modifier.isFinal(VoidMorphAlien.class.getDeclaredMethod("setMorphingAbility", double.class).getModifiers()), "The method setMorphingAbility(double) must not be final");
            assertEquals(void.class, VoidMorphAlien.class.getDeclaredMethod("setMorphingAbility", double.class).getReturnType(), "The method setMorphingAbility(double) must return void");

            assertTrue(Modifier.isPublic(VoidMorphAlien.class.getDeclaredMethod("changeName").getModifiers()), "The method changeName() must be public");
            assertFalse(Modifier.isStatic(VoidMorphAlien.class.getDeclaredMethod("changeName").getModifiers()), "The method changeName() must not be static");
            assertFalse(Modifier.isFinal(VoidMorphAlien.class.getDeclaredMethod("changeName").getModifiers()), "The method changeName() must not be final");
            assertEquals(void.class, VoidMorphAlien.class.getDeclaredMethod("changeName").getReturnType(), "The method changeName() must return void");

            assertTrue(Modifier.isPublic(VoidMorphAlien.class.getDeclaredMethod("toString").getModifiers()), "The method toString() must be public");
            assertFalse(Modifier.isStatic(VoidMorphAlien.class.getDeclaredMethod("toString").getModifiers()), "The method toString() must not be static");
            assertFalse(Modifier.isFinal(VoidMorphAlien.class.getDeclaredMethod("toString").getModifiers()), "The method toString() must not be final");
            assertEquals(String.class, VoidMorphAlien.class.getDeclaredMethod("toString").getReturnType(), "The method toString() must return a String");
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
            VoidMorphAlien alien = new VoidMorphAlien("Recursion", 0.7);
            assertEquals("Recursion", alien.getName(), "The name of the alien is incorrect.");
            assertEquals(0.7, alien.getMorphingAbility(), "The morphing ability is incorrect.");
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
            Exception exception = assertThrows(AlienException.class, () -> new VoidMorphAlien(null, 0.7), "Constructor did not throw an exception for null name.");
            assertEquals(AlienException.INVALID_ALIEN_NAME, exception.getMessage(), "The exception message for null name is incorrect.");
            assertEquals(AlienException.class, exception.getClass(), "The exception type for null name is incorrect.");

            exception = assertThrows(AlienException.class, () -> new VoidMorphAlien("", 0.7), "Constructor did not throw an exception for empty name.");
            assertEquals(AlienException.INVALID_ALIEN_NAME, exception.getMessage(), "The exception message for empty name is incorrect.");
            assertEquals(AlienException.class, exception.getClass(), "The exception type for empty name is incorrect.");

            exception = assertThrows(AlienException.class, () -> new VoidMorphAlien("   ", 0.7), "Constructor did not throw an exception for blank name.");
            assertEquals(AlienException.INVALID_ALIEN_NAME, exception.getMessage(), "The exception message for blank name is incorrect.");
            assertEquals(AlienException.class, exception.getClass(), "The exception type for blank name is incorrect.");

            Alien alien = new VoidMorphAlien("Infinity", 0.7);
            assertEquals("Infinity", alien.getName(), "The name of the alien is incorrect.");

            exception = assertThrows(AlienException.class, () -> alien.setName(null), "setName did not throw an exception for null name.");
            assertEquals(AlienException.INVALID_ALIEN_NAME, exception.getMessage(), "The exception message for null name is incorrect.");
            assertEquals(AlienException.class, exception.getClass(), "The exception type for null name is incorrect.");

            exception = assertThrows(AlienException.class, () -> alien.setName(""), "setName did not throw an exception for empty name.");
            assertEquals(AlienException.INVALID_ALIEN_NAME, exception.getMessage(), "The exception message for empty name is incorrect.");
            assertEquals(AlienException.class, exception.getClass(), "The exception type for empty name is incorrect.");

            exception = assertThrows(AlienException.class, () -> alien.setName("   "), "setName did not throw an exception for blank name.");
            assertEquals(AlienException.INVALID_ALIEN_NAME, exception.getMessage(), "The exception message for blank name is incorrect.");
            assertEquals(AlienException.class, exception.getClass(), "The exception type for blank name is incorrect.");

            alien.setName("VoidName");
            assertEquals("VoidName", alien.getName(), "The name of the alien is incorrect after using setName.");
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
            VoidMorphAlien alien = new VoidMorphAlien("Recursion", 0.7);
            assertEquals(0.9, alien.getTransparencyLevel(), 0.001, "The transparency level is incorrect.");

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
            Exception exception = assertThrows(AlienException.class, () -> new VoidMorphAlien("Recursion", -0.1), "Constructor did not throw an exception for morphing ability less than 0.0.");
            assertEquals(AlienException.INVALID_MORPHING_ABILITY, exception.getMessage(), "The exception message for morphing ability less than 0.0 is incorrect.");
            assertEquals(AlienException.class, exception.getClass(), "The exception type for morphing ability less than 0.0 is incorrect.");

            exception = assertThrows(AlienException.class, () -> new VoidMorphAlien("Recursion", 1.1), "Constructor did not throw an exception for morphing ability greater than 1.0.");
            assertEquals(AlienException.INVALID_MORPHING_ABILITY, exception.getMessage(), "The exception message for morphing ability greater than 1.0 is incorrect.");
            assertEquals(AlienException.class, exception.getClass(), "The exception type for morphing ability greater than 1.0 is incorrect.");

            VoidMorphAlien alien = new VoidMorphAlien("Recursion", 0.7);
            assertEquals(0.7, alien.getMorphingAbility(), 0.001, "The morphing ability is incorrect.");

            alien.setMorphingAbility(0.4);
            assertEquals(0.4, alien.getMorphingAbility(), 0.001, "The morphing ability is incorrect after setting to 0.4.");

            exception = assertThrows(AlienException.class, () -> alien.setMorphingAbility(-0.2), "setMorphingAbility did not throw an exception for morphing ability less than 0.0.");
            assertEquals(AlienException.INVALID_MORPHING_ABILITY, exception.getMessage(), "The exception message for morphing ability less than 0.0 is incorrect.");
            assertEquals(AlienException.class, exception.getClass(), "The exception type for morphing ability less than 0.0 is incorrect.");

            exception = assertThrows(AlienException.class, () -> alien.setMorphingAbility(1.5), "setMorphingAbility did not throw an exception for morphing ability greater than 1.0.");
            assertEquals(AlienException.INVALID_MORPHING_ABILITY, exception.getMessage(), "The exception message for morphing ability greater than 1.0 is incorrect.");
            assertEquals(AlienException.class, exception.getClass(), "The exception type for morphing ability greater than 1.0 is incorrect.");
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

            VoidMorphAlien alien = new VoidMorphAlien("Recursion", 0.7);
            alien.changeName();

            System.setOut(originalOut);

            String printed = outputStream.toString().replace("\n", "").replace("\r", "");
            assertEquals("Shape shifting...", printed, "The changeName() method did not print the expected message.");
            assertEquals("Recursion (VoidMorph)", alien.getName(), "The name was not changed correctly by changeName().");
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
            VoidMorphAlien alien = new VoidMorphAlien("Recursion", 0.7);
            String expected = "{ \"type\": \"VoidMorphAlien\", \"etherealAlienDetails\": { \"alienDetails\": { \"name\": \"Recursion\" }, \"transparencyLevel\": 0.90 }, \"morphingAbility\": 0.70 }";
            assertEquals(expected, alien.toString(), "The toString() method returned an incorrect string representation.");

            alien = new VoidMorphAlien("Phantom", 0.3);
            alien.setTransparencyLevel(0.5);
            expected = "{ \"type\": \"VoidMorphAlien\", \"etherealAlienDetails\": { \"alienDetails\": { \"name\": \"Phantom\" }, \"transparencyLevel\": 0.50 }, \"morphingAbility\": 0.30 }";
            assertEquals(expected, alien.toString(), "The toString() method returned an incorrect string representation after modifications.");
        } catch (AlienException e) {
            fail("Constructor threw an exception for valid parameters: " + e.getMessage());
        }
    }

}
