package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import clases.Order;
import orders.dao.DaoOrdersItem;

@Service
public class OrderServiceImp implements OrderService{
	
	@Autowired
	private DaoOrdersItem ordersDao;

	@Transactional
	@Override
	public boolean add(Order order) {
		return ordersDao.add(order);
	}

}
