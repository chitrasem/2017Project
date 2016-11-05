package com.chitra.school.id;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

public class MemoIdGenerator implements IdentifierGenerator {

	public Serializable generate(SessionImplementor compo, Object obj) throws HibernateException {
		String sql = "SELECT  CONCAT('MEM', LPAD(CAST(FN_TB_UID_SEQ('MEMO_ID') AS VARCHAR),7,'0')) AS MEMO_ID";
		Connection connection = compo.connection();
		try{
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				String id = rs.getString("MEMO_ID");
				return id;
			}
		}catch(SQLException e){
			e.printStackTrace();
			
		}
		return null;
	}

}
