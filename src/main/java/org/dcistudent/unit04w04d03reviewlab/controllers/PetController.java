package org.dcistudent.unit04w04d03reviewlab.controllers;

import org.dcistudent.unit04w04d03reviewlab.entities.Pet;
import org.dcistudent.unit04w04d03reviewlab.services.PetService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PetController {

  PetService service;

  public PetController(PetService service) {
    this.service = service;
  }

  @GetMapping("/pets")
  public List<Pet> getAll() {
    return this.service.getAll();
  }

  @GetMapping("/pets/new")
  public Pet create(
      @PathVariable String name,
      @PathVariable String breed,
      @PathVariable int age
  ) {
    return this.service.create(name, breed, age);
  }

  @GetMapping("/pets/{id}")
  public Pet getById(@PathVariable Long id) {
    return this.service.getById(id);
  }

  @GetMapping("/pets/{id}/edit")
  public Pet edit(
      @PathVariable Long id,
      @PathVariable String name,
      @PathVariable String breed,
      @PathVariable int age
  ) {
    return this.service.edit(id, name, breed, age);
  }

  @GetMapping("/pets/{id}/delete")
  public Boolean delete(@PathVariable Long id) {
    return this.service.delete(id);
  }
}
