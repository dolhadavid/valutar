package controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import model.OfferModel;
import model.TodoModel;
import model.UserModel;
import service.DemandService;
import service.OfferService;
import util.SessionUtil;

@RestController
@RequestMapping("/offers")
public class OfferController {

	@Resource
	private OfferService offerService;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<OfferModel> getUserOffers() {
		UserModel userModel = (UserModel) SessionUtil.getInstance().session().getAttribute("user");
		if (userModel != null) {
			return null;
		} else {
			return null;
		}
	}

	@RequestMapping(method = RequestMethod.POST)
	public OfferModel addOffer(@RequestBody OfferModel offerModel) {
		UserModel userModel = (UserModel) SessionUtil.getInstance().session().getAttribute("user");
		if (userModel != null) {
			return null;
		} else {
			return null;
		}
	}

}
