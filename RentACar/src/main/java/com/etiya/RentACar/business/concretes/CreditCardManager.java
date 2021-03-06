package com.etiya.RentACar.business.concretes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.RentACar.business.abstracts.CreditCardService;
import com.etiya.RentACar.business.dtos.CreditCardDto;
import com.etiya.RentACar.business.requests.creditCard.CreateCreditCardRequest;
import com.etiya.RentACar.business.requests.creditCard.DeleteCreditCardRequest;
import com.etiya.RentACar.business.requests.creditCard.UpdateCreditCardRequest;
import com.etiya.RentACar.core.utilities.business.BusinessRules;
import com.etiya.RentACar.core.utilities.mapping.ModelMapperService;
import com.etiya.RentACar.core.utilities.results.DataResult;
import com.etiya.RentACar.core.utilities.results.ErrorResult;
import com.etiya.RentACar.core.utilities.results.Result;
import com.etiya.RentACar.core.utilities.results.SuccessDataResult;
import com.etiya.RentACar.core.utilities.results.SuccessResult;
import com.etiya.RentACar.dataAccess.abstracts.CreditCardDao;
import com.etiya.RentACar.entites.CreditCard;


@Service
public class CreditCardManager implements CreditCardService{

	private CreditCardDao creditCardDao;
	private ModelMapperService modelMapperService;
	
	@Autowired
	public CreditCardManager(CreditCardDao creditCardDao, ModelMapperService modelMapperService) {
		super();
		this.creditCardDao = creditCardDao;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public DataResult<List<CreditCardDto>> getAll() {
		List<CreditCard> result = this.creditCardDao.findAll();
		List<CreditCardDto> response = result.stream().map(creditCard->modelMapperService.forDto()
				.map(creditCard,CreditCardDto.class)).collect(Collectors.toList());
		return new SuccessDataResult<List<CreditCardDto>>(response);
	}

	@Override
	public Result add(CreateCreditCardRequest createCreditCardRequest) {
		Result result = BusinessRules.run(checkCreditCardFormat(createCreditCardRequest.getCardNumber()),
				checkCardNumberByCardNumber(createCreditCardRequest.getCardNumber()));
		if(result!=null) {
			return result;
		}
		CreditCard creditCard = modelMapperService.forRequest().map(createCreditCardRequest, CreditCard.class);
		this.creditCardDao.save(creditCard);
		return new SuccessResult();
	}

	@Override
	public Result update(UpdateCreditCardRequest updateCreditCardRequest) {
		CreditCard result = modelMapperService.forRequest().map(updateCreditCardRequest, CreditCard.class);
		this.creditCardDao.save(result);
		return new SuccessResult();
	}

	@Override
	public Result delete(DeleteCreditCardRequest deleteCreditCardRequest) {
		//CreditCard result = modelMapperService.forRequest().map(deleteCarRequest, CreditCard.class);
		this.creditCardDao.deleteById(deleteCreditCardRequest.getCreditCardId());
		return new SuccessResult();
	}
	private Result checkCreditCardFormat(String cardNumber) {
		
		String regex = "^(?:(?<visa>4[0-9]{12}(?:[0-9]{3})?)|" + "(?<mastercard>5[1-5][0-9]{14})|"
				+ "(?<discover>6(?:011|5[0-9]{2})[0-9]{12})|" + "(?<amex>3[47][0-9]{13})|"
				+ "(?<diners>3(?:0[0-5]|[68][0-9])?[0-9]{11})|" + "(?<jcb>(?:2131|1800|35[0-9]{3})[0-9]{11}))$";
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(cardNumber);
		if (!matcher.find()) {
			return new ErrorResult("Kredi kart?? yanl???? formatta girildi");
		}

		return new SuccessResult();

	}
	private Result checkCardNumberByCardNumber(String cardNumber) {

		if (this.creditCardDao.existsByCardNumber(cardNumber)) {
			return new ErrorResult("Bu kart numaras?? kay??tl??");
		}
		return new SuccessResult();
	}
	

}
