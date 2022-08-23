package com.spring.app.persistence.dao.Impl;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.app.persistence.dao.AbstractDao;
import com.spring.app.persistence.dao.UserDao;
import com.spring.app.persistence.entity.User;

@Repository
@Transactional
public class UserDaoImpl extends AbstractDao<Long, User> implements UserDao {

	@SuppressWarnings("unchecked")
	public List<User> getAllUser() {
		return getSession().createQuery("SELECT * FROM users").list();
	}
	
	@SuppressWarnings("rawtypes")
	public User getUserByUsername(String username) {
		Query query = getSession().createQuery("SELECT u FROM users u WHERE u.name = :username");
		query.setParameter("username", username);
		return (User) query.uniqueResult();
	}
	
	@SuppressWarnings("rawtypes")
	public User getUserByEmail(String email) {
		Query query = getSession().createQuery("SELECT u FROM users u WHERE u.email = :email");
		query.setParameter("email", email);
		return (User) query.uniqueResult();
	}
	
	public int getUserCount() {
		return getAllUser().size();
	}
	
	public User getUserById(long id) {
		return getById(id);
	}

	public long createUser(User user) {
		return (Long) create(user);
	}

	public void updateUser(User user) {
		update(user);
	}

	public void deleteUser(User user) {
		delete(user);
	}

	public void deleteUserById(long id) {
		deleteById(id);
	}

}
