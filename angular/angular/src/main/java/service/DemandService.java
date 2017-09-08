package service;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import domain.Demand;
import domain.User;
import model.DemandModel;
import model.UserModel;
import repository.DemandDao;

@Service
@Transactional
public class DemandService {

	@Resource
	private DemandDao demandDao;

	@Resource
	private UserService userService;

	public List<DemandModel> getAllDemands() {
		List<DemandModel> demandsModel = new LinkedList<>();

		for (Demand demand : demandDao.getAll()) {
			User user = demand.getUser();
			demandsModel.add(new DemandModel(demand.getId(), demand.getSum(), demand.getFromCurrency(),
					demand.getToCurrency(), new UserModel(user.getId(), user.getUsername()), demand.getDataDemand()));
		}

		return demandsModel;
	}

	public List<DemandModel> getAllDemandsByUser(UserModel userModel) {
		List<DemandModel> demandsModel = new LinkedList<>();

		User user = userService.getUserByUsernameAndPassword(userModel);

		for (Demand demand : user.getDemand()) {
			User userCopy = demand.getUser();

			demandsModel.add(
					new DemandModel(demand.getId(), demand.getSum(), demand.getFromCurrency(), demand.getToCurrency(),
							new UserModel(userCopy.getId(), userCopy.getUsername()), demand.getDataDemand()));
		}

		return demandsModel;
	}

	public void deleteDemand(UserModel userModel, Integer demandId) {
		Demand demand = this.demandDao.findById(demandId);

		if (demand != null) {
			if (demand.getUser().getId() == userModel.getId()) {
				this.demandDao.delete(demandId);
			}
			this.demandDao.delete(demandId);
		}
	}
}
