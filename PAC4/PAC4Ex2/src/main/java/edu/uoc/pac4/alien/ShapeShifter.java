package edu.uoc.pac4.alien;

public interface ShapeShifter {
    void changeName();

    default void shapeShift() {
        System.out.println("Shape shifting...");
    }
}