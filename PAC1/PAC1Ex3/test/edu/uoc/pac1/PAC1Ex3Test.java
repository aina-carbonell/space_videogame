package edu.uoc.pac1;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PAC1Ex3Test {

    @Test
    @Order(1)
    @DisplayName("getBaseDropProbability")
    public void testGetBaseDropProbability() {
        assertEquals(0.10, PAC1Ex3.getBaseDropProbability(0, 0), 0.001);
        assertEquals(0.05, PAC1Ex3.getBaseDropProbability(0, 9), 0.001);
        assertEquals(0.09, PAC1Ex3.getBaseDropProbability(9, 0), 0.001);
        assertEquals(0.05, PAC1Ex3.getBaseDropProbability(9, 9), 0.001);

        assertEquals(0.70, PAC1Ex3.getBaseDropProbability(4, 3), 0.001);
        assertEquals(0.75, PAC1Ex3.getBaseDropProbability(5, 4), 0.001);

        assertEquals(0.15, PAC1Ex3.getBaseDropProbability(0, 1), 0.001);
        assertEquals(0.25, PAC1Ex3.getBaseDropProbability(0, 5), 0.001);
        assertEquals(0.14, PAC1Ex3.getBaseDropProbability(9, 1), 0.001);
        assertEquals(0.25, PAC1Ex3.getBaseDropProbability(9, 5), 0.001);
        assertEquals(0.24, PAC1Ex3.getBaseDropProbability(5, 0), 0.001);
        assertEquals(0.15, PAC1Ex3.getBaseDropProbability(5, 9), 0.001);

        assertEquals(0.38, PAC1Ex3.getBaseDropProbability(2, 2), 0.001);
        assertEquals(0.45, PAC1Ex3.getBaseDropProbability(2, 3), 0.001);
        assertEquals(0.50, PAC1Ex3.getBaseDropProbability(7, 3), 0.001);
        assertEquals(0.30, PAC1Ex3.getBaseDropProbability(9, 3), 0.001);
    }

    @Test
    @Order(2)
    @DisplayName("isValidCoordinate")
    public void testIsValidCoordinate() {
        int maxX = PAC1Ex3.MAX_COLUMNS * PAC1Ex3.CHUNK_SIZE;
        int maxY = PAC1Ex3.MAX_ROWS * PAC1Ex3.CHUNK_SIZE;

        assertTrue(PAC1Ex3.isValidCoordinate(0, 0));
        assertTrue(PAC1Ex3.isValidCoordinate(maxX - 1, maxY - 1));

        assertTrue(PAC1Ex3.isValidCoordinate(maxX - 1, 0));
        assertTrue(PAC1Ex3.isValidCoordinate(0, maxY - 1));

        assertTrue(PAC1Ex3.isValidCoordinate(maxX / 2, maxY / 2));

        assertFalse(PAC1Ex3.isValidCoordinate(-1, 0));
        assertFalse(PAC1Ex3.isValidCoordinate(0, -1));
        assertFalse(PAC1Ex3.isValidCoordinate(maxX, 0));
        assertFalse(PAC1Ex3.isValidCoordinate(0, maxY));
        assertFalse(PAC1Ex3.isValidCoordinate(-5, -5));
        assertFalse(PAC1Ex3.isValidCoordinate(maxX, maxY));
    }

    @Test
    @Order(3)
    @DisplayName("getChunk")
    public void testGetChunk() {
        assertArrayEquals(new int[]{0, 0}, PAC1Ex3.getChunk(0, 0));
        assertArrayEquals(new int[]{0, 1}, PAC1Ex3.getChunk(PAC1Ex3.CHUNK_SIZE, 0));
        assertArrayEquals(new int[]{1, 0}, PAC1Ex3.getChunk(0, PAC1Ex3.CHUNK_SIZE));
        assertArrayEquals(new int[]{1, 1}, PAC1Ex3.getChunk(PAC1Ex3.CHUNK_SIZE, PAC1Ex3.CHUNK_SIZE));
        assertArrayEquals(new int[]{0, 9}, PAC1Ex3.getChunk(PAC1Ex3.MAX_COLUMNS * PAC1Ex3.CHUNK_SIZE - 1, 0));
        assertArrayEquals(new int[]{9, 0}, PAC1Ex3.getChunk(0, PAC1Ex3.MAX_ROWS * PAC1Ex3.CHUNK_SIZE - 1));
        assertArrayEquals(new int[]{5, 4}, PAC1Ex3.getChunk(4 * PAC1Ex3.CHUNK_SIZE, 5 * PAC1Ex3.CHUNK_SIZE));
        assertArrayEquals(new int[]{9, 9}, PAC1Ex3.getChunk(PAC1Ex3.MAX_COLUMNS * PAC1Ex3.CHUNK_SIZE - 1,
                PAC1Ex3.MAX_ROWS * PAC1Ex3.CHUNK_SIZE - 1));
    }

    @Test
    @Order(4)
    @DisplayName("calculateLevelAdjustment")
    public void testCalculateLevelAdjustment() {
        assertEquals(1.0, PAC1Ex3.calculateLevelAdjustment(30, 15), 0.0);
        assertEquals(1.0, PAC1Ex3.calculateLevelAdjustment(45, 15), 0.0);

        assertEquals(0.0, PAC1Ex3.calculateLevelAdjustment(15, 30), 0.0);
        assertEquals(0.0, PAC1Ex3.calculateLevelAdjustment(15, 45), 0.0);

        assertEquals(0.5, PAC1Ex3.calculateLevelAdjustment(15, 15), 0.01);
        assertEquals(0.5, PAC1Ex3.calculateLevelAdjustment(75, 75), 0.01);

        assertEquals(0.9, PAC1Ex3.calculateLevelAdjustment(27, 15), 0.001);
        assertEquals(0.6, PAC1Ex3.calculateLevelAdjustment(18, 15), 0.001);
        assertEquals(0.67, PAC1Ex3.calculateLevelAdjustment(20, 15), 0.01);
        assertEquals(0.33, PAC1Ex3.calculateLevelAdjustment(10, 15), 0.01);
        assertEquals(0.33, PAC1Ex3.calculateLevelAdjustment(15, 20), 0.01);
        assertEquals(0.03, PAC1Ex3.calculateLevelAdjustment(15, 29), 0.01);
    }

    @Test
    @Order(5)
    @DisplayName("calculateDropProbability")
    public void testCalculateDropProbability() {
        assertEquals(0.0, PAC1Ex3.calculateDropProbability(-1, -1, 15, 15), 0.01);

        assertEquals(0.0, PAC1Ex3.calculateDropProbability(PAC1Ex3.MAX_COLUMNS * PAC1Ex3.CHUNK_SIZE,
                PAC1Ex3.MAX_ROWS * PAC1Ex3.CHUNK_SIZE, 15, 15), 0.01);

        assertEquals(0.05, PAC1Ex3.calculateDropProbability(0, 0, 15, 15), 0.01);
        assertEquals(0.055, PAC1Ex3.calculateDropProbability(9 * PAC1Ex3.CHUNK_SIZE - 1,
                9 * PAC1Ex3.CHUNK_SIZE - 1, 15, 15), 0.001);
        assertEquals(0.265, PAC1Ex3.calculateDropProbability(4 * PAC1Ex3.CHUNK_SIZE,
                3 * PAC1Ex3.CHUNK_SIZE, 15, 15), 0.001);
        assertEquals(0.325, PAC1Ex3.calculateDropProbability(5 * PAC1Ex3.CHUNK_SIZE,
                4 * PAC1Ex3.CHUNK_SIZE, 15, 15), 0.001);

        assertEquals(0.09, PAC1Ex3.calculateDropProbability(0, 0, 27, 15), 0.01);
        assertEquals(0.099, PAC1Ex3.calculateDropProbability(9 * PAC1Ex3.CHUNK_SIZE - 1,
                9 * PAC1Ex3.CHUNK_SIZE - 1, 27, 15), 0.001);

        assertEquals(0.318, PAC1Ex3.calculateDropProbability(4 * PAC1Ex3.CHUNK_SIZE,
                3 * PAC1Ex3.CHUNK_SIZE, 18, 15), 0.001);
        assertEquals(0.39, PAC1Ex3.calculateDropProbability(5 * PAC1Ex3.CHUNK_SIZE,
                4 * PAC1Ex3.CHUNK_SIZE, 18, 15), 0.01);
        assertEquals(0.067, PAC1Ex3.calculateDropProbability(0, 0, 20, 15), 0.001);
        assertEquals(0.073, PAC1Ex3.calculateDropProbability(9 * PAC1Ex3.CHUNK_SIZE - 1,
                9 * PAC1Ex3.CHUNK_SIZE - 1, 20, 15), 0.001);
        assertEquals(0.177, PAC1Ex3.calculateDropProbability(4 * PAC1Ex3.CHUNK_SIZE,
                3 * PAC1Ex3.CHUNK_SIZE, 10, 15), 0.001);
        assertEquals(0.217, PAC1Ex3.calculateDropProbability(5 * PAC1Ex3.CHUNK_SIZE,
                4 * PAC1Ex3.CHUNK_SIZE, 10, 15), 0.001);
    }

}
