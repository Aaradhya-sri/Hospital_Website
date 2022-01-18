package net.javaguides.Hospital.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.ForeignKey;

@Entity
@Table(name= "Patients")
public class Patients {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="patient_id")
	private long id;
	
	@Column(name="patient_name")
	private String name;
	
	@Column(name="patient_visitedDoctor")
	private String visitedDoctor;
	
	@Column(name="patient_dateOfVisit")
	private String dateOfVisit;
	
	
	@ManyToOne
	@JoinColumn(foreignKey=@ForeignKey(name="Doctor_id"))
	private Doctor Doctor;
	
	public Patients() {
		
	}	

	public Patients(String name, String visitedDoctor, String dateOfVisit) {
		super();
		this.name = name;
		this.visitedDoctor = visitedDoctor;
		this.dateOfVisit = dateOfVisit;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVisitedDoctor() {
		return visitedDoctor;
	}

	public void setVisitedDoctor(String visitedDoctor) {
		this.visitedDoctor = visitedDoctor;
	}

	public String getDateOfVisit() {
		return dateOfVisit;
	}

	public void setDateOfVisit(String dateOfVisit) {
		this.dateOfVisit = dateOfVisit;
	}	
	
	/*public doctor getdoctor() {
		return doctor;
	}
	public void setdoctor() {
		this.doctor = doctor;
	}*/
}
