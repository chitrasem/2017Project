package com.chitra.school.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.chitra.school.bean.DashboardBean;

@Repository("dashboardDao")
@Transactional
public class DashboardDaoImpl extends AbstractDao<Integer, Object>  implements DashboardDao {
	public List<DashboardBean> list() {		
		String sql = "SELECT "
				+ "AMT_US"
				+ ",AMT_KM"
				+ ",TOT_USER"
				+ ",TOT_STU "
				+ "FROM DASHBOARD";
		SQLQuery query = getSession().createSQLQuery(sql);// session.createSQLQuery(sql);
		query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);		
		
		return (List<DashboardBean>) query.list();
	}

}
