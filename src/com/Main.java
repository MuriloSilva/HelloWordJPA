package com;
 
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
 
public class Main {
 
    /**
     * @param args
     */
	public User user;
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Hello");
    EntityManager em = emf.createEntityManager();
	
	public void insere(User user) {
		try {			
			this.user = user;
			em.getTransaction().begin();                 
	        em.persist(user);
	        em.getTransaction().commit();	
		 }
        catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
        finally{
            emf.close();
        }
	}
	
	
	public void altera(User user) {
		try {			
			this.user = user;
			em.getTransaction().begin();                 
	        em.merge(user);
	        em.getTransaction().commit();	
		 }
        catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
        finally{
            emf.close();
        }
	}
	
	public void remove(User user) {		
		try {			
			this.user = user;
			em.getTransaction().begin();                 
	        em.remove(user);
	        em.getTransaction().commit();	
		 }
        catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
        finally{
            emf.close();
        }
	}
	
	public User busca(long id) {
		try {			          
	        return em.find(User.class, id);	       
		}
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        finally{
            emf.close();
        }
	}
	
	
	@SuppressWarnings("unchecked")
	public List<User> lista(){
		return  (List<User>) em.createQuery("SELECT u FROM User u").getResultList();
	}
	
    public static void main(String[] args) {
    	User user = new User();
    	user.setName("Murilo Silva");
    	user.setPassword("PingaPura");
    	Main daoUser = new Main();
    	daoUser.insere(user);
    	System.out.println(user);
    	System.out.println("Lista todos usuarios...");
    	for(Object usuario : daoUser.lista()) {
    		System.out.println(usuario);
    	}
    	
    }
}