package chapter9.lamda;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Person> roster = createRoster();
        System.out.println("모든 사람 출력");
        Person.printPersons(roster, (Person p) -> true);
        System.out.println("---------------------------------------");
        Person.printPersonOlderThan(roster,26);
        System.out.println("---------------------------------------");
        Person.printPersonsWithinAgeRange(roster, 20,23);

        System.out.printf("\t\t\tHi");

    }

    private static List<Person> createRoster() {
        List<Person> roster = new ArrayList<>();
        roster.add(new Person("Alice", Person.Gender.FEMALE, "alice@example.com", 25));
        roster.add(new Person("Bob", Person.Gender.MALE, "bob@example.com", 30));
        roster.add(new Person("Charlie", Person.Gender.MALE, "charlie@example.com", 22));
        roster.add(new Person("Diana", Person.Gender.FEMALE, "diana@example.com", 28));
        return roster;
    }
}
