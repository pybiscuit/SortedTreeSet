// Assignment: Person.java (Human Resources)
// Purpose: Human Resource Parts 1 and 2. provide mechanisms for inheritance, 
// inerfaces, polymorphism, and file io.

import java.util.Objects;

class Person implements Comparable<Person>{

    private String name;
    private double height;
    private double weight;

    public Person() {
        this.height = 0.0;
        this.weight = 0.0;
        this.name = "The Swamp Thing";
    }

    public Person(String name, double height, double weight) {
        this.height = height;
        this.weight = weight;
        this.name = name;
    }

    public double getHeight() {
        return this.height;
    }

    public double getWeight() {
        return this.weight;
    }

    public String getName() {
        return this.name;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    
    @Override
    public String toString() {
        return this.name + " is " + this.height + " meters tall, and weighs " 
                + this.weight + " Kilograms.";
    }

    @Override
    public boolean equals(Object obj) {
        // if the Person objects match return true.
        if (this == obj) return true;

        // if the Person objects do not match return false.
        if (!(obj instanceof Person)) return false;

        // check if the attributes returned from the objects getter methods match.
        Person other = (Person) obj;
        return this.height == other.height &&
               this.weight == other.weight &&
               this.name.equals(other.name);
    }

    @Override
    public int hashCode() {
        // return the hashCode for height, weight, name to allow equals to check
        // Person objects for parity.
        return Objects.hash(height, weight, name);
    }

    @Override
    public int compareTo(Person p) {
        return this.name.compareTo(p.name);
    }
}
