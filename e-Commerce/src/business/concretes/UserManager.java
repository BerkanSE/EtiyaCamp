package business.concretes;

import business.abstracts.UserCheckService;
import business.abstracts.UserService;
import business.abstracts.VerificationService;
import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class UserManager implements UserService{

	private UserDao userDao;
	UserCheckService userCheckService;
	VerificationService verificationService;
	
	public UserManager(UserDao userDao, UserCheckService userCheckService, VerificationService verificationService) {
		this.userDao = userDao;
		this.userCheckService = userCheckService;
		this.verificationService = verificationService;
	}

	@Override
	public void signUp(User user) {
		if (userCheckService.isValid(user) == false) {
			System.out.println("Kayıt Başarılı!");
			userDao.add(user);
		}else {
			System.out.println("Email veya Şifre yanlış!");
		}
		
	}

	@Override
	public void signIn(User user) {
		if (userDao.getEmail(user.getEmail()) == true && userDao.getPassword(user.getPassword()) == true) {
			System.out.println("Giriş başarılı");
		}else {
			System.out.println("Giriş başarısız");
		}
		
	}

}
