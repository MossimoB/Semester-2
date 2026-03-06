package org.mossimo;

public class Main {
    public static void main(String[] args) {
        School school = new School();

        school.addUser(new User("jane", 20));
    }

    /*
    create a Pet class abstract
        id, name, age, gender (enum)
        id for cat and dog is separated
    create Cat class sub of Pet
        cute (int)
    create Dog class sub of Pet
        dangerous (boolean)
    create a petStore class
        pets (list of pets)
        default constructor to load pets from a csv file
        method loadPets()
        method addPet(Pet pet)
        method exportPets()
     */
}