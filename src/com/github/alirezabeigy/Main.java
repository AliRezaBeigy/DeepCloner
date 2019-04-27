package com.github.alirezabeigy;

public class Main {

    public static void main(String[] args) {
        //Initialize a person
        Person person = new Person.Builder()
                .address(new Address.Builder().name("Tehran").address("Iran, Tehran").build())
                .name(new Name.Builder().first_name("Ali").last_name("Mohammadi").build())
                .build();

        //print person 1 info
        printPersonInfo(person);

        //deep copy person 1 to person 2
        Person person2 = new Person.Builder().build();
        person.clone(person2);

        //print person 2 info
        printPersonInfo(person2);

        System.out.println();

        //change person 2 info
        person2.setName(new Name.Builder().first_name("Homan").last_name("Setak").build());

        //print persons info
        printPersonInfo(person);
        printPersonInfo(person2);
    }

    private static void printPersonInfo(Person person) {
        System.out.printf("%s %s from %s%n", person.getName().getFirstName(), person.getName().getLastName(), person.getAddress().getFullAddress());
    }
}
