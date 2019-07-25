import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.appmusic.entity.Users;

public class UserTest {
	
	public static void main(String[] args) {
		
	 EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("AppMusic");
	 EntityManager entityManager = entityManagerFactory.createEntityManager();
	 
	 Users user = new Users("John","John@example.com","Password");
	 entityManager.getTransaction().begin();
	 
	 entityManager.persist(user);
	 entityManager.getTransaction().commit();
	 
	 entityManager.close();
	 entityManagerFactory.close();
	 
	 System.out.println("Object has been persisted !");
	 
	 
		
		
	}

}
