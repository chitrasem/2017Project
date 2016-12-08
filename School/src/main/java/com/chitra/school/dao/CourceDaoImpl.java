package com.chitra.school.dao;

import java.util.List;

import org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.chitra.school.model.Cources;
import com.chitra.school.model.Student;


@Repository("classroomDao")
@Transactional
public class CourceDaoImpl extends AbstractDao<String, Cources> implements CourceDao {

	
	public void save(Cources classroom) {
	
		persist(classroom);
		
	}

	public Cources findClassroomById(String id) {
		
		Criteria crit = getSession().createCriteria(Cources.class);
		
		crit.setProjection(Projections.projectionList());
		
		crit.add(Restrictions.eqOrIsNull("id", id));
		
		return (Cources)crit.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Cources> findAllClassrooms() {
		
		Criteria crit = getSession().createCriteria(Cources.class, "cl");
		
		crit.setProjection(Projections.projectionList()
				.add(Projections.property("cl.id"), "id")
				.add(Projections.property("cl.classroom"), "classroom")
				
				);	
		crit.addOrder(Order.desc("cl.id"));
		crit.setResultTransformer(Transformers.aliasToBean(Cources.class));	
		
		return (List<Cources>) crit.list();
	}

	public void updateClassroom(Cources classroom) {
		persist(classroom);
	}

}
