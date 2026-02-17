package edu.uoc.pac4;

import org.junit.jupiter.api.*;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SpaceGameExceptionTest {

    @Test
    @Order(1)
    @Tag("sanity")
    @DisplayName("Sanity - Fields definition")
    public void checkExceptions() {
        int numFields = 5;

        // Check attribute fields
        assertEquals(numFields, SpaceGameException.class.getDeclaredFields().length, "The class must have exactly " + numFields + " attributes");

        try {
            assertTrue(Modifier.isPublic(SpaceGameException.class.getField("INVALID_GALAXY_NAME").getModifiers()), "The field INVALID_GALAXY_NAME must be public");
            assertTrue(Modifier.isStatic(SpaceGameException.class.getField("INVALID_GALAXY_NAME").getModifiers()), "The field INVALID_GALAXY_NAME must be static");
            assertTrue(Modifier.isFinal(SpaceGameException.class.getField("INVALID_GALAXY_NAME").getModifiers()), "The field INVALID_GALAXY_NAME must be final");
            assertEquals(String.class, SpaceGameException.class.getField("INVALID_GALAXY_NAME").getType(), "The field INVALID_GALAXY_NAME must be of type String");
            assertEquals("[ERROR] Galaxy name cannot be null or empty.", SpaceGameException.INVALID_GALAXY_NAME, "The value of INVALID_GALAXY_NAME field is incorrect");

            assertTrue(Modifier.isPublic(SpaceGameException.class.getField("NULL_SPACESHIP").getModifiers()), "The field NULL_SPACESHIP must be public");
            assertTrue(Modifier.isStatic(SpaceGameException.class.getField("NULL_SPACESHIP").getModifiers()), "The field NULL_SPACESHIP must be static");
            assertTrue(Modifier.isFinal(SpaceGameException.class.getField("NULL_SPACESHIP").getModifiers()), "The field NULL_SPACESHIP must be final");
            assertEquals(String.class, SpaceGameException.class.getField("NULL_SPACESHIP").getType(), "The field NULL_SPACESHIP must be of type String");
            assertEquals("[ERROR] Spaceship cannot be null.", SpaceGameException.NULL_SPACESHIP, "The value of NULL_SPACESHIP field is incorrect");

            assertTrue(Modifier.isPublic(SpaceGameException.class.getField("MAX_SPACESHIPS_REACHED").getModifiers()), "The field MAX_SPACESHIPS_REACHED must be public");
            assertTrue(Modifier.isStatic(SpaceGameException.class.getField("MAX_SPACESHIPS_REACHED").getModifiers()), "The field MAX_SPACESHIPS_REACHED must be static");
            assertTrue(Modifier.isFinal(SpaceGameException.class.getField("MAX_SPACESHIPS_REACHED").getModifiers()), "The field MAX_SPACESHIPS_REACHED must be final");
            assertEquals(String.class, SpaceGameException.class.getField("MAX_SPACESHIPS_REACHED").getType(), "The field MAX_SPACESHIPS_REACHED must be of type String");
            assertEquals("[ERROR] Maximum number of spaceships reached.", SpaceGameException.MAX_SPACESHIPS_REACHED, "The value of MAX_SPACESHIPS_REACHED field is incorrect");

            assertTrue(Modifier.isPublic(SpaceGameException.class.getField("SPACESHIP_ALREADY_EXISTS").getModifiers()), "The field SPACESHIP_ALREADY_EXISTS must be public");
            assertTrue(Modifier.isStatic(SpaceGameException.class.getField("SPACESHIP_ALREADY_EXISTS").getModifiers()), "The field SPACESHIP_ALREADY_EXISTS must be static");
            assertTrue(Modifier.isFinal(SpaceGameException.class.getField("SPACESHIP_ALREADY_EXISTS").getModifiers()), "The field SPACESHIP_ALREADY_EXISTS must be final");
            assertEquals(String.class, SpaceGameException.class.getField("SPACESHIP_ALREADY_EXISTS").getType(), "The field SPACESHIP_ALREADY_EXISTS must be of type String");
            assertEquals("[ERROR] Spaceship already exists in the game.", SpaceGameException.SPACESHIP_ALREADY_EXISTS, "The value of SPACESHIP_ALREADY_EXISTS field is incorrect");

            assertTrue(Modifier.isPublic(SpaceGameException.class.getField("SPACESHIP_NOT_FOUND").getModifiers()), "The field SPACESHIP_NOT_FOUND must be public");
            assertTrue(Modifier.isStatic(SpaceGameException.class.getField("SPACESHIP_NOT_FOUND").getModifiers()), "The field SPACESHIP_NOT_FOUND must be static");
            assertTrue(Modifier.isFinal(SpaceGameException.class.getField("SPACESHIP_NOT_FOUND").getModifiers()), "The field SPACESHIP_NOT_FOUND must be final");
            assertEquals(String.class, SpaceGameException.class.getField("SPACESHIP_NOT_FOUND").getType(), "The field SPACESHIP_NOT_FOUND must be of type String");
            assertEquals("[ERROR] Spaceship not found in the game.", SpaceGameException.SPACESHIP_NOT_FOUND, "The value of SPACESHIP_NOT_FOUND field is incorrect");
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
        assertEquals(numConstructors, SpaceGameException.class.getDeclaredConstructors().length, "The class must have exactly " + numConstructors + " constructors");

        try {
            assertTrue(Modifier.isPublic(SpaceGameException.class.getConstructor(String.class).getModifiers()), "The constructor SpaceGameException(String) must be public");
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
        assertEquals(numMethods, SpaceGameException.class.getDeclaredMethods().length, "The class must have exactly " + numMethods + " constructor");
    }

    @Test
    @Order(4)
    @Tag("sanity")
    @DisplayName("Sanity - Inheritance definition")
    void checkInheritance() {
        assertTrue(Exception.class.isAssignableFrom(SpaceGameException.class), "The class must inherit from Exception");
    }

}
