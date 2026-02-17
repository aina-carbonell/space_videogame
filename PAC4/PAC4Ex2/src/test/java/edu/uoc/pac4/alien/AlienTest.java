package edu.uoc.pac4.alien;

import org.junit.jupiter.api.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AlienTest {

    @Test
    @Order(1)
    @Tag("sanity")
    @DisplayName("Sanity - Fields definition")
    public void checkFields() {
        int numFields = 1;

        // Check attribute fields
        assertEquals(numFields, Alien.class.getDeclaredFields().length, "The class must have exactly " + numFields + " fields.");

        try {
            assertTrue(Modifier.isPrivate(Alien.class.getDeclaredField("name").getModifiers()), "The attribute name must be private.");
            assertFalse(Modifier.isStatic(Alien.class.getDeclaredField("name").getModifiers()), "The attribute name must not be static.");
            assertFalse(Modifier.isFinal(Alien.class.getDeclaredField("name").getModifiers()), "The attribute name must not be final.");
            assertEquals(String.class, Alien.class.getDeclaredField("name").getType(), "The attribute name must be of type String.");
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

        Constructor<?>[] declaredConstructors = Alien.class.getDeclaredConstructors();
        assertEquals(numConstructors, declaredConstructors.length,
                "The class must declare exactly " + numConstructors + " constructor");

        try {
            Constructor<?> constructor = Alien.class.getDeclaredConstructor(String.class);

            int modifiers = constructor.getModifiers();

            assertTrue(Modifier.isProtected(modifiers), "The constructor Alien(String) must be protected");
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
        assertTrue(Modifier.isAbstract(Alien.class.getModifiers()), "The class Alien must be abstract");
    }

    @Test
    @Order(4)
    @Tag("sanity")
    @DisplayName("Sanity - Methods definition")
    public void checkMethods() {
        int numMethods = 3;

        // Check number of methods
        assertEquals(numMethods, Alien.class.getDeclaredMethods().length, "The class must have exactly " + numMethods + " methods");

        try {
            assertTrue(Modifier.isPublic(Alien.class.getDeclaredMethod("getName").getModifiers()), "The method getName() must be public");
            assertFalse(Modifier.isStatic(Alien.class.getDeclaredMethod("getName").getModifiers()), "The method getName() must not be static");
            assertFalse(Modifier.isFinal(Alien.class.getDeclaredMethod("getName").getModifiers()), "The method getName() must not be final");
            assertEquals(String.class, Alien.class.getDeclaredMethod("getName").getReturnType(), "The method getName() must return a String");

            assertTrue(Modifier.isProtected(Alien.class.getDeclaredMethod("setName", String.class).getModifiers()), "The method setName(String) must be protected");
            assertFalse(Modifier.isStatic(Alien.class.getDeclaredMethod("setName", String.class).getModifiers()), "The method setName(String) must not be static");
            assertFalse(Modifier.isFinal(Alien.class.getDeclaredMethod("setName", String.class).getModifiers()), "The method setName(String) must not be final");
            assertEquals(void.class, Alien.class.getDeclaredMethod("setName", String.class).getReturnType(), "The method setName(String) must return void");

            assertTrue(Modifier.isPublic(Alien.class.getDeclaredMethod("toString").getModifiers()), "The method toString() must be public");
            assertFalse(Modifier.isStatic(Alien.class.getDeclaredMethod("toString").getModifiers()), "The method toString() must not be static");
            assertFalse(Modifier.isFinal(Alien.class.getDeclaredMethod("toString").getModifiers()), "The method toString() must not be final");
            assertEquals(String.class, Alien.class.getDeclaredMethod("toString").getReturnType(), "The method toString() must return a String");
        } catch (NoSuchMethodException e) {
            fail("[ERROR] There is some problem with the definition of methods: " + e.getMessage());
        }
    }

}
