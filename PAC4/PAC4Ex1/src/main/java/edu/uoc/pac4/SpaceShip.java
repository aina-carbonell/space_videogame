package edu.uoc.pac4;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class SpaceShip {
    private String id;
    private int peopleCapacity;
    private double cargoCapacity;
    private SpaceShipRolType spaceShipRolType;

    public SpaceShip(String id, int peopleCapacity, double cargoCapacity, SpaceShipRolType type) throws SpaceShipException {
        setId(id);
        setPeopleCapacity(peopleCapacity);
        setCargoCapacity(cargoCapacity);
        setSpaceShipRolType(type);
    }

    public String getId() { return id; }
    public int getPeopleCapacity() { return peopleCapacity; }
    public double getCargoCapacity() { return cargoCapacity; }
    public SpaceShipRolType getSpaceShipRolType() { return spaceShipRolType; }

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

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.0");
        df.setDecimalFormatSymbols(new DecimalFormatSymbols(Locale.US));

        return "{\n" +
                "    \"id\": \"" + id + "\",\n" +
                "    \"peopleCapacity\": " + peopleCapacity + ",\n" +
                "    \"cargoCapacity\": " + df.format(cargoCapacity) + ",\n" +
                "    \"rol\": \"" + spaceShipRolType.toString() + "\"\n" +
                "}";
    }
}