package net.javaguides.Hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.Hospital.model.Patients;

@Repository
public interface PatientRepository extends JpaRepository<Patients, Long> {
	
}
