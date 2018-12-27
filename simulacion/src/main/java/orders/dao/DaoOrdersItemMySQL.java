package orders.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import clases.Order;

@Repository
public class DaoOrdersItemMySQL implements DaoOrdersItem{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean add(Order order) {
		sessionFactory.getCurrentSession().save(order);
		return true;
	}

	
}
