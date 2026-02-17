package edu.uoc.pac3;

import org.junit.jupiter.api.*;

import java.lang.reflect.Modifier;
import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CastleTest {

    @Test
    @Order(1)
    @DisplayName("Sanity - Fields definitions")
    public void checkFieldsDefinition() {
        assertEquals(18, Castle.class.getDeclaredFields().length);

        try {
            assertTrue(Modifier.isPublic(Castle.class.getDeclaredField("INVALID_CASTLE_TYPE").getModifiers()));
            assertTrue(Modifier.isStatic(Castle.class.getDeclaredField("INVALID_CASTLE_TYPE").getModifiers()));
            assertTrue(Modifier.isFinal(Castle.class.getDeclaredField("INVALID_CASTLE_TYPE").getModifiers()));
            assertEquals(String.class, Castle.class.getDeclaredField("INVALID_CASTLE_TYPE").getType());
            assertEquals("[ERROR] Invalid castle type", Castle.INVALID_CASTLE_TYPE);

            assertTrue(Modifier.isPrivate(Castle.class.getDeclaredField("castleType").getModifiers()));
            assertFalse(Modifier.isStatic(Castle.class.getDeclaredField("castleType").getModifiers()));
            assertFalse(Modifier.isFinal(Castle.class.getDeclaredField("castleType").getModifiers()));
            assertEquals(CastleType.class, Castle.class.getDeclaredField("castleType").getType());
        } catch (NoSuchFieldException e) {
            fail("[ERROR] There is some problem with the definition of the attributes: " + e.getMessage());
        }
    }

    @Test
    @Order(2)
    @DisplayName("Sanity - Constructor definition")
    public void checkConstructorSanity() {
        assertEquals(2, Castle.class.getDeclaredConstructors().length);

        try {
            assertTrue(Modifier.isPublic(Castle.class.getDeclaredConstructor(String.class, LocalDate.class, double.class, String.class, CastleType.class).getModifiers()));
            assertTrue(Modifier.isPublic(Castle.class.getDeclaredConstructor(String.class, LocalDate.class, double.class, String.class, CastleType.class, String.class, int.class, double.class, int.class, boolean.class).getModifiers()));
        } catch (NoSuchMethodException e) {
            fail("There is some problem with the definition of constructors: " + e.getMessage());
        }
    }

    @Test
    @Order(3)
    @DisplayName("Sanity - Methods definition")
    public void checkMethodsSanity() {
        assertEquals(8, Arrays.stream(Castle.class.getDeclaredMethods()).filter(m -> Modifier.isPublic(m.getModifiers())).toList().size());
        assertEquals(8, Arrays.stream(Castle.class.getDeclaredMethods()).filter(m -> Modifier.isPrivate(m.getModifiers())).toList().size());

        try {
            assertTrue(Modifier.isPublic(Castle.class.getDeclaredMethod("getCastleType").getModifiers()));
            assertFalse(Modifier.isStatic(Castle.class.getDeclaredMethod("getCastleType").getModifiers()));
            assertFalse(Modifier.isFinal(Castle.class.getDeclaredMethod("getCastleType").getModifiers()));
            assertEquals(CastleType.class, Castle.class.getDeclaredMethod("getCastleType").getReturnType());

            assertTrue(Modifier.isPrivate(Castle.class.getDeclaredMethod("setCastleType", CastleType.class).getModifiers()));
            assertFalse(Modifier.isStatic(Castle.class.getDeclaredMethod("setCastleType", CastleType.class).getModifiers()));
            assertFalse(Modifier.isFinal(Castle.class.getDeclaredMethod("setCastleType", CastleType.class).getModifiers()));
            assertEquals(void.class, Castle.class.getDeclaredMethod("setCastleType", CastleType.class).getReturnType());
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the definition of getter or setter methods: " + e.getMessage());
        }
    }

    @Test
    @Order(4)
    @DisplayName("Castle - Castle type")
    public void testCastleType() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Castle("UOC Castle", LocalDate.of(1300, 5, 15), 5000.0, "A dragon statue", null);
        });
        assertEquals("[ERROR] Invalid castle type", exception.getMessage());

        Castle castle = new Castle("UOC Castle", LocalDate.of(1300, 5, 15), 5000.0, "A dragon statue", CastleType.STRONGHOLD);
        assertEquals(CastleType.STRONGHOLD, castle.getCastleType());

        castle = new Castle("UOC Castle", LocalDate.of(1300, 5, 15), 5000.0, "A dragon statue", CastleType.STRONGHOLD,
                "Lord UOC", 5, 30.0, 20, true);
        assertEquals(CastleType.STRONGHOLD, castle.getCastleType());

        castle = new Castle("UOC Castle", LocalDate.of(1300, 5, 15), 5000.0, "A dragon statue", CastleType.CITADEL);
        assertEquals(CastleType.CITADEL, castle.getCastleType());

        castle = new Castle("UOC Castle", LocalDate.of(1300, 5, 15), 5000.0, "A dragon statue", CastleType.CITADEL,
                "Lord UOC", 5, 30.0, 20, true);
        assertEquals(CastleType.CITADEL, castle.getCastleType());

        castle = new Castle("UOC Castle", LocalDate.of(1300, 5, 15), 5000.0, "A dragon statue", CastleType.FORTRESS);
        assertEquals(CastleType.FORTRESS, castle.getCastleType());

        castle = new Castle("UOC Castle", LocalDate.of(1300, 5, 15), 5000.0, "A dragon statue", CastleType.FORTRESS,
                "Lord UOC", 5, 30.0, 20, true);
        assertEquals(CastleType.FORTRESS, castle.getCastleType());

        castle = new Castle("UOC Castle", LocalDate.of(1300, 5, 15), 5000.0, "A dragon statue", CastleType.ROYAL_PALACE);
        assertEquals(CastleType.ROYAL_PALACE, castle.getCastleType());

        castle = new Castle("UOC Castle", LocalDate.of(1300, 5, 15), 5000.0, "A dragon statue", CastleType.ROYAL_PALACE,
                "Lord UOC", 5, 30.0, 20, true);
        assertEquals(CastleType.ROYAL_PALACE, castle.getCastleType());
    }

}
