package com.learninggeeks.profilesearch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learninggeeks.profilesearch.dao.ProfileSearchDAO;
import com.learninggeeks.profilesearch.entity.Applicant;

@Service
public class ProfileSearchServiceImpl implements ProfileSearchService {

	@Autowired
	private ProfileSearchDAO profileSearchDAO;
	@Override
	@Transactional
	public List<Applicant> getApplicantsBySkills(List<String> skills) {
		List<Applicant> Applicants = profileSearchDAO.getApplicantsBySkills( skills);
		return Applicants;
	}
	
}
