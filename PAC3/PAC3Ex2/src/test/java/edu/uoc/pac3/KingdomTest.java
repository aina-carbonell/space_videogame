package edu.uoc.pac3;

import org.junit.jupiter.api.*;

import java.lang.reflect.Modifier;
import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class KingdomTest {

    @BeforeEach
    public void resetNextId() throws Exception {
        java.lang.reflect.Field field = Castle.class.getDeclaredField("nextId");
        field.setAccessible(true);
        field.setInt(null, 1);
    }

    @Test
    @Order(1)
    @Tag("sanity")
    @DisplayName("Sanity - Fields definition")
    public void checkFieldsSanity() {
        assertEquals(21, Kingdom.class.getDeclaredFields().length);

        try {
            assertTrue(Modifier.isPrivate(Kingdom.class.getDeclaredField("MIN_NAME_LENGTH").getModifiers()));
            assertTrue(Modifier.isStatic(Kingdom.class.getDeclaredField("MIN_NAME_LENGTH").getModifiers()));
            assertTrue(Modifier.isFinal(Kingdom.class.getDeclaredField("MIN_NAME_LENGTH").getModifiers()));
            assertEquals(int.class, Kingdom.class.getDeclaredField("MIN_NAME_LENGTH").getType());

            assertTrue(Modifier.isPrivate(Kingdom.class.getDeclaredField("MAX_NAME_LENGTH").getModifiers()));
            assertTrue(Modifier.isStatic(Kingdom.class.getDeclaredField("MAX_NAME_LENGTH").getModifiers()));
            assertTrue(Modifier.isFinal(Kingdom.class.getDeclaredField("MAX_NAME_LENGTH").getModifiers()));
            assertEquals(int.class, Kingdom.class.getDeclaredField("MAX_NAME_LENGTH").getType());

            assertTrue(Modifier.isPrivate(Kingdom.class.getDeclaredField("CODE_LENGTH").getModifiers()));
            assertTrue(Modifier.isStatic(Kingdom.class.getDeclaredField("CODE_LENGTH").getModifiers()));
            assertTrue(Modifier.isFinal(Kingdom.class.getDeclaredField("CODE_LENGTH").getModifiers()));
            assertEquals(int.class, Kingdom.class.getDeclaredField("CODE_LENGTH").getType());

            assertTrue(Modifier.isPrivate(Kingdom.class.getDeclaredField("MIN_TREASURY").getModifiers()));
            assertTrue(Modifier.isStatic(Kingdom.class.getDeclaredField("MIN_TREASURY").getModifiers()));
            assertTrue(Modifier.isFinal(Kingdom.class.getDeclaredField("MIN_TREASURY").getModifiers()));
            assertEquals(double.class, Kingdom.class.getDeclaredField("MIN_TREASURY").getType());

            assertTrue(Modifier.isPublic(Kingdom.class.getDeclaredField("INVALID_NAME").getModifiers()));
            assertTrue(Modifier.isStatic(Kingdom.class.getDeclaredField("INVALID_NAME").getModifiers()));
            assertTrue(Modifier.isFinal(Kingdom.class.getDeclaredField("INVALID_NAME").getModifiers()));
            assertEquals(String.class, Kingdom.class.getDeclaredField("INVALID_NAME").getType());
            assertEquals("[ERROR] Kingdom name must have between 3 and 20 characters", Kingdom.INVALID_NAME);

            assertTrue(Modifier.isPublic(Kingdom.class.getDeclaredField("INVALID_CODE").getModifiers()));
            assertTrue(Modifier.isStatic(Kingdom.class.getDeclaredField("INVALID_CODE").getModifiers()));
            assertTrue(Modifier.isFinal(Kingdom.class.getDeclaredField("INVALID_CODE").getModifiers()));
            assertEquals(String.class, Kingdom.class.getDeclaredField("INVALID_CODE").getType());
            assertEquals("[ERROR] Kingdom code must have exactly 3 uppercase letters", Kingdom.INVALID_CODE);

            assertTrue(Modifier.isPublic(Kingdom.class.getDeclaredField("INVALID_LAST_WAR_DATE").getModifiers()));
            assertTrue(Modifier.isStatic(Kingdom.class.getDeclaredField("INVALID_LAST_WAR_DATE").getModifiers()));
            assertTrue(Modifier.isFinal(Kingdom.class.getDeclaredField("INVALID_LAST_WAR_DATE").getModifiers()));
            assertEquals(String.class, Kingdom.class.getDeclaredField("INVALID_LAST_WAR_DATE").getType());
            assertEquals("[ERROR] Last war date cannot be in the future", Kingdom.INVALID_LAST_WAR_DATE);

            assertTrue(Modifier.isPublic(Kingdom.class.getDeclaredField("INVALID_TREASURY").getModifiers()));
            assertTrue(Modifier.isStatic(Kingdom.class.getDeclaredField("INVALID_TREASURY").getModifiers()));
            assertTrue(Modifier.isFinal(Kingdom.class.getDeclaredField("INVALID_TREASURY").getModifiers()));
            assertEquals(String.class, Kingdom.class.getDeclaredField("INVALID_TREASURY").getType());
            assertEquals("[ERROR] Treasury cannot be less than -100000.0", Kingdom.INVALID_TREASURY);

            assertTrue(Modifier.isPublic(Kingdom.class.getDeclaredField("KINGDOM_FULL").getModifiers()));
            assertTrue(Modifier.isStatic(Kingdom.class.getDeclaredField("KINGDOM_FULL").getModifiers()));
            assertTrue(Modifier.isFinal(Kingdom.class.getDeclaredField("KINGDOM_FULL").getModifiers()));
            assertEquals(String.class, Kingdom.class.getDeclaredField("KINGDOM_FULL").getType());
            assertEquals("[ERROR] The number of castles cannot exceed the maximum", Kingdom.KINGDOM_FULL);

            assertTrue(Modifier.isPublic(Kingdom.class.getDeclaredField("CASTLE_NULL").getModifiers()));
            assertTrue(Modifier.isStatic(Kingdom.class.getDeclaredField("CASTLE_NULL").getModifiers()));
            assertTrue(Modifier.isFinal(Kingdom.class.getDeclaredField("CASTLE_NULL").getModifiers()));
            assertEquals(String.class, Kingdom.class.getDeclaredField("CASTLE_NULL").getType());
            assertEquals("[ERROR] The castle cannot be null", Kingdom.CASTLE_NULL);

            assertTrue(Modifier.isPublic(Kingdom.class.getDeclaredField("CASTLE_ALREADY_EXISTS").getModifiers()));
            assertTrue(Modifier.isStatic(Kingdom.class.getDeclaredField("CASTLE_ALREADY_EXISTS").getModifiers()));
            assertTrue(Modifier.isFinal(Kingdom.class.getDeclaredField("CASTLE_ALREADY_EXISTS").getModifiers()));
            assertEquals(String.class, Kingdom.class.getDeclaredField("CASTLE_ALREADY_EXISTS").getType());
            assertEquals("[ERROR] The castle already exists in the kingdom", Kingdom.CASTLE_ALREADY_EXISTS);

            assertTrue(Modifier.isPublic(Kingdom.class.getDeclaredField("CASTLE_NOT_FOUND").getModifiers()));
            assertTrue(Modifier.isStatic(Kingdom.class.getDeclaredField("CASTLE_NOT_FOUND").getModifiers()));
            assertTrue(Modifier.isFinal(Kingdom.class.getDeclaredField("CASTLE_NOT_FOUND").getModifiers()));
            assertEquals(String.class, Kingdom.class.getDeclaredField("CASTLE_NOT_FOUND").getType());
            assertEquals("[ERROR] The castle does not exist in the kingdom", Kingdom.CASTLE_NOT_FOUND);

            assertTrue(Modifier.isPrivate(Kingdom.class.getDeclaredField("MAX_CASTLES").getModifiers()));
            assertFalse(Modifier.isStatic(Kingdom.class.getDeclaredField("MAX_CASTLES").getModifiers()));
            assertTrue(Modifier.isFinal(Kingdom.class.getDeclaredField("MAX_CASTLES").getModifiers()));
            assertEquals(int.class, Kingdom.class.getDeclaredField("MAX_CASTLES").getType());

            assertTrue(Modifier.isPrivate(Kingdom.class.getDeclaredField("name").getModifiers()));
            assertFalse(Modifier.isStatic(Kingdom.class.getDeclaredField("name").getModifiers()));
            assertFalse(Modifier.isFinal(Kingdom.class.getDeclaredField("name").getModifiers()));
            assertEquals(String.class, Kingdom.class.getDeclaredField("name").getType());

            assertTrue(Modifier.isPrivate(Kingdom.class.getDeclaredField("code").getModifiers()));
            assertFalse(Modifier.isStatic(Kingdom.class.getDeclaredField("code").getModifiers()));
            assertFalse(Modifier.isFinal(Kingdom.class.getDeclaredField("code").getModifiers()));
            assertEquals(String.class, Kingdom.class.getDeclaredField("code").getType());

            assertTrue(Modifier.isPrivate(Kingdom.class.getDeclaredField("lastWarDate").getModifiers()));
            assertFalse(Modifier.isStatic(Kingdom.class.getDeclaredField("lastWarDate").getModifiers()));
            assertFalse(Modifier.isFinal(Kingdom.class.getDeclaredField("lastWarDate").getModifiers()));
            assertEquals(java.time.LocalDate.class, Kingdom.class.getDeclaredField("lastWarDate").getType());

            assertTrue(Modifier.isPrivate(Kingdom.class.getDeclaredField("treasury").getModifiers()));
            assertFalse(Modifier.isStatic(Kingdom.class.getDeclaredField("treasury").getModifiers()));
            assertFalse(Modifier.isFinal(Kingdom.class.getDeclaredField("treasury").getModifiers()));
            assertEquals(double.class, Kingdom.class.getDeclaredField("treasury").getType());

            assertTrue(Modifier.isPrivate(Kingdom.class.getDeclaredField("isReligious").getModifiers()));
            assertFalse(Modifier.isStatic(Kingdom.class.getDeclaredField("isReligious").getModifiers()));
            assertFalse(Modifier.isFinal(Kingdom.class.getDeclaredField("isReligious").getModifiers()));
            assertEquals(boolean.class, Kingdom.class.getDeclaredField("isReligious").getType());

            assertTrue(Modifier.isPrivate(Kingdom.class.getDeclaredField("castles").getModifiers()));
            assertFalse(Modifier.isStatic(Kingdom.class.getDeclaredField("castles").getModifiers()));
            assertFalse(Modifier.isFinal(Kingdom.class.getDeclaredField("castles").getModifiers()));
            assertEquals(Castle[].class, Kingdom.class.getDeclaredField("castles").getType());

            assertTrue(Modifier.isPrivate(Kingdom.class.getDeclaredField("numCastles").getModifiers()));
            assertFalse(Modifier.isStatic(Kingdom.class.getDeclaredField("numCastles").getModifiers()));
            assertFalse(Modifier.isFinal(Kingdom.class.getDeclaredField("numCastles").getModifiers()));
            assertEquals(int.class, Kingdom.class.getDeclaredField("numCastles").getType());

            assertTrue(Modifier.isPrivate(Kingdom.class.getDeclaredField("totalArea").getModifiers()));
            assertFalse(Modifier.isStatic(Kingdom.class.getDeclaredField("totalArea").getModifiers()));
            assertFalse(Modifier.isFinal(Kingdom.class.getDeclaredField("totalArea").getModifiers()));
            assertEquals(double.class, Kingdom.class.getDeclaredField("totalArea").getType());
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the definition of the attributes: " + e.getMessage());
        }
    }

    @Test
    @Order(2)
    @Tag("sanity")
    @DisplayName("Sanity - Constructor definition")
    public void checkConstructorSanity() {
        assertEquals(1, Kingdom.class.getDeclaredConstructors().length);

        try {
            assertTrue(Modifier.isPublic(Kingdom.class.getDeclaredConstructor(String.class, String.class, LocalDate.class, double.class, boolean.class, int.class).getModifiers()));
        } catch (NoSuchMethodException e) {
            fail("There is some problem with the definition of constructors: " + e.getMessage());
        }
    }

    @Test
    @Order(3)
    @Tag("sanity")
    @DisplayName("Sanity - Methods definition")
    public void checkMethodsSanity() {
        assertEquals(13, Arrays.stream(Kingdom.class.getDeclaredMethods()).filter(m -> Modifier.isPublic(m.getModifiers())).toList().size());
        assertEquals(7, Arrays.stream(Kingdom.class.getDeclaredMethods()).filter(m -> Modifier.isPrivate(m.getModifiers())).toList().size());

        try {
            assertTrue(Modifier.isPrivate(Kingdom.class.getDeclaredMethod("setName", String.class).getModifiers()));
            assertFalse(Modifier.isStatic(Kingdom.class.getDeclaredMethod("setName", String.class).getModifiers()));
            assertFalse(Modifier.isFinal(Kingdom.class.getDeclaredMethod("setName", String.class).getModifiers()));
            assertEquals(void.class, Kingdom.class.getDeclaredMethod("setName", String.class).getReturnType());

            assertTrue(Modifier.isPublic(Kingdom.class.getDeclaredMethod("getName").getModifiers()));
            assertFalse(Modifier.isStatic(Kingdom.class.getDeclaredMethod("getName").getModifiers()));
            assertFalse(Modifier.isFinal(Kingdom.class.getDeclaredMethod("getName").getModifiers()));
            assertEquals(String.class, Kingdom.class.getDeclaredMethod("getName").getReturnType());

            assertTrue(Modifier.isPrivate(Kingdom.class.getDeclaredMethod("setCode", String.class).getModifiers()));
            assertFalse(Modifier.isStatic(Kingdom.class.getDeclaredMethod("setCode", String.class).getModifiers()));
            assertFalse(Modifier.isFinal(Kingdom.class.getDeclaredMethod("setCode", String.class).getModifiers()));
            assertEquals(void.class, Kingdom.class.getDeclaredMethod("setCode", String.class).getReturnType());

            assertTrue(Modifier.isPublic(Kingdom.class.getDeclaredMethod("getCode").getModifiers()));
            assertFalse(Modifier.isStatic(Kingdom.class.getDeclaredMethod("getCode").getModifiers()));
            assertFalse(Modifier.isFinal(Kingdom.class.getDeclaredMethod("getCode").getModifiers()));
            assertEquals(String.class, Kingdom.class.getDeclaredMethod("getCode").getReturnType());

            assertTrue(Modifier.isPrivate(Kingdom.class.getDeclaredMethod("setLastWarDate", LocalDate.class).getModifiers()));
            assertFalse(Modifier.isStatic(Kingdom.class.getDeclaredMethod("setLastWarDate", LocalDate.class).getModifiers()));
            assertFalse(Modifier.isFinal(Kingdom.class.getDeclaredMethod("setLastWarDate", LocalDate.class).getModifiers()));
            assertEquals(void.class, Kingdom.class.getDeclaredMethod("setLastWarDate", LocalDate.class).getReturnType());

            assertTrue(Modifier.isPublic(Kingdom.class.getDeclaredMethod("getLastWarDate").getModifiers()));
            assertFalse(Modifier.isStatic(Kingdom.class.getDeclaredMethod("getLastWarDate").getModifiers()));
            assertFalse(Modifier.isFinal(Kingdom.class.getDeclaredMethod("getLastWarDate").getModifiers()));
            assertEquals(LocalDate.class, Kingdom.class.getDeclaredMethod("getLastWarDate").getReturnType());

            assertTrue(Modifier.isPrivate(Kingdom.class.getDeclaredMethod("setTreasury", double.class).getModifiers()));
            assertFalse(Modifier.isStatic(Kingdom.class.getDeclaredMethod("setTreasury", double.class).getModifiers()));
            assertFalse(Modifier.isFinal(Kingdom.class.getDeclaredMethod("setTreasury", double.class).getModifiers()));
            assertEquals(void.class, Kingdom.class.getDeclaredMethod("setTreasury", double.class).getReturnType());

            assertTrue(Modifier.isPublic(Kingdom.class.getDeclaredMethod("getTreasury").getModifiers()));
            assertFalse(Modifier.isStatic(Kingdom.class.getDeclaredMethod("getTreasury").getModifiers()));
            assertFalse(Modifier.isFinal(Kingdom.class.getDeclaredMethod("getTreasury").getModifiers()));
            assertEquals(double.class, Kingdom.class.getDeclaredMethod("getTreasury").getReturnType());

            assertTrue(Modifier.isPrivate(Kingdom.class.getDeclaredMethod("setIsReligious", boolean.class).getModifiers()));
            assertFalse(Modifier.isStatic(Kingdom.class.getDeclaredMethod("setIsReligious", boolean.class).getModifiers()));
            assertFalse(Modifier.isFinal(Kingdom.class.getDeclaredMethod("setIsReligious", boolean.class).getModifiers()));
            assertEquals(void.class, Kingdom.class.getDeclaredMethod("setIsReligious", boolean.class).getReturnType());

            assertTrue(Modifier.isPublic(Kingdom.class.getDeclaredMethod("isReligious").getModifiers()));
            assertFalse(Modifier.isStatic(Kingdom.class.getDeclaredMethod("isReligious").getModifiers()));
            assertFalse(Modifier.isFinal(Kingdom.class.getDeclaredMethod("isReligious").getModifiers()));
            assertEquals(boolean.class, Kingdom.class.getDeclaredMethod("isReligious").getReturnType());

            assertTrue(Modifier.isPublic(Kingdom.class.getDeclaredMethod("getDaysWithoutWar").getModifiers()));
            assertFalse(Modifier.isStatic(Kingdom.class.getDeclaredMethod("getDaysWithoutWar").getModifiers()));
            assertFalse(Modifier.isFinal(Kingdom.class.getDeclaredMethod("getDaysWithoutWar").getModifiers()));
            assertEquals(long.class, Kingdom.class.getDeclaredMethod("getDaysWithoutWar").getReturnType());

            assertTrue(Modifier.isPublic(Kingdom.class.getDeclaredMethod("getMaxCastles").getModifiers()));
            assertFalse(Modifier.isStatic(Kingdom.class.getDeclaredMethod("getMaxCastles").getModifiers()));
            assertFalse(Modifier.isFinal(Kingdom.class.getDeclaredMethod("getMaxCastles").getModifiers()));
            assertEquals(int.class, Kingdom.class.getDeclaredMethod("getMaxCastles").getReturnType());

            assertTrue(Modifier.isPublic(Kingdom.class.getDeclaredMethod("getCastles").getModifiers()));
            assertFalse(Modifier.isStatic(Kingdom.class.getDeclaredMethod("getCastles").getModifiers()));
            assertFalse(Modifier.isFinal(Kingdom.class.getDeclaredMethod("getCastles").getModifiers()));
            assertEquals(Castle[].class, Kingdom.class.getDeclaredMethod("getCastles").getReturnType());

            assertTrue(Modifier.isPublic(Kingdom.class.getDeclaredMethod("getNumCastles").getModifiers()));
            assertFalse(Modifier.isStatic(Kingdom.class.getDeclaredMethod("getNumCastles").getModifiers()));
            assertFalse(Modifier.isFinal(Kingdom.class.getDeclaredMethod("getNumCastles").getModifiers()));
            assertEquals(int.class, Kingdom.class.getDeclaredMethod("getNumCastles").getReturnType());

            assertTrue(Modifier.isPrivate(Kingdom.class.getDeclaredMethod("findCastle", Castle.class).getModifiers()));
            assertFalse(Modifier.isStatic(Kingdom.class.getDeclaredMethod("findCastle", Castle.class).getModifiers()));
            assertFalse(Modifier.isFinal(Kingdom.class.getDeclaredMethod("findCastle", Castle.class).getModifiers()));
            assertEquals(int.class, Kingdom.class.getDeclaredMethod("findCastle", Castle.class).getReturnType());

            assertTrue(Modifier.isPrivate(Kingdom.class.getDeclaredMethod("findFirstEmptySlot").getModifiers()));
            assertFalse(Modifier.isStatic(Kingdom.class.getDeclaredMethod("findFirstEmptySlot").getModifiers()));
            assertFalse(Modifier.isFinal(Kingdom.class.getDeclaredMethod("findFirstEmptySlot").getModifiers()));
            assertEquals(int.class, Kingdom.class.getDeclaredMethod("findFirstEmptySlot").getReturnType());

            assertTrue(Modifier.isPublic(Kingdom.class.getDeclaredMethod("containsCastle", Castle.class).getModifiers()));
            assertFalse(Modifier.isStatic(Kingdom.class.getDeclaredMethod("containsCastle", Castle.class).getModifiers()));
            assertFalse(Modifier.isFinal(Kingdom.class.getDeclaredMethod("containsCastle", Castle.class).getModifiers()));
            assertEquals(boolean.class, Kingdom.class.getDeclaredMethod("containsCastle", Castle.class).getReturnType());

            assertTrue(Modifier.isPublic(Kingdom.class.getDeclaredMethod("addCastle", Castle.class).getModifiers()));
            assertFalse(Modifier.isStatic(Kingdom.class.getDeclaredMethod("addCastle", Castle.class).getModifiers()));
            assertFalse(Modifier.isFinal(Kingdom.class.getDeclaredMethod("addCastle", Castle.class).getModifiers()));
            assertEquals(void.class, Kingdom.class.getDeclaredMethod("addCastle", Castle.class).getReturnType());

            assertTrue(Modifier.isPublic(Kingdom.class.getDeclaredMethod("removeCastle", Castle.class).getModifiers()));
            assertFalse(Modifier.isStatic(Kingdom.class.getDeclaredMethod("removeCastle", Castle.class).getModifiers()));
            assertFalse(Modifier.isFinal(Kingdom.class.getDeclaredMethod("removeCastle", Castle.class).getModifiers()));
            assertEquals(void.class, Kingdom.class.getDeclaredMethod("removeCastle", Castle.class).getReturnType());

            assertTrue(Modifier.isPublic(Kingdom.class.getDeclaredMethod("getAverageArea").getModifiers()));
            assertFalse(Modifier.isStatic(Kingdom.class.getDeclaredMethod("getAverageArea").getModifiers()));
            assertFalse(Modifier.isFinal(Kingdom.class.getDeclaredMethod("getAverageArea").getModifiers()));
            assertEquals(double.class, Kingdom.class.getDeclaredMethod("getAverageArea").getReturnType());
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the definition of getter or setter methods: " + e.getMessage());
        }
    }

    @Test
    @Order(4)
    @Tag("minimum")
    @DisplayName("Minimum - Valid parameters")
    public void testCreateKingdomValidParameters() {
        Kingdom kingdom = new Kingdom("UOC Kingdom", "UOC", LocalDate.of(1000, 1, 1), 50000.0, false, 5);

        assertEquals("UOC Kingdom", kingdom.getName());
        assertEquals("UOC", kingdom.getCode());
        assertEquals(LocalDate.of(1000, 1, 1), kingdom.getLastWarDate());
        assertEquals(50000.0, kingdom.getTreasury());
        assertFalse(kingdom.isReligious());
        assertEquals(5, kingdom.getMaxCastles());

        kingdom = new Kingdom("UOC Kingdom", "UOC", null, 50000.0, true, 100);

        assertEquals("UOC Kingdom", kingdom.getName());
        assertEquals("UOC", kingdom.getCode());
        assertNull(kingdom.getLastWarDate());
        assertEquals(50000.0, kingdom.getTreasury());
        assertTrue(kingdom.isReligious());
        assertEquals(100, kingdom.getMaxCastles());
    }

    @Test
    @Order(5)
    @Tag("minimum")
    @DisplayName("Minimum - Name")
    public void testCreateKingdomName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {new Kingdom(null, "UOC", LocalDate.of(1000, 1, 1), 50000.0, false, 5);});
        assertEquals("[ERROR] Kingdom name must have between 3 and 20 characters", exception.getMessage());

        assertThrows(IllegalArgumentException.class, () -> {new Kingdom("", "UOC", LocalDate.of(1000, 1, 1), 50000.0, false, 5);});
        assertThrows(IllegalArgumentException.class, () -> {new Kingdom("  ", "UOC", LocalDate.of(1000, 1, 1), 50000.0, false, 5);});
        assertThrows(IllegalArgumentException.class, () -> {new Kingdom("AB", "UOC", LocalDate.of(1000, 1, 1), 50000.0, false, 5);});
        assertThrows(IllegalArgumentException.class, () -> {new Kingdom("A".repeat(21), "UOC", LocalDate.of(1000, 1, 1), 50000.0, false, 5);});
        assertThrows(IllegalArgumentException.class, () -> {new Kingdom("  AB  ", "UOC", LocalDate.of(1000, 1, 1), 50000.0, false, 5);});
        assertThrows(IllegalArgumentException.class, () -> {new Kingdom("UOC".repeat(18), "UOC", LocalDate.of(1000, 1, 1), 50000.0, false, 5);});

        Kingdom kingdom = new Kingdom("  UOC Kingdom  ", "UOC", LocalDate.of(1000, 1, 1), 50000.0, false, 5);
        assertEquals("UOC Kingdom", kingdom.getName());

        kingdom = new Kingdom("__UOC Kingdom__", "UOC", LocalDate.of(1000, 1, 1), 50000.0, false, 5);
        assertEquals("__UOC Kingdom__", kingdom.getName());

        kingdom = new Kingdom(" U  O  C ", "UOC", LocalDate.of(1000, 1, 1), 50000.0, false, 5);
        assertEquals("U  O  C", kingdom.getName());

        kingdom = new Kingdom(" " + "A".repeat(19) + " ", "UOC", LocalDate.of(1000, 1, 1), 50000.0, false, 5);
        assertEquals("A".repeat(19), kingdom.getName());
    }

    @Test
    @Order(6)
    @Tag("minimum")
    @DisplayName("Minimum - Code")
    public void testCreateKingdomCode() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {new Kingdom("UOC Kingdom", null, LocalDate.of(1000, 1, 1), 50000.0, false, 5);});
        assertEquals("[ERROR] Kingdom code must have exactly 3 uppercase letters", exception.getMessage());

        assertThrows(IllegalArgumentException.class, () -> {new Kingdom("UOC Kingdom", "", LocalDate.of(1000, 1, 1), 50000.0, false, 5);});
        assertThrows(IllegalArgumentException.class, () -> {new Kingdom("UOC Kingdom", "  ", LocalDate.of(1000, 1, 1), 50000.0, false, 5);});
        assertThrows(IllegalArgumentException.class, () -> {new Kingdom("UOC Kingdom", "AB", LocalDate.of(1000, 1, 1), 50000.0, false, 5);});
        assertThrows(IllegalArgumentException.class, () -> {new Kingdom("UOC Kingdom", "ABCD", LocalDate.of(1000, 1, 1), 50000.0, false, 5);});
        assertThrows(IllegalArgumentException.class, () -> {new Kingdom("UOC Kingdom", "uoc", LocalDate.of(1000, 1, 1), 50000.0, false, 5);});
        assertThrows(IllegalArgumentException.class, () -> {new Kingdom("UOC Kingdom", "UoC", LocalDate.of(1000, 1, 1), 50000.0, false, 5);});
        assertThrows(IllegalArgumentException.class, () -> {new Kingdom("UOC Kingdom", "U1C", LocalDate.of(1000, 1, 1), 50000.0, false, 5);});
        assertThrows(IllegalArgumentException.class, () -> {new Kingdom("UOC Kingdom", " UOC ", LocalDate.of(1000, 1, 1), 50000.0, false, 5);});

        Kingdom kingdom = new Kingdom("UOC Kingdom", "UOC", LocalDate.of(1000, 1, 1), 50000.0, false, 5);
        assertEquals("UOC", kingdom.getCode());

        kingdom = new Kingdom("UOC Kingdom", "ABC", LocalDate.of(1000, 1, 1), 50000.0, false, 5);
        assertEquals("ABC", kingdom.getCode());
    }

    @Test
    @Order(7)
    @Tag("minimum")
    @DisplayName("Minimum - Last war date")
    public void testCreateKingdomLastWarDate() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {new Kingdom("UOC Kingdom", "UOC", LocalDate.now().plusDays(1), 50000.0, false, 5);});
        assertEquals("[ERROR] Last war date cannot be in the future", exception.getMessage());

        Kingdom kingdom = new Kingdom("UOC Kingdom", "UOC", null, 50000.0, false, 5);
        assertNull(kingdom.getLastWarDate());

        kingdom = new Kingdom("UOC Kingdom", "UOC", LocalDate.now(), 50000.0, false, 5);
        assertEquals(LocalDate.now(), kingdom.getLastWarDate());

        kingdom = new Kingdom("UOC Kingdom", "UOC", LocalDate.now().minusDays(1), 50000.0, false, 5);
        assertEquals(LocalDate.now().minusDays(1), kingdom.getLastWarDate());

        kingdom = new Kingdom("UOC Kingdom", "UOC", LocalDate.of(1500, 6, 15), 50000.0, false, 5);
        assertEquals(LocalDate.of(1500, 6, 15), kingdom.getLastWarDate());
    }

    @Test
    @Order(8)
    @Tag("minimum")
    @DisplayName("Minimum - Treasury")
    public void testCreateKingdomTreasury() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {new Kingdom("UOC Kingdom", "UOC", LocalDate.of(1000, 1, 1), -100001.0, false, 5);});
        assertEquals("[ERROR] Treasury cannot be less than -100000.0", exception.getMessage());

        Kingdom kingdom = new Kingdom("UOC Kingdom", "UOC", LocalDate.of(1000, 1, 1), -100000.0, false, 5);
        assertEquals(-100000.0, kingdom.getTreasury());

        kingdom = new Kingdom("UOC Kingdom", "UOC", LocalDate.of(1000, 1, 1), 0.0, false, 5);
        assertEquals(0.0, kingdom.getTreasury());

        kingdom = new Kingdom("UOC Kingdom", "UOC", LocalDate.of(1000, 1, 1), 50000.0, false, 5);
        assertEquals(50000.0, kingdom.getTreasury());

        kingdom = new Kingdom("UOC Kingdom", "UOC", LocalDate.of(1000, 1, 1), 1_000_000.0, false, 5);
        assertEquals(1_000_000.0, kingdom.getTreasury());
    }

    @Test
    @Order(9)
    @Tag("minimum")
    @DisplayName("Minimum - Is religious")
    public void testCreateKingdomIsReligious() {
        Kingdom kingdom = new Kingdom("UOC Kingdom", "UOC", LocalDate.of(1000, 1, 1), 50000.0, false, 5);
        assertFalse(kingdom.isReligious());

        kingdom = new Kingdom("UOC Kingdom", "UOC", LocalDate.of(1000, 1, 1), 50000.0, true, 5);
        assertTrue(kingdom.isReligious());
    }

    @Test
    @Order(10)
    @Tag("minimum")
    @DisplayName("Minimum - Days without war")
    public void testGetDaysWithoutWar() {
        Kingdom kingdom = new Kingdom("UOC Kingdom", "UOC", null, 50000.0, false, 5);
        assertEquals(Integer.MAX_VALUE, kingdom.getDaysWithoutWar());

        kingdom = new Kingdom("UOC Kingdom", "UOC", LocalDate.now(), 50000.0, false, 5);
        assertEquals(0, kingdom.getDaysWithoutWar());

        kingdom = new Kingdom("UOC Kingdom", "UOC", LocalDate.now().minusDays(10), 50000.0, false, 5);
        assertEquals(10, kingdom.getDaysWithoutWar());

        kingdom = new Kingdom("UOC Kingdom", "UOC", LocalDate.of(2000, 1, 1), 50000.0, false, 5);
        long expectedDays = java.time.temporal.ChronoUnit.DAYS.between(LocalDate.of(2000, 1, 1), LocalDate.now());
        assertEquals(expectedDays, kingdom.getDaysWithoutWar());
    }

    @Test
    @Order(11)
    @Tag("advanced")
    @DisplayName("Advanced - Max castles")
    public void testCreateKingdomMaxCastles() {
        Kingdom kingdom = new Kingdom("UOC Kingdom", "UOC", LocalDate.of(1000, 1, 1), 50000.0, false, 0);
        assertEquals(0, kingdom.getMaxCastles());

        kingdom = new Kingdom("UOC Kingdom", "UOC", LocalDate.of(1000, 1, 1), 50000.0, false, 1);
        assertEquals(1, kingdom.getMaxCastles());

        kingdom = new Kingdom("UOC Kingdom", "UOC", LocalDate.of(1000, 1, 1), 50000.0, false, 50);
        assertEquals(50, kingdom.getMaxCastles());

        kingdom = new Kingdom("UOC Kingdom", "UOC", LocalDate.of(1000, 1, 1), 50000.0, false, 100);
        assertEquals(100, kingdom.getMaxCastles());
    }

    @Test
    @Order(12)
    @Tag("advanced")
    @DisplayName("Advanced - Add castle")
    public void testAddCastle() {
        Kingdom kingdom = new Kingdom("UOC Kingdom", "UOC", LocalDate.of(500, 1, 1), 50000.0, false, 5);
        Castle castle1 = new Castle("UOC Castle 1", LocalDate.of(600, 1, 1), 1000.0, "A dragon statue");
        Castle castle2 = new Castle("UOC Castle 2", LocalDate.of(700, 1, 1), 2000.0, "An ancient sword");
        Castle castle3 = new Castle("UOC Castle 3", LocalDate.of(800, 1, 1), 3000.0, "A royal crown");
        Castle castle4 = new Castle("UOC Castle 4", LocalDate.of(900, 1, 1), 4000.0, "A magical shield");
        Castle castle5 = new Castle("UOC Castle 5", LocalDate.of(1000, 1, 1), 5000.0, "A golden scepter");
        Castle castle6 = new Castle("UOC Castle 6", LocalDate.of(1100, 1, 1), 6000.0, "A jeweled necklace");

        assertEquals(5, kingdom.getMaxCastles());
        assertEquals(0, kingdom.getNumCastles());

        Exception exception = assertThrows(NullPointerException.class, () -> {kingdom.addCastle(null);});
        assertEquals("[ERROR] The castle cannot be null", exception.getMessage());
        assertEquals(0, kingdom.getNumCastles());

        kingdom.addCastle(castle1);

        assertEquals(1, kingdom.getNumCastles());
        assertTrue(kingdom.containsCastle(castle1));
        assertEquals(castle1, kingdom.getCastles()[0]);
        for (int i = 1; i < kingdom.getMaxCastles(); i++) {
            assertNull(kingdom.getCastles()[i]);
        }

        exception = assertThrows(IllegalArgumentException.class, () -> {kingdom.addCastle(castle1);});
        assertEquals("[ERROR] The castle already exists in the kingdom", exception.getMessage());
        assertEquals(1, kingdom.getNumCastles());
        assertTrue(kingdom.containsCastle(castle1));
        assertEquals(castle1, kingdom.getCastles()[0]);
        for (int i = 1; i < kingdom.getMaxCastles(); i++) {
            assertNull(kingdom.getCastles()[i]);
        }

        kingdom.addCastle(castle2);
        assertEquals(2, kingdom.getNumCastles());
        assertTrue(kingdom.containsCastle(castle1));
        assertTrue(kingdom.containsCastle(castle2));
        assertEquals(castle1, kingdom.getCastles()[0]);
        assertEquals(castle2, kingdom.getCastles()[1]);
        for (int i = 2; i < kingdom.getMaxCastles(); i++) {
            assertNull(kingdom.getCastles()[i]);
        }

        kingdom.addCastle(castle3);
        assertEquals(3, kingdom.getNumCastles());
        assertTrue(kingdom.containsCastle(castle1));
        assertTrue(kingdom.containsCastle(castle2));
        assertTrue(kingdom.containsCastle(castle3));
        assertEquals(castle1, kingdom.getCastles()[0]);
        assertEquals(castle2, kingdom.getCastles()[1]);
        assertEquals(castle3, kingdom.getCastles()[2]);
        for (int i = 3; i < kingdom.getMaxCastles(); i++) {
            assertNull(kingdom.getCastles()[i]);
        }

        kingdom.addCastle(castle4);
        assertEquals(4, kingdom.getNumCastles());
        assertTrue(kingdom.containsCastle(castle1));
        assertTrue(kingdom.containsCastle(castle2));
        assertTrue(kingdom.containsCastle(castle3));
        assertTrue(kingdom.containsCastle(castle4));
        assertEquals(castle1, kingdom.getCastles()[0]);
        assertEquals(castle2, kingdom.getCastles()[1]);
        assertEquals(castle3, kingdom.getCastles()[2]);
        assertEquals(castle4, kingdom.getCastles()[3]);
        for (int i = 4; i < kingdom.getMaxCastles(); i++) {
            assertNull(kingdom.getCastles()[i]);
        }

        kingdom.addCastle(castle5);
        assertEquals(5, kingdom.getNumCastles());
        assertTrue(kingdom.containsCastle(castle1));
        assertTrue(kingdom.containsCastle(castle2));
        assertTrue(kingdom.containsCastle(castle3));
        assertTrue(kingdom.containsCastle(castle4));
        assertTrue(kingdom.containsCastle(castle5));
        assertEquals(castle1, kingdom.getCastles()[0]);
        assertEquals(castle2, kingdom.getCastles()[1]);
        assertEquals(castle3, kingdom.getCastles()[2]);
        assertEquals(castle4, kingdom.getCastles()[3]);
        assertEquals(castle5, kingdom.getCastles()[4]);

        exception = assertThrows(IllegalStateException.class, () -> {kingdom.addCastle(castle6);});
        assertEquals("[ERROR] The number of castles cannot exceed the maximum", exception.getMessage());
        assertEquals(5, kingdom.getNumCastles());
        assertTrue(kingdom.containsCastle(castle1));
        assertTrue(kingdom.containsCastle(castle2));
        assertTrue(kingdom.containsCastle(castle3));
        assertTrue(kingdom.containsCastle(castle4));
        assertTrue(kingdom.containsCastle(castle5));
        assertEquals(castle1, kingdom.getCastles()[0]);
        assertEquals(castle2, kingdom.getCastles()[1]);
        assertEquals(castle3, kingdom.getCastles()[2]);
        assertEquals(castle4, kingdom.getCastles()[3]);
        assertEquals(castle5, kingdom.getCastles()[4]);
        assertFalse(kingdom.containsCastle(castle6));
    }

    @Test
    @Order(13)
    @Tag("advanced")
    @DisplayName("Advanced - Remove castle")
    public void testRemoveCastle() {
        Kingdom kingdom = new Kingdom("UOC Kingdom", "UOC", LocalDate.of(500, 1, 1), 50000.0, false, 5);
        Castle castle1 = new Castle("UOC Castle 1", LocalDate.of(600, 1, 1), 1000.0, "A dragon statue");
        Castle castle2 = new Castle("UOC Castle 2", LocalDate.of(700, 1, 1), 2000.0, "An ancient sword");
        Castle castle3 = new Castle("UOC Castle", LocalDate.of(800, 1, 1), 3000.0, "A royal crown");
        Castle castle4 = new Castle("UOC Castle 4", LocalDate.of(900, 1, 1), 4000.0, "A magical shield");
        Castle castle5 = new Castle("UOC Castle", LocalDate.of(1000, 1, 1), 5000.0, "A golden scepter");

        Exception exception = assertThrows(NullPointerException.class, () -> {kingdom.removeCastle(null);});
        assertEquals("[ERROR] The castle cannot be null", exception.getMessage());
        assertEquals(0, kingdom.getNumCastles());

        exception = assertThrows(IllegalArgumentException.class, () -> {kingdom.removeCastle(castle1);});
        assertEquals("[ERROR] The castle does not exist in the kingdom", exception.getMessage());
        assertEquals(0, kingdom.getNumCastles());

        kingdom.addCastle(castle1);
        kingdom.addCastle(castle2);
        kingdom.addCastle(castle3);
        kingdom.addCastle(castle4);
        kingdom.addCastle(castle5);
        assertEquals(5, kingdom.getNumCastles());
        assertTrue(kingdom.containsCastle(castle1));
        assertTrue(kingdom.containsCastle(castle2));
        assertTrue(kingdom.containsCastle(castle3));
        assertTrue(kingdom.containsCastle(castle4));
        assertTrue(kingdom.containsCastle(castle5));
        assertEquals(castle1, kingdom.getCastles()[0]);
        assertEquals(castle2, kingdom.getCastles()[1]);
        assertEquals(castle3, kingdom.getCastles()[2]);
        assertEquals(castle4, kingdom.getCastles()[3]);
        assertEquals(castle5, kingdom.getCastles()[4]);

        kingdom.removeCastle(castle3);
        assertEquals(4, kingdom.getNumCastles());
        assertTrue(kingdom.containsCastle(castle1));
        assertTrue(kingdom.containsCastle(castle2));
        assertFalse(kingdom.containsCastle(castle3));
        assertTrue(kingdom.containsCastle(castle4));
        assertTrue(kingdom.containsCastle(castle5));
        assertEquals(castle1, kingdom.getCastles()[0]);
        assertEquals(castle2, kingdom.getCastles()[1]);
        assertNull(kingdom.getCastles()[2]);
        assertEquals(castle4, kingdom.getCastles()[3]);
        assertEquals(castle5, kingdom.getCastles()[4]);

        kingdom.removeCastle(castle1);
        assertEquals(3, kingdom.getNumCastles());
        assertFalse(kingdom.containsCastle(castle1));
        assertTrue(kingdom.containsCastle(castle2));
        assertFalse(kingdom.containsCastle(castle3));
        assertTrue(kingdom.containsCastle(castle4));
        assertTrue(kingdom.containsCastle(castle5));
        assertNull(kingdom.getCastles()[0]);
        assertEquals(castle2, kingdom.getCastles()[1]);
        assertNull(kingdom.getCastles()[2]);
        assertEquals(castle4, kingdom.getCastles()[3]);
        assertEquals(castle5, kingdom.getCastles()[4]);

        kingdom.removeCastle(castle5);
        assertEquals(2, kingdom.getNumCastles());
        assertFalse(kingdom.containsCastle(castle1));
        assertTrue(kingdom.containsCastle(castle2));
        assertFalse(kingdom.containsCastle(castle3));
        assertTrue(kingdom.containsCastle(castle4));
        assertFalse(kingdom.containsCastle(castle5));
        assertNull(kingdom.getCastles()[0]);
        assertEquals(castle2, kingdom.getCastles()[1]);
        assertNull(kingdom.getCastles()[2]);
        assertEquals(castle4, kingdom.getCastles()[3]);
        assertNull(kingdom.getCastles()[4]);

        kingdom.removeCastle(castle2);
        assertEquals(1, kingdom.getNumCastles());
        assertFalse(kingdom.containsCastle(castle1));
        assertFalse(kingdom.containsCastle(castle2));
        assertFalse(kingdom.containsCastle(castle3));
        assertTrue(kingdom.containsCastle(castle4));
        assertFalse(kingdom.containsCastle(castle5));
        assertNull(kingdom.getCastles()[0]);
        assertNull(kingdom.getCastles()[1]);
        assertNull(kingdom.getCastles()[2]);
        assertEquals(castle4, kingdom.getCastles()[3]);
        assertNull(kingdom.getCastles()[4]);

        kingdom.removeCastle(castle4);
        assertEquals(0, kingdom.getNumCastles());
        assertFalse(kingdom.containsCastle(castle1));
        assertFalse(kingdom.containsCastle(castle2));
        assertFalse(kingdom.containsCastle(castle3));
        assertFalse(kingdom.containsCastle(castle4));
        assertFalse(kingdom.containsCastle(castle5));
        for (int i = 0; i < kingdom.getMaxCastles(); i++) {
            assertNull(kingdom.getCastles()[i]);
        }
    }

    @Test
    @Order(14)
    @Tag("advanced")
    @DisplayName("Advanced - Average area")
    public void testGetAverageArea() {
        Kingdom kingdom = new Kingdom("UOC Kingdom", "UOC", LocalDate.of(500, 1, 1), 50000.0, false, 5);
        Castle castle1 = new Castle("UOC Castle 1", LocalDate.of(600, 1, 1), 1000.0, "A dragon statue");
        Castle castle2 = new Castle("UOC Castle 2", LocalDate.of(700, 1, 1), 2000.0, "An ancient sword");
        Castle castle3 = new Castle("UOC Castle 3", LocalDate.of(800, 1, 1), 3000.0, "A royal crown");
        Castle castle4 = new Castle("UOC Castle 4", LocalDate.of(900, 1, 1), 4000.0, "A magical shield");
        Castle castle5 = new Castle("UOC Castle 5", LocalDate.of(1000, 1, 1), 5000.0, "A golden scepter");

        assertEquals(0.0, kingdom.getAverageArea(), 0.001);

        kingdom.addCastle(castle1);
        assertEquals(1000.0, kingdom.getAverageArea(), 0.001);

        kingdom.addCastle(castle2);
        assertEquals(1500.0, kingdom.getAverageArea(), 0.001);

        kingdom.addCastle(castle3);
        assertEquals(2000.0, kingdom.getAverageArea(), 0.001);

        kingdom.addCastle(castle4);
        assertEquals(2500.0, kingdom.getAverageArea(), 0.001);

        kingdom.addCastle(castle5);
        assertEquals(3000.0, kingdom.getAverageArea(), 0.001);

        kingdom.removeCastle(castle2);
        assertEquals(3250.0, kingdom.getAverageArea(), 0.001);

        kingdom.removeCastle(castle4);
        assertEquals(3000.0, kingdom.getAverageArea(), 0.001);

        kingdom.removeCastle(castle1);
        assertEquals(4000.0, kingdom.getAverageArea(), 0.001);

        kingdom.removeCastle(castle3);
        assertEquals(5000.0, kingdom.getAverageArea(), 0.001);

        kingdom.removeCastle(castle5);
        assertEquals(0.0, kingdom.getAverageArea(), 0.001);
    }

}
