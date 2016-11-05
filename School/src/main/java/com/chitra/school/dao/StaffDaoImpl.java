package com.chitra.school.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.chitra.school.model.Staff;

@Repository("StaffDao")
@Transactional
public class StaffDaoImpl extends AbstractDao<Integer, Object> implements StaffDao {

	public Staff findStaffByID(String id) {
		Criteria crit = getSession().createCriteria(Staff.class);
		
		crit.add(Restrictions.eq("id", id));
		return (Staff) crit.uniqueResult();
	}
	public List<Staff> findAllStaff() {
		Criteria crit = getSession().createCriteria(Staff.class, "staff");
		return (List<Staff>) crit.list();
	}

	public void saveStaff(Staff staff) {
		persist(staff);
		
	}

}
