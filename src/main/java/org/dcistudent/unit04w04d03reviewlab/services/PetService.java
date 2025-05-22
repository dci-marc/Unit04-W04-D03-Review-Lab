package org.dcistudent.unit04w04d03reviewlab.services;

import org.dcistudent.unit04w04d03reviewlab.entities.Pet;
import org.dcistudent.unit04w04d03reviewlab.repositories.PetRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

  PetRepository repository;

  public List<Pet> getAll() {
    return repository.findAll();
  }

  public Pet create(String name, String breed, int age) {
    Pet pet = new Pet(name, breed, age);
    return repository.save(pet);
  }

  @Cacheable(value = "pets", key = "#id")
  public Pet getById(Long id) {
    return repository.findById(id).orElseThrow(() -> new RuntimeException("Pet not found"));
  }

  public Pet edit(Long id, String name, String breed, int age) {
    Pet pet = repository.findById(id).orElseThrow(() -> new RuntimeException("Pet not found"));
    pet.setName(name);
    pet.setBreed(breed);
    pet.setAge(age);
    return repository.save(pet);
  }

  public Boolean delete(Long id) {
    Pet pet = repository.findById(id).orElseThrow(() -> new RuntimeException("Pet not found"));
    repository.delete(pet);
    return true;
  }

  public Pet persist(Pet pet) {
    return repository.save(pet);
  }
}
