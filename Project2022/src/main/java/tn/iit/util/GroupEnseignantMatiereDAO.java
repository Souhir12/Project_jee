package tn.iit.util;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import tn.iit.authentification.model.GroupeEnseignantMatiere;
import tn.iit.authentification.model.Groupe;
import tn.iit.authentification.model.Matiere;
import tn.iit.authentification.model.User;

public class GroupEnseignantMatiereDAO {
	public boolean deleteGroupe(int id) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// Delete a persistent object
			GroupeEnseignantMatiere groupe = session.get(GroupeEnseignantMatiere.class, id);
			if (groupe != null) {
				session.delete(groupe);
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
	public GroupeEnseignantMatiere geById(int id) {
		Transaction transaction = null;
		GroupeEnseignantMatiere groupe = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			groupe = (GroupeEnseignantMatiere) session.createQuery("FROM GroupeEnseignantMatiere G WHERE G.id = :id").setParameter("id", id)
					.uniqueResult();
			// user = session.get(User.class, id);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return groupe;
	}
	public List<User> listGroupnseignant() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		// We read labels record from database using a simple Hibernate
		// query, Hibernate Query Language (HQL).
		List<User> users = session.createQuery("select  u.firstName as name , g.label as group , m.label as mat ,gem.id as idg FROM GroupeEnseignantMatiere gem, User u,Groupe g,Matiere m  "
				+ " WHERE gem.enseignant_id=u.id and gem.groupe_id=g.id and gem.matiere_id=m.id ").list();
		session.getTransaction().commit();

		return users;
	}
	public List<User> listGroupMatiere2(User user) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		// We read labels record from database using a simple Hibernate
		// query, Hibernate Query Language (HQL).
		List<User> users = session.createQuery("select g.label as group , m.label as mat ,gem.id as idg FROM GroupeEnseignantMatiere gem, User u,Groupe g,Matiere m  "
				+ " WHERE gem.enseignant_id=u.id and gem.groupe_id=g.id and gem.matiere_id=m.id  and  gem.enseignant_id = :enseignant_id").setParameter("enseignant_id", user).list();
		session.getTransaction().commit();

		return users;
	}
	public void save_update_Groupe(GroupeEnseignantMatiere groupe) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.saveOrUpdate(groupe);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
	public List<Groupe> listGroup() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		// We read labels record from database using a simple Hibernate
		// query, Hibernate Query Language (HQL).
		List<Groupe> groupes = session.createQuery("from Groupe", Groupe.class).list();
		session.getTransaction().commit();

		return groupes;
	}
	
	public List<Matiere> listMatiere() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		// We read labels record from database using a simple Hibernate
		// query, Hibernate Query Language (HQL).
		List<Matiere> matieres = session.createQuery("from Matiere", Matiere.class).list();
		session.getTransaction().commit();

		return matieres;
	}
	public List<User> listUser() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		// We read labels record from database using a simple Hibernate
		// query, Hibernate Query Language (HQL).
		List<User> users = session.createQuery("FROM User u WHERE u.role = :role").setParameter("role", "1").list();
		session.getTransaction().commit();

		return users;
	}


}
