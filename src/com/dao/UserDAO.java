package com.dao;
 
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.bean.User;
 
public class UserDAO {
 
    /**
     * @param args
     */
//	public User user;
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Hello");
    EntityManager em = emf.createEntityManager();
	
	public void insere(User user) {
		try {			
			em.getTransaction().begin();                 
	        em.persist(user);
	        em.getTransaction().commit();	
		 }
        catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }        
	}
		
	public void altera(User user) {
		try {			
			em.getTransaction().begin();                 
	        em.merge(user);
	        em.getTransaction().commit();	
		 }
        catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }        
	}
	
	public void remove(User user) {		
		try {			
			em.getTransaction().begin();                 
	        em.remove(user);
	        em.getTransaction().commit();	
		 }
        catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }        
	}
	
	public User busca(int id) {
		try {			          
	        return em.find(User.class, id);	       
		}
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        
	}
		
	@SuppressWarnings("unchecked")
	public List<User> lista(){
		return  (List<User>) em.createQuery("SELECT u FROM User u").getResultList();
	}
}