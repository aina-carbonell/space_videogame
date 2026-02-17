package edu.uoc.pac4.alien;

import org.junit.jupiter.api.*;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ShapeShifterTest {

    @Test
    @Order(1)
    @Tag("sanity")
    @DisplayName("Sanity - Methods definition")
    public void checkMethods() {
        int numMethods = 2;

        assertEquals(2, ShapeShifter.class.getDeclaredMethods().length, "The interface must have exactly " + numMethods + " methods");

        final Class<ShapeShifter> ownClass = ShapeShifter.class;

        try {
            assertTrue(Modifier.isPublic(ownClass.getMethod("changeName").getModifiers()), "The method changeName() must be public");
            assertFalse(Modifier.isStatic(ownClass.getMethod("changeName").getModifiers()), "The method changeName() must not be static");
            assertFalse(Modifier.isFinal(ownClass.getMethod("changeName").getModifiers()), "The method changeName() must not be final");
            assertFalse(ownClass.getMethod("changeName").isDefault(), "The method changeName() must not be a default method");
            assertEquals(void.class, ownClass.getMethod("changeName").getReturnType(), "The method changeName() must return void");

            assertTrue(Modifier.isPublic(ownClass.getMethod("shapeShift").getModifiers()), "The method shapeShift() must be public");
            assertFalse(Modifier.isStatic(ownClass.getMethod("shapeShift").getModifiers()), "The method shapeShift() must not be static");
            assertFalse(Modifier.isFinal(ownClass.getMethod("shapeShift").getModifiers()), "The method shapeShift() must not be final");
            assertTrue(ownClass.getMethod("shapeShift").isDefault(), "The method shapeShift() must be a default method");
            assertEquals(void.class, ownClass.getMethod("shapeShift").getReturnType(), "The method shapeShift() must return void");
        } catch (NoSuchMethodException e) {
            fail("[ERROR] There is some problem with the definition of methods: " + e.getMessage());
        }
    }

}
