package edu.uoc.pac3;

public class Student {
    private String name;
    private double[] grades;
    private String email;

    public Student(String name, double[] grades, String email) {
        this.name = name;
        this.grades = grades;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public double[] getGrades() {
        return grades;
    }

    public String getEmail() {
        return email;
    }

    public double calculateAverage() {
        if (grades == null || grades.length == 0) {
            return 0;
        }

        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        return sum / grades.length;
    }
}