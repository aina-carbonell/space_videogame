package edu.uoc.pac4;

public enum SpaceShipRolType {
    BATTLE,
    SCIENCE,
    DIPLOMATIC;

    @Override
    public String toString() {
        String name = name();
        return name.charAt(0) + name.substring(1).toLowerCase();
    }
}