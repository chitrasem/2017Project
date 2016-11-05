package com.chitra.school.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.chitra.school.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
 
@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    public User findById(int id) {
        return getByKey(id);
    }
 
    public User findBySSO(String sso) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("ssoId", sso));
        return (User) crit.uniqueResult();
    }

	public void save(User user) {

		 user.setPassword(passwordEncoder.encode(user.getPassword()));
		 persist(user);
	}

	@SuppressWarnings("unchecked")
	public List<User> findAllUsers() {
		Criteria crit = createEntityCriteria();
		 //Criteria crit = getSession().createCriteria(User.class);
		
		return (List<User>) crit.list();
	}

	public void deleteUserById(int id) {

		Query query = getSession().createQuery(
				"delete from Employee where id = :id");
		query.setInteger("id", id);
		query.executeUpdate();
		
	}
 
     
}
