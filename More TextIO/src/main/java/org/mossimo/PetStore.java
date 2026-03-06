package org.mossimo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PetStore {
    private List<Pet> pets;
    private static final String PET_PATH = "src/main/resources/pet.csv";

    public PetStore() {
        loadPets();
    }

    private void loadPets() {
        File file = new File(PET_PATH);
        pets = new ArrayList<>();

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] elements = line.split(",");

                String name = elements[0];
                int age = Integer.parseInt(elements[1]);
                Pet.Gender gender = Pet.Gender.valueOf(elements[2].trim());

                Pet pet = new Pet(name, age, gender);
                pets.add(pet);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void addPet(Pet pet) {
        pets.add(pet);

        File file = new File(PET_PATH);
        try (FileWriter fileWriter = new FileWriter(file, true)) {
            String name = pet.getName();
            int age = pet.getAge();
            Pet.Gender gender = pet.getGender();

            fileWriter.write(String.format("%s, %d, %s\n", name, age, gender));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void exportPets() {
        File file = new File(PET_PATH);

        try (FileWriter fileWriter = new FileWriter(file)) {
            for (Pet pet : pets) {
                String name = pet.getName();
                int age = pet.getAge();
                Pet.Gender gender = pet.getGender();

                fileWriter.write(String.format("%s, %d, %s\n", name, age, gender));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
