package com.chitra.school.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.chitra.school.entities.Grade;

@Repository("gradeDao")
@Transactional
@EnableTransactionManagement
public class GradeDaoImpl extends AbstractDao<Integer, Grade> implements GradeDao{

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Grade> getGrade() {
		Criteria crit = getSession().createCriteria(Grade.class);		
		return (List<Grade>) crit.list();
	}
	@Transactional
	public void saveGrade(Grade grade) {
		persist(grade);
	}

}
