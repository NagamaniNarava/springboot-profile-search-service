package com.learninggeeks.profilesearch.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learninggeeks.profilesearch.entity.Applicant;


@Repository
public class ProfileSearchDAOImpl implements ProfileSearchDAO {

	private EntityManager entityManager;
	
	// set up constructor injection
	@Autowired
	public ProfileSearchDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	public List<Applicant> getApplicantsBySkills(List<String> skills) {
		System.out.println(skills);
		String lastSkill = skills.get(skills.size() - 1);
		skills.remove(skills.size()-1);
		System.out.println(skills+":"+skills.size());
		
		StringBuffer sb = new StringBuffer();
		sb.append("select * from applicant a where ");
		if(skills.size()>0) {
			skills.stream().forEach(sk->sb.append("exists (select * from applicant_skills where applicant_id = a.id  and skills ="+"'"+sk+"') and "));
		}
		sb.append("exists (select * from applicant_skills where applicant_id = a.id  and skills ="+"'"+lastSkill+"')");
		
		System.out.println("Query:"+sb.toString());
		
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Applicant> theQuery = currentSession.createNativeQuery(sb.toString(),Applicant.class);
		List<Applicant> Applicants = theQuery.getResultList();
		return Applicants;
	}
}
