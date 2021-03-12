package com.mukul.java8features.lambdas.streamoperations;

import com.mukul.java8features.lambdas.domain.Student;
import com.mukul.java8features.lambdas.domain.Teacher;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class OptionalType {

    private void sumOfAttendees() {
        List<Integer> attendees = Arrays.asList(22, 10, 13, 9);

        Optional<Integer> totalAttendees = attendees.stream().reduce(
                Integer::sum);

        int total = totalAttendees.orElse(0);

        System.out.println("Total attendees: " + total);
    }

    private void noAttendeesOptional() {
        List<Integer> attendees = Collections.emptyList();
        Optional<Integer> noAttendees = attendees.stream().reduce(Integer::sum);

        if (noAttendees.isPresent())
            System.out.println(noAttendees.get());

    }

    private void creatingOptionals() {
        Student student = new Student();
        Optional<Student> studentOptional = Optional.of(student);
        studentOptional.ifPresent(System.out::println);

        student = null;
        Optional<Student> studentOptional2 = Optional.ofNullable(student);

        System.out.println("Student can't be null:" + studentOptional2);

    }

    private void usingIfPresent() {
        Student student = new Student();
        Optional<Student> studentOptional = Optional.of(student);
        studentOptional.ifPresent(System.out::println);
    }

    private void usingOrElse() {
        Student student = null;
        Student defaultStudent = new Student();
        defaultStudent.setName("Default John");

        Optional<Student> studentOptional = Optional.ofNullable(student);

        String name = studentOptional.orElse(defaultStudent).getName();
        System.out.println("Get Name: " + name);

    }

    private void usingOrElseThrow() throws Exception {
        Optional<Student> studentOptional = null;
        studentOptional.orElseThrow(Exception::new);
    }

    private void filteringAndMapping() {
        Student s = new Student();
        s.setName("John Carla");
        s.setTeacher(new Teacher("Prof. Pandit"));

        Optional<Student> studentOptional = Optional.of(s);
        studentOptional
                .filter(student -> student.hasTeacher())
                .ifPresent(System.out::println);

        studentOptional
                .map(student -> student.getName())
                .ifPresent(System.out::println);
    }

    public static void main(String[] args) {
		new OptionalType().sumOfAttendees();
		new OptionalType().noAttendeesOptional();
		new OptionalType().creatingOptionals();
		new OptionalType().usingIfPresent();
		new OptionalType().usingOrElse();
        new OptionalType().filteringAndMapping();
        try {
            new OptionalType().usingOrElseThrow();
        } catch (Exception e) {
            System.out.println("Expected exception: ");
            e.printStackTrace();
        }



    }

}
