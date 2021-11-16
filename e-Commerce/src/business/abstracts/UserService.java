package business.abstracts;

import entities.concretes.User;

public interface UserService {
	//Kaydolma:
	void signUp(User user);
	//Giriş:
	void signIn(User user);
}
