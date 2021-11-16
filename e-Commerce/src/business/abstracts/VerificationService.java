package business.abstracts;

import entities.concretes.User;

public interface VerificationService {
	void sendVerificationMail(User user);
	void verifyMail(User user);
}
