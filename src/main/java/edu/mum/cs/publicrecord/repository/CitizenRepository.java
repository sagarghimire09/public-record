package edu.mum.cs.publicrecord.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mum.cs.publicrecord.model.Citizen;

@Repository
public interface CitizenRepository extends JpaRepository<Citizen, Long> {

}
