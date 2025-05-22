package org.dcistudent.unit04w04d03reviewlab.repositories;

import org.dcistudent.unit04w04d03reviewlab.entities.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet, Long> {
  @Query("SELECT p FROM Pet AS p")
  public List<Pet> findAll();
}
