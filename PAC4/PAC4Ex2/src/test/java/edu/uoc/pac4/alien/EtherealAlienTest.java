package edu.uoc.pac4.alien;

import org.junit.jupiter.api.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EtherealAlienTest {

    @Test
    @Order(1)
    @Tag("sanity")
    @DisplayName("Sanity - Fields definition")
    public void checkFields() {
        int numFields = 1;

        // Check attribute fields
        assertEquals(numFields, EtherealAlien.class.getDeclaredFields().length, "The class must have exactly " + numFields + " fields.");

        try {
            assertTrue(Modifier.isPrivate(EtherealAlien.class.getDeclaredField("transparencyLevel").getModifiers()), "The attribute transparencyLevel must be private.");
            assertFalse(Modifier.isStatic(EtherealAlien.class.getDeclaredField("transparencyLevel").getModifiers()), "The attribute transparencyLevel must not be static.");
            assertFalse(Modifier.isFinal(EtherealAlien.class.getDeclaredField("transparencyLevel").getModifiers()), "The attribute transparencyLevel must not be final.");
            assertEquals(double.class, EtherealAlien.class.getDeclaredField("transparencyLevel").getType(), "The attribute transparencyLevel must be of type double.");
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

        Constructor<?>[] declaredConstructors = EtherealAlien.class.getDeclaredConstructors();
        assertEquals(numConstructors, declaredConstructors.length,
                "The class must declare exactly " + numConstructors + " constructor");

        try {
            Constructor<?> constructor = EtherealAlien.class.getDeclaredConstructor(String.class, double.class);

            int modifiers = constructor.getModifiers();

            assertTrue(Modifier.isProtected(modifiers), "The constructor EtherealAlien(String, double) must be protected");
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
        assertTrue(Modifier.isAbstract(EtherealAlien.class.getModifiers()), "The class EtherealAlien must be abstract");
    }

    @Test
    @Order(4)
    @Tag("sanity")
    @DisplayName("Sanity - Inheritance definition")
    public void checkInheritance() {
        assertEquals(Alien.class, EtherealAlien.class.getSuperclass(), "The class EtherealAlien must directly extend the Alien class");
    }

    @Test
    @Order(5)
    @Tag("sanity")
    @DisplayName("Sanity - Methods definition")
    public void checkMethods() {
        int numMethods = 3;

        // Check number of methods
        assertEquals(numMethods, EtherealAlien.class.getDeclaredMethods().length, "The class must have exactly " + numMethods + " methods");

        try {
            assertTrue(Modifier.isPublic(EtherealAlien.class.getDeclaredMethod("getTransparencyLevel").getModifiers()), "The method getTransparencyLevel() must be public");
            assertFalse(Modifier.isStatic(EtherealAlien.class.getDeclaredMethod("getTransparencyLevel").getModifiers()), "The method getTransparencyLevel() must not be static");
            assertFalse(Modifier.isFinal(EtherealAlien.class.getDeclaredMethod("getTransparencyLevel").getModifiers()), "The method getTransparencyLevel() must not be final");
            assertEquals(double.class, EtherealAlien.class.getDeclaredMethod("getTransparencyLevel").getReturnType(), "The method getTransparencyLevel() must return a double");

            assertTrue(Modifier.isPublic(EtherealAlien.class.getDeclaredMethod("setTransparencyLevel", double.class).getModifiers()), "The method setTransparencyLevel(double) must be public");
            assertFalse(Modifier.isStatic(EtherealAlien.class.getDeclaredMethod("setTransparencyLevel", double.class).getModifiers()), "The method setTransparencyLevel(double) must not be static");
            assertFalse(Modifier.isFinal(EtherealAlien.class.getDeclaredMethod("setTransparencyLevel", double.class).getModifiers()), "The method setTransparencyLevel(double) must not be final");
            assertEquals(void.class, EtherealAlien.class.getDeclaredMethod("setTransparencyLevel", double.class).getReturnType(), "The method setTransparencyLevel(double) must return void");

            assertTrue(Modifier.isPublic(EtherealAlien.class.getDeclaredMethod("toString").getModifiers()), "The method toString() must be public");
            assertFalse(Modifier.isStatic(EtherealAlien.class.getDeclaredMethod("toString").getModifiers()), "The method toString() must not be static");
            assertFalse(Modifier.isFinal(EtherealAlien.class.getDeclaredMethod("toString").getModifiers()), "The method toString() must not be final");
            assertEquals(String.class, EtherealAlien.class.getDeclaredMethod("toString").getReturnType(), "The method toString() must return a String");
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the definition of methods: " + e.getMessage());
        }
    }

}
