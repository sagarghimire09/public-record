package edu.mum.cs.publicrecord.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs.publicrecord.model.State;
import edu.mum.cs.publicrecord.repository.StateRepository;
import edu.mum.cs.publicrecord.service.StateService;

@Service
public class StateServiceImpl implements StateService {
	@Autowired
	StateRepository repository;
	@Override
	public List<State> getAllState() {
		return repository.findAll();
	}

}
