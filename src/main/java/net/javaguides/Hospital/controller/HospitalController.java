package net.javaguides.Hospital.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.Hospital.exception.ResourceNotFoundException;
import net.javaguides.Hospital.model.Doctor;
import net.javaguides.Hospital.model.Patients;
import net.javaguides.Hospital.repository.DoctorRepository;
import net.javaguides.Hospital.repository.PatientRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class HospitalController {
	
	@Autowired
	private DoctorRepository DoctorRepository;
	
	@Autowired
	private PatientRepository PatientRepository;
	
	// get all Doctor
	@GetMapping("/Doctor")
	public List<Doctor> getAllDoctor(){
		return DoctorRepository.findAll();
	}		
	
	// create employee rest api
	@PostMapping("/Doctor")
	public Doctor createDoctor(@RequestBody Doctor Doctor) {
		return DoctorRepository.save(Doctor);
	}
	
	// get employee by id rest api
	@GetMapping("/Doctor/{id}")
	public ResponseEntity<Doctor> getDoctorById(@PathVariable Long id) {
		Doctor Doctor = DoctorRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Doctor not exist with id :" + id));
		return ResponseEntity.ok(Doctor);
	}
	
	// update employee rest api
	
	@PutMapping("/Doctor/{id}")
	public ResponseEntity<Doctor> updateDoctor(@PathVariable Long id, @RequestBody Doctor DoctorDetails){
		Doctor Doctor = DoctorRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Doctor not exist with id :" + id));
		
		Doctor.setId(DoctorDetails.getId());
		Doctor.setName(DoctorDetails.getName());
		Doctor.setAge(DoctorDetails.getAge());
		Doctor.setGender(DoctorDetails.getGender());
		Doctor.setSpecialist_fields(DoctorDetails.getSpecialist_fields());
		
		Doctor updatedDoctor = DoctorRepository.save(Doctor);
		return ResponseEntity.ok(updatedDoctor);
	}
	
	// delete employee rest api
	@DeleteMapping("/Doctor/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteDoctor(@PathVariable Long id){
		Doctor Doctor = DoctorRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Doctor not exist with id :" + id));
		
		DoctorRepository.delete(Doctor);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	// get all Patients
	@GetMapping("/Patients")
	public List<Patients> getAllPatients(){
		return PatientRepository.findAll();
	}		
	
	// create Patient rest api
	@PostMapping("/Patient")
	public Patients createPatient(@RequestBody Patients Patient) {
		return PatientRepository.save(Patient);
	}
	
	// get Patient by id rest api
	@GetMapping("/Patient/{id}")
	public ResponseEntity<Patients> getPatientById(@PathVariable Long id) {
		Patients Patients = PatientRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Patient not exist with id :" + id));
		return ResponseEntity.ok(Patients);
	}
	
	// update Patient rest api
	
	@PutMapping("/Patient/{id}")
	public ResponseEntity<Patients> updatePatient(@PathVariable Long id, @RequestBody Patients PatientDetails){
		Patients Patient = PatientRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Patient not exist with id :" + id));
		
		Patient.setId(PatientDetails.getId());
		Patient.setName(PatientDetails.getName());
		Patient.setVisitedDoctor(PatientDetails.getVisitedDoctor());
		Patient.setDateOfVisit(PatientDetails.getDateOfVisit());
		
		Patients updatedPatient = PatientRepository.save(Patient);
		return ResponseEntity.ok(updatedPatient);
	}
	
	// delete Patient rest api
	@DeleteMapping("/Patient/{id}")
	public ResponseEntity<Map<String, Boolean>> deletePatient(@PathVariable Long id){
		Patients Patient = PatientRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Patient not exist with id :" + id));
		
		PatientRepository.delete(Patient);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
