package main.java.com.siit.week06;

import main.java.com.siit.week06.classexercises.*;
import main.java.com.siit.week06.homework.AgeComparator;
import main.java.com.siit.week06.homework.Hobby;
import main.java.com.siit.week06.homework.NameComparator;

import java.util.*;

/**
 * ObjectContainers
 * <p>
 * Will submit the homework as a git commit, like last time. Please make sure you separate the homework code from the
 * class exercises.
 * <p>
 * Requirements:
 * <p>
 * 1. You need to store Persoane in a TreeSet. Define 2 Comparators (one for name - nume and one for age-varsta) that
 * will be used when creating the TreeSet;
 * <p>
 * Add Persoane to the TreeSet; iterate throug the treeset and print the name and the age;
 * NOTE: if you are using a Comparator, the class Persoana should not implement Comparable anymore.
 * <p>
 * 2. You need to store some information about some persons: for one person, you need a list of his/her hobbies;
 * <p>
 * Define for Hobby a class that contains:
 * <p>
 * Name of hobby (String) – eq: cycling, swimming
 * Frequency (int) – how many times a week they practice it
 * List of Addresses where this hobby can be practiced (List<Adresa>)
 * <p>
 * You will use a HashMap
 * <p>
 * <Persoana, List<Hobby>>
 * <p>
 * NOTE: equals() from Persoana must be overriden
 * <p>
 * Add some information to this map; for a certain Persoana, print the names of the hobbies and the countries where it
 * can be practiced
 * <p>
 * USE THE ALREADY DEFINED CLASSES: PERSOANA, SOMER, ANGAJAT, STUDENT; ADRESA; TARA;
 */
public class Main {
    public static void main(String[] args) {
        Person ion = new Employee("Ion", 50, "1123823455741");
        Person vasile = new Unemployed("Vasile", 7, "6456454694195");
        Person ghita = new Student("Ghita", 19, "4054488496542");

        Set<Person> personSet = addingPersonsToTreeSet(ion, vasile, ghita);

        printNameAndAge(personSet);

        Hobby cycling = configureCyclingHobby();

        Hobby swimming = configureSwimmingHobby();

        List<Hobby> hobbiesOfIon = configuringIonSHobbies(cycling, swimming);

        Map<Person, List<Hobby>> hobbiesOfThePersons = new HashMap<>();
        hobbiesOfThePersons.put(ion, hobbiesOfIon);

        printHobbiesNameAndCountries(ion, hobbiesOfThePersons);
    }

    public static List<Hobby> configuringIonSHobbies(Hobby cycling, Hobby swimming) {
        List<Hobby> hobbiesOfIon = new ArrayList<>();
        hobbiesOfIon.add(cycling);
        hobbiesOfIon.add(swimming);
        return hobbiesOfIon;
    }

    public static Hobby configureSwimmingHobby() {
        Adress swimmingFirstAdress = new Adress("Romania", "Cluj", "1 Martie", "3", null, null);
        Adress swimmingSecondAdress = new Adress("Russia", "Stalingrad", "Fabricii", "82", null, null);
        List<Adress> swimmingAdresses = new ArrayList<>();
        swimmingAdresses.add(swimmingFirstAdress);
        swimmingAdresses.add(swimmingSecondAdress);
        return new Hobby("swimming", 2, swimmingAdresses);
    }

    public static Hobby configureCyclingHobby() {
        Adress cyclingFirstAdress = new Adress("Romania", "Cluj", "21 Decembrie", "1", "B2", "7");
        Adress cyclingSecondAdress = new Adress("USA", "Area51", "Apei", "12", "A2", "45");
        List<Adress> cyclingAdresses = new ArrayList<>();
        cyclingAdresses.add(cyclingFirstAdress);
        cyclingAdresses.add(cyclingSecondAdress);
        return new Hobby("cycling", 2, cyclingAdresses);
    }

    public static Set<Person> addingPersonsToTreeSet(Person ion, Person vasile, Person ghita) {
        Set<Person> personSet = new TreeSet<>(new NameComparator().thenComparing(new AgeComparator()));
        personSet.add(ion);
        personSet.add(vasile);
        personSet.add(ghita);
        return personSet;
    }

    public static void printNameAndAge(Set<Person> personSetToPrint) {
        System.out.println("Sorted: ");
        for (Person aPerson : personSetToPrint) {
            System.out.println("Name: " + aPerson.getName() + " Age: " + aPerson.getAge());
        }
    }

    public static void printHobbiesNameAndCountries(Person aPerson, Map<Person, List<Hobby>> map) {
        if (map.containsKey(aPerson)) {
            System.out.println("\nHobbies of " + aPerson.getName()+":");
            for (Hobby hobby : map.get(aPerson)) {
                System.out.println();
                System.out.println(hobby.getNameOfTheHobby());
                for (Adress adress : hobby.getHobbyAddresses()) {
                    System.out.println(adress.getCountry());
                }
            }
        } else {
            System.out.println("No such person!");
        }
    }
}