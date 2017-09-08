package repository;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import domain.Demand;
import domain.Todo;

@Repository
public class DemandDao {

	@Resource
	private SessionFactory factory;

	private Session getSession() {
		return this.factory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public List<Demand> getAll() {
		List<Demand> demands = this.getSession().createQuery("FROM Demand").list();
		this.getSession().flush();

		return demands;
	}

	public Demand findById(Integer id) {
		return this.getSession().get(Demand.class, id);
	}

	public void delete(Integer id) {
		Demand demand = this.findById(id);

		if (demand != null) {
			demand.setUser(null);
			this.getSession().delete(demand);
			this.getSession().flush();
		}
	}
}
