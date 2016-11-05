package com.chitra.school.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.Type;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.chitra.school.model.Memo;
import com.chitra.school.model.Student;

@Repository("studentDao")
@Transactional
public class StudentDaoImpl extends AbstractDao<Integer, Object> implements StudentDao{

	
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

	public void save(Student student, Memo memo) {
	
			persist(student);
			if(memo.getContent() != null){
				persist(memo);
			}
	}

	public Student findById(String id) {
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
		String sql = "AGE(TO_DATE(BIRTH_DATE,'YYYY-MM-DD')) as birthDate";
		String sql2 = "(SELECT CONTENT FROM tb_memo WHERE STUDENT_ID = this_.STUDENT_ID ORDER BY REGISTER_DATE DESC LIMIT  1) as biography";
		try {
			
			Criteria crit = getSession().createCriteria(Student.class, "student");
			
			crit.setProjection(Projections.projectionList()
					.add(Projections.property("id"),"id")
					.add(Projections.property("firstName"), "firstName")
					.add(Projections.property("lastName"), "lastName")
					.add(Projections.property("kmFirstName"), "kmFirstName")
					.add(Projections.property("kmLastName"), "kmLastName")
					.add(Projections.property("gender"), "gender")
					.add(Projections.sqlProjection(sql2, 
							new String[]{"biography"}, 
							new Type[] {StandardBasicTypes.STRING}))
					.add(Projections.sqlProjection(sql, 
							new String[] {"birthDate"}, 
							new Type[] { StandardBasicTypes.STRING}))
					).setResultTransformer(Transformers.aliasToBean(Student.class));
			crit.addOrder(Order.asc("birthDate"));
			return (List<Student>) crit.list();
			
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

}
