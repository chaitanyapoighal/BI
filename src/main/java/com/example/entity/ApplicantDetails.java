package com.example.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class ApplicantDetails {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sno;
    
	@Id
    private Integer casenum;
	
	private String applicantName;
	
	private Long applicantSsn;
	
	private String planname;
	
	private String planstatus;
	
	private LocalDate startDate;
	
	private LocalDate endDate;
	
	private Integer benefitAmt;
	
	private String denialreason;
	
	private String bankName;
	
	private String Accno;
    
}
