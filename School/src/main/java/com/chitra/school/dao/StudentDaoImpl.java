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
import com.chitra.school.utils.StringUtils;
import com.chitra.school.utils.UserUtil;

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
	public List<Student> findAll(
			String id,
			int maxResult, 
			int pageCount) {			
		
		
		
			Criteria crit = getSession().createCriteria(Student.class, "student");
			
			String query1 = "AGE(TO_DATE(BIRTH_DATE,'YYYYMMDD')) as birthDate";
			String query2 = "(SELECT CONTENT FROM tb_memo WHERE STUDENT_ID = this_.STUDENT_ID ORDER BY REGISTER_DATE DESC LIMIT  1) as biography";
			
			crit.setProjection(Projections.projectionList()
					.add(Projections.property("id"),"id")
					.add(Projections.property("firstName"), "firstName")
					.add(Projections.property("lastName"), "lastName")
					.add(Projections.property("kmFirstName"), "kmFirstName")
					.add(Projections.property("kmLastName"), "kmLastName")
					.add(Projections.property("gender"), "gender")
					.add(Projections.property("phone1"), "phone1")
					.add(Projections.property("birthDate"), "birthDate")
					.add(Projections.property("imageUrl"), "imageUrl")
					
					
					/*
					.add(Projections.sqlProjection(query2, 
							new String[] {"birthDate"}, 
							new Type[] { StandardBasicTypes.STRING}))
					*/
					.add(Projections.sqlProjection(query2, 
							new String[]{"biography"}, 
							new Type[] {StandardBasicTypes.STRING}))
					).setResultTransformer(Transformers.aliasToBean(Student.class));			
			
				crit.add(Restrictions.ilike("id", "%"+id+"%"));

			crit.setMaxResults(maxResult);
			if(pageCount >0){
				int  firstResult = (pageCount-1)*maxResult;
				crit.setFirstResult(firstResult);
			}
			crit.addOrder(Order.desc("id"));
			
			
			return (List<Student>) crit.list();
			
		
	}
	
	public long totalRecord(String id){
		Criteria crit = getSession().createCriteria(Student.class, "student");		
		crit.setProjection(Projections.projectionList()
				.add(Projections.rowCount()));	
		
		crit.add(Restrictions.ilike("id", "%"+id+"%"));
		return (Long) crit.uniqueResult();
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
		
		s.setChangeDate(StringUtils.getSystemDate() );
		s.setChangePerson(UserUtil.getPrincipal());
		
		persist(s);
		
		if( memo.getContent().length()>0){
			persist(memo);
		}
		
	}

	public long totalStudentByCLSroomId(
			String clsroomId) {
		Criteria crit = getSession().createCriteria(Student.class, "s");
		crit.setProjection(Projections.projectionList()
				.add(Projections.rowCount())
				);
		crit.add(Restrictions.eq("s.classroom.id", clsroomId));
		return (Long) crit.uniqueResult() ;
	}

	@SuppressWarnings("unchecked")
	public List<Student> findStudentByCLSroomID(String clsroomId, int maxResult, int pageCount) {

		Criteria crit = getSession().createCriteria(Student.class, "s");
		
		crit.setProjection(Projections.projectionList()
				.add(Projections.property("s.id"),"id")
				.add(Projections.property("s.firstName"),"firstName")
				.add(Projections.property("s.lastName"),"lastName")
				.add(Projections.property("s.kmFirstName"),"kmFirstName")
				.add(Projections.property("s.kmLastName"),"kmLastName")
				.add(Projections.property("s.gender"),"gender")
				);
		crit.addOrder(Order.desc("s.id"));
		crit.add(Restrictions.eq("s.classroom.id", clsroomId));
		
		
		crit.setResultTransformer(Transformers.aliasToBean(Student.class));	
		
		crit.setMaxResults(maxResult);
		if(pageCount >0){
			int  firstResult = (pageCount-1)*maxResult;
			crit.setFirstResult(firstResult);
		}
		
		return (List<Student>) crit.list();
	}

}
