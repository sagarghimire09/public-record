package edu.mum.cs.publicrecord.service;

import java.util.List;

import edu.mum.cs.publicrecord.model.Citizen;

public interface CitizenService {
	List<Citizen> getAllCitizen();
	Citizen saveCitizen(Citizen citizen);
	double getNationalYearlyIncome(List<Citizen> citizens);
}
