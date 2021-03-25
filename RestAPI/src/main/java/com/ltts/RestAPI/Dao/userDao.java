//package com.ltts.RestAPI.Dao;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.Iterator;
//import java.util.List;
//import org.springframework.stereotype.Component;
//
//import com.ltts.RestAPI.model.User;
//
//@Component
//public class userDao {
//	public static int usersCount = 5;
//	private static List<User> users = new ArrayList<>();
//
//	static {
//		users.add(new User(1, "John", new Date()));
//		users.add(new User(2, "Robert", new Date()));
//		users.add(new User(3, "Adam", new Date()));
//		users.add(new User(4, "Andrew", new Date()));
//		users.add(new User(5, "Jack", new Date()));
//	}
//
//	public List<User> findAll() {
//		return users;
//	}
//
//	public User save(User user) {
//		if (user.getId() == null) {
//			user.setId(++usersCount);
//		}
//		users.add(user);
//		return user;
//	}
//
//	public User findOne(int id) {
//		for (User user : users) {
//			if (user.getId() == id)
//				return user;
//		}
//		return null;
//	}
//
//	public User deleteById(int id) {
//		Iterator<User> iterator = users.iterator();
//		while (iterator.hasNext()) {
//			User user = iterator.next();
//			if (user.getId() == id) {
//				iterator.remove();
//				return user; // returns the deleted resource back
//			}
//		}
//		return null;
//	}
//}








package com.ltts.RestAPI.Dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ltts.RestAPI.model.*;


@Repository
public class userDao {
	
	@Autowired
	private EntityManager em;
	
	@Autowired
	private SessionFactory sf;
	
	
	public boolean InsertUser(User m) {
		boolean b=false;
		Session s=null;
		try {
			s=sf.openSession();
			s.beginTransaction();
			
			s.save(m);
			s.getTransaction().commit();
			
		}
		catch(Exception e) {
			System.out.println("Exception "+e);
			b=true;
		}	
		return b;
	}
	
//	
//	public User getMemberByEmpId(String emp_id) {
//		User e = (User)sf.openSession().get(User.class, emp_id);
//		return e;
//	
//	}
//	
	public boolean updateUser(int id, String Name){
	      Session session = sf.openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         User user = 
	         (User)session.get(User.class, id); 
	         user.setName(Name);
	         session.update(user); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
		return false;
	   }
	
	@SuppressWarnings("unchecked")
	public List<User> list() {
		Session session = this.sf.openSession();
		List<User> personList = session.createQuery("from User").list();
		session.close();
		return personList;
	}

	
	public User getMemberByEmpId(Integer emp_id) {
		User e = (User)sf.openSession().get(User.class, emp_id);
		return e;
	
	}
	
}









