package edu.uoc.pac4.ship;

public class Cargo extends SpaceShip {
    private static final int PEOPLE_CAPACITY = 500;
    private boolean isRefrigerated;

    public Cargo(String id, double cargoCapacity, SpaceShipRolType rol, boolean isRefrigerated)
            throws SpaceShipException {
        super(id, PEOPLE_CAPACITY, cargoCapacity, rol);
        this.isRefrigerated = isRefrigerated;
    }

    public boolean isRefrigerated() {
        return isRefrigerated;
    }

    public void setRefrigerated(boolean refrigerated) {
        isRefrigerated = refrigerated;
    }

    @Override
    public String toString() {
        return "{ \"type\": \"Cargo\", \"details\": " +
                super.toString() + ", \"isRefrigerated\": " + (isRefrigerated ? 1 : 0) + " }";
    }
}