package controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import model.DemandModel;
import model.UserModel;
import service.DemandService;
import util.SessionUtil;

@RestController
@RequestMapping("/demands")
public class DemandController {

	@Resource
	private DemandService demandService;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<DemandModel> getDemands() {
		UserModel userModel = (UserModel) SessionUtil.getInstance().session().getAttribute("user");
		if (userModel != null) {
			return this.demandService.getAllDemands();
		} else {
			return null;
		}
	}

	@RequestMapping(value = "/userDemands", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<DemandModel> getUserDemands() {
		UserModel userModel = (UserModel) SessionUtil.getInstance().session().getAttribute("user");
		if (userModel != null) {
			return this.demandService.getAllDemandsByUser(userModel);
		} else {
			return null;
		}
	}

	@RequestMapping(value = "/userDemands/{demandId}", method = RequestMethod.DELETE)
	public void deleteTodo(@PathVariable Integer demandId) {
		UserModel userModel = (UserModel) SessionUtil.getInstance().session().getAttribute("user");
		this.demandService.deleteDemand(userModel, demandId);
	}
}
