package service;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import domain.User;
import model.OfferModel;
import model.UserModel;
import repository.OfferDao;

@Service
@Transactional
public class OfferService {

	@Resource
	private OfferDao offerDao;

	@Resource
	private UserService userService;

	public List<OfferModel> getOfferByUser(UserModel userModel) {
		List<OfferModel> offersModel = new LinkedList<>();

		User user = userService.getUserByUsernameAndPassword(userModel);
		// for(Offer offer : user.getOffer())
		return offersModel;
	}
}