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
			if( memo.getContent().length()>0){
				persist(memo);
			}
	}

	public Student findById(String id) {
		Criteria crit = getSession().createCriteria(Student.class);
		crit.add(Restrictions.eq("id", id));
		
		return (Student) crit.uniqueResult();
		
		
		/*Criteria crit = getSession().createCriteria(Student.class, "student");
		
		crit.setProjection(Projections.projectionList()
				.add(Projections.property("id"),"id")
				.add(Projections.property("firstName"), "firstName")
				.add(Projections.property("lastName"), "lastName")
				.add(Projections.property("kmFirstName"), "kmFirstName")
				.add(Projections.property("kmLastName"), "kmLastName")
				.add(Projections.property("gender"), "gender")
				).setResultTransformer(Transformers.aliasToBean(Student.class));
		crit.addOrder(Order.asc("birthDate"));*/
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
		String sql = "AGE(TO_DATE(BIRTH_DATE,'YYYYMMDD')) as birthDate";
		String sql2 = "(SELECT CONTENT FROM tb_memo WHERE STUDENT_ID = this_.STUDENT_ID ORDER BY REGISTER_DATE DESC LIMIT  1) as biography";
		
			
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
			crit.addOrder(Order.desc("id"));
			return (List<Student>) crit.list();
			
		
	}

	public void update(Student student, Memo memo) {
		Criteria crit = getSession().createCriteria(Student.class);
		
		crit.add(Restrictions.eq("id", student.getId()));				
		Student s = (Student)  crit.uniqueResult();
		
		s.setFirstName(student.getFirstName());
		s.setLastName(student.getLastName());
		s.setKmFirstName(student.getKmFirstName());
		s.setKmLastName(student.getKmLastName());
		s.setGender(student.getGender());
		s.setBirthDate(student.getBirthDate());
		s.setBirthPlace(student.getBirthPlace());
		s.setBiography(student.getBiography());
		s.setPhone1(student.getPhone1());
		s.setPhone2(student.getPhone2());
		s.setEmail(student.getEmail());
		s.setCurrentAddr(student.getCurrentAddr());
		s.setMotherName(student.getMotherName());
		s.setMotherPhone(student.getMotherPhone());
		s.setFatherName(student.getFatherName());
		s.setFatherPhone(student.getFatherPhone());
		
		persist(s);
		
		if( memo.getContent().length()>0){
			persist(memo);
		}
		
	}

}
