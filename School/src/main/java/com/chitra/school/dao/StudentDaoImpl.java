package com.chitra.school.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.chitra.school.model.Student;

@Repository("studentDao")
public class StudentDaoImpl extends AbstractDao<Integer, Student> implements StudentDao{

	
	@SuppressWarnings("unchecked")
	public List<Student> findAll(int userId, 
			String firstName, 
			String lastName, 
			String searchName, 
			int maxResults, 
			int firstResult) {
		
		Criteria crit = getSession().
				
				createCriteria(Student.class, "student");
				crit.setProjection(Projections.projectionList().
				add(Projections.property("student.id"),"id").
						add(Projections.property(lastName),"lastName").
						add(Projections.property(firstName), "firstName").
						add(Projections.property("student.gender"), "gender"));
		
				
				
		Criterion cFirstName = Restrictions.like(firstName, searchName);
		Criterion cLastName = Restrictions.like(lastName, searchName);
		LogicalExpression orExp = Restrictions.or(cFirstName, cLastName);
				crit.add(orExp);
				
				crit.add(Restrictions.eq("student.user.id", userId));
				crit.addOrder(Order.asc(lastName));
				crit.setMaxResults(maxResults);
				crit.setFirstResult(firstResult);
				
				crit.setResultTransformer(Transformers.aliasToBean(Student.class));
				
		
		return (List<Student>)crit.list();
		
		
	}

	public void save(Student student) {
		persist(student);
		
	}

	public Student findById(int id) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("id", id));
		
		return (Student) crit.uniqueResult();
	}

	public Student findByFirstName(String firstName) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("firstName", firstName));
        return (Student) crit.uniqueResult();
	}
	
	/**
	 * 
	 */
	public long countRecordListl(int userId, 
			String firstName, 
			String lastName, 
			String searchName) {
		
		Criteria query = getSession().
				createCriteria(Student.class, "student");
				query.setProjection(Projections.projectionList().
				add(Projections.rowCount()));				
				
		Criterion cFirstName = Restrictions.like(firstName, searchName);
		Criterion cLastName = Restrictions.like(lastName, searchName);
		LogicalExpression orExp = Restrictions.or(cFirstName, cLastName);
				query.add(orExp);				
				query.add(Restrictions.eq("student.user.id", userId));
				
		return (Long) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Student> findAll() {
		Criteria crit = getSession().createCriteria(Student.class, "student");
		
		return (List<Student>) crit.list();
	}

}
