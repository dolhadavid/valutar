package repository;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import domain.Offer;

@Repository
public class OfferDao {

	@Resource
	private SessionFactory factory;

	private Session getSession() {
		return this.factory.getCurrentSession();
	}
}
