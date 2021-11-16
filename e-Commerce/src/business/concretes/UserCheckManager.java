package business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import business.abstracts.UserCheckService;
import entities.concretes.User;

public class UserCheckManager implements UserCheckService{

	List<String> listOfEmail = new ArrayList<String>();
	
	@Override
	public boolean checkFirstName(User user) {
		if (user.getFirstName().length() < 2) {
			//Yanlıs girilen değer 
			System.out.println("Ad en az 2 karakterden oluşmalıdır.");
			return false;
		}
		return true;
	}

	@Override
	public boolean checkLastName(User user) {
		if (user.getLastName().length() < 2) {
			System.out.println("Soyadı en az 2 karakterden oluşmalıdır.");
			return false;
		}
		return true;
	}

	@Override
	public boolean checkPassword(User user) {
		if (user.getPassword().isEmpty()) {
			System.out.println("Lütfen şifre giriniz.");
			return false;
		}else if (user.getPassword().length() < 6) {
				System.out.println("Parola en az 6 karakterden oluşmalıdır.");
				return false;
		}
		
		return true;
	}

	@Override
	public boolean checkEmail(User user) {
		String regex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		if (user.getEmail().isEmpty()) {
			System.out.println("Email alanı boş geçilemez.");
			return false;
		}
		else if(pattern.matcher(user.getEmail()).find() == false) {
			System.out.println("Girilen mail adresi format ile uyumlu değildir.");
			return false;
		}
		return true;
	}

	@Override
	public boolean uniqueEmail(User user) {
		boolean result = true;
		if (listOfEmail.contains(user.getEmail())) {
			System.out.println("Lütfen farklı bir e-mail adresi deneyiniz. Bu email adresi sisteme kayıtlıdır. ");
			return false;		}
		else {
			result = true;
			listOfEmail.add(user.getEmail());
		}
		return result;
	}

	@Override
	public boolean isValid(User user) {
		//isValid true ise kaydol
		if (checkFirstName(user) && checkLastName(user)
				&& checkEmail(user) && checkPassword(user)
				&& uniqueEmail(user)) {
			return true;
		}
		return false;
	}

}
