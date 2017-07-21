package com.chitra.school.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.chitra.school.entities.Course;
import com.chitra.school.utils.AliasToBeanNestedResultTransformer;


@Repository("CourseDao")
@Transactional
public class CourseDaoImpl extends AbstractDao<String, Course> implements CourseDao {

	
	public void save(Course Course) {
	
		persist(Course);
		
	}

	public Course findCourseById(String id) {
		
		Criteria crit = getSession().createCriteria(Course.class);
		
		crit.setProjection(Projections.projectionList());
		
		crit.add(Restrictions.eqOrIsNull("id", id));
		
		return (Course)crit.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Course> findAllCourses() {
		
		//String query = "(SELECT ACY.ACADEMIC_YEAR from TB_ACADEMIC_YEAR ACY where ACY.ID = THIS_.ACY_ID) AS myAlias";
		
		Criteria crit = getSession().createCriteria(Course.class, "c");
		crit.createAlias("academicYear", "acy");
		crit.setProjection(Projections.projectionList()
				.add(Projections.property("c.id"), "id")
				.add(Projections.property("c.course"), "course")
				.add(Projections.property("acy.academicYear"),"academicYear.academicYear"));
				//.add(Projections.property("acy.id"),"id")
			/*	.add(Projections.sqlProjection(query, 
						new String[]{"myAlias"}, 
						new Type[] {StandardBasicTypes.STRING}))
				
				)*/
		crit.setResultTransformer( new AliasToBeanNestedResultTransformer(Course.class) );
		crit.add(Restrictions.eq("c.state", "Active"));
		crit.addOrder(Order.asc("c.course"));
		return (List<Course>) crit.list();
		
	}

	public void updateCourse(Course Course) {
		persist(Course);
	}

}
