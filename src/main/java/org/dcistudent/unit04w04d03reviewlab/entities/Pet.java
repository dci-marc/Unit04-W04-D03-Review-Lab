package org.dcistudent.unit04w04d03reviewlab.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public final class Pet {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  @Column(name = "name")
  @NotBlank(message = "Pet name cannot be blank")
  String name;
  @Column(name = "breed")
  @NotBlank(message = "Pet breed cannot be blank")
  String breed;
  @Column(name = "age")
  @NotBlank(message = "Pet age cannot be blank")
  int age;

  public Pet(String name, String breed, int age) {
    this.name = name;
    this.breed = breed;
    this.age = age;
  }

  public Pet() {
  }

  public Long getId() {
    return id;
  }

  public Pet setName(String name) {
    this.name = name;
    return this;
  }

  public String getName() {
    return this.name;
  }

  public Pet setBreed(String breed) {
    this.breed = breed;
    return this;
  }

  public String getBreed() {
    return this.breed;
  }

  public Pet setAge(int age) {
    this.age = age;
    return this;
  }

  public int getAge() {
    return this.age;
  }
}
