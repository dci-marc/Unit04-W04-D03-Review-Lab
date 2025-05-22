package org.dcistudent.unit04w04d03reviewlab.repositories;

import org.dcistudent.unit04w04d03reviewlab.entities.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Long> {
}
