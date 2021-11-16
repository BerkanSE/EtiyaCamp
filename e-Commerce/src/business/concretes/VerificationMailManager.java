package business.concretes;

import business.abstracts.VerificationService;
import entities.concretes.User;

public class VerificationMailManager implements VerificationService{

	@Override
	public void sendVerificationMail(User user) {
		System.out.println("Doğrulama işlemi gönderildi: " + user.getEmail());
		
	}

	@Override
	public void verifyMail(User user) {
		System.out.println(user.getEmail() + " doğrulama başarılı");
		
	}

}
