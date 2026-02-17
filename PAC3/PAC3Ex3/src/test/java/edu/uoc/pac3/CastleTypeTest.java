package edu.uoc.pac3;

import org.junit.jupiter.api.*;

import java.lang.reflect.Modifier;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CastleTypeTest {

    @Test
    @Order(1)
    @DisplayName("Sanity - Fields definitions")
    public void checkFieldsSanity() {
        assertEquals(10, CastleType.class.getDeclaredFields().length);

        try {
            assertTrue(Modifier.isPublic(CastleType.class.getDeclaredField("FORTRESS").getModifiers()));
            assertTrue(Modifier.isStatic(CastleType.class.getDeclaredField("FORTRESS").getModifiers()));
            assertTrue(Modifier.isFinal(CastleType.class.getDeclaredField("FORTRESS").getModifiers()));
            assertEquals(CastleType.class, CastleType.class.getDeclaredField("FORTRESS").getType());

            assertTrue(Modifier.isPublic(CastleType.class.getDeclaredField("ROYAL_PALACE").getModifiers()));
            assertTrue(Modifier.isStatic(CastleType.class.getDeclaredField("ROYAL_PALACE").getModifiers()));
            assertTrue(Modifier.isFinal(CastleType.class.getDeclaredField("ROYAL_PALACE").getModifiers()));
            assertEquals(CastleType.class, CastleType.class.getDeclaredField("ROYAL_PALACE").getType());

            assertTrue(Modifier.isPublic(CastleType.class.getDeclaredField("STRONGHOLD").getModifiers()));
            assertTrue(Modifier.isStatic(CastleType.class.getDeclaredField("STRONGHOLD").getModifiers()));
            assertTrue(Modifier.isFinal(CastleType.class.getDeclaredField("STRONGHOLD").getModifiers()));
            assertEquals(CastleType.class, CastleType.class.getDeclaredField("STRONGHOLD").getType());

            assertTrue(Modifier.isPublic(CastleType.class.getDeclaredField("CITADEL").getModifiers()));
            assertTrue(Modifier.isStatic(CastleType.class.getDeclaredField("CITADEL").getModifiers()));
            assertTrue(Modifier.isFinal(CastleType.class.getDeclaredField("CITADEL").getModifiers()));
            assertEquals(CastleType.class, CastleType.class.getDeclaredField("CITADEL").getType());

            assertTrue(Modifier.isPrivate(CastleType.class.getDeclaredField("SOLDIER_VALUE").getModifiers()));
            assertTrue(Modifier.isStatic(CastleType.class.getDeclaredField("SOLDIER_VALUE").getModifiers()));
            assertTrue(Modifier.isFinal(CastleType.class.getDeclaredField("SOLDIER_VALUE").getModifiers()));
            assertEquals(double.class, CastleType.class.getDeclaredField("SOLDIER_VALUE").getType());

            assertTrue(Modifier.isPrivate(CastleType.class.getDeclaredField("ARCHER_VALUE").getModifiers()));
            assertTrue(Modifier.isStatic(CastleType.class.getDeclaredField("ARCHER_VALUE").getModifiers()));
            assertTrue(Modifier.isFinal(CastleType.class.getDeclaredField("ARCHER_VALUE").getModifiers()));
            assertEquals(double.class, CastleType.class.getDeclaredField("ARCHER_VALUE").getType());

            assertTrue(Modifier.isPrivate(CastleType.class.getDeclaredField("description").getModifiers()));
            assertFalse(Modifier.isStatic(CastleType.class.getDeclaredField("description").getModifiers()));
            assertTrue(Modifier.isFinal(CastleType.class.getDeclaredField("description").getModifiers()));
            assertEquals(String.class, CastleType.class.getDeclaredField("description").getType());

            assertTrue(Modifier.isPrivate(CastleType.class.getDeclaredField("soldiers").getModifiers()));
            assertFalse(Modifier.isStatic(CastleType.class.getDeclaredField("soldiers").getModifiers()));
            assertTrue(Modifier.isFinal(CastleType.class.getDeclaredField("soldiers").getModifiers()));
            assertEquals(int.class, CastleType.class.getDeclaredField("soldiers").getType());

            assertTrue(Modifier.isPrivate(CastleType.class.getDeclaredField("archers").getModifiers()));
            assertFalse(Modifier.isStatic(CastleType.class.getDeclaredField("archers").getModifiers()));
            assertTrue(Modifier.isFinal(CastleType.class.getDeclaredField("archers").getModifiers()));
            assertEquals(int.class, CastleType.class.getDeclaredField("archers").getType());
        } catch (NoSuchFieldException e) {
            fail("[ERROR] There is some problem with the definition of the attributes: " + e.getMessage());
        }
    }

    @Test
    @Order(2)
    @DisplayName("Sanity - Methods definition")
    public void checkMethodsSanity() {
        assertEquals(1, CastleType.class.getDeclaredConstructors().length);
        assertEquals(8, Arrays.stream(CastleType.class.getDeclaredMethods()).filter(m -> Modifier.isPublic(m.getModifiers())).toList().size());

        try {
            assertTrue(Modifier.isPublic(CastleType.class.getDeclaredMethod("getDescription").getModifiers()));
            assertFalse(Modifier.isStatic(CastleType.class.getDeclaredMethod("getDescription").getModifiers()));
            assertFalse(Modifier.isFinal(CastleType.class.getDeclaredMethod("getDescription").getModifiers()));
            assertEquals(String.class, CastleType.class.getDeclaredMethod("getDescription").getReturnType());

            assertTrue(Modifier.isPublic(CastleType.class.getDeclaredMethod("getSoldiers").getModifiers()));
            assertFalse(Modifier.isStatic(CastleType.class.getDeclaredMethod("getSoldiers").getModifiers()));
            assertFalse(Modifier.isFinal(CastleType.class.getDeclaredMethod("getSoldiers").getModifiers()));
            assertEquals(int.class, CastleType.class.getDeclaredMethod("getSoldiers").getReturnType());

            assertTrue(Modifier.isPublic(CastleType.class.getDeclaredMethod("getArchers").getModifiers()));
            assertFalse(Modifier.isStatic(CastleType.class.getDeclaredMethod("getArchers").getModifiers()));
            assertFalse(Modifier.isFinal(CastleType.class.getDeclaredMethod("getArchers").getModifiers()));
            assertEquals(int.class, CastleType.class.getDeclaredMethod("getArchers").getReturnType());

            assertTrue(Modifier.isPublic(CastleType.class.getDeclaredMethod("getTotalValue").getModifiers()));
            assertFalse(Modifier.isStatic(CastleType.class.getDeclaredMethod("getTotalValue").getModifiers()));
            assertFalse(Modifier.isFinal(CastleType.class.getDeclaredMethod("getTotalValue").getModifiers()));
            assertEquals(double.class, CastleType.class.getDeclaredMethod("getTotalValue").getReturnType());

            assertTrue(Modifier.isPublic(CastleType.class.getDeclaredMethod("getType", String.class).getModifiers()));
            assertTrue(Modifier.isStatic(CastleType.class.getDeclaredMethod("getType", String.class).getModifiers()));
            assertFalse(Modifier.isFinal(CastleType.class.getDeclaredMethod("getType", String.class).getModifiers()));
            assertEquals(CastleType.class, CastleType.class.getDeclaredMethod("getType", String.class).getReturnType());

            assertTrue(Modifier.isPublic(CastleType.class.getDeclaredMethod("nextType").getModifiers()));
            assertFalse(Modifier.isStatic(CastleType.class.getDeclaredMethod("nextType").getModifiers()));
            assertFalse(Modifier.isFinal(CastleType.class.getDeclaredMethod("nextType").getModifiers()));
            assertEquals(CastleType.class, CastleType.class.getDeclaredMethod("nextType").getReturnType());
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the definition of the methods: " + e.getMessage());
        }
    }

    @Test
    @Order(3)
    @DisplayName("Castle Type - Description")
    public void testDescription() {
        assertEquals("Fortress", CastleType.FORTRESS.getDescription());
        assertEquals("Royal palace", CastleType.ROYAL_PALACE.getDescription());
        assertEquals("Stronghold", CastleType.STRONGHOLD.getDescription());
        assertEquals("Citadel", CastleType.CITADEL.getDescription());
    }

    @Test
    @Order(4)
    @DisplayName("Castle Type - Soldiers")
    public void testSoldiers() {
        assertEquals(40, CastleType.FORTRESS.getSoldiers());
        assertEquals(150, CastleType.ROYAL_PALACE.getSoldiers());
        assertEquals(400, CastleType.STRONGHOLD.getSoldiers());
        assertEquals(800, CastleType.CITADEL.getSoldiers());
    }

    @Test
    @Order(5)
    @DisplayName("Castle Type - Archers")
    public void testArchers() {
        assertEquals(20, CastleType.FORTRESS.getArchers());
        assertEquals(50, CastleType.ROYAL_PALACE.getArchers());
        assertEquals(250, CastleType.STRONGHOLD.getArchers());
        assertEquals(500, CastleType.CITADEL.getArchers());
    }

    @Test
    @Order(6)
    @DisplayName("Castle Type - Total Value")
    public void testTotalValue() {
        assertEquals(100.0, CastleType.FORTRESS.getTotalValue(), 0.01);
        assertEquals(325.0, CastleType.ROYAL_PALACE.getTotalValue(), 0.01);
        assertEquals(1100.0, CastleType.STRONGHOLD.getTotalValue(), 0.01);
        assertEquals(2200.0, CastleType.CITADEL.getTotalValue(), 0.01);
    }

    @Test
    @Order(7)
    @DisplayName("Castle Type - Get type")
    public void testGetType() {
        assertEquals(CastleType.FORTRESS, CastleType.getType("Fortress"));
        assertEquals(CastleType.ROYAL_PALACE, CastleType.getType("Royal palace"));
        assertEquals(CastleType.STRONGHOLD, CastleType.getType("Stronghold"));
        assertEquals(CastleType.CITADEL, CastleType.getType("Citadel"));
        assertNull(CastleType.getType("Unknown"));
    }

    @Test
    @Order(8)
    @DisplayName("Castle Type - Next type")
    public void testNextType() {
        assertEquals(CastleType.ROYAL_PALACE, CastleType.FORTRESS.nextType());
        assertEquals(CastleType.STRONGHOLD, CastleType.ROYAL_PALACE.nextType());
        assertEquals(CastleType.CITADEL, CastleType.STRONGHOLD.nextType());
        assertEquals(CastleType.CITADEL, CastleType.CITADEL.nextType());
    }

}
