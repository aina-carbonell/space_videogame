package edu.uoc.pac3;

import java.time.LocalDate;

public class Castle {
    private static final int MIN_NAME_LENGTH = 3;
    private static final double MIN_AREA = 100.0;
    private static final LocalDate MIDDLE_AGES_START = LocalDate.of(500, 1, 1);
    private static final LocalDate MIDDLE_AGES_END = LocalDate.of(1499, 12, 31);
    private static final int MIN_SYMBOLIC_ARTIFACT_LENGTH = 2;

    public static final String INVALID_NAME = "[ERROR] Castle name must have at least 3 characters";
    public static final String INVALID_CONSTRUCTION_DATE = "[ERROR] Construction date cannot be null and must be between 0500-01-01 and 1499-12-31";
    public static final String INVALID_AREA = "[ERROR] Area must be at least 100.0 square meters";
    public static final String INVALID_SYMBOLIC_ARTIFACT = "[ERROR] Symbolic artifact cannot be null, formed by only whitespace and must have at least 2 characters";

    private int id;
    private static int nextId = 1;
    private String name;
    private LocalDate constructionDate;
    private double area;
    private String symbolicArtifact;
    private Keep keep;

    public Castle(String name, LocalDate constructionDate, double area, String symbolicArtifact) {
        setName(name);
        setConstructionDate(constructionDate);
        setArea(area);
        setSymbolicArtifact(symbolicArtifact);
        setId();
        this.keep = null;
    }

    public Castle(String name, LocalDate constructionDate, double area, String symbolicArtifact,
                  String keepLordName, int keepFloors, double keepHeight,
                  int keepNumGuards, boolean keepHasDungeon) {
        setName(name);
        setConstructionDate(constructionDate);
        setArea(area);
        setSymbolicArtifact(symbolicArtifact);
        setId();

        try {
            setKeep(keepLordName, keepFloors, keepHeight, keepNumGuards, keepHasDungeon);
        } catch (Exception e) {
            this.keep = null;
        }
    }

    private void setId() {
        this.id = nextId;
        incNextId();
    }

    public int getId() {
        return id;
    }

    public static int getNextId() {
        return nextId;
    }

    private static void incNextId() {
        nextId++;
    }

    private void setArea(double area) {
        if (area < MIN_AREA) {
            throw new IllegalArgumentException(INVALID_AREA);
        }
        this.area = area;
    }

    private void setName(String name) {
        if (name == null || name.trim().length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException(INVALID_NAME);
        }
        this.name = name.trim();
    }

    private void setConstructionDate(LocalDate constructionDate) {
        if (constructionDate == null ||
                constructionDate.isBefore(MIDDLE_AGES_START) ||
                constructionDate.isAfter(MIDDLE_AGES_END)) {
            throw new IllegalArgumentException(INVALID_CONSTRUCTION_DATE);
        }
        this.constructionDate = constructionDate;
    }

    private void setSymbolicArtifact(String symbolicArtifact) {
        if (symbolicArtifact == null || symbolicArtifact.trim().length() < MIN_SYMBOLIC_ARTIFACT_LENGTH) {
            throw new IllegalArgumentException(INVALID_SYMBOLIC_ARTIFACT);
        }
        String trimmed = symbolicArtifact.trim();
        this.symbolicArtifact = trimmed.substring(0, 1).toUpperCase() +
                trimmed.substring(1).toLowerCase();
    }

    private void setKeep(String lordName, int floors, double height, int numGuards, boolean hasDungeon) {
        this.keep = new Keep(lordName, floors, height, numGuards, hasDungeon);
    }

    public String getName() { return name; }
    public LocalDate getConstructionDate() { return constructionDate; }
    public double getArea() { return area; }
    public String getSymbolicArtifact() { return symbolicArtifact; }
    public Keep getKeep() { return keep; }
}