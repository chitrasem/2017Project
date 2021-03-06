package com.chitra.school.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.chitra.school.entities.Memo;

@Repository("memoDao")
@Transactional
public class MemoDaoImple extends AbstractDao<Integer, Memo> implements MemoDao {

	public void save(Memo memo) {
		persist(memo);
		
	}

	@SuppressWarnings("unchecked")
	public List<Memo> listMemoByStudentId(String student_id) {
		Criteria crit = getSession().createCriteria(Memo.class, "memo");
		crit.setProjection(Projections.projectionList()
				.add(Projections.property("content"), "content")
				.add(Projections.property("registerPerson"),"registerPerson")
				.add(Projections.property("registerDate"), "registerDate")
				);
		crit.add(Restrictions.eq("memo.student.id", student_id));
		crit.addOrder(Order.desc("registerDate"));
		crit.setMaxResults(5);
		
		crit.setResultTransformer(Transformers.aliasToBean(Memo.class));
				
		return (List<Memo>)crit.list();
	}

}
