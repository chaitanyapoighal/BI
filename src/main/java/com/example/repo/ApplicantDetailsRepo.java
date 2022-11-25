package com.example.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.ApplicantDetails;

public interface ApplicantDetailsRepo extends JpaRepository<ApplicantDetails,Integer>{

	public List<ApplicantDetails> findByPlanstatus(String status);
}
