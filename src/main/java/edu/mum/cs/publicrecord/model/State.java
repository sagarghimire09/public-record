package edu.mum.cs.publicrecord.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="states")
public class State {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int stateId;
	@Column(nullable=false, unique=true)
	@NotBlank(message="*This field is required.")
	private String stateCode;
	@Column(nullable=false)
	@NotBlank(message="*This field is required.")
	private String stateName;
	@OneToMany(mappedBy="state", cascade = CascadeType.ALL)
	private List<Citizen> citizens;
	
	
	public int getStateId() {
		return stateId;
	}
	public void setStateId(int stateId) {
		this.stateId = stateId;
	}
	public String getStateCode() {
		return stateCode;
	}
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public List<Citizen> getCitizens() {
		return citizens;
	}
	public void setCitizens(List<Citizen> citizens) {
		this.citizens = citizens;
	}
	
}
