package edu.uoc.pac4;

import edu.uoc.pac4.ship.SpaceShip;
import edu.uoc.pac4.ship.SpaceShipException;
import edu.uoc.pac4.ship.SpaceShipRolType;
import org.junit.jupiter.api.*;

import java.lang.reflect.Modifier;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SpaceGameTest {

    @Test
    @Order(1)
    @Tag("sanity")
    @DisplayName("Sanity - Fields definition")
    public void checkFields() {
        int numFields = 3;

        // Check attribute fields
        assertEquals(numFields, SpaceGame.class.getDeclaredFields().length, "The class must have exactly " + numFields + " fields.");

        try {
            assertTrue(Modifier.isPrivate(SpaceGame.class.getDeclaredField("MAX_SPACESHIPS").getModifiers()), "The attribute MAX_SPACESHIPS must be private.");
            assertTrue(Modifier.isStatic(SpaceGame.class.getDeclaredField("MAX_SPACESHIPS").getModifiers()), "The attribute MAX_SPACESHIPS must be static.");
            assertTrue(Modifier.isFinal(SpaceGame.class.getDeclaredField("MAX_SPACESHIPS").getModifiers()), "The attribute MAX_SPACESHIPS must be final.");
            assertEquals(int.class, SpaceGame.class.getDeclaredField("MAX_SPACESHIPS").getType(), "The attribute MAX_SPACESHIPS must be of type int.");

            assertTrue(Modifier.isPrivate(SpaceGame.class.getDeclaredField("galaxyName").getModifiers()), "The attribute galaxyName must be private.");
            assertFalse(Modifier.isStatic(SpaceGame.class.getDeclaredField("galaxyName").getModifiers()), "The attribute galaxyName must not be static.");
            assertFalse(Modifier.isFinal(SpaceGame.class.getDeclaredField("galaxyName").getModifiers()), "The attribute galaxyName must not be final.");
            assertEquals(String.class, SpaceGame.class.getDeclaredField("galaxyName").getType(), "The attribute galaxyName must be of type String.");

            assertTrue(Modifier.isPrivate(SpaceGame.class.getDeclaredField("spaceships").getModifiers()), "The attribute spaceships must be private.");
            assertFalse(Modifier.isStatic(SpaceGame.class.getDeclaredField("spaceships").getModifiers()), "The attribute spaceships must not be static.");
            assertFalse(Modifier.isFinal(SpaceGame.class.getDeclaredField("spaceships").getModifiers()), "The attribute spaceships must not be final.");
            assertEquals(List.class, SpaceGame.class.getDeclaredField("spaceships").getType(), "The attribute spaceships must be of type List.");
        } catch (NoSuchFieldException e) {
            fail("[ERROR] There is some problem with the definition of the attributes: " + e.getMessage());
        }
    }

    @Test
    @Order(2)
    @Tag("sanity")
    @DisplayName("Sanity - Constructors definition")
    public void checkConstructors() {
        int numConstructors = 1;

        // Check number of constructors
        assertEquals(numConstructors, SpaceGame.class.getConstructors().length, "The class must have exactly " + numConstructors + " constructor");

        try {
            assertTrue(Modifier.isPublic(SpaceGame.class.getConstructor(String.class).getModifiers()), "The constructor SpaceGame(String) must be public");
        } catch (NoSuchMethodException e) {
            fail("[ERROR] There is some problem with the definition of constructors: " + e.getMessage());
        }
    }

    @Test
    @Order(3)
    @Tag("sanity")
    @DisplayName("Sanity - Methods definition")
    public void checkMethods() {
        int numMethods = 7;

        // Check number of methods
        assertEquals(numMethods, SpaceGame.class.getDeclaredMethods().length, "The class must have exactly " + numMethods + " methods");

        try {
            assertTrue(Modifier.isPublic(SpaceGame.class.getDeclaredMethod("getGalaxyName").getModifiers()), "The method getGalaxyName() must be public");
            assertFalse(Modifier.isStatic(SpaceGame.class.getDeclaredMethod("getGalaxyName").getModifiers()), "The method getGalaxyName() must not be static");
            assertFalse(Modifier.isFinal(SpaceGame.class.getDeclaredMethod("getGalaxyName").getModifiers()), "The method getGalaxyName() must not be final");
            assertEquals(String.class, SpaceGame.class.getDeclaredMethod("getGalaxyName").getReturnType(), "The method getGalaxyName() must return a String");

            assertTrue(Modifier.isPublic(SpaceGame.class.getDeclaredMethod("setGalaxyName", String.class).getModifiers()), "The method setGalaxyName(String) must be public");
            assertFalse(Modifier.isStatic(SpaceGame.class.getDeclaredMethod("setGalaxyName", String.class).getModifiers()), "The method setGalaxyName(String) must not be static");
            assertFalse(Modifier.isFinal(SpaceGame.class.getDeclaredMethod("setGalaxyName", String.class).getModifiers()), "The method setGalaxyName(String) must not be final");
            assertEquals(void.class, SpaceGame.class.getDeclaredMethod("setGalaxyName", String.class).getReturnType(), "The method setGalaxyName(String) must return void");

            assertTrue(Modifier.isPublic(SpaceGame.class.getDeclaredMethod("getSpaceships").getModifiers()), "The method getSpaceships() must be public");
            assertFalse(Modifier.isStatic(SpaceGame.class.getDeclaredMethod("getSpaceships").getModifiers()), "The method getSpaceships() must not be static");
            assertFalse(Modifier.isFinal(SpaceGame.class.getDeclaredMethod("getSpaceships").getModifiers()), "The method getSpaceships() must not be final");
            assertEquals(List.class, SpaceGame.class.getDeclaredMethod("getSpaceships").getReturnType(), "The method getSpaceships() must return a List");

            assertTrue(Modifier.isPublic(SpaceGame.class.getDeclaredMethod("getMaxSpaceships").getModifiers()), "The method getMaxSpaceships() must be public");
            assertFalse(Modifier.isStatic(SpaceGame.class.getDeclaredMethod("getMaxSpaceships").getModifiers()), "The method getMaxSpaceships() must not be static");
            assertFalse(Modifier.isFinal(SpaceGame.class.getDeclaredMethod("getMaxSpaceships").getModifiers()), "The method getMaxSpaceships() must not be final");
            assertEquals(int.class, SpaceGame.class.getDeclaredMethod("getMaxSpaceships").getReturnType(), "The method getMaxSpaceships() must return an int");

            assertTrue(Modifier.isPublic(SpaceGame.class.getDeclaredMethod("addSpaceShip", SpaceShip.class).getModifiers()), "The method addSpaceShip(SpaceShip) must be public");
            assertFalse(Modifier.isStatic(SpaceGame.class.getDeclaredMethod("addSpaceShip", SpaceShip.class).getModifiers()), "The method addSpaceShip(SpaceShip) must not be static");
            assertFalse(Modifier.isFinal(SpaceGame.class.getDeclaredMethod("addSpaceShip", SpaceShip.class).getModifiers()), "The method addSpaceShip(SpaceShip) must not be final");
            assertEquals(boolean.class, SpaceGame.class.getDeclaredMethod("addSpaceShip", SpaceShip.class).getReturnType(), "The method addSpaceShip(SpaceShip) must return void");

            assertTrue(Modifier.isPublic(SpaceGame.class.getDeclaredMethod("removeSpaceShip", SpaceShip.class).getModifiers()), "The method removeSpaceShip(SpaceShip) must be public");
            assertFalse(Modifier.isStatic(SpaceGame.class.getDeclaredMethod("removeSpaceShip", SpaceShip.class).getModifiers()), "The method removeSpaceShip(SpaceShip) must not be static");
            assertFalse(Modifier.isFinal(SpaceGame.class.getDeclaredMethod("removeSpaceShip", SpaceShip.class).getModifiers()), "The method removeSpaceShip(SpaceShip) must not be final");
            assertEquals(boolean.class, SpaceGame.class.getDeclaredMethod("removeSpaceShip", SpaceShip.class).getReturnType(), "The method removeSpaceShip(SpaceShip) must return void");
        } catch (NoSuchMethodException e) {
            fail("[ERROR] There is some problem with the definition of methods: " + e.getMessage());
        }
    }

}
