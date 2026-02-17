package edu.uoc.pac4.ship;

import edu.uoc.pac4.alien.Alien;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public abstract class SpaceShip {
    private String id;
    private int peopleCapacity;
    private double cargoCapacity;
    private SpaceShipRolType spaceShipRolType;
    private List<Alien> aliens;

    protected SpaceShip(String id, int peopleCapacity, double cargoCapacity, SpaceShipRolType type)
            throws edu.uoc.pac4.ship.SpaceShipException {
        setId(id);
        setPeopleCapacity(peopleCapacity);
        setCargoCapacity(cargoCapacity);
        setSpaceShipRolType(type);
        this.aliens = new LinkedList<>();
    }

    public String getId() {
        return id;
    }

    public int getPeopleCapacity() {
        return peopleCapacity;
    }

    public double getCargoCapacity() {
        return cargoCapacity;
    }

    public SpaceShipRolType getSpaceShipRolType() {
        return spaceShipRolType;
    }

    public List<Alien> getAliens() {
        return aliens;
    }

    private void setId(String id) throws SpaceShipException {
        if (id == null || !id.startsWith("SS-")) {
            throw new SpaceShipException(SpaceShipException.INVALID_SPACESHIP_ID);
        }
        this.id = id;
    }

    public void setPeopleCapacity(int peopleCapacity) {
        this.peopleCapacity = Math.max(peopleCapacity, 0);
    }

    private void setCargoCapacity(double cargoCapacity) {
        this.cargoCapacity = Math.max(cargoCapacity, 0);
    }

    public void setSpaceShipRolType(SpaceShipRolType spaceShipRolType) throws SpaceShipException {
        if (spaceShipRolType == null) {
            throw new SpaceShipException(SpaceShipException.INVALID_SPACESHIP_ROL_TYPE);
        }
        this.spaceShipRolType = spaceShipRolType;
    }

    public boolean addAlien(Alien alien) throws SpaceShipException {
        if (alien == null) {
            throw new SpaceShipException(SpaceShipException.NULL_ALIEN);
        }
        if (aliens.contains(alien)) {
            throw new SpaceShipException(SpaceShipException.ALIEN_ALREADY_EXISTS);
        }
        if (aliens.size() >= peopleCapacity) {
            throw new SpaceShipException(SpaceShipException.PEOPLE_CAPACITY_EXCEEDED);
        }
        return aliens.add(alien);
    }

    public boolean removeAlien(Alien alien) throws SpaceShipException {
        if (alien == null) {
            throw new SpaceShipException(SpaceShipException.NULL_ALIEN);
        }
        return aliens.remove(alien);
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.0");
        df.setDecimalFormatSymbols(new DecimalFormatSymbols(Locale.US));

        StringBuilder sb = new StringBuilder();
        sb.append("{ \"id\": \"").append(id).append("\", ");
        sb.append("\"peopleCapacity\": ").append(peopleCapacity).append(", ");
        sb.append("\"cargoCapacity\": ").append(df.format(cargoCapacity)).append(", ");
        sb.append("\"rol\": \"").append(spaceShipRolType.toString()).append("\", ");
        sb.append("\"aliens\": [");

        for (int i = 0; i < aliens.size(); i++) {
            String alienStr = aliens.get(i).toString().replace("\n", "").replace("\r", "");
            sb.append(alienStr);
            if (i < aliens.size() - 1) {
                sb.append(", ");
            }
        }

        sb.append("] }");
        return sb.toString();
    }
}