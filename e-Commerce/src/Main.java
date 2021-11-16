
import business.concretes.UserCheckManager;
import business.concretes.UserManager;
import business.concretes.VerificationMailManager;
import dataAccess.concretes.HibernateUserDao;
import entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		User user = new User();
		user.setId(1);
		user.setFirstName("Berkan");
		user.setLastName("Senger");
		user.setEmail("berkansenger@gmail.com");
		user.setPassword("1234567");
		
		UserManager userManager = new UserManager(new HibernateUserDao(), new UserCheckManager(), new VerificationMailManager());
		userManager.signUp(user);
		userManager.signIn(user);
	}

}
