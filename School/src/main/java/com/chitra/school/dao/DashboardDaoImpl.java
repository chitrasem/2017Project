package com.chitra.school.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.chitra.school.model.Dashboard;

@Repository("dashboardDao")
@Transactional
public class DashboardDaoImpl extends AbstractDao<Integer, Object>  implements DashboardDao {
	private SessionFactory factory ;
	public List<Dashboard> list() {		
		Session session = factory.openSession();
		String sql = "SELECT TOT_STU FROM DASHBOARD";
		SQLQuery query = session.createSQLQuery(sql);
		query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);		
		
		return (List<Dashboard>) query.list();
	}

}
