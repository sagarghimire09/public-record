package edu.mum.cs.publicrecord.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import edu.mum.cs.publicrecord.model.Citizen;
import edu.mum.cs.publicrecord.repository.CitizenRepository;
import edu.mum.cs.publicrecord.service.CitizenService;

@Service
public class CitizenServiceImpl implements CitizenService {
	@Autowired
	CitizenRepository repository;
	
	@Override
	public List<Citizen> getAllCitizen() {
		return repository.findAll(Sort.by(Sort.Direction.ASC, "lastName"));
	}

	@Override
	public Citizen saveCitizen(Citizen citizen) {
		return repository.save(citizen);
	}

	@Override
	public double getNationalYearlyIncome(List<Citizen> citizens) {
		double totalIncome = 0.0;
		for(Citizen c : citizens) {
			totalIncome += c.getYearlyIncome();
		}
		return Math.floor(totalIncome*100)/100;
	}

}
