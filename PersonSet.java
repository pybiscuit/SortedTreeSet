// Assignment: PersonSet.java (Human Resources)
// Purpose: Human Resource Parts 1 and 2. provide mechanisms for inheritance, 
// inerfaces, polymorphism, and file io.

import java.util.ArrayList;

class PersonSet implements PersonList {

    // instantiate ArrayList to hold Person objects.
    protected final ArrayList<Person> personList = new ArrayList<>();

    // gets a Person object from the ArrayList at the index position.
    @Override
    public Person get(int index) {
        return this.personList.get(index);
    }

    // helper method. ArrayList is private and cannot use ArrayList.size().
    public int countPeople() {
        return this.personList.size();
    }

    public String getHeader() {
        return "Name    Height (cm)    Weight (kg)\n";
    }
    // adds a Person object to the ArrayList.
    // verifies a person match does not already exist in the list.
    @Override
    public void add(Person personToAdd) {
        // if the list is not empty, proceed with checking for duplicates.
        if (!this.personList.isEmpty()) {

            // check that the list does not already contain personToAdd.
            for (int i = 0; i < this.personList.size(); ++i) {
                if (!this.personList.contains(personToAdd)) {
                    this.personList.add(personToAdd);
                }
            }
        } else {
            this.personList.add(personToAdd);
        }
    }

    @Override
    public String toString() {
        String stringToReturn = getHeader();

        for (int i = 0; i < this.personList.size(); ++i) {
            double height = this.personList.get(i).getHeight();
            double weight = this.personList.get(i).getWeight();
            String name = this.personList.get(i).getName();

            int spaceCount = (height > 100) ? 9: 10; 

            stringToReturn = stringToReturn + String.format(
                "%s" + " ".repeat(8-name.length()) + "%.2f" 
                + " ".repeat(spaceCount) 
                + "%.2f\n", name, height, weight
            );
        }

        return stringToReturn;
    }
}
