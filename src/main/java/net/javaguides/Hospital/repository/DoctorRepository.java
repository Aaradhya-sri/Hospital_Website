package net.javaguides.Hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.Hospital.model.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long>{
	
	
}
