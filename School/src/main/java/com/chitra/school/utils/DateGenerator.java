package com.chitra.school.utils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

public class DateGenerator implements IdentifierGenerator {
	public Serializable generate(SessionImplementor session, Object object) throws HibernateException {
		// TODO Auto-generated method stub
		String sql = "SELECT TO_CHAR(NOW(), 'YYYYMMDDHH24MISS') AS DATE_GENERATOR";
		Connection connection = session.connection();
		try{
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				String dateGenerator = rs.getString("DATE_GENERATOR");
				return dateGenerator;
			}
		}catch(SQLException e){
			e.printStackTrace();
			
		}
		return null;
	}

}
