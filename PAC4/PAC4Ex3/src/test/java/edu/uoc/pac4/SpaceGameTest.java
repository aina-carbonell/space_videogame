package edu.uoc.pac4;

import edu.uoc.pac4.ship.*;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SpaceGameTest {

    @Test
    @Order(1)
    @DisplayName("getSpaceshipsByRolType")
    public void testGetSpaceshipsByRolType() {
        try {
            SpaceGame spaceGame = new SpaceGame("Milky Way");
            SpaceShip ship1 = new Cargo("SS-001", 100.4, SpaceShipRolType.BATTLE, true);
            SpaceShip ship2 = new Cargo("SS-002", 200.8, SpaceShipRolType.SCIENCE, false);
            SpaceShip ship3 = new Cargo("SS-003", 1500.0, SpaceShipRolType.BATTLE, true);
            SpaceShip ship4 = new Cruiser("SS-004", 2500, SpaceShipRolType.BATTLE, 10);
            SpaceShip ship5 = new Cruiser("SS-005", 3000, SpaceShipRolType.DIPLOMATIC, 50);
            SpaceShip ship6 = new Cruiser("SS-006", 1200, SpaceShipRolType.SCIENCE, 20);
            SpaceShip ship7 = new DeathStar("SS-007", SpaceShipRolType.DIPLOMATIC, 15.0);
            spaceGame.addSpaceShip(ship1);
            spaceGame.addSpaceShip(ship2);
            spaceGame.addSpaceShip(ship3);
            spaceGame.addSpaceShip(ship4);
            spaceGame.addSpaceShip(ship5);
            spaceGame.addSpaceShip(ship6);
            spaceGame.addSpaceShip(ship7);

            List<SpaceShip> spaceShips = spaceGame.getSpaceshipsByRolType(SpaceShipRolType.BATTLE);
            assertEquals(3, spaceShips.size(), "There should be 3 BATTLE spaceships");
            assertTrue(spaceShips.contains(ship1), "List should contain ship1");
            assertTrue(spaceShips.contains(ship3), "List should contain ship3");
            assertTrue(spaceShips.contains(ship4), "List should contain ship4");

            spaceShips = spaceGame.getSpaceshipsByRolType(SpaceShipRolType.SCIENCE);
            assertEquals(2, spaceShips.size(), "There should be 2 SCIENCE spaceships");
            assertTrue(spaceShips.contains(ship2), "List should contain ship2");
            assertTrue(spaceShips.contains(ship6), "List should contain ship6");

            spaceShips = spaceGame.getSpaceshipsByRolType(SpaceShipRolType.DIPLOMATIC);
            assertEquals(2, spaceShips.size(), "There should be 2 DIPLOMATIC spaceships");
            assertTrue(spaceShips.contains(ship5), "List should contain ship5");
            assertTrue(spaceShips.contains(ship7), "List should contain ship7");

            spaceGame.removeSpaceShip(ship4);
            spaceShips = spaceGame.getSpaceshipsByRolType(SpaceShipRolType.BATTLE);
            assertEquals(2, spaceShips.size(), "There should be 2 BATTLE spaceships after removing ship4");
            assertTrue(spaceShips.contains(ship1), "List should contain ship1");
            assertTrue(spaceShips.contains(ship3), "List should contain ship3");

            spaceGame.removeSpaceShip(ship1);
            spaceGame.removeSpaceShip(ship3);
            spaceShips = spaceGame.getSpaceshipsByRolType(SpaceShipRolType.BATTLE);
            assertEquals(0, spaceShips.size(), "There should be 0 BATTLE spaceships after removing ship1 and ship3");
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }
    }

    @Test
    @Order(2)
    @DisplayName("getTotalCargoCapacity")
    public void testGetTotalCargoCapacity() {
        try {
            SpaceGame spaceGame = new SpaceGame("Milky Way");

            double totalCargoCapacity = spaceGame.getTotalCargoCapacity();
            assertEquals(0.0, totalCargoCapacity, 0.001, "Total cargo capacity should be 0.0 for empty space game");

            SpaceShip ship1 = new Cargo("SS-001", 100.4, SpaceShipRolType.BATTLE, true);
            SpaceShip ship2 = new Cargo("SS-002", 200.8, SpaceShipRolType.SCIENCE, false);
            SpaceShip ship3 = new Cargo("SS-003", 1500.0, SpaceShipRolType.BATTLE, true);
            SpaceShip ship4 = new Cruiser("SS-004", 2500, SpaceShipRolType.BATTLE, 10);
            SpaceShip ship5 = new Cruiser("SS-005", 3000, SpaceShipRolType.DIPLOMATIC, 50);
            SpaceShip ship6 = new Cruiser("SS-006", 1200, SpaceShipRolType.SCIENCE, 20);
            SpaceShip ship7 = new DeathStar("SS-007", SpaceShipRolType.DIPLOMATIC, 15.0);
            spaceGame.addSpaceShip(ship1);
            spaceGame.addSpaceShip(ship2);
            spaceGame.addSpaceShip(ship3);
            spaceGame.addSpaceShip(ship4);
            spaceGame.addSpaceShip(ship5);
            spaceGame.addSpaceShip(ship6);
            spaceGame.addSpaceShip(ship7);

            totalCargoCapacity = spaceGame.getTotalCargoCapacity();
            assertEquals(30801.2, totalCargoCapacity, 0.001, "Total cargo capacity should be 30801.2");

            spaceGame.removeSpaceShip(ship1);
            totalCargoCapacity = spaceGame.getTotalCargoCapacity();
            assertEquals(30700.8, totalCargoCapacity, 0.001, "Total cargo capacity should be 30700.8 after removing ship1");
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }
    }

}
