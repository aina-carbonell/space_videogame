package edu.uoc.pac4.ship;

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
        int numFields = 7;

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

            assertTrue(Modifier.isPublic(SpaceShipException.class.getField("INVALID_LASER_POWER").getModifiers()), "The field INVALID_LASER_POWER must be public");
            assertTrue(Modifier.isStatic(SpaceShipException.class.getField("INVALID_LASER_POWER").getModifiers()), "The field INVALID_LASER_POWER must be static");
            assertTrue(Modifier.isFinal(SpaceShipException.class.getField("INVALID_LASER_POWER").getModifiers()), "The field INVALID_LASER_POWER must be final");
            assertEquals(String.class, SpaceShipException.class.getField("INVALID_LASER_POWER").getType(), "The field INVALID_LASER_POWER must be of type String");
            assertEquals("[ERROR] Laser power must be greater than 0.", SpaceShipException.INVALID_LASER_POWER, "The value of INVALID_LASER_POWER field is incorrect");

            assertTrue(Modifier.isPublic(SpaceShipException.class.getField("INVALID_NUMBER_OF_CANNONS").getModifiers()), "The field INVALID_NUMBER_OF_CANNONS must be public");
            assertTrue(Modifier.isStatic(SpaceShipException.class.getField("INVALID_NUMBER_OF_CANNONS").getModifiers()), "The field INVALID_NUMBER_OF_CANNONS must be static");
            assertTrue(Modifier.isFinal(SpaceShipException.class.getField("INVALID_NUMBER_OF_CANNONS").getModifiers()), "The field INVALID_NUMBER_OF_CANNONS must be final");
            assertEquals(String.class, SpaceShipException.class.getField("INVALID_NUMBER_OF_CANNONS").getType(), "The field INVALID_NUMBER_OF_CANNONS must be of type String");
            assertEquals("[ERROR] Number of cannons cannot be negative.", SpaceShipException.INVALID_NUMBER_OF_CANNONS, "The value of INVALID_NUMBER_OF_CANNONS field is incorrect");

            assertTrue(Modifier.isPublic(SpaceShipException.class.getField("NULL_ALIEN").getModifiers()), "The field NULL_ALIEN must be public");
            assertTrue(Modifier.isStatic(SpaceShipException.class.getField("NULL_ALIEN").getModifiers()), "The field NULL_ALIEN must be static");
            assertTrue(Modifier.isFinal(SpaceShipException.class.getField("NULL_ALIEN").getModifiers()), "The field NULL_ALIEN must be final");
            assertEquals(String.class, SpaceShipException.class.getField("NULL_ALIEN").getType(), "The field NULL_ALIEN must be of type String");
            assertEquals("[ERROR] Alien cannot be null.", SpaceShipException.NULL_ALIEN, "The value of NULL_ALIEN field is incorrect");

            assertTrue(Modifier.isPublic(SpaceShipException.class.getField("ALIEN_ALREADY_EXISTS").getModifiers()), "The field ALIEN_ALREADY_EXISTS must be public");
            assertTrue(Modifier.isStatic(SpaceShipException.class.getField("ALIEN_ALREADY_EXISTS").getModifiers()), "The field ALIEN_ALREADY_EXISTS must be static");
            assertTrue(Modifier.isFinal(SpaceShipException.class.getField("ALIEN_ALREADY_EXISTS").getModifiers()), "The field ALIEN_ALREADY_EXISTS must be final");
            assertEquals(String.class, SpaceShipException.class.getField("ALIEN_ALREADY_EXISTS").getType(), "The field ALIEN_ALREADY_EXISTS must be of type String");
            assertEquals("[ERROR] Alien already exists in the spaceship.", SpaceShipException.ALIEN_ALREADY_EXISTS, "The value of ALIEN_ALREADY_EXISTS field is incorrect");

            assertTrue(Modifier.isPublic(SpaceShipException.class.getField("PEOPLE_CAPACITY_EXCEEDED").getModifiers()), "The field PEOPLE_CAPACITY_EXCEEDED must be public");
            assertTrue(Modifier.isStatic(SpaceShipException.class.getField("PEOPLE_CAPACITY_EXCEEDED").getModifiers()), "The field PEOPLE_CAPACITY_EXCEEDED must be static");
            assertTrue(Modifier.isFinal(SpaceShipException.class.getField("PEOPLE_CAPACITY_EXCEEDED").getModifiers()), "The field PEOPLE_CAPACITY_EXCEEDED must be final");
            assertEquals(String.class, SpaceShipException.class.getField("PEOPLE_CAPACITY_EXCEEDED").getType(), "The field PEOPLE_CAPACITY_EXCEEDED must be of type String");
            assertEquals("[ERROR] People capacity exceeded.", SpaceShipException.PEOPLE_CAPACITY_EXCEEDED, "The value of PEOPLE_CAPACITY_EXCEEDED field is incorrect");
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
