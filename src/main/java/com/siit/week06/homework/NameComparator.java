package main.java.com.siit.week06.homework;

import main.java.com.siit.week06.classexercises.Person;

import java.util.Comparator;

public class NameComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.getName().compareTo(o2.getName());
    }
}