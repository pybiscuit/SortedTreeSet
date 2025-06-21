// Assignment: PersonOrderedSet.java (Human Resources)
// Purpose: Human Resource Parts 1 and 2. provide mechanisms for inheritance, 
// inerfaces, polymorphism, and file io.

import java.util.Collections;

class PersonOrderedSet extends PersonSet {
    
    @Override
    public void add(Person p) {
        super.add(p);
    }

    public void sort() {
        Collections.sort(this.personList);
    }
}
