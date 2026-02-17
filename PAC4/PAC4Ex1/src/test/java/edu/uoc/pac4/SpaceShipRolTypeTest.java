package edu.uoc.pac4;

import org.junit.jupiter.api.*;

import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SpaceShipRolTypeTest {

    @Test
    @Order(1)
    @Tag("sanity")
    @DisplayName("Sanity - Literals definition")
    public void checkLiterals() {
        SpaceShipRolType[] literalsArray = SpaceShipRolType.values();
        List<SpaceShipRolType> literals = Arrays.asList(literalsArray);

        assertEquals(3, literals.size());

        assertTrue(literals.contains(SpaceShipRolType.BATTLE));
        assertTrue(literals.contains(SpaceShipRolType.SCIENCE));
        assertTrue(literals.contains(SpaceShipRolType.DIPLOMATIC));
    }

    @Test
    @Order(2)
    @Tag("sanity")
    @DisplayName("Sanity - Methods definition")
    public void checkMethods() {
        int numMethods = 4;

        // Check number of methods
        assertEquals(numMethods, SpaceShipRolType.class.getDeclaredMethods().length, "The class must have exactly " + numMethods + " method");

        try {
            assertTrue(Modifier.isPublic(SpaceShipRolType.class.getMethod("toString").getModifiers()), "The method toString() must be public");
            assertFalse(Modifier.isStatic(SpaceShipRolType.class.getMethod("toString").getModifiers()), "The method toString() must not be static");
            assertFalse(Modifier.isFinal(SpaceShipRolType.class.getMethod("toString").getModifiers()), "The method toString() must not be final");
            assertEquals(String.class, SpaceShipRolType.class.getMethod("toString").getReturnType(), "The method toString() must return a String");
        } catch (NoSuchMethodException e) {
            fail("[ERROR] There is some problem with the definition of methods: " + e.getMessage());
        }
    }

    @Test
    @Order(3)
    @Tag("advanced")
    @DisplayName("Advanced - toString method")
    public void testToString() {
        assertEquals("Battle", SpaceShipRolType.BATTLE.toString());
        assertEquals("Science", SpaceShipRolType.SCIENCE.toString());
        assertEquals("Diplomatic", SpaceShipRolType.DIPLOMATIC.toString());
    }

}
