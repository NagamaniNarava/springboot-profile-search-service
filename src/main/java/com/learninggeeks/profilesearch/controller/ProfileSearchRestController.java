package com.learninggeeks.profilesearch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learninggeeks.profilesearch.entity.Applicant;
import com.learninggeeks.profilesearch.service.ProfileSearchService;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/search")
public class ProfileSearchRestController {	
	
	@Autowired
	private ProfileSearchService profileSearchService;
	
	@PostMapping("/skillsearch")
	public List<Applicant> getApplicants(@RequestBody List<String> skills) {
		System.out.println(skills);
		List<Applicant> applicants = profileSearchService.getApplicantsBySkills(skills);
		System.out.println("debug:"+applicants);
		return applicants;
	}
}