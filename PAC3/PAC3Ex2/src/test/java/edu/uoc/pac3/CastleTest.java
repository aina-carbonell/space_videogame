package edu.uoc.pac3;

import org.junit.jupiter.api.*;

import java.lang.reflect.Modifier;
import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CastleTest {

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
        assertEquals(16, Castle.class.getDeclaredFields().length);

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

            assertTrue(Modifier.isPrivate(Castle.class.getDeclaredField("id").getModifiers()));
            assertFalse(Modifier.isStatic(Castle.class.getDeclaredField("id").getModifiers()));
            assertFalse(Modifier.isFinal(Castle.class.getDeclaredField("id").getModifiers()));
            assertEquals(int.class, Castle.class.getDeclaredField("id").getType());

            assertTrue(Modifier.isPrivate(Castle.class.getDeclaredField("nextId").getModifiers()));
            assertTrue(Modifier.isStatic(Castle.class.getDeclaredField("nextId").getModifiers()));
            assertFalse(Modifier.isFinal(Castle.class.getDeclaredField("nextId").getModifiers()));
            assertEquals(int.class, Castle.class.getDeclaredField("nextId").getType());

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
        assertEquals(7, Arrays.stream(Castle.class.getDeclaredMethods()).filter(m -> Modifier.isPublic(m.getModifiers())).toList().size());
        assertEquals(7, Arrays.stream(Castle.class.getDeclaredMethods()).filter(m -> Modifier.isPrivate(m.getModifiers())).toList().size());

        try {
            assertTrue(Modifier.isPrivate(Castle.class.getDeclaredMethod("setId").getModifiers()));
            assertFalse(Modifier.isStatic(Castle.class.getDeclaredMethod("setId").getModifiers()));
            assertFalse(Modifier.isFinal(Castle.class.getDeclaredMethod("setId").getModifiers()));
            assertEquals(void.class, Castle.class.getDeclaredMethod("setId").getReturnType());

            assertTrue(Modifier.isPublic(Castle.class.getDeclaredMethod("getId").getModifiers()));
            assertFalse(Modifier.isStatic(Castle.class.getDeclaredMethod("getId").getModifiers()));
            assertFalse(Modifier.isFinal(Castle.class.getDeclaredMethod("getId").getModifiers()));
            assertEquals(int.class, Castle.class.getDeclaredMethod("getId").getReturnType());

            assertTrue(Modifier.isPublic(Castle.class.getDeclaredMethod("getNextId").getModifiers()));
            assertTrue(Modifier.isStatic(Castle.class.getDeclaredMethod("getNextId").getModifiers()));
            assertFalse(Modifier.isFinal(Castle.class.getDeclaredMethod("getNextId").getModifiers()));
            assertEquals(int.class, Castle.class.getDeclaredMethod("getNextId").getReturnType());

            assertTrue(Modifier.isPrivate(Castle.class.getDeclaredMethod("incNextId").getModifiers()));
            assertTrue(Modifier.isStatic(Castle.class.getDeclaredMethod("incNextId").getModifiers()));
            assertFalse(Modifier.isFinal(Castle.class.getDeclaredMethod("incNextId").getModifiers()));
            assertEquals(void.class, Castle.class.getDeclaredMethod("incNextId").getReturnType());

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
    @Tag("minimum")
    @DisplayName("Minimum - Id")
    public void testCreateCastleId() {
        assertEquals(1, Castle.getNextId());
        Castle castle1 = new Castle("UOC Castle", LocalDate.of(1300, 5, 15), 5000.0, "A dragon statue");
        assertEquals(2, Castle.getNextId());

        Castle castle2 = new Castle("Medieval Fortress", LocalDate.of(1200, 8, 20), 3000.0, "An ancient sword");
        assertEquals(3, Castle.getNextId());

        assertThrows(IllegalArgumentException.class, () -> {Castle castleInvalid = new Castle("ABA", LocalDate.of(1100, 1, 1), 2000.0, "");});
        assertEquals(3, Castle.getNextId());

        Castle castle3 = new Castle("Knight's Keep", LocalDate.of(1400, 3, 10), 4000.0, "A royal crown");
        assertEquals(4, Castle.getNextId());

        assertEquals(1, castle1.getId());
        assertEquals(2, castle2.getId());
        assertEquals(3, castle3.getId());
    }

}
