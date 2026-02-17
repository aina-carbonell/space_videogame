package edu.uoc.pac4;

import edu.uoc.pac4.SpaceGameException;
import edu.uoc.pac4.ship.SpaceShip;

import java.util.ArrayList;
import java.util.List;

public class SpaceGame {
    private static final int MAX_SPACESHIPS = 10;
    private String galaxyName;
    private List<SpaceShip> spaceships;

    public SpaceGame(String galaxyName) throws SpaceGameException {
        setGalaxyName(galaxyName);
        this.spaceships = new ArrayList<>(MAX_SPACESHIPS);
    }

    public String getGalaxyName() {
        return galaxyName;
    }

    public List<SpaceShip> getSpaceships() {
        return spaceships;
    }

    public int getMaxSpaceships() {
        return MAX_SPACESHIPS;
    }

    public void setGalaxyName(String galaxyName) throws SpaceGameException {
        if (galaxyName == null || galaxyName.trim().isEmpty()) {
            throw new SpaceGameException(SpaceGameException.INVALID_GALAXY_NAME);
        }
        this.galaxyName = galaxyName;
    }

    public boolean addSpaceShip(SpaceShip spaceShip) throws SpaceGameException {
        if (spaceShip == null) {
            throw new SpaceGameException(SpaceGameException.NULL_SPACESHIP);
        }
        if (spaceships.contains(spaceShip)) {
            throw new SpaceGameException(SpaceGameException.SPACESHIP_ALREADY_EXISTS);
        }
        if (spaceships.size() >= MAX_SPACESHIPS) {
            throw new SpaceGameException(SpaceGameException.MAX_SPACESHIPS_REACHED);
        }
        return spaceships.add(spaceShip);
    }

    public boolean removeSpaceShip(SpaceShip spaceShip) throws SpaceGameException {
        if (spaceShip == null) {
            throw new SpaceGameException(SpaceGameException.NULL_SPACESHIP);
        }
        if (!spaceships.contains(spaceShip)) {
            throw new SpaceGameException(SpaceGameException.SPACESHIP_NOT_FOUND);
        }
        return spaceships.remove(spaceShip);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        sb.append("    \"galaxyName\": \"").append(galaxyName).append("\",\n");
        sb.append("    \"spaceships\": [\n");

        for (int i = 0; i < spaceships.size(); i++) {
            sb.append(spaceships.get(i).toString().replaceAll("(?m)^", "        "));
            if (i < spaceships.size() - 1) {
                sb.append(",");
            }
            sb.append("\n");
        }

        sb.append("    ]\n");
        sb.append("}");
        return sb.toString();
    }
}