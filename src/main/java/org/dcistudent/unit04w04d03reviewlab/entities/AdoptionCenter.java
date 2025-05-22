package org.dcistudent.unit04w04d03reviewlab.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
public final class AdoptionCenter {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  @Column(name = "name")
  @NotBlank(message = "Adoption center name cannot be blank")
  private String name;
  @Column(name = "location")
  @NotBlank(message = "Adoption center location cannot be blank")
  private String location;
  @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
  private List<Adopter> adopters;

  public AdoptionCenter(String name, String location) {
    this.name = name;
    this.location = location;
  }

  public AdoptionCenter() {
  }

  public Long getId() {
    return this.id;
  }

  public AdoptionCenter setName(String name) {
    this.name = name;
    return this;
  }

  public String getName() {
    return this.name;
  }

  public AdoptionCenter setLocation(String location) {
    this.location = location;
    return this;
  }

  public String getLocation() {
    return this.location;
  }

  public List<Adopter> getAdopters() {
    return this.adopters;
  }

  public AdoptionCenter setAdopters(List<Adopter> adopters) {
    this.adopters = adopters;
    return this;
  }
}
