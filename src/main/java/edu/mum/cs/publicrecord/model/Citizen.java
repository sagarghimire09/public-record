package edu.mum.cs.publicrecord.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="citizens")
public class Citizen {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long citizenId;
	@Column(nullable=false, unique=true)
	@NotBlank(message="*This field is required.")
	private String socialSecurityNumber;
	@Column(nullable=false)
	@NotBlank(message="*This field is required.")
	private String firstName;
	private String middleName;
	@Column(nullable=false)
	@NotBlank(message="*This field is required.")
	private String lastName;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@NotNull(message="*This field is required.")
	private LocalDate dateOfBirth;
	@NotNull(message="*This field is required.")
	private double yearlyIncome;
	@ManyToOne
	@JoinColumn(name="state_id")
	private State state;
	
	
	public Long getCitizenId() {
		return citizenId;
	}
	public void setCitizenId(Long citizenId) {
		this.citizenId = citizenId;
	}
	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}
	public void setSocialSecurityNumber(String socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public double getYearlyIncome() {
		return yearlyIncome;
	}
	public void setYearlyIncome(double yearlyIncome) {
		this.yearlyIncome = yearlyIncome;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	
	@Override
	public String toString() {
		return "Citizen [citizenId=" + citizenId + ", socialSecurityNumber=" + socialSecurityNumber + ", firstName="
				+ firstName + ", middleName=" + middleName + ", lastName=" + lastName + ", dateOfBirth=" + dateOfBirth
				+ ", yearlyIncome=" + yearlyIncome + ", state=" + state + "]";
	}
	
}
