package com.chitra.school.dao;

import java.util.List;

import org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction;
import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.chitra.school.model.Classroom;
import com.chitra.school.model.Student;


@Repository("classroomDao")
@Transactional
public class ClassroomDaoImpl extends AbstractDao<String, Classroom> implements ClassroomDao {

	
	public void save(Classroom classroom) {
	
		persist(classroom);
		
	}

	public Classroom findClassroomById(String id) {
		
		Criteria crit = getSession().createCriteria(Classroom.class);
		
		crit.setProjection(Projections.projectionList());
		
		crit.add(Restrictions.eqOrIsNull("id", id));
		
		return (Classroom)crit.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Classroom> findAllClassrooms() {
		
		Criteria crit = getSession().createCriteria(Classroom.class, "cl");
		
		crit.setProjection(Projections.projectionList()
				.add(Projections.property("cl.id"), "id")
				.add(Projections.property("cl.classroom"), "classroom")
				.add(Projections.property("cl.students.firstName"), "firstName")
				);		
		
		crit.setResultTransformer(Transformers.aliasToBean(Classroom.class));	
		
		return (List<Classroom>) crit.list();
	}

	public void updateClassroom(Classroom classroom) {
		// TODO Auto-generated method stub
		
	}

}
