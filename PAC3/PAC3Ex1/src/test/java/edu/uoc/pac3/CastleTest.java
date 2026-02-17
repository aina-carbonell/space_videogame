package edu.uoc.pac3;

import org.junit.jupiter.api.*;

import java.lang.reflect.Modifier;
import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CastleTest {

    @Test
    @Order(1)
    @Tag("sanity")
    @DisplayName("Sanity - Fields definition")
    public void checkFieldsSanity() {
        assertEquals(14, Castle.class.getDeclaredFields().length);

        try {
            assertTrue(Modifier.isPrivate(Castle.class.getDeclaredField("MIN_NAME_LENGTH").getModifiers()));
            assertTrue(Modifier.isStatic(Castle.class.getDeclaredField("MIN_NAME_LENGTH").getModifiers()));
            assertTrue(Modifier.isFinal(Castle.class.getDeclaredField("MIN_NAME_LENGTH").getModifiers()));
            assertEquals(int.class, Castle.class.getDeclaredField("MIN_NAME_LENGTH").getType());

            assertTrue(Modifier.isPrivate(Castle.class.getDeclaredField("MIN_AREA").getModifiers()));
            assertTrue(Modifier.isStatic(Castle.class.getDeclaredField("MIN_AREA").getModifiers()));
            assertTrue(Modifier.isFinal(Castle.class.getDeclaredField("MIN_AREA").getModifiers()));
            assertEquals(double.class, Castle.class.getDeclaredField("MIN_AREA").getType());

            assertTrue(Modifier.isPrivate(Castle.class.getDeclaredField("MIDDLE_AGES_START").getModifiers()));
            assertTrue(Modifier.isStatic(Castle.class.getDeclaredField("MIDDLE_AGES_START").getModifiers()));
            assertTrue(Modifier.isFinal(Castle.class.getDeclaredField("MIDDLE_AGES_START").getModifiers()));
            assertEquals(LocalDate.class, Castle.class.getDeclaredField("MIDDLE_AGES_START").getType());

            assertTrue(Modifier.isPrivate(Castle.class.getDeclaredField("MIDDLE_AGES_END").getModifiers()));
            assertTrue(Modifier.isStatic(Castle.class.getDeclaredField("MIDDLE_AGES_END").getModifiers()));
            assertTrue(Modifier.isFinal(Castle.class.getDeclaredField("MIDDLE_AGES_END").getModifiers()));
            assertEquals(LocalDate.class, Castle.class.getDeclaredField("MIDDLE_AGES_END").getType());

            assertTrue(Modifier.isPrivate(Castle.class.getDeclaredField("MIN_SYMBOLIC_ARTIFACT_LENGTH").getModifiers()));
            assertTrue(Modifier.isStatic(Castle.class.getDeclaredField("MIN_SYMBOLIC_ARTIFACT_LENGTH").getModifiers()));
            assertTrue(Modifier.isFinal(Castle.class.getDeclaredField("MIN_SYMBOLIC_ARTIFACT_LENGTH").getModifiers()));
            assertEquals(int.class, Castle.class.getDeclaredField("MIN_SYMBOLIC_ARTIFACT_LENGTH").getType());

            assertTrue(Modifier.isPublic(Castle.class.getDeclaredField("INVALID_NAME").getModifiers()));
            assertTrue(Modifier.isStatic(Castle.class.getDeclaredField("INVALID_NAME").getModifiers()));
            assertTrue(Modifier.isFinal(Castle.class.getDeclaredField("INVALID_NAME").getModifiers()));
            assertEquals(String.class, Castle.class.getDeclaredField("INVALID_NAME").getType());
            assertEquals("[ERROR] Castle name must have at least 3 characters", Castle.INVALID_NAME);

            assertTrue(Modifier.isPublic(Castle.class.getDeclaredField("INVALID_NAME").getModifiers()));
            assertTrue(Modifier.isStatic(Castle.class.getDeclaredField("INVALID_NAME").getModifiers()));
            assertTrue(Modifier.isFinal(Castle.class.getDeclaredField("INVALID_NAME").getModifiers()));
            assertEquals(String.class, Castle.class.getDeclaredField("INVALID_NAME").getType());
            assertEquals("[ERROR] Construction date cannot be null and must be between 0500-01-01 and 1499-12-31", Castle.INVALID_CONSTRUCTION_DATE);

            assertTrue(Modifier.isPublic(Castle.class.getDeclaredField("INVALID_AREA").getModifiers()));
            assertTrue(Modifier.isStatic(Castle.class.getDeclaredField("INVALID_AREA").getModifiers()));
            assertTrue(Modifier.isFinal(Castle.class.getDeclaredField("INVALID_AREA").getModifiers()));
            assertEquals(String.class, Castle.class.getDeclaredField("INVALID_AREA").getType());
            assertEquals("[ERROR] Area must be at least 100.0 square meters", Castle.INVALID_AREA);

            assertTrue(Modifier.isPublic(Castle.class.getDeclaredField("INVALID_SYMBOLIC_ARTIFACT").getModifiers()));
            assertTrue(Modifier.isStatic(Castle.class.getDeclaredField("INVALID_SYMBOLIC_ARTIFACT").getModifiers()));
            assertTrue(Modifier.isFinal(Castle.class.getDeclaredField("INVALID_SYMBOLIC_ARTIFACT").getModifiers()));
            assertEquals(String.class, Castle.class.getDeclaredField("INVALID_SYMBOLIC_ARTIFACT").getType());
            assertEquals("[ERROR] Symbolic artifact cannot be null, formed by only whitespace and must have at least 2 characters", Castle.INVALID_SYMBOLIC_ARTIFACT);

            assertTrue(Modifier.isPrivate(Castle.class.getDeclaredField("name").getModifiers()));
            assertFalse(Modifier.isStatic(Castle.class.getDeclaredField("name").getModifiers()));
            assertFalse(Modifier.isFinal(Castle.class.getDeclaredField("name").getModifiers()));
            assertEquals(String.class, Castle.class.getDeclaredField("name").getType());

            assertTrue(Modifier.isPrivate(Castle.class.getDeclaredField("constructionDate").getModifiers()));
            assertFalse(Modifier.isStatic(Castle.class.getDeclaredField("constructionDate").getModifiers()));
            assertFalse(Modifier.isFinal(Castle.class.getDeclaredField("constructionDate").getModifiers()));
            assertEquals(LocalDate.class, Castle.class.getDeclaredField("constructionDate").getType());

            assertTrue(Modifier.isPrivate(Castle.class.getDeclaredField("area").getModifiers()));
            assertFalse(Modifier.isStatic(Castle.class.getDeclaredField("area").getModifiers()));
            assertFalse(Modifier.isFinal(Castle.class.getDeclaredField("area").getModifiers()));
            assertEquals(double.class, Castle.class.getDeclaredField("area").getType());

            assertTrue(Modifier.isPrivate(Castle.class.getDeclaredField("symbolicArtifact").getModifiers()));
            assertFalse(Modifier.isStatic(Castle.class.getDeclaredField("symbolicArtifact").getModifiers()));
            assertFalse(Modifier.isFinal(Castle.class.getDeclaredField("symbolicArtifact").getModifiers()));
            assertEquals(String.class, Castle.class.getDeclaredField("symbolicArtifact").getType());

            assertTrue(Modifier.isPrivate(Castle.class.getDeclaredField("keep").getModifiers()));
            assertFalse(Modifier.isStatic(Castle.class.getDeclaredField("keep").getModifiers()));
            assertFalse(Modifier.isFinal(Castle.class.getDeclaredField("keep").getModifiers()));
            assertEquals(Keep.class, Castle.class.getDeclaredField("keep").getType());
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the definition of the attributes: " + e.getMessage());
        }
    }

    @Test
    @Order(2)
    @Tag("sanity")
    @DisplayName("Sanity - Constructor definition")
    public void checkConstructorSanity() {
        assertEquals(2, Castle.class.getDeclaredConstructors().length);

        try {
            assertTrue(Modifier.isPublic(Castle.class.getDeclaredConstructor(String.class, LocalDate.class, double.class, String.class).getModifiers()));
            assertTrue(Modifier.isPublic(Castle.class.getDeclaredConstructor(String.class, LocalDate.class, double.class, String.class, String.class, int.class, double.class, int.class, boolean.class).getModifiers()));
        } catch (NoSuchMethodException e) {
            fail("There is some problem with the definition of constructors: " + e.getMessage());
        }
    }

    @Test
    @Order(3)
    @Tag("sanity")
    @DisplayName("Sanity - Methods definition")
    public void checkMethodsSanity() {
        assertEquals(5, Arrays.stream(Castle.class.getDeclaredMethods()).filter(m -> Modifier.isPublic(m.getModifiers())).toList().size());
        assertEquals(5, Arrays.stream(Castle.class.getDeclaredMethods()).filter(m -> Modifier.isPrivate(m.getModifiers())).toList().size());

        try {
            assertTrue(Modifier.isPrivate(Castle.class.getDeclaredMethod("setName", String.class).getModifiers()));
            assertFalse(Modifier.isStatic(Castle.class.getDeclaredMethod("setName", String.class).getModifiers()));
            assertFalse(Modifier.isFinal(Castle.class.getDeclaredMethod("setName", String.class).getModifiers()));
            assertEquals(void.class, Castle.class.getDeclaredMethod("setName", String.class).getReturnType());

            assertTrue(Modifier.isPublic(Castle.class.getDeclaredMethod("getName").getModifiers()));
            assertFalse(Modifier.isStatic(Castle.class.getDeclaredMethod("getName").getModifiers()));
            assertFalse(Modifier.isFinal(Castle.class.getDeclaredMethod("getName").getModifiers()));
            assertEquals(String.class, Castle.class.getDeclaredMethod("getName").getReturnType());

            assertTrue(Modifier.isPrivate(Castle.class.getDeclaredMethod("setConstructionDate", LocalDate.class).getModifiers()));
            assertFalse(Modifier.isStatic(Castle.class.getDeclaredMethod("setConstructionDate", LocalDate.class).getModifiers()));
            assertFalse(Modifier.isFinal(Castle.class.getDeclaredMethod("setConstructionDate", LocalDate.class).getModifiers()));
            assertEquals(void.class, Castle.class.getDeclaredMethod("setConstructionDate", LocalDate.class).getReturnType());

            assertTrue(Modifier.isPublic(Castle.class.getDeclaredMethod("getConstructionDate").getModifiers()));
            assertFalse(Modifier.isStatic(Castle.class.getDeclaredMethod("getConstructionDate").getModifiers()));
            assertFalse(Modifier.isFinal(Castle.class.getDeclaredMethod("getConstructionDate").getModifiers()));
            assertEquals(LocalDate.class, Castle.class.getDeclaredMethod("getConstructionDate").getReturnType());

            assertTrue(Modifier.isPrivate(Castle.class.getDeclaredMethod("setArea", double.class).getModifiers()));
            assertFalse(Modifier.isStatic(Castle.class.getDeclaredMethod("setArea", double.class).getModifiers()));
            assertFalse(Modifier.isFinal(Castle.class.getDeclaredMethod("setArea", double.class).getModifiers()));
            assertEquals(void.class, Castle.class.getDeclaredMethod("setArea", double.class).getReturnType());

            assertTrue(Modifier.isPublic(Castle.class.getDeclaredMethod("getArea").getModifiers()));
            assertFalse(Modifier.isStatic(Castle.class.getDeclaredMethod("getArea").getModifiers()));
            assertFalse(Modifier.isFinal(Castle.class.getDeclaredMethod("getArea").getModifiers()));
            assertEquals(double.class, Castle.class.getDeclaredMethod("getArea").getReturnType());

            assertTrue(Modifier.isPrivate(Castle.class.getDeclaredMethod("setSymbolicArtifact", String.class).getModifiers()));
            assertFalse(Modifier.isStatic(Castle.class.getDeclaredMethod("setSymbolicArtifact", String.class).getModifiers()));
            assertFalse(Modifier.isFinal(Castle.class.getDeclaredMethod("setSymbolicArtifact", String.class).getModifiers()));
            assertEquals(void.class, Castle.class.getDeclaredMethod("setSymbolicArtifact", String.class).getReturnType());

            assertTrue(Modifier.isPublic(Castle.class.getDeclaredMethod("getSymbolicArtifact").getModifiers()));
            assertFalse(Modifier.isStatic(Castle.class.getDeclaredMethod("getSymbolicArtifact").getModifiers()));
            assertFalse(Modifier.isFinal(Castle.class.getDeclaredMethod("getSymbolicArtifact").getModifiers()));
            assertEquals(String.class, Castle.class.getDeclaredMethod("getSymbolicArtifact").getReturnType());

            assertTrue(Modifier.isPrivate(Castle.class.getDeclaredMethod("setKeep", String.class, int.class, double.class, int.class, boolean.class).getModifiers()));
            assertFalse(Modifier.isStatic(Castle.class.getDeclaredMethod("setKeep", String.class, int.class, double.class, int.class, boolean.class).getModifiers()));
            assertFalse(Modifier.isFinal(Castle.class.getDeclaredMethod("setKeep", String.class, int.class, double.class, int.class, boolean.class).getModifiers()));
            assertEquals(void.class, Castle.class.getDeclaredMethod("setKeep", String.class, int.class, double.class, int.class, boolean.class).getReturnType());

            assertTrue(Modifier.isPublic(Castle.class.getDeclaredMethod("getKeep").getModifiers()));
            assertFalse(Modifier.isStatic(Castle.class.getDeclaredMethod("getKeep").getModifiers()));
            assertFalse(Modifier.isFinal(Castle.class.getDeclaredMethod("getKeep").getModifiers()));
            assertEquals(Keep.class, Castle.class.getDeclaredMethod("getKeep").getReturnType());
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the definition of getter or setter methods: " + e.getMessage());
        }
    }

    @Test
    @Order(4)
    @Tag("advanced")
    @DisplayName("Advanced - Valid parameters")
    public void testCreateCastleValidParameters() {
        Castle castle = new Castle("UOC Castle", LocalDate.of(1300, 5, 15), 5000.0, "A dragon statue");

        assertNotNull(castle);
        assertEquals("UOC Castle", castle.getName());
        assertEquals(LocalDate.of(1300, 5, 15), castle.getConstructionDate());
        assertEquals(5000.0, castle.getArea());
        assertEquals("A dragon statue", castle.getSymbolicArtifact());
        assertNull(castle.getKeep());

        castle = new Castle("UOC Super Castle", LocalDate.of(1400, 10, 20), 8000.0, "A phoenix emblem", "Lord UOC", 5, 30.0, 15, true);

        assertNotNull(castle);
        assertEquals("UOC Super Castle", castle.getName());
        assertEquals(LocalDate.of(1400, 10, 20), castle.getConstructionDate());
        assertEquals(8000.0, castle.getArea());
        assertEquals("A phoenix emblem", castle.getSymbolicArtifact());
        assertNotNull(castle.getKeep());
        assertEquals("Lord UOC", castle.getKeep().getLordName());
        assertEquals(5, castle.getKeep().getFloors());
        assertEquals(30.0, castle.getKeep().getHeight());
        assertEquals(15, castle.getKeep().getNumGuards());
        assertTrue(castle.getKeep().isHasDungeon());
    }

    @Test
    @Order(5)
    @Tag("advanced")
    @DisplayName("Advanced - Name")
    public void testCreateCastleName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {new Castle(null, LocalDate.of(1300, 5, 15), 5000.0, "A dragon statue");});
        assertEquals("[ERROR] Castle name must have at least 3 characters", exception.getMessage());

        assertThrows(IllegalArgumentException.class, () -> {new Castle("", LocalDate.of(1300, 5, 15), 5000.0, "A dragon statue");});
        assertThrows(IllegalArgumentException.class, () -> {new Castle("  ", LocalDate.of(1300, 5, 15), 5000.0, "A dragon statue");});
        assertThrows(IllegalArgumentException.class, () -> {new Castle("AB", LocalDate.of(1300, 5, 15), 5000.0, "A dragon statue");});
        assertThrows(IllegalArgumentException.class, () -> {new Castle(" A ", LocalDate.of(1300, 5, 15), 5000.0, "A dragon statue");});

        Castle castle = new Castle("UOC Castle", LocalDate.of(1300, 5, 15), 5000.0, "A dragon statue");
        assertEquals("UOC Castle", castle.getName());

        castle = new Castle("  UOC Castle  ", LocalDate.of(1300, 5, 15), 5000.0, "A dragon statue");
        assertEquals("UOC Castle", castle.getName());

        castle = new Castle("___UOC___", LocalDate.of(1300, 5, 15), 5000.0, "A dragon statue");
        assertEquals("___UOC___", castle.getName());
    }

    @Test
    @Order(6)
    @Tag("advanced")
    @DisplayName("Advanced - Construction date")
    public void testCreateCastleConstructionDate() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {new Castle("UOC Castle", null, 5000.0, "A dragon statue");});
        assertEquals("[ERROR] Construction date cannot be null and must be between 0500-01-01 and 1499-12-31", exception.getMessage());

        assertThrows(IllegalArgumentException.class, () -> {new Castle("UOC Castle", LocalDate.of(499, 12, 31), 5000.0, "A dragon statue");});
        assertThrows(IllegalArgumentException.class, () -> {new Castle("UOC Castle", LocalDate.of(1500, 1, 1), 5000.0, "A dragon statue");});

        Castle castle = new Castle("UOC Castle", LocalDate.of(500, 1, 1), 5000.0, "A dragon statue");
        assertEquals(LocalDate.of(500, 1, 1), castle.getConstructionDate());

        castle = new Castle("UOC Castle", LocalDate.of(1499, 12, 31), 5000.0, "A dragon statue");
        assertEquals(LocalDate.of(1499, 12, 31), castle.getConstructionDate());
    }

    @Test
    @Order(7)
    @Tag("advanced")
    @DisplayName("Advanced - Area")
    public void testCreateCastleArea() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {new Castle("UOC Castle", LocalDate.of(1300, 5, 15), -10.0, "A dragon statue");});
        assertEquals("[ERROR] Area must be at least 100.0 square meters", exception.getMessage());

        assertThrows(IllegalArgumentException.class, () -> {new Castle("UOC Castle", LocalDate.of(1300, 5, 15), 99.9, "A dragon statue");});

        Castle castle = new Castle("UOC Castle", LocalDate.of(1300, 5, 15), 100.0, "A dragon statue");
        assertEquals(100.0, castle.getArea());

        castle = new Castle("UOC Castle", LocalDate.of(1300, 5, 15), 5000.0, "A dragon statue");
        assertEquals(5000.0, castle.getArea());
    }

    @Test
    @Order(8)
    @Tag("advanced")
    @DisplayName("Advanced - Symbolic artifact")
    public void testCreateCastleSymbolicArtifact() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {new Castle("UOC Castle", LocalDate.of(1300, 5, 15), 5000.0, null);});
        assertEquals("[ERROR] Symbolic artifact cannot be null, formed by only whitespace and must have at least 2 characters", exception.getMessage());

        assertThrows(IllegalArgumentException.class, () -> {new Castle("UOC Castle", LocalDate.of(1300, 5, 15), 5000.0, "");});
        assertThrows(IllegalArgumentException.class, () -> {new Castle("UOC Castle", LocalDate.of(1300, 5, 15), 5000.0, "   ");});
        assertThrows(IllegalArgumentException.class, () -> {new Castle("UOC Castle", LocalDate.of(1300, 5, 15), 5000.0, "A");});
        assertThrows(IllegalArgumentException.class, () -> {new Castle("UOC Castle", LocalDate.of(1300, 5, 15), 5000.0, " B ");});

        Castle castle = new Castle("UOC Castle", LocalDate.of(1300, 5, 15), 5000.0, "A dragon statue");
        assertEquals("A dragon statue", castle.getSymbolicArtifact());

        castle = new Castle("UOC Castle", LocalDate.of(1300, 5, 15), 5000.0, "   a mystical sword   ");
        assertEquals("A mystical sword", castle.getSymbolicArtifact());

        castle = new Castle("UOC Castle", LocalDate.of(1300, 5, 15), 5000.0, "SHIELD OF HONOR");
        assertEquals("Shield of honor", castle.getSymbolicArtifact());

        castle = new Castle("UOC Castle", LocalDate.of(1300, 5, 15), 5000.0, "eMerALd AmULET");
        assertEquals("Emerald amulet", castle.getSymbolicArtifact());
    }

    @Test
    @Order(10)
    @Tag("special")
    @DisplayName("Special - Keep")
    public void testCreateCastleWithKeep() {
        Castle castle = new Castle("UOC Super Castle", LocalDate.of(1400, 10, 20), 8000.0, "A phoenix emblem");
        assertNotNull(castle);
        assertNull(castle.getKeep());

        castle = new Castle("UOC Super Castle", LocalDate.of(1400, 10, 20), 8000.0, "A phoenix emblem", null, 5, 30.0, 15, true);
        assertNotNull(castle);
        assertNull(castle.getKeep());

        castle = new Castle("UOC Super Castle", LocalDate.of(1400, 10, 20), 8000.0, "A phoenix emblem", "", 5, 30.0, 15, true);
        assertNotNull(castle);
        assertNull(castle.getKeep());

        castle = new Castle("UOC Super Castle", LocalDate.of(1400, 10, 20), 8000.0, "A phoenix emblem", "   ", 5, 30.0, 15, true);
        assertNotNull(castle);
        assertNull(castle.getKeep());

        castle = new Castle("UOC Super Castle", LocalDate.of(1400, 10, 20), 8000.0, "A phoenix emblem", "Lord UOC", 0, 30.0, 15, true);
        assertNotNull(castle);
        assertNull(castle.getKeep());

        castle = new Castle("UOC Super Castle", LocalDate.of(1400, 10, 20), 8000.0, "A phoenix emblem", "Lord UOC", 5, -1.0, 15, true);
        assertNotNull(castle);
        assertNull(castle.getKeep());

        castle = new Castle("UOC Super Castle", LocalDate.of(1400, 10, 20), 8000.0, "A phoenix emblem", "Lord UOC", 5, 14.9, 15, true);
        assertNotNull(castle);
        assertNull(castle.getKeep());

        castle = new Castle("UOC Super Castle", LocalDate.of(1400, 10, 20), 8000.0, "A phoenix emblem", "Lord UOC", 5, 30.0, -1, true);
        assertNotNull(castle);
        assertNotNull(castle.getKeep());
        assertEquals("Lord UOC", castle.getKeep().getLordName());
        assertEquals(5, castle.getKeep().getFloors());
        assertEquals(30.0, castle.getKeep().getHeight());
        assertEquals(0, castle.getKeep().getNumGuards());
        assertTrue(castle.getKeep().isHasDungeon());

        castle = new Castle("UOC Super Castle", LocalDate.of(1400, 10, 20), 8000.0, "A phoenix emblem", "Lord UOC", 5, 30.0, 15, true);
        assertNotNull(castle);
        assertNotNull(castle.getKeep());
        assertEquals("Lord UOC", castle.getKeep().getLordName());
        assertEquals(5, castle.getKeep().getFloors());
        assertEquals(30.0, castle.getKeep().getHeight());
        assertEquals(15, castle.getKeep().getNumGuards());
        assertTrue(castle.getKeep().isHasDungeon());

        castle = new Castle("UOC Super Castle", LocalDate.of(1400, 10, 20), 8000.0, "A phoenix emblem", "   Lady UOC   ", 3, 20.0, 10, false);
        assertNotNull(castle);
        assertNotNull(castle.getKeep());
        assertEquals("Lady UOC", castle.getKeep().getLordName());
        assertEquals(3, castle.getKeep().getFloors());
        assertEquals(20.0, castle.getKeep().getHeight());
        assertEquals(10, castle.getKeep().getNumGuards());
        assertFalse(castle.getKeep().isHasDungeon());
    }

}
