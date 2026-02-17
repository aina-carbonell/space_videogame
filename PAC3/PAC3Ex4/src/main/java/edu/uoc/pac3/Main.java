package edu.uoc.pac3;

public class Main {
    public static void main(String[] args) {
        double[] grades1 = {9.0, 8.5, 7.5, 10.0};
        Student s1 = new Student("David", grades1, "dgarciaso@uoc.edu");

        double[] grades2 = {6.0, 7.0, 8.0, 7.5};
        Student s2 = new Student("Carles", grades2, "cgallel94bcn@uoc.edu");

        StudentRepository repository = new StudentRepository();

        repository.save(s1);
        repository.save(s2);

        repository.listAll();

        Student found = repository.findStudentByEmail("cgallel94bcn@uoc.edu");

        if (found != null) {
            System.out.println("Average grade for " + found.getName() + ": " + found.calculateAverage());
        } else {
            System.out.println("Student not found, cannot send email.");
        }
    }
}
