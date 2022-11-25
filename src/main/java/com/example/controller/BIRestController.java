package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.BIService;

@RestController
public class BIRestController {
@Autowired
BIService serviceimpl;
@GetMapping("/file")
public void getfile()
{
	serviceimpl.createcsv();
}
}
