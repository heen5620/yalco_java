package chapter9.lamda;

import java.time.LocalDate;
import java.util.*;

class CheckPerosnEl implements CheckPerson{
    public boolean test(Person p){
        return p.gender == Person.Gender.MALE &&
                p.getAge() >= 19 &&
                p.getAge() <= 25;
    }
}

public class Person {
    public Person(String name, Gender gender, String emailAddress, int age) {
        this.name = name;
        this.gender = gender;
        this.emailAddress = emailAddress;
        this.age = age;
    }

    public enum Gender{
        MALE, FEMALE;
    }

    String name;
    LocalDate birthday;
    Gender gender;

    String emailAddress;
    int age;

    public int getAge(){
        return this.age;
    }

    public void printPerson() {
        System.out.println("이름 : " + this.name +
                " 생년월일 :" + this.birthday+
                " Gender :" + gender +
                "age : " + this.age +
                "E-mail address : " + this.emailAddress
                );

    }

    public static void printPersonOlderThan(List<Person> roster, int age){
        for(Person p : roster){
            if(p.getAge() >= age){
                p.printPerson();
            }
        }
    }

    public static void  printPersonsWithinAgeRange(List<Person> roster, int low, int high){
        for (Person p : roster) {
            if (low <= p.getAge() && p.getAge() < high) {
                p.printPerson();
            }
        }
    }

    public static void printPersons(List<Person> roster, CheckPerson tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }
}
