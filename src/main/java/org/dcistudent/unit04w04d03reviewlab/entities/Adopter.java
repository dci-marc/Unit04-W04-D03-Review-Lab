package org.dcistudent.unit04w04d03reviewlab.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
public final class Adopter {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name")
  @NotBlank(message = "Adopter name is mandatory")
  private String name;
  @Column(name = "phone")
  @NotBlank(message = "Adopter phone number is mandatory")
  private String phone;
  @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
  private List<Pet> pets;

  public Adopter(String name, String phone) {
    this.name = name;
    this.phone = phone;
  }

  public Adopter() {
  }

  public Long getId() {
    return id;
  }

  public Adopter setName(String name) {
    this.name = name;
    return this;
  }

  public String getName() {
    return this.name;
  }

  public Adopter setPhone(String phone) {
    this.phone = phone;
    return this;
  }

  public String getPhone() {
    return this.phone;
  }

  public List<Pet> getPets() {
    return this.pets;
  }

  public Adopter setPets(List<Pet> pets) {
    this.pets = pets;
    return this;
  }
}
