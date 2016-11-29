package com.chitra.school.dao;

import java.util.List;

import org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction;
import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.chitra.school.model.Classroom;


@Repository("classroomDao")
@Transactional
public class ClassroomDaoImpl extends AbstractDao<String, Classroom> implements ClassroomDao {

	public void save(Classroom classroom) {
		// TODO Auto-generated method stub
		
	}

	public Classroom findClassroomById(String id) {
		
		Criteria crit = getSession().createCriteria(Classroom.class);
		
		crit.setProjection(Projections.projectionList());
		
		crit.add(Restrictions.eqOrIsNull("id", id));
		
		return (Classroom)crit.uniqueResult();
	}

	public List<Classroom> findAllClassrooms(String id) {
		
		Criteria crit = getSession().createCriteria(Classroom.class);
		
		crit.setProjection(Projections.projectionList());
		
		crit.add(Restrictions.eqOrIsNull("id", id));
		
		return (List<Classroom>) crit.list();
	}

	public void updateClassroom(Classroom classroom) {
		// TODO Auto-generated method stub
		
	}

}
