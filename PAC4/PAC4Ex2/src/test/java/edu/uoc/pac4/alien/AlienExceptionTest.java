package edu.uoc.pac4.alien;

import org.junit.jupiter.api.*;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AlienExceptionTest {

    @Test
    @Order(1)
    @Tag("sanity")
    @DisplayName("Sanity - Fields definition")
    public void checkExceptions() {
        int numFields = 4;

        // Check attribute fields
        assertEquals(numFields, AlienException.class.getDeclaredFields().length, "The class must have exactly " + numFields + " attributes");

        try {
            assertTrue(Modifier.isPublic(AlienException.class.getField("INVALID_ALIEN_NAME").getModifiers()), "The field INVALID_ALIEN_NAME must be public");
            assertTrue(Modifier.isStatic(AlienException.class.getField("INVALID_ALIEN_NAME").getModifiers()), "The field INVALID_ALIEN_NAME must be static");
            assertTrue(Modifier.isFinal(AlienException.class.getField("INVALID_ALIEN_NAME").getModifiers()), "The field INVALID_ALIEN_NAME must be final");
            assertEquals(String.class, AlienException.class.getField("INVALID_ALIEN_NAME").getType(), "The field INVALID_ALIEN_NAME must be of type String");
            assertEquals("[ERROR] Alien name cannot be null or empty.", AlienException.INVALID_ALIEN_NAME, "The value of INVALID_ALIEN_NAME field is incorrect");

            assertTrue(Modifier.isPublic(AlienException.class.getField("INVALID_HAUNTING_POWER").getModifiers()), "The field INVALID_HAUNTING_POWER must be public");
            assertTrue(Modifier.isStatic(AlienException.class.getField("INVALID_HAUNTING_POWER").getModifiers()), "The field INVALID_HAUNTING_POWER must be static");
            assertTrue(Modifier.isFinal(AlienException.class.getField("INVALID_HAUNTING_POWER").getModifiers()), "The field INVALID_HAUNTING_POWER must be final");
            assertEquals(String.class, AlienException.class.getField("INVALID_HAUNTING_POWER").getType(), "The field INVALID_HAUNTING_POWER must be of type String");
            assertEquals("[ERROR] Haunting power must be greater than 0.", AlienException.INVALID_HAUNTING_POWER, "The value of INVALID_HAUNTING_POWER field is incorrect");

            assertTrue(Modifier.isPublic(AlienException.class.getField("INVALID_STEALTH_LEVEL").getModifiers()), "The field INVALID_STEALTH_LEVEL must be public");
            assertTrue(Modifier.isStatic(AlienException.class.getField("INVALID_STEALTH_LEVEL").getModifiers()), "The field INVALID_STEALTH_LEVEL must be static");
            assertTrue(Modifier.isFinal(AlienException.class.getField("INVALID_STEALTH_LEVEL").getModifiers()), "The field INVALID_STEALTH_LEVEL must be final");
            assertEquals(String.class, AlienException.class.getField("INVALID_STEALTH_LEVEL").getType(), "The field INVALID_STEALTH_LEVEL must be of type String");
            assertEquals("[ERROR] Stealth level must be between 0 and 100.", AlienException.INVALID_STEALTH_LEVEL, "The value of INVALID_STEALTH_LEVEL field is incorrect");

            assertTrue(Modifier.isPublic(AlienException.class.getField("INVALID_MORPHING_ABILITY").getModifiers()), "The field INVALID_MORPHING_ABILITY must be public");
            assertTrue(Modifier.isStatic(AlienException.class.getField("INVALID_MORPHING_ABILITY").getModifiers()), "The field INVALID_MORPHING_ABILITY must be static");
            assertTrue(Modifier.isFinal(AlienException.class.getField("INVALID_MORPHING_ABILITY").getModifiers()), "The field INVALID_MORPHING_ABILITY must be final");
            assertEquals(String.class, AlienException.class.getField("INVALID_MORPHING_ABILITY").getType(), "The field INVALID_MORPHING_ABILITY must be of type String");
            assertEquals("[ERROR] Morphing ability must be between 0.0 and 1.0.", AlienException.INVALID_MORPHING_ABILITY, "The value of INVALID_MORPHING_ABILITY field is incorrect");
        } catch (NoSuchFieldException e) {
            fail("[ERROR] There is some problem with the definition of the field: " + e.getMessage());
        }
    }

    @Test
    @Order(2)
    @Tag("sanity")
    @DisplayName("Sanity - Constructor definition")
    public void checkConstructor() {
        int numConstructors = 1;

        // Check constructors
        assertEquals(numConstructors, AlienException.class.getDeclaredConstructors().length, "The class must have exactly " + numConstructors + " constructors");

        try {
            assertTrue(Modifier.isPublic(AlienException.class.getConstructor(String.class).getModifiers()), "The constructor AlienException(String) must be public");
        } catch (NoSuchMethodException e) {
            fail("[ERROR] There is some problem with the definition of constructors: " + e.getMessage());
        }
    }

    @Test
    @Order(3)
    @Tag("sanity")
    @DisplayName("Sanity - Methods definition")
    void checkMethods() {
        int numMethods = 0;

        // Check number of methods
        assertEquals(numMethods, AlienException.class.getDeclaredMethods().length, "The class must have exactly " + numMethods + " constructor");
    }

    @Test
    @Order(4)
    @Tag("sanity")
    @DisplayName("Sanity - Inheritance definition")
    void checkInheritance() {
        assertTrue(Exception.class.isAssignableFrom(AlienException.class), "The class must inherit from Exception");
    }

}
