package com.chitra.school.utils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

public class StudentIdGenerator implements IdentifierGenerator  {

	public Serializable generate(SessionImplementor session, Object arg1) throws HibernateException {

		
		String sql = "SELECT  CONCAT('STU', LPAD(CAST(FN_TB_UID_SEQ('STUDENT_ID') AS VARCHAR),7,'0')) AS STUDENT_ID";
		
		Connection connection = session.connection();
		try{
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				String id = rs.getString("STUDENT_ID");
				return id;
			}
		}catch(SQLException e){
			e.printStackTrace();
			
		}
		return null;
	}

}
