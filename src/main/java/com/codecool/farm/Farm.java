package com.codecool.farm;

import com.codecool.farm.animal.Animal;

import java.util.ArrayList;
import java.util.List;

class Farm {

    List<Animal> animals = new ArrayList<>();

    public Farm(List<Animal> animals) {
        this.animals = animals;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void feedAnimals() {
        animals.stream()
                .forEach(animal -> animal.feed());
    }

    public void butcher(Butcher butcher) {
        animals.removeIf(animal -> butcher.canButcher(animal));
    }

    public boolean isEmpty() {
        return animals.isEmpty();
    }


    public List<String> getStatus() {
        List<String> status = new ArrayList<>();
        animals.forEach(animal -> {
            status.add("There is a " + animal.getSize() + " sized " + animal.getClass().getSimpleName().toLowerCase() + " in the farm.");
        });
        return status;
    }
}
