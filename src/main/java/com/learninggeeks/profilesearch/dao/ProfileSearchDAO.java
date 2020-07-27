package com.learninggeeks.profilesearch.dao;

import java.util.List;

import com.learninggeeks.profilesearch.entity.Applicant;


public interface ProfileSearchDAO {
	
	public List<Applicant> getApplicantsBySkills(List<String> skills);

}
