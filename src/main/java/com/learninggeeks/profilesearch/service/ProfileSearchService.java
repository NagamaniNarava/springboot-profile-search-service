package com.learninggeeks.profilesearch.service;

import java.util.List;

import com.learninggeeks.profilesearch.entity.Applicant;


public interface ProfileSearchService {
	public List<Applicant> getApplicantsBySkills(List<String> skills);
}
