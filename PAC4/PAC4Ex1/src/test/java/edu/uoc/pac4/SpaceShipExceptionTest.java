package edu.uoc.pac4;

import org.junit.jupiter.api.*;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SpaceShipExceptionTest {

    @Test
    @Order(1)
    @Tag("sanity")
    @DisplayName("Sanity - Fields definition")
    public void checkExceptions() {
        int numFields = 2;

        // Check attribute fields
        assertEquals(numFields, SpaceShipException.class.getDeclaredFields().length, "The class must have exactly " + numFields + " attributes");

        try {
            assertTrue(Modifier.isPublic(SpaceShipException.class.getField("INVALID_SPACESHIP_ID").getModifiers()), "The field INVALID_SPACESHIP_ID must be public");
            assertTrue(Modifier.isStatic(SpaceShipException.class.getField("INVALID_SPACESHIP_ID").getModifiers()), "The field INVALID_SPACESHIP_ID must be static");
            assertTrue(Modifier.isFinal(SpaceShipException.class.getField("INVALID_SPACESHIP_ID").getModifiers()), "The field INVALID_SPACESHIP_ID must be final");
            assertEquals(String.class, SpaceShipException.class.getField("INVALID_SPACESHIP_ID").getType(), "The field INVALID_SPACESHIP_ID must be of type String");
            assertEquals("[ERROR] Spaceship ID cannot be null and have to start with 'SS-'.", SpaceShipException.INVALID_SPACESHIP_ID, "The value of INVALID_SPACESHIP_ID field is incorrect");

            assertTrue(Modifier.isPublic(SpaceShipException.class.getField("INVALID_SPACESHIP_ROL_TYPE").getModifiers()), "The field INVALID_SPACESHIP_ROL_TYPE must be public");
            assertTrue(Modifier.isStatic(SpaceShipException.class.getField("INVALID_SPACESHIP_ROL_TYPE").getModifiers()), "The field INVALID_SPACESHIP_ROL_TYPE must be static");
            assertTrue(Modifier.isFinal(SpaceShipException.class.getField("INVALID_SPACESHIP_ROL_TYPE").getModifiers()), "The field INVALID_SPACESHIP_ROL_TYPE must be final");
            assertEquals(String.class, SpaceShipException.class.getField("INVALID_SPACESHIP_ROL_TYPE").getType(), "The field INVALID_SPACESHIP_ROL_TYPE must be of type String");
            assertEquals("[ERROR] Spaceship type cannot be null.", SpaceShipException.INVALID_SPACESHIP_ROL_TYPE, "The value of INVALID_SPACESHIP_ROL_TYPE field is incorrect");
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
        assertEquals(numConstructors, SpaceShipException.class.getDeclaredConstructors().length, "The class must have exactly " + numConstructors + " constructors");

        try {
            assertTrue(Modifier.isPublic(SpaceShipException.class.getConstructor(String.class).getModifiers()), "The constructor SpaceShipException(String) must be public");
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
        assertEquals(numMethods, SpaceShipException.class.getDeclaredMethods().length, "The class must have exactly " + numMethods + " constructor");
    }

    @Test
    @Order(4)
    @Tag("sanity")
    @DisplayName("Sanity - Inheritance definition")
    void checkInheritance() {
        assertTrue(Exception.class.isAssignableFrom(SpaceShipException.class), "The class must inherit from Exception");
    }

}
