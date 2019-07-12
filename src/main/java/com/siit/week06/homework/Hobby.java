package main.java.com.siit.week06.homework;

import main.java.com.siit.week06.classexercises.Adress;

import java.util.List;
import java.util.Objects;

public class Hobby {
    private String nameOfTheHobby;
    private int FrequencyInAWeek;
    private List<Adress> hobbyAddresses;

    public Hobby(String nameOfTheHobby, int frequencyInAWeek, List<Adress> hobbyAddresses) {
        this.nameOfTheHobby = nameOfTheHobby;
        FrequencyInAWeek = frequencyInAWeek;
        this.hobbyAddresses = hobbyAddresses;
    }

    public String getNameOfTheHobby() {
        return nameOfTheHobby;
    }

    public void setNameOfTheHobby(String nameOfTheHobby) {
        this.nameOfTheHobby = nameOfTheHobby;
    }

    public int getFrequencyInAWeek() {
        return FrequencyInAWeek;
    }

    public void setFrequencyInAWeek(int frequencyInAWeek) {
        FrequencyInAWeek = frequencyInAWeek;
    }

    public List<Adress> getHobbyAddresses() {
        return hobbyAddresses;
    }

    public void setHobbyAddresses(List<Adress> hobbyAddresses) {
        this.hobbyAddresses = hobbyAddresses;
    }

    @Override
    public String toString() {
        return "Hobby{" +
                "nameOfTheHobby='" + nameOfTheHobby + '\'' +
                ", FrequencyInAWeek=" + FrequencyInAWeek +
                ", hobbyAddresses=" + hobbyAddresses +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hobby)) return false;
        Hobby hobby = (Hobby) o;
        return FrequencyInAWeek == hobby.FrequencyInAWeek &&
                nameOfTheHobby.equals(hobby.nameOfTheHobby) &&
                hobbyAddresses.equals(hobby.hobbyAddresses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameOfTheHobby, FrequencyInAWeek, hobbyAddresses);
    }
}