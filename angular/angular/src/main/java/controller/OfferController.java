package controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import model.DemandModel;
import model.UserModel;
import service.DemandService;
import util.SessionUtil;

@RestController
@RequestMapping("/offers")
public class OfferController {

	@Resource
	private DemandService demandService;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<DemandModel> getUserDemands() {
		UserModel userModel = (UserModel) SessionUtil.getInstance().session().getAttribute("user");
		if (userModel != null) {
			return this.demandService.getAllDemandsByUser(userModel);
		} else {
			return null;
		}
	}

}
