package com.example.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bind.CitizenForm;
import com.example.entity.ApplicantDetails;
import com.example.repo.ApplicantDetailsRepo;
import com.opencsv.CSVWriter;

@Service
public class BIServiceImpl implements BIService {

	@Autowired
	ApplicantDetailsRepo aprepo;

	public void createcsv() {
		List<ApplicantDetails> appdetails = aprepo.findByPlanstatus("Approved");
		List<CitizenForm> cforms = new ArrayList<CitizenForm>();
		for (ApplicantDetails app : appdetails) {
			CitizenForm citiform = new CitizenForm();
			BeanUtils.copyProperties(app, citiform);
			cforms.add(citiform);
		}

		String path = "E:\\SPRING\\csv.txt";
		File file = new File(path);
		try {
			FileWriter opfile = new FileWriter(file);
			CSVWriter writer = new CSVWriter(opfile);

			List<String[]> data = new ArrayList<String[]>();
			data.add(new String[] { "Casenum", "Name", "SSN", "BenefitAmt", "BankName", "AccontNumer" });

			for (CitizenForm cform : cforms) {

				data.add(new String[] { String.valueOf(cform.getCasenum()), cform.getApplicantName(),
						String.valueOf(cform.getApplicantSsn()), String.valueOf(cform.getBenefitAmt()),
						cform.getBankName(), cform.getAccno() });
			}

			writer.writeAll(data);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
