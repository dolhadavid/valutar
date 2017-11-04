package repository;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import domain.Transaction;


@Repository
public class TransactionDao {

	@Resource
	private SessionFactory factory;

	private Session getSession() {
		return this.factory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public List<Transaction> getAll() {
		List<Transaction> transaction = this.getSession().createQuery("FROM Demand").list();
		this.getSession().flush();

		return transaction;
	}
}
