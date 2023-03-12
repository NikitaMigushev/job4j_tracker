package ru.job4j.encapsulation;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Nikita Migushev");
        student.setGroup(1);
        student.setAdmissionDate(new Date());

        System.out.println("Student " + student.getFullName() + " is in Group: " + student.getGroup() + " admission date: " + student.getAdmissionDate());
    }
}
