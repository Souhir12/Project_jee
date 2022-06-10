package tn.iit.util;


import tn.iit.authentification.model.Groupe;
import tn.iit.authentification.model.User;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.naming.factory.BeanFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
 


public class UserDAO {
	public User geById(int id) {
        Transaction transaction = null;
        User user = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
        	transaction = session.beginTransaction();
			// get an user object
        	user = (User) session.createQuery("FROM User U WHERE U.id = :id").setParameter("id", id)
                    .uniqueResult();
        	//user = session.get(User.class, id);
			// commit transaction
			transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
		return user;
    }
	public User geByUsername_Password(String us, String pass) {
        Transaction transaction = null;
        User user = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
        	transaction = session.beginTransaction();
			// get an user object
        	user = (User) session.createQuery("FROM User U WHERE U.username = :username and U.password = :password")
        			.setParameter("username", us)
        			.setParameter("password", pass)
                    .uniqueResult();
        	//user = session.get(User.class, id);
			// commit transaction
			transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
		return user;
    }
	public List<User> getUsers() {
        Session session =  HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        // We read labels record from database using a simple Hibernate
        // query, Hibernate Query Language (HQL).
        List<User> users = session.createQuery("from User", User.class).list();
        session.getTransaction().commit();

        return users;
        }
	/*public void listUsers( ){
		  Session session = HibernateUtil.getSessionFactory().openSession();
	      Transaction tx = null;
	      
	      try {
	         tx = session.beginTransaction();
	         List employees = session.createQuery("FROM User").list(); 
	         for (Iterator iterator1 = employees.iterator(); iterator1.hasNext();){
	            User employee = (User) iterator1.next(); 
	            System.out.print("First Name: " + employee.getFirstName()); 
	            System.out.print("  Last Name: " + employee.getLastName()); 
	            System.out.println("  password: " + employee.getPassword());
	            System.out.println("  user name: " + employee.getUsername());           
	         }
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } 
	   }
	   
	*/
	
	public void saveUser(User user) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.saveOrUpdate(user);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
	public User listUser() {
		 Transaction transaction = null;
	        User user = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();
	            // get an user object
	            user = (User) session.createQuery("FROM User").getResultList();            
	            // commit transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	        return user;

	/*    Session session = HibernateUtil.getSessionFactory().getCurrentSession();

	    session.beginTransaction();

	    List result = (List) session.createQuery("from User").list();

	    session.getTransaction().commit();

	    return result;*/
	}
	public static List<User> getAll() throws SQLException {
		List<User> liste =new ArrayList<>();
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		session.beginTransaction();

		List result = (List) session.createQuery("from User").uniqueResult();

		session.getTransaction().commit();
		return liste=result;
	}
	public boolean deleteUser(int id) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// Delete a persistent object
			User user = session.get(User.class, id);
			if (user != null) {
				session.delete(user);
			}
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return true;
	}
	public void updateUser(User user) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.update(user);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public boolean validate(String userName, String password) {
    	User currentUser = null;
    	
        Transaction transaction = null;
        User user = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            user = (User) session.createQuery("FROM User U WHERE U.username = :userName").setParameter("userName", userName)
                .uniqueResult();

            if (user != null && user.getPassword().equals(password) && user.getStatus().equals("1")) {
            	
                return true;
            }
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return false;
    }
    public boolean VerifActif (String userName, String password) {
    	User currentUser = null;
    	
        Transaction transaction = null;
        User user = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            user = (User) session.createQuery("FROM User U WHERE U.username = :userName").setParameter("userName", userName)
                .uniqueResult();

            if (user != null && user.getPassword().equals(password) && user.getStatus().equals("0")) {
            	
                return true;
            }
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return false;
    }
	/*public static List<Utilisateur> getAll() throws SQLException {
		List<Utilisateur> liste =new ArrayList<>();
		try {			
			String ps="select * from utilisateur";
			ResultSet rs =JDBCUtil.getStatement().executeQuery(ps);
			while (rs.next()) {
				Utilisateur a = new Utilisateur();
				a.setId(rs.getInt("id"));
				a.setLogin(rs.getString("login"));
				a.setNom(rs.getString("nom"));
				a.setPrenom(rs.getString("prenom"));
				a.setPwd(rs.getString("pwd"));
				liste.add(a);
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return liste;
	}
	public static void save(Utilisateur u) throws SQLException {

		String query = "insert into utilisateur(nom,prenom,login,pwd)" + "value('"
				+ u.getNom() + "','" + u.getPrenom() + "','" + u.getLogin() + "','" + u.getPwd() + "')";
		JDBCUtil.getStatement().executeUpdate(query);
	}

	public static void update(Utilisateur u) throws SQLException {
		String query = "update utilisateur set nom= '"+u.getNom()+"',prenom ='"+ u.getPrenom() +"',login ='"+ u.getLogin()+"',pwd ="+ u.getPwd() +" where id ="+u.getId();
		JDBCUtil.getStatement().executeUpdate(query);
	}
	public static void delete(Utilisateur u) throws SQLException {
		String query = "DELETE FROM utilisateur WHERE id ="+u.getId();
		JDBCUtil.getStatement().executeUpdate(query);
	}
	public static Utilisateur findByLoginPwd(String login, String pwd) throws SQLException {
		Utilisateur u = null;
		String query = "select * from utilisateur where login='" + login + "' and pwd='" + pwd + "'";
		ResultSet rs = JDBCUtil.getStatement().executeQuery(query);
		if (rs.next()) {
			u = new Utilisateur(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("login"),
					rs.getString("pwd"));
		}
		return u;
	}*/
}