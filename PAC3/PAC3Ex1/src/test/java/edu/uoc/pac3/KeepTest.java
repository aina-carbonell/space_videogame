package edu.uoc.pac3;

import org.junit.jupiter.api.*;

import java.lang.reflect.Modifier;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class KeepTest {

    @Test
    @Order(1)
    @Tag("sanity")
    @DisplayName("Sanity - Fields definition")
    public void checkFieldsSanity() {
        assertEquals(9, Keep.class.getDeclaredFields().length);

        try {
            assertTrue(Modifier.isPrivate(Keep.class.getDeclaredField("MIN_HEIGHT").getModifiers()));
            assertTrue(Modifier.isStatic(Keep.class.getDeclaredField("MIN_HEIGHT").getModifiers()));
            assertTrue(Modifier.isFinal(Keep.class.getDeclaredField("MIN_HEIGHT").getModifiers()));
            assertEquals(double.class, Keep.class.getDeclaredField("MIN_HEIGHT").getType());

            assertTrue(Modifier.isPublic(Keep.class.getDeclaredField("INVALID_LORD_NAME").getModifiers()));
            assertTrue(Modifier.isStatic(Keep.class.getDeclaredField("INVALID_LORD_NAME").getModifiers()));
            assertTrue(Modifier.isFinal(Keep.class.getDeclaredField("INVALID_LORD_NAME").getModifiers()));
            assertEquals(String.class, Keep.class.getDeclaredField("INVALID_LORD_NAME").getType());
            assertEquals("[ERROR] Lord name cannot be null, empty or formed by only whitespace", Keep.INVALID_LORD_NAME);

            assertTrue(Modifier.isPublic(Keep.class.getDeclaredField("INVALID_FLOORS").getModifiers()));
            assertTrue(Modifier.isStatic(Keep.class.getDeclaredField("INVALID_FLOORS").getModifiers()));
            assertTrue(Modifier.isFinal(Keep.class.getDeclaredField("INVALID_FLOORS").getModifiers()));
            assertEquals(String.class, Keep.class.getDeclaredField("INVALID_FLOORS").getType());
            assertEquals("[ERROR] Keep must have at least one floor", Keep.INVALID_FLOORS);

            assertTrue(Modifier.isPublic(Keep.class.getDeclaredField("INVALID_HEIGHT").getModifiers()));
            assertTrue(Modifier.isStatic(Keep.class.getDeclaredField("INVALID_HEIGHT").getModifiers()));
            assertTrue(Modifier.isFinal(Keep.class.getDeclaredField("INVALID_HEIGHT").getModifiers()));
            assertEquals(String.class, Keep.class.getDeclaredField("INVALID_HEIGHT").getType());
            assertEquals("[ERROR] Height must be at least 15.0 meters", Keep.INVALID_HEIGHT);

            assertTrue(Modifier.isPrivate(Keep.class.getDeclaredField("lordName").getModifiers()));
            assertFalse(Modifier.isStatic(Keep.class.getDeclaredField("lordName").getModifiers()));
            assertFalse(Modifier.isFinal(Keep.class.getDeclaredField("lordName").getModifiers()));
            assertEquals(String.class, Keep.class.getDeclaredField("lordName").getType());

            assertTrue(Modifier.isPrivate(Keep.class.getDeclaredField("floors").getModifiers()));
            assertFalse(Modifier.isStatic(Keep.class.getDeclaredField("floors").getModifiers()));
            assertFalse(Modifier.isFinal(Keep.class.getDeclaredField("floors").getModifiers()));
            assertEquals(int.class, Keep.class.getDeclaredField("floors").getType());

            assertTrue(Modifier.isPrivate(Keep.class.getDeclaredField("height").getModifiers()));
            assertFalse(Modifier.isStatic(Keep.class.getDeclaredField("height").getModifiers()));
            assertFalse(Modifier.isFinal(Keep.class.getDeclaredField("height").getModifiers()));
            assertEquals(double.class, Keep.class.getDeclaredField("height").getType());

            assertTrue(Modifier.isPrivate(Keep.class.getDeclaredField("numGuards").getModifiers()));
            assertFalse(Modifier.isStatic(Keep.class.getDeclaredField("numGuards").getModifiers()));
            assertFalse(Modifier.isFinal(Keep.class.getDeclaredField("numGuards").getModifiers()));
            assertEquals(int.class, Keep.class.getDeclaredField("numGuards").getType());

            assertTrue(Modifier.isPrivate(Keep.class.getDeclaredField("hasDungeon").getModifiers()));
            assertFalse(Modifier.isStatic(Keep.class.getDeclaredField("hasDungeon").getModifiers()));
            assertFalse(Modifier.isFinal(Keep.class.getDeclaredField("hasDungeon").getModifiers()));
            assertEquals(boolean.class, Keep.class.getDeclaredField("hasDungeon").getType());
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the definition of the attributes: " + e.getMessage());
        }
    }

    @Test
    @Order(2)
    @Tag("sanity")
    @DisplayName("Sanity - Constructor definition")
    public void checkConstructorSanity() {
        assertEquals(1, Keep.class.getDeclaredConstructors().length);

        try {
            assertTrue(Modifier.isPublic(Keep.class.getDeclaredConstructor(String.class, int.class, double.class, int.class, boolean.class).getModifiers()));
        } catch (NoSuchMethodException e) {
            fail("There is some problem with the definition of constructors: " + e.getMessage());
        }
    }

    @Test
    @Order(3)
    @Tag("sanity")
    @DisplayName("Sanity - Methods definition")
    public void checkMethodsSanity() {
        assertEquals(5, Arrays.stream(Keep.class.getDeclaredMethods()).filter(m -> Modifier.isPublic(m.getModifiers())).toList().size());
        assertEquals(5, Arrays.stream(Keep.class.getDeclaredMethods()).filter(m -> Modifier.isPrivate(m.getModifiers())).toList().size());

        try {
            assertTrue(Modifier.isPrivate(Keep.class.getDeclaredMethod("setLordName", String.class).getModifiers()));
            assertFalse(Modifier.isStatic(Keep.class.getDeclaredMethod("setLordName", String.class).getModifiers()));
            assertFalse(Modifier.isFinal(Keep.class.getDeclaredMethod("setLordName", String.class).getModifiers()));
            assertEquals(void.class, Keep.class.getDeclaredMethod("setLordName", String.class).getReturnType());

            assertTrue(Modifier.isPublic(Keep.class.getDeclaredMethod("getLordName").getModifiers()));
            assertFalse(Modifier.isStatic(Keep.class.getDeclaredMethod("getLordName").getModifiers()));
            assertFalse(Modifier.isFinal(Keep.class.getDeclaredMethod("getLordName").getModifiers()));
            assertEquals(String.class, Keep.class.getDeclaredMethod("getLordName").getReturnType());

            assertTrue(Modifier.isPrivate(Keep.class.getDeclaredMethod("setFloors", int.class).getModifiers()));
            assertFalse(Modifier.isStatic(Keep.class.getDeclaredMethod("setFloors", int.class).getModifiers()));
            assertFalse(Modifier.isFinal(Keep.class.getDeclaredMethod("setFloors", int.class).getModifiers()));
            assertEquals(void.class, Keep.class.getDeclaredMethod("setFloors", int.class).getReturnType());

            assertTrue(Modifier.isPublic(Keep.class.getDeclaredMethod("getFloors").getModifiers()));
            assertFalse(Modifier.isStatic(Keep.class.getDeclaredMethod("getFloors").getModifiers()));
            assertFalse(Modifier.isFinal(Keep.class.getDeclaredMethod("getFloors").getModifiers()));
            assertEquals(int.class, Keep.class.getDeclaredMethod("getFloors").getReturnType());

            assertTrue(Modifier.isPrivate(Keep.class.getDeclaredMethod("setHeight", double.class).getModifiers()));
            assertFalse(Modifier.isStatic(Keep.class.getDeclaredMethod("setHeight", double.class).getModifiers()));
            assertFalse(Modifier.isFinal(Keep.class.getDeclaredMethod("setHeight", double.class).getModifiers()));
            assertEquals(void.class, Keep.class.getDeclaredMethod("setHeight", double.class).getReturnType());

            assertTrue(Modifier.isPublic(Keep.class.getDeclaredMethod("getHeight").getModifiers()));
            assertFalse(Modifier.isStatic(Keep.class.getDeclaredMethod("getHeight").getModifiers()));
            assertFalse(Modifier.isFinal(Keep.class.getDeclaredMethod("getHeight").getModifiers()));
            assertEquals(double.class, Keep.class.getDeclaredMethod("getHeight").getReturnType());

            assertTrue(Modifier.isPrivate(Keep.class.getDeclaredMethod("setNumGuards", int.class).getModifiers()));
            assertFalse(Modifier.isStatic(Keep.class.getDeclaredMethod("setNumGuards", int.class).getModifiers()));
            assertFalse(Modifier.isFinal(Keep.class.getDeclaredMethod("setNumGuards", int.class).getModifiers()));
            assertEquals(void.class, Keep.class.getDeclaredMethod("setNumGuards", int.class).getReturnType());

            assertTrue(Modifier.isPublic(Keep.class.getDeclaredMethod("getNumGuards").getModifiers()));
            assertFalse(Modifier.isStatic(Keep.class.getDeclaredMethod("getNumGuards").getModifiers()));
            assertFalse(Modifier.isFinal(Keep.class.getDeclaredMethod("getNumGuards").getModifiers()));
            assertEquals(int.class, Keep.class.getDeclaredMethod("getNumGuards").getReturnType());

            assertTrue(Modifier.isPrivate(Keep.class.getDeclaredMethod("setHasDungeon", boolean.class).getModifiers()));
            assertFalse(Modifier.isStatic(Keep.class.getDeclaredMethod("setHasDungeon", boolean.class).getModifiers()));
            assertFalse(Modifier.isFinal(Keep.class.getDeclaredMethod("setHasDungeon", boolean.class).getModifiers()));
            assertEquals(void.class, Keep.class.getDeclaredMethod("setHasDungeon", boolean.class).getReturnType());

            assertTrue(Modifier.isPublic(Keep.class.getDeclaredMethod("isHasDungeon").getModifiers()));
            assertFalse(Modifier.isStatic(Keep.class.getDeclaredMethod("isHasDungeon").getModifiers()));
            assertFalse(Modifier.isFinal(Keep.class.getDeclaredMethod("isHasDungeon").getModifiers()));
            assertEquals(boolean.class, Keep.class.getDeclaredMethod("isHasDungeon").getReturnType());
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the definition of getter or setter methods: " + e.getMessage());
        }
    }

    @Test
    @Order(4)
    @Tag("minimum")
    @DisplayName("Minimum - Valid parameters")
    public void testCreateKeepValidParameters() {
        Keep keep = new Keep("Lord A", 3, 15.5, 10, true);

        assertEquals("Lord A", keep.getLordName());
        assertEquals(3, keep.getFloors());
        assertEquals(15.5, keep.getHeight());
        assertEquals(10, keep.getNumGuards());
        assertTrue(keep.isHasDungeon());

        keep = new Keep("Lord B", 1, 15.0, 0, false);
        assertEquals("Lord B", keep.getLordName());
        assertEquals(1, keep.getFloors());
        assertEquals(15.0, keep.getHeight());
        assertEquals(0, keep.getNumGuards());
        assertFalse(keep.isHasDungeon());
    }

    @Test
    @Order(5)
    @Tag("minimum")
    @DisplayName("Minimum - Lord name")
    public void testCreateKeepLordName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Keep(null, 3, 15.5, 10, true));
        assertEquals("[ERROR] Lord name cannot be null, empty or formed by only whitespace", exception.getMessage());

        assertThrows(IllegalArgumentException.class, () -> new Keep("", 3, 15.5, 10, true));
        assertThrows(IllegalArgumentException.class, () -> new Keep("   ", 3, 15.5, 10, true));

        Keep keep = new Keep("Lord C", 3, 15.5, 10, true);
        assertNotNull(keep);
        assertEquals("Lord C", keep.getLordName());

        keep = new Keep("  Lord D  ", 3, 15.5, 10, true);
        assertNotNull(keep);
        assertEquals("Lord D", keep.getLordName());

        keep = new Keep("__Lord E__", 3, 15.5, 10, true);
        assertNotNull(keep);
        assertEquals("__Lord E__", keep.getLordName());
    }

    @Test
    @Order(6)
    @Tag("minimum")
    @DisplayName("Minimum - Floors")
    public void testCreateKeepFloors() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Keep("Lord A", 0, 15.5, 10, true));
        assertEquals("[ERROR] Keep must have at least one floor", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> new Keep("Lord A", -2, 15.5, 10, true));
        assertEquals("[ERROR] Keep must have at least one floor", exception.getMessage());

        Keep keep = new Keep("Lord B", 1, 15.5, 10, true);
        assertNotNull(keep);
        assertEquals(1, keep.getFloors());

        keep = new Keep("Lord C", 5, 15.5, 10, true);
        assertNotNull(keep);
        assertEquals(5, keep.getFloors());
    }

    @Test
    @Order(7)
    @Tag("minimum")
    @DisplayName("Minimum - Height")
    public void testCreateKeepHeight() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Keep("Lord A", 3, -1.0, 10, true));
        assertEquals("[ERROR] Height must be at least 15.0 meters", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> new Keep("Lord A", 3, -15.5, 10, true));
        assertEquals("[ERROR] Height must be at least 15.0 meters", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> new Keep("Lord A", 3, 14.9, 10, true));
        assertEquals("[ERROR] Height must be at least 15.0 meters", exception.getMessage());

        Keep keep = new Keep("Lord B", 3, 15.0, 10, true);
        assertNotNull(keep);
        assertEquals(15.0, keep.getHeight());

        keep = new Keep("Lord C", 3, 40.5, 10, true);
        assertNotNull(keep);
        assertEquals(40.5, keep.getHeight());
    }

    @Test
    @Order(8)
    @Tag("minimum")
    @DisplayName("Minimum - Number of guards")
    public void testCreateKeepNumGuards() {
        Keep keep = new Keep("Lord B", 3, 15.5, 0, true);
        assertNotNull(keep);
        assertEquals(0, keep.getNumGuards());

        keep = new Keep("Lord C", 3, 15.5, 20, true);
        assertNotNull(keep);
        assertEquals(20, keep.getNumGuards());

        keep = new Keep("Lord C", 3, 15.5, -1, true);
        assertNotNull(keep);
        assertEquals(0, keep.getNumGuards());
    }

    @Test
    @Order(9)
    @Tag("minimum")
    @DisplayName("Minimum - Has dungeon")
    public void testCreateKeepHasDungeon() {
        Keep keep = new Keep("Lord A", 3, 15.5, 10, true);
        assertNotNull(keep);
        assertTrue(keep.isHasDungeon());

        keep = new Keep("Lord B", 3, 15.5, 10, false);
        assertNotNull(keep);
        assertFalse(keep.isHasDungeon());
    }

}
